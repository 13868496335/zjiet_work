package com.zjiet.web.config;

import com.zjiet.web.filter.MyTimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置 filter bean
 * @author: linlc
 * 2017/10/24 14:29
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    //将MyTimeFilter配置成bean  ，不同配置文件和@Component     =>当前只过滤  : findByStock
    //@Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        MyTimeFilter myTimeFilter = new MyTimeFilter();
        registrationBean.setFilter(myTimeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/findByStock/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

}
