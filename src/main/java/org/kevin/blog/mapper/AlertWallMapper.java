package org.kevin.blog.mapper;

import org.kevin.blog.model.AlertWall;

import java.util.List;

public interface AlertWallMapper {
    int insert(AlertWall record);

    int insertSelective(AlertWall record);

    int updateByPrimaryKey(AlertWall record);

    int updateByType(AlertWall record);

    int deleteByPrimaryKey(String id);

    AlertWall selectByType(Integer type);

    List<AlertWall> findList();
}