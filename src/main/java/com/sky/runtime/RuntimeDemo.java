package com.sky.runtime;

import java.io.IOException;

/**
 * @author : wushikai
 * <p>
 * date : 2020-07-23
 */
public class RuntimeDemo {


    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec(System.getenv("windir")+"\\system32\\shutdown.exe -s -f");
            //shutdown -a 撤销;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
