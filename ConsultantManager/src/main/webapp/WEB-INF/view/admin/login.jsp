<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 데모</title>
		<style type="text/css">
		<!--
		table.t1 {border: #000000 solid; border-width: 0px 0px 0px 0px}
		table.t2 {border: #000000 solid; border-width: 0px 1px 0px 1px}
		-->
		</style>
	</head>
	
<body>
	<table class="t1" style="margin:0px auto" border="1">
		<tr>
			<td><h3>## 로그인 페이지 ##</h3></td>
			<td>
				<form action="/admin/login.do"  method="post">
				<input type = "text" 	 id="m_id" 	name="m_id" placeholder="아이디"><br>
				<input type = "password" id="m_pw"  name="m_pw" placeholder="비밀번호"><br>
				<button id = "login_process">로그인</button>
				<p>만약 로그인 할 계정이 없다면 <a href = "/demo/register">여기</a>를 눌러주세요.</p>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>