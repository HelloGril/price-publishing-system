package com.hywa.pricepublish.dao.mapper;

import com.hywa.pricepublish.dao.entity.PriceCollection;
import com.hywa.pricepublish.dao.entity.Price_collectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceCollectionMapper {
    int countByExample(Price_collectionExample example);

    int deleteByExample(Price_collectionExample example);

    int deleteByPrimaryKey(String id);

    int insert(PriceCollection record);

    int insertSelective(PriceCollection record);

    List<PriceCollection> selectByExample(Price_collectionExample example);

    PriceCollection selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PriceCollection record, @Param("example") Price_collectionExample example);

    int updateByExample(@Param("record") PriceCollection record, @Param("example") Price_collectionExample example);

    int updateByPrimaryKeySelective(PriceCollection record);

    int updateByPrimaryKey(PriceCollection record);

    void insertBatch(List<PriceCollection> priceCollections);
}