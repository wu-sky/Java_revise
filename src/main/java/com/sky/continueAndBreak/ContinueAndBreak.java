package com.sky.continueAndBreak;

/*
 *用户：sky-吴
 *日期：2020/4/23
 */
public class ContinueAndBreak {

	public static void testContinue(){
		System.out.println("----------testContinue------------");
		for (int i = 10; i >0; i--) {

			if (i%2==0){
				continue;

			}else {
				System.out.println("i===>"+i);
			}
		}
	}

	public static void testBreak(){
		System.out.println("----------testBreak------------");
		for (int i = 10; i >0; i--) {

			if (i%2==0){
				break;

			}else {
				System.out.println("i===>"+i);
			}
		}
	}

	public static void testDoubleLoopForBreak(){
		System.out.println("----------testDoubleLoopForBreak------------");
		for (int i = 0; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println("j====>" +j);
				if (j % 5==0){
					//连第二层循环也跳出去了
					break;
				}
			}
		}
	}


	public static void main(String[] args){
	  testContinue();
	  testBreak();
	  testDoubleLoopForBreak();
	}
}
