package com.tour.edu.test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tour.edu.model.dao.IMyTourBookDao;
import com.tour.edu.vo.MyTourBookVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml",
		"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class Test {
	
	@Autowired
	private ApplicationContext context;

	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private IMyTourBookDao dao;
	
	@org.junit.Test
	public void test() {
		//assertNotNull(context);
		//assertNotNull(session);
		MyTourBookVo vo = new MyTourBookVo();
		vo.setTitle("MyTourBookVo insert 테스트2");
		vo.setAurthor("저자2");
		vo.setKeyword("keyword2");
		System.out.println(dao.MyTourBookInsert(vo));
	}

}
