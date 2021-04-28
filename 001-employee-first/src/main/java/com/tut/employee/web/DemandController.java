package com.tut.employee.web;

import com.tut.employee.model.Demand;
import com.tut.employee.model.Result;
import com.tut.employee.utils.JwtTokenUtils;
import com.tut.employee.web.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DemandController {

    @Autowired
    private DemandService demandService;

    @RequestMapping(value = "/updateDemand")
    public Result updateDemand(HttpServletRequest request, @RequestBody Demand demand){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        demand.setSid(Integer.valueOf(JwtTokenUtils.getUserId(token)));
        return demandService.updateDemand(demand);
    }

    @RequestMapping(value = "/selectDemand")
    public Result selectDemand(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        return demandService.selectDemand(Integer.valueOf(JwtTokenUtils.getUserId(token)));
    }

    @RequestMapping(value = "/tuijian")
    public Result queryDemand(String province,String profession,String job){
        System.out.println(profession);
        if(job == null && profession == null && province == null){
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg(null);
            result.setDetail(null);
            return  result;
        }
        return demandService.queryDemand(province,profession,job);
    }
}
