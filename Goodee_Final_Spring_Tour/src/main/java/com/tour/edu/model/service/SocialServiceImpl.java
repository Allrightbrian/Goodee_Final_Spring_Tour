package com.tour.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.ISocialDao;
import com.tour.edu.vo.Comment_Vo;
import com.tour.edu.vo.Theme_Vo;

@Service
public class SocialServiceImpl implements ISocialService {

	@Autowired
	private ISocialDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Theme_Vo> themeAllSelect() {
		logger.info("SocialServiceImpl themeAllSelect");
		return dao.themeAllSelect();
	}

	@Override
	public boolean themeFollow(Map<String, String> map) {
		logger.info("SocialServiceImpl themeFollow");
		return dao.themeFollow(map);
	}

	@Override
	public boolean userFollow(Map<String, String> map) {
		logger.info("SocialServiceImpl themeFollow");
		return dao.userFollow(map);
	}

	@Override
	public boolean themeUnFollow(Map<String, String> map) {
		logger.info("SocialServiceImpl themeUnFollow");
		return dao.themeUnFollow(map);
	}

	@Override
	public boolean userUnFollow(Map<String, String> map) {
		logger.info("SocialServiceImpl userUnFollow");
		return dao.userUnFollow(map);
	}

	@Override
	public boolean postCommentInsert(Comment_Vo cvo) {
		logger.info("SocialServiceImpl postCommentInsert");
		return dao.postCommentInsert(cvo);
	}

	@Override
	public List<Comment_Vo> postCommentSelect(String postid) {
		logger.info("SocialServiceImpl postCommentInsert");
		return dao.postCommentSelect(postid);
	}

	@Override
	public boolean postUpViewCount(String postid) {
		logger.info("SocialServiceImpl postUpViewCount");
		return dao.postUpViewCount(postid);
	}

}
