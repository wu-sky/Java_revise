package com.chatroom;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{

    public static void main(String[] args) {
        BufferedReader bufferedReader=null;
        OutputStreamWriter outputStreamWriter=null;
        Socket socket=null;
        try {
            socket=new Socket(InetAddress.getLocalHost(), 8888);
            outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
            BufferedReader bufferedReaderServer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("--------------client---------------");
            int Length=0;
            String message="";
            String messageServer="";
            char arrayC[ ]=new char[1024];
            bufferedReader=new BufferedReader(new InputStreamReader(System.in ));
            while (!"quit".equals(message)&&!"quit".equals(messageServer)){
                message=bufferedReader.readLine();
                outputStreamWriter.write(message+"\n");
                outputStreamWriter.flush();


                //System.out.println(":"+message);
                //outputStreamWriter.write(arrayC+"\n", 0, Length);
                // arrayc数组将不会追加\n, 如果读不到\n, bufferedreader.readline()将会一直等待


                messageServer= bufferedReaderServer.readLine();
                System.out.println("from server:"+messageServer);

            }
            outputStreamWriter.close();
            bufferedReader.close();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}