package com.tut.employee.mapper;

import com.tut.employee.model.Demand;
import com.tut.employee.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface DemandMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Demand record);

    int insertSelective(Demand record);

    Demand selectByPrimaryKey(Integer sid);

    List<Demand> queryDemand(HashMap<String,String> hashMap);

    int updateByPrimaryKeySelective(Demand record);

    int updateByPrimaryKey(Demand record);
}