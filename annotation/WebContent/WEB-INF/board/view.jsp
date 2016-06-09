<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" session="true" import="java.util.*"%>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
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
		
		StringBuffer regDtm = new StringBuffer(board.getRegDtm());
		regDtm.insert(4, "-");
		regDtm.insert(7, "-");
		regDtm.insert(10, " ");
		regDtm.insert(13, ":");
		regDtm.insert(16, ":");
		if(board.getModDtm() != null) {
			regDtm.append(board.getModDtm());
			regDtm.insert(23, "-");
			regDtm.insert(26, "-");
			regDtm.insert(29, " ");
			regDtm.insert(32, ":");
			regDtm.insert(35, ":");
			regDtm.insert(19, "</span>&nbsp;&nbsp;<span class=\"fa fa-fw fa-refresh\"></span>&nbsp;<span class=\"text-primary\">");
			regDtm.append("</span>");
		}
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
								<h3 style="word-wrap:break-word;"><span class="fa fa-fw fa-star"></span>&nbsp;<%= newTitle %></h3>
								<h4 class="text-muted">
									<span class="fa fa-fw fa-flip-horizontal fa-slack"></span>&nbsp;<span class="text-primary"><%= board.getBoardNo() %></span>&nbsp;&nbsp;
									<span class="fa fa-fw fa-user"></span>&nbsp;<span class="text-primary"><%= board.getMemNm() %>(<%= board.getMemId() %>)</span>&nbsp;&nbsp;
									<span class="fa fa-fw fa-eye"></span>&nbsp;<span class="text-primary"><%= board.getCount() %></span>&nbsp;&nbsp;
									<span class="fa fa-fw fa-clock-o"></span>&nbsp;<span class="text-primary"><%= regDtm %></span>
								</h4>
						</div>
						<div class="panel-body">
							<p class="lead"><%= newText %></p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<a class="btn btn-lg btn-warning" href="modify.do?boardNo=<%= board.getBoardNo() %>"><span class="fa fa-fw fa-eraser"></span> 수정</a>
					<a class="btn btn-lg btn-danger" href="javascript:del(<%= board.getBoardNo() %>);"><span class="fa fa-fw fa-trash"></span> 삭제</a>
				</div>
			</div>
		</div>
	</div>
</body>

</html>

<jsp:include page="/board_list.do"></jsp:include>
