package com.chatroom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 难点就在于流的选择, 其他都是公式化的
 * Created by admin on 2019/5/13.
 */
class Server {
    /**
     * acceptMethod1
     *
     * @param args
     */
    public static void acceptMethod1(String[] args) {
        try {
            System.out.println("--------server---------------");
            ServerSocket serverSocket = new ServerSocket(8888);// 打开端口
            Socket socket = new Socket();//创建一个socket管道
            socket = serverSocket.accept();// 等待client的连接
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
            char arrayC[] = new char[16];//超过16个字符会报异常吗???
            int len = arrayC.length;

            while ((len = inputStreamReader.read(arrayC, 0, len)) > 0) {
                //缺陷, 这种写法不适合聊天室一条条发的消息, 因为len到后面都是变成了零头长度
                // 只会越来越小.
                System.out.println("len=" + len);
                System.out.println("from client:" + (new String(arrayC, 0, len)));
            }

            inputStreamReader.close();
            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 总的来说inputstreamreader有自己的优势,
     * 但是不适合在聊天室中使用, 它没有接收一行数据的方法
     * acceptmethod2
     *
     * @param args
     */
    public static void acceptmethod2(String[] args) {
        ServerSocket serversocket = null;
        InputStreamReader inputStreamReader = null;
        Socket socket = null;
        try {
            System.out.println("--------server---------------");
            serversocket = new ServerSocket(8888);
            socket = serversocket.accept();
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            char arrayC[] = new char[16];
            int len = 16;

            while ((inputStreamReader.read(arrayC, 0, len)) > 0) {

                //len我给你写死了, 这种写法特别笨了
                System.out.println("len=" + len);

                System.out.println("from client:" + (new String(arrayC, 0, len)));

            }
            inputStreamReader.close();
            serversocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * acceptmethod3
     * @param args
     */
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket socket=null;
        try {
            System.out.println("--------server-------------");
            serverSocket=new ServerSocket(8888);
            socket=serverSocket.accept();
           //BufferedInputStream bufferedInputStream=new BufferedInputStream(socket.getInputStream()); //没有获取一行的方法
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()) );
            //DataInputStream dataInputStream=new DataInputStream(socket.getInputStream()); //这个真的不知道如何用
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
            BufferedReader bufferedReaderconsole=new BufferedReader(new InputStreamReader(System.in));
            String strClient="";
            String strServer="";
            while(true){

                strServer= bufferedReaderconsole.readLine();
                outputStreamWriter.write(strServer+"\n");
                outputStreamWriter.flush();
                strClient=  bufferedReader.readLine();
                System.out.println("from client:"+ strClient);

                if ("quit".equals(strClient)||"quit".equals(strServer)){
                    System.out.println("系统下线");
                    break;
                }
            }
            outputStreamWriter.close();
            bufferedReaderconsole.close();
            bufferedReader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}