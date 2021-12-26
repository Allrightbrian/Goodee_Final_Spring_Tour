package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.MemberVo;


@Repository
public class MemberDaoImpl implements IMemberDao{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS = "com.tour.edu.model.dao.MemberDaoImpl.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberVo> login(MemberVo vo) {
		logger.info("MemberDaoImpl의 login 메소드 : {}", vo);
		return sqlSession.selectList(NS+"login", vo);
	}
	
	@Override
	public int updateFinalLogin(MemberVo vo) {
		return sqlSession.update(NS+"updateFinalLogin", vo);
	}

	@Override
	public int deleteMember(String id) {
		logger.info("MemberDaoImpl의 deleteMember 메소드 : {}", id);
		return sqlSession.update(NS+"deleteMember", id);
	}

	@Override
	public int updateMember(MemberVo vo) {
		logger.info("MemberDaoImpl의 updateMember 메소드 : {}", vo);
		return sqlSession.update(NS+"updateMember", vo);
	}

	@Override
	public int joinMember(MemberVo vo) {
		logger.info("MemberDaoImpl의 joinMember 메소드 : {}", vo);
		return sqlSession.insert(NS+"joinMember", vo);
	}

	@Override
	public int panalty(String id) {
		logger.info("MemberDaoImpl의 joinMember 메소드 : {}", id);
		return sqlSession.update(NS+"joinMember", id);
	}

	@Override
	public int deletePanalty(String id) {
		logger.info("MemberDaoImpl의 deletePanalty 메소드 : {}", id);
		return sqlSession.update(NS+"deletePanalty", id);
	}

	@Override
	public List<Integer> checkDuplicateId(String id) {
		logger.info("MemberDaoImpl의 checkDuplicateId 메소드 : {}", id);
		return sqlSession.selectList(NS+"checkDuplicateId", id);
	}

	@Override
	public List<Integer> checkDuplicateNick(String nickname) {
		logger.info("MemberDaoImpl의 checkDuplicateNick 메소드 : {}", nickname);
		return sqlSession.selectList(NS+"checkDuplicateNick", nickname);
	}

	@Override
	public List<String> findId(MemberVo vo) {
		logger.info("MemberDaoImpl의 findId 메소드 : {}", vo);
		return sqlSession.selectList(NS+"findId", vo);
	}

	@Override
	public List<String> findPw(MemberVo vo) {
		logger.info("MemberDaoImpl의 findPw 메소드 : {}", vo);
		return sqlSession.selectList(NS + "findPw", vo);
	}

	@Override
	public int setTemporaryPw(MemberVo vo) {
		logger.info("MemberDaoImpl의 setTemporaryPw 메소드 : {}", vo);
		return sqlSession.update(NS+"setTemporaryPw", vo);
	}
	
}
