package com.chatroom_v1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * interact between server and client!!
 * Created by admin on 2019/5/13.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("--------------------client--------------");
        Socket socket=null;
        BufferedReader in=null;
        BufferedWriter out=null;
        BufferedReader br=null;

        try {
            socket=new Socket(InetAddress.getLocalHost(), 8888);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String str=br.readLine();
                out.write(str+"\n");
                out.flush();
                if ("end".equals(str)){
                    break;
                }
                System.out.println("server:"+in.readLine());
            }
            out.close();
            in.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
