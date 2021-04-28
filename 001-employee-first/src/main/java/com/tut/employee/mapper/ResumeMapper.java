package com.tut.employee.mapper;

import com.tut.employee.model.Resume;

public interface ResumeMapper {
    Resume select(Integer sid);

    int insert(Resume record);

    int updateByPrimaryKeySelective(Resume record);

}