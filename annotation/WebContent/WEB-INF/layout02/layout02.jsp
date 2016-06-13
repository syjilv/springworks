<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	#header {
		height:20%;
	}
	#left {
		width:25%;
		height:70%;
		float:left;
	}
	#content {
		width:75%;
		height:70%;
		float:right;
	}
	#footer {
		height:10%;
		clear:both;
	}
</style>
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div id="left">
		<tiles:insertAttribute name="left"></tiles:insertAttribute>
	</div>
	<div id="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>