<<<<<<< HEAD
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
=======
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
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
}