package com.tut.employee.web.service;

import com.tut.employee.model.Result;
import com.tut.employee.model.User;

import java.util.List;

public interface UserService {
    public Result addUser(User user);
    public Result deleteUser(Integer userid);
    public Result updateUser(User user);
    public Result selectUser(User user);
    public Result updateRole(Integer userId);
    public List<Integer> selectByRole(String role);
}
