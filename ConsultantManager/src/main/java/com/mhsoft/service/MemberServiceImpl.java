package com.mhsoft.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhsoft.dao.MemberDao;
import com.mhsoft.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao m_dao;
	
	@Override
	public String getServerTime() {
		return m_dao.getServerTime();
	}

	@Override
	public List<MemberVO> doLogin(String id, String pw) {
		// TODO Auto-generated method stub
		return m_dao.doLogin(id, pw);
	}
}
