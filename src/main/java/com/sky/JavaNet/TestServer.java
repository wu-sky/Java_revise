package com.sky.JavaNet;

import java.io.*;
import java.net.*;

/**
 * @author：吴世凯 邮箱：
 * 日期：2020/5/5
 * 可以放在不同的idea 项目中跑起
 */
public class TestServer {

    static ServerSocket serverSocket = null;

    public static void reseiveAMsg() {
        InputStream inputStream = null;
        Socket socket = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(8888);

            socket = serverSocket.accept(); //服务器在这里阻塞

            System.out.println("远程socket位置==> socket.getInetAddress() = " + socket.getInetAddress());
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[5];
            int len = bytes.length;
            String content = "";
            //这么写, 如果有中文, 可能会乱码
          /*  while ((len = inputStream.read(bytes, 0, len)) > 0) {
                //一段一段接上去, 一个汉字可能断裂, 造成乱码
                content += new String(bytes, 0, len);
            }
            System.out.println("content = " + content);*/


            //解决方案
            byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(bytes, 0, len)) > 0) {
                //全都保留在一个流中
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println("byteArrayOutputStream.toString() = " + byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
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

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }


    public static void reseiveAFile() {
        InputStream inputStream = null;
        OutputStream fileOutputStream = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("server start.....");
            socket = serverSocket.accept(); //服务器在这里阻塞

            System.out.println("远程socket位置==> socket.getInetAddress() = " + socket.getInetAddress());
            inputStream = socket.getInputStream();
            File file = new File("test.txt");
            fileOutputStream = new FileOutputStream(file);
            byte[] bytes = new byte[16];
            int len = bytes.length;

            while ((len = inputStream.read(bytes, 0, len)) > 0) {

                fileOutputStream.write(bytes, 0, len);
                System.out.println("len = " + len);
                fileOutputStream.flush();

            }
            if (file.exists()){
                System.out.println("file.length() = " + file.length());
                System.out.println("文件接收完毕....");
            }
            //通知 client
            OutputStream outputStream=socket.getOutputStream();
            outputStream = socket.getOutputStream();
            outputStream.write("你好, 文件已经接收".getBytes());
            outputStream.close();



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
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

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    public static void receiveUDPMsg(){
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            DatagramSocket datagramSocket = new DatagramSocket( 8889, inetAddress);
            byte[] bytes=new byte[1024];

            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, inetAddress,8889);
            datagramSocket.receive(datagramPacket);
            System.out.println("数据==> "+ new String(datagramPacket.getData(), 0, datagramPacket.getLength()));



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
       // reseiveAMsg();
       // reseiveAFile();
        receiveUDPMsg();
    }


}
