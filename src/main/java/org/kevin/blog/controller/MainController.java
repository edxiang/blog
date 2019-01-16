package org.kevin.blog.controller;

import com.github.pagehelper.PageInfo;
import org.kevin.blog.model.*;
import org.kevin.blog.service.AlertWallService;
import org.kevin.blog.service.ArticleService;
import org.kevin.blog.service.ArticleTypeService;
import org.kevin.blog.service.SecretMomentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AlertWallService alertWallService;
    @Autowired
    private SecretMomentService secretMomentService;

    @RequestMapping({"/", "", "/index"})
    public String index(ModelMap modelMap) {
        logger.info("in the index page.");

        List<ArticleWithBLOBs> articles = articleService.findList(8);
        modelMap.addAttribute("articles", articles);

        logger.error("the article's size:" + articles.size());
        return "index";
    }

    @RequestMapping("/signin")
    public String signin(ModelMap modelMap) {
        return "signin";
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

    @RequestMapping("/secretMoment")
    public String secretMoment(@RequestParam(value = "pageNum", required = false) Integer pageNum,
                               @RequestParam(value = "pageSize", required = false) Integer pageSize,
                               ModelMap modelMap) {
        SecretMoment secretMoment = null;
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageInfo<SecretMoment> pageInfo = secretMomentService.selectByCondition(secretMoment, pageNum, pageSize);

        modelMap.addAttribute("pageInfo", pageInfo);
        modelMap.addAttribute("secretMoments", pageInfo.getList());
        return "secretMoment";
    }

    @RequestMapping("/alertWall")
    public String alertWall(ModelMap modelMap){
        List<AlertWall> alertWallList = alertWallService.findList();
        modelMap.addAttribute("alertWallTypes",alertWallList);

        return "alertWall";
    }

    @RequestMapping("/blogExample")
    public String blogExample() {
        return "blog-example";
    }

    @RequestMapping("/articles")
    public String articles(@RequestParam("articleType") Integer type,
                           @RequestParam(value = "pageNum", required = false) Integer pageNum,
                           @RequestParam(value = "pageSize", required = false) Integer pageSize,
                           ModelMap modelMap) {
        ArticleWithBLOBs record = new ArticleWithBLOBs();
        record.setArticleType(type);
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageInfo<ArticleWithBLOBs> pageInfo = articleService.list(record, pageNum, pageSize);

        modelMap.addAttribute("pageInfo", pageInfo);
        modelMap.addAttribute("articles", pageInfo.getList());
        modelMap.addAttribute("articleType", type);

        return "blogWithType";
    }
}
