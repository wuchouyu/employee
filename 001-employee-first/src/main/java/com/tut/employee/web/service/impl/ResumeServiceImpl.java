<<<<<<< HEAD
package com.tut.employee.web.service.impl;

import com.github.javafaker.Bool;
import com.tut.employee.mapper.JobSeekerMapper;
import com.tut.employee.mapper.ResumeMapper;
import com.tut.employee.mapper.StudentMapper;
import com.tut.employee.model.JobSeekerKey;
import com.tut.employee.model.Result;
import com.tut.employee.model.Resume;
import com.tut.employee.model.Student;
import com.tut.employee.web.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private JobSeekerMapper jobSeekerMapper;

    @Override
    public Result addResume(MultipartFile file, Integer sid) {
        Result result = new Result();
        result.setMsg(null);
        result.setSuccess(false);

        //判断是否已有简历
        Boolean flag = false;
        Resume r = resumeMapper.select(sid);
        if(r != null){
            flag = true;
            //删除已有简历
            File file1 = new File(r.getPath());
            if(!file1.delete()){
                result.setMsg("添加失败");
                return result;
            }
        }

        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //指定上传的位置为 d:/upload/
            String path = "E://work1//resume/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            //获取上传时的文件名
            String fileName = file.getOriginalFilename();
            //注意是路径+文件名
            File targetFile = new File(path + fileName);
            //如果之前的 String path = "d:/upload/" 没有在最后加 / ，那就要在 path 后面 + "/"

            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }

            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
            FileCopyUtils.copy(inputStream, outputStream);

            //插入数据库记录
            int i = -1;
            Resume resume = new Resume();
            resume.setSid(sid);
            resume.setPath(path + fileName);

            //修改简历
            if(flag){
                i = resumeMapper.updateByPrimaryKeySelective(resume);
            }
            //新添简历
            else {
                i = resumeMapper.insert(resume);
            }

            //告诉页面上传成功了
            if(i > 0){
                result.setMsg("上传成功");
                result.setSuccess(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉页面失败
            result.setMsg("上传失败");
            result.setSuccess(false);
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Result selectResume(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Resume resume = resumeMapper.select(sid);

            if(resume != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(resume.getPath().substring(18));
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result downloadResume(HttpServletRequest request, HttpServletResponse response, JobSeekerKey jobSeekerKey) {
        Resume resume = resumeMapper.select(jobSeekerKey.getSid());
        if (resume != null) {
            File file = new File(resume.getPath());
            if (file.exists()) {
                Student student = studentMapper.selectByPrimaryKey(resume.getSid());
                response.setContentType("application/force-download");// 设置强制下载不打开
                System.out.println(student.getSname());
                try {
                    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(student.getSname(), "utf-8"));// 设置文件名
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    jobSeekerMapper.updateByPrimaryKey(jobSeekerKey);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;

    }
}
=======
package com.tut.employee.web.service.impl;

import com.github.javafaker.Bool;
import com.tut.employee.mapper.ResumeMapper;
import com.tut.employee.mapper.StudentMapper;
import com.tut.employee.model.Result;
import com.tut.employee.model.Resume;
import com.tut.employee.model.Student;
import com.tut.employee.web.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result addResume(MultipartFile file, Integer sid) {
        Result result = new Result();
        result.setMsg(null);
        result.setSuccess(false);

        //判断是否已有简历
        Boolean flag = false;
        Resume r = resumeMapper.select(sid);
        if(r != null){
            flag = true;
            File file1 = new File(r.getPath());
            if(!file1.delete()){
                result.setMsg("添加失败");
                return result;
            }
        }

        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //指定上传的位置为 d:/upload/
            String path = "E://work1//resume/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            //获取上传时的文件名
            String fileName = file.getOriginalFilename();
            //注意是路径+文件名
            File targetFile = new File(path + fileName);
            //如果之前的 String path = "d:/upload/" 没有在最后加 / ，那就要在 path 后面 + "/"

            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }

            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
            FileCopyUtils.copy(inputStream, outputStream);

            //插入数据库记录
            int i = -1;
            Resume resume = new Resume();
            resume.setSid(sid);
            resume.setPath(path + fileName);

            if(flag){
                i = resumeMapper.updateByPrimaryKeySelective(resume);
            }
            else {
                i = resumeMapper.insert(resume);
            }

            //告诉页面上传成功了
            if(i > 0){
                result.setMsg("上传成功");
                result.setSuccess(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉页面失败
            result.setMsg("上传失败");
            result.setSuccess(false);
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Result selectResume(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Resume resume = resumeMapper.select(sid);

            if(resume != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(resume);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result downloadResume(HttpServletRequest request, HttpServletResponse response, Integer sid) {
        Resume resume = resumeMapper.select(sid);
        if (resume != null) {
            File file = new File(resume.getPath());
            if (file.exists()) {
                Student student = studentMapper.selectByPrimaryKey(resume.getSid());
                response.setContentType("application/force-download");// 设置强制下载不打开
                System.out.println(student.getSname());
                try {
                    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(student.getSname(), "utf-8"));// 设置文件名
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;

    }
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
