<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background-color:#212121">
<head>
<script type="text/javascript">
	try {
		if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			window.location.href = "m/modInfo.jsp";
		}
	} catch (e) {
	}
</script>
<link href="../../static/customer/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="../../static/customer/css/gloab.css" type="text/css" rel="stylesheet">
<link href="../../static/customer/css/regUsr.css" type="text/css" rel="stylesheet">
<script src="../../static/customer/js/jquery-1.11.1.min.js"></script>
<script src="../../static/customer/js/register.js" type="text/javascript"></script>
<script type="text/javascript">
function edit() {
	if ($("#tel").val() == "" && $("#pwd").val() == "") {
		alert('请至少修改一项 !');
		return;
	}
	document.f.submit();
}
$(function(){
	var tel = document.getElementById('requestTel').value;
	var email = document.getElementById('requestEmail').value;
	
	if(typeof tel == "null"){
		
	}
})



</script>


<style>
.btn-red {
	background-color: #C72828;
	border-color: #1997d7;
	color: #fff;
	font-size:18px;
	height:44px;
	line-height:44px;
	width:270px;
	padding:0;
}
</style>

<title>编辑个人信息</title>
</head>
<body>
<body class="bgf4" style="background-color:#212121">
	<div class="login-box f-mt10 f-pb50">
		<div class="main bgf" style="background-color:#212121">
			<div class="reg-box-pan display-inline">

				<div class="reg-box" id="verifyCheck" style="margin-top: 20px;">
<%-- 				<input type="hidden" value="${param.tel }" id="requestTel" /> --%>
<%-- 				<input type="hidden" value="${param.email }" id="requestEmail" /> --%>
					<form name="f" action="${pageContext.request.contextPath}/EditCustomer" method="POST">
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl" style="color:#fff;" ><b class="ftx04">*</b>原电话:</span>
								<div class="f-fl item-ifo">
									<input type="text" name="userName" maxlength="20"
										class="txt03 f-r3 required" tabindex="1"
										data-valid="isNonEmpty||between:3-20||isUname"
										id="userName" value="${user.c_tel }"
										disabled="disabled" style="background-color:transparent;"/> <span class="ie8 icon-close close hide"></span>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl" style="color:#fff;" ><b class="ftx04">*</b>原邮件:</span>
								<div class="f-fl item-ifo">
									<input type="text" name="userName" maxlength="20"
										class="txt03 f-r3 required" tabindex="1"
										data-valid="isNonEmpty||between:3-20||isUname"
										id="userName" value="${user.email }"
										disabled="disabled" style="background-color:transparent;"/> <span class="ie8 icon-close close hide"></span>
								</div>
							</div>
						
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color:#fff;">新的电话:</span>
							<div class="f-fl item-ifo">
								<input type="text" name="tel" id="tel"
									maxlength="20" class="txt03 f-r3 required" tabindex="3"
									style="ime-mode: disabled;background-color:transparent;"
>
							</div>
						</div>
						
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color:#fff;">新的邮件地址:</span>
							<div class="f-fl item-ifo">
								<input type="text" name="email" id="email"
									maxlength="20" class="txt03 f-r3 required" tabindex="2"
									style="ime-mode: disabled;background-color:transparent;"
									/>
								
							</div>
						</div>
						
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl">&nbsp;</span>
							<div class="f-fl item-ifo">
<!-- 								<a href="javascript:;" onclick="edit();" class="btn btn-blue f-r3" id="btn_part1">Apply</a> -->
								<input type="hidden" name="id" id="id" value="${user.c_id }">
								<input type="button" onclick="edit();" class="btn btn-blue f-r3" id="btn_part1" value="修改"/>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl">&nbsp;</span>
							<div class="f-fl item-ifo">
								<a style="border:none" href="${pageContext.request.contextPath}/customer/customerMain.jsp;" target="rightFrame" class="btn btn-red f-r3" id="btn_part1">取消</a>
							</div>
						</div>
						
						</form>
				
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>