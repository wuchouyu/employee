package com.tut.employee.web.service;

import com.tut.employee.model.Employment;
import com.tut.employee.model.Result;

public interface EmploymentService {
    public Result addEmployment(Employment employment);
    public Result deleteEmployment(Integer sid);
    public Result selectEmployment();
    public Result selectEmploymentBySid(Integer sid);
    public Result countByCollege();
    public Result countByProvince();
    public Result countByProfession(String college);
    public Result xy_jiuyelv();
}
