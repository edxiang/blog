package org.kevin.blog;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kevin.blog.common.util.CommonUtils;
import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleType;
import org.kevin.blog.model.ArticleWithBLOBs;
import org.kevin.blog.service.ArticleService;
import org.kevin.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Resource
	private RedisTemplate<String,Object> redisTemplate;

	@Autowired
	private ArticleTypeService articleTypeService;
	@Autowired
	private ArticleService articleService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRedis(){
		redisTemplate.opsForValue().set("name","kevin");
		System.out.println(redisTemplate.opsForValue().get("name"));
	}


	@Test
	public void insertArticleType(){
		String[] types = {"whatever","Opinion","Movies&Books","Animals&Plants",
				"EnglishLearning","Health","Design","Travel"};

		List<ArticleType> list = articleTypeService.findList();
		System.out.println(list.size());
	}

	@Test
	public void listArticle(){
		PageInfo<ArticleWithBLOBs> page = articleService.list(new ArticleWithBLOBs(),2,1);
		System.out.println("hw");
	}
}
