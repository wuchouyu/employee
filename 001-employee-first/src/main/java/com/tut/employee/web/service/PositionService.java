package com.tut.employee.web.service;

import com.tut.employee.model.Position;
import com.tut.employee.model.Result;

public interface PositionService {
    public Result addPosition(Position position);
    public Result deletePosition(Integer pid);
    public Result selectPositionByPrimaryKey(Integer pid);
    public Result selectPositionByCid(Integer cid);
    public Result selectPositionName();
    public Result selectPositionByName(String name);
    public Result updatePosition(Position position);
}
