package org.kevin.blog.controller;

import org.kevin.blog.common.util.CommonUtils;
import org.kevin.blog.model.ArticleWithBLOBs;
import org.kevin.blog.model.SecretMoment;
import org.kevin.blog.service.AlertWallService;
import org.kevin.blog.service.ArticleService;
import org.kevin.blog.service.SecretMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Kevin.Z
 * @version 12/9/18
 */
@RestController
public class SaveController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SecretMomentService secretMomentService;
    @Autowired
    private AlertWallService alertWallService;

    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public int saveArticle(ArticleWithBLOBs article) {
        return articleService.insertSelective(article);
    }

    @RequestMapping(value = "/saveSecretMoment", method = RequestMethod.POST)
    public int saveSecretMoment(@RequestParam("content") String content) {
        SecretMoment record = new SecretMoment();
        record.setId(CommonUtils.getUUID32());
        record.setMoment(CommonUtils.replaceLineCharacter(content));
        record.setCreateTime(new Date());

        return secretMomentService.insert(record);
    }
}
