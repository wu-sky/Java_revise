package com.JavaCommonTopics;


/**
 * 在JAVA中如何跳出当前的多重嵌套循环？
 */
public class BreakLoop {

	public static void breakFunction1() {
		System.out.println("方法1:Break + 标签; 注意[ok:]标签这一行只能写[ok:], 不能写其他代码, 否则报错");
		int i, j;
		ok:
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				System.out.println("i=" + i + " , j=" + j);
				if (i == 2) {
					break ok;
				}
			}
		}

		System.out.println("i=" + i);
	}

	public static void breakFunction2() {
		System.out.println("方法2:直接Break, 但是只能跳出一层循环");
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				System.out.println("i=" + i + " , j=" + j);
			}
			if (i == 2) {
				break;
			}
		}
		System.out.println("i=" + i);
	}

	public static void breakFunction3() {
		System.out.println("方法3:在循环表达式插入条件判断; 例如外层的循环条件表达式的结果可以受到里层循环体代码的控制,，例如，要在二维数组中查找到某个数字。");
		int arr[][] = {{1, 2, 3}, {4, 5, 6, 7}, {9}};
		boolean found = false;
		for (int i = 0; i < arr.length && (!found); i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("arr[" + i + "][" + j + "]=" + arr[i][j]);
				if (arr[i][j] == 5) {
					found = true;
					break;
				}
			}
		}
	}


	public static void breakFunction4() {
		System.out.println("方法4:使用return");
		int count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				count++;
				System.out.println("i=" + i + ",j=" + j);
				if (j == 5) {
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		//BreakLoop.breakFunction1();
		BreakLoop.breakFunction4();
	}


}
/*
 *用户：sky-吴
 *日期：2019/9/2
 */