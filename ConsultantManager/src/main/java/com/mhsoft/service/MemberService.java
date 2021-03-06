package com.mhsoft.service;

public interface MemberService {
	public String getServerTime();

	public boolean doLogin(String id, String pw);
}
