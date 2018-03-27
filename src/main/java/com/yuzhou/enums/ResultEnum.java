package com.yuzhou.enums;

public enum ResultEnum {
    UNKNOW_ERROE(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "小学"),
    MIDDLE_SCHOOL(101, "中学");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
