package com.sky.io;

import java.io.*;
/**
 * Created by admin on 2019/5/13.
 */
public class IOtest {
    //在静态块中先把数据准备好
    static {
        File file=new File("./test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter= null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            //bufferedwriter是自动追加的
            String s=new String(" I love Java");
            char bchar[] = s.toCharArray();
            for (int i = 0; i <5; i++) {
                bufferedWriter.write(bchar, 0, bchar.length);
                bufferedWriter.write(s+"\n");
                //试着分析下面一段代码, 去掉注释会怎么样???
                // bufferedWriter.flush();
                //bufferedWriter.close();
            }
            //写完之后才能关闭流,
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void bufferedreaderChar() {
        char c='c';
        //使用system.in从控制台中读取字符, 而且bufferedreader是一个缓冲, 在流里面它属于中层,
        // 不直接面对数据源, 需要要给它一个下层的数据源
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("press  q  to  quit ");
        while (!(c=='q')){

            try {
                //read()方法不带参数, 将返回字符的ASCII值
                int i=  bufferedReader.read();
                c=(char)i;
                if(i!=10) {//排除掉回车键值的影响
                    System.out.println("returned int is:" + i + " to char is: " + c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public  void bufferedReaderString() {

        BufferedReader bufferedReader=new BufferedReader(
                new InputStreamReader(System.in));
        String str="aaa";
        System.out.println("type  end  to  quit ");
        while(!"end".equals(str)){
            try {
                //这段代码和上面核心就是read 和 readline 不一样而已
                str=bufferedReader.readLine();
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * bufferedReaderFile
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----------bufferedreaderFile-----------------");
        char arrayc[]=new char[1024];
        String str=null;
        try {
            //数据源从文件里面拿
            BufferedReader bufferedReader=new BufferedReader(new FileReader("./test.txt"));
            while(0<(bufferedReader.read(arrayc, 0, arrayc.length))){
                str= new String(arrayc);
                System.out.print(str);
            };
             //这样写局限很大, 每次只能读取一行, 如果整个文档就只有一行, 呵呵

            while (true){
                str=bufferedReader.readLine();
                if (str==null){
                    break;
                }
                System.out.println(str);

            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * inputStream 针对的是文件, 进入文件里面 -> file
     * readFile
     */
    public  void readFile() {
        System.out.println("---------read file with FileInputStream------------");
        FileInputStream fileInputStream=null;
        try {
            //fileInputStream=new FileInputStream("./test.txt");
            fileInputStream=new FileInputStream("d:/temp/first.png");
            byte b[]=new byte[1024];
            int len=b.length;
            //这个len确保从文件中读取的数据一个不多一个不少.
            while (0<(len=(fileInputStream.read(b, 0, len)))){
                //刚开始len是b[]这个水瓢的容量, 倒数第二次成为从文件中读取的容量, 最后一次读完了成-1
                //这个String构造器没见过吧!!! 从二进制数据转成String类型
                System.out.print(new String(b, 0, len));
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
