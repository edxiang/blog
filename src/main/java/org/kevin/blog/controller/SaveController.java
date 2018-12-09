package org.kevin.blog.controller;

import org.kevin.blog.common.util.CommonUtils;
import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleWithBLOBs;
import org.kevin.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Kevin.Z
 * @version 12/9/18
 */
@Controller
public class SaveController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    @ResponseBody
    public String saveArticle(ArticleWithBLOBs article){
        article.setId(CommonUtils.getUUID32());
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setDeleteFlag(false);

        articleService.insertSelective(article);
        System.out.println("hello");
        return "200";
    }
}
