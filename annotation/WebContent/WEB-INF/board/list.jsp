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
		int size = list.size();
		
		// ��¥ ó����
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dff = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar c = Calendar.getInstance();
		String today = df.format(c.getTime());
		Long todayFull = Long.parseLong(dff.format(c.getTime()));
	%>

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>�Խ��� 
					<!-- �α��� ���� ǥ�� -->
					<% if(session.getAttribute("mem") != null) { %>
						<small> ${mem.memId} <a href="logout.do?ref=board_list">(�α׾ƿ�)</a></small>
					<% } else { %>
						<small> <a href="login.do?ref=board_list">�α���</a></small>
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
								<th class="text-center col-md-6">����</th>
								<th class="text-center col-md-2">�ۼ���</th>
								<th class="text-center col-md-2">��¥</th>
								<th class="text-center col-md-1">��ȸ��</th>
							</tr>
						</thead>
						<tbody>
						<%
							for (int i = 0; i < size; i++) {
								BoardDTO board = list.get(i);
								// ���� �̱���Ʈ, �±�, ���� ó��
								String newTitle = board.getTitle();
								// ���� �ʹ� ��� �ڸ���
								if(newTitle.length() > 50) {
									newTitle = newTitle.substring(0, 50) + "...";
								}
								newTitle = newTitle.replaceAll("��","'");
								newTitle = newTitle.replaceAll("\u0020","&nbsp;");
								newTitle = newTitle.replaceAll(">","&gt;");
								newTitle = newTitle.replaceAll("<","&lt;");
								// �ð�/��¥ ǥ�ø� ���� String ������
								String showDate = "";
								String writeDtm = board.getRegDtm();
								String writeDate = writeDtm.substring(0, 8);
								String writeTime = writeDtm.substring(8);
								// ���� �ۼ��� ���̸� �ð� ǥ��, �ƴϸ� ��¥ ǥ��
								if(today.equals(writeDate)) {
									showDate = writeTime.substring(0, 2) + ":" + writeTime.substring(2, 4) + ":" + writeTime.substring(4);
								} else {
									showDate = writeDate.substring(0,4) + "-" + writeDate.substring(4,6) + "-" + writeDate.substring(6);
								}
								
								// �ۼ����� 12�ð� �̳��� New ���� �޾��ֱ�
								Long hourGap = todayFull - 120000;
								String titleBadge = newTitle + "</a>";
								// 12�� �����̸� �Ϸ� �� ���� - ���� �Ѿ�°� �׳� ���������� ������ �϶�� ó�� ����
								if((hourGap - Long.parseLong(today + "000000")) < 0) {
									hourGap = hourGap - 760000;
								}
								if(hourGap <= Long.parseLong(writeDtm)) {
									titleBadge += "</a> <sup><span class=\"label label-warning\">New</span></sup>";
								}
								
								// �Խù� ���� �ؿ� �ٴ� ����Ʈ�� ��� ���� ���� �ִ� �Խù��� ��ĥ 
								String currentBoardNo = board.getBoardNo();
								if(boardNo != null && boardNo.equals(board.getBoardNo())) {
									currentBoardNo = "<span class=\"fa fa-fw fa-angle-double-right\"></span>";	
								%>
									<tr class="active">
								<% } else { %>
									<tr>
								<% } %>
									<td class="text-center"><%= currentBoardNo %></td>
									<td class="text-left"><a href="view.do?pageNo=<%= pageNo %>&boardNo=<%= board.getBoardNo() %>"><%= titleBadge %></td>
									<td class="text-center"><%= board.getMemNm() %><small>(<%= board.getMemId() %>)</small></td>
									<td class="text-center"><%= showDate %></td>
									<td class="text-center"><%= board.getCount() %></td>
								</tr>
						<% } %>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<a class="btn btn-default btn-lg" href="board_list.do?pageNo=<%= pageNo %>"><span class="fa fa-fw fa-th-list"></span> ���</a>
				</div>
				<div class="col-md-6">
					<form>
						<div class="input-group input-group-lg">
							<select class="form-control input-lg" style="width:30%">
								<option>����</option>
								<option>����+����</option>
								<option>�ۼ���(�̸�)</option>
								<option>�ۼ���(ID)</option>
							</select>

							<input type="text" class="form-control" placeholder="�˻��� �� �� �ֽ��ϴ�" style="width:70%">
							<span class="input-group-btn">
								<button class="btn btn-default btn-success" type="button"><span class="fa fa-fw fa-search"></span> ã��</button>
							</span>
						</div>
					</form>
				</div>
				<div class="col-md-3 text-right">
					<a class="btn btn-lg btn-primary" href="write.do"><span class="fa fa-fw fa-pencil"></span> �۾���</a>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<ul class="pagination pagination-lg">

						<% 	// ����¡���� �������� ù ������
						int startPage = 1;
						if(pageNo % 5 == 0) {
							startPage = pageNo - 4; 
						} else if (pageNo > 5) {
							startPage = pageNo - (pageNo % 5) + 1;
						}
						// ��ü �Խù��� ������ ������
						int lastPage = 0;
						if((count % 10) == 0) {
							lastPage = (count / 10);
						} else {
							lastPage = (count / 10) + 1;
						}
						
						// Prev ó��
						if(pageNo == 1) { %>
							<li class="disabled"><a href="#">Prev</a></li>
						<% } else { %>
								<li><a href="board_list.do?pageNo=<%= pageNo - 1 %>">Prev</a></li>
						<% }
						// �� �������� 5������ �̸��� ��� ����¡ ó��
						int pageSize = 5;
						if((startPage + 4) > lastPage) {
							pageSize = lastPage - startPage + 1;
						}
						// ����¡ ǥ�� �� ��ũ ó��
						for(int j = 0; j < pageSize; j++) {
							int showPage = startPage + j;
							if(showPage == pageNo) {
						%>
								<li class="active">
						<% } else { %>
								<li>
						<% } %>
								<a href="board_list.do?pageNo=<%= showPage %>"><%= showPage %></a></li>
						<% }
						// Next ó��
						if(pageNo == lastPage) { %>
							<li class="disabled"><a href="#">Next</a></li>
						<% } else { %>
							<li><a href="board_list.do?pageNo=<%= pageNo + 1 %>">Next</a></li>
						<% } %>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>