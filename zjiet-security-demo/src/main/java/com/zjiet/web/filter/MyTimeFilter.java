package com.zjiet.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.util.*;
import java.io.IOException;

/**
 *  filter 过滤器
 * @author: linlc
 * 2017/10/24 13:26
 */

//@Component
public class MyTimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myTime  filter  init ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter start time");
        long  time = new Date().getTime();
        filterChain.doFilter(request,response);
        System.out.println("总耗时:"+(new Date().getTime()-time)+"mm");
        System.out.println("filter end time");
    }

    @Override
    public void destroy() {
        System.out.println("myTime  filter   Destroy ");
    }
}
