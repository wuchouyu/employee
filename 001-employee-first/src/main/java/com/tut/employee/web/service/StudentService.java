package com.tut.employee.web.service;

import com.tut.employee.model.Result;
import com.tut.employee.model.Student;

public interface StudentService {
    public Result addStudent(Student student);
    public Result deleteStudent(Integer sid);
    public Result updateStudent(Student student);
    public Result selectStudent(Integer sid);
    public Result queryStudent(Integer sid);
    public Result selectAllStudent();
    public Result countByCollege();
    public Result countByProfession(String college);
}
