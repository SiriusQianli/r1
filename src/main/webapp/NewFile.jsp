<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 引入jquery -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-3.3.1.min.js"></script>
<!-- 引入样式 -->
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH }/static/js/jquerysession.js"></script>
<script type="text/javascript">
	//默认未登录状态下不可评分和增删改查
	$(document).ready(function() {
		$("#markk").attr("disabled", true);
		$("#manage").attr("disabled", true);
	})

	$("#login").click(function() {
		alert("fdsf");
		 		$("#userLoginModal").modal({
		 backdrop : "static"
		 }); 
	});
</script>
</head>
<body>

	<div class="modal fade" id="userLoginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">登陆</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" accept-charset="UTF-8">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" name="name" class="form-control" id="name">
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="password" name="password" class="form-control"
									id="password"> <span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="user_login_btn">登陆</button>
				</div>
			</div>
		</div>
	</div>
	<input type="button" class="btn btn-default" id="login" name="login"
		value="登陆">
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#home" data-toggle="tab"> 主页</a></li>
		<li><a href="#main" data-toggle="tab"> 查看</a></li>
		<li><a href="#mark" data-toggle="tab" id="markk" name="markk">评分</a></li>
		<li class="dropdown"><a id="manage" name="manage" href="#"
			id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown">管理
				<b class="caret"></b>
		</a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
				<li><a id="manage1" name="manage1" href="#marks" tabindex="-1"
					data-toggle="tab"> 考核项目</a></li>
				<li><a id="manage2" name="manage2" href="#employee"
					tabindex="-1" data-toggle="tab"> 员工</a></li>
				<li><a id="manage3" name="manage3" href="#department"
					tabindex="-1" data-toggle="tab">部门</a></li>
				<li><a id="manage4" name="manage4" href="#item"
					tabindex="-1" data-toggle="tab">总分类</a></li>
			</ul></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="home">
			<p>MainPage</p>
		</div>
		<div class="tab-pane fade" id="main">
			<iframe src="index4.jsp" width="100%" frameborder="0" height="800"></iframe>

		</div>
		<div class="tab-pane fade" id="mark">
			<iframe src="index.jsp" width="100%" frameborder="0" height="800"
				onload="this.height=Info1.document.body.scrollHeight"></iframe>

		</div>
		<div class="tab-pane fade" id="employee">
			<iframe src="index2.jsp" width="100%" frameborder="0" height="800"
				onload="this.height=Info1.document.body.scrollHeight"></iframe>
		</div>
		<div class="tab-pane fade" id="marks">
			<iframe src="index3.jsp" width="100%" frameborder="0" height="800"></iframe>
		</div>
		<div class="tab-pane fade" id="department">
			<iframe src="index5.jsp" width="100%" frameborder="0" height="800"></iframe>
		</div>
				<div class="tab-pane fade" id="item">
			<iframe src="itemCRUD.jsp" width="100%" frameborder="0" height="800"></iframe>
		</div>
	</div>
	<script>
		$(function() {
			$('#myTab li:eq(0) a').tab('show');
		});

		$("#login").click(function() {
			$("#userLoginModal").modal({
				backdrop : "static"
			});
		});
		$("#user_login_btn").click(function() {
			var username = $.trim($("#name").val());
			var password = $.trim($("#password").val());
			if (username == "") {
				alert("请输入用户名");
				return false;
			} else if (password == "") {
				alert("请输入密码");
				return false;
			}
			$.ajax({
				url : "${APP_PATH}/login",
				type : "POST",
				data : {
					"name" : username,
					"password" : password
				},
				success : function(result) {
					$("#userLoginModal").modal('hide');
					var i = result.extend.emp;
					 $.session.set('user', i.empName);
					
					if (i.empPosition == 2) {
						$("#markk").attr("disabled", false);
					}
					if (i.empPosition == 3) {
						$("#markk").attr("disabled", false);
						$("#manage").attr("disabled", false);
					}
					$("#login").val("已登陆");
					$("#login").attr("disabled", true);
				},
				error : function(result) {
					alert("登陆失败，用户名或密码错误");
				}
			});

		});
	</script>


</body>
</html>