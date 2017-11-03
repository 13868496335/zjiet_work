package com.zjiet.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全配置
 * @author: Double
 * 2017/11/2 12:36
 */

@Data
@ConfigurationProperties(prefix = "com.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private SocialProperties social = new SocialProperties();



}
