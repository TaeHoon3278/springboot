<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹페이지 테스트</title>
</head>
<body>
<c:if test="${member != null}">
aaa : ${member}
<a href="/admin/logout.do">로그아웃</a>
</c:if>
<c:if test="${member == null}">
로그아웃</c:if>
</body>
</html>