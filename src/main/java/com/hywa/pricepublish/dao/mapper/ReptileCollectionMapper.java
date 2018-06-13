package com.hywa.pricepublish.dao.mapper;

import com.hywa.pricepublish.dao.entity.ReptileCollection;
import com.hywa.pricepublish.dao.entity.ReptileCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReptileCollectionMapper {
    int countByExample(ReptileCollectionExample example);

    int deleteByExample(ReptileCollectionExample example);

    int deleteByPrimaryKey(String id);

    int insert(ReptileCollection record);

    int insertSelective(ReptileCollection record);

    List<ReptileCollection> selectByExample(ReptileCollectionExample example);

    ReptileCollection selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ReptileCollection record, @Param("example") ReptileCollectionExample example);

    int updateByExample(@Param("record") ReptileCollection record, @Param("example") ReptileCollectionExample example);

    int updateByPrimaryKeySelective(ReptileCollection record);

    int updateByPrimaryKey(ReptileCollection record);
}