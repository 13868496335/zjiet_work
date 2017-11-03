package com.zjiet.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 校验异常
 * @author: Double
 * 2017/10/26 14:01
 */
public class ValidateException extends RuntimeException{

    private static final long serialVersionUID = 7207451175263593487L;

    private List<ObjectError> errors;

    public ValidateException(List<ObjectError> errors) {
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

}
