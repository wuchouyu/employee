<<<<<<< HEAD
package com.tut.employee.web;

import com.tut.employee.model.Reply;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/addReply")
    public Result addReply(@RequestBody Reply reply){
        return replyService.addReply(reply);
    }

    @RequestMapping(value = "/selectReply")
    public Result selectReply(Integer qid){
        System.out.println(qid);return replyService.selectReplyByPrimaryKey(qid);
    }
}
=======
package com.tut.employee.web;

import com.tut.employee.model.Reply;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/addReply")
    public Result addReply(@RequestBody Reply reply){
        return replyService.addReply(reply);
    }

    @RequestMapping(value = "/selectReply")
    public Result selectReply(Integer qid){
        System.out.println(qid);return replyService.selectReplyByPrimaryKey(qid);
    }
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
