package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.CompanyMapper;
import com.tut.employee.mapper.QuestionMapper;
import com.tut.employee.mapper.ResumeMapper;
import com.tut.employee.model.Question;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Result addQusetion(Question question) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        question.setState("未回复");
        question.setCname(companyMapper.selectByPrimaryKey(question.getCid()).getCname());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        question.setTime(date);
        try {
            int i = -1;
            i = questionMapper.insertSelective(question);

            if (i > 0) {
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(question);
            }
            else {
                result.setMsg("提交问题失败");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteQuestion(Integer qid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = questionMapper.deleteByPrimaryKey(qid);

            if(i > 0){
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail(qid);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectBySid(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
           List<Question> questions = questionMapper.selectBySid(sid);

            if(questions != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(questions);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectByCid(Integer cid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Question> questions = questionMapper.selectByCid(cid);

            if(questions != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(questions);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectByPrimaryKey(Integer qid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Question> questions = questionMapper.selectBySid(qid);

            if(questions != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(questions);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateState(Integer qid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = 0;
            i = questionMapper.updateState(qid);

            if(i > 0){
                result.setMsg("修改成功");
                result.setSuccess(true);
                result.setDetail(qid);
            }
            else{
                result.setMsg("修改失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
