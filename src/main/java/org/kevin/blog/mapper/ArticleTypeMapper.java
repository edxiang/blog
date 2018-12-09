package org.kevin.blog.mapper;

import org.kevin.blog.model.ArticleType;

import java.util.List;

public interface ArticleTypeMapper {
    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    List<ArticleType> findList();
}