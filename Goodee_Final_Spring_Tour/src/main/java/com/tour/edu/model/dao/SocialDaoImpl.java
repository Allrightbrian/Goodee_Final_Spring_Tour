package com.tour.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.Theme_Vo;

@Repository
public class SocialDaoImpl implements ISocialDao {

	private final String NS = "com.tour.edu.model.dao.SocialDaoImpl.";

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Theme_Vo> themeAllSelect() {
		return sqlSession.selectList(NS+"themeAllSelect");
	}

	@Override
	public boolean themeFollow(Map<String, String> map) {
		return sqlSession.insert(NS+"themeFollow", map)==1?true:false;
	}

}
