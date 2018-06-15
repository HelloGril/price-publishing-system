package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.CollectionTemplateRep;

import java.util.List;

public interface CollectionTemplateService {
    List<CollectionTemplateRep> findByUserId(String userId);

    void save(CollectionTemplateRep templateRep, String userId);

    CollectionTemplateRep findByTemplateId(String templateId);
}
