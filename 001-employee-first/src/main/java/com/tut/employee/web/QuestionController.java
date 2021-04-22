package com.tut.employee.web;

import com.tut.employee.model.Question;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/addQuestion")
    public Result addQuestion(@RequestBody Question question){
        return questionService.addQusetion(question);
    }

    @RequestMapping(value = "/selectQuestionBySid")
    public Result selectPositionBySid(Integer sid){
        return questionService.selectBySid(sid);
    }

    @RequestMapping(value = "/selectQuestionByCid")
    public Result selectPositionByCid(Integer cid){
        return questionService.selectByCid(cid);
    }

    @RequestMapping(value = "/selectQuestionByQid")
    public Result selectPositionByqid(Integer qid){
        return questionService.selectByPrimaryKey(qid);
    }
}
