package com.sky.JavaNet;

import java.io.*;
import java.net.*;

/**
 * @author：吴世凯 邮箱：
 * 日期：2020/5/5
 * 可以放在不同的idea项目中跑
 */
public class TestClient {

    static Socket socket = null;
    static OutputStream outputStream = null;

    public static void sendAMsg() {

        try {


            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8888);
            outputStream = socket.getOutputStream();
            outputStream.write("你好, motherf*cker".getBytes());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {

                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void sendAFile() {
        try {

            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8888);
            outputStream = socket.getOutputStream();
            File file = new File("test.txt");
            if (!file.exists()){
                System.out.println("文件不存在, 退出.....");
                return;
            }else{
                System.out.println("file.length() = " + file.length());
            }

            InputStream  fileInputStream = new FileInputStream(file);
            int len=0;
            byte[] bytes=new byte[16];
            len=bytes.length;
            while ((len=fileInputStream.read(bytes, 0, len))>0){
                outputStream.write(bytes, 0, len);
                System.out.println("len = " + len);
            }
            System.out.println("文件发送完毕");
            //通知server 文件已经发送完毕
            socket.shutdownOutput();


            InputStream inputStream=socket.getInputStream();
            ByteArrayOutputStream   byteArrayOutputStream = new ByteArrayOutputStream();
            len=bytes.length;
            while ((len = inputStream.read(bytes, 0, len)) > 0) {
                //全都保留在一个流中
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println("byteArrayOutputStream.toString() = " + byteArrayOutputStream.toString());
            inputStream.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {

                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void sendUDPMsg(){
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            String str="你好, motherf*cker, 我是UDP";
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), 0, str.length(), inetAddress,8889);
            datagramSocket.send(datagramPacket);

            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

    }

    public static void main(String[] args) {
        //sendAMsg();

        //sendAFile();
        sendUDPMsg();
    }

}
