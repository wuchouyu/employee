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
