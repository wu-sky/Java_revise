package com.objectRecycling;


/*
 *用户：sky-吴
 *日期：2019/7/15
 * gc强制回收
 */
public class ObjectRecycle {
    private String name;

    ObjectRecycle(String str) {
        name = str;
        System.out.println(str + "对象已创建");
    }

    @Override
    public void finalize() {
        System.out.println("系统正在清理对象的资源...");
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new ObjectRecycle("obj" + i);
            System.gc();
            //Runtime.getRuntime().gc();
        }


    }


}
