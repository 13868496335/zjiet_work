package com.zjiet.repository;

import com.zjiet.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

/**
 * 用户__JPA
 * @author: linlc
 * 2017/10/24 17:23
 */

public interface UserInfoRepository extends JpaRepository<User,Integer> {

    /**
     * 获取 某个时间点之前的数据。
     * @param date
     * @return
     */
    List<User> findByBeforeLoginDateBefore(Date date);

    /**
     * 根据用户信息查询，用户详情
     * @param user
     * @return
     */
   // User findUserBy(User user);

    /**
     * 通过账号，验证密码
     * @param account
     * @return
     */
    User findByAccount(String account);

}
