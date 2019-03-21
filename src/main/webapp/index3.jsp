<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考核项目增删改查</title>
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
			url : "${APP_PATH}/markss",
			data : {
				"pn" : pn
			},
			type : "GET",
			success : function(result) {
				//console.log(result);
				//1、解析并显示员工数据
				build_marks_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
				build_page_nav(result);
			},
			error : function() {
				alert("fucking fucked");
			}
		});
	}
	function build_marks_table(result) {
		$("#marks_table tbody").empty();
		var marks = result.extend.pageInfo.list;

		$.each(marks, function(index, item) {
			var markItem = $("<td></td>").append(item.markItem);
			var markGenre = $("<td></td>").append(item.markGenre);
			var markContent = $("<td></td>").append(item.markContent);
			var markScore = $("<td></td>").append(item.markScore);
			var markMethod = $("<td></td>").append(item.markMethod);
			var editBtn = $("<button></button>").addClass(
					"btn btn-primary btn-sm edit_btn").append(
					$("<span></span>").addClass("glyphicon glyphicon-pencil"))
					.append("编辑");
			//为编辑按钮添加一个自定义的属性，来表示当前员工id
			editBtn.attr("edit-id", item.markId);
			var delBtn = $("<button></button>").addClass(
					"btn btn-danger btn-sm delete_btn").append(
					$("<span></span>").addClass("glyphicon glyphicon-trash"))
					.append("删除");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			delBtn.attr("del-id", item.markId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(
					delBtn);
			//var delBtn = 
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(markItem).append(markGenre).append(
					markContent).append(markScore).append(markMethod).append(
					btnTd).appendTo("#marks_table tbody");
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
		$.each(result.extend.pageInfo.navigatepageNums, function(index, item) {

			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if (result.extend.pageInfo.pageNum == item) {
				numLi.addClass("active");
			}
			numLi.click(function() {
				to_page(item);
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
	<!-- 员工修改的模态框 -->
	<div class="modal fade" id="markUpdateModal" tabindex="-1"
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
							<label class="col-sm-2 control-label">总项</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" id="update_item" name="update_item">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">分类</label>
							<div class="col-sm-10">
								<input type="text" name="genre" class="form-control"
									id="genre_add_input"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">内容</label>
							<div class="col-sm-10">
								<textarea name="content" class="form-control"
									id="content_add_input"></textarea>
								<span class="help-block"></span>

							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">分值</label>
							<div class="col-sm-10">
								<input type="text" name="score" class="form-control"
									id="score_add_input"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">方式</label>
							<div class="col-sm-10">
								<input type="text" name="method" class="form-control"
									id="method_add_input"> <span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="mark_update_btn">更新</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 员工添加的模态框 -->
	<div class="modal fade" id="markAddModal" tabindex="-1" role="dialog"
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
							<label class="col-sm-2 control-label">总项</label>
							<div class="col-sm-4">
								<!-- 部门提交部门id即可 -->
								<select class="form-control" id="add_item" name="add_item">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">分类</label>
							<div class="col-sm-10">
								<input type="text" name="genre1" class="form-control"
									id="genre1"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">内容</label>
							<div class="col-sm-10">
								<textarea name="content1" class="form-control"
									id="content1"></textarea>
								<span class="help-block"></span>

							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">分值</label>
							<div class="col-sm-10">
								<input type="text" name="score1" class="form-control"
									id="score1"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">方式</label>
							<div class="col-sm-10">
								<input type="text" name="method1" class="form-control"
									id="method1"> <span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="mark_save_btn">保存</button>
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
				<button class="btn btn-primary" id="mark_add_modal_btn">新增</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="marks_table">
					<thead>
						<tr>
							<th>项目</th>
							<th>分类</th>
							<th>内容</th>
							<th>分值</th>
							<th>考核方式</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6" id="page_info_area"></div>
		<div class="col-md-6" id="page_nav_area"></div>
	</div>
	<script type="text/javascript">
		$("#mark_add_modal_btn").click(function() {
			reset_form("#markAddModal form");
			getItems("#markAddModal select");
			$("#markAddModal").modal({
				backdrop : "static"
			});
		});
		function reset_form(ele) {
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		
		function getItems(ele) {
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH}/getItemss",
				type : "GET",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				success : function(result) {
					$.each(result.extend.items, function() {
						var optionEle = $("<option></option>").append(this.itemName)
								.attr("value", this.itemName);
						optionEle.appendTo(ele);
					});
				},
				error:function(){alert("获取失败");}
			});
		}
		function getMark(id) {
			$.ajax({
				url : "${APP_PATH}/mark/" + id,
				type : "GET",
				success : function(result) {
					var markData = result.extend.mark;
					//$("#item_add_input").val(markData.markItem);
					$("#genre_add_input").val(markData.markGenre);
					$("#content_add_input").val(markData.markContent);
					$("#score_add_input").val(markData.markScore);
					$("#method_add_input").val(markData.markMethod);
					  }
			});
		}
		$("#mark_update_btn").click(function() {
			$.ajax({
				url : "${APP_PATH}/updateMark",
				type : "POST",
				data : {
					"mark" : $("#markUpdateModal form").serialize(),
					"id":$(this).attr("edit-id")
				},
				success : function(result) {
					$("#markUpdateModal").modal("hide");
					to_page(1);
				},
				error: function (XMLHttpRequest, textStatus, errorThrown) {alert(XMLHttpRequest.status);}     
			});
		});

		$(document).on("click", ".edit_btn", function() {
			//2、查出员工信息，显示员工信息
			getMark($(this).attr("edit-id"));
			getItems("#markUpdateModal select");
			$("#mark_update_btn").attr("edit-id", $(this).attr("edit-id"));
			$("#markUpdateModal").modal({
				backdrop : "static"
			});
		});

		$(document).on("click", ".delete_btn", function() {
			var markId = $(this).attr("del-id");
			if (confirm("确认删除吗？")) {
				//确认，发送ajax请求删除即可
				$.ajax({
					url : "${APP_PATH}/mark/" + markId,
					type : "DELETE",
					success : function(result) {
						alert(result.msg);
						//回到本页
						to_page(currentPage);
					}
				});
			}
		});
		$("#mark_save_btn").click(function() {
			//alert("#mark_save_btn");
			if (!validate_add_form()) {
				return false;
			}
			;
			$.ajax({
				url : "${APP_PATH}/addMark",
				type : "POST",
				data : {
					"mark" : $("#markAddModal form").serialize()
				},
				success : function(result) {
					$("#markAddModal").modal('hide');
					to_page(1);
				}

			});
		});
		function validate_add_form() {
			///alert("#validate_add_form");
			//1、拿到要校验的数据，使用正则表达式
			//var item = $("#add_item").val();
			var genre = $("#genre1").val();
			var content = $("#content1").val();
			var score = $("#score1").val();
			var method = $("#method1").val();
			var regScore = /^\d+(\.\d+)?$/;
			if ( genre == "" || content == ""||method=="") {
				show_validate_msg("#score1", "error", "项目、分类、内容、方式非空");
				return false;
			} else {
				show_validate_msg("#score1", "success", "");
			}
			if (!regScore.test(score)) {
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#score1", "error", "分值应为正浮点数");
				return false;
			} else {
				show_validate_msg("#score_add_input", "success", "");
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