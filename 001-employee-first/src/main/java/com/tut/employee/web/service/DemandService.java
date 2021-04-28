package com.tut.employee.web.service;

import com.tut.employee.model.Demand;
import com.tut.employee.model.Result;

public interface DemandService {
    public Result addDemand(Demand demand);
    public Result selectDemand(Integer sid);
    public Result updateDemand(Demand demand);
    public Result queryDemand(String province,String profession,String job);
}
