package com.dbms.article;

import com.dbms.article.controller.ArticleController;
import com.dbms.article.entity.*;
import com.dbms.article.mapper.AdvertiMapper;
import com.dbms.article.mapper.ArticleMapper;
import com.dbms.article.mapper.CategoryMapper;
import com.dbms.article.mapper.FunctionMapper;
import com.dbms.article.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemsApplicationTests {

	@Autowired
	ArticleService service;


	@Test
	public void contextLoads() {
			System.out.println(service.fiveArticle(2));
	}
}
