<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<div id="footer">
		<p>COPYRIGHT (©) 2018 网上订餐系统</p>
	</div>

	<div id="shares">
		<a id="sshare"><i class="fa fa-share-alt"></i></a><a
			href="javascript:if(confirm('http://service.weibo.com/share/share.php?appkey=3206975293&))window.location='http://service.weibo.com/share/share.php?appkey=3206975293&'"
			target="_blank" id="sweibo"><i class="fa fa-weibo"></i></a><a
			href="javascript:;" id="sweixin"><i class="fa fa-weixin"></i></a><a
			href="javascript:;" id="gotop"><i class="fa fa-angle-up"></i></a>
	</div>
<!-- 	<div class="fixed" id="fixed_weixin"> -->
<!-- 		<div class="fixed-container"> -->
<!-- 			<div id="qrcode"></div> -->
<!-- 			<p>扫描二维码分享到微信</p> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<div id="online_open">
		<i class="fa fa-comments-o"></i>
	</div>
	<div id="online_lx">
		<div id="olx_head">
			在线咨询<i class="fa fa-times fr" id="online_close"></i>
		</div>
		<ul id="olx_qq">
			<li><a
				href="tencent://message/?uin=8888899999&Site=uelike&Menu=yes"><i
					class="fa fa-qq"></i>客服一</a></li>
			<li><a
				href="tencent://message/?uin=888889999&Site=uelike&Menu=yes"><i
					class="fa fa-qq"></i>客服二</a></li>
		</ul>
		<div id="olx_tel">
			<div>
				<i class="fa fa-phone"></i>联系电话
			</div>
			<p>
				17792935660<br />
			</p>
		</div>
	</div>
	<div class="hide"></div>
</body>
</html>