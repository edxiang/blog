package org.kevin.blog.service.impl;

import org.kevin.blog.mapper.AlertWallMapper;
import org.kevin.blog.model.AlertWall;
import org.kevin.blog.service.AlertWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kevin.Z
 * @version 12/15/18
 */
@Service(value = "alertWallService")
public class AlertWallServiceImpl implements AlertWallService {
    @Autowired
    private AlertWallMapper alertWallMapper;

    @Override
    public int insert(AlertWall record) {
        return alertWallMapper.insert(record);
    }

    @Override
    public int insertSelective(AlertWall record) {
        return alertWallMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(AlertWall record) {
        return alertWallMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return alertWallMapper.deleteByPrimaryKey(id);
    }

    @Override
    public AlertWall selectByType(Integer type) {
        return alertWallMapper.selectByType(type);
    }
}
