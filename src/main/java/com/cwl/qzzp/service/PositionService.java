package com.cwl.qzzp.service;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.common.annotation.Page;
import com.cwl.qzzp.dao.CollectMapper;
import com.cwl.qzzp.dao.PositioninfoDao;
import com.cwl.qzzp.dto.CollectDto;
import com.cwl.qzzp.dto.EnterpriseinfoDTO;
import com.cwl.qzzp.dto.PositioninfoDTO;
import com.cwl.qzzp.dto.RecruiterinforDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.cwl.qzzp.util.GetUUIDUtil.getUUID;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/4/27
 * @description：TODO
 */
@Service("positionService")
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
public class PositionService {

    @Autowired
    private PositioninfoDao positioninfodao;

    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    RecruiterinforService recruiterinforService;


    public ResultData postingPositionInfoData(PositioninfoDTO position, RecruiterinforDTO recruiterinforDTO) {
        log.info("即将发布的职位信息：{}", position);
        RecruiterinforDTO loginUser = recruiterinforService.getLoginUser(recruiterinforDTO);
        if (StringUtils.isNotEmpty(loginUser.getItemid()) && StringUtils.isNotEmpty(loginUser.getDataid())) {
            position.setDataid(loginUser.getDataid());
            position.setReid(loginUser.getItemid());
        } else {
            return ResultData.failed(RetCode.FAIL);
        }
        String pId = getUUID();
        position.setPid(pId);
        position.setStates("发布");
        position.setVisitnum(1);
        int i = positioninfodao.insertSelective(position);
        if (i != 0) {
            return ResultData.ok();
        } else {
            return ResultData.failed(RetCode.FAIL);
        }
    }

    @Page
    public ResultData getAllPosition(String id) {
        List<PositioninfoDTO> positions = positioninfodao.getAllPosition(id);
        if (positions.size() > 0) {
            return ResultData.ok(positions);
        } else {
            return ResultData.failed(RetCode.RELOAD.code, "'加载职位表数据失败'");
        }

    }

    public ResultData upDataPositionInfoData(PositioninfoDTO position) {
        log.info("需要修改职位信息：{}", position);
        int i = positioninfodao.updateByPrimaryKeySelective(position);
        if (i != 0) {
            return ResultData.ok();
        } else {
            return ResultData.failed(RetCode.FAIL);
        }
    }

    public List<PositioninfoDTO> getIndexPosition(String title) {
        List<PositioninfoDTO> list = positioninfodao.getIndexPosition(title);
        for (PositioninfoDTO positioninfoDTO : list) {
            EnterpriseinfoDTO enterpriseinfoDTO = positioninfoDTO.getEnterpriseinfoDTO();
            String logoimage = enterpriseinfoDTO.getLogoimage();
            enterpriseinfoDTO.setLogoimage(StringUtils.substring(logoimage, 16));
            positioninfoDTO.setEnterpriseinfoDTO(enterpriseinfoDTO);
        }
        return list;
    }

    public PositioninfoDTO getPositionInfoData(String pid) {
        positioninfodao.updateVisitNum(pid);
        return positioninfodao.getPositionInfoData(pid);
    }

    public List<PositioninfoDTO> getPositionData(int pageNum, int pageSize,
                                                 String title,
                                                 String place,
                                                 String experience,
                                                 String education,
                                                 String salary,
                                                 String postNature   ) {
        List<PositioninfoDTO> positionData = positioninfodao.getPositionData(pageNum, pageSize,
                                                                                title,
                                                                                place,
                                                                                experience,
                                                                                education,
                                                                                salary,
                                                                                postNature);
        for (PositioninfoDTO positioninfoDTO : positionData) {
            EnterpriseinfoDTO enterpriseinfoDTO = positioninfoDTO.getEnterpriseinfoDTO();
            String logoimage = enterpriseinfoDTO.getLogoimage();
            enterpriseinfoDTO.setLogoimage(StringUtils.substring(logoimage, 16));
            positioninfoDTO.setEnterpriseinfoDTO(enterpriseinfoDTO);
        }
        return positionData;
    }

    public List<PositioninfoDTO> getPositionInfoDTO(Integer pageNum, Integer pageSize, String position, String city) {
        return positioninfodao.getPositionInfoDTO(pageNum, pageSize, position, city);
    }

    public List<CollectDto> getCollectionPosition(int pageNum, int pageSize, String userid) {
        return collectMapper.getCollectionPosition(pageNum, pageSize, userid);
    }

    public List<PositioninfoDTO> deliveryRecord(Integer pageNum, Integer pageSize, String userid) {

        return positioninfodao.deliveryRecord(pageNum, pageSize, userid);
    }

    public PositioninfoDTO getPostion(String id) {

        return positioninfodao.getPostion(id);
    }
}
