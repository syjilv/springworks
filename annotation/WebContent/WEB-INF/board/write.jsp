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
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>�Խù� �ۼ�</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form class="form-horizontal" role="form">
						<div class="form-group" id="title">
							<div class="col-md-2 text-right">
								<label for="title" class="control-label">����</label>
							</div>
							<div class="col-md-10">
								<input type="text" class="form-control input-lg" id="title"
									placeholder="����">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 text-right">
								<label for="text" class="control-label">����</label>
							</div>
							<div class="col-md-10">
								<textarea class="form-control" rows="20" id="text"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12 text-center">
								<button type="submit" class="btn btn-lg btn-primary">
									<i class="fa fa-fw fa-check"></i>�۾���
								</button>
								<button type="submit" class="btn btn-danger btn-lg">
									<i class="fa fa-fw fa-close"></i>���
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