package com.tut.employee.mapper;

import com.tut.employee.model.Question;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer qid);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer qid);

    List<Question> selectBySid(Integer sid);

    List<Question> selectByPid(Integer pid);

    List<Question> selectByCid(Integer cid);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    int updateState(Integer qid);
}