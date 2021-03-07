package com.mhsoft.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mhsoft.vo.MemberVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class MemberDao {
	
	private Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	protected static final String NAMESPACE = "com.mhsoft.dao.";

	@Autowired
	private SqlSession m_session;

	public String getServerTime() {
		// TODO Auto-generated method stub
		return m_session.selectOne(NAMESPACE+"getServerTime");
	}

	public List<MemberVO> doLogin(String id, String pw) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		
		List<MemberVO> list = m_session.selectList(NAMESPACE+"doLogin", map);
		return list;
	}
}
