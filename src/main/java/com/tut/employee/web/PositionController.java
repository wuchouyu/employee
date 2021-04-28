package com.tut.employee.web;

import ch.qos.logback.core.util.InvocationGate;
import com.tut.employee.model.Position;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/addPosition")
    public Result addPosition(@RequestBody Position position){
        System.out.println(position.getCid());
        return positionService.addPosition(position);
    }

    @RequestMapping(value = "/deletePosition/{pid}")
    public Result deletePositin(@PathVariable("pid") Integer pid){
        return positionService.deletePosition(pid);
    }

    @RequestMapping(value = "/selectPositin")
    public Result selectPositin(Integer pid){
        return positionService.selectPositionByPrimaryKey(pid);
    }


    @RequestMapping(value = "/selectPositionByCid")
    public Result selectPositionByCid(Integer cid){
        System.out.println(cid);
        return positionService.selectPositionByCid(cid);
    }

    @RequestMapping(value = "/selectPositionName")
    public Result selectPositionName(){
        return positionService.selectPositionName();
    }

    @RequestMapping(value = "selectPositionByName")
    public Result selectPositionByName(String name){
        return positionService.selectPositionByName(name);
    }

    @RequestMapping(value = "/updatePosition")
    public Result updatePosition(@RequestBody Position position){
        return positionService.updatePosition(position);
    }
}
