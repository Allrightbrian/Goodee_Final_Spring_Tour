package com.tour.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tour.edu.model.service.IPostService;
import com.tour.edu.model.service.ISocialService;
import com.tour.edu.vo.Comment_Vo;
import com.tour.edu.vo.Paging_Vo;
import com.tour.edu.vo.Post_Vo;

@Controller
public class SocialCtrl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPostService service;

	@Autowired
	private ISocialService socialService;

	@RequestMapping(value = "/userset.do", method = RequestMethod.GET)
	public String userset(HttpSession session, String userid) {
		session.setAttribute("userid", userid); // 테스트 및 구현을 위하여 임시적으로 회원 아이디를 저장
		session.setAttribute("themeList", socialService.themeAllSelect());
		System.out.println("접속한 유저 아이디 *******" + session.getAttribute("userid"));
		return "redirect:/postAllSelect.do";
	}
	
	//포스트 페이징 처리 하기 위한 페이징 공통 모듈
	public void paging(Model model, HttpServletRequest req, List<Post_Vo> lists, int total) {
		Paging_Vo paging = new Paging_Vo(
				req.getParameter("index"),
				req.getParameter("pageStartNum"),
				req.getParameter("listCnt")
				);
		logger.info("페이징 DTO 값 : {}", paging.getIndex());
		logger.info("페이징 DTO 값 : {}", paging.getPageStartNum());
		logger.info("페이징 DTO 값 : {}", paging.getListCnt());
		paging.setTotal(total);
		model.addAttribute("lists", lists);
		model.addAttribute("paging",paging);
		logger.info("페이징 DTO 값 : {}", paging.toString());
	}

	// 전체 포스트 출력
	@RequestMapping(value = "/postAllSelect.do", method = RequestMethod.GET)
	public String postAllSelect(Model model, HttpSession session) {
		logger.info("SocialCtrl postAllSelect");
		model.addAttribute("postList", service.postAllSelect());
		return "social/postList";
	}

	// 팔로우한 유저의 포스트 셀렉트
	@RequestMapping(value = "/userPostSelect.do", method = RequestMethod.GET)
	public String userPostSelect(Model model, HttpSession session) {
		logger.info("SocialCtrl userPostSelect");
		model.addAttribute("postList", service.userPostSelect((String) session.getAttribute("userid")));
		return "social/postList";
	}

	// 팔로우한 테마의 포스트 셀렉트
	@RequestMapping(value = "/themePostSelect.do", method = RequestMethod.GET)
	public String themePostSelect(Model model, HttpSession session) {
		logger.info("SocialCtrl themePostSelect");
		model.addAttribute("postList", service.themePostSelect((String)session.getAttribute("userid")));
		return "social/postList";
	}

	// 포스트를 선택하여 디테일 페이지로 전환
	@RequestMapping(value = "/detailPostSelect.do", method = RequestMethod.GET)
	public String detailPostSelect(Model model, String postid) {
		logger.info("SocialCtrl detailPostSelect");
		socialService.postUpViewCount(postid);
		model.addAttribute("post", service.detailPostSelect(Integer.parseInt(postid)));
		model.addAttribute("commentList", socialService.postCommentSelect(postid));
		return "social/detailPost";
	}

	// 테마를 선택하여 팔로우 하는 기능
	@RequestMapping(value = "/themeFollow.do", method = RequestMethod.GET)
	public String themeFollow(String themeid, HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", (String) session.getAttribute("userid"));
		map.put("themeid", themeid);
		socialService.themeFollow(map);
		logger.info("SocialCtrl themeFollow 팔로우 : 유저 {} -> 테마 {}", map.get("userid"), map.get("themeid"));
		return "redirect:/themePostSelect.do";
	}

	// 유저를 팔로우 하는 기능
	@RequestMapping(value = "/userFollow.do", method = RequestMethod.GET)
	public String userFollow(String followingUserId, HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("followUserId", (String) session.getAttribute("userid"));
		map.put("followingUserId", followingUserId);
		logger.info("SocialCtrl userFollow 팔로우 : 팔로윙 유저 {} -> 팔로우 유저 {}", map.get("followUserId"),
				map.get("followingUserId"));
		socialService.userFollow(map);
		return "redirect:/userPostSelect.do";
	}
	
	//테마 언팔
	@RequestMapping(value = "/themeUnFollow.do", method = RequestMethod.GET)
	public String themeUnFollow(String themeid, HttpSession session) {
		logger.info("SocialCtrl themeUnFollow : 유저 {} -> 테마언팔 {}", (String)session.getAttribute("userid"), themeid);
		Map<String, String> map = new HashMap<String, String>();
		map.put("themeid", themeid);
		map.put("userid", (String)session.getAttribute("userid"));
		socialService.themeUnFollow(map);
		return "redirect:/themePostSelect.do";
	}

	// 유저를 팔로우 취소 하는 기능
	@RequestMapping(value = "/userUnFollow.do", method = RequestMethod.GET)
	public String userUnFollow(String userUnFolowId, HttpSession session) {
		logger.info("SocialCtrl userUnFollow : 유저 {} -> 유저 언팔 {}", (String)session.getAttribute("userid"), userUnFolowId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("userUnFolowId", userUnFolowId);
		map.put("userid", (String)session.getAttribute("userid"));
		socialService.userUnFollow(map);
		return "redirect:/userPostSelect.do";
	}
	
	@RequestMapping(value = "/postCommentInsert.do", method = RequestMethod.POST)
	public String postCommentInsert(Model model, HttpSession session, String content, String postid) {
		System.out.println(content+" : "+postid);
		logger.info("SocialCtrl postCommentInsert : 유저 {} -> 댓글 입력 포스트 {} -> 댓글 내용 -> {}",
				(String)session.getAttribute("userid"), postid, content);
		Comment_Vo cvo = new Comment_Vo();
		cvo.setId((String)session.getAttribute("userid"));
		cvo.setComment_content(content);
		cvo.setComment_post_id(Integer.parseInt(postid));
		socialService.postCommentInsert(cvo);
		return "redirect:/detailPostSelect.do?postid="+postid;
	}
	
	@RequestMapping(value = "/postCommentSelect.do", method = RequestMethod.POST)
	public String postCommentSelect(Model model, HttpSession session, String postid) {
		logger.info("SocialCtrl postCommentInsert : 유저 {} -> 댓글 입력 포스트 {} -> 댓글 내용 -> {}");
		socialService.postCommentSelect(postid);
		return "redirect:/detailPostSelect.do?postid="+postid;
	}
	
	@RequestMapping(value = "/myProfile.do")
	public String Profile(HttpSession session, Model model) {
		logger.info("SocialCtrl Profile 유저아이디 -> {}", (String)session.getAttribute("userid"));
//		socialService.profileSelect(session.getAttribute("user"));
		model.addAttribute("postList", service.profilePostSelect((String)session.getAttribute("userid")));
		
		return "social/profile";
	}
	
	@GetMapping(value = "/wirtePostForm.do")
	public String wirtePostForm(Model model, HttpSession session) {
		logger.info("SocialCtrl wirtePostForm ");
		model.addAttribute("myTourList", service.myTourSelect((String)session.getAttribute("userid")));
		return "social/wirtePostForm";
	}
	
	@PostMapping(value = "/wirtePost.do")
	public String wirtePost(Post_Vo vo, HttpServletResponse resp) throws IOException {
		logger.info("SocialCtrl wirtePost post ->  ? {}", vo);
		boolean isc = service.wirtePost(vo);
		if(isc) {
			return "redirect:/myProfile.do";
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('처리가 잘못되었습니다'); location.href='./myProfile.do';</script>");
			out.flush();
			return null;
		}
	}

}
