package com.udp;

import java.io.IOException;
import java.net.*;

/**
 *
 * 不用io流, 但是有io异常
 * Created by admin on 2019/5/18.
 */
public class Client {
    /**
     * method1
     * @param args
     */
    public static void method1(String[] args){
        try {
            DatagramSocket clientDatagramSocket = new DatagramSocket(5070);//接收快递的地址5070
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
            clientDatagramSocket.receive(packet);
            System.out.println(packet.getAddress().getHostName() + "(" + packet.getPort() + "):" + new String(packet.getData()));
            //接收完事了

            //发送数据
            packet.setPort(5060);//快递的地址
            packet.setAddress(InetAddress.getLocalHost());
            packet.setData("Hello Server".getBytes());
            clientDatagramSocket.send(packet);
            clientDatagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * method2
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println("client:");
            DatagramSocket datagramSocket=new DatagramSocket(8889);//服务端负责收
            DatagramPacket datagramPacket=new DatagramPacket(new byte[1024],  1024);
            datagramSocket.receive(datagramPacket);//这里将会阻塞等待快递的到来
            //引用类型, 进到里面会更改属性
            System.out.println("来自商家的消息:"+new String(datagramPacket.getData()));
            datagramPacket.setData("".getBytes());//把数据包里面的东西全给你清空


            String message="你他娘的才放弃";
            datagramPacket.setPort(8888);
            datagramPacket.setData(message.getBytes());
            datagramSocket.send(datagramPacket);
            System.out.println("消息已发送");
            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }


    }

}
