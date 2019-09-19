package com.bigintegerBigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/*
 *用户：sky-吴
 *日期：2019/7/15
 */
public class BigNumberDemo  {


    public static void  issueOfDoubleFloat(){
        //精度丢失
        System.out.println("0.05 + 0.01= " + (0.01 + 0.05));
        System.out.println("1.0 - 0.42=" +(1.0 - 0.42));
        System.out.println("4.0105* 100= "+(4.0105 * 100));
    }

    public static void bigIntegerDemo()
    {
        System.out.println("构造两个BigInteger对象");
        //BigInteger(int numBits,Random rnd)
        //构造一个随机生成的 BigInteger，它是在 0 到 (2^numBits - 1)（包括）范围内均匀分布的值
        BigInteger bi1 = new BigInteger(55,new Random());
        System.out.println("bil = " + bi1);

        //BigInteger(byte[] val)
        //将包含 BigInteger 的二进制补码表示形式的 byte 数组转换为 BigInteger。
        BigInteger bi2 = new BigInteger(new byte[]{3,2,3});
        System.out.println("bi2 = " + bi2);

        //加
        System.out.println("bi1 + bi2 = " + bi1.add(bi2));
        //减
        System.out.println("bi1 - bi2 = " + bi1.subtract(bi2));
        //乘
        System.out.println("bi1 * bi2 = " + bi1.multiply(bi2));
        //指数运算
        System.out.println("bi1的2次方 = " + bi1.pow(2));
        //整数商
        System.out.println("bi1/bi2的整数商: " + bi1.divide(bi2));
        //余数
        System.out.println("bi1/bi2的余数: " + bi1.remainder(bi2));
        //整数商+余数
        System.out.println("bi1 / bi2 = " + bi1.divideAndRemainder(bi2)[0] +
                "--" + bi1.divideAndRemainder(bi2)[1]);
        System.out.println("bi1 + bi2 = " + bi1.add(bi2));
        //比较大小,也可以用max()和min()
        if(bi1.compareTo(bi2) > 0)
        {
            System.out.println("bi1 is greater than bi2");
        }
        else if(bi1.compareTo(bi2) == 0)
        {
            System.out.println("bi1 is equal to bi2");
        }
        else if(bi1.compareTo(bi2) < 0)
        {
            System.out.println("bd1 is lower than bd2");
        }
        //返回相反数
        BigInteger bi3 = bi1.negate();
        System.out.println("bi1的相反数:" + bi3);
        //返回绝对值
        System.out.println("bi1的绝对值:" + bi3.abs());
    }

    public static void bigDecimalDemo()
    {
        System.out.println("构造两个BigDecimal对象");
        //用char[]数组创建BigDecimal对象,第二个参数为位移offset,
        //第三个参数指定长度
        BigDecimal bd1 = new BigDecimal("3464656776868432998434".toCharArray(),0,20);
        System.out.println("bd1 = " + bd1);
        //用double类型创建BigDecimal对象
        BigDecimal bd2 = new BigDecimal(123456789987654321.0);
        System.out.println("bd2 = " + bd2);


        System.out.println("bd1 + bd2 = " + bd1.add(bd2));

        System.out.println("bd1 - bd2 = " + bd1.subtract(bd2));

        System.out.println("bd1 * bd2 = " + bd1.multiply(bd2));
        //指数运算
        System.out.println("bd1的2次方 = " + bd1.pow(2));
        //取商的整数部分
        System.out.println("bd1/bd2的整数商: " + bd1.divideToIntegralValue(bd2));
        //返回余数计算为:this.subtract(this.divideToIntegralValue(divisor).multiply(divisor))
        //System.out.println(bd1.subtract(bd1.divideToIntegralValue(bd2).multiply(bd2)));
        System.out.println("bd1/bd2的余数: " + bd1.remainder(bd2));
        //取商和余,即bd1.divideToIntegralValue(bd2)与bd1.remainder(bd2)
        System.out.println("bd1 / bd2 = " + bd1.divideAndRemainder(bd2)[0] +
                "--" + bd1.divideAndRemainder(bd2)[1]);
        //比较大小,也可以用max()和min()
        if(bd1.compareTo(bd2) > 0)

            System.out.println("bd1 is greater than bd2");

        else if(bd1.compareTo(bd2) == 0)

            System.out.println("bd1 is equal to bd2");

        else if(bd1.compareTo(bd2) < 0)

            System.out.println("bd1 is lower than bd2");
        //末位数据精度
        System.out.println("bd1的末位数据精度:  " + bd1.ulp());
    }



    // 100吉的数据
    static void testNumber(){
        BigInteger bigInteger=new BigInteger("10000000000000000000");
        //Long L1=10000000000000000000L; //long 顶不住了, 最多到922京
        BigDecimal bigDecimal =new BigDecimal("10000000000000000000.000");
        System.out.println("bigInteger:"+bigInteger);
        System.out.println("bigDecimal:"+bigDecimal);
    }

    public static void main(String[] args){
        //issueOfDoubleFloat();
        //bigIntegerDemo();
        bigDecimalDemo();
        //doExercise();

    }

}




