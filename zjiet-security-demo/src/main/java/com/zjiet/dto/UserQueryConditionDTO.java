package com.zjiet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户交互
 * @author: Double
 * 2017/10/26 13:46
 */

@Data
public class UserQueryConditionDTO {

    @ApiModelProperty(value = "用户名")
     private  String  username;

    @ApiModelProperty(value = "账号")
     private  String  account;

    @ApiModelProperty(value = "年龄")
     private  String  age;


}
