package com.cwl.qzzp.dao;

import com.cwl.qzzp.dto.PositioninfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositioninfoDao {

    int deleteByPrimaryKey(String pid);

    int insert(PositioninfoDTO record);

    int insertSelective(PositioninfoDTO record);

    PositioninfoDTO selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(PositioninfoDTO record);

    int updateByPrimaryKey(PositioninfoDTO record);

    int updateVisitNum(String pid);

    List<PositioninfoDTO> getAllPosition(String reid);

    List<PositioninfoDTO> getIndexPosition(String title);

    PositioninfoDTO getPositionInfoData(String pid);

    List<PositioninfoDTO> getPositionData(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,String title);

    List<PositioninfoDTO> getPositionInfoDTO(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize, String position, String city);

    List<PositioninfoDTO> deliveryRecord(@Param("pageNum") int pageNum, @Param("pageSize")  int pageSize, String userid);

    PositioninfoDTO getPostion(String id);
}