package com.softeem.ssm.service.impl;

import com.softeem.ssm.mapper.AuthRoleMapper;
import com.softeem.ssm.mapper.RoleMapper;
import com.softeem.ssm.pojo.AuthRoleExample;
import com.softeem.ssm.pojo.AuthRoleKey;
import com.softeem.ssm.pojo.Role;
import com.softeem.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthRoleMapper authRoleMapper;
    @Override
    public List<Role> findAll() {
        return roleMapper.selectByExample(null);
    }

    @Override
    @Transactional
    public void savaRoleAuthMapping(Integer[] aid, Integer rid) {
        AuthRoleExample authRoleExample = new AuthRoleExample();
        AuthRoleExample.Criteria criteria = authRoleExample.createCriteria();
        criteria.andRidEqualTo(rid);
       authRoleMapper.deleteByExample(authRoleExample);
           for (Integer a : aid) {
               AuthRoleKey authRoleKey = new AuthRoleKey();
               authRoleKey.setAid(a);
               authRoleKey.setRid(rid);
               authRoleMapper.insert(authRoleKey);
           }

    }

    /**
     * 通过角色主键id 查找所有权限的id
     * @param rid
     * @return
     */
    @Override
    public String findRoleByRid(Integer rid) {
        AuthRoleExample authRoleExample = new AuthRoleExample();
        AuthRoleExample.Criteria criteria = authRoleExample.createCriteria();
        criteria.andRidEqualTo(rid);
        List<AuthRoleKey> authRoleKeys = authRoleMapper.selectByExample(authRoleExample);
        ArrayList<Integer> list = new ArrayList<>();
        for (AuthRoleKey authRoleKey : authRoleKeys) {

          list.add(authRoleKey.getAid());
        }
        return list.toString();
    }
}
