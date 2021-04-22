package com.tut.employee.web.service;

import com.tut.employee.model.JobSeeker;
import com.tut.employee.model.Result;

public interface JobSeekerService {
    public Result addJobSeeker(JobSeeker jobSeeker);
    public Result deleteSeeker(Integer jid);
    public Result selectJobSeekerByCid(Integer cid);
    public Result selectJobSeekerBySid(Integer sid);
    public Result updateJobSeeker(JobSeeker jobSeeker);
}
