package com.tour.edu.model.dao;

import java.util.List;

import com.tour.edu.vo.Post_Vo;

public interface IPostDao {
	public List<Post_Vo> postSelect(String topic);
}
