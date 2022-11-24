package com.softeem.ssm.service.impl;

import com.softeem.ssm.mapper.AuthMapper;
import com.softeem.ssm.mapper.UserMapper;
import com.softeem.ssm.mapper.UserRoleMapper;
import com.softeem.ssm.pojo.*;
import com.softeem.ssm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private AuthMapper authMapper;
   @Autowired
   private UserMapper userMapper;

   @Autowired
   private UserRoleMapper userRoleMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Transactional
    @Override
    public void saveUserRoleMapping(Integer[] rid, Integer uid) {
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUidEqualTo(uid);
        userRoleMapper.deleteByExample(userRoleExample);
        if (rid!=null) {
            for (Integer r : rid) {
                UserRoleKey userRoleKey = new UserRoleKey();
                userRoleKey.setUid(uid);
                userRoleKey.setRid(r);
                userRoleMapper.insert(userRoleKey);
            }
        }
    }

    @Override
    public String findUserByUid(Integer uid) {
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();

        criteria.andUidEqualTo(uid);
        List<UserRoleKey> userRoleKeys = userRoleMapper.selectByExample(userRoleExample);
        ArrayList<Integer> list = new ArrayList<>();
        for (UserRoleKey userRoleKey : userRoleKeys) {

            list.add(userRoleKey.getRid());
        }
        return list.toString();
    }

    @Override
    public UserVo login(User user) {
        if (user==null){
            return null;
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size()>0){
            User myuser = userList.get(0);
            List<Auth> authList = authMapper.findPathByUid(myuser.getUid());
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(myuser,userVo);
           /* userVo.setUid(user.getUid());
            userVo.setAge(user.getAge());
            userVo.setUsername(user.getUsername());
            userVo.setSex(user.getSex());
            userVo.setPassword(user.getPassword());
           */
            userVo.setAuthList(authList);
            return userVo;
        }else{
return null;
        }

    }
}
