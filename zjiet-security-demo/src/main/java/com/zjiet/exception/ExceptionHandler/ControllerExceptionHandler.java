package com.zjiet.exception.ExceptionHandler;

import com.zjiet.VO.ResultVO;
import com.zjiet.exception.UserNotExistException;
import com.zjiet.utils.ResultVOUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.Map;

/**
 * 异常处理类
 * @author: linlc
 * 2017/10/24 15:59
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleUserNotExistException(UserNotExistException ex){
       return ResultVOUtil.Error(ex.getMessage(),ex.getId());
    }
}
