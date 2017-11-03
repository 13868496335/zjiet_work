package com.zjiet.entry;

import lombok.Data;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体类
 * @author: linlc
 * 2017/10/24 17:10
 */
@Entity
@Data
@Table(name="sys_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String  account;

    private String  password;

    private String  username;

    private String  email;

    private Integer age;

    private String  phone;

    private String  mobile;

    private char    userType;

    private String  photo;

    private String  loginIp;

    private Date  beforeLoginDate;

    private Date  updateDate;

}
