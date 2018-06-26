package com.hywa.pricepublish.controller.collect;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.representation.ProductReps;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.collect.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collect/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/findByType")
    public ResponseEntity<ResponseBase> find(@RequestParam String typeId,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        ProductReps productReps = productService.findByType(typeId, pageNum, pageSize);
        ResponseBase<ProductReps> responseBase = new ResponseBase<>();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        responseBase.setRetBody(productReps);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseBase> save(@RequestBody ProductRep productRep) {
        productService.save(productRep);
        ResponseBase responseBase = new ResponseBase<>();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @GetMapping("/findRecent")
    public ResponseEntity<ResponseBase> findRecent(@RequestParam String userId) {
        ProductReps recentUse = productService.findRecentUse(userId);
        ResponseBase<ProductReps> responseBase = new ResponseBase<>();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        responseBase.setRetBody(recentUse);
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }
}
