<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 데모</title>
	</head>
	<body>
		<h3>## 로그인 페이지 ##</h3>
		<form action="/admin/login.do"  method="post">
			<input type = "text" id="m_id" 		name="m_id" placeholder="아이디"><br>
			<input type = "password" id="m_pw"  name="m_pw" placeholder="비밀번호"><br>
			<button id = "login_process">로그인</button>
			<p>만약 로그인 할 계정이 없다면 <a href = "/demo/register">여기</a>를 눌러주세요.</p>
		</form>
	</body>
</html>