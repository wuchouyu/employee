<<<<<<< HEAD
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
=======
package com.tut.employee.web;

import com.tut.employee.model.Result;
import com.tut.employee.model.User;
import com.tut.employee.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = {"http://192.168.0.197:8080", "null"})
@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser")
    public Result addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/deleteUser")
    public Result deleteUser(Integer uid){
        return userService.deleteUser(uid);
    }

    @RequestMapping(value = "/updateUser")
    public Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/selectUser")
    @CrossOrigin
    public Result selectUser(@RequestBody User user){
        return userService.selectUser(user);
    }
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
