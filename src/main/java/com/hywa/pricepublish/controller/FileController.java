package com.hywa.pricepublish.controller;

import com.hywa.pricepublish.common.ConstantPool;
import com.hywa.pricepublish.common.enums.CommonEnum;
import com.hywa.pricepublish.common.utils.ExcelUtils;
import com.hywa.pricepublish.common.utils.FileUtils;
import com.hywa.pricepublish.config.ManyEnvProperties;
import com.hywa.pricepublish.dao.entity.PriceCrawlerData;
import com.hywa.pricepublish.representation.ResponseBase;
import com.hywa.pricepublish.service.crawler.PriceCrawlerDataService;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FileController {
    @Autowired
    private PriceCrawlerDataService priceCrawlerDataService;

    @Autowired
    private ManyEnvProperties envProperties;

    @RequestMapping(value = "/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file) {
        CommonEnum upload = FileUtils.upload(file, envProperties.getFILE_PATH());
        ResponseBase responseBase = new ResponseBase();
        responseBase.setRetHead(upload.getIndex().toString(), upload.getValue());
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    @RequestMapping("/download")
    public ResponseEntity downloadFile(@RequestParam String fileName, HttpServletResponse response) {
        FileUtils.downloadFile(envProperties.getFILE_PATH(), fileName, response);
        ResponseBase responseBase = new ResponseBase();
        responseBase.setRetHead(ConstantPool.SUCCESS_CODE, "成功");
        return new ResponseEntity<>(responseBase, HttpStatus.OK);
    }

    //多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    public ResponseEntity handleFileUpload(HttpServletRequest request) {
        try {
            String msg = FileUtils.handleFileUpload(request);
            ResponseBase responseBase = new ResponseBase();
            responseBase.setRetHead(ConstantPool.SUCCESS_CODE, msg);
            return new ResponseEntity<>(responseBase, HttpStatus.OK);
        } catch (FileUploadException e) {
            ResponseBase responseBase = new ResponseBase();
            responseBase.setRetHead(ConstantPool.FAILURE, e.getMessage());
            return new ResponseEntity<>(responseBase, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "crawlerData/getExcel")
    public ResponseEntity getExcel(HttpServletResponse response) {
        try {
            String tableName = "价格爬虫数据";
            List<PriceCrawlerData> list = priceCrawlerDataService.findALL();
            LinkedHashMap<String, String> filedNames = new LinkedHashMap<>();
            filedNames.put("name", "商品名称");
            filedNames.put("price", "价格");
            filedNames.put("priceUnit", "商品单位");
            filedNames.put("maket", "市场名称");
            filedNames.put("region", "区域");
            filedNames.put("updateTime", "采集时间");
            filedNames.put("dataOrigion", "数据来源");
            ExcelUtils.exportExcel(list, response, tableName, "价格爬虫数据展示", "test", filedNames);

            ResponseBase responseBase = new ResponseBase();
            responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
            return new ResponseEntity<>(responseBase, HttpStatus.OK);
        } catch (Exception e) {
            ResponseBase responseBase = new ResponseBase();
            responseBase.setRetHead(ConstantPool.FAILURE, e.getMessage());
            return new ResponseEntity<>(responseBase, HttpStatus.OK);
        }
    }

    @PostMapping(value = "crawlerData/uploadExcel")
    public ResponseEntity uploadExcel(@RequestParam MultipartFile file) {
        try {
            List<Map<String, String>> maps = ExcelUtils.importExcel(file);
            //TODO
            ResponseBase responseBase = new ResponseBase();
            responseBase.setRetHead(ConstantPool.SUCCESS_CODE, ConstantPool.SUCCESS_MESSAGE);
            return new ResponseEntity<>(responseBase, HttpStatus.OK);
        } catch (Exception e) {
            ResponseBase responseBase = new ResponseBase();
            responseBase.setRetHead(ConstantPool.FAILURE, e.getMessage());
            return new ResponseEntity<>(responseBase, HttpStatus.OK);
        }
    }
}
