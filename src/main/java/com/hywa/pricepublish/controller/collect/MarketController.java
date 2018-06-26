package com.hywa.pricepublish.controller.collect;

import com.github.pagehelper.PageInfo;
import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.utils.UUIDUtils;
import com.hywa.pricepublish.representation.MarketRecentUseReps;
import com.hywa.pricepublish.representation.MarketRep;
import com.hywa.pricepublish.representation.MarketReps;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.collect.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collect/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @GetMapping("/findByTypeAndRegionId")
    public ResponseEntity<ResponseBase> findMarketByType(
            @RequestParam String typeId,
            @RequestParam String regionId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        try {
            MarketReps markets = marketService.findMarkets(typeId, regionId, pageNum, pageSize);

            ResponseBase<MarketReps> repResponseBase = new ResponseBase<>();
            repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
            repResponseBase.setRetBody(markets);
            return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseBase repResponseBase = new ResponseBase();
            repResponseBase.setRetHead(ConstantPool.FAILURE, e.getMessage());
            return new ResponseEntity<>(repResponseBase, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseBase> addMarket(@RequestBody MarketRep marketRep,
                                                  @RequestParam String userId) {

        marketService.save(marketRep, userId);
        ResponseBase<PageInfo<MarketRep>> repResponseBase = new ResponseBase<>();
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
    }

    @GetMapping("/findRecentUse")
    public ResponseEntity<ResponseBase> findRecentUse(@RequestParam String userId) {
        ResponseBase<MarketRecentUseReps> repResponseBase = new ResponseBase<>();
        MarketRecentUseReps marketRecentUse = marketService.findMarketRecentUse(userId);
        repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
        repResponseBase.setRetBody(marketRecentUse);
        return new ResponseEntity<>(repResponseBase, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}