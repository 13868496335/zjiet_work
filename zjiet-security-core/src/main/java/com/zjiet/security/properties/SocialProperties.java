package com.zjiet.security.properties;

import lombok.Data;

/**
 * 重写社交工具类
 * @author: Double
 * 2017/11/1 19:21
 */

@Data
public class SocialProperties {

    private String  filterProcessesUrl = "/url" ;

    private QQProperties qq = new QQProperties();

    private WeixinProperties weixin = new WeixinProperties();

    SocialProperties(){}

    SocialProperties(String Url ,QQProperties qq ,WeixinProperties weixin){
        setQq(qq);
        setFilterProcessesUrl(filterProcessesUrl);
        setWeixin(weixin);
    }

}
