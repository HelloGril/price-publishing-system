package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.dao.entity.Product;
import com.hywa.pricepublish.dao.entity.ProductExample;
import com.hywa.pricepublish.dao.mapper.ProductMapper;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.service.ProductService;
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

    @Override
    public void save(ProductRep productRep) {
        Product product = new Product();
        //TODO
        productMapper.insert(product);
    }

    @Override
    public List<ProductRep> findByType(String typeId) {
        ProductExample example = new ProductExample();
        example.createCriteria()
                .andProductTypeIdEqualTo(typeId)
                .andIsDelEqualTo(ConstantPool.NOT_DEL);
        List<Product> products = productMapper.selectByExample(example);

        List<ProductRep> productReps = new ArrayList<>();
        products.forEach(product -> {
            ProductRep productRep = new ProductRep(product);
            productReps.add(productRep);
        });
        return productReps;
    }
}
