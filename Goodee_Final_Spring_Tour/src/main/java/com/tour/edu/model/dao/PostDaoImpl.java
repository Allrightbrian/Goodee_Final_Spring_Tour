package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.MyTourBookVo;
import com.tour.edu.vo.Post_Vo;

@Repository
public class PostDaoImpl implements IPostDao {

	private final String NS = "com.tour.edu.model.dao.PostDaoImpl.";

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Post_Vo> postAllSelect() {
		return sqlSession.selectList(NS + "allPostSelect");
	}

	@Override
	public List<Post_Vo> userPostSelect(String id) {
		return sqlSession.selectList(NS + "userPostSelect", id);
	}

	@Override
	public List<Post_Vo> themePostSelect(String id) {
		return sqlSession.selectList(NS+"themePostSelect", id);
	}

	@Override
	public Post_Vo detailPostSelect(int postid) {
		return sqlSession.selectOne(NS+"detailPostSelect", postid);
	}

	@Override
	public List<Post_Vo> profilePostSelect(String userid) {
		return sqlSession.selectList(NS+"profilePostSelect", userid);
	}

	@Override
	public int wirtePost(Post_Vo vo) {
		return sqlSession.insert(NS+"wirtePost", vo);
	}

	@Override
	public List<MyTourBookVo> myTourSelect(String userid) {
		return sqlSession.selectList(NS+"myTourSelect", userid);
	}

}
