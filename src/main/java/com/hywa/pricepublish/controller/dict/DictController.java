package com.hywa.pricepublish.controller.dict;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.DictReps;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.dict.DictService;
import com.hywa.pricepublish.service.dict.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    public DictService dictService;

    @Autowired
    public DictTypeService dictTypeService;

    @GetMapping()
    public ResponseEntity<ResponseBase> findMarketType(@RequestParam("type") String type) {
        String dictTypeId = dictTypeService.findDictTypeIdByCode(type);
        DictReps dictList = dictService.findDictListByDictType(dictTypeId);

        ResponseBase<DictReps> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        repResponseBase.setRetBody(dictList);
        return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
    }

    @GetMapping("/findList")
    public ResponseEntity<ResponseBase> findNameByCode(@RequestParam String id) {
        DictReps dictList = dictService.findDictListByDictType(id);

        ResponseBase<DictReps> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        repResponseBase.setRetBody(dictList);
        return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
    }
}
