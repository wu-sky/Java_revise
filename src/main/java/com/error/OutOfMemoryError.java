package com.error;

/**
 * 堆溢出 情况多见于对象过多，存在多余引用，使对象未及时释放
 */
public class OutOfMemoryError {

	public static void outOfMemory(){
		//String 但是 它是有固定长度, 太长就超了
		String str = "OutOfMemoryError";
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			str += str +  str;
			System.out.println("count: " + i);
		}
	}

	public static void main(String[] args){

		OutOfMemoryError.outOfMemory();
	}

}
/*
  堆内存溢出
 *用户：sky-吴
 *日期：2019/8/28
 */