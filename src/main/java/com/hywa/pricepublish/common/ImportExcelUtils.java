package com.hywa.pricepublish.common;

import jxl.*;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ImportExcelUtils {
    public void importExcel(){
        try {
            //打开文件
            Workbook book = Workbook.getWorkbook(new File("testclb.xls"));
            //获得第一个表的工作对象，“0”表示第一个表
            Sheet sheet = book.getSheet(0);
            //得到第一列，第一行的单元格（0，0）
            Cell cell = sheet.getCell(0,0);
            //获取单元格内容
            String result = cell.getContents();

            //取数字的时候强转一下,否则默认只取出小数点后3位
            if (cell.getType() == CellType.NUMBER) {
                NumberCell numberCell = (NumberCell) cell;
                double value = numberCell.getValue();
                System.out.println(value);
            }
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
