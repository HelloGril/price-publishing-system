package com.hywa.pricepublish.controller.collect;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.CollectionHistoryReps;
import com.hywa.pricepublish.representation.PriceCollectionReps;
import com.hywa.pricepublish.representation.ProductReps;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.collect.CollectionHistoryService;
import com.hywa.pricepublish.service.collect.PriceCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collect/price")
public class PriceCollectionController {

    @Autowired
    private PriceCollectionService priceCollectionService;
    @Autowired
    private CollectionHistoryService collectionHistoryService;

    @PostMapping("/add")
    public ResponseEntity<ResponseBase> addPrice(@RequestParam String userId,
                                                 @RequestParam String dateTime,
                                                 @RequestParam String marketId,
                                                 @RequestParam String marketName,
                                                 @RequestBody ProductReps reps) {

        priceCollectionService.save(userId, dateTime, marketId, marketName, reps.getList());
        ResponseBase repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
    }

    @GetMapping("/findCollectHistory")
    public ResponseEntity<ResponseBase> collectHistory(@RequestParam String userId,
                                                       @RequestParam(defaultValue = "1") Integer pageNum,
                                                       @RequestParam(defaultValue = "10") Integer pageSize) {
        CollectionHistoryReps collectionHistoryReps = collectionHistoryService.collectHistory(userId, pageNum, pageSize);
        ResponseBase<CollectionHistoryReps> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        repResponseBase.setRetBody(collectionHistoryReps);
        return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
    }

    @GetMapping("/findCollectInfo")
    public ResponseEntity<ResponseBase> findCollect(@RequestParam String collectHistoryId) {
        PriceCollectionReps priceCollectionReps = priceCollectionService.findCollect(collectHistoryId);
        ResponseBase<PriceCollectionReps> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        repResponseBase.setRetBody(priceCollectionReps);
        return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseBase> findCollect(@RequestBody PriceCollectionReps priceCollectionReps) {
        try {
            priceCollectionService.updateCollect(priceCollectionReps);
            ResponseBase<PriceCollectionReps> repResponseBase = new ResponseBase<>();
            repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
            return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
        } catch (Exception e) {
            ResponseBase<PriceCollectionReps> repResponseBase = new ResponseBase<>();
            repResponseBase.setRetHead(ConstantPool.FAILURE, "更新失败：" + e.getMessage());
            return new ResponseEntity<>(repResponseBase, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
