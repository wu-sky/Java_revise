package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 不依赖io流, 但是有io异常
 * Created by admin on 2019/5/18.
 */
public class Server {
    /**
     * method1
     * @param args
     */
    public static void method1(String[] args) {
        try {
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);// 容器,字节数组 封装包裹
            packet.setData("Hello Client".getBytes());  //发送数据必须转成字节流
            packet.setPort(5070);  //对方的房门端口和地址设置完毕, 快递准备就绪
            packet.setAddress(InetAddress.getLocalHost());
            DatagramSocket serverDatagramSocket = new DatagramSocket(5060); //使用datagramsocket 指定接受端口
            serverDatagramSocket.send(packet);//快递发货
            System.out.println("---------快递发送完毕-----------");

            System.out.println("---------等待接收-------------");
            serverDatagramSocket.receive(packet); //阻塞式接受包裹
            System.out.println(packet.getAddress().getHostName() +
                    "(" + packet.getPort() + "):" + new String(packet.getData())); //getData方法解封数据
            serverDatagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method2
     * @param args
     */
    public static void main(String[] args) {

        try {
            System.out.println("server:");
            DatagramSocket datagramSocket=new DatagramSocket(8888);//接收快递的地址
            DatagramPacket datagramPacket=
                    new DatagramPacket(new byte[1024],  1024, InetAddress.getLocalHost(), 8889);
            //初始化容器和发包地址, 即使现在没有指定也不要紧, 后面还可以调
            String message="这是您在某东买的Java从入门到放弃, 请签收...";
            datagramPacket.setData(message.getBytes());
            datagramSocket.send(datagramPacket);
            System.out.println("快递已经发送...");
            //datagramPacket.setData("".getBytes());//把数据包里面的东西全给你清空 但是没用, 原来的数据包已经用不了了

            //创建一个新的数据包来接收
            datagramPacket=new DatagramPacket(new byte[1024], 1024);
            datagramSocket.receive(datagramPacket);
            System.out.println("来自买家的消息:"+new String(datagramPacket.getData()));
            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



