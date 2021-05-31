package com.cwl.qzzp.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/31
 * @description：投递和投递者
 */
@Data
public class PositionAndDelivery {
    List<UserinfoDTO> userinfo;

    List<DeliveryDto> delivery;
}
