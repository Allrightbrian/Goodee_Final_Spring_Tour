package com.tour.edu.model.service;

import java.util.List;

import com.tour.edu.vo.MemberVo;

public interface IMemberService {
	public List<MemberVo> login(MemberVo vo);
	public int deleteMember(String id);
	public int updateMember(MemberVo vo);
	public int joinMember(MemberVo vo);
	public int panalty(String id);
	public int deletePanalty(String id);
	public List<Integer> checkDuplicateId(String id);
	public List<Integer> checkDuplicateNick(String nickname);
	
}
