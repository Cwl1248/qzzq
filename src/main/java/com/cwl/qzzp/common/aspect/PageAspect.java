package com.cwl.qzzp.common.aspect;

import com.cwl.qzzp.common.PagingDTO;
import com.cwl.qzzp.common.PagingParam;
import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.annotation.Page;
import com.cwl.qzzp.util.NumberUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Slf4j
@Component
public class PageAspect {
    @Pointcut("@annotation(com.cwl.qzzp.common.annotation.Page)")
    private void pageAspect() {
        log.debug("注册分页切面.");
    }

    @Around("pageAspect()")
    private ResultData around(ProceedingJoinPoint point) throws Throwable {
        try {
            String methodName = point.getSignature().getName();
            Method method = getCurrMethod(methodName, point.getTarget());
            Page page = method.getAnnotation(Page.class);
            boolean export = page.export();
            PagingParam paParam = null;
            for (Object param : point.getArgs()) {
                if (param instanceof PagingParam) {
                    paParam = (PagingParam) param;
                }
            }
            if (paParam != null) {
                prePageParam(paParam, export);
            }
            ResultData result = (ResultData) point.proceed();
            if (result.getData() instanceof List) {
                if (!page.rawData()) {
                    if (page.codePage()) {
                        result.setData(prePageResultByCode((List) result.getData(), paParam));
                    } else {
                        result.setData(prePageResult((List) result.getData()));
                    }
                }
            }
            return result;
        } finally {
            //清理当前进程（子线程）的分页功能
            clearPageHelper();
        }
    }

    /**
     * 分页参数前置处理逻辑
     *
     * @param param  参数
     * @param export 需要导出(true 表示取Integer最大值,false表示只做当前页数量)
     * @param <T>    参数类型
     */
    public <T extends PagingParam> void prePageParam(T param, boolean export) {
        if (export) {
            PageHelper.startPage(1, Integer.MAX_VALUE - 1);
        } else {
            PageHelper.startPage(param.getPage(), param.getRows());
        }
        if (param.getSord() != null && !"".equals(param.getSord())) {
            PageHelper.orderBy(param.getSidx() + " " + param.getSord());
        }
    }

    /**
     * 清理当前进程（子线程）的分页功能
     * 当当前子线程中配置了分页，但又未调用sql查询，将会让分页功能顺延到下一次接口获取该进程名
     * 并进行sql查询时，使该次查询sql会添加分页的limit 或order等逻辑，导致sql异常
     */
    public void clearPageHelper() {
        PageHelper.clearPage();
    }

    /**
     * 分页结果前置处理逻辑
     *
     * @param result 数据
     * @param <T>    数据类型
     * @return 分页数据
     */
    public <T> PagingDTO<T> prePageResult(List<T> result) {
        PageInfo<T> page = new PageInfo(result);
        PagingDTO<T> pagingDTO = new PagingDTO<>();
        pagingDTO.setPage(page.getPageNum());
        pagingDTO.setTotal(page.getPages());
        pagingDTO.setRecords(page.getTotal());
        pagingDTO.setRows(page.getList());
        return pagingDTO;
    }

    /**
     * 准备当前方法实例
     *
     * @param methodName 方法名
     * @param service    对象
     * @return 方法实例
     */
    private Method getCurrMethod(String methodName, Object service) {
        Method currM = null;
        for (Method m : service.getClass().getMethods()) {
            if (m.getName().equals(methodName)) {
                currM = m;
                break;
            }
        }
        return currM;
    }

    /**
     * 分页结果前置处理逻辑 代码分页
     *
     * @param result    数据
     * @param pageParam 继承PagingParam的类对象
     * @param <T>       数据类型
     * @param <K>       分类参数泛型
     * @return 分页数据
     */
    public <T, K> PagingDTO<T> prePageResultByCode(List<T> result, K pageParam) {
        com.github.pagehelper.Page<T> page = new com.github.pagehelper.Page<T>();
        List<T> list = new ArrayList<>();
        //总数据数
        page.setTotal(result.size());

        PagingParam pagingParam = (PagingParam) pageParam;
        //每页数量
        page.setPageNum(pagingParam.getRows());
        //计算总页数
        page.setPages(NumberUtil.getTotalPageNum(pagingParam.getRows(), result.size()));
        //代码分页，根据每页数量和当前页码
        list = pageFromList(result, pagingParam.getPage(), pagingParam.getRows());
        page.addAll(list);
        PagingDTO<T> pagingDTO = new PagingDTO<>();
        pagingDTO.setPage(page.getPageNum());
        pagingDTO.setTotal(page.getPages());
        pagingDTO.setRecords(page.getTotal());
        pagingDTO.setRows(page.getResult());
        return pagingDTO;
    }

    /**
     * 根据当前页数和每页数量进行代码分页
     *
     * @param list    需要分页的集合
     * @param pageNum 当前页数
     * @param limit   每页数量
     * @param <T>     数据类型
     * @return 分页
     */
    public <T> List<T> pageFromList(List<T> list, int pageNum, int limit) {
        List<T> result = new ArrayList<>();
        try {
            //获取总页数
            int totalPage = NumberUtil.getTotalPageNum(limit, list.size());

            int size = list.size();
            //当前第2页，每页10笔，则需要从第11笔开始 下标算法：(2-1)*10=10 第一页是0-9
            int startNumIndex = (pageNum - 1) * limit;
            //当前第2页，每页10笔,则需要在第20笔结束 下标算法：2*10-1=19 第二页是10-19
            int endNumIndex = startNumIndex;
            int endNum = pageNum * limit;

            if (endNum > size) {
                //判断当前页是否为最后一页，根据实际数据量判断，而不是传入的总页数
                endNumIndex = size - 1;
            } else {
                endNumIndex = pageNum * limit - 1;
            }
            if (pageNum > totalPage) {
                //大于总页数时
                return new ArrayList<>();
            } else if (pageNum < 1 || totalPage < 1) {
                //页数应该大于1
                return new ArrayList<>();
            } else if (size < (startNumIndex + 1)) {
                //开始下表为10时，数据量至少需要11个
                return new ArrayList<>();
            } else {
                for (int i = startNumIndex; i <= endNumIndex; i++) {
                    result.add(list.get(i));
                }
            }
            return result;
        } catch (Exception e) {
            return list;
        }
    }
}
