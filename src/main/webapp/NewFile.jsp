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
<link rel="stylesheet" href= "${APP_PATH }/static/layui/css/layui.css"/>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/static/layui/layui.all.js"></script>

</head>
	<body class="layui-layout-body layui-bg-gray">
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header" id="head">
			<div class="layui-logo">
				在线考核系统
			</div>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item avatar-item">
					<a href="javascript:;">
						<img src="${APP_PATH }/static/img/userAvatar.jpg" class="layui-nav-img"> <span id='username'>aaa</span>
					</a>
					<dl class="layui-nav-child">
						<dd>
							<a a href="javascript:void(0);" onclick="logOut()">退出登录</a>
						</dd>
					</dl>
				</li>
			</ul>
			</div>

 			<div class="layui-side layui-bg-black" id="side">
				<div class="layui-side-scroll">
					<ul class="layui-nav layui-nav-tree" lay-filter="test">
						<li class="layui-nav-item layui-nav-itemed">
							<a class="" href="javascript:;">
								<i class="layui-icon layui-icon-home"></i>
								<span class="">首页</span>
							</a>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;" >查看</a>
							<dl class="layui-nav-child">
								<dd>
									<a class="myItem" href="javascript:;" href-url="gradeList.jsp">按月查看</a>
								</dd>
								<dd>
									<a class="myItem"  href="javascript:;" href-url="">按部门查看</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a class="myItem"  href="javascript:;" href-url="markOnline.jsp">评分</a>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a class="myItem"  href="javascript:;" href-url="markCRUD.jsp" >考核项目</a>
								</dd>
								<dd>
									<a class="myItem"  href="javascript:;" href-url="empCRUD.jsp" >员工</a>
								</dd>
								<dd>
									<a class="myItem"  href="javascript:;" href-url="departmentCRUD.jsp" >部门</a>
								</dd>
								<dd>
									<a class="myItem"  href="javascript:;" href-url="itemCRUD.jsp" >总分类</a>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
			</div> 

		<div class="layui-body" id="body"> 
							<!-- 内容主体区域 -->
			<!-- <div class="layui-tab layui-tab-card my-tab" lay-filter="card" lay-allowClose="true">
				<div class="layui-tab-content my-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe id="frame" src="" frameborder="0" width='100%' height='100%'></iframe>
					</div>
				</div>
			</div> -->
			<iframe id="frame" src="" frameborder="0" width='100%' height='100%'></iframe>
		</div>

			<div class="layui-footer" id="footer">
				<!-- 底部固定区域 -->
				
			</div>
		</div>
		<script type="text/javascript">
		layui.use('element', function() {
			var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
			element.init();
			//默认选中第一个导航
			$("#menuList li:eq(0) a:eq(0)").click();

			//控制导航栏伸缩或展开
			$('.my-item').click(function() {
				if($(this).hasClass("layui-nav-itemed")) {
					$(this).siblings('').removeClass("layui-nav-itemed");
				}
			});
			$('.myItem').click(function(){
				var src = $(this).attr('href-url'); // 导航栏跳转URL
				//var eid = elem.attr('lay-id'); // 获取点击的a标签的id
				if(src!=''){
					$("#frame").attr("src",src);  
				}
			});

		});
		</script>
</body>
</html>