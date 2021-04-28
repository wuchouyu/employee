package com.tut.employee.web;

import com.tut.employee.mapper.CompanyMapper;
import com.tut.employee.model.Company;
import com.tut.employee.model.Result;
import com.tut.employee.model.User;
import com.tut.employee.web.service.CompanyService;
import com.tut.employee.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyMapper companyMapper;

    @RequestMapping("/register")
    public Result register(@RequestBody Company company){
        Result result= companyService.addCompany(company);
        System.out.println(company);
        if(result.isSuccess()){
            Company company1 = companyService.selectCompanyByShxx(company.getShxy());
            User user = new User();
            user.setUser_id(company1.getCid());
            user.setPassword(company1.getCid().toString());
            user.setRole("ROLE_TEM");

            result = userService.addUser(user);
            return result;
        }
        return result;
    }

    @RequestMapping("/shenhe")
    public Result shenhe(){
        Result result = new Result();
        result.setSuccess(false);
        try{
            List<Integer> list = userService.selectByRole("ROLE_TEM");
            List<Company> companies = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                Company company = companyMapper.selectByPrimaryKey(list.get(i));
                companies.add(company);
            }
            result.setSuccess(true);
            result.setDetail(companies);
            return result;
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/shtg")
    public Result updateRole(Integer userId){
        return userService.updateRole(userId);
    }

    @RequestMapping("/jj")
    public Result deleteCompany(Integer cid){
        companyMapper.deleteByPrimaryKey(cid);
        return userService.deleteUser(cid);
    }
}
