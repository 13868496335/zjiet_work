package com.zjiet.security.browser.support;

import lombok.Data;

/**
 * 简单响应
 * @author: Double
 * 2017/10/31 11:38
 */

@Data
public class SimpleResponse {

    private Object context;

    public SimpleResponse(Object context){
        this.context = context ;
    }
}
