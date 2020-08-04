package com.sky.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author : wushikai
 * <p>
 * date : 2020-07-31
 */
public class Lam8 {


    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("李小明", true, 18, 1.76, LocalDate.of(2001, 3, 23)));
        studentList.add(new Student("李小明", true, 18, 1.76, LocalDate.of(2001, 3, 23)));
        studentList.add(new Student("张小丽", false, 18, 1.61, LocalDate.of(2001, 6, 3)));
        studentList.add(new Student("王大朋", true, 19, 1.82, LocalDate.of(2000, 3, 11)));
        studentList.add(new Student("陈小跑", false, 17, 1.67, LocalDate.of(2002, 10, 18)));
        //查找身高在1.8米及以上的男生
        List<Student> students = studentList.stream().filter(student -> student.getGender() && student.getHeight() >= 1.8).collect(Collectors.toList());

        //去重
        List<Student> res = studentList.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(  Comparator.comparing( o -> o.getName()  )   )
                ), ArrayList::new)
        );

        Student.printStudents(res);

        //筛选
        res = students.stream().filter(ls -> ls.getName().equals("222")).collect(Collectors.toList());
        //输出查找结果
        Student.printStudents(students);


    }


}

/*
*
Java 8 中的 Stream 是对集合（Collection）对象功能的增强，它专注于对集合对象进行各种非常便利、高效的聚合操作（aggregate
operation），或者大批量数据操作 (bulk data operation)。Stream API 借助于同样新出现的 Lambda
表达式，极大的提高编程效率和程序可读性。同时它提供串行和并行两种模式进行汇聚操作，并发模式能够充分利用多核处理器的优势，使
用 fork/join 并行方式来拆分任务和加速处理过程。通常编写并行代码很难而且容易出错, 但使用 Stream API
无需编写一行多线程的代码，就可以很方便地写出高性能的并发程序。所以说，Java 8 中首次出现的 java.util.stream
是一个函数式语言+多核时代综合影响的产物。
* */
