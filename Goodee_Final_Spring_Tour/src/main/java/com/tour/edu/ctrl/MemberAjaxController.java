package com.tour.edu.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.edu.model.service.IMemberService;


@RestController
public class MemberAjaxController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IMemberService service;
	
	@PostMapping(value="/duplicateCheckId.do")
	public String duplicateCheckId(String id) {
		logger.info("아이디 중복 체크 duplicateCheckId 메소드. 파라미터 값 : {}",id);
		List<Integer> result = service.checkDuplicateId(id);
		return (result.get(0) > 0) ? "true" : "false";
	}
	
	@PostMapping(value="/duplicateCheckNick.do")
	public String duplicateCheckNick(String nickname) {
		logger.info("아이디 중복 체크 duplicateCheckNick 메소드. 파라미터 값 : {}",nickname);
		List<Integer> result = service.checkDuplicateNick(nickname);
		return (result.get(0) > 0) ? "true" : "false";
	}
	
}
