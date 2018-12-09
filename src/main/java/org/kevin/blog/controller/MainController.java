package org.kevin.blog.controller;

import org.kevin.blog.model.ArticleType;
import org.kevin.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/8/18
 */
@Controller
public class MainController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @RequestMapping({"/","","/index"})
    public String index(ModelMap modelMap){
        List<ArticleType> articleTypes = articleTypeService.findList();
        modelMap.addAttribute("articleTypes",articleTypes);
        return "index";
    }

    @RequestMapping("newArticle")
    public String newArticle(ModelMap modelMap){
        List<ArticleType> articleTypes = articleTypeService.findList();
        modelMap.addAttribute("articleTypes",articleTypes);
        return "newArticle";
    }
}
