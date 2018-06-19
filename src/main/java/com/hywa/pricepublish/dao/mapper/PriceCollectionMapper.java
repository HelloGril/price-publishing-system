package com.hywa.pricepublish.dao.mapper;

import com.hywa.pricepublish.dao.entity.PriceCollection;
import com.hywa.pricepublish.dao.entity.PriceCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceCollectionMapper {
    int countByExample(PriceCollectionExample example);

    int deleteByExample(PriceCollectionExample example);

    int deleteByPrimaryKey(String id);

    int insert(PriceCollection record);

    int insertSelective(PriceCollection record);

    List<PriceCollection> selectByExample(PriceCollectionExample example);

    PriceCollection selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PriceCollection record, @Param("example") PriceCollectionExample example);

    int updateByExample(@Param("record") PriceCollection record, @Param("example") PriceCollectionExample example);

    int updateByPrimaryKeySelective(PriceCollection record);

    int updateByPrimaryKey(PriceCollection record);

    void insertBatch(List<PriceCollection> priceCollections);
}