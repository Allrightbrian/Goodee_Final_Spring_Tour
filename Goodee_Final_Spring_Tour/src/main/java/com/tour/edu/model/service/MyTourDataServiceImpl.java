package com.tour.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.IMyTourDataDao;
import com.tour.edu.vo.MyTourDataVo;

@Service
public class MyTourDataServiceImpl implements IMyTourDataService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IMyTourDataDao dao;
	
	@Override
	public List<MyTourDataVo> MyTourDataAll() {
		logger.info("MyTourDataServiceImpl MyTourDataAll 실행");
		return dao.MyTourDataAll();
	}

	@Override
	public int MyTourDataInsert(MyTourDataVo vo) {
		logger.info("MyTourDataServiceImpl MyTourDataInsert 실행");
		return dao.MyTourDataInsert(vo);
	}

	@Override
	public int MyTourDataDeleteDataNo(int dataNo) {
		logger.info("MyTourDataServiceImpl MyTourDataDeleteDataNo 실행");
		return dao.MyTourDataDeleteDataNo(dataNo);
	}

	@Override
	public int MyTourDataDeleteBookNo(int bookNo) {
		logger.info("MyTourDataServiceImpl MyTourDataDeleteBookNo 실행");
		return dao.MyTourDataDeleteBookNo(bookNo);
	}

	@Override
	public int MyTourDataUpdate(MyTourDataVo vo) {
		logger.info("MyTourDataServiceImpl MyTourDataUpdate 실행");
		return dao.MyTourDataUpdate(vo);
	}

	@Override
	public List<MyTourDataVo> MyTourDataBookNo(int bookNo) {
		logger.info("MyTourDataServiceImpl MyTourDataBookNo 실행");
		return dao.MyTourDataBookNo(bookNo);
	}

	@Override
	public int MyTourDataTourOrderUpdate(MyTourDataVo vo) {
		logger.info("MyTourDataServiceImpl MyTourDataTourOrderUpdate 실행");
		return dao.MyTourDataTourOrderUpdate(vo);
	}
	
}
