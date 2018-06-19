package com.hywa.pricepublish.controller.collect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.representation.MarketRep;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collect/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @GetMapping("/findByCodeAndRegionId")
    public ResponseEntity<ResponseBase> findMarketByType(
            @RequestParam String type,
            @RequestParam String regionId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        try {
            PageHelper.startPage(pageNum, pageSize);
            List<MarketRep> markets = marketService.findMarkets(type, regionId);
            PageInfo<MarketRep> templateRepPageInfo = new PageInfo<>(markets);
            ResponseBase<PageInfo<MarketRep>> repResponseBase = new ResponseBase<>();
            repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
            repResponseBase.setRetBody(templateRepPageInfo);
            return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseBase<PageInfo<MarketRep>> repResponseBase = new ResponseBase<>();
            repResponseBase.setRetHead(ConstantPool.FAILURE, e.getMessage());
            return new ResponseEntity<>(repResponseBase, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseBase> addMarket(@RequestBody MarketRep marketRep,
                                                  @RequestParam String userId) {
        //TODO 市场中增加地址信息
        try {
            marketService.save(marketRep, userId);
            ResponseBase<PageInfo<MarketRep>> repResponseBase = new ResponseBase<>();
            repResponseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
            return new ResponseEntity<>(repResponseBase, HttpStatus.OK);
        } catch (Exception e) {
            ResponseBase<PageInfo<MarketRep>> repResponseBase = new ResponseBase<>();
            repResponseBase.setRetHead(ConstantPool.FAILURE, e.getMessage());
            return new ResponseEntity<>(repResponseBase, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}