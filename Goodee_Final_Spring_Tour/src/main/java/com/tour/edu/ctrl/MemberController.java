package com.tour.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.edu.model.service.IMemberService;
import com.tour.edu.vo.MemberVo;

@Controller
public class MemberController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IMemberService service;
	
	@Autowired
	KakaoLoginController kakaoService;
	
	@Autowired
	JavaMailSender mailSender;
	
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
		
		if(loginMember.size() == 1) {
			service.updateFinalLogin(loginMember.get(0));
			session.setAttribute("member", loginMember.get(0)); 
			return "redirect:/main.do";
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
	 * 아이디, 닉네임 중복체크
	 */
	@PostMapping(value="/duplicateCheckId.do")
	@ResponseBody
	public String duplicateCheckId(String id) {
		logger.info("아이디 중복 체크 duplicateCheckId 메소드. 파라미터 값 : {}",id);
		List<Integer> result = service.checkDuplicateId(id);
		return (result.get(0) > 0) ? "true" : "false";
	}
	
	@PostMapping(value="/duplicateCheckNick.do")
	@ResponseBody
	public String duplicateCheckNick(String nickname) {
		logger.info("닉네임 중복 체크 duplicateCheckNick 메소드. 파라미터 값 : {}",nickname);
		List<Integer> result = service.checkDuplicateNick(nickname);
		return (result.get(0) > 0) ? "true" : "false";
	}
	
	/*
	 * 카카오 회원가입/로그인
	 */
	@GetMapping(value = "/kakaoJoin.do")
	public String kakaoJoin(@RequestParam(value = "code", required = false) String code, Model model, HttpSession session) throws Exception{
		logger.info("컨트롤러의 카카오 Join 메소드");
		
		System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code,"join");
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
        System.out.println("###profile_image#### : " + userInfo.get("profile_image"));
        List<Integer> idCnt = service.checkDuplicateId((String)userInfo.get("email"));
       
        if(idCnt.get(0)>0) {
        	System.out.println(idCnt.get(0)+"DB에 이미 있으므로 가입이 필요없음. 바로 로그인");
        	MemberVo vo= new MemberVo();
        	vo.setId((String)userInfo.get("email"));
        	List<MemberVo> result = service.login(vo);
        	session.setAttribute("member", result.get(0));
        	service.updateFinalLogin(result.get(0));
        	return "redirect:/main.do";
        }else {
            model.addAttribute("userInfo", userInfo);
        	return "member/kakaoJoin";
        }
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
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code, MemberVo vo, HttpSession session) throws Exception{
		
		logger.info("MemberController의 kakaoLogin 메소드");
		
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
        	session.setAttribute("member", result.get(0));
        	service.updateFinalLogin(result.get(0));
        	return "redirect:/main.do";
        }else {
        	return "member/kakaoJoin";
        }
    }
	
	/*
	 * 로그아웃
	 */
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("MemberController 클래스의 logout메소드 실행");
		session.removeAttribute("member");
		logger.info("세션에 남아있는지 확인 객체 : {}", session.getAttribute("member"));
		return "redirect:/main.do";
	}
	
	/*
	 * 아이디/비밀번호 찾기 폼
	 */
	@RequestMapping(value = "/findIdPwForm.do", method = RequestMethod.GET)
	public String findIdPwForm() {
		logger.info("MemberController 클래스의 findIdPwForm메소드 실행");
		return "member/findIdPwForm";
	}
	
	/*
	 * 아이디 찾기
	 */
	@RequestMapping(value="/findId.do", method = RequestMethod.POST)
	@ResponseBody
	public String findId(MemberVo vo) throws IOException {
		logger.info("MemberController 클래스의 findId 메소드 실행");
		List<String> member = service.findId(vo);
		if(member.size() == 1) {
			return member.get(0);
		}else {
			return null;
		}
		
	}
	
	/*
	 * 비밀번호 찾기 이메일
	 */
	@RequestMapping(value="/findPw.do", method = RequestMethod.POST)
	public String findPw(MemberVo vo, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		logger.info("MemberController 클래스의 findPw 메소드 실행");
		List<String> mailList = service.findPw(vo);
		if(mailList.size() == 1) {
			String sender = "zzangkkukku0218@gmail.com";
			String title = "임시 비밀번호 발급을 안내드립니다.";
			String pw = UUID.randomUUID().toString().split("-")[0];
			String content = "발급된 임시 비밀번호 입니다.<br>임시 비밀번호 : "+pw+"<br>로그인한 후에 반드시 비밀번호를 변경해 주세요.";
			
			MimeMessage message = mailSender.createMimeMessage();
			try {
				MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");
				msgHelper.setFrom(sender);
				msgHelper.setTo(mailList.get(0));
				msgHelper.setSubject(title);
				msgHelper.setText(content,true);
				
				mailSender.send(message);
				vo.setPassword(pw);
				service.setTemporaryPw(vo);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			writer.println("<script>alert('입력하신 정보로 가입된 회원이 없습니다.')</script>");
			writer.println("<script>history.back()</script>");
			writer.flush();
			writer.close();
			return null;
		}
		return "redirect:/loginForm.do";
	}
	
	/*
	 * 회원정보 수정
	 */
	//카카오 로그인 회원이면 바로 회원정보 수정으로, 아니라면 비밀번호 입력받음.
	@GetMapping(value="/confirmPw.do")
	public String confirmPw(HttpSession session) {
		logger.info("MemberController 클래스의 confirmPw메소드 실행 - 회원정보 수정하기 위한 비밀번호 입력");
		MemberVo vo = (MemberVo)session.getAttribute("member");
		if(vo.getSnsjoin().equals("Y")) {
			return "member/modifyForm";
		}else {
			return "member/confirmPw";
		}
	}
	
	//비밀번호 맞는지 확인
	@PostMapping(value="/ModifyMemberInfoForm.do")
	public String modifyMemberInfoForm(String password,HttpSession session, HttpServletRequest req) {
		logger.info("MemberController 클래스의 modifyMemberInfoForm메소드 실행 - 회원정보 수정하기 위한 폼으로 이동하기 위한 비밀번호 체크");
		MemberVo vo = (MemberVo)session.getAttribute("member");
		if(vo.getPassword().equals(password)) {
			return "member/modifyForm";
		}else {
			req.setAttribute("msg","비밀번호를 잘못 입력하셨습니다. 다시 입력해 주세요.");
			return "member/confirmPw";
		}
	}
	
	@PostMapping(value="/modifyMemberInfo.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String modifyMemberInfo(MemberVo vo) {
		logger.info("MemberController 클래스의 ModifyMemberInfo메소드 실행 - 회원정보 수정하기 실행");
		logger.info(vo.toString());
		int result = service.updateMember(vo);
		if(result == 1) {
			logger.info("성공");
			return "성공";			
		}else {
			return "실패";
		}
	}
	
	/*
	 * 메인 이동(임시)
	 */
	@GetMapping(value="/main.do")
	public String main() {
		return "member/main";
	}
}
