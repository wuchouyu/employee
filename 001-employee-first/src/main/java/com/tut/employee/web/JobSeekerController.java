package com.tut.employee.web;

import com.tut.employee.mapper.PositionMapper;
import com.tut.employee.mapper.StudentMapper;
import com.tut.employee.model.JobSeeker;
import com.tut.employee.model.Position;
import com.tut.employee.model.Result;
import com.tut.employee.utils.JwtTokenUtils;
import com.tut.employee.web.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping(value = "/addJobSeeker")
    public Result addJobSeeker(HttpServletRequest request, Integer pid){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        JobSeeker jobSeeker = new JobSeeker(Integer.valueOf(JwtTokenUtils.getUserId(token)),pid);
        Position position = positionMapper.selectByPrimaryKey(pid);
        jobSeeker.setCid(position.getCid());
        jobSeeker.setCname(position.getCname());
        jobSeeker.setPname(position.getName());
        jobSeeker.setSname(studentMapper.selectByPrimaryKey(Integer.valueOf(JwtTokenUtils.getUserId(token))).getSname());
        jobSeeker.setState("未查看");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jobSeeker.setTime(sdf.format(date));
        return jobSeekerService.addJobSeeker(jobSeeker);
    }

    @RequestMapping(value = "/selectJobSeekerBySid")
    public Result selectJobSeekerBySid(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return jobSeekerService.selectJobSeekerBySid(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/selectJobSeekerByCid")
    public Result selectJobSeekerByCid(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return jobSeekerService.selectJobSeekerByCid(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }
}
