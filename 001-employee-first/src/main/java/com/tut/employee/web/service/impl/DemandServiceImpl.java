package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.DemandMapper;
import com.tut.employee.model.Demand;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    private DemandMapper demandMapper;

    @Override
    public Result addDemand(Demand demand) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        try {
            Demand d = demandMapper.selectByPrimaryKey(demand.getSid());

            if(d != null){
                result.setMsg("该用户求职需求信息已存在");
                return  result;
            }
            else{
                int i = -1;
                i = demandMapper.insert(demand);

                if(i > 0){
                    result.setMsg("添加求职需求成功");
                    result.setDetail(demand);
                    result.setSuccess(true);
                    return result;
                }
            }

        } catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectDemand(Integer sid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        try {
            Demand demand = demandMapper.selectByPrimaryKey(sid);

            if(demand != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(demand);
                return result;
            }
            else {
                result.setMsg("无数据");
                result.setSuccess(false);
                return result;
            }


        } catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateDemand(Demand demand) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        try {
            Demand d = demandMapper.selectByPrimaryKey(demand.getSid());

            if(d == null){
                result.setMsg("该用户为添加求职需求");
                return  result;
            }
            else{
                int i = -1;
                i = demandMapper.updateByPrimaryKey(demand);

                if(i > 0){
                    result.setMsg("修改求职需求成功");
                    result.setDetail(demand);
                    result.setSuccess(true);
                    return result;
                }
            }

        } catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result queryDemand(String province, String profession, String job) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("province",province);
        hashMap.put("profession",profession);
        hashMap.put("job",job);
        try {
            List<Demand> demands = demandMapper.queryDemand(hashMap);

            if(demands != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(demands);
                return result;
            }
            else {
                result.setMsg("无数据");
                result.setSuccess(false);
                return result;
            }


        } catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
