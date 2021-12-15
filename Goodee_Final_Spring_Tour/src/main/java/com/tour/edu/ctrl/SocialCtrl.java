package com.tour.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.edu.model.service.IPostService;
import com.tour.edu.model.service.ISocialService;

@Controller
public class SocialCtrl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPostService service;
	
	@Autowired 
	private ISocialService socialService;
	
	
	@RequestMapping(value = "/userset.do", method = RequestMethod.GET)
	public String userset(HttpSession session, String userid) {
		session.setAttribute("userid", userid); // 테스트 밑 구현을 위하여 임시적으로 회원 아이디를 저장
		session.setAttribute("themeList", socialService.themeAllSelect());
		System.out.println(session.getAttribute("userid"));
		return "social/postList";
	}
	
	
	//전체 포스트 출력
	@RequestMapping(value = "/postAllSelect.do", method = RequestMethod.GET)
	public String postAllSelect(Model model, HttpSession session) {
		logger.info("SocialCtrl postAllSelect");
		model.addAttribute("postList", service.postAllSelect());
		return "social/postList";
	}
	
	//팔로우한 유저의 포스트 셀렉트
	@RequestMapping(value = "/userPostSelect.do", method = RequestMethod.GET)
	public String userPostSelect(Model model, String id) {
		logger.info("SocialCtrl userPostSelect");
		System.out.println(id);// session에서 usersession을 받아와 아이디로
		model.addAttribute("postList", service.userPostSelect(id));
		return "social/postList";
	}
	
	//팔로우한 테마의 포스트 셀렉트
	@RequestMapping(value = "/themePostSelect.do", method = RequestMethod.GET)
	public String themePostSelect(Model model, String id) {
		logger.info("SocialCtrl themePostSelect");
		model.addAttribute("postList", service.themePostSelect(id));
		return "social/postList";
	}
	
	//포스트를 선택하여 디테일 페이지로 전환
	@RequestMapping(value = "/detailPostSelect.do", method = RequestMethod.GET)
	public String detailPostSelect(Model model, String postid) {
		logger.info("SocialCtrl detailPostSelect");
		model.addAttribute("post", service.detailPostSelect(Integer.parseInt(postid)));
		return "social/detailPost";
	}
	
	//테마를 선택하여 팔로우 하는 기능
	@RequestMapping(value = "/themeFollow.do", method = RequestMethod.GET)
	public String themeFollow(String themeid, HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", (String)session.getAttribute("userid"));
		map.put("themeid", themeid);
		socialService.themeFollow(map);
		logger.info("SocialCtrl themeFollow 팔로우 : 유저 {} -> 테마 {}", map.get("userid"), map.get("themeid"));
		return "redirect:/postAllSelect.do";
	}
	
	//
	
	
}
