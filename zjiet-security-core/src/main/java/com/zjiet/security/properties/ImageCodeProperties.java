package com.zjiet.security.properties;

import lombok.Data;

/**
 *
 * 图片code属性
 * @author: Double
 * 2017/11/1 17:26
 */
@Data
public class ImageCodeProperties  extends  SmsCodeProperties{

    private int width = 67;
    private int height = 23;

    ImageCodeProperties(){
        setLength(4);
    }
    ImageCodeProperties(Integer length ,Integer width ,Integer height){
        setLength(length);
        setWidth(width);
        setHeight(height);
    }
}
