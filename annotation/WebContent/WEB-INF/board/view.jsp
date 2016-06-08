<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" session="true" import="java.util.*"%>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>

<body>
	<%
		BoardDTO board = (BoardDTO) request.getAttribute("board");
		String newTitle = board.getTitle();
		newTitle = newTitle.replaceAll("′","'");
		newTitle = newTitle.replaceAll("\u0020","&nbsp;");
		newTitle = newTitle.replaceAll(">","&gt;");
		newTitle = newTitle.replaceAll("<","&lt;");

		String newText = board.getText();
		newText = newText.replaceAll("′","'");
		newText = newText.replaceAll("\u0020","&nbsp;");		
		newText = newText.replaceAll(">","&gt;");
		newText = newText.replaceAll("<","&lt;");
		newText = newText.replaceAll("\r\n","<br>");
		%>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>게시물 조회</h1>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-8">
									<h4><%= newTitle %></h4>
								</div>
								<div class="col-md-4">
									<h4 class="text-muted text-right"><%= board.getMemId() %></h4>
								</div>
								<div class="col-md-4">
									<h4 class="text-muted text-right"><%= board.getBoardNo() %></h4>
								</div>
								<div class="col-md-4">
									<h4 class="text-muted text-right"><%= board.getRegDtm() %></h4>
								</div>
								<div class="col-md-4">
									<h4 class="text-muted text-right">글쓴이</h4>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<p><%= newText %></p>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>