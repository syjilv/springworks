<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" session="true" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% MemberDTO mem = (MemberDTO) session.getAttribute("mem"); %>

	<div>
		<h1>메인페이지(어노테이션)</h1>

		<hr/>
		<% if(mem != null) { %>
			<h3>아이디 : <%= mem.getMemId() %></h3>
			<h3>이  름 : <%= mem.getMemNm() %></h3>
			<h3><a href="logout.do">로그아웃</a></h3>
			<h3><a href="write.do">글쓰기</a></h3>
		<% } else { %>
			<h3><a href="login.do">로그인</a></h3>
		<% } %>
		<hr/>
		<h3><a href="test.do">스프링 웹 MVC연동하기</a></h3>
		<h3><a href="insert.do">회원가입</a></h3>
		<h3><a href="list.do">회원목록</a></h3>
		<h3><a href="search.do">회원검색</a></h3>
		<h3><a href="board_list.do">게시판</a></h3>
	</div>
</body>
</html>










