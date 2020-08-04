package com.sky.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : wushikai
 * <p>
 * date : 2020-07-31
 */
public class Java8Stream {


    public static void main(String[] args) {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();


        /*
        *
        * IntStream、LongStream、DoubleStream。当然我们也可以用 Stream、Stream >、Stream，
        * 但是 boxing 和 unboxing 会很耗时，所以特别为这三种基本数值型提供了对应的 Stream。
        * */
        IntStream.of(new int[]{1, 2, 3}).forEach( i-> System.out.print(i));
        System.out.println();
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print);




    }


}
