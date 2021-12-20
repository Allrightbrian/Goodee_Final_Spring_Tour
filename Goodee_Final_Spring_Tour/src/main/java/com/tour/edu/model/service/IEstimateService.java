package com.tour.edu.model.service;

import java.util.List;

import com.tour.edu.vo.EstimateVo;

public interface IEstimateService {
	
	public List<EstimateVo> EstimateSelectUserId(String userId);
	public int EstimateInsert(EstimateVo vo);
	public int EstimateUpdate(EstimateVo vo);
	public int EstimateDelete(int offerCode);
}
