package org.kevin.blog.mapper;

import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleWithBLOBs;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    List<ArticleWithBLOBs> findList();

    List<ArticleWithBLOBs> selectByCondition(Article record);

    ArticleWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKey(ArticleWithBLOBs record);
}