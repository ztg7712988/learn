package com.dbms.article;

import com.dbms.article.controller.CategoryEditController;
import com.dbms.article.controller.CategoryListController;
import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.mapper.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Timer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemsApplicationTests {

	@Autowired
	CategoryMapper mapper;

	@Test
	public void contextLoads() {
		List<CategoryTbl> list = mapper.selectCategoryAndFunctionMap1();
		for (CategoryTbl tbl: list){
			System.out.println(tbl.toString());
		}
	}
}
