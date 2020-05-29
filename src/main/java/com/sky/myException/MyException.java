package com.sky.myException;



/*
 *用户：sky-吴
 *日期：2020/4/8
 */
public class MyException {

	public static void main(String[] args) throws Exception  {
		//System.out.println(MyException.test());
		try {

			MyException.test2();
		}catch (Exception e){

		}
		System.out.println("异常被抛出去, 但是得到了处理, 我还能执行");
	}
	public static int test() {
		int x = 1;
		try{
			System.out.println(1/0);
			return x;
		}catch (Exception e){
			e.printStackTrace();

			return x;
		}
		finally {
			++x;
			System.out.println(x);

		}
	}


	public static void test2() throws ClassNotFoundException {
		try {

			Class.forName("草泥马");
		}catch (Exception e){
		System.out.println("异常处理中.....");
	}
		System.out.println("异常处理之后...我还在");
		System.out.println("不做处理的异常...");
		Class.forName("草泥粑粑"); /**/
		System.out.println("异常不做处理之后...我还在");
	}
}
