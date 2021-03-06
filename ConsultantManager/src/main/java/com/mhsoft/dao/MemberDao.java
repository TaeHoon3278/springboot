package com.mhsoft.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	protected static final String NAMESPACE = "com.mhsoft.dao.";

	@Autowired
	private SqlSession m_session;

	public String getServerTime() {
		// TODO Auto-generated method stub
		return m_session.selectOne(NAMESPACE+"getServerTime");
	}
}
