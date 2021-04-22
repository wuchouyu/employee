package com.tut.employee.mapper;

import ch.qos.logback.core.util.InvocationGate;
import com.tut.employee.model.Position;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer pid);

    List<String> selectName();

    List<Position> selectByName(String name);

    List<Position> selectByCid(Integer cid);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKeyWithBLOBs(Position record);

    int updateByPrimaryKey(Position record);

    int updateState(Integer rid);
}