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
	public List<Post_Vo> postSelect(String topic) {
		return dao.postSelect(topic);
	}
	
}
