<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css"/>
<title>Add Food</title>
</head>
<body>
<div class="main">
	<div class="main-content">
		<div class="container-fluid">
			<h3 class="page-title">菜品管理</h3>
			<div class="row">
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title">添加菜品</h3>
					</div>
					<div class="panel-body">
						<form action="${pageContext.request.contextPath}/AddFood.do?method=add" name="formAdd" method="post" enctype="multipart/form-data">
				     <table class="table" width="70%" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="${pageContext.request.contextPath}/images/wbg.gif" class='title'><span>&nbsp;</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         菜品名称：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="foodName" size="60"/>
						    </td>
						</tr>
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         菜品子名称：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="foodSubName" size="60"/>
						    </td>
						</tr>
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         定价：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="foodPrice" size="60"/>
						    </td>
						</tr>
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         描述：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="foodDesc" size="60"/>
						    </td>
						</tr>
						
						<tr bgcolor="#FFFFFF" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         添加图片：
                           <td><input type="file" name="file"/></td>
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