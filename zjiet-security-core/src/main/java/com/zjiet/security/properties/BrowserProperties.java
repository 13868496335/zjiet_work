package com.zjiet.security.properties;

import lombok.Data;

/**
 * 浏览器属性
 * @author: Double
 * 2017/11/2 12:40
 */

@Data
public class BrowserProperties {

    private SessionProperties session = new SessionProperties();

    private String signUpUrl = "/imooc-signUp.html";

    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    private LoginResponseType loginType = LoginResponseType.JSON;

    private int rememberMeSeconds = 3600;

}
