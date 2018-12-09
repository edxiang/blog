package org.kevin.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kevin.blog.common.util.CommonUtils;
import org.kevin.blog.model.ArticleType;
import org.kevin.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private ArticleTypeService articleTypeService;

	@Test
	public void insertArticleType(){
		String[] types = {"whatever","Opinion","Movies&Books","Animals&Plants",
				"EnglishLearning","Health","Design","Travel"};

		List<ArticleType> list = articleTypeService.findList();
		System.out.println(list.size());
	}
}
