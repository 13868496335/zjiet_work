package com.zjiet.web.controller;

import com.zjiet.VO.ResultVO;
import com.zjiet.constant.CookieConstant;
import com.zjiet.entry.User;
import com.zjiet.exception.UserNotExistException;
import com.zjiet.service.userService.UserService;
import com.zjiet.utils.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author: linlc
 * 2017/10/24 17:45
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询某时间点之前的数据
     * @param date
     * @return
     */
    @ApiOperation(value = "查询某个时间点用户登录信息")
    @GetMapping("/findByDate")
    public ResultVO findByLoginDateBefore(Date date){
        List<User> users = userService.findByLoginDateBefore(date);
        return ResultVOUtil.SUCCESS(users);
    }

    @GetMapping("/registerLogin")
    @ApiOperation(value = "查询用户登录")
    public ResultVO findRegisterLogin(@ApiParam("账号")String account, @ApiParam("密码") String password, HttpSession session, HttpServletRequest request , HttpServletResponse response){

        User user = userService.registerUserLogin(account);

        if(user!=null&&user.getPassword().equals(password)){

            //IP地址
            System.out.println("用户 :"+user.getUsername()+"  登陆点IP地址 :"+IPUtil.getIPUtil(request));
            //设置cookie
            CookieUtil.set(response,CookieConstant.TOKEN, MD5Utils.getPwd(account),CookieConstant.EXPIRE);

            //设置了session
           // session.setAttribute(account,key);

            return ResultVOUtil.SUCCESS(null,"登陆成功");
        }else{
            throw new UserNotExistException("400");
        }

    }
}
