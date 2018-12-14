package org.kevin.blog.service;

import com.github.pagehelper.PageInfo;
import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleWithBLOBs;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/8/18
 */
public interface ArticleService {
    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    List<ArticleWithBLOBs> findList(Integer limit);

    PageInfo<ArticleWithBLOBs> list(ArticleWithBLOBs record, int pageNum, int pageSize);

    ArticleWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKey(ArticleWithBLOBs record);
}
