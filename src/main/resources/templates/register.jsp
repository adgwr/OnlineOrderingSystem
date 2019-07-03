<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	try {
		if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			window.location.href = "m/register.jsp";
		}
	} catch (e) {
	}
</script>
<title>Register page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/gloab.css" rel="stylesheet">
<link href="css/addAddress.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/addAddress.js"></script>

<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/lib.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/style.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/376.css" />
<script type="text/javascript"
	src="templets/cloud_04/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="templets/cloud_04/js/org.js"
	data-main="baseMain"></script>

</head>
<body class="nobanner">
	<jsp:include page="banner.jsp"></jsp:include>
	<!-- <div class="bgf4"> -->
	<div id="sitecontent">
		<div class="npagePage Pageanli" id="mproject">
			<div class="content">
				<div class="header" id="plheader">
					<p class="title">注册新用户</p>
					<p class="subtitle">WELCOME!</p>
				</div>
				<div class="login-box f-mt10 f-pb50">
					<div class="main bgf">
						<div  >
<!-- 						style="background: #2B2B2B;" -->
<!-- 							<div class="step"> -->
<!-- 								<ul> -->
<!-- 									<li class="col-xs-4 on"><span class="num"><em -->
<!-- 											class="f-r5"></em><i>1</i></span> <span class="line_bg lbg-r"></span> -->
<!-- 										<p class="lbg-txt">Fill in Librarian information</p></li> -->
<!-- 									<li class="col-xs-4"><span class="num"><em -->
<!-- 											class="f-r5"></em><i>2</i></span> <span class="line_bg lbg-l"></span> -->
<!-- 										<p class="lbg-txt">Register successfully</p></li> -->
<!-- 								</ul> -->
<!-- 							</div> -->

							<div class="reg-box" id="verifyCheck" style="margin-top: 10px;">
								<form id="form2" name="fff" method="POST">
									<div class="item col-xs-12">
										<span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名:</span>
										<div class="f-fl item-ifo">
											<input type="text" name="CustomerID" maxlength="20"
												class="txt03 f-r3 required" tabindex="1"
												data-valid="isNonEmpty||between:3-20||isUname"
												data-error="用户名不能为空||用户名长度在3到20位||只能为字母、数字或下划线，以字母开头"
												id="userID" /> <span class="ie8 icon-close close hide"></span>
											<label class="icon-sucessfill hide"></label> <label
												class="focus"><span style="">3-20位字母、数字或下划线，以字母开头</span></label>
											<label class="focus valid"></label>
										</div>
									</div>
									<div class="item col-xs-12">
										<span class="intelligent-label f-fl"><b class="ftx04">*</b>电子邮箱:</span>
										<div class="f-fl item-ifo">
											<input type="text" name="email" class="txt03 f-r3 required"
												keycodes="email" tabindex="2"
												data-valid="isNonEmpty||isEmail"
												data-error="电子邮件不能为空||电子邮件格式错误"
												maxlength="30" id="email" /> <span
												class="ie8 icon-close close hide"></span> <label
												class="icon-sucessfill hide"></label> <label
												class="focus">电子邮箱地址</label> <label
												class="focus valid"></label>
										</div>
									</div>
									<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>密码:</span>
							<div class="f-fl item-ifo">
								<input type="password" name="password" id="thepassword"
									maxlength="20" class="txt03 f-r3 required" tabindex="3"
									style="ime-mode: disabled;" onpaste="return  false"
									autocomplete="off"
									data-valid="isNonEmpty||between:6-16||level:2"
									data-error="密码不能为空||密码长度在6到16位||密码太简单" />
								<span class="ie8 icon-close close hide" style="right: 55px"></span>
								<span class="showpwd" data-eye="password"></span> <label
									class="icon-sucessfill hide"></label> <label
									class="focus">6-16位英文字母，数字或字符</label> <label
									class="focus valid"></label> <span class="clearfix"></span> <label
									class="strength"> <span class="f-fl f-size12">安全性:</span>
									<b><i>弱</i><i>中</i><i>强</i></b>
								</label>
							</div>
						</div>

									<div class="item col-xs-12">
										<span class="intelligent-label f-fl">&nbsp;</span>
										<div class="f-fl item-ifo">
											<a href="javascript:;" class="btn btn-blue f-r3"
												id="btn_part1">注册</a>
										</div>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		$(function() {
			//Register Button
			$("#btn_part1").click(function() {
				if (!verifyCheck._click())
					return;
				document.fff.action = "CRegister";
				document.fff.submit();
			});
		});
	</script>
</body>
</html>