package com.init.crud.dao;

import com.init.crud.bean.RecordForMark;
import com.init.crud.bean.RecordForMarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordForMarkMapper {
    long countByExample(RecordForMarkExample example);

    int deleteByExample(RecordForMarkExample example);

    int deleteByPrimaryKey(Integer rfmId);

    int insert(RecordForMark record);

    int insertSelective(RecordForMark record);

    List<RecordForMark> selectByExample(RecordForMarkExample example);

    RecordForMark selectByPrimaryKey(Integer rfmId);

    int updateByExampleSelective(@Param("record") RecordForMark record, @Param("example") RecordForMarkExample example);

    int updateByExample(@Param("record") RecordForMark record, @Param("example") RecordForMarkExample example);

    int updateByPrimaryKeySelective(RecordForMark record);

    int updateByPrimaryKey(RecordForMark record);
}