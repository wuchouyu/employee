package com.tut.employee.web.service;

import com.tut.employee.model.Company;
import com.tut.employee.model.Result;

public interface CompanyService {
    public Result addCompany(Company company);
    public Result deleteCompany(Integer cid);
    public Result selectByPrimaryKey(Integer cid);
    public Result updateCompany(Company company);
    public Result selectAllCompany();
}