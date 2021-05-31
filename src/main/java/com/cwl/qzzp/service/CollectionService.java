package com.cwl.qzzp.service;

import com.cwl.qzzp.dao.CollectMapper;
import com.cwl.qzzp.dao.DeliveryMapper;
import com.cwl.qzzp.dto.CollectDto;
import com.cwl.qzzp.dto.DeliveryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/26
 * @description：TODO
 */
@Service("collectionService")
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {Exception.class})
public class CollectionService {

    @Autowired
    CollectMapper collectMapper;

    @Autowired
    DeliveryMapper deliveryMapper;

    public int insertCollection(CollectDto collectDto) {
        return collectMapper.insertSelective(collectDto);
    }


    public int insertDelivery(DeliveryDto deliveryDto) {
        return deliveryMapper.insertSelective(deliveryDto);
    }

    public List<DeliveryDto> getPostion(String id) {
        return deliveryMapper.selectDeliveryDto(id);
    }
}
