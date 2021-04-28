package com.tut.employee.web;

import com.tut.employee.mapper.UserMapper;
import com.tut.employee.model.Result;
import com.tut.employee.model.User;
import com.tut.employee.utils.JwtTokenUtils;
import com.tut.employee.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;


@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

//    @RequestMapping(value = "/addUser")
//    public Result addUser(Integer cid){
//        User user = new User();
//        user.setUser_id(cid);
//        user.setPassword(cid.toString());
//        return userService.addUser(user);
//    }

    @RequestMapping(value = "/updateUser")
    public Result updateUser(HttpServletRequest request,@RequestParam("password") String password){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUser_id(Integer.valueOf(JwtTokenUtils.getUserId(token)));
        user.setPassword(encoder.encode(password));
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/login")
    public Result selectUser(@RequestBody User user){
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("kfs");
        result.setDetail(user);
        return result;
    }

}
