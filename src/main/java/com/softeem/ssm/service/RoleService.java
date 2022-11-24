package com.softeem.ssm.service;

import com.softeem.ssm.pojo.Role;
import com.softeem.ssm.pojo.User;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void savaRoleAuthMapping(Integer [] aid, Integer rid);

    String findRoleByRid(Integer rid);
}
