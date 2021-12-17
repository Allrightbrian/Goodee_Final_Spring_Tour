package com.tour.edu.model.dao;

import java.util.List;

import com.tour.edu.vo.ProductsVo;

public interface IProductsDao {

//	상품 등록
	public int productInsert(ProductsVo vo);
//	상품 전체조회
	public List<ProductsVo> productSelectAll();
//	상품 조회(이름)
	public List<ProductsVo> productSelectByName(String name);
//	상품 단일 조회
	public ProductsVo productSelectOne(int product_code);
//	상품 수정
	public int productUpdate(ProductsVo vo);
//	상품 삭제(delflag)
	public int productDelflag(int product_code);
}
