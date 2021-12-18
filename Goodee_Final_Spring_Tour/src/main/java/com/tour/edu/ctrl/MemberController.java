package com.tour.edu.ctrl;

import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.tour.edu.model.service.IMemberService;
import com.tour.edu.vo.MemberVo;

@Controller
public class MemberController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IMemberService service;
	
	@Autowired
	KakaoLoginController kakaoService;
	
	/*
	 * 일반 로그인
	 */
	@RequestMapping(value="/loginForm.do", method=RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MemberVo vo, HttpSession session, Model model) {
		logger.info("컨트롤러의 로그인 메소드");
		vo.setSnsjoin("N");
		List<MemberVo> loginMember = service.login(vo);
		if(loginMember.size() > 0) {
			session.setAttribute("id", loginMember.get(0).getId()); 
			model.addAttribute("nickname", loginMember.get(0).getNickname());
			return "main";
		}else {
			return "redirect:/loginForm.do";
		}
	}
	
	/*
	 * 일반 회원가입
	 */
	@RequestMapping(value="/joinMemberForm.do", method=RequestMethod.GET)
	public String joinMemberForm() {
		logger.info("컨트롤러의 JoinForm 메소드");
		return "member/joinForm";
	}
	
	@RequestMapping(value="/joinMember.do", method=RequestMethod.POST)
	public String joinMember(MemberVo vo) {
		logger.info("컨트롤러의 Join 메소드");
		vo.setSnsjoin("N");
		int result = service.joinMember(vo);
		if(result == 1) {
			return "redirect:/loginForm.do";
		}else {
			return "";
		}
	}
	
	/*
	 * 카카오 회원가입/로그인
	 */
	@GetMapping(value = "/kakaoJoin.do")
	public String kakaoJoin(@RequestParam(value = "code", required = false) String code, Model model) throws Exception{
		logger.info("컨트롤러의 카카오 Join 메소드");
		
		System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code,"join");
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
        System.out.println("###profile_image#### : " + userInfo.get("profile_image"));
        model.addAttribute("userInfo", userInfo);
        List<Integer> idCnt = service.checkDuplicateId((String)userInfo.get("email"));
       
        if(idCnt.get(0)>0) {
        	System.out.println(idCnt.get(0)+"DB에 이미 있으므로 가입이 필요없음. 바로 로그인");
        	return "redirect:/main.do";
        }
        return "member/kakaoJoin";
	}
	
	@PostMapping(value="/kakaoJoinForm.do")
	public String kakaoJoin(MemberVo vo) {
		logger.info("컨트롤러의 카카오 Join Post 메소드");
		vo.setSnsjoin("Y");
		int n = service.joinMember(vo);
		if(n == 1) {
			return "redirect:/main.do";
		}else {
			return "";
		}
	}
	
	@RequestMapping(value = "/kakaoLogin.do")
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code, MemberVo vo) throws Exception{
		
		System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code,"login");
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
        System.out.println("###profile_image#### : " + userInfo.get("profile_image"));
        vo.setId(String.valueOf(userInfo.get("email")));
        vo.setSnsjoin("Y");
        
        List<MemberVo> result = service.login(vo);
        System.out.println("결과 사이즈 " + result.size());
        if(result.size() == 1) {
        	return "redirect:/main.do";
        }else {
        	return "member/kakaoJoin";
        }
    }
	
	/*
	 * 메인 이동(임시)
	 */
	@GetMapping(value="/main.do")
	public String main() {
		return "redirect:/loginForm.do";
	}
}
