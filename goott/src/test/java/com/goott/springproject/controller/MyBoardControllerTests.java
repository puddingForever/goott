package com.goott.springproject.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/mybatis-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class MyBoardControllerTests {
	
	//테스트 환경 구성 시작, 컨트롤러 테스트를 위해서는 WebApplicationContext 를 객체로 주입 받아야 합니다.
    @Setter(onMethod_ = { @Autowired })
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    } 
    
  //게시물 목록 조회 테스트 
  @Test
  public void testShowBoardList() throws Exception {
      log.info(mockMvc.perform(MockMvcRequestBuilders.get("/myboard/list")
//                                                     .param("pageNum", "2")    //페이징 테스트 시 추가
//                                                     .param("rowAmountPerPage", "10") //페이징 테스트 시 추가
                               )
                      .andReturn()
                      .getModelAndView()
//                      .getViewName());z
                      .getModelMap());
  }
    
    
}
