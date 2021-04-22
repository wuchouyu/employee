package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.UserMapper;
import com.tut.employee.model.Company;
import com.tut.employee.model.Result;
import com.tut.employee.model.User;
import com.tut.employee.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
                result.setMsg("添加成功");
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
        try{
            User u = userMapper.selectByPrimaryKey(user.getUser_id());

            if(u == null){
                result.setMsg("帐号不存在");
            }
            else{
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);


                if(encoder.matches(user.getPassword(),u.getPassword())){
                    result.setMsg("帐号密码正确");
                    result.setSuccess(true);
                    user.setPassword(null);
                    result.setDetail(user);
                    return result;
                }
                else{
                    result.setMsg("密码错误");
                    result.setSuccess(false);
                }
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
