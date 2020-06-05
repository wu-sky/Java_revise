package com.sky.io;



import java.io.File;
import java.io.IOException;
/**
 * @author：sky-吴
 * 日期：2020/4/25
 * 常识:
 *在Java中, 有个分隔符常量		File.separator  在win 中是\ , 在Linux中是 /
 *在idea工程中 相对路径是工程名下的路径 , 如: E:\Java\codeLibraries\JavaSE\Java_revise
 */
public class FileDemo {



	public  void  test(){
		File absoluteFile = new File("E:\\Java\\codeLibraries\\JavaSE\\Java_revise\\src\\main\\java\\com\\io\\absoluteFile.txt");
		/*现在这个file 只是一个内存层面的对象而已, 并没有去访问 磁盘
		第一个参数是父目录, 第二个文件是子目录 , 其实就是 d:/temp/test 目录*/
		File dir = new File("d:/temp", "test");
		//第一个参数是 目录对象, 第二个参数是文件名, 文件要想创建成功, 目录必须存在
		File realFile= new File(dir, "1.txt");
		showFileIO(realFile);
		showFileProperties(realFile);
	}

	/**
	 * io层面的方法, 一般都有try catch
	 * @param file
	 */
	public static void showFileIO(File file) {
		System.out.println("文件的绝对路径是: " + file.getAbsolutePath());
		if (!file.exists()){

	    	File dir=new File(file.getParent());
		   if (!dir.exists()){
			   System.out.print("父目录"+dir.getAbsolutePath()+" 不存在!! ");
			   dir.mkdirs();
			   System.out.println("父目录"+dir.getAbsolutePath()+" 创建成功");
		   }
		    try {
			    boolean crateResult = file.createNewFile();
			    System.out.println("文件不存在并创建成功");
		    } catch (IOException e) {
			    System.out.println("文件创建失败");
			    e.printStackTrace();
		    }
	    }else{
			System.out.print("文件已存在");
			file.delete();
			System.out.println(", 已经删掉");
		}
	}


	public void showFileProperties(File file){
		System.out.println("-----------showFileProperties---------");
		//内存层面的方法, 它是不会报错的
		System.out.println(file.getName()+    "    realFile.delete() = " + file.delete());
		System.out.println(file.getName()+    "    文件或者文件夹的名称是："+file.getName());
		System.out.println(file.getName()+    "    绝对路径是："+file.getPath());
		System.out.println(file.getName()+    "    绝对路径是："+file.getAbsolutePath());
		System.out.println(file.getName()+    "    文件大小是（以字节为单位）:"+file.length());
		System.out.println(file.getName()+    "    file.getParent() 父路径是"+file.getParent());
		System.out.println(file.getName()+    "    文件或者文件夹存在吗？"+file.exists());
		System.out.println(file.getName()+    "    是一个文件吗？"+file.isFile());
		System.out.println(file.getName()+    "    是一个文件夹吗？"+file.isDirectory());
		System.out.println(file.getName()+    "    是隐藏文件吗？"+file.isHidden());
		System.out.println(file.getName()+    "    file.canExecute() = " + file.canExecute());
		System.out.println(file.getName()+    "    file.canWrite() = " + file.canWrite());
		System.out.println(file.getName()+    "    file.canRead() = " + file.canRead());
		System.out.println(file.getName()+    "    此路径是绝对路径名？"+file.isAbsolute());
		System.out.println(file.getName()+    "    最后一次被修改的时间(不存在则为 0 ): "+file.lastModified());
		System.out.println(file.getName()+    "    文件或文件夹的名称，不包含上级路径: "+file.getName());
		System.out.println("-------------end----------------------");
	}

	public static void showRelativeProperties(){
		File relativeFile = new File("src\\main\\java\\com\\io\\relativeFile.txt");
		System.out.println("relativeFile 对象路径是绝对路径名？"+relativeFile.isAbsolute());
		System.out.println("relativeFile 绝对路径是："+relativeFile.getAbsolutePath());

	}

	public static void showError(){
		/*这是一个错误的路径, 在win中上面的特殊字符都是不允许的, 但是在内存中的却能创建对象, 但是
		写到磁盘中将会报错*/
		File errorFile =new File("d:\\\\\\///::<?***||||>:xxxxxxxxx");
		System.out.println("relativeFile 对象路径是绝对路径名？"+errorFile.getAbsolutePath());
		showFileIO(errorFile);
	}

}
