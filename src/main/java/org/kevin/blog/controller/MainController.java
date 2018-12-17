package org.kevin.blog.controller;

import org.kevin.blog.model.AlertWall;
import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleType;
import org.kevin.blog.model.ArticleWithBLOBs;
import org.kevin.blog.service.AlertWallService;
import org.kevin.blog.service.ArticleService;
import org.kevin.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private AlertWallService alertWallService;

    @RequestMapping({"/", "", "/index"})
    public String index(ModelMap modelMap) {
        List<ArticleWithBLOBs> articles = articleService.findList(4);
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
    public String article(@RequestParam("id") String id, ModelMap modelMap) {
        List<ArticleType> articleTypes = articleTypeService.findList();
        modelMap.addAttribute("articleTypes", articleTypes);

        ArticleWithBLOBs article = articleService.selectByPrimaryKey(id);
        modelMap.addAttribute("article", article);
        return "blog";
    }

    @RequestMapping("/blogExample")
    public String blogExample() {
        return "blog-example";
    }


}
