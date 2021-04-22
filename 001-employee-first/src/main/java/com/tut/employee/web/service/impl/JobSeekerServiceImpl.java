package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.JobSeekerMapper;
import com.tut.employee.model.Company;
import com.tut.employee.model.JobSeeker;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    private JobSeekerMapper jobSeekerMapper;

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            int i = -1;

            i = jobSeekerMapper.insertSelective(jobSeeker);

            if (i > 0) {
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(jobSeeker);
            }
            else {
                result.setMsg("添加失败！");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteSeeker(Integer jid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = jobSeekerMapper.deleteByPrimaryKey(jid);

            if(i > 0){
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail(jid);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectJobSeekerByCid(Integer cid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<JobSeeker> jobSeeker = jobSeekerMapper.selectByCid(cid);

            if(jobSeeker != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(jobSeeker);
            }
            else{
                result.setMsg("无数据");
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectJobSeekerBySid(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<JobSeeker> jobSeeker = jobSeekerMapper.selectBySid(sid);

            if(jobSeeker != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(jobSeeker);
            }
            else{
                result.setMsg("无数据");
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public Result updateJobSeeker(JobSeeker jobSeeker) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            jobSeekerMapper.updateByPrimaryKeySelective(jobSeeker);
            result.setMsg("修改成功");
            result.setSuccess(true);
            result.setDetail(jobSeeker);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
