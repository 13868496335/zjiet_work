package com.zjiet.utils;

import org.apache.commons.collections.map.HashedMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * cookie 工具类
 * @author: linlc
 * 2017/10/25 11:34
 */

public class CookieUtil {

    /**
     * 存数据  cookie
     * @param response
     * @param key
     * @param value
     * @param maxAge
     */
    public  static  void  set(HttpServletResponse response ,
                              String key ,
                              String value ,
                              int maxAge){

        Cookie cookie = new Cookie(key,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }



    /**
     * 读取指定的某个cookie
     * @param request
     * @param name
     * @return
     */
    public  static Cookie get(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap =readCookieMap(request);
        if(cookieMap!=null){
            return cookieMap.get(name);
        }
        return null;
    }



    /**
     * 获取有效的cookie
     * @param request
     * @return
     */

    public  static Map<String , Cookie>  readCookieMap(HttpServletRequest request){

        Map<String ,Cookie> cookieMap = new HashedMap();
        Cookie[] cookies =request.getCookies();
       if(cookies!=null){
           Arrays.stream(cookies).forEach(cookie -> cookieMap.put(cookie.getName(),cookie));
       }
        return cookieMap;
    }
}
