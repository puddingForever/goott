package com.goott.springproject.mapper;
import java.sql.Connection;
//import javax.sql.DataSource;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/mybatis-context.xml")
@Log4j
public class MyBoardMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private MyBoardMapper myBoardMapper;
	
	@Test
	public void testSelectBoardList() {
		myBoardMapper.selectMyBoardList().forEach(myBoard -> log.info(myBoard));
	}

}
