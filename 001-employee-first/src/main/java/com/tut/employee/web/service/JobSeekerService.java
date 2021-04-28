<<<<<<< HEAD
package com.tut.employee.web.service;

import com.tut.employee.model.JobSeeker;
import com.tut.employee.model.JobSeekerKey;
import com.tut.employee.model.Result;

public interface JobSeekerService {
    public Result addJobSeeker(JobSeeker jobSeeker);
    public Result selectJobSeekerByCid(Integer cid);
    public Result selectJobSeekerBySid(Integer sid);
    public Result updateJobSeeker(JobSeekerKey jobSeekerKey);
}
=======
package com.tut.employee.web.service;

import com.tut.employee.model.JobSeeker;
import com.tut.employee.model.Result;

public interface JobSeekerService {
    public Result addJobSeeker(JobSeeker jobSeeker);
    public Result deleteSeeker(Integer jid);
    public Result selectJobSeekerByCid(Integer cid);
    public Result selectJobSeekerBySid(Integer sid);
    public Result updateJobSeeker(JobSeeker jobSeeker);
}
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
