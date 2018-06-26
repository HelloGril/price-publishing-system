package com.hywa.pricepublish.representation;

import com.hywa.pricepublish.common.utils.DateUtils;
import com.hywa.pricepublish.dao.entity.CollectionTemplate;

import java.util.List;
import java.util.Objects;

public class CollectionTemplateRep {
    private String templateId;
    private String templateName;
    private String updateTime;
    private List<ProductRep> productReps;

    public CollectionTemplateRep() {
    }

    public CollectionTemplateRep(CollectionTemplate collectionTemplate) {
        this.setTemplateId(collectionTemplate.getId());
        this.setTemplateName(collectionTemplate.getName());
        this.setUpdateTime(DateUtils.formatDate(collectionTemplate.getUpdateTime(), DateUtils.DETAIL));
    }

    public CollectionTemplateRep(String templateId, String templateName, String updateTime) {
        this.setTemplateId(templateId);
        this.setTemplateName(templateName);
        this.setUpdateTime(updateTime);
    }

    public List<ProductRep> getProductReps() {
        return productReps;
    }

    public void setProductReps(List<ProductRep> productReps) {
        this.productReps = productReps;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionTemplateRep that = (CollectionTemplateRep) o;
        return Objects.equals(templateId, that.templateId) &&
                Objects.equals(templateName, that.templateName) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(templateId, templateName, updateTime);
    }

    @Override
    public String toString() {
        return "CollectionTemplateRep{" +
                "templateId='" + templateId + '\'' +
                ", templateName='" + templateName + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
