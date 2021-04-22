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
