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
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-3.3.1.min.js"></script>
<!-- 引入样式 -->
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
	
<script type="text/javascript">
window.onload = function(){
$("#btn").click(function(){
 	 $.ajax({
             type: "get",//方法类型
             url: "${APP_PATH}/countMarks" ,//url
             data: {'year':year.value,'month':month.value},
             success: function (result) {
            	 build_deps_table(result);
             },
             error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("提交失败" + XMLHttpRequest.status);}
         }); 
});
}
function build_deps_table(result) {
	$("#deps_table tbody").empty();
	var deps = result.extend.deplist;
	 $.each(deps,function(index, name) {
		var depName = $("<td></td>").append(name.depName);
		var depScore = $("<td></td>").append(name.depScore);
		var depRemark = $("<td></td>").append(name.depRemark);
		$("<tr></tr>").append(depName)
		.append(depScore).append(depRemark).appendTo("#deps_table tbody");
	}); 
}
 </script>
</head>
<body>

<select name="year" id="year">
<option value="2019">2019</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
</select>
<select name="month" id="month">
<option value="01">1</option>
<option value="02">2</option>
<option value="03">3</option>
<option value="04">4</option>
<option value="05">5</option>
<option value="06">6</option>
<option value="07">7</option>
<option value="08">8</option>
<option value="09">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>
<button id="btn">检索</button>

<table class="table table-hover" id="deps_table">
					<thead>
						<tr>
							<th>部门名称</th>
							<th>总成绩</th>
							<th>扣分项</th>
						</tr>
					</thead>
					<tbody></tbody>
</table>
</body>
</html>