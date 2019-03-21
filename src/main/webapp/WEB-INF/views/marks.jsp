<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

<script type="text/javascript">

window.onload =function(){
 //alert("fdsfs");
 		  $.ajax({url:"${APP_PATH }/getMarks",
			              type:"GET",
			              data:{},
			              success:function(result){build_emps_table(result);},
			              error:function(XMLHttpRequest, textStatus, errorThrown){alert("获取失败"+XMLHttpRequest.status); }			              
 		  });
	} 
function build_emps_table(result){
	
	$("#emps_table tbody").empty();
	var deps = result.extend.deplist;
//	alert(deps);
	$.each(deps, function(index, dep) {
		var d1 = $("<td></td>").append(dep.depId);
		var d2 = $("<td></td>").append(dep.depName);
		var d3 = $("<td></td>").append(dep.depScore);
		var d4 = $("<td></td>").append(dep.depRank);
		var d5 = $("<td></td>").append(dep.depRemark);
		var d6 = $("<td></td>").append(dep.depNumber);
		$("<tr></tr>")
			.append(d1)
			.append(d2)
			.append(d3)
			.append(d4)
			.append(d5)
			.append(d6)
			.appendTo("#emps_table tbody");
});
}
	
	 
     </script>
</head>
<body>

<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>depId</th>
							<th>depName</th>
							<th>depScore</th>
							<th>depRank</th>
							<th>depRemark</th>
							<th>depNumber</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
</table>
</body>
</html>