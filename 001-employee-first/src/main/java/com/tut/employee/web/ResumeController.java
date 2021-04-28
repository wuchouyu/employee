<<<<<<< HEAD
package com.tut.employee.web;

import com.tut.employee.model.JobSeekerKey;
import com.tut.employee.model.Result;
import com.tut.employee.utils.JwtTokenUtils;
import com.tut.employee.web.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping(value = "/uploadResume")
    public Result uploadResume(@RequestParam(value = "file",required = false) MultipartFile myFile,HttpServletRequest request) {
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        System.out.println(tokenHeader);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        System.out.println(token);
        return resumeService.addResume(myFile,Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/selectResume")
    public Result selectResume(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return resumeService.selectResume(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/downloadResume")
    public Result download(HttpServletRequest request, HttpServletResponse response, @RequestBody JobSeekerKey jobSeekerKey){
        return resumeService.downloadResume(request,response,jobSeekerKey);
    }
}
=======
package com.tut.employee.web;

import com.tut.employee.model.Result;
import com.tut.employee.web.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping(value = "/uploadResume")
    public Result uploadResume(@RequestParam(value = "file",required = false) MultipartFile myFile,@RequestParam(value = "sid") Integer sid) {
        return resumeService.addResume(myFile,sid);
    }

    @RequestMapping(value = "downloadResume")
    public Result download(HttpServletRequest request, HttpServletResponse response, Integer sid){
        return resumeService.downloadResume(request,response,sid);
    }
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
