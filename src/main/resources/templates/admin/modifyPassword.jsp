<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Modify Password</title>
<link href="../../static/admin/css/bootstrap.min.css" rel="stylesheet">
<link href="../../static/admin/css/gloab.css" rel="stylesheet">
<link href="../../static/admin/css/regUsr.css" rel="stylesheet">
<script src="../../static/admin/js/jquery-1.11.1.min.js"></script>
<script src="../../static/admin/js/register.js"></script>
</head>

<body class="bgf4">
	<div class="login-box f-mt10 f-pb50">
		<div class="main bgf">
			<div class="reg-box-pan display-inline">

				<div class="reg-box" id="verifyCheck" style="margin-top: 20px;">
					<form id="form1" name="form1" method="post">
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color:#777777;"><b class="ftx04">*</b>用户名:</span>
							<div class="f-fl item-ifo">
								<input type="text" name="userName" maxlength="20"
									class="txt03 f-r3 required" tabindex="1"
									data-valid="isNonEmpty||between:3-20||isUname"
									data-error="The user name cannot be empty||The user name is 3-20 digits long||Only letters, numbers and underscores can be entered and begin with letters"
									id="adminNo" value="${user.admin_id }"
									disabled="disabled" /> <span class="ie8 icon-close close hide"></span>
								<label class="icon-sucessfill blank hide"></label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color:#777777;"><b class="ftx04">*</b>原密码:</span>
							<div class="f-fl item-ifo">
								<input type="password" name="oldPswd" id="oldPswd"
									maxlength="20" class="txt03 f-r3 required" tabindex="2"
									style="ime-mode: disabled;" onpaste="return  false"
									autocomplete="off" data-valid="isNonEmpty||between:6-20"
									data-error="密码不能为空||密码长度在6到20位" />
								<span class="ie8 icon-close close hide" style="right: 55px"></span>
								<span class="showpwd" data-eye="oldPswd"></span> <label
									class="icon-sucessfill blank hide"></label> <label
									class="focus valid"></label> <span class="clearfix"></span>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color:#777777;"><b class="ftx04">*</b>新密码:</span>
							<div class="f-fl item-ifo">
								<input type="password" name="newPswd" id="password"
									maxlength="20" class="txt03 f-r3 required" tabindex="3"
									style="ime-mode: disabled;" onpaste="return  false"
									autocomplete="off"
									data-valid="isNonEmpty||between:6-16||level:2"
									data-error="密码不能为空||密码长度在6到16位||密码太简单" />
								<span class="ie8 icon-close close hide" style="right: 55px"></span>
								<span class="showpwd" data-eye="password"></span> <label
									class="icon-sucessfill blank hide"></label> <label
									class="focus">6-16位英语(区分大小写)、数字和字符组合</label> <label
									class="focus valid"></label> <span class="clearfix"></span> <label
									class="strength"> <span class="f-fl f-size12">安全性:</span>
									<b><i>弱</i><i>中</i><i>强</i></b>
								</label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl" style="color:#777777;"><b class="ftx04">*</b>密码确认:</span>
							<div class="f-fl item-ifo">
								<input type="password" maxlength="20"
									class="txt03 f-r3 required" tabindex="4"
									style="ime-mode: disabled;" onpaste="return  false"
									autocomplete="off"
									data-valid="isNonEmpty||between:6-16||isRepeat:password"
									data-error="密码不能为空||密码长度在6到16位||两次密码不一致"
									id="rePassword" /> <span class="ie8 icon-close close hide"
									style="right: 55px"></span> <span class="showpwd"
									data-eye="rePassword"></span> <label
									class="icon-sucessfill blank hide"></label> <label
									class="focus">请再输入一遍密码</label> <label
									class="focus valid"></label>
							</div>
						</div>
						<input type="text" id="adminID" name="adminID"
							value="${user.admin_id }" hidden="ture">
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl">&nbsp;</span>
							<div class="f-fl item-ifo">
								<a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">提交</a>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			//Apply Button
			$("#btn_part1").click(function() {
				if (!verifyCheck._click())
					return;
				document.form1.action = "../ModifyPwdAdmin";
				document.form1.submit();
			});
		});
	</script>
</body>
</html>