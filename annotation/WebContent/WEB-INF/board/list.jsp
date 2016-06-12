<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" session="true" import="java.util.*" %>
<%@page import="java.text.SimpleDateFormat"%><%@page import="board.dto.BoardDTO"%>
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
	<%
		List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
		int count = (int) request.getAttribute("count");
		int pageNo = (int) request.getAttribute("pageNo");
		String boardNo = (String) request.getAttribute("boardNo");
		String target = (String) request.getAttribute("target");
		String keyword = (String) request.getAttribute("keyword");
		String mode = (String) request.getAttribute("mode");
		int size = list.size();
		
		// 검색일 경우와 아닐 경우 체크
		String modeRef = "board_list.do?";
		if(mode.equals("search")) {
			modeRef = "board_search.do?target=" + target + "&keyword=" + keyword + "&";
		}
		
		// 날짜 처리용
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dff = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar c = Calendar.getInstance();
		String today = df.format(c.getTime());
		Long todayFull = Long.parseLong(dff.format(c.getTime()));
	%>
	
<script>
// 전송 전 체크
function searchCheck() {
	if(searchform.keyword.value.length == 0) {
		alert("검색어를 입력해 주세요.");
		searchform.keyword.focus();
		return false;
	} else if(searchform.keyword.value.length <= 1) {
		alert("검색어는 2자 이상 입력해 주세요.");
		searchform.keyword.focus();
		return false;
	}
	else return true;
}
</script>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>게시판 
					<!-- 로그인 상태 표시 -->
					<% if(session.getAttribute("mem") != null) { %>
						<small> ${mem.memId} <a href="logout.do?ref=board_list">(로그아웃)</a></small>
					<% } else { %>
						<small> <a href="login.do?ref=board_list">로그인</a></small>
					<% } %>
					</h1>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover">
						<thead>
							<tr class="active">
								<th class="text-center col-md-1">#</th>
								<th class="text-center col-md-6">제목</th>
								<th class="text-center col-md-2">작성자</th>
								<th class="text-center col-md-2">날짜</th>
								<th class="text-center col-md-1">조회수</th>
							</tr>
						</thead>
						<tbody>
						<% if (count == 0) { %>
							<tr class="text-center">
								<td colspan="5">내용이 없습니다.</td>
							</tr>
						<% 	} else {
								for (int i = 0; i < size; i++) {
									BoardDTO board = list.get(i);
									// 제목 싱글쿼트, 태그, 공백 처리
									String newTitle = board.getTitle();
									// 제목 너무 길면 자르기
									if(newTitle.length() > 50) {
										newTitle = newTitle.substring(0, 50) + "...";
									}
									newTitle = newTitle.replaceAll("′","'");
									newTitle = newTitle.replaceAll("\u0020","&nbsp;");
									newTitle = newTitle.replaceAll(">","&gt;");
									newTitle = newTitle.replaceAll("<","&lt;");
									// 시간/날짜 표시를 위한 String 무더기
									String showDate = "";
									String writeDtm = board.getRegDtm();
									String writeDate = writeDtm.substring(0, 8);
									String writeTime = writeDtm.substring(8);
									// 오늘 작성된 글이면 시간 표출, 아니면 날짜 표출
									if(today.equals(writeDate)) {
										showDate = writeTime.substring(0, 2) + ":" + writeTime.substring(2, 4) + ":" + writeTime.substring(4);
									} else {
										showDate = writeDate.substring(0,4) + "-" + writeDate.substring(4,6) + "-" + writeDate.substring(6);
									}
									
									// 작성한지 12시간 이내면 New 뱃지 달아주기
									Long hourGap = todayFull - 120000;
									String titleBadge = newTitle + "</a>";
									// 12시 이전이면 하루 더 빼줌 - 연월 넘어가는건 그냥 새마음으로 새시작 하라고 처리 안함
									if((hourGap - Long.parseLong(today + "000000")) < 0) {
										hourGap = hourGap - 760000;
									}
									if(hourGap <= Long.parseLong(writeDtm)) {
										titleBadge += "</a> <sup><span class=\"label label-warning\">New</span></sup>";
									}
									
									// 게시물 보기 밑에 붙는 리스트일 경우 현재 보고 있는 게시물 표시
									String currentBoardNo = board.getBoardNo();
									if(boardNo != null && boardNo.equals(board.getBoardNo())) {
										currentBoardNo = "<span class=\"fa fa-fw fa-angle-double-right\"></span>";	
									%>
										<tr class="active">
									<% } else { %>
										<tr>
									<% } %>
										<td class="text-center"><%= currentBoardNo %></td>
										<% if(mode.equals("search")) { %>
											<td class="text-left"><a href="view.do?mode=<%= mode %>&target=<%= target %>&keyword=<%= keyword %>&pageNo=<%= pageNo %>&boardNo=<%= board.getBoardNo() %>"><%= titleBadge %></td>
										<% } else { %>
											<td class="text-left"><a href="view.do?pageNo=<%= pageNo %>&boardNo=<%= board.getBoardNo() %>"><%= titleBadge %></td>
										<% } %>

										<td class="text-center"><%= board.getMemNm() %><small>(<%= board.getMemId() %>)</small></td>
										<td class="text-center"><%= showDate %></td>
										<td class="text-center"><%= board.getCount() %></td>
									</tr>
							<% } %>
						<% } %>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<a class="btn btn-default btn-lg" href="board_list.do?pageNo=<%= pageNo %>"><span class="fa fa-fw fa-th-list"></span> 목록</a>
				</div>
				<!-- 검색폼을 난 왜 붙여서 고생하는가 -->
				<div class="col-md-6">
					<form role="form" name="searchform" action="board_search.do" method="GET" onsubmit="return searchCheck()">
						<div class="input-group input-group-lg">
							<select class="form-control input-lg" name="target" style="width:30%">
							<% 	// 검색했을 경우 선택값 selected 체크
								String targetSelect1 = "";
								String targetSelect2 = "";
								String targetSelect3 = "";
								String targetSelect4 = "";
								
								if(target != null) {
									switch(target) {
									case "title" :
										targetSelect1 = "selected";
										break;
									case "all" :
										targetSelect2 = "selected";
										break;
									case "memNm" :
										targetSelect3 = "selected";
										break;
									case "memId" :
										targetSelect4 = "selected";
										break;
									}
								}
							%>
								<option value="title" <%= targetSelect1 %>>제목</option>
								<option value="all" <%= targetSelect2 %>>제목+내용</option>
								<option value="memNm" <%= targetSelect3 %>>작성자(이름)</option>
								<option value="memId" <%= targetSelect4 %>>작성자(ID)</option>
							</select>
							<!-- 키워드 표시 -->
							<% if (keyword != null) { %>
								<input type="text" class="form-control" name="keyword" value="<%= keyword %>" style="width:70%">
							<% } else { %>
								<input type="text" class="form-control" name="keyword" placeholder="검색도 할 수 있습니다" style="width:70%">
							<% } %>
							<input type="hidden" name="pageNo" value="1">
							<span class="input-group-btn">
								<button class="btn btn-default btn-success" type="submit"><span class="fa fa-fw fa-search"></span> 찾기</button>
							</span>
						</div>
					</form>
				</div>
				<!-- 검색폼 끝 -->
				<div class="col-md-3 text-right">
					<a class="btn btn-lg btn-primary" href="write.do"><span class="fa fa-fw fa-pencil"></span> 글쓰기</a>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<ul class="pagination pagination-lg">

						<% 	// 페이징에서 보여지는 첫 페이지
						int startPage = 1;
						if(pageNo % 5 == 0) {
							startPage = pageNo - 4; 
						} else if (pageNo > 5) {
							startPage = pageNo - (pageNo % 5) + 1;
						}
						// 전체 게시물의 마지막 페이지
						int lastPage = 0;
						if((count % 10) == 0) {
							lastPage = (count / 10);
						} else {
							lastPage = (count / 10) + 1;
						}
						
						// Prev 처리
						if(pageNo == 1) { %>
							<li class="disabled"><a href="#">Prev</a></li>
						<% } else { %>
								<li><a href="<%= modeRef %>pageNo=<%= pageNo - 1 %>">Prev</a></li>
						<% }
						// 총 페이지가 5페이지 미만일 경우 페이징 처리
						int pageSize = 5;
						if((startPage + 4) > lastPage) {
							pageSize = lastPage - startPage + 1;
						}
						// 페이징 표시 및 링크 처리
						for(int j = 0; j < pageSize; j++) {
							int showPage = startPage + j;
							if(showPage == pageNo) {
						%>
								<li class="active">
						<% } else { %>
								<li>
						<% } %>
								<a href="<%= modeRef %>pageNo=<%= showPage %>"><%= showPage %></a></li>
						<% }
						// Next 처리
						if(pageNo == lastPage) { %>
							<li class="disabled"><a href="#">Next</a></li>
						<% } else { %>
							<li><a href="<%= modeRef %>pageNo=<%= pageNo + 1 %>">Next</a></li>
						<% } %>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>