package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.UserMapper;
import com.tut.employee.model.JwtUser;
import com.tut.employee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(s));
        return new JwtUser(user);
    }
}
