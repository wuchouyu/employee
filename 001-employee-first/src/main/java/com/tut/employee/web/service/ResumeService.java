<<<<<<< HEAD
package com.tut.employee.web.service;

import com.tut.employee.model.JobSeekerKey;
import com.tut.employee.model.Result;
import com.tut.employee.model.Resume;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface ResumeService {
    Result addResume(MultipartFile file,Integer sid);
    Result selectResume(Integer sid);
    Result downloadResume(HttpServletRequest request, HttpServletResponse response, JobSeekerKey jobSeekerKey);
}
=======
package com.tut.employee.web.service;

import com.tut.employee.model.Result;
import com.tut.employee.model.Resume;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface ResumeService {
    Result addResume(MultipartFile file,Integer sid);
    Result selectResume(Integer sid);
    Result downloadResume(HttpServletRequest request, HttpServletResponse response, Integer sid);
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
