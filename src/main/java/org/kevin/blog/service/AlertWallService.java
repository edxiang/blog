package org.kevin.blog.service;

import org.kevin.blog.model.AlertWall;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/15/18
 */
public interface AlertWallService {
    int insert(AlertWall record);

    int insertSelective(AlertWall record);

    int updateByPrimaryKey(AlertWall record);

    int updateByType(AlertWall record);

    int deleteByPrimaryKey(String id);

    AlertWall selectByType(Integer type);

    List<AlertWall> findList();
}
