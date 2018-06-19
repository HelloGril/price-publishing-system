package com.hywa.pricepublish.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.UUIDUtils;
import com.hywa.pricepublish.dao.entity.CollectionTemplate;
import com.hywa.pricepublish.dao.entity.CollectionTemplateExample;
import com.hywa.pricepublish.dao.entity.CollectionTemplateExample.Criteria;
import com.hywa.pricepublish.dao.entity.Product;
import com.hywa.pricepublish.dao.entity.TemplateProduct;
import com.hywa.pricepublish.dao.mapper.CollectionTemplateMapper;
import com.hywa.pricepublish.dao.mapper.TemplateProductMapper;
import com.hywa.pricepublish.representation.CollectionTemplateRep;
import com.hywa.pricepublish.representation.CollectionTemplateReps;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.service.CollectionTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CollectionTemplateServiceImpl implements CollectionTemplateService {

    @Autowired
    private CollectionTemplateMapper collectionTemplateMapper;

    @Autowired
    private TemplateProductMapper templateProductMapper;

    @Override
    public CollectionTemplateRep findByTemplateId(String templateId) {
        List<Product> products = templateProductMapper.selectProductByTemplateId(templateId);
        CollectionTemplateExample example = new CollectionTemplateExample();
        example.createCriteria()
                .andIdEqualTo(templateId)
                .andIsDelEqualTo(ConstantPool.NOT_DEL);
        CollectionTemplate collectionTemplate = collectionTemplateMapper.selectByExample(example).get(0);

        CollectionTemplateRep collectionTemplateRep = new CollectionTemplateRep(collectionTemplate);
        List<ProductRep> productReps = new ArrayList<>();
        products.forEach(product -> {
            ProductRep productRep = new ProductRep(product);
            productReps.add(productRep);
        });
        collectionTemplateRep.setProductReps(productReps);

        return collectionTemplateRep;
    }

    @Override
    public CollectionTemplateReps findByUserId(String userId, Integer pageNum, Integer pageSize) {
        CollectionTemplateExample example = new CollectionTemplateExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(ConstantPool.NOT_DEL);
        criteria.andCreateUserEqualTo(userId);
        Page<CollectionTemplate> page = PageHelper.startPage(pageNum, pageSize, true);
        long total = page.getTotal();
        List<CollectionTemplate> collectionTemplates = collectionTemplateMapper.selectByExample(example);
//TODO 分页
        List<CollectionTemplateRep> collectionTemplateRepList = new ArrayList<>();
        collectionTemplates.forEach(collectionTemplate -> {
            CollectionTemplateRep collectionTemplateRep = new CollectionTemplateRep(collectionTemplate);
            collectionTemplateRepList.add(collectionTemplateRep);
        });
        return new CollectionTemplateReps(collectionTemplateRepList);
    }

    @Override
    @Transactional
    public void save(CollectionTemplateRep templateRep, String userId) {
        String templateId = UUIDUtils.randomUUID();

        CollectionTemplate collectionTemplate = new CollectionTemplate();
        collectionTemplate.setCreateTime(new Date());
        collectionTemplate.setUpdateTime(new Date());
        collectionTemplate.setCreateUser(userId);
        collectionTemplate.setId(templateId);
        collectionTemplate.setIsDel(ConstantPool.NOT_DEL);
        collectionTemplate.setName(templateRep.getTemplateName());
        collectionTemplateMapper.insert(collectionTemplate);

        templateRep.getProductReps().forEach(productRep -> {
            TemplateProduct templateProduct = new TemplateProduct();
            templateProduct.setId(UUIDUtils.randomUUID());
            templateProduct.setProductId(productRep.getProductId());
            templateProduct.setTemplateId(templateId);
            templateProductMapper.insert(templateProduct);
        });
    }
}
