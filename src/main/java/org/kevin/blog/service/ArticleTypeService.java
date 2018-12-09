package org.kevin.blog.service;

import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleType;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/8/18
 */
public interface ArticleTypeService {
    int insert(ArticleType record);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(ArticleType record);

    List<ArticleType> findList();

    ArticleType selectByPrimaryKey(String id);

    ArticleType select(ArticleType record);

}
