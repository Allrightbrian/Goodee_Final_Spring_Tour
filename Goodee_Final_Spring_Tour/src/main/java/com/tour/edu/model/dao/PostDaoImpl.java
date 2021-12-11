package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.Post_Vo;

@Repository
public class PostDaoImpl implements IPostDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String NS = "com.tour.edu.model.dao.PostDaoImpl.";
	
	@Autowired
	SqlSessionTemplate sqlSession;  

	@Override
	public List<Post_Vo> postSelect(String topic) {
		if(topic == "user") {
			logger.info("PostDaoImpl postSelect : {}", topic);
			return sqlSession.selectList(NS+"userPostSelect");
		}else if (topic == "theme") {
			return null;
		}
		else{
			logger.info("PostDaoImpl postSelect : {}", topic+"(없음)");
			return sqlSession.selectList(NS+"allPostSelect");
		}
		
	}

}
