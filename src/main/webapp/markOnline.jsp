<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>在线评分</title>
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
	var selected = 0;
	window.onload = function() {
		var user=sessionStorage.getItem('user');
		//alert(user.empName);
		$.ajax({
			url : "${APP_PATH}/getDeps",
			data : {},
			type : "GET",
			async : false,
			success : function(result) {
				//alert("fsdkfdsl");
				//build_table(result);//填充考核项列表
				build_table2(result);//填充部门列表
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("获取列表失败" + XMLHttpRequest.status);
			}
		});

		var obj_lis = document.getElementById("dep").getElementsByTagName("a");
		for (i = 0; i < obj_lis.length; i++) {
			obj_lis[i].onclick = function() {
				selected = 1;
				document.getElementById("head").innerHTML = this.innerHTML;
				getMarkList(user);
			}
		}

	}
	
	function getMarkList(name){
		var user=$.session.get('user');
		//alert(user.empName);
		$.ajax({
			url : "${APP_PATH}/mark",
			data : {'name':user},
			type : "GET",
			async : false,
			success : function(result) {
				//alert("fsdkfdsl");
				build_table(result);//填充考核项列表
				//build_table2(result);//填充部门列表
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("获取列表失败" + XMLHttpRequest.status);
			}
		});

		var obj_lis = document.getElementById("dep").getElementsByTagName("a");
		for (i = 0; i < obj_lis.length; i++) {
			obj_lis[i].onclick = function() {
				selected = 1;
				document.getElementById("head").innerHTML = this.innerHTML;
			}
		}
	}
	//提交评分
	$(document).ready(function() {
		$("#submit").click(function() {
			if (selected == 0) {
				alert("请选择部门");
			} else {
				var user=$.session.get('user');
				alert(user);
				$.ajax({
					url : "${APP_PATH }/addRecord",
					type : "POST",
					data : {
						'recs' : $("#records").serialize(),
						'dep' : document.getElementById("head").innerHTML,
						'name':user
					},
					success : function(result) {
						alert(result.extend.msg);
					}
				/* error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("提交失败" + XMLHttpRequest.status);
				} */
				});
			}
		});
	});

	function build_table(result) {
		//alert(result.extend.marks);
		$("#marks_table tbody").empty();
		var marks = result.extend.marks;
		var item = "000";
		var genre = "000";
		$
				.each(
						marks,
						function(index, mark) {
							//var m1 = $("<td></td>").append(mark.markId);
							var m2=$("<td></td>");
							if (mark.markItem != item) {
								item = mark.markItem;
								mItem= "<a data-toggle='collapse' data-target='#"+item+">"+item+"</a>";
								m2.append(item);
							}
							var m3 = $("<td></td>");
							if (mark.markGenre != genre) {
								genre = mark.markGenre;
								m3.append(genre);
							}
							var m4 = $("<td></td>").append(mark.markContent);
							var m5 = $("<td></td>").append(mark.markScore);
							var m6 = $("<td></td>").append(mark.markMethod);
							var m7 = $("<input></input>")
									.append(mark.markScore);
							var m9 = "<input name="+mark.markId+" value="+mark.markScore+"></input>";
							var m8 = $("<td></td>").append(m9);
							$("<tr></tr>").append(m2).append(m3)
									.append(m4).append(m5).append(m6)
									.append(m8).appendTo("#marks_table tbody");
						});
	}

	function build_table2(result) {
		//清空table表格
		//alert(result.extend.deps);
		$("#dep").empty();
		var deps = result.extend.deps;
		$.each(deps, function(index, dep) {
			var d = $("<a href='#'></a>").append(dep.depName);
			$("<li></li>").append(d).appendTo("#dep");
		});
	}
</script>
</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h2 id="head">请选择部门</h2>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="true">
						部门列表 <span class="caret"></span>
					</button>
					<ul id="dep" class="dropdown-menu" aria-labelledby="dropdownMenu1">
					</ul>
				</div>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<form id="records" method="post">
					<table class="table table-hover" id="marks_table">
						<thead>
							<tr>
								<th>项目</th>
								<th>分类</th>
								<th>内容</th>
								<th>分值</th>
								<th>考核方式</th>
								<th>分数</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</form>
				<div class="row">
					<div class="col-md-4 col-md-offset-8">
						<button id="submit" class="btn btn-primary btn-lg">提交</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>