package com.tut.employee.mapper;

import com.tut.employee.model.JobSeeker;
import com.tut.employee.model.JobSeekerKey;

import java.util.List;

public interface JobSeekerMapper {
    int deleteByPrimaryKey(JobSeekerKey key);

    int insert(JobSeeker record);

    int insertSelective(JobSeeker record);

    JobSeeker selectByPrimaryKey(JobSeekerKey key);

    List<JobSeeker> selectBySid(Integer sid);

    List<JobSeeker> selectByCid(Integer cid);

    int updateByPrimaryKeySelective(JobSeeker record);

    int updateByPrimaryKey(JobSeekerKey record);
}