package com.tour.edu.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tour.edu.model.service.IEstimateService;
import com.tour.edu.vo.EstimateVo;

@Controller
public class EstimateController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IEstimateService service;
	
	@GetMapping(value = "/EstimateSelectUserId.do")
	public String EstimateSelectUserId(String userId, Model model) {
		logger.info("EstimateController UserId를 통해서 견적서 확인 {}", userId);
		List<EstimateVo> lists=service.EstimateSelectUserId(userId);
		model.addAttribute("lists", lists);
		return "service/EstimateList";
	}
	
	@GetMapping(value="/EstimateInsertForm.do")
	public String EstimateInsertForm() {
		
		return "service/EstimateInsertForm";
	}
	
	@PostMapping(value="/EstimateInsert.do")
	public String EstimateInsert(Model model, EstimateVo vo, HttpSession session) {
		//String userId=(String) session.getAttribute("userId");
		vo.setUserId("USER01");
		service.EstimateInsert(vo);
		
		return "redirect:/EstimateSelectUserId.do";
	}
}
