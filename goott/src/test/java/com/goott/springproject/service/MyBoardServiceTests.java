package com.goott.springproject.service;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goott.springproject.mapper.MyBoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/mybatis-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class MyBoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private MyBoardService myBoardService;
	
	@Test
	public void testMyBoardServiceExist() {
		log.info(myBoardService);
		assertNotNull(myBoardService);
	}

}
