package com.zjiet.security.properties;

import lombok.Data;

/**
 * 验证code
 * @author: Double
 * 2017/11/1 16:57
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

    ValidateCodeProperties(){}

    ValidateCodeProperties(ImageCodeProperties image , SmsCodeProperties sms){
        setImage(image);
        setSms(sms);
    }
}
