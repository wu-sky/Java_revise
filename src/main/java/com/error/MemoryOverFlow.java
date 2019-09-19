package com.error;

import java.util.ArrayList;

/*
 *用户：sky-吴
 *日期：2019/8/28
 * 最高Java jvm也跑不了100%的内存,  到了一个上限就上不去了
 * 内存100%。不停生成数组
 */
public class MemoryOverFlow {
	public static void main(String[] args){
		ArrayList<String> list=new ArrayList<>();
		for (int i=1;i>0; i++){
			list.add(""+i);
			System.out.println("count: "+i);
	  }

	}
}
