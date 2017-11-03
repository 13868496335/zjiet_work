package com.zjiet.security.social.weixin.api;

/**
 * @author: Double
 * 2017/11/2 18:07
 */
public interface Weixin {
    /* (non-Javadoc)
     * @see com.ymt.pz365.framework.security.social.api.SocialUserProfileService#getUserProfile(java.lang.String)
     */
    WeixinUserInfo getUserInfo(String openId);
}
