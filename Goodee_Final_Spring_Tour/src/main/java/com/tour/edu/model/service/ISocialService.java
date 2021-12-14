package com.tour.edu.model.service;

import java.util.List;
import java.util.Map;

import com.tour.edu.vo.Theme_Vo;

public interface ISocialService {
	public List<Theme_Vo> themeAllSelect();

	public boolean themeFollow(Map<String, String> map);
}
