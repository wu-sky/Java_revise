package com.thread.importantMethod;



/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/20/2020
 */
public class MyTMethodDemo  extends  Thread{


    @Override
    public void run() {

        Thread.currentThread().setName("自定义线程名");
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程id: "+Thread.currentThread().getId()+" 线程名: "+Thread.currentThread().getName()+"  " +i);
        }
        System.out.println("ing == "+Thread.currentThread().isAlive() );
    }



    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        MyTMethodDemo myThread=new MyTMethodDemo();

        System.out.println("begin =="+myThread.isAlive());
        myThread.start();
        //线程休眠1秒,交出CPU，让CPU去执行其他的任务
        sleep(10);
        System.out.println("end =="+myThread.isAlive());
        /*子线程中药进行大量耗时运算，主线程往往将早于子线程结束之前结束。
        这时，如果主线程想等待子线程执行完成之后再结束，比如子线程处理一个数据，
        主线程要取得这个数据中的值，就要用到join()方法了。方法join()的作用是等待线程对象销毁*/
        MyTMethodDemo myThread1=new MyTMethodDemo();
        myThread1.start();
        for (int i = 0; i < 30; i++) {
            if (i==10){
                //让分线程加进来, 它先执行完, 才到主线程执行
                myThread1.join();
            }
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }




    }




}
