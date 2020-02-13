package com.mmall.common;

/**
 * @program: mmall
 * @ClassName Const
 * @description 这里用枚举的方法会过于繁重，所以使用内部接口类来吧常量分组
 * @author: Yangh
 * @create: 2020-02-04 16:16
 * @Version 1.0
 **/
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1; //管理员
    }
}
