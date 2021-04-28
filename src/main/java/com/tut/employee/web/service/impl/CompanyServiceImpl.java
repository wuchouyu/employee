package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.CompanyMapper;
import com.tut.employee.model.Company;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Result addCompany(@RequestBody Company company) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Company c = companyMapper.selectByPrimaryKey(company.getCid());
            int i = -1;

            if (c == null) {
                i = companyMapper.insert(company);
            }

            if (i > 0) {
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(company);
            }
            else {
                result.setMsg("该账号已被注册！");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteCompany(Integer cid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = companyMapper.deleteByPrimaryKey(cid);

            if(i > 0){
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail(cid);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectByPrimaryKey(Integer cid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Company company = companyMapper.selectByPrimaryKey(cid);

            if(company != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(company);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateCompany( Company company) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = 0;System.out.println(company.getCid());
            i = companyMapper.updateByPrimaryKey(company);

            if(i > 0){
                result.setMsg("修改成功");
                result.setSuccess(true);
                result.setDetail(company);
            }
            else{
                result.setMsg("修改失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectAllCompany() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Company> company = companyMapper.selectAll();

            if(company != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(company);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
