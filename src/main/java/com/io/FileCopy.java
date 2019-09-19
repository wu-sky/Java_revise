package com.io;

import java.io.*;

/**
 * 使用io流进行文件的简单复制
 * Created by Sky-wu@foxmail.com on 2019/5/15.
 */
public class FileCopy {


    public static void main(String[] args) {
        File sourcefile=new File("./test.txt");
        File copyfile=new File("./testcopy.txt");
        FileInputStream fileInputStream= null;//从文件中读数据
        FileOutputStream fileOutputStream=null;//用于把数据写入文件
        BufferedWriter bufferedWriter= null;//用于把数据写入文件
        try {
            if (!sourcefile.exists()){
                sourcefile.createNewFile();
                bufferedWriter = new BufferedWriter(new FileWriter(sourcefile));
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
            copyfile.createNewFile();
            fileInputStream=new FileInputStream(sourcefile);
            fileOutputStream=new FileOutputStream(copyfile);
            byte b[]=new byte[8192];

            int len=b.length;
            while ((len=fileInputStream.read(b, 0, len))>0){
                fileOutputStream.write(b,0,len);
                fileOutputStream.flush();
            }
            System.out.println("file copied");
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
