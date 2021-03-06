<<<<<<< HEAD
package com.tut.employee.web;

import com.tut.employee.model.Employment;
import com.tut.employee.model.Result;
import com.tut.employee.utils.JwtTokenUtils;
import com.tut.employee.web.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"http://192.168.43.94:8080", "null"})
@RestController
public class EmploymentController {

    @Autowired
    private EmploymentService employmentService;

    @RequestMapping(value = "/addEmployment")
    public Result addEmployment(@RequestBody Employment employment){
        return employmentService.addEmployment(employment);
    }

    @RequestMapping(value = "/deleteEmployment")
    public Result deleteEmployment(Integer sid){
        return employmentService.deleteEmployment(sid);
    }

    @RequestMapping(value = "/selectAllEmployment")
    public Result selectAll(){
        return employmentService.selectEmployment();
    }

    @RequestMapping(value = "/selectEmployment")
    public Result selectBySid(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return employmentService.selectEmploymentBySid(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/countByCollege")
    public Result countByCollege(){
        return employmentService.countByCollege();
    }

    @RequestMapping(value ="/countByProvince")
    public Result countByProvince(){
        return employmentService.countByProvince();
    }

    @RequestMapping(value = "/countByProfession")
    public Result countByProfession(String college){
        return employmentService.countByProfession(college);
    }

    @RequestMapping(value = "/xy_jiuyelv")
    public Result xyJiuyelv(){
        return employmentService.xy_jiuyelv();
    }
}
=======
package com.tut.employee.web;

import com.tut.employee.model.Employment;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://192.168.43.94:8080", "null"})
@RestController
public class EmploymentController {

    @Autowired
    private EmploymentService employmentService;

    @RequestMapping(value = "/addEmployment")
    public Result addEmployment(@RequestBody Employment employment){
        return employmentService.addEmployment(employment);
    }

    @RequestMapping(value = "/deleteEmployment")
    public Result deleteEmployment(Integer sid){
        return employmentService.deleteEmployment(sid);
    }

    @RequestMapping(value = "/selectAllEmployment")
    public Result selectAll(){
        return employmentService.selectEmployment();
    }

    @RequestMapping(value = "/selectEmployment")
    public Result selectBySid(Integer sid){
        return employmentService.selectEmploymentBySid(sid);
    }

    @RequestMapping(value = "/countByCollege")
    public Result countByCollege(){
        return employmentService.countByCollege();
    }

    @RequestMapping(value =" /countByProvince")
    public Result countByProvince(){
        return employmentService.countByProvince();
    }

    @RequestMapping(value = "/countByProfession")
    public Result countByProfession(String college){
        return employmentService.countByProfession(college);
    }

    @RequestMapping(value = "/xy_jiuyelv")
    public Result xyJiuyelv(){
        return employmentService.xy_jiuyelv();
    }
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
