package com.zjiet.utils;

import com.zjiet.VO.ResultVO;

import javax.validation.groups.Default;

/**
 * @author: linlc
 * 2017/10/23 14:50
 */
public class ResultVOUtil {


    //返回成功信息！
    public static ResultVO SUCCESS(Object object){
        return  SUCCESS(object,"操作成功！");
    }

    public static ResultVO SUCCESS(Object object,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode("000");
        resultVO.setData(object);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO SUCCESS(){
        return  SUCCESS(null);
    }


    //返回失败信息
    public static ResultVO Error(String msg,String code){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
