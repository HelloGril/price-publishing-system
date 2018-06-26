package com.hywa.pricepublish.service.collect.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywa.pricepublish.dao.entity.Product;
import com.hywa.pricepublish.dao.entity.ProductExample;
import com.hywa.pricepublish.dao.entity.ProductRecentUse;
import com.hywa.pricepublish.dao.entity.ProductRecentUseExample;
import com.hywa.pricepublish.dao.mapper.ProductMapper;
import com.hywa.pricepublish.dao.mapper.ProductRecentUseMapper;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.representation.ProductReps;
import com.hywa.pricepublish.service.collect.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRecentUseMapper productRecentUseMapper;

    @Override
    public void save(ProductRep productRep) {
        Product product = new Product();
        //TODO
        productMapper.insert(product);
    }

    @Override
    public ProductReps findByType(String typeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Product> products = productMapper.findByType(typeId);
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        List<ProductRep> productReps = new ArrayList<>();
        products.forEach(product -> {
            ProductRep productRep = new ProductRep(product);
            productReps.add(productRep);
        });
        return new ProductReps(productReps, pageInfo.getTotal());
    }

    @Override
    public ProductReps findRecentUse(String userId) {
        ProductRecentUseExample example = new ProductRecentUseExample();
        example.createCriteria()
                .andUserIdEqualTo(userId);
        List<ProductRecentUse> productRecentUses = productRecentUseMapper.selectByExample(example);
        if (productRecentUses.size() == 0) {
            return null;
        } else {
            List<ProductRep> productReps = new ArrayList<>();
            productRecentUses.forEach(productRecentUse -> {
                Product product = productMapper.findById(productRecentUse.getProductId());
                productReps.add(new ProductRep(product));
            });
            return new ProductReps(productReps);
        }
    }

}
