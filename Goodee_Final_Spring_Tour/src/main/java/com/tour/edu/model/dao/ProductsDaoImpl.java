package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.ProductsVo;


@Repository
public class ProductsDaoImpl implements IProductsDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.tour.edu.model.dao.ProductsDaoImpl.";
	
	@Override
	public int productInsert(ProductsVo vo) {
		logger.info("ProductsDaoImpl 상품등록 {}", vo);
		
		return sqlSession.insert(NS+"productInsert", vo);
	}

	@Override
	public List<ProductsVo> productSelectAll() {
		logger.info("ProductsDaoImpl 전체 상품조회 {}");
		return sqlSession.selectList(NS+"productSelectAll");
	}
	
	@Override
	public List<ProductsVo> productSelectByName(String name) {
		logger.info("ProductsDaoImpl 이름으로 상품조회 {}", name);
		return sqlSession.selectList(NS+"productSelectByName", name);
	}
	
	@Override
	public ProductsVo productSelectOneByName(String name) {
		logger.info("ProductsDaoImpl 이름으로 상품단일조회 {}", name);
		return sqlSession.selectOne(NS+"productSelectOneByName", name);
	}

	@Override
	public ProductsVo productSelectOne(int product_code) {
		logger.info("ProductsDaoImpl 단일 상품조회 {}", product_code);
		return sqlSession.selectOne(NS+"productSelectOne", product_code);
	}

	@Override
	public int productUpdate(ProductsVo vo) {
		logger.info("ProductsDaoImpl 상품 수정 {}", vo);
		return sqlSession.update(NS+"productUpdate", vo);
	}

	@Override
	public int productDelflag(int product_code) {
		logger.info("ProductsDaoImpl 상품 삭제 {}", product_code);
		return sqlSession.update(NS+"productDelflag", product_code);
	}


	
}
