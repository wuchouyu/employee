package com.tut.employee.mapper;

import com.tut.employee.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer user_id);

    List<Integer> selectByRole(String role);

    int updateByPrimaryKey(User user);

    int updateRole(Integer userId);
}