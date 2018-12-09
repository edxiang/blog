package org.kevin.blog.service.impl;

import org.kevin.blog.mapper.ArticleMapper;
import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleWithBLOBs;
import org.kevin.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/9/18
 */
@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int insert(ArticleWithBLOBs record) {
        return articleMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticleWithBLOBs record) {
        return articleMapper.insertSelective(record);
    }

    @Override
    public List<ArticleWithBLOBs> findList() {
        return articleMapper.findList();
    }

    @Override
    public List<ArticleWithBLOBs> list(Article record, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public ArticleWithBLOBs selectByPrimaryKey(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(ArticleWithBLOBs record) {
        return articleMapper.updateByPrimaryKey(record);
    }
}
