package com.cwl.qzzp.controllor;

import com.cwl.qzzp.common.ResultData;
import com.cwl.qzzp.common.RetCode;
import com.cwl.qzzp.dto.CollectDto;
import com.cwl.qzzp.dto.DeliveryDto;
import com.cwl.qzzp.service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/26
 * @description：收藏与投递
 */
@Slf4j
@Controller
@RequestMapping("/collection")
public class collectionController {


    @Autowired
    CollectionService collectionService;

    @PostMapping("/insertCollection")
    @ResponseBody
    public ResultData insertCollection(@RequestBody CollectDto collectDto) {

        try {
            if (ObjectUtils.isNotEmpty(collectDto)) {
                int i = collectionService.insertCollection(collectDto);
                if (i != 0) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.FAIL);
                }
            } else {
                return ResultData.failed(RetCode.FAIL);
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.FAIL.code, "操作失败", e);
        }
    }

    @PostMapping("/insertDelivery")
    @ResponseBody
    public ResultData insertDelivery(@RequestBody DeliveryDto deliveryDto) {

        try {
            if (ObjectUtils.isNotEmpty(deliveryDto)) {
                int i = collectionService.insertDelivery(deliveryDto);
                if (i != 0) {
                    return ResultData.ok();
                } else {
                    return ResultData.failed(RetCode.FAIL);
                }
            } else {
                return ResultData.failed(RetCode.FAIL);
            }
        } catch (Exception e) {
            return ResultData.failed(RetCode.FAIL.code, "操作失败", e);
        }
    }
}