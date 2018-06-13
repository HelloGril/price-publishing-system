package com.hywa.pricepublish.dao.mapper;

import com.hywa.pricepublish.dao.entity.Price_collection;
import com.hywa.pricepublish.dao.entity.Price_collectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Price_collectionMapper {
    int countByExample(Price_collectionExample example);

    int deleteByExample(Price_collectionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Price_collection record);

    int insertSelective(Price_collection record);

    List<Price_collection> selectByExample(Price_collectionExample example);

    Price_collection selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Price_collection record, @Param("example") Price_collectionExample example);

    int updateByExample(@Param("record") Price_collection record, @Param("example") Price_collectionExample example);

    int updateByPrimaryKeySelective(Price_collection record);

    int updateByPrimaryKey(Price_collection record);
}