package com.tut.employee.mapper;

import com.tut.employee.model.JobSeeker;

import java.util.List;

public interface JobSeekerMapper {
    int deleteByPrimaryKey(Integer jid);

    int insert(JobSeeker record);

    int insertSelective(JobSeeker record);

    JobSeeker selectByPrimaryKey(Integer jid);

    List<JobSeeker> selectByCid(Integer cid);

    List<JobSeeker> selectBySid(Integer sid);

    int updateByPrimaryKeySelective(JobSeeker record);

    int updateByPrimaryKey(JobSeeker record);
}