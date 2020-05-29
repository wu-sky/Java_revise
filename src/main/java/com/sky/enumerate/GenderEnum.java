package com.sky.enumerate;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/25/2020
 */

public enum GenderEnum {
    GENDER_MALE("1","男"),
    GENDER_FEMALE("0","女"),
    GENDER_UNKNOW("2","未知");

    private String code;
    private String msg;

    GenderEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(String code) {
        for (GenderEnum b : GenderEnum.values()) {
            if (b.getCode().equalsIgnoreCase(code)) {
                return b.getMsg();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
