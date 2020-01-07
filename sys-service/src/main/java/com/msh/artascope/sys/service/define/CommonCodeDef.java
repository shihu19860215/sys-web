package com.msh.artascope.sys.service.define;


import com.msh.frame.client.common.CommonCode;

public class CommonCodeDef extends CommonCode {
    public static CommonCode NO_USER = new CommonCodeDef(400110, "用户不存在");
    public static CommonCode PASSWORD_ERROR = new CommonCodeDef(400112, "密码错误");
    public static CommonCode USERNAME_PASSWORD_ERROR = new CommonCodeDef(400113, "用户名和密码都不能为空");
    public static CommonCode USER_DISABLE = new CommonCodeDef(400114, "用户已被禁用");
    public static CommonCode NO_SYSTEM =  new CommonCodeDef(400115, "该用户没有可已使用的系统");

    private CommonCodeDef(Integer code, String message) {
        super(code, message);
    }
}
