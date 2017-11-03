package com.zjiet.security.browser.support;

import lombok.Data;

/**
 * 社会用户信息
 * @author: Double
 * 2017/10/31 11:44
 */

@Data
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;

}
