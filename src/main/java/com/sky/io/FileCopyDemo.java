package com.sky.io;

import java.io.*;

/**
 * 使用io流进行文件的简单复制
 * Created by Sky-wu@foxmail.com on 2019/5/15.
 */
public class FileCopyDemo extends Thread{


    public static void copyFileByStream()  {
        File sourceFile=new File("test.txt");
        File copiedFile=new File("testcopy.txt");
        FileInputStream sourceFileInputStream= null;//从文件中读数据
        FileOutputStream copiedFileOutputStream=null;//用于把数据写入文件
        BufferedWriter bufferedWriter= null;//用于把数据写入文件
        try {
            if (!sourceFile.exists()){
                sourceFile.createNewFile();
                bufferedWriter = new BufferedWriter(new FileWriter(sourceFile));
                //bufferedwriter是自动追加数据的
                String s=new String(" I love Java");
                char bchar[] = s.toCharArray();
                for (int i = 0; i <5; i++) {
                    //两种方式往文件中写数据
                    bufferedWriter.write(bchar, 0, bchar.length);
                    bufferedWriter.write(", "+s+"\n");

                }
                //写完之后才能关闭流,
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            copiedFile.createNewFile();
            sourceFileInputStream=new FileInputStream(sourceFile);
            copiedFileOutputStream=new FileOutputStream(copiedFile);
            //使用缓冲流把输入输出流包起来
            BufferedInputStream bufferedInputStream=new BufferedInputStream(sourceFileInputStream);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(copiedFileOutputStream);
            //一次复制10个字节
            byte b[]=new byte[10];
            int len=b.length;
            while ((len=bufferedInputStream.read(b, 0, len))>0){
                /**
                 *     源文件相当于一个池塘, byte 数组相当于一个水桶,
                 *     水桶往源文件池塘舀水, 往目标文件里面倒. 知道原文件的水舀完了,
                 *     才能结束.
                 * */
                //这个输出流还是个内存对象??
                String byteStr=new String(b);
                System.out.println("读取的数据是==>"+ byteStr);
                System.out.print("转成数字是==>");
                for (int i = 0; i < b.length; i++) {
                    System.out.print(b[i]);
                }
                bufferedOutputStream.write(b,0,len);
                sleep(1000);
                //往文件中写数据
                bufferedOutputStream.flush();
                System.out.println("目标文件的大小是: "+copiedFile.length() +" 字节");
            }
            System.out.println("file copied");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (sourceFileInputStream!=null){

                try {
                    sourceFileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (copiedFileOutputStream!=null) {
                try {
                    copiedFileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    /**
     * 有问题, 分析问题在那里
     */
    public static void fileCopyByWriter(){

        File sourceFile=new File("test.txt");
        File copiedFile=new File("testcopy.txt");
        FileReader sourceFileReader= null;//从文件中读数据
        FileWriter copiedFileWriter=null;//用于把数据写入文件
        BufferedWriter bufferedWriter= null;//用于把数据写入文件
        try {
            if (!sourceFile.exists()){
                sourceFile.createNewFile();
                bufferedWriter = new BufferedWriter(new FileWriter(sourceFile));
                //bufferedwriter是自动追加数据的
                String s=new String(" I love Java");
                char bchar[] = s.toCharArray();
                for (int i = 0; i <5; i++) {
                    //两种方式往文件中写数据
                    bufferedWriter.write(bchar, 0, bchar.length);
                    bufferedWriter.write(", "+s+"\n");

                }
                //写完之后才能关闭流,
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            copiedFile.createNewFile();
            sourceFileReader=new FileReader(sourceFile);
            copiedFileWriter=new FileWriter(copiedFile);
            //使用缓冲流把输入输出流包起来
            BufferedReader bufferedReader =new BufferedReader(sourceFileReader);
            bufferedWriter =new BufferedWriter(copiedFileWriter);
            //一次复制10个字节
            char c[]=new char[10];
            int len=c.length;
            String str="";
            //第一种方式 while ((len=bufferedReader.read(c, 0, len))>0){
            while( (str=(bufferedReader.readLine()))!=null){

                /**
                 *     源文件相当于一个池塘, char 数组相当于一个水桶,
                 *     水桶往源文件池塘舀水, 往目标文件里面倒. 知道原文件的水舀完了,
                 *     才能结束.
                 * */
                //不对, char[5] c 的容量不够装
                c=str.toCharArray();

                System.out.println("读取的数据是==>"+ str);
                bufferedWriter.write(str,0,    str.length());
                sleep(1000);
                //往文件中写数据
                bufferedWriter.flush();
                System.out.println("目标文件的大小是: "+copiedFile.length() +" 字节");
            }
            System.out.println("file copied");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (sourceFileReader!=null){

                try {
                    sourceFileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (copiedFileWriter!=null) {
                try {
                    copiedFileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }




    public static void readTxt(){
        File file=new File("test.txt");
        FileReader fileReader=null;
        try {
            fileReader = new FileReader(file);
            char[] buf = new char[10];
            int len=buf.length;
            while (len>0){
                //返回实际读取的个数, 从0开始取数据, 到len长度结束
                len = fileReader.read(buf, 0, len);
                sleep(1000);
                //把char [] 转成String
                String bufStr = new String(buf);
                System.out.println("bufStr = " + bufStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 缓冲区的数据没有被覆盖掉, 它的旧数据还在, 它最后第二次的长度是不准确的; 造成多读.
     */
    public static void readTxtError(){
        File file=new File("test.txt");
        FileReader fileReader=null;
        try {
            fileReader = new FileReader(file);
            char[] buf = new char[10];
            int len=buf.length;
            String bufStr;
            //倒数第二次的时候fileReader.read(buf, 0, len) 是返回它正常的len,
            // 但是buf里面长度可能比len大, 因为旧数据还在
            while (fileReader.read(buf, 0, len) >0 ){
                bufStr= new String(buf);
                System.out.println("bufStr = " + bufStr);
                System.out.println("len = " + len);
                sleep(1000);
                //把char [] 转成String

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
     /*   //如果并发数达到一万, 内存占用居高不下, 系统就崩溃了
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new  FileCopyDemo(), "thread " + i);
            thread.start();
        }
        System.out.println("读取完毕, 进入等待");
        sleep(10000);
        System.out.println("quit");*/
        //readTxtError();
        //writeFile();

     //copyFileDemo();
        //renameFile();
        fileCopyByWriter();
    }


    @Override
    public void run() {
        this.IONotClose();
    }

    public void IONotClose(){
        readTxt();
    }


    public static void writeFile(){
        File file = new File("test2.txt");
        try {
            //开启追加
            FileWriter fileWriter=new FileWriter(file, true);
            fileWriter.write("abc");
            fileWriter.write("def");
            //如果你不写close(), 或者不写flush(), 这些数据都是在内存中, 没有写入文件
            fileWriter.close(); //自动flush
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  static void renameFile(){
        File oldFile = new File("test.txt");
        String newFileName="newTest.txt";
        File newFile = new File(newFileName);


        if (oldFile.exists() && oldFile.isFile()) {
            //目前重命名只有这个API
            oldFile.renameTo(newFile);
        }
    }

}
