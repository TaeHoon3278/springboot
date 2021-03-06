package com.mhsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhsoft.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao m_dao;
	
	@Override
	public String getServerTime() {
		return m_dao.getServerTime();
	}
}
