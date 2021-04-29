package com.cwl.qzzp.service;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.dao.PositioninfoDao;
import com.cwl.qzzp.dto.PositioninfoDTO;
import lombok.extern.slf4j.Slf4j;
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


    public ResultData postingPositionInfoData(PositioninfoDTO position) {
        log.info("即将发布的职位信息：{}", position);
        String pId = getUUID();
        position.setPid(pId);
        position.setStates("发布");
        position.setVisitnum(1);
        position.setDataid("f3c4ccf9-8e17-4f3e-920d-2507e42d01b2");
        position.setReid("a30f7eaa-00e2-4260-b884-9ec2a95bf191");
        int i = positioninfodao.insertSelective(position);
        if (i != 0) {
            return ResultData.ok();
        } else {
            return ResultData.failed(RetCode.FAIL);
        }
    }

    public ResultData<List<PositioninfoDTO>> getAllPosition() {
        List<PositioninfoDTO> positions = positioninfodao.getAllPosition("a30f7eaa-00e2-4260-b884-9ec2a95bf191");
        if (positions.size() > 0) {
            return ResultData.ok(positions);
        } else {
            return ResultData.failed(RetCode.RELOAD.code, "'加载职位表数据失败'");
        }

    }
}