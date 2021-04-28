<<<<<<< HEAD
package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.EmploymentMapper;
import com.tut.employee.mapper.StudentMapper;
import com.tut.employee.model.*;
import com.tut.employee.web.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmploymentServiceImpl implements EmploymentService {

    @Autowired
    private EmploymentMapper employmentMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Result addEmployment(Employment employment) {

        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Employment e = employmentMapper.selectByPrimaryKey(employment.getSid());
            int i = -1;

            if (e == null) {
                Student student = studentMapper.selectByPrimaryKey(employment.getSid());
                employment.setSname(student.getSname());
                employment.setCollege(student.getCollege());
                employment.setProfession(student.getProfession());
                employment.setSclass(student.getSclass());
                i = employmentMapper.insert(employment);
            }

            if (i > 0) {
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(employment);
            }
            else {
                result.setMsg("已有该学生就业信息！");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteEmployment(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = employmentMapper.delete(sid);

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
    public Result selectEmployment() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Employment> employments = employmentMapper.selectAll() ;

            if(employments != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(employments);
            }
            else{
                result.setMsg("无数据");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectEmploymentBySid(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Employment employment = employmentMapper.selectByPrimaryKey(sid);

            if(employment != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(employment);
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
            list = employmentMapper.countByCollege();
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
//            for(Map.Entry<String,Integer> entry : map.entrySet()){
//                System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
//            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result countByProvince() {
        Result result = new Result();
            result.setSuccess(false);
            result.setDetail(null);
            try{
                List<Map<String, Object>> list = new ArrayList<>();
                list = employmentMapper.countByProvince();
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
            list = employmentMapper.countByProfession(college);
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
    public Result xy_jiuyelv() {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        List<Jiuyelv> l = new ArrayList<>();
        try{
            List<Map<String, Object>> list1 = new ArrayList<>();
            list1 = employmentMapper.countByCollege();
            List<Map<String, Object>> list2 = new ArrayList<>();
            list2 = studentMapper.countByCollege();
            Map<String,Integer> map = new HashMap<>();

            //查询各学院已就业学生人数
            for (Map<String, Object> kv : list1) {
                String key = null;
                Integer value = null;

                for (Map.Entry<String, Object> entry : kv.entrySet()) {
                    if (entry.getKey().equals("key")) {
                        key = (String)entry.getValue();
                    } else {
                        value = (Integer)entry.getValue();
                    }
                }
                map.put(key,value);
            }
            map.remove(null);
            //查询各学院学生数
            for (Map<String, Object> kv : list2) {
                String key = null;
                Integer value = null;

                for (Map.Entry<String, Object> entry : kv.entrySet()) {
                    if (entry.getKey().equals("key")) {
                        key = (String)entry.getValue();
                        System.out.println(key);
                    } else {
                        value = (Integer)entry.getValue();
                    }
                }

                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if(key.equals(entry.getKey()) ){
                        Jiuyelv jiuyelv = new Jiuyelv();
                        jiuyelv.setCollege(key);
                        jiuyelv.setValue1(entry.getValue());
                        jiuyelv.setValue2(value- entry.getValue());
                        l.add(jiuyelv);
                    }
                }

            }
            result.setDetail(l);
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

import com.tut.employee.mapper.EmploymentMapper;
import com.tut.employee.mapper.StudentMapper;
import com.tut.employee.model.*;
import com.tut.employee.web.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmploymentServiceImpl implements EmploymentService {

    @Autowired
    private EmploymentMapper employmentMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Result addEmployment(Employment employment) {

        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Employment e = employmentMapper.selectByPrimaryKey(employment.getSid());
            int i = -1;

            if (e == null) {
                Student student = studentMapper.selectByPrimaryKey(employment.getSid());
                employment.setSname(student.getSname());
                employment.setCollege(student.getCollege());
                employment.setProfession(student.getProfession());
                employment.setSclass(student.getSclass());
                i = employmentMapper.insert(employment);
            }

            if (i > 0) {
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(employment);
            }
            else {
                result.setMsg("已有该学生就业信息！");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteEmployment(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = employmentMapper.delete(sid);

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
    public Result selectEmployment() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Employment> employments = employmentMapper.selectAll() ;

            if(employments != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(employments);
            }
            else{
                result.setMsg("无数据");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectEmploymentBySid(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Employment employment = employmentMapper.selectByPrimaryKey(sid);

            if(employment != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(employment);
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
            list = employmentMapper.countByCollege();
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
//            for(Map.Entry<String,Integer> entry : map.entrySet()){
//                System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
//            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result countByProvince() {
        Result result = new Result();
            result.setSuccess(false);
            result.setDetail(null);
            try{
                List<Map<String, Object>> list = new ArrayList<>();
                list = employmentMapper.countByProvince();
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
            list = employmentMapper.countByProfession(college);
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
    public Result xy_jiuyelv() {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        List<Jiuyelv> l = new ArrayList<>();
        try{
            List<Map<String, Object>> list1 = new ArrayList<>();
            list1 = employmentMapper.countByCollege();
            List<Map<String, Object>> list2 = new ArrayList<>();
            list2 = studentMapper.countByCollege();
            Map<String,Integer> map = new HashMap<>();

            //查询各学院已就业学生人数
            for (Map<String, Object> kv : list1) {
                String key = null;
                Integer value = null;

                for (Map.Entry<String, Object> entry : kv.entrySet()) {
                    if (entry.getKey().equals("key")) {
                        key = (String)entry.getValue();
                    } else {
                        value = (Integer)entry.getValue();
                    }
                }
                map.put(key,value);
            }
            map.remove(null);
            //查询各学院学生数
            for (Map<String, Object> kv : list2) {
                String key = null;
                Integer value = null;

                for (Map.Entry<String, Object> entry : kv.entrySet()) {
                    if (entry.getKey().equals("key")) {
                        key = (String)entry.getValue();
                        System.out.println(key);
                    } else {
                        value = (Integer)entry.getValue();
                    }
                }

                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if(key.equals(entry.getKey()) ){
                        Jiuyelv jiuyelv = new Jiuyelv();
                        jiuyelv.setCollege(key);
                        jiuyelv.setValue1(entry.getValue());
                        jiuyelv.setValue2(value- entry.getValue());
                        l.add(jiuyelv);
                    }
                }

            }
            result.setDetail(l);
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
