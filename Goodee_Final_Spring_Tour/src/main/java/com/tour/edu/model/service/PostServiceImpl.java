package com.tour.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.IPostDao;
import com.tour.edu.vo.Post_Vo;

@Service
public class PostServiceImpl implements IPostService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPostDao dao;
	
	@Override
	public List<Post_Vo> postAllSelect() {
		logger.info("PostServiceImpl postAllSelect");
		return dao.postAllSelect();
	}

	@Override
	public List<Post_Vo> userPostSelect(String user) {
		logger.info("PostServiceImpl userPostSelect");
		return dao.userPostSelect(user);
	}

	@Override
	public List<Post_Vo> themePostSelect(String user) {
		logger.info("PostServiceImpl themePostSelect");
		return dao.themePostSelect(user);
	}

	@Override
	public Post_Vo detailPostSelect(int postid) {
		logger.info("PostServiceImpl detailPostSelect postid : {}", postid);
		return dao.detailPostSelect(postid);
	}
	
}
