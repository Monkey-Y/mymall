package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: mmall
 * @ClassName UserController
 * @description
 * @author: Yangh
 * @create: 2020-02-04 12:00
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * @Author Yangjh
     * @Description //TODO 用户登录接口
     * @Date 12:07 2020-2-4
     * @Param [username, password, session]
     * @return java.lang.Object
     **/
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     * @Author Yangjh
     * @Description //TODO 登出接口
     * @Date 17:14 2020-2-4
     * @Param [session]
     * @return com.mmall.common.ServerResponse<java.lang.String>
     **/
    @RequestMapping(value = "logout.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * @Author Yangjh
     * @Description //TODO 用户注册接口
     * @Date 17:18 2020-2-4
     * @Param [user]
     * @return com.mmall.common.ServerResponse<java.lang.String>
     **/
    @RequestMapping(value = "register.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }

















}
