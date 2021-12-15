package com.tour.edu.model.service;

import java.util.List;

import com.tour.edu.vo.MyTourBookVo;

public interface IMyTourBookService {
	
	public List<MyTourBookVo> MyTourSelectAll();
	public List<MyTourBookVo> MyTourBookSelectNo(int bookNo);
	public List<MyTourBookVo> MyTourBookSelectTitle(String title);
	public List<MyTourBookVo> MyTourBookSelectRegdate(String regdate);
	
	public int MyTourBookInsert(MyTourBookVo myTourBookvo);
	public int MyTourBookUpdate(MyTourBookVo myTourBookvo);
	public int MyTourBookDelflag(int bookNo);
	public int MyTourBookDelete(int bookNo);
	
}
