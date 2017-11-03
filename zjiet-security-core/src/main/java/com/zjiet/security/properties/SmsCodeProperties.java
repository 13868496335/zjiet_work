package com.zjiet.security.properties;

import lombok.Data;

/**
 * Sms短信属性
 * @author: Double
 * 2017/11/1 17:00
 */

@Data
public class SmsCodeProperties {

     private String  url;
     private int  length=6;
     private int  expireIn=60;

     SmsCodeProperties(){}

     SmsCodeProperties(Integer length,Integer expireIn,String url){
          this.url = url;
          this.length = length;
          this.expireIn = expireIn;
     }

}
