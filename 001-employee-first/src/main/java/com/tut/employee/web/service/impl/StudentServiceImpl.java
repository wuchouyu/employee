<<<<<<< HEAD
package com.tut.employee.web.service.impl;

import com.github.javafaker.Faker;
import com.tut.employee.mapper.StudentMapper;
import com.tut.employee.model.Company;
import com.tut.employee.model.Result;
import com.tut.employee.model.Student;
import com.tut.employee.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result addStudent(Student student) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Student c = studentMapper.selectByPrimaryKey(student.getSid());
            int i = -1;

            if (c == null) {
                i = studentMapper.insert(student);
            }

            if (i > 0) {
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(student);
            }
            else {
                result.setMsg("该账号已被注册！");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteStudent(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = studentMapper.deleteByPrimaryKey(sid);

            if(i > 0){
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail(sid);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateStudent(Student student) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        System.out.println(student.getId());
        try{
            System.out.println(student.getPhone());
            studentMapper.updateByPrimaryKey(student);
            result.setMsg("修改成功");
            result.setSuccess(true);
            result.setDetail(student);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectStudent(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Student student = studentMapper.selectByPrimaryKey(sid);

            if(student != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(student);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Result queryStudent(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Student> student = studentMapper.selectStudents(sid);

            if(student.size() > 0){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(student);
            }
            else{
                result.setMsg("无匹配数据");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Result selectAllStudent() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Student> student = studentMapper.selectAll();

            if(student.size() >0){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(student);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Result countByCollege() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Map<String, Object>> list = new ArrayList<>();
            list = studentMapper.countByCollege();
            System.out.println(list.size());
            Map<String,Integer> map = new HashMap<>();
            for (Map<String, Object> kv : list) {
                String key = null;
                Integer value = null;

                for (Map.Entry<String, Object> entry : kv.entrySet()) {
                    if (entry.getKey().equals("key")) {
                        key = (String)entry.getValue();
                    } else {
                        value = (Integer)entry.getValue();
                    }
                    map.put(key, value);
                }
            }
            map.remove(null);
            result.setDetail(map);
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result countByProfession(String college) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Map<String, Object>> list = new ArrayList<>();
            list = studentMapper.countByProfession(college);
            System.out.println(list.size());
            Map<String,Integer> map = new HashMap<>();
            for (Map<String, Object> kv : list) {
                String key = null;
                Integer value = null;

                for (Map.Entry<String, Object> entry : kv.entrySet()) {
                    if (entry.getKey().equals("key")) {
                        key = (String)entry.getValue();
                    } else {
                        value = (Integer)entry.getValue();
                    }
                    map.put(key, value);
                }
            }
            map.remove(null);
            result.setDetail(map);
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
=======
package com.tut.employee.web.service.impl;

import com.github.javafaker.Faker;
import com.tut.employee.mapper.StudentMapper;
import com.tut.employee.model.Company;
import com.tut.employee.model.Result;
import com.tut.employee.model.Student;
import com.tut.employee.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result addStudent(Student student) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Student c = studentMapper.selectByPrimaryKey(student.getSid());
            int i = -1;

            if (c == null) {
                i = studentMapper.insert(student);
            }

            if (i > 0) {
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(student);
            }
            else {
                result.setMsg("该账号已被注册！");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteStudent(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = studentMapper.deleteByPrimaryKey(sid);

            if(i > 0){
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail(sid);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateStudent(Student student) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        System.out.println(student.getId());
        try{
            System.out.println(student.getPhone());
            studentMapper.updateByPrimaryKey(student);
            result.setMsg("修改成功");
            result.setSuccess(true);
            result.setDetail(student);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectStudent(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Student student = studentMapper.selectByPrimaryKey(sid);

            if(student != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(student);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Result queryStudent(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Student> student = studentMapper.selectStudents(sid);

            if(student.size() > 0){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(student);
            }
            else{
                result.setMsg("无匹配数据");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Result selectAllStudent() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Student> student = studentMapper.selectAll();

            if(student.size() >0){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(student);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Result countByCollege() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Map<String, Object>> list = new ArrayList<>();
            list = studentMapper.countByCollege();
            System.out.println(list.size());
            Map<String,Integer> map = new HashMap<>();
            for (Map<String, Object> kv : list) {
                String key = null;
                Integer value = null;

                for (Map.Entry<String, Object> entry : kv.entrySet()) {
                    if (entry.getKey().equals("key")) {
                        key = (String)entry.getValue();
                    } else {
                        value = (Integer)entry.getValue();
                    }
                    map.put(key, value);
                }
            }
            map.remove(null);
            result.setDetail(map);
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result countByProfession(String college) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Map<String, Object>> list = new ArrayList<>();
            list = studentMapper.countByProfession(college);
            System.out.println(list.size());
            Map<String,Integer> map = new HashMap<>();
            for (Map<String, Object> kv : list) {
                String key = null;
                Integer value = null;

                for (Map.Entry<String, Object> entry : kv.entrySet()) {
                    if (entry.getKey().equals("key")) {
                        key = (String)entry.getValue();
                    } else {
                        value = (Integer)entry.getValue();
                    }
                    map.put(key, value);
                }
            }
            map.remove(null);
            result.setDetail(map);
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
