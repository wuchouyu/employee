<<<<<<< HEAD
package com.tut.employee.web.service;

import com.tut.employee.model.Company;
import com.tut.employee.model.Result;

public interface CompanyService {
    public Result addCompany(Company company);
    public Result deleteCompany(Integer cid);
    public Result selectByPrimaryKey(Integer cid);
    public Result updateCompany(Company company);
    public Result selectAllCompany();
    public Result queryCompany(String cname);
    public Company selectCompanyByShxx(String shxx);
=======
package com.tut.employee.web.service;

import com.tut.employee.model.Company;
import com.tut.employee.model.Result;

public interface CompanyService {
    public Result addCompany(Company company);
    public Result deleteCompany(Integer cid);
    public Result selectByPrimaryKey(Integer cid);
    public Result updateCompany(Company company);
    public Result selectAllCompany();
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
}