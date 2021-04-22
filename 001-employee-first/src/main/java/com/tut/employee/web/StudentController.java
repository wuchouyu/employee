package com.tut.employee.web;

import com.tut.employee.model.Result;
import com.tut.employee.model.Student;
import com.tut.employee.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/addStudent")
    public Result addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @RequestMapping(value = "/deleteStudent")
    public Result deleteStudent(Integer sid){
        return  studentService.deleteStudent(sid);
    }

    @RequestMapping(value = "/selectStudent")
    public Result selectStudent(Integer sid){
        return studentService.selectStudent(sid);
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
