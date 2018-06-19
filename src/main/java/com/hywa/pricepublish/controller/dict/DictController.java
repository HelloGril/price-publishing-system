package com.hywa.pricepublish.controller.dict;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.DictRep;
import com.hywa.pricepublish.representation.DictReps;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.DictService;
import com.hywa.pricepublish.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    public DictService dictService;

    @Autowired
    public DictTypeService dictTypeService;

    @GetMapping("/find")
    public ResponseEntity<ResponseBase> findMarketType(@RequestParam String typeCode) {
        String dictTypeId = dictTypeService.findDictTypeIdByCode(typeCode);
        DictReps dictList = dictService.findDictListByDictType(dictTypeId);

        ResponseBase<DictReps> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        repResponseBase.setRetBody(dictList);
        return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<ResponseBase> findNameByCode(@RequestParam String code, @RequestParam String typeId) {
//        String dictTypeId = dictTypeService.findDictTypeIdByCode(ConstantPool.MARKET_TYPE);
//        List<DictRep> dictList = dictService.findDictListByDictType(dictTypeId);
        //TODO
        ResponseBase<List<DictRep>> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
//        repResponseBase.setRetBody(dictList);
        return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
    }
}
