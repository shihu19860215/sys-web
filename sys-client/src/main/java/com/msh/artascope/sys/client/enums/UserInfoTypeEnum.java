package com.msh.artascope.sys.client.enums;

public enum  UserInfoTypeEnum {
    SUPER_ADMIN(1,"超级管理员"),
    PRIMARY(10,"主账号"),
    GENERAL(100,"普通账号");

    private Integer code;
    private String desc;

    private UserInfoTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
