<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分类增删改查</title>
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

<script type="text/javascript">
	var totalRecord, currentPage;
	window.onload = function() {
		to_page(1);
	}
	function to_page(pn) {
		//alert("to_page");
		$.ajax({
			url : "${APP_PATH}/getItems",
			data : {
				"pn" : pn
			},
			type : "GET",
			success : function(result) {
				build_items_table(result);
				build_page_info(result);
				build_page_nav(result);
			},
			error : function() {
				alert("加载失败");
			}
		});
	}
	function build_items_table(result) {
		$("#items_table tbody").empty();
		var items = result.extend.pageInfo.list;

		$.each(items, function(index, name) {
			var itemName = $("<td></td>").append(name.itemName);
			var itemEmp = $("<td></td>").append(name.itemEmp);

			var editBtn = $("<button></button>").addClass(
					"btn btn-primary btn-sm edit_btn").append(
					$("<span></span>").addClass("glyphicon glyphicon-pencil"))
					.append("编辑");
			//为编辑按钮添加一个自定义的属性，来表示当前员工id
			editBtn.attr("edit-id", name.itemId);
			var delBtn = $("<button></button>").addClass(
					"btn btn-danger btn-sm delete_btn").append(
					$("<span></span>").addClass("glyphicon glyphicon-trash"))
					.append("删除");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			delBtn.attr("del-id", name.itemId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(
					delBtn);
			//var delBtn = 
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(itemName).append(itemEmp).append(btnTd)
					.appendTo("#items_table tbody");
		});
	}
	//解析显示分页信息
	function build_page_info(result) {
		$("#page_info_area").empty();
		$("#page_info_area").append(
				"当前" + result.extend.pageInfo.pageNum + "页,总"
						+ result.extend.pageInfo.pages + "页,总"
						+ result.extend.pageInfo.total + "条记录");
		totalRecord = result.extend.pageInfo.total;
		currentPage = result.extend.pageInfo.pageNum;
	}
	//解析显示分页条，点击分页要能去下一页....
	function build_page_nav(result) {
		//page_nav_area
		$("#page_nav_area").empty();
		var ul = $("<ul></ul>").addClass("pagination");

		//构建元素
		var firstPageLi = $("<li></li>").append(
				$("<a></a>").append("首页").attr("href", "#"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if (result.extend.pageInfo.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			//为元素添加点击翻页的事件
			firstPageLi.click(function() {
				to_page(1);
			});
			prePageLi.click(function() {
				to_page(result.extend.pageInfo.pageNum - 1);
			});
		}

		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append(
				$("<a></a>").append("末页").attr("href", "#"));
		if (result.extend.pageInfo.hasNextPage == false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			nextPageLi.click(function() {
				to_page(result.extend.pageInfo.pageNum + 1);
			});
			lastPageLi.click(function() {
				to_page(result.extend.pageInfo.pages);
			});
		}

		//添加首页和前一页 的提示
		ul.append(firstPageLi).append(prePageLi);
		//1,2，3遍历给ul中添加页码提示
		$.each(result.extend.pageInfo.navigatepageNums, function(index, name) {

			var numLi = $("<li></li>").append($("<a></a>").append(name));
			if (result.extend.pageInfo.pageNum == name) {
				numLi.addClass("active");
			}
			numLi.click(function() {
				to_page(name);
			});
			ul.append(numLi);
		});
		//添加下一页和末页 的提示
		ul.append(nextPageLi).append(lastPageLi);

		//把ul加入到nav
		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav_area");
	}
</script>
</head>
<body>
	<!-- 分类修改的模态框 -->
	<div class="modal fade" id="itemUpdateModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" accept-charset="UTF-8">
						<div class="form-group">
							<label class="col-sm-2 control-label">名称</label>
							<div class="col-sm-10">
								<input type="text" name="name_update_input" class="form-control"
									id="name_update_input"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">评分员</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" id="update_emp" name="update_emp">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="item_update_btn">更新</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 分类添加的模态框 -->
	<div class="modal fade" id="itemAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" accept-charset="UTF-8">
						<div class="form-group">
							<label class="col-sm-2 control-label">名称</label>
							<div class="col-sm-10">
								<input type="text" name="name_add_input" class="form-control"
									id="name_add_input"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">评分员</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" id="add_emp" name="add_emp">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="item_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h2 id="head"></h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="item_add_modal_btn">新增</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="items_table">
					<thead>
						<tr>
							<th>名称</th>
							<th>评分员</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row" style="color:grey;position:fixed;bottom:10px;left:200px;width:100%;">
		<div class="col-md-6" id="page_info_area"></div>
		<div class="col-md-6" id="page_nav_area"></div>
	</div>
	<script type="text/javascript">
		$("#item_add_modal_btn").click(function() {
			reset_form("#itemAddModal form");
			getEmps("#add_emp");
			$("#itemAddModal").modal({
				backdrop : "static"
			});
		});
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		
		function getEmps(ele) {
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH}/getAllEmps",
				type : "GET",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				success : function(result) {
					$.each(result.extend.emps, function() {
						var optionEle = $("<option></option>").append(this.empName)
								.attr("value", this.empName);
						optionEle.appendTo(ele);
					});
				},
				error:function(){alert("获取失败");}
			});
		}

		function getItem(id) {
			$.ajax({
				url : "${APP_PATH}/getItem",
				data : {
					"id" : id
				},
				type : "GET",
				success : function(result) {
					var itemData = result.extend.item;
					$("#name_update_input").val(itemData.itemName);
				}
			});
		}
		$("#item_update_btn").click(function() {
			$.ajax({
				url : "${APP_PATH}/updateItem",
				type : "POST",
				data : {
					"item" : $("#itemUpdateModal form").serialize(),
					"id" : $(this).attr("edit-id")
				},
				success : function(result) {
					$("#itemUpdateModal").modal("hide");
					to_page(1);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
				}
			});
		});

		$(document).on("click", ".edit_btn", function() {
			//2、查出员工信息，显示员工信息
			getItem($(this).attr("edit-id"));
			reset_form("#itemUpdateModal form");
			getEmps("#update_emp");
			$("#item_update_btn").attr("edit-id", $(this).attr("edit-id"));
			$("#itemUpdateModal").modal({
				backdrop : "static"
			});
		});

		$(document).on("click", ".delete_btn", function() {
			var itemId = $(this).attr("del-id");
			if (confirm("确认删除吗？")) {
				//确认，发送ajax请求删除即可
				$.ajax({
					url : "${APP_PATH}/deleteItem",
					data : {
						"itemId" : itemId
					},
					success : function(result) {
						alert(result.msg);
						//to_page(currentPage);
						window.location.reload(); 
					}
				});
			}
		});
		$("#item_save_btn").click(function() {
			if (!validate_add_form()) {
				return false;
			}
			;
			$.ajax({
				url : "${APP_PATH}/addItem",
				type : "POST",
				data : {
					"item" : $("#itemAddModal form").serialize()
				},
				success : function(result) {
					$("#itemAddModal").modal('hide');
					to_page(1);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
				}

			});
		});
		function validate_add_form() {
			//1、拿到要校验的数据，使用正则表达式
			var name = $("#name_add_input").val();
			var regScore = /^\d+(\.\d+)?$/;
			if (name == "") {
				show_validate_msg("#name_add_input", "error", "分类名称不可为空");
				return false;
			} else {
				show_validate_msg("#name_add_input", "success", "");
			}
			;
			return true;
		}
		function show_validate_msg(ele, status, msg) {
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
	</script>
</body>
</html>