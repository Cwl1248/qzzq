package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.dto.AppraiseDTO;
import com.cwl.qzzp.dto.CollectDto;
import com.cwl.qzzp.dto.PositioninfoDTO;
import com.cwl.qzzp.dto.UserinfoDTO;
import com.cwl.qzzp.service.AppraiseService;
import com.cwl.qzzp.service.PositionService;
import com.cwl.qzzp.service.UserService;
import com.cwl.qzzp.util.GetUUIDUtil;
import com.cwl.qzzp.util.JWTUtil;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/10
 * @description：个人信息
 */
@Slf4j
@Controller
@RequestMapping("/myInfo")
public class MyInfoController {

    @Autowired
    UserService userService;

    @Autowired
    PositionService positionService;

    @Autowired
    AppraiseService appraiseService;

    /**
     * 编辑简历
     *
     * @return
     */
    @RequestMapping("/InfoDetail")
    public String getMyInfoData() {
        return "myInfo/myInfo";
    }

    /**
     * 修改简历
     *
     * @return
     */
    @RequestMapping("/toSelect")
    public String toSelect() {
        return "myInfo/updateInfo";
    }

    /**
     * 为我推荐
     *
     * @return
     */
    @RequestMapping("/toRecommend")
    public String toRecommend(@RequestParam String userid, ModelMap modelMap, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                              @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        try {
            if (StringUtils.isNotEmpty(userid)) {
                UserinfoDTO userinfoDTO = userService.selectInfo(userid);
                String city = userinfoDTO.getCity();
                String position = userinfoDTO.getPosition();
                Page<PositioninfoDTO> listData = (Page<PositioninfoDTO>) positionService.getPositionInfoDTO(pageNum, pageSize, position, city);
                modelMap.addAttribute("list", listData);
                modelMap.addAttribute("userid", userid);
                return "myInfo/recommend";
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        return "myInfo/recommend";
    }

    /**
     * 收藏职位
     *
     * @return
     */
    @RequestMapping("/toCollection")
    public String toCollection(@RequestParam String userid, ModelMap modelMap, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                               @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }

        try {
            if (StringUtils.isNotEmpty(userid)) {
                Page<CollectDto> listData = (Page<CollectDto>) positionService.getCollectionPosition(pageNum, pageSize, userid);
                modelMap.addAttribute("list", listData);
                modelMap.addAttribute("userid", userid);
                return "myInfo/collection";
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        return "myInfo/collection";
    }

    /**
     * 投递记录
     *
     * @return
     */
    @RequestMapping("/deliveryRecord")
    public String deliveryRecord(@RequestParam String userid, ModelMap modelMap, @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 4;
        }

        try {
            if (StringUtils.isNotEmpty(userid)) {
                Page<PositioninfoDTO> listData = (Page<PositioninfoDTO>) positionService.deliveryRecord(pageNum, pageSize, userid);
                modelMap.addAttribute("list", listData);
                modelMap.addAttribute("userid", userid);
                return "myInfo/deliveryRecord";
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        return "myInfo/deliveryRecord";
    }

    /**
     * 评价
     *
     * @param appraiseDTO
     * @return
     */
    @PostMapping("/insertAppraise")
    @ResponseBody
    private ResultData insertAppraise(@RequestBody AppraiseDTO appraiseDTO) {
        log.debug("appraiseDTO", appraiseDTO);
        if (StringUtils.isNotEmpty(appraiseDTO.getUserid())&& StringUtils.isNotEmpty(appraiseDTO.getDataid())) {
            appraiseDTO.setItemid(GetUUIDUtil.getUUID());
            try {
                int i = appraiseService.insertAppraise(appraiseDTO);
                if (i != 0) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.FAIL);
                }
            } catch (Exception e) {
                return ResultData.failed(RetCode.FAIL.code, "操作失败", e);
            }
        } else {
            return ResultData.failed(RetCode.FAIL.code, "操作失败");
        }
    }


    @PostMapping("/login")
    @ResponseBody
    public ResultData login(@RequestBody UserinfoDTO user) {
        log.info("", user);
        Map<Object, Object> map = new HashMap<>();

        try {
            if (ObjectUtils.isNotEmpty(user)) {
                UserinfoDTO login = userService.login(user);
                if (ObjectUtils.isNotEmpty(user)) {
                    String token = JWTUtil.getToken(new HashMap<>());
                    map.put("token", token);
                    map.put("Userid", login.getUserid());
                    return ResultData.ok(map);
                } else {
                    return ResultData.failed(RetCode.LOGINFAIL);
                }
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.LOGINFAIL.code, "登录失败", e);
        }
        return ResultData.failed(RetCode.LOGINFAIL);
    }

    @PostMapping("/registered")
    @ResponseBody
    public ResultData registered(@RequestBody UserinfoDTO user) {
        log.info("", user);
        try {
            if (ObjectUtils.isNotEmpty(user)) {
                user.setUserid(GetUUIDUtil.getUUID());
                Integer i = userService.registered(user);
                if (ObjectUtils.isNotEmpty(i)) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.LOGINFAIL);
                }
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.LOGINFAIL.code, "注册失败", e);
        }
        return ResultData.ok();
    }

    @PostMapping("/addinfo")
    @ResponseBody
    public ResultData addinfo(@RequestBody UserinfoDTO user) {
        log.info("", user);
        try {
            if (StringUtils.isNotEmpty(user.getUserid())) {
                Integer i = userService.addinfo(user);
                if (ObjectUtils.isNotEmpty(i)) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.LOGINFAIL);
                }
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.LOGINFAIL.code, "添加失败", e);
        }
        return ResultData.ok();
    }


    @PostMapping("/updataInfo")
    @ResponseBody
    public ResultData updataInfo(@RequestBody UserinfoDTO user) {
        log.info("", user);
        try {
            if (StringUtils.isNotEmpty(user.getUserid())) {
                Integer i = userService.addinfo(user);
                if (ObjectUtils.isNotEmpty(i)) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.FAIL);
                }
            } else {
                return ResultData.failed(RetCode.FAIL);
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.FAIL.code, "修改失败", e);
        }
    }

    @GetMapping("/selectInfo")
    @ResponseBody
    public ResultData selectInfo(String userid) {
        log.info("", userid);
        try {
            if (StringUtils.isNotEmpty(userid)) {
                UserinfoDTO userinfoDTO = userService.selectInfo(userid);
                if (ObjectUtils.isNotEmpty(userinfoDTO)) {
                    return ResultData.ok(userinfoDTO);
                } else {
                    return ResultData.failed(RetCode.FAIL);
                }
            } else {
                return ResultData.failed(RetCode.FAIL);
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.LOGINFAIL.code, "查询失败", e);
        }

    }
}
