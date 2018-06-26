package com.hywa.pricepublish.controller.collect;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.CollectionTemplateRep;
import com.hywa.pricepublish.representation.CollectionTemplateReps;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.collect.CollectionTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collect/template")
public class CollectionTemplateController {

    @Autowired
    private CollectionTemplateService collectionTemplateService;

    @PostMapping("/add")
    public ResponseEntity<ResponseBase> createTemplate(@RequestBody CollectionTemplateRep templateRep,
                                                       @RequestParam String userId) {
        collectionTemplateService.save(templateRep, userId);

        ResponseBase responseBase = new ResponseBase();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @GetMapping("/findList")
    public ResponseEntity<ResponseBase> findTemplates(@RequestParam String userId,
                                                      @RequestParam(defaultValue = "1") Integer pageNum,
                                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        CollectionTemplateReps templateReps = collectionTemplateService.findByUserId(userId, pageNum, pageSize);

        ResponseBase<CollectionTemplateReps> responseBase = new ResponseBase<>();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        responseBase.setRetBody(templateReps);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<ResponseBase> createTemplates(@RequestParam String templateId) {
        CollectionTemplateRep templateReps = collectionTemplateService.findByTemplateId(templateId);

        ResponseBase<CollectionTemplateRep> responseBase = new ResponseBase<>();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        responseBase.setRetBody(templateReps);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseBase> updateTemplate(@RequestBody CollectionTemplateRep templateRep) {
        try {
            collectionTemplateService.update(templateRep);
            ResponseBase responseBase = new ResponseBase();
            responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
            return new ResponseEntity<>(responseBase, HttpStatus.OK);
        } catch (Exception e) {
            ResponseBase responseBase = new ResponseBase();
            responseBase.setRetHead(ConstantPool.FAILURE, "更新失败" + e.getMessage());
            return new ResponseEntity<>(responseBase, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
