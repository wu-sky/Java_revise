package com.chatroom_v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 有个问题, 收发消息不是分开的, 而是说一句收到一句, 因为发消息的时候是阻塞式写消息
 * Created by admin on 2019/5/13.
 */
public class Server {
    public static void main(String[] args) {
        System.out.println("--------------------server--------------");
        Socket socket=null;
        BufferedReader in=null;
        BufferedWriter out=null;
        BufferedReader br=null;

        try{
            ServerSocket server=new ServerSocket(8888);
            socket=server.accept();
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br=new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                String str=in.readLine();//从socket中读取数据
                System.out.println("client:"+str);
                String str2=null;
                if ("end".equals(str)){
                    break;
                }

                str2=br.readLine(); //阻塞, 也就是说你想要得到下一步的信息, 必须得说话
                out.write(str2+"\n");
                out.flush();

            }
            in.close();
            out.close();
            br.close();
            socket.close();
        }catch(IOException exception){
            System.out.println(exception);
        }finally{


        }

    }



}
