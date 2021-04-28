package com.tut.employee.web;

import com.tut.employee.model.Result;
import com.tut.employee.model.Student;
import com.tut.employee.utils.JwtTokenUtils;
import com.tut.employee.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpHeaders;

@RestController()
public class StudentController {

    @Autowired
    private StudentService studentService;

//    @RequestMapping(value = "/addStudent")
//    public Result addStudent(@RequestBody Student student){
//        return studentService.addStudent(student);
//    }

//    @RequestMapping(value = "/deleteStudent")
//    public Result deleteStudent(Integer sid){
//        return  studentService.deleteStudent(sid);
//    }

    @RequestMapping(value = "/selectStudent")
    public Result selectStudent(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return studentService.selectStudent(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/updateStudent")
    public Result updateStudent(@RequestBody Student student){
        return  studentService.updateStudent(student);
    }

    @RequestMapping(value = "/selectAllStudent")
    public Result selectAllStudent(){
        return studentService.selectAllStudent();
    }

    @RequestMapping(value = "/queryStudent")
    public Result queryStudent(Integer sid){
        return studentService.queryStudent(sid);
    }

}
