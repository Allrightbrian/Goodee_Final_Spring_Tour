package com.tour.edu.model.dao;

import java.util.List;

import com.tour.edu.vo.MyTourDataVo;

public interface IMyTourDataDao {
	
	public List<MyTourDataVo> MyTourDataAll();
	public int MyTourDataInsert(MyTourDataVo vo);
	public int MyTourDataDeleteDataNo(int dataNo);
	public int MyTourDataDeleteBookNo(int bookNo);
	public int MyTourDataUpdate(MyTourDataVo vo);
	public List<MyTourDataVo> MyTourDataBookNo(int bookNo);
}
