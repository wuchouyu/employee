<<<<<<< HEAD
package com.tut.employee.web.service;

import com.tut.employee.model.Result;
import com.tut.employee.model.User;

import java.util.List;

public interface UserService {
    public Result addUser(User user);
    public Result deleteUser(Integer userid);
    public Result updateUser(User user);
    public Result selectUser(User user);
    public Result updateRole(Integer userId);
    public List<Integer> selectByRole(String role);
}
=======
package com.tut.employee.web.service;

import com.tut.employee.model.Result;
import com.tut.employee.model.User;

public interface UserService {
    public Result addUser(User user);
    public Result deleteUser(Integer userid);
    public Result updateUser(User user);
    public Result selectUser(User user);
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
