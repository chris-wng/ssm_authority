package com.softeem.ssm.service;

import com.softeem.ssm.pojo.User;
import com.softeem.ssm.pojo.UserVo;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void saveUserRoleMapping(Integer [] rid,Integer uid);

    String findUserByUid(Integer uid);

    UserVo login(User user);
}
