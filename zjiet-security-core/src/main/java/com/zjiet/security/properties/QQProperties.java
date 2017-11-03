package com.zjiet.security.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * 社交配置
 * @author: Double
 * 2017/11/1 19:14
 */

@Data
public class QQProperties extends SocialProperties {

        private String providerId = "qq";


}
