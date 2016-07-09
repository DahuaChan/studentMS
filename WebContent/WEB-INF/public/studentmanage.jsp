<%@page import="cn.cdh.studentMS.model.Admin"%>
<%@page import="cn.cdh.studentMS.model.Student"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="lib/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->

	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

				<li><a href="#"
					class="hidden-phone visible-tablet visible-desktop" role="button">设置</a></li>
				<li id="fat-menu" class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i> <%
 	out.print(((Admin) session.getAttribute("admin")).getId());
 %> <i class="icon-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">我的账户</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" class="visible-phone" href="#">设置</a></li>
						<li class="divider visible-phone"></li>
						<li><a tabindex="-1" href="sign-in.html">注销</a></li>
					</ul></li>

			</ul>
			<a class="brand" href="index.html"><span class="first">岭南师范学院</span>
				<span class="second">学生信息管理系统</span></a>
		</div>
	</div>




	<div class="sidebar-nav">
		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-dashboard"></i>信息维护<i class="icon-chevron-up"></i></a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href="">个人信息</a></li>
			<li><a href="">密码修改</a></li>
			<li><a href="">学籍信息</a></li>
			<li><a href="infosign">信息登记卡</a></li>

		</ul>

		<a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-briefcase"></i>信息查询<i class="icon-chevron-up"></i></a>
		<ul id="accounts-menu" class="nav nav-list collapse">
			<li><a href="">成绩查询</a></li>
			<li><a href="">奖惩信息查询</a></li>
		</ul>

		<a href="#error-menu" class="nav-header collapsed"
			data-toggle="collapse"><i class="icon-exclamation-sign"></i>评价管理<i
			class="icon-chevron-up"></i></a>
		<ul id="error-menu" class="nav nav-list collapse">
			<li><a href="">学生评价</a></li>
		</ul>

		<a href="#legal-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-legal"></i>用户管理<i class="icon-chevron-up"></i></a>
		<ul id="legal-menu" class="nav nav-list collapse">
			<li><a href="adminmanage">管理员</a></li>
			<li><a href="">教师</a></li>
			<li><a href="studentmanage">学生</a></li>
		</ul>
	</div>



	<div class="content">

		<div class="header">

			<h1 class="page-title">学生信息管理</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="#">用户管理</a> <span class="divider">/</span></li>
			<li class="active">学生信息</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">

				<div class="btn-toolbar">
					<a href="filter?type=student">
						<button class="btn btn-primary">
							<i class="icon-plus"></i> 添加学生
						</button>
					</a>
					<button class="btn">导入</button>
					<button class="btn">导出</button>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>密码</th>
								<th>学院</th>
								<th>专业</th>
								<th>操作</th>
								<th style="width: 26px;"></th>
							</tr>
						</thead>
						<tbody>
							<%
								List<?> lists = (ArrayList<?>) session.getAttribute("stu_list");
								for (int i = lists.size() - 1; i >= 0; i--) {
									Student student = (Student) lists.get(i);
							%>
							<tr>
								<td>
									<%
										out.print(student.getStu_id());
									%>
								</td>
								<td>
									<%
										out.print(student.getStu_name());
									%>
								</td>
								<td>
									<%
										out.print(student.getStu_password());
									%>
								</td>
								<td>
									<%
										out.print(student.getSub_id());
									%>
								</td>
								<td>
									<%
										out.print(student.getMaj_id());
									%>
								</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<div class="pagination">
					<ul>
						<%
							int stu_page = Integer.parseInt(request.getAttribute("stu_page").toString());
						%>
						<li><a href="studentmanage?stu_page=<%=stu_page - 1%>">上一页</a></li>
						<%
							int pagecount = Integer.parseInt(session.getAttribute("stu_pagecount").toString());
							int pages = pagecount / 10 + 1;
							for (int i = 1; i <= pages; i++) {
						%>
						<li><a href="studentmanage?stu_page=<%=i%>" 
							<%
							if(stu_page==i)
								out.print("style='text-decoration: underline;'");
							%>><%=i%></a></li>
						<%
							}
						%>
						<li><a href="studentmanage?stu_page=<%=stu_page + 1%>">下一页</a></li>
					</ul>
				</div>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">注意</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>你确定要删除这位学生吗？
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-danger" data-dismiss="modal">删除</button>
					</div>
				</div>



				<footer>
					<hr>

					<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
					<p class="pull-right">
						Powered by <a href="#" title="CDH" target="_blank">CDH</a>
					</p>

					<p>
						&copy; 2016 <a href="#" title="CDH" target="_blank">CDH</a>
					</p>
				</footer>

			</div>
		</div>
	</div>



	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>

</body>
</html>


