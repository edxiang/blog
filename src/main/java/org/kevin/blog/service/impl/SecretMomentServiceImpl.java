package org.kevin.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kevin.blog.mapper.AlertWallMapper;
import org.kevin.blog.mapper.SecretMomentMapper;
import org.kevin.blog.model.AlertWall;
import org.kevin.blog.model.SecretMoment;
import org.kevin.blog.service.AlertWallService;
import org.kevin.blog.service.SecretMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/15/18
 */
@Service(value = "secretMomentService")
public class SecretMomentServiceImpl implements SecretMomentService {
    @Autowired
    private SecretMomentMapper secretMomentMapper;

    @Override
    public int insert(SecretMoment record) {
        return secretMomentMapper.insert(record);
    }

    @Override
    public List<SecretMoment> findList(Integer limit) {
        return secretMomentMapper.findList(limit);
    }

    @Override
    public PageInfo<SecretMoment> selectByCondition(SecretMoment record,Integer pageNum,Integer pageSize) {
        PageInfo<SecretMoment> page = PageHelper.startPage(pageNum,pageSize).setOrderBy("create_time desc")
                .doSelectPageInfo(() -> secretMomentMapper.selectByCondition(record));
        return page;
    }
}
