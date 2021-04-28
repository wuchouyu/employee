package com.tut.employee.mapper;

import com.tut.employee.model.Company;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer cid);

    List<Company> selectAll();

    Company selectByName(String cname);

    List<Company> queryCompany(String cname);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}