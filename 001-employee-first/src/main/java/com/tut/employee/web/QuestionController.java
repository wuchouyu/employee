package com.tut.employee.web;

import com.tut.employee.model.JwtUser;
import com.tut.employee.model.Question;
import com.tut.employee.model.Result;
import com.tut.employee.utils.JwtTokenUtils;
import com.tut.employee.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/addQuestion")
    public Result addQuestion(@RequestBody Question question){
        return questionService.addQusetion(question);
    }

    @RequestMapping(value = "/selectQuestionBySid")
    public Result selectPositionBySid(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return questionService.selectBySid(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/selectQuestionByCid")
    public Result selectPositionByCid(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return questionService.selectByCid(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/selectQuestionByQid")
    public Result selectPositionByqid(Integer qid){
        return questionService.selectByPrimaryKey(qid);
    }
}
