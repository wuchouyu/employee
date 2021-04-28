<<<<<<< HEAD
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
=======
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
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
