package com.generic;
import java.util.ArrayList;
import	java.util.Collection;



public class GenericMethod {

	/**定义一个泛型方法, 把一个object数组放到一个集合中
	 * 而且可以被定义为静态, 因为泛型方法是在调用方法的时候被确定, 而非实例化类时确定
	 * @param tArray
	 * @param c
	 * @param <T>
	 */
	public static <T> void fromArray2Collection (T[] tArray, Collection<T> c){

		for (T t : tArray){
			c.add(t);
		}

	}


	public static void main(String[] args){
	    Object[] oa=new Object[10];
	    Collection<Object> co=new ArrayList<>();
	    fromArray2Collection(oa, co);

	    String[] os=new String[10];
	    Collection<String> cs=new ArrayList<>();
	    fromArray2Collection(os, cs);

	    Integer[] oi=new Integer[10];
	    Collection<Integer> ci=new ArrayList<>();
	    fromArray2Collection(oi, ci);
	}


}



/*
 *用户：sky-吴
 *日期：2019/9/3
 */