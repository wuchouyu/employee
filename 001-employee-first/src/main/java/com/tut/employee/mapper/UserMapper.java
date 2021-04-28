<<<<<<< HEAD
package com.tut.employee.mapper;

import com.tut.employee.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer user_id);

    List<Integer> selectByRole(String role);

    int updateByPrimaryKey(User user);

    int updateRole(Integer userId);
=======
package com.tut.employee.mapper;

import com.tut.employee.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKey(User user);
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
}