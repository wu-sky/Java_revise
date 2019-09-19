package com.polymorphic;

/*
 *用户：sky-吴
 *日期：2019/9/5
 */
public class CF {
	String name;
	String slogan;
	CF(){

	}



	CF(String name){
		this.name=name;
	}

	void test(String str){
		 str="abc";
		//StringBuffer sb = (StringBuffer)str;
	}


	 int test(){
		int x = 1;
		try{
			return x;
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			++x;
			return x;
		}
	}

	public static void main(String[] args){
		System.out.println(new CF().test());
	}

}
