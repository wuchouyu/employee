<<<<<<< HEAD
package com.tut.employee.mapper;

import com.tut.employee.model.Company;
import com.tut.employee.model.Employment;

import java.util.List;
import java.util.Map;

public interface EmploymentMapper {
    int delete(Integer sid);

    int insert(Employment record);

    int insertSelective(Employment record);

    Employment selectByPrimaryKey(Integer sid);

    List<Employment> selectAll();

    List<Map<String,Object>> countByProvince();

    List<Map<String,Object>> countByCollege();

    List<Map<String,Object>> countByProfession(String College);

    int updateByPrimaryKey(Employment employment);

=======
package com.tut.employee.mapper;

import com.tut.employee.model.Company;
import com.tut.employee.model.Employment;

import java.util.List;
import java.util.Map;

public interface EmploymentMapper {
    int delete(Integer sid);

    int insert(Employment record);

    int insertSelective(Employment record);

    Employment selectByPrimaryKey(Integer sid);

    List<Employment> selectAll();

    List<Map<String,Object>> countByProvince();

    List<Map<String,Object>> countByCollege();

    List<Map<String,Object>> countByProfession(String College);

    int updateByPrimaryKey(Employment employment);

>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
}