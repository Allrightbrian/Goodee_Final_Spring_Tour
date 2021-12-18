package com.tour.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.Comment_Vo;
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

	@Override
	public boolean userFollow(Map<String, String> map) {
		return sqlSession.insert(NS+"userFollow", map)==1?true:false;
	}

	@Override
	public boolean themeUnFollow(Map map) {
		return sqlSession.delete(NS+"themeUnFollow", map)>=1?true:false;
	}

	@Override
	public boolean userUnFollow(Map<String, String> map) {
		return sqlSession.delete(NS+"userUnFollow", map)>=1?true:false;
	}

	@Override
	public boolean postCommentInsert(Comment_Vo cvo) {
		return sqlSession.insert(NS+"postCommentInsert", cvo)==1?true:false;
	}

	@Override
	public List<Comment_Vo> postCommentSelect(String postid) {
		return sqlSession.selectList(NS+"postCommentSelect", postid);
	}

	@Override
	public boolean postUpViewCount(String postid) {
		return sqlSession.update(NS+"postUpViewCount", postid)==1?true:false;
	}

}
