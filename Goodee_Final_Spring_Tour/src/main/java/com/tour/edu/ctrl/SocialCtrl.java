package com.tour.edu.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tour.edu.model.service.IPostService;

@Controller
public class SocialCtrl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPostService service;

	//전체 포스트 출력
	@RequestMapping(value = "/postAllSelect.do", method = RequestMethod.GET)
	public String postAllSelect(Model model, String topic) {
		logger.info("postAllSelect");
		model.addAttribute("postList", service.postAllSelect());
		return "social/postList";
	}
	
	//팔로우한 유저의 포스트 셀렉트
	@RequestMapping(value = "/userPostSelect.do", method = RequestMethod.GET)
	public String userPostSelect(Model model, String id) {
		logger.info("userPostSelect");
		System.out.println(id);// session에서 usersession을 받아와 아이디로
		model.addAttribute("postList", service.userPostSelect(id));
		return "social/postList";
	}
	
	//팔로우한 테마의 포스트 셀렉트
	@RequestMapping(value = "/themePostSelect.do", method = RequestMethod.GET)
	public String themePostSelect(Model model, String id) {
		logger.info("themePostSelect");
		model.addAttribute("postList", service.themePostSelect(id));
		return "social/postList";
	}
	
	//
}
