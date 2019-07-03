<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../../static/admin/css/main.css"/>
<title>Add category</title>
</head>
<body>
<div class="main">
	<div class="main-content">
		<div class="container-fluid">
			<h3 class="page-title">菜品类别管理</h3>
			<div class="row">
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title">添加类别</h3>
					</div>
					<div class="panel-body">
					<form action="${pageContext.request.contextPath}/AddCategory.do" name="formAdd" method="post" accept-charset="UTF-8" onsubmit="document.charset='UTF-8';">
						<table class="table">
							
							<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="${pageContext.request.contextPath}/images/wbg.gif" class='title'><span>&nbsp;</span></td>
					        </tr>
					        <tr>
					            <td width="25%" bgcolor="#FFFFFF" align="right">
						         类别名称：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="catelogName" size="60"/>
						    </td>
					        </tr>
								<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="提交"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>