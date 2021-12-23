package com.tour.edu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.IMemberDao;
import com.tour.edu.vo.MemberVo;


@Service
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	IMemberDao dao;

	@Override
	public List<MemberVo> login(MemberVo vo) {
		return dao.login(vo);
	}
	
	@Override
	public int updateFinalLogin(MemberVo vo) {
		return dao.updateFinalLogin(vo);
	}

	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVo vo) {
		return dao.updateMember(vo);
	}

	@Override
	public int joinMember(MemberVo vo) {
		return dao.joinMember(vo);
	}

	@Override
	public int panalty(String id) {
		return dao.panalty(id);
	}

	@Override
	public int deletePanalty(String id) {
		return dao.deletePanalty(id);
	}

	@Override
	public List<Integer> checkDuplicateId(String id) {
		return dao.checkDuplicateId(id);
	}

	@Override
	public List<Integer> checkDuplicateNick(String nickname) {
		return dao.checkDuplicateNick(nickname);
	}

	@Override
	public List<String> findId(MemberVo vo) {
		return dao.findId(vo);
	}

	@Override
	public List<String> findPw(MemberVo vo) {
		return dao.findPw(vo);
	}

	@Override
	public int setTemporaryPw(MemberVo vo) {
		return dao.setTemporaryPw(vo);
	}

}
