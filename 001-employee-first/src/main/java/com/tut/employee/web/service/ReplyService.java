package com.tut.employee.web.service;

import com.tut.employee.model.Reply;
import com.tut.employee.model.Result;

public interface ReplyService {
    public Result addReply(Reply reply);
    public Result selectReplyByPrimaryKey(Integer rid);
}
