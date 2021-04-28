package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.UserMapper;
import com.tut.employee.model.Result;
import com.tut.employee.model.User;
import com.tut.employee.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result addUser(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        System.out.println(user.getUser_id());
        try {
            User u = userMapper.selectByPrimaryKey(user.getUser_id());
            int i = -1;

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            user.setPassword(encoder.encode(user.getPassword()));

            if (u == null) {
                i = userMapper.insertSelective(user);
            }else {
                result.setMsg("该账号已被注册！");
                result.setSuccess(false);
                return result;
            }

            if (i > 0) {
                result.setMsg("注册成功，等待管理员审核。");
                result.setSuccess(true);
                result.setDetail(user);
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteUser(Integer userid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = userMapper.deleteByPrimaryKey(userid);

            if(i > 0){
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail(userid);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateUser(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            userMapper.updateByPrimaryKey(user);
            result.setMsg("修改成功");
            result.setSuccess(true);
            result.setDetail(user);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectUser(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);

        return result;
    }

    @Override
    public Result updateRole(Integer userId) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        try{
            int i = -1;
            i =  userMapper.updateRole(userId);
            if(i > 0){
                result.setMsg("修改成功");
                result.setSuccess(true);
                result.setDetail(userId);
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Integer> selectByRole(String role) {
        return userMapper.selectByRole(role);
    }
}
