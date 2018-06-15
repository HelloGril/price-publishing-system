package com.hywa.pricepublish.controller.collect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.CollectionHistoryRep;
import com.hywa.pricepublish.representation.MarketRep;
import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.PriceCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/collect/price")
public class PriceCollectionController {

    @Autowired
    private PriceCollectionService priceCollectionService;

    @RequestMapping("/add")
    public ResponseEntity addPrice(@RequestParam String userId,
                                   @RequestParam Date dateTime,
                                   @RequestParam String marketId,
                                   @RequestParam String marketName,
                                   @RequestBody List<ProductRep> reps) {

        priceCollectionService.save(userId, dateTime, marketId, marketName, reps);
        ResponseBase<PageInfo<MarketRep>> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/findCollectHistory")
    public ResponseEntity<ResponseBase> collectHistory(@RequestParam String userId,
                                                       @RequestParam(defaultValue = "1") Integer pageNum,
                                                       @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CollectionHistoryRep> collectionHistoryReps = priceCollectionService.collectHistory(userId);
        PageInfo<CollectionHistoryRep> pageInfo = new PageInfo<>(collectionHistoryReps);
        ResponseBase<PageInfo<CollectionHistoryRep>> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        repResponseBase.setRetBody(pageInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
