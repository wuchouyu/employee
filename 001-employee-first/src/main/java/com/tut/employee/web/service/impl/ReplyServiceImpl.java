<<<<<<< HEAD
package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.QuestionMapper;
import com.tut.employee.mapper.ReplyMapper;
import com.tut.employee.model.Question;
import com.tut.employee.model.Reply;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public Result addReply(Reply reply) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reply.setTime(sdf.format(date));
        try {
            int i = -1;
            i = replyMapper.insert(reply);

            if (i > 0) {
                //修改问题状态
                questionMapper.updateState(reply.getRid());
                result.setMsg("回复成功");
                result.setSuccess(true);
                result.setDetail(reply);
            }
            else {
                result.setMsg("回复失败");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectReplyByPrimaryKey(Integer rid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Reply reply = replyMapper.selectByPrimaryKey(rid);

            if(reply != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(reply);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
=======
package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.QuestionMapper;
import com.tut.employee.mapper.ReplyMapper;
import com.tut.employee.model.Question;
import com.tut.employee.model.Reply;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public Result addReply(Reply reply) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        Date date = new Date();
        reply.setTime(date);
        try {
            int i = -1;
            i = replyMapper.insert(reply);

            if (i > 0) {
                questionMapper.updateState(reply.getRid());
                result.setMsg("回复成功");
                result.setSuccess(true);
                result.setDetail(reply);
            }
            else {
                result.setMsg("回复失败");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectReplyByPrimaryKey(Integer rid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Reply reply = replyMapper.selectByPrimaryKey(rid);

            if(reply != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(reply);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
