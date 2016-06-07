<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.*,emp.dto.*"%>
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
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>Heading</h1>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form class="form-horizontal" role="form" name="loginform" method="post" action="login.do">
						<div class="form-group has-feedback">
							<div class="col-sm-2 text-right">
								<label for="memId" class="control-label">ID</label>
							</div>
							<div class="col-sm-10">
								<input type="text" class="form-control input-lg" id="memId" name="memId" placeholder="ID">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2 text-right">
								<label for="pwd" class="control-label">Password</label>
							</div>
							<div class="col-sm-10">
								<input type="password" class="form-control input-lg" id="pwd" name="pwd" placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-block btn-lg btn-success">
									<i class="fa fa-fw fa-sign-in"></i> 로그인
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