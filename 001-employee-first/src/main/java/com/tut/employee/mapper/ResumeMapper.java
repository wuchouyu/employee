<<<<<<< HEAD
package com.tut.employee.mapper;

import com.tut.employee.model.Resume;

public interface ResumeMapper {
    Resume select(Integer sid);

    int insert(Resume record);

    int updateByPrimaryKeySelective(Resume record);

=======
package com.tut.employee.mapper;

import com.tut.employee.model.Resume;

public interface ResumeMapper {
    Resume select(Integer sid);

    int insert(Resume record);

    int updateByPrimaryKeySelective(Resume record);

>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
}