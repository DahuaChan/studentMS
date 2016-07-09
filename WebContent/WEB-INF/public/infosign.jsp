<%@page import="cn.cdh.studentMS.model.Admin"%>
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
						class="icon-user"></i> <% out.print(((Admin)session.getAttribute("admin")).getId()); %>  <i class="icon-caret-down"></i>
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
		<div class="well">
			<form action="" method="post">
				<table width="550" border="1px" align="center">
					<caption>

						<span class="STYLE1">学生登记卡</span>
					</caption>
					<col span="6" width="72" />
					<tr height="40" align="center">
						<td height="40" width="56">学号</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
						<td width="92">姓名</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
					</tr>
					<tr height="40" align="center">
						<td height="40">性别</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
						<td>出生日期</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
					</tr>
					<tr height="18" align="center">
						<td height="40">名族</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
						<td>籍贯</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
					</tr>
					<tr height="18" align="center">
						<td height="40">政治面貌</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
						<td>加入时间</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
					</tr>
					<tr height="18" align="center">
						<td height="40">入学时间</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
						<td>所在院系</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
					</tr>
					<tr height="18" align="center">
						<td height="40">所学专业</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
						<td>班级</td>
						<td colspan="2"><input type="text" name="stu_id"
							style="border: 0px; width: 120px" /></td>
					</tr>
					<tr height="18" align="center">
						<td rowspan="5" height="90">学生关系</td>
						<td width="79">姓名</td>
						<td width="85">关系</td>
						<td>工作单位</td>
						<td width="83">职务</td>
						<td width="91">联系方式</td>
					</tr>
					<tr align="center">
						<td height="18"><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input align="middle" type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
					</tr>
					<tr align="center">
						<td height="18"><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
					</tr>
					<tr align="center">
						<td height="18"><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
					</tr>
					<tr align="center">
						<td height="18"><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
						<td><input type="text" name="stu_id"
							style="border: 0px; width: 74px" /></td>
					</tr>
				</table>
				<br />
				<div align="center">
					<input name="submit" type="submit" value="提交" />
				</div>
			</form>

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


