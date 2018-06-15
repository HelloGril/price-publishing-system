package com.hywa.pricepublish.controller.collect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collect/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/findByType")
    public ResponseEntity<ResponseBase> find(@RequestParam String typeId,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductRep> productReps = productService.findByType(typeId);
        PageInfo<ProductRep> repPageInfo = new PageInfo<>(productReps);
        ResponseBase<PageInfo<ProductRep>> responseBase = new ResponseBase<>();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        responseBase.setRetBody(repPageInfo);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseBase> save(@RequestBody ProductRep productRep) {
        productService.save(productRep);
        ResponseBase<List<ProductRep>> responseBase = new ResponseBase<>();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }
}
