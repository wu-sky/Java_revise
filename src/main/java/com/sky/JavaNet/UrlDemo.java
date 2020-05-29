package com.sky.JavaNet;

import org.apache.http.HttpConnection;

import java.io.*;
import java.net.*;

/**
 * @author：吴世凯 邮箱：
 * 日期：2020/5/5
 */
public class UrlDemo {


    public static void test() throws IOException {

        URL url=new URL("https://i0.hdslb.com/bfs/album/798de0fa7f8373a07e4809feb483809b4fe45f5a.jpg");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        File file = new File("音阙思听.jpg");
        OutputStream fileOuputStream=new FileOutputStream(file);
        int len=0;
        byte[] bytes=new byte[1024];
        len=bytes.length;
        while ((len=inputStream.read(bytes, 0, len))>0){
            fileOuputStream.write(bytes, 0, len);
        }
        System.out.println("download completed");
        fileOuputStream.close();
        inputStream.close();
        urlConnection.disconnect();



    }

    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
