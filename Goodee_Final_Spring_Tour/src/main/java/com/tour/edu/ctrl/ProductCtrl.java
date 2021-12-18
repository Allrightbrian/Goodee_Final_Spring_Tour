package com.tour.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tour.edu.model.service.IProductsService;
import com.tour.edu.vo.ProductsVo;


@Controller
public class ProductCtrl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IProductsService service;
	
	@GetMapping(value="/productList.do")
	public String productList(Model model) {
		
		logger.info("ProductCtrl productList 호출");
		
		List<ProductsVo> productList = service.productSelectAll();
		model.addAttribute("productList", productList);
		
		return "product/productList";
	}
	
	@RequestMapping(value = "/productDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String productDetail(Model model, int product_code) {
		logger.info("ProductCtrl productDetail 호출 {}", product_code);
		
//		int code = Integer.parseInt(product_code);
		ProductsVo productDetail = service.productSelectOne(product_code);
		model.addAttribute("productDetail", productDetail);
		
		return "product/productDetail";
	}
	@PostMapping(value = "/productUpdate.do")
	public String productUpdate(ProductsVo vo) {
		logger.info("ProductCtrl productUpdate 호출 {}", vo);
		service.productUpdate(vo);
		
		return "redirect:/productList.do";
		
	}
	@RequestMapping(value = "/productDelflag.do", method = RequestMethod.GET)
	public String productDelflag(int product_code) {
		logger.info("ProductCtrl productDelflag 호출 {}", product_code);
		service.productDelflag(product_code);
		
		return "redirect:/productList.do";
		
	}
	
	@GetMapping(value = "/productInsertForm.do")
	public String productInsertForm(){
		logger.info("ProductCtrl productInsertForm 호출 {}");
		return "product/productInsertForm";
	}
	
	@PostMapping(value = "/productInsert.do")
	public String productInsert(ProductsVo vo, HttpServletResponse resp) throws IOException {
		logger.info("ProductCtrl productInsert 호출 {}", vo);
		int cnt = service.productInsert(vo);
		
		if (cnt == 1) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('성공적으로 상품이 등록되었습니다'); location.href='./productList.do';</script>");
			out.flush();

			return null;
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('상품 등록 실패'); location.href='./productInsertForm.do';</script>");
			out.flush();

			return null;
		}
	}
}
