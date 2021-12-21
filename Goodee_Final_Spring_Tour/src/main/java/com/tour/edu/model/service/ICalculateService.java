package com.tour.edu.model.service;

import java.util.List;

import com.tour.edu.vo.CalculateVo;

public interface ICalculateService {
	
	public List<CalculateVo> CalculateSelectAll();
	public List<CalculateVo> CalculateSelectResultCode(int resultCode);
	public int CalculateInsert(CalculateVo vo);
	public int CalculateUpdate(CalculateVo vo);
	public int CalculateCntUp(CalculateVo vo);
	public int CalculateDelete(int resultCode);
	
}
