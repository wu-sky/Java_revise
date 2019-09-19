package com.referenceType;
/**
 *用户：sky-吴
 *日期：2019/7/15
 * 引用类型:
 * 不new, 引用类型直接赋值就是相当于两个绑定
 * new了, 引用类型赋值就是普通赋值而已了
 *引用传值, 对象的值会改变;
 *如果你不了解引用类型, 你就是那个没文化的国民党军官,
 *抓周树人和我鲁迅有什么关系???
 */
public class Student {
    String name;
    Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //没有返回值, 但是关联到的对象属性就是会变化, 引用传值.
    //相当于对一个对象进行改造
    void changeAge(Student stu){
       //年龄增加10岁
        stu.age+=10;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args){

        Student student1=new Student("学生1" , 22);
        Student student2=student1;

        student1.changeAge(student2);
        //学生2老十岁跟学生1有什么关系
        System.out.println(student1.toString());
    }
}
