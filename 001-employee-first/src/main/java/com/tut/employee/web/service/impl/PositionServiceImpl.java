package com.tut.employee.web.service.impl;

import com.tut.employee.mapper.CompanyMapper;
import com.tut.employee.mapper.PositionMapper;
import com.tut.employee.model.Company;
import com.tut.employee.model.Position;
import com.tut.employee.model.Result;
import com.tut.employee.web.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Result addPosition(Position position) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        System.out.println(position);
        try {
            Company company = companyMapper.selectByPrimaryKey(position.getCid());
            position.setCname(company.getCname());
            int i = -1;
            i = positionMapper.insert(position);
            if (i > 0) {
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(position);
            }
            else {
                result.setMsg("该职位已存在！");
                result.setSuccess(false);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deletePosition(Integer pid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int i = -1;
            i = positionMapper.deleteByPrimaryKey(pid);

            if(i > 0){
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail(pid);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectPositionByPrimaryKey(Integer pid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Position position = positionMapper.selectByPrimaryKey(pid);

            if(position != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(position);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectPositionByName(String name) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Position> positions = positionMapper.selectByName(name);

            if(positions != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(positions);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectPositionByCid(Integer cid) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<Position> positions = positionMapper.selectByCid(cid);

            if(positions != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(positions);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result selectPositionName() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            List<String> names = positionMapper.selectName();

            if(names != null){
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(names);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updatePosition(Position position) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            positionMapper.updateByPrimaryKey(position);
            result.setMsg("修改成功");
            result.setSuccess(true);
            result.setDetail(position);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
