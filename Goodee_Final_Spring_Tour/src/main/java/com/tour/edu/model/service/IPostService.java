package com.tour.edu.model.service;

import java.util.List;

import com.tour.edu.vo.Post_Vo;

public interface IPostService {
	public List<Post_Vo> postSelect(String topic);	
}
