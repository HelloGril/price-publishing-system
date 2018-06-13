package com.hywa.pricepublish.common;

import com.hywa.pricepublish.dao.entity.User;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;


import java.io.IOException;
import java.io.OutputStream;

public class ExportExcelUtils {
    public static void createExcel(User user, OutputStream outputStream) {
        try {
            //创建Excel文件
            WritableWorkbook workbook = Workbook.createWorkbook(outputStream);
            //创建Sheet页
            WritableSheet sheet = workbook.createSheet("测试sheet", 0);

            // 设置字体种类和黑体显示,字体为Arial,字号大小为14,采用黑体显示
            WritableFont bold = new WritableFont(WritableFont.ARIAL, 14,
                    WritableFont.BOLD);
            // 生成一个单元格样式控制对象
            WritableCellFormat titleFormat = new WritableCellFormat(bold);

            //创建单元格
            Label label0 = new Label(0, 0, "用户信息记录表", titleFormat);
            Label label1 = new Label(0, 1, user.getName());
            Label label2 = new Label(1, 1, user.getPassword());
            Label label3 = new Label(2, 1, user.getJob());
            Label label4 = new Label(3, 1, Sex.getSex(user.getSex()));
            Label label5 = new Label(4, 1, user.getWorkUnit());
            //添加单元格式
            sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            //合并单元格，第一个参数是起始列，第二个参数是起始行，第三个参数是终止列，第四个参数是终止行
            sheet.mergeCells(0, 0, 5, 0);

            //将数据写入文件
            workbook.write();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

}
