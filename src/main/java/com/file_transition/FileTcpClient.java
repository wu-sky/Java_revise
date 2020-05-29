package com.file_transition;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 两台电脑之间的文件复制客户器端
 * @author Administrator
 */
public class FileTcpClient {

	public static void main(String[] args) {
		File sf = new File("F:\\FTP(1902部)\\01.java\\ppt\\21.java输入输出.pptx");
		FileInputStream fis = null;
	    DataOutputStream dos = null;
	    Socket client = null;
		try {
			fis = new FileInputStream(sf);
			client = new Socket("192.168.1.36", 5050);
			dos = new DataOutputStream(client.getOutputStream());
			//获取文件名
			byte[] a = sf.getName().getBytes();
			//写入文件名字节长度
			dos.writeInt(a.length);
			dos.write(a);
			//写入文件的内容
			byte[] b = new byte[1024];
			int i = 0;
			int count = 0;
			while((i=fis.read(b))!=-1){
				dos.write(b,0,i);//输出到目的地
				count++;
				if(count%10==0){
					dos.flush();//写入硬盘
				}				
			}
			dos.flush();
			System.out.println("文件传输完毕...");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				dos.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}




	}


}
