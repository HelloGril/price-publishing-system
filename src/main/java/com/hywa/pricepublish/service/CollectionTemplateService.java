package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.CollectionTemplateRep;
import com.hywa.pricepublish.representation.CollectionTemplateReps;

import java.util.List;

public interface CollectionTemplateService {
    CollectionTemplateReps findByUserId(String userId, Integer pageNum, Integer pageSize);

    void save(CollectionTemplateRep templateRep, String userId);

    CollectionTemplateRep findByTemplateId(String templateId);
}
