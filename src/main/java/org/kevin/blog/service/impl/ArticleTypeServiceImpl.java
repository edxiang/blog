package org.kevin.blog.service.impl;

import org.kevin.blog.mapper.ArticleTypeMapper;
import org.kevin.blog.model.ArticleType;
import org.kevin.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/8/18
 */
@Service(value = "articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public int insert(ArticleType record) {
        return articleTypeMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ArticleType record) {
        return 0;
    }

    @Override
    public List<ArticleType> findList() {
        return articleTypeMapper.findList();
    }

    @Override
    public ArticleType selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public ArticleType select(ArticleType record) {
        return null;
    }
}
