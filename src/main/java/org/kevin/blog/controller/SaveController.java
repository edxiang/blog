package org.kevin.blog.controller;

import org.kevin.blog.common.util.CommonUtils;
import org.kevin.blog.model.AlertWall;
import org.kevin.blog.model.ArticleWithBLOBs;
import org.kevin.blog.model.Finance;
import org.kevin.blog.model.SecretMoment;
import org.kevin.blog.service.AlertWallService;
import org.kevin.blog.service.ArticleService;
import org.kevin.blog.service.FinanceService;
import org.kevin.blog.service.SecretMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private FinanceService financeService;

    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public int saveArticle(ArticleWithBLOBs article) {
        return articleService.insertSelective(article);
    }

    @RequestMapping(value = "/saveSecretMoment", method = RequestMethod.POST)
    public int saveSecretMoment(@RequestParam("content") String content) {
        SecretMoment record = new SecretMoment();
        record.setMoment(CommonUtils.replaceLineCharacter(content));

        return secretMomentService.insert(record);
    }

    @RequestMapping(value = "/updateAlertWall", method = RequestMethod.POST)
    public int updateAlertWall(AlertWall alertWall) {
        return alertWallService.updateByType(alertWall);
    }

    @RequestMapping(value = "/saveSpending", method = RequestMethod.POST)
    public int saveSpending(@RequestParam(value = "cost") Double cost,
                            @RequestParam(value = "forWhat") String forWhat,
                            @RequestParam(value = "type") String type) {
        Finance record = new Finance();
        record.setCost(cost);
        record.setForWhat(CommonUtils.replaceLineCharacter(forWhat));
        record.setType(type);
        return financeService.insert(record);
    }
}
