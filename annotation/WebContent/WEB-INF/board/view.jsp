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
	<script type="text/javascript">
		function del(boardNo) {
		    if (confirm("삭제하시겠습니까?") == true) {
				location.href='del.do?boardNo=' + boardNo;
		    } else {
		        alert('취소되었습니다.');
		    }
		}
		</script>
	</script>
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
								<div class="col-md-3">
									<h4 class="text-muted text-right"><%= board.getBoardNo() %></h4>
								</div>
								<div class="col-md-3">
									<h4 class="text-muted text-right"><%= board.getRegDtm() %></h4>
								</div>
								<div class="col-md-3">
									<h4 class="text-muted text-right"><%= board.getModDtm() %></h4>
								</div>
								<div class="col-md-3">
									<h4 class="text-muted text-right"><%= board.getCount() %></h4>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<p><%= newText %></p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<a class="btn btn-lg btn-warning" href="modify.do?boardNo=<%= board.getBoardNo() %>"><i class="fa fa-fw fa-eraser"></i> 수정</a>
					<a class="btn btn-lg btn-danger" href="javascript:del(<%= board.getBoardNo() %>);"><i class="fa fa-fw fa-trash"></i> 삭제</a>
				</div>
			</div>
		</div>
	</div>
</body>

</html>

<jsp:include page="/board_list.do"></jsp:include>
