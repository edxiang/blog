package org.kevin.blog.mapper;

import org.kevin.blog.model.ArticleType;

public interface ArticleTypeMapper {
    int insert(ArticleType record);

    int insertSelective(ArticleType record);
}