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
		<h1>����������(������̼�)</h1>

		<hr/>
		<% if(mem != null) { %>
			<h3>���̵� : <%= mem.getMemId() %></h3>
			<h3>��  �� : <%= mem.getMemNm() %></h3>
			<h3><a href="logout.do?ref=index">�α׾ƿ�</a></h3>
		<% } else { %>
			<h3><a href="login.do?ref=index">�α���</a></h3>
		<% } %>
		<hr/>
		<h3><a href="test.do">������ �� MVC�����ϱ�</a></h3>
		<h3><a href="insert.do">ȸ������</a></h3>
		<h3><a href="list.do">ȸ�����</a></h3>
		<h3><a href="search.do">ȸ���˻�</a></h3>
		<h3><a href="board_list.do">�Խ���</a></h3>
	</div>
</body>
</html>








