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
//		MyTourBookVo vo = new MyTourBookVo();
//		vo.setTitle("MyTourBookVo update 변경");
//		vo.setAurthor("저자변경");
//		vo.setKeyword("keyword3");
//		vo.setDelflag("N");
//		vo.setBookNo(1);
//		System.out.println(dao.MyTourBookInsert(vo));
//		System.out.println(dao.MyTourBookSelectNo(1));
//		System.out.println(dao.MyTourBookSelectTitle("insert"));
		//assertEquals(1, dao.MyTourBookUpdate(vo));
		//assertEquals(1, dao.MyTourBookDelflag(1));
	}

}
