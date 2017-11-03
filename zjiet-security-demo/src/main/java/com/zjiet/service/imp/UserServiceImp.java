package com.zjiet.service.imp;

import com.zjiet.entry.User;
import com.zjiet.repository.UserInfoRepository;
import com.zjiet.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


/**
 * @author: linlc
 * 2017/10/24 17:42
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public List<User> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public User findOne(Integer id) {
        return userInfoRepository.findOne(id);
    }

    @Override
    public List<User> findByLoginDateBefore(Date date) {
        return userInfoRepository.findByBeforeLoginDateBefore(date);
    }

    @Override
    public User registerUserLogin(String account) {
        return userInfoRepository.findByAccount(account);
    }
}
