<%@page import="member.dto.MemberDTO"%>
<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" session="true" import="java.util.*,emp.dto.*"%>
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
<script>
<% 	BoardDTO board = (BoardDTO) request.getAttribute("board");
	MemberDTO mem = (MemberDTO) session.getAttribute("mem");

	// 임의 접근 차단 - 작성자와 로그인 아이디가 다를 경우 리스트로 리다이렉트
	if(mem != null && !mem.getMemId().equals(board.getMemId()) || mem == null) { %>
		alert('잘못된 접근입니다.');
		location.href='board_list.do';
<%	} %>
	// 전송 전 체크
	function modCheck() {
		if(modifyform.title.value == "") {
			alert("제목을 입력해 주세요.");
			modifyform.title.focus();

		} else if(modifyform.title.value.length >= 20) {
			alert("제목 사이즈는 주세요.");
			modifyform.title.focus();
			return false;
		} else if(modifyform.text.value == "") {
			alert("내용을 입력해 주세요.");
			modifyform.text.focus();
			return false;
		}
		else return true;
	}


</script>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>게시물 수정</h1>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form class="form-horizontal" role="form" name="modifyform" action="modify.do" method="POST" onsubmit="return modCheck()">
						<div class="form-group">
							<div class="col-md-2 text-right">
								<label for="title" class="control-label">제목</label>
							</div>
							<div class="col-md-10">
								<input type="text" class="form-control input-lg" name="title" id="title" value="<%= board.getTitle() %>">
								<input type="hidden" name="boardNo" value="<%= board.getBoardNo() %>">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 text-right">
								<label for="text" class="control-label">내용</label>
							</div>
							<div class="col-md-10">
								<textarea class="form-control" rows="20" name="text" id="text"><%= board.getText() %></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12 text-center">
								<button type="submit" class="btn btn-lg btn-warning" onclick>
									<span class="fa fa-fw fa-check"></span> 수정
								</button>
								<button type="button" class="btn btn-danger btn-lg" onclick=>
									<span class="fa fa-fw fa-close"></span> 취소
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>