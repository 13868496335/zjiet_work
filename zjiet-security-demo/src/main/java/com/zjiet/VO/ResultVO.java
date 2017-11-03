package com.zjiet.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author: linlc
 * 2017/10/23 14:45
 */

@Data
public class ResultVO<T> {
    private   String code;

    private   String msg;

    private    T    data ;
}
