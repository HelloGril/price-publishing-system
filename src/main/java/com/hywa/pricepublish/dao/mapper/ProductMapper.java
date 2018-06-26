package com.hywa.pricepublish.dao.mapper;

import com.hywa.pricepublish.common.utils.HttpUtils;
import com.hywa.pricepublish.dao.entity.Product;
import com.hywa.pricepublish.dao.entity.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Product selectNameAndUnitById(String id);

    List<Product> findByType(String typeId);

    Product findById(String productId);
}