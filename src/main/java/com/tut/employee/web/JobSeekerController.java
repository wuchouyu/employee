package com.tut.employee.web;

import com.tut.employee.model.JobSeeker;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;

    @RequestMapping(value = "/addJobSeeker")
    public Result addJobSeeker(JobSeeker jobSeeker){
        return jobSeekerService.addJobSeeker(jobSeeker);
    }

    @RequestMapping(value = "/selectJobSeekerBySid")
    public Result selectJobSeekerBySid(Integer sid){
        return jobSeekerService.selectJobSeekerBySid(sid);
    }

    @RequestMapping(value = "/selectJobSeekerByCid")
    public Result selectJobSeekerByCid(Integer cid){
        return jobSeekerService.selectJobSeekerByCid(cid);
    }
}
