package org.kevin.blog.mapper;

import org.kevin.blog.model.ArticleWithBLOBs;

public interface ArticleMapper {
    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);
}