package com.sky.enumerate;

/**
 * @author：吴世凯 邮箱：
 * 日期：09/05/2020
 */
public enum WeekDayEnum  {

    MONDAY("周一", 1, "开始上班了"),
    TUESDAY("周2", 2, "累的像条狗"),
    WEDNESDAY("周3", 3, "累的像条狗"),
    THURSDAY("周4", 4, "累的像条狗"),
    FRIDAY("周5", 5, "终于到周五了"),
    SATURDAY("周6", 6, "睡上一天"),
    SUNDAY("周日", 7, "工作没搞完");

    private final String weekDayName;
    private final Integer weekDayNum;
    private final String weekDayDescription;


    WeekDayEnum(String weekDayName, Integer weekDayNum, String weekDayDescription) {
        this.weekDayName = weekDayName;
        this.weekDayNum = weekDayNum;
        this.weekDayDescription = weekDayDescription;
    }

    public String getWeekDayName() {
        return weekDayName;
    }

    public Integer getWeekDayNum() {
        return weekDayNum;
    }

    public String getWeekDayDescription() {
        return weekDayDescription;
    }



/*Enum类的主要方法

values()：返回枚举类型的对象数组;该方法可以很方便地遍历所有的枚举值;
valueOf(String str):可以把一个字符串转为对应的枚举类对象;要求字符串必须是枚举类对象的“名字”;
如不是，会有运行时异常：IllegalArgumentException
toString():返回当前枚举类对象常量的名称*/
    
    public static void main(String[] args) {
        System.out.println("WeekDayEnum.FRIDAY.getClass().getSuperclass().getName() = " + WeekDayEnum.FRIDAY.getClass().getSuperclass().getName());
        System.out.println("WeekDayEnum.FRIDAY.weekDayNum = " + WeekDayEnum.FRIDAY.weekDayNum);
        System.out.println("WeekDayEnum.FRIDAY.weekDayName = " + WeekDayEnum.FRIDAY.weekDayName);
        System.out.println("WeekDayEnum.FRIDAY.weekDayDescription = " + WeekDayEnum.FRIDAY.weekDayDescription);
        WeekDayEnum[] values = WeekDayEnum.values();
        for (WeekDayEnum weekDayEnum: values){
            System.out.println("weekDayEnum.toString() = " + weekDayEnum.toString());
        }

        WeekDayEnum FRIDAY= (WeekDayEnum) WeekDayEnum.valueOf("FRIDAY");
        // WeekDayEnum.FRIDAY.weekDayNum=1; 常量不应该能赋值

    }
}
