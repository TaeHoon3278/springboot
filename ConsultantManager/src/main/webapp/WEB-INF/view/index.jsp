<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>A Simple CSS lyaout demo, Jiansen Lu</title>
  <style>
/* CSS Document */
#header, #mainContent, #footer{
    /*defaut all margin 0,  The browser calculates a margin*/
    margin:0 auto;
    width:100%;
    }
#header {
    height:100px;
    background:#9c6;
    /* header and main content distance 5 px */
    margin-bottom:5px;
    }
#mainContent {
    position:relative;
    height:400px;
    }
#sidebar {
    position:absolute;
    top:0;
    left:0;
    width:200px;
    height:398px;
    background:#cf9;
    }
#content {
    margin-left:202px;   
    width:558;
    height:398px;
    background:#ffa;
    }
#footer {
    height:60px;
    background:#9c6;
    }

  </style>
</head>
<body>
<div id="container">
  <div id="header">This is  Header</div>
  <div id="mainContent">
    <div id="sidebar">This is sidebar</div>
    <div id="content">This is content
		<table border="1">
			<tr>
				<th>번호</th>
				<th>ID</th>
				<th>이름</th>
				<th>권한</th>
			</tr>
				<c:forEach var="list" items="${listVO}">
			<tr>
				<td>${list.m_no }</td>
				<td>${list.m_id }</td>
				<td>${list.m_name }</td>
					
				<td><c:if test="${list.m_level eq 3}">최고 관리자</c:if></td>
			</tr>
				</c:forEach>
		</table>
	
	
	</div>
  </div>
  <div id="footer">This is footer<span style="display:none">
  </span></div>
</div>
</body>
</html>