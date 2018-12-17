package org.kevin.blog.config;

import org.kevin.blog.model.AlertWall;
import org.kevin.blog.model.ArticleType;
import org.kevin.blog.service.AlertWallService;
import org.kevin.blog.service.ArticleTypeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/14/18
 * 可以用来初始化一些东西，在项目启动之前
 */
@Component
public class InitializeProject implements InitializingBean, ApplicationContextAware {
    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private AlertWallService alertWallService;

    @Autowired
    private ServletContext sc;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<ArticleType> articleTypes = articleTypeService.findList();
        sc.setAttribute("articleTypes", articleTypes);

        AlertWall aw = alertWallService.selectByType(1);
        sc.setAttribute("alertWall", aw);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
