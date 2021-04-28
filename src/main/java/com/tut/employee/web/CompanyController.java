package com.tut.employee.web;

import com.tut.employee.model.Company;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/addCompany")
    public Result addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @RequestMapping(value = "/deleteCompany")
    public Result deleteCompany(Integer cid){
        return companyService.deleteCompany(cid);
    }

    @RequestMapping(value = "/updateCompany")
    public Result updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @RequestMapping(value = "/selectCompany")
    public Result selectCompany(Integer cid){
        return companyService.selectByPrimaryKey(cid);
    }

    @RequestMapping(value = "/selectAllCompany")
    public Result selectAllCompany(){
        return companyService.selectAllCompany();
    }
}
