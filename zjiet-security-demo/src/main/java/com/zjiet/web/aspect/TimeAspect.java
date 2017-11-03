package com.zjiet.web.aspect;

import com.zjiet.constant.CookieConstant;
import com.zjiet.exception.ValidateException;
import com.zjiet.utils.CookieUtil;
import com.zjiet.utils.ResultVOUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * 切面
 * @author: linlc
 * 2017/10/25 10:07
 */
@Aspect
@Component
public class TimeAspect {

    @Pointcut(value="execution(* com.zjiet.web.controller.ProductController.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public  Object handlerControllerMethod(ProceedingJoinPoint point) throws Throwable{

        System.out.println("进入切片");

        Object[] args = point.getArgs();

        //如果  有错误信息   ，则抛出校验异常
        for (Object arg : args) {
            if(arg instanceof BindingResult) {
                BindingResult errors = (BindingResult)arg;
                if (errors.hasErrors()) {
                    throw new ValidateException(errors.getAllErrors());
                }
            }
        }

        /**
         * 未登录，拦截机制 ，判断cooike是否有 有效值
         */
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);

        if(cookie==null){
            System.out.println("无效操作");
            return  ResultVOUtil.Error("未登录，非法操作","400");
        }

        Object object = point.proceed();


        return object;
    }

}
