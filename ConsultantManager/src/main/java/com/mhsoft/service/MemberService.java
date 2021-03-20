package com.mhsoft.service;

import java.util.List;
import java.util.Map;

import com.mhsoft.vo.MemberVO;

public interface MemberService {
	public String getServerTime();
	public MemberVO doLogin(String id, String pw);
}
