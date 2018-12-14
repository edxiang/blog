package org.kevin.blog.controller;

import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleType;
import org.kevin.blog.model.ArticleWithBLOBs;
import org.kevin.blog.service.ArticleService;
import org.kevin.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/8/18
 */
@Controller
public class MainController {

    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping({"/", "", "/index"})
    public String index(ModelMap modelMap) {
        List<ArticleType> articleTypes = articleTypeService.findList();
        modelMap.addAttribute("articleTypes", articleTypes);

        List<ArticleWithBLOBs> articles = articleService.findList(10);
        modelMap.addAttribute("articles", articles);
        return "index";
    }

    @RequestMapping("/newArticle")
    public String newArticle(ModelMap modelMap) {
        List<ArticleType> articleTypes = articleTypeService.findList();
        modelMap.addAttribute("articleTypes", articleTypes);
        return "newArticle";
    }

    @RequestMapping("/article")
    public String article(@RequestParam("id") String id, ModelMap modelMap){
        List<ArticleType> articleTypes = articleTypeService.findList();
        modelMap.addAttribute("articleTypes", articleTypes);

        ArticleWithBLOBs article = articleService.selectByPrimaryKey(id);
        modelMap.addAttribute("article",article);
        return "blog";
    }

    @RequestMapping("/blogExample")
    public String blogExample() {
        return "blog-example";
    }


}
