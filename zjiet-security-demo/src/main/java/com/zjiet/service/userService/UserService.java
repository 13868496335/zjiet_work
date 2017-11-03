package com.zjiet.service.userService;

import com.zjiet.entry.User;

import java.util.*;

/**
 * @author: linlc
 * 2017/10/24 17:37
 */

public interface UserService {

      List<User> findAll();

      User findOne(Integer id);

      List<User> findByLoginDateBefore(Date date);

      User registerUserLogin(String account);

}
