<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.*,emp.dto.*"%>
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
		List<MyEmpDTO> userlist = (List<MyEmpDTO>) request
				.getAttribute("userlist");
		int size = userlist.size();
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
							%>
							<tr>
								<td>1</td>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
								<td>@mdo</td>
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
						class="btn btn-lg btn-primary"><i
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
						<ul class="pagination">
							<li><a href="#">Prev</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">Next</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
</body>

</html>









