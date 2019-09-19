package com.java8lambda;

import java.util.function.Supplier;

/**
 * Created by admin on 2019/5/13.
 */
public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest lambdaTest=new LambdaTest();
        Supplier<String> supplier = () -> "special type value";
        String s = supplier.get();
        System.out.println(s);
    }


}













