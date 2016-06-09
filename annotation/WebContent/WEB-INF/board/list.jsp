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
		int pageNo = (int) request.getAttribute("page");
		int size = list.size();
		
		// ��¥ ó����
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		String today = df.format(c.getTime());
	%>

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>�Խ���<small> Login status : ${sessionScope.mem.memId} <a href="logout.do">�α׾ƿ�</a></small></h1>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
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
								newTitle = newTitle.replaceAll("��","'");
								newTitle = newTitle.replaceAll("\u0020","&nbsp;");
								newTitle = newTitle.replaceAll(">","&gt;");
								newTitle = newTitle.replaceAll("<","&lt;");
								// ���� �ۼ��� ���̸� �ð� ǥ��, �ƴϸ� ��¥ ǥ��
								String showDate = "";
								String writeDate = board.getRegDtm().substring(0, 8);
								String writeTime = board.getRegDtm().substring(8);
								String titleBadge = newTitle + "</a>";	// �� ���� New ����
								
								if(today.equals(writeDate)) {
									showDate = writeTime.substring(0, 2) + ":" + writeTime.substring(2, 4) + ":" + writeTime.substring(4);
									titleBadge += "</a> <small><span class=\"label label-info\">New</span></small>";
								} else {
									showDate = writeDate.substring(0,4) + "-" + writeDate.substring(4,6) + "-" + writeDate.substring(6);
								}
						%>
								<tr>
									<td class="text-center"><%= board.getBoardNo() %></td>
									<td class="text-left"><a href="view.do?boardNo=<%= board.getBoardNo() %>"><%= titleBadge %></td>
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
					<a class="btn btn-default btn-lg" href="board_list.do?page=<%= pageNo %>"><i class="fa fa-fw -alt fa-th-list"></i> ���</a>
				</div>
				<div class="col-md-6">
					<form role="form">
						<div class="form-group">
							<div class="input-group input-group-lg">
									<select class=" form-control" style="width:20%">
										<option>1</option>
									</select>
								<input type="search" class="form-control" style="width:80%" placeholder="������ �ϰ���">
								<span class="input-group-btn">
									<a class="btn btn-success" type="submit"><i class="fa fa-fw fa-search"></i> �˻�</a>
								</span>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-3 text-right">
					<a class="btn btn-lg btn-primary" href="write.do"><i class="-alt -list fa fa-fw fa-pencil"></i> �۾���</a>
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
								<li><a href="board_list.do?page=<%= pageNo - 1 %>">Prev</a></li>
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
								<a href="board_list.do?page=<%= showPage %>"><%= showPage %></a></li>
						<% }
						// Next ó��
						if(pageNo == lastPage) { %>
							<li class="disabled"><a href="#">Next</a></li>
						<% } else { %>
							<li><a href="board_list.do?page=<%= pageNo + 1 %>">Next</a></li>
						<% } %>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>