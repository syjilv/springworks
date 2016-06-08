<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" session="true" import="java.util.*" %>
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
		List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
		int count = (int) request.getAttribute("count");
		int pageNo = (int) request.getAttribute("page");
	
		int size = list.size();
	%>

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>게시판</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>제목</th>
								<th>작성자</th>
								<th>날짜</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < size; i++) {
									BoardDTO board = list.get(i);
									String newTitle = board.getTitle();
									newTitle = newTitle.replaceAll("′","'");
									newTitle = newTitle.replaceAll("\u0020","&nbsp;");
									newTitle = newTitle.replaceAll(">","&gt;");
									newTitle = newTitle.replaceAll("<","&lt;");
							%>
							<tr>
								<td><%= board.getBoardNo() %></td>
								<td><a href="view.do?boardNo=<%= board.getBoardNo() %>"><%= newTitle %></a></td>
								<td><%= board.getMemId() %></td>
								<td><%= board.getRegDtm() %></td>
								<td><%= board.getCount() %></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<a class="btn btn-default btn-lg"><i
						class="fa fa-fw -alt fa-th-list"></i> 목록</a> <a
						class="btn btn-lg btn-primary" href="write.do"><i
						class="-alt -list fa fa-fw fa-pencil"></i> 글쓰기</a>
				</div>
				<div class="col-md-6 text-right">
					<form role="form">
						<div class="form-group">
							<div class="input-group input-group-lg">
								<span class="input-group-btn">
									<a class="btn btn-primary dropdown-toggle"> 제목 <span class="fa fa-caret-down"></span></a>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">내용</a></li>
											<li><a href="#">내용</a></li>
										</ul>
								</span>
								<input type="search" class="form-control" placeholder="Enter your email">
								<span class="input-group-btn"> <a class="btn btn-danger" type="submit"><i class="fa fa-fw fa-search"></i> 검색</a>
								</span>
							</div>
						</div>
					</form>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<ul class="pagination pagination-lg">

						<% 	// 페이징 처리
							int startPage = 1;
							if(pageNo % 5 == 0) {
								startPage = pageNo - 4; 
							} else if (pageNo > 5) {
								startPage = pageNo - (pageNo % 5) + 1;
							}
						%>

						<% if(pageNo != 1) { %>
							<li class="disabled">
						<% } else { %>
							<li>
						<% } %>
							<a href="board_list.do?page=<%= pageNo - 1 %>">Prev</a></li>

						<%
						for(int j = 0; j < 5; j++) {
								int listPage = startPage + j;
								if(listPage == pageNo) {
						%>	
								<li class="active">
							<% } else { %>
								<li>
							<% } %>
								<a href="board_list.do?page=<%= listPage %>"><%= listPage %></a></li>
						<% } %>
						
						<% if(pageNo != 1) { %>
							<li class="disabled">
						<% } else { %>
							<li>
						<% } %>
							<a href="board_list.do?page=<%= pageNo + 1 %>">Next</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>









