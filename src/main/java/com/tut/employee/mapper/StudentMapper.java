package com.tut.employee.mapper;

import com.tut.employee.model.Company;
import com.tut.employee.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    List<Student> selectStudents(Integer sid);

    List<Student> selectAll();

    List<Map<String,Object>> countByCollege();

    List<Map<String,Object>> countByProfession(String college);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}