package com.sky.JavaNet;

import java.io.*;
import java.net.*;
import java.util.Arrays;

/**
 * @author：sky-吴 日期：2020/4/27
 * 邮箱:
 */
public class JavaNet {

    public static void main1(String[] args) throws UnknownHostException, IOException {

        int port = 80;
        String host = "127.0.0.1";

        // 创建一个套接字并将其连接到指定端口号
        Socket socket = new Socket(host, port);

        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));

		/*DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(socket.getOutputStream()));*/
        byte[] data = new byte[1024];
        int len = data.length;
        String str = "";
        while (dis.read(data, 0, len) > 0) {
            str += new String(data);
        }
        System.out.println("str = " + str);
        dis.close();
        socket.close();

    }


    public static void testURLEncoder() {
        String url = "http://www.baidu.com?name=伍思凯";
        try {
            String encodedUrl = URLEncoder.encode(url, "utf-8");
            System.out.println("encodedUrl = " + encodedUrl);
            byte[] bytes=url.getBytes("utf-8");
			System.out.println("bytes = " + Arrays.toString(bytes));
			String decodeURL= new String(bytes, "utf-8");
			System.out.println("decodeURL = " + decodeURL);

		} catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    /*
    Malformed 畸形的, 格式不正确的
     */
    public static void testURL() {
        URL url = null;
        try {
            //创建一个URL实例
            URL bilibili = new URL("https://message.bilibili.com");
            //？后面表示参数，#后面表示锚点
            url = new URL(bilibili, "/#/love");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("协议：" + url.getProtocol());
        System.out.println("主机：" + url.getHost());
        //如果未指定端口号，则使用默认的端口号，此时getPort（）方法返回值为-1
        System.out.println("端口：" + url.getPort());
        System.out.println("文件path：" + url.getPath());
        System.out.println("文件名：" + url.getFile());
        System.out.println("相对路径：" + url.getRef());
        System.out.println("查询字符串：" + url.getQuery());
    }


    public static void main(String[] args) {
        testURLEncoder();
    	//testInetAddress();
       // testURL();
    	//curl();
    }


    public static void testInetAddress() {
        InetAddress localhost = null;
        InetAddress bilibli = null;
        try {
            //获取本机的InetAddress实例
            localhost = InetAddress.getLocalHost();
            //根据IP获取地址
            bilibli = InetAddress.getByName("110.43.34.66");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("计算机名：" + localhost.getHostName());
        System.out.println("IP地址：" + localhost.getHostAddress());
        byte[] bytes = localhost.getAddress(); //获取字节数组形式的IP地址
        System.out.println("字节数组形式的IP地址：" + Arrays.toString(bytes));
        System.out.println("localhost = " + localhost);
        //直接输出InetAddress对象


        //根据机器名获取InetAddress实例
        //InetAddress address2 = InetAddress.getByName("DESKTOP-1GQCD7C");

        System.out.println("计算机名：" + bilibli.getHostName());
        System.out.println("IP地址：" + bilibli.getHostAddress());
    }


    public static void curl() {
        try {
            //创建一个URL实例
            URL url = new URL("http://www.baidu.com");
            //通过URL的openStream方法获取URL对象所表示的资源的字节输入流
            InputStream is = url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();//读取数据
            while (data != null) {//循环读取数据
                System.out.println(data);//输出数据
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
