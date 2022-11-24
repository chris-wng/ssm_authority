package com.softeem.ssm.service.impl;

import com.softeem.ssm.mapper.AuthMapper;
import com.softeem.ssm.pojo.Auth;
import com.softeem.ssm.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;
    @Override
    public List<Auth> findAll() {
        return authMapper.selectByExample(null);
    }
}
