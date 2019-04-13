<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工列表</title>
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

</head>
<body>

	<!-- 员工修改的模态框 -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">员工修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">empName</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="empName_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">部门名称</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" id="UdName" name="UdName">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">职位</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" id="UpId" name="UpId">
									<option value="1">员工</option>
									<option value="2">管理</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 员工添加的模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">员工添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" accept-charset="UTF-8">
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" name="empName" class="form-control"
									id="empName_add_input" placeholder="empName"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">部门名</label>
							<div class="col-sm-4">
								<!-- 部门提交部门名即可 -->
								<select class="form-control" id="dName" name="dName">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">职位</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" id="pId" name="pId">
									<option value="1">员工</option>
									<option value="2">管理</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>员工管理</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-primary" id="emp_pull_out_btn">导出</button>
				<!-- <button class="btn btn-danger">删除</button> -->
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>工号</th>
						<th>姓名</th>
						<th>职位</th>
						<th>部门</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list}" var="emp">
						<tr>
							<th>${emp.empId }</th>
							<th>${emp.empName }</th>
							<th>${emp.empPosition==1?"员工":"管理"}</th>
							<th>${emp.empDepartment }</th>
							<th>
								<button class="btn btn-primary btn-sm edit_btn"
									edit-id="${emp.empId }">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
								<button class="btn btn-danger btn-sm delete_btn"
									name="${emp.empId }">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									删除
								</button>
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<!-- 显示分页信息 -->
		<div class="row" style="color:grey;position:fixed;bottom:20px;left:200px;width:100%;">
			<!--分页文字信息  -->
			<div class="col-md-4">当前 ${pageInfo.pageNum}页,总${pageInfo.pages}
				页,总 ${pageInfo.total}条记录</div>
			<!-- 分页条信息 -->
			<div class="col-md-8">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${APP_PATH }/emps?pn=1">首页</a></li>
					<c:if test="${pageInfo.hasPreviousPage }">
						<li><a href="${APP_PATH }/emps?pn=${pageInfo.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>


					<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
						<c:if test="${page_Num == pageInfo.pageNum }">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num != pageInfo.pageNum }">
							<li><a href="${APP_PATH }/emps?pn=${page_Num }">${page_Num }</a></li>
						</c:if>

					</c:forEach>
					<c:if test="${pageInfo.hasNextPage }">
						<li><a href="${APP_PATH }/emps?pn=${pageInfo.pageNum+1 }"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="${APP_PATH }/emps?pn=${pageInfo.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
<!--新增-->
	$("#emp_add_modal_btn").click(function() {
		reset_form("#empAddModal form");
		getDepts("#dName");
		$("#empAddModal").modal({
			backdrop : "static"
		});
	});
<!--编辑-->
	$(document).on("click", ".edit_btn", function() {
		getDepts("#UdName");
		getEmp($(this).attr("edit-id"));

		//3、把员工的id传递给模态框的更新按钮
		$("#emp_update_btn").attr("edit-id", $(this).attr("edit-id"));
		$("#empUpdateModal").modal({
			backdrop : "static"
		});
	});

	$("#emp_update_btn").click(function() {
		$.ajax({
			url : "${APP_PATH}/updateEmp",
			type : "POST",
			data : {"emp":$("#empUpdateModal form").serialize(),"id":$(this).attr("edit-id")},
			success : function(result) {
				//alert(result.msg);
				//1、关闭对话框
				$("#empUpdateModal").modal("hide");
			}
		});
	});
	$("#emp_pull_out_btn").click(function() {
		location.href="${APP_PATH}/pullOutEmps";
	});
	function reset_form(ele) {
		$(ele)[0].reset();
		$(ele).find("*").removeClass("has-error has-success");
		$(ele).find(".help-block").text("");
	}

	function getDepts(ele) {
		$(ele).empty();
		$.ajax({
			url : "${APP_PATH}/getDeps",
			type : "GET",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(result) {
				//alert(result.extend.deps);
				$.each(result.extend.deps, function() {
					var optionEle = $("<option></option>").append(this.depName)
							.attr("value", this.depName);
					optionEle.appendTo(ele);
				});
			}
		});
	}

	function getEmp(id) {
		$.ajax({
			url : "${APP_PATH}/getEmp",
			type : "GET",
			data:{"id":id},
			success : function(result) {
				//console.log(result);
				var empData = result.extend.emp;
				$("#empName_update_static").text(empData.empName);
				$("#UdName").val(empData.empDepartment);
				$("#UpId").val(empData.empPosition);
			}
		});
	}

	$("#emp_save_btn").click(function() {
		//1、模态框中填写的表单数据提交给服务器进行保存
		//1、先对要提交给服务器的数据进行校验
		if (!validate_add_form()) {
			return false;
		}
		;
		/* 		//1、判断之前的ajax用户名校验是否成功。如果成功。
		 if($(this).attr("ajax-va")=="error"){
		 return false;
		 }  */

		//2、发送ajax请求保存员工
		$.ajax({
			url : "${APP_PATH}/addEmp",
			type : "POST",
			data : {
				"emp" : $("#empAddModal form").serialize()
			},
			success : function(result) {
				$("#empAddModal").modal('hide');
			}
		});
	});
	function validate_add_form() {
		//1、拿到要校验的数据，使用正则表达式
		var empName = $("#empName_add_input").val();
		var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if (!regName.test(empName)) {
			alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
			//show_validate_msg("#empName_add_input", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
			return false;
		} else {
			//show_validate_msg("#empName_add_input", "success", "");
		}
		;
		return true;
	}
	$(document).on("click", ".delete_btn", function() {
		//1、弹出是否确认删除对话框
		var empName = $(this).parents("tr").find("td:eq(1)").text();
		var empId = $(this).attr("name");
		//alert($(this).parents("tr").find("td:eq(1)").text());
		if (confirm("确认删除【" + empName + "】吗？")) {
			//确认，发送ajax请求删除即可
			$.ajax({
				url : "${APP_PATH}/deleteEmp",
				data : {
					"empId" : empId
				},
				success : function(result) {
					alert(result.msg);
					//回到本页
					//to_page(currentPage);
				}
			});
		}
	});
</script>
</html>