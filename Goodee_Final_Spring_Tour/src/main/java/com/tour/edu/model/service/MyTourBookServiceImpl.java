package com.tour.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.IMyTourBookDao;
import com.tour.edu.vo.MyTourBookVo;

@Service
public class MyTourBookServiceImpl implements IMyTourBookService {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IMyTourBookDao dao;
	
	@Override
	public List<MyTourBookVo> MyTourSelectAll() {
		logger.info("MyTourBookServiceImpl MyTourSelectAll");
		return dao.MyTourSelectAll();
	}

	@Override
	public List<MyTourBookVo> MyTourBookSelectNo(int bookNo) {
		logger.info("MyTourBookServiceImpl MyTourBookSelectNo");
		return dao.MyTourBookSelectNo(bookNo);
	}

	@Override
	public List<MyTourBookVo> MyTourBookSelectTitle(String title) {
		logger.info("MyTourBookServiceImpl MyTourBookSelectTitle");
		return dao.MyTourBookSelectTitle(title);
	}

	@Override
	public List<MyTourBookVo> MyTourBookSelectRegdate(String regdate) {
		logger.info("MyTourBookServiceImpl MyTourBookSelectRegdate");
		return dao.MyTourBookSelectRegdate(regdate);
	}

	@Override
	public int MyTourBookInsert(MyTourBookVo myTourBookvo) {
		logger.info("MyTourBookServiceImpl MyTourBookInsert");
		return dao.MyTourBookInsert(myTourBookvo);
	}

	@Override
	public int MyTourBookUpdate(MyTourBookVo myTourBookvo) {
		logger.info("MyTourBookServiceImpl MyTourBookUpdate");
		return dao.MyTourBookUpdate(myTourBookvo);
	}

	@Override
	public int MyTourBookDelflag(int bookNo) {
		logger.info("MyTourBookServiceImpl MyTourBookDelflag");
		return dao.MyTourBookDelflag(bookNo);
	}

	@Override
	public int MyTourBookDelete(int bookNo) {
		logger.info("MyTourBookServiceImpl MyTourBookDelete");
		return dao.MyTourBookDelete(bookNo);
	}
	
}
