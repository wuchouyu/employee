package com.tut.employee.web;

import com.tut.employee.model.Company;
import com.tut.employee.model.Result;
import com.tut.employee.utils.JwtTokenUtils;
import com.tut.employee.web.service.CompanyService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/addCompany")
    public Result addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }


    @RequestMapping(value = "/updateCompany")
    public Result updateCompany(HttpServletRequest request, @RequestBody Company company){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        company.setCid(Integer.valueOf(JwtTokenUtils.getUserId(token)));
        return companyService.updateCompany(company);
    }

    @RequestMapping(value = "/selectCompany")
    public Result selectCompany(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return companyService.selectByPrimaryKey(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/selectAllCompany")
    public Result selectAllCompany(){
        return companyService.selectAllCompany();
    }

    @RequestMapping(value = "/queryCompany")
    public Result queryCompany(String cname){
        return companyService.queryCompany(cname);
    }
}
