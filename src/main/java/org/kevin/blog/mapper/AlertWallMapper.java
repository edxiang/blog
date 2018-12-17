package org.kevin.blog.mapper;

import org.kevin.blog.model.AlertWall;

public interface AlertWallMapper {
    int insert(AlertWall record);

    int insertSelective(AlertWall record);

    int updateByPrimaryKey(AlertWall record);

    int deleteByPrimaryKey(String id);

    AlertWall selectByType(Integer type);
}