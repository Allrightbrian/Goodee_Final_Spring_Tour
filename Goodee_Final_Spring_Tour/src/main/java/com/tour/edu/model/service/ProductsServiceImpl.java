package com.tour.edu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.IProductsDao;
import com.tour.edu.vo.ProductsVo;


@Service
public class ProductsServiceImpl  implements IProductsService {

	@Autowired
	private IProductsDao dao;

	@Override
	public int productInsert(ProductsVo vo) {
		return dao.productInsert(vo);
	}

	@Override
	public List<ProductsVo> productSelectAll() {
		System.out.println("실행");
		return dao.productSelectAll();
	}

	@Override
	public List<ProductsVo> productSelectByName(String name) {
		return dao.productSelectByName(name);
	}
	
	@Override
	public ProductsVo productSelectOne(int product_code) {
		return dao.productSelectOne(product_code);
	}

	@Override
	public int productUpdate(ProductsVo vo) {
		return dao.productUpdate(vo);
	}

	@Override
	public int productDelflag(int product_code) {
		return dao.productDelflag(product_code);
	}

}
