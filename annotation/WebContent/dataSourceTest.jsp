<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>JNDI - Java Naming Directory Interface �� �̿��Ͽ� Ŀ�ؼ� Ǫ���� �����ϱ�</h1>
	<hr/>
	<h3>WAS���� �����ϴ� Ŀ�ؼ�Ǯ�� �̿��Ͽ� Ŀ�ؼ� �����ϱ� - 
		<small>WAS���� ��ϵ� Ŀ�ؼ�Ǯ�� �����ϴ� ����� ��� �ٸ� ���̹Ƿ� Ŀ�ؼ��� ���� �� �ִ� ǥ�� API�� �־�� �ϸ�
		javax.sql��Ű���� DataSource�� ǥ�� API�̴�.
		context.xml�� &lt;resource&gt;�� ��ϵǾ� �ִ� name���� lookup�ؼ� ã�ƿ� �� �̿��Ѵ�.</small></h3>
	<%
		//1. WAS�� ��ϵ� �ڿ��� ã�ƿ��� ���� ��ü�� ����
		InitialContext context = new InitialContext();
	
		//2. InitialContext��ü�� lookup �޼ҵ忡 ã�� resource�� �̸��� �����Ͽ� �ڿ��� ã�ƿ´�.
		//=> WAS�� ��ϵ� Ŀ�ؼ�Ǯ�� ������ �� �ִ� ��ü�� �޾ƿ´�.
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/myspring");
		// ������ DriverManager�� �̿��ؼ� Connection�� ���ϴ� �۾��� ��û�� ���� �� ���� Connection�� ����� ����������
		// DataSource�� �̿��ؼ� Connection�� ���ϴ� �۾��� �̸� ����� ���� Ŀ�ؼ�Ǯ�� �����ؼ� Ŀ�ؼ��� �޾ƿ� �����Ѵ�.
		Connection con = ds.getConnection();
		System.out.println("con->" + con);
	%>
</body>
</html>