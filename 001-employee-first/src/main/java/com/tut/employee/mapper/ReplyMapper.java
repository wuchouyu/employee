package com.tut.employee.mapper;

import com.tut.employee.model.Reply;

public interface ReplyMapper {
    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer rid);
}