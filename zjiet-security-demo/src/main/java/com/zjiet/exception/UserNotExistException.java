package com.zjiet.exception;

/**
 * 自定义错误    =>   用户不存在异常
 * @author: linlc
 * 2017/10/24 15:47
 */

public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = -6112780192479692859L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
