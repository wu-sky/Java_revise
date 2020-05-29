package com.sky.properties;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

/**
 * @author：吴世凯 邮箱：
 * 日期：2020/4/30
 */
public class PropertiesUtils {


/*

类Properties

类Properties存在于java.util包下

继承结构如：

java.lang.Object

　　|_ java.uil.Dictionary<K,V>

　　　　|_ java.util.Hashtable<Object,Object>

　　　　　　|_ java.util.Properties

已实现的主要接口：

Serializable, Cloneable, Map<Object, Object>

直接子类：

Provider

Properties直接继承自Hashtable那么它的数据结构也和Hashtable一样属于键值对形式如：username="lay"，
不过不同的是，Properties的键和值都是String类型。所以，
虽然Properties继承了Hashtable后可以使用put和putAll方法，但是不被建议使用。因为这两个方法允许插入非String类型

*/



    public static void main(String[] args) {
        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("./test.properties");
        InputStream inputStream=null;
        Properties properties = new Properties();
        try {
            inputStream=new FileInputStream(new File("src/main/java/com/sky/properties/test.properties"));
            //从流中获取属性kv, 为了避免乱码, 必须来个缓冲
            Reader reader= new InputStreamReader(inputStream, "utf-8");
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String property = properties.getProperty("spring.devtools.restart.enabled");
        System.out.println("property=" + property);
        Enumeration<?> enumerations = properties.propertyNames();
        System.out.println("第一种遍历方式:");
        while (enumerations.hasMoreElements()){
            Object o = enumerations.nextElement();
            System.out.print("o.toString() = " + o.toString() +"  ");
            String propertyValue = properties.getProperty(o.toString());
            System.out.print("propertyValue = " + propertyValue+ "\n");
        }
        Set<String> keySet =properties.stringPropertyNames();
        System.out.println("第二种遍历方式:");
        for (String key: keySet){
            System.out.print("key=" + key);
            System.out.println("     value=" + properties.getProperty(key));
        }
    }

}
