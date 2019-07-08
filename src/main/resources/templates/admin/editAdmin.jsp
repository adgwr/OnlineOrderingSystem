<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link href="../../static/admin/css/bootstrap.min.css" rel="stylesheet">
<link href="../../static/admin/css/gloab.css" rel="stylesheet">
<link href="../../static/admin/css/regUsr.css" rel="stylesheet">
<script src="../../static/admin/js/jquery-1.11.1.min.js"></script>
<script src="../../static/admin/js/register.js"></script>
<script type="text/javascript">
	function edit() {
		if ($("#tel").val() == "" && $("#pwd").val() == "") {
			alert('请至少修改一项 !');
			return;
		}
		document.f.submit();
		// 	if ($("#pwd").val() == "") {
		// 		alert('Please INPUT the password!');
		// 		return;
		// 	}

	}
</script>


<style>
.btn-red {
	background-color: #C72828;
	border-color: #1997d7;
	color: #fff;
	font-size: 18px;
	height: 44px;
	line-height: 44px;
	width: 270px;
	padding: 0;
}
</style>

<title>编辑管理员</title>
</head>
<body>
<body class="bgf4">
	<div class="login-box f-mt10 f-pb50">
		<div class="main bgf">
			<div class="reg-box-pan display-inline">

				<div class="reg-box" id="verifyCheck" style="margin-top: 20px;">

					<form name="f" action="../EditAdmin" method="POST">
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color: #777777;"><b
								class="ftx04">*</b>用户名:</span>
							<div class="f-fl item-ifo">
								<input type="text" name="userName" maxlength="20"
									class="txt03 f-r3 required" tabindex="1"
									data-valid="isNonEmpty||between:3-20||isUname" id="userName"
									value="${param.id }" disabled="disabled" /> <span
									class="ie8 icon-close close hide"></span>
							</div>
						</div>

						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color: #777777;"><b
								class="ftx04">*</b>新密码:</span>
							<div class="f-fl item-ifo">
								<input type="password" name="pwd" id="pwd" maxlength="20"
									class="txt03 f-r3 required" tabindex="3"
									style="ime-mode: disabled;">
							</div>
						</div>

						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color: #777777;"><b
								class="ftx04">*</b>电话:</span>
							<div class="f-fl item-ifo">
								<input type="text" name="tel" id="tel" maxlength="20"
									class="txt03 f-r3 required" tabindex="2"
									style="ime-mode: disabled;" />

							</div>
						</div>

						<div class="item col-xs-12">
							<span class="intelligent-label f-fl">&nbsp;</span>
							<div class="f-fl item-ifo">
								<!-- 								<a href="javascript:;" onclick="edit();" class="btn btn-blue f-r3" id="btn_part1">Apply</a> -->
								<input type="hidden" name="id" id="id" value="${param.id }">
								<input type="button" onclick="edit();" class="btn btn-blue f-r3"
									id="btn_part1" value="应用" />
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl">&nbsp;</span>
							<div class="f-fl item-ifo">
								<a href="adminMain.jsp;" target="rightFrame"
									class="btn btn-red f-r3" id="btn_part1">取消</a>
							</div>
						</div>

					</form>


				</div>
			</div>
		</div>
	</div>
</body>
</html>