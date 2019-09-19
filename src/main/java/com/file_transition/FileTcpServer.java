package com.file_transition;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 两台电脑之间的文件复制服务器端
 * @author Administrator
 */
public class FileTcpServer {

	public static void main(String[] args) {
		
		File p = new File("d:\\temp");//文件保存的位置
		DataInputStream dis = null;
		FileOutputStream fos = null;
		Socket client = null;
		ServerSocket server = null;
		try {
			server = new ServerSocket(5050);
			System.out.println("文件传输服务器启动...");
			client = server.accept();
			System.out.println("一个来自["+ client.getInetAddress() + "]的连接");
			System.out.println("开始进行文件传输...");
			//数据流
			dis = new DataInputStream(client.getInputStream());
			//读取文件名长度
			int length = dis.readInt();
			//接收文件名
			byte[] a = new byte[length];
			dis.read(a);
			String fileName = new String(a);
			File nf = new File(p,fileName);
			if(!nf.exists()){
				nf.createNewFile();
			}
			//打开指定目标文件的流
			fos = new FileOutputStream(nf);
			byte[] b = new byte[1024];
			int i = 0;
			int count = 0;
			while((i=dis.read(b))!=-1){
				fos.write(b,0,i);//输出到目的地
				count++;
				if(count%10==0){
					fos.flush();//写入硬盘
				}				
			}
			fos.flush();
			System.out.println("文件传输完毕...");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dis.close();
				fos.close();
				client.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
