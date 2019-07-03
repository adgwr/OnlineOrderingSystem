<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="LYHTags" prefix="LYH" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../static/admin/css/main.css"/>
<style>
a{
		text-decoration:none;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="main">
	<div class="main-content">
		<div class="container-fluid">
			<h3 class="page-title">所有的管理员</h3>
			<div class="row">
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title">管理员列表</h3>
					</div>
					<div class="panel-body">
						<table class="table">
<!-- 							<thead> -->
								<tr>
									<td width="100px">用户名</td>
									<td width="100px">电话</td>
<!-- 									<th>MaxBorrow</th> -->
									<td width="40px">编辑</td>
									<td width="40px">删除</td>
								</tr>
<!-- 							</thead> -->
							<tbody>
								<LYH:adminList/>
							
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>