package com.sky.hardware;



import javax.print.PrintService;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

/**
 * @author : wushikai
 * <p>
 * date : 2020-06-16
 */
public class Printer implements Printable {
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int page)
            throws PrinterException {

        if (page > 0) {
            return NO_SUCH_PAGE;
        }
      justString(graphics, pageFormat, page);

        //  receipt(graphics, pageFormat, page);
        return PAGE_EXISTS;
    }


    public void justString(Graphics graphics, PageFormat pageFormat, int page){
        Graphics2D graphics2D= (Graphics2D) graphics;
        Font font = new Font("黑体", Font.PLAIN, 10); //字体名称, 字体样式, 字体大小

        graphics2D.setFont(font);
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        graphics.drawString("abcdef", -10, 10);
        graphics.drawString("其实我是一个程序员", 0, 15);
        graphics.drawString("abcdef", 0, 30);
        graphics.drawString("其实我是一个程序员", 0, 45);
        graphics.drawString("abcdef", 0, 60);
        graphics.drawString("其实我是一个程序员", 0, 15*5);
        graphics.drawString("abcdef", 0, 15*6);
        graphics.drawString("其实我是一个程序员", 0, 15*7);


    }

    public void receipt(Graphics graphics, PageFormat pageFormat, int page){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics.setFont(new Font("Default", Font.PLAIN, 14));
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        graphics.drawString("等位排单号", 10, 10);
        graphics.drawString("------------------------------------------------------", 10, 25);
        graphics.drawString("手机号码：***", 10, 40);
        graphics.drawString("就餐人数：3", 10, 55);
        graphics.drawString("领号日期：2013-08-09 12:00:00", 10, 70);
        graphics.drawString("------------------------------------------------------",  10, 85);
        graphics.setFont(new Font("Default", Font.PLAIN, 25));
        graphics.drawString("中桌9号", 10, 100);
        graphics.setFont(new Font("Default", Font.PLAIN, 14));
        graphics.drawString("您之前还有" + 5 + "桌客人在等待", 10, 115);
        graphics.drawString("------------------------------------------------------",
                10, 130);
        graphics.drawString("*打印时间:2013-08-09 12:00:00*", 10, 145);
        graphics.drawString("*注意迎宾叫号，过号请到迎宾台*", 10, 160);
        graphics.drawString("*提前短信通知可能存在延时，仅供参考*", 10, 180);
        graphics.drawString("*最终解释权归本店所有*", 10, 195);
        graphics.drawString("店名：餐厅", 10, 210);
    }

    public static void main(String[] args) {

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printer());
        try {
            job.setPrintService(getMicrosoft2Pdf());

            job.print();
        } catch (PrinterException e) {
            System.out.println("================打印出现异常");
        }


    }



    public static PrintService getMicrosoft2Pdf(){
        PrintService[] printServices = PrinterJob.lookupPrintServices();
        ArrayList<String> printerNameList = new ArrayList<>();
        for (int i = 0; i < printServices.length; i++) {
            String name = printServices[i].getName();
            if ("Microsoft Print to PDF".equals(name)){
                return printServices[i];
            }

        }
        return null;

    }


    public  static ArrayList<String> getPrinterNames ( ){
        PrintService[] printServices = PrinterJob.lookupPrintServices();
        ArrayList<String> printerNameList=new ArrayList<>();
        for (int i = 0; i < printServices.length; i++) {
            String name = printServices[i].getName();
            System.out.println(name);
            printerNameList.add(name);
        }
            return  printerNameList;
    }



}
