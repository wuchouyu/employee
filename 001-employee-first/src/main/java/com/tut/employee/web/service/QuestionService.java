package com.tut.employee.web.service;

import com.tut.employee.model.Question;
import com.tut.employee.model.Result;

public interface QuestionService {
    public Result addQusetion(Question question);
    public Result deleteQuestion(Integer qid);
    public Result selectBySid(Integer sid);
    public Result selectByCid(Integer cid);
    public Result selectByPrimaryKey(Integer cid);
    public Result updateState(Integer qid);
}
