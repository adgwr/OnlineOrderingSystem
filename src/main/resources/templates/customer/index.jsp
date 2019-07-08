<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
href="../templets/cloud_04/style/lib.css"/>
<link rel="stylesheet" type="text/css"
  href="../templets/cloud_04/style/style.css"/>
  <link rel="stylesheet" type="text/css"
    href="../templets/cloud_04/style/376.css"/>
    <script type="text/javascript"
      src="../templets/cloud_04/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript"
      src="../templets/cloud_04/js/org.js" data-main="baseMain"></script>
      
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/customer/css/main.css"/>
<title>Insert title here</title>
</head>
<body class="nobanner">
<jsp:include page="../banner.jsp" ></jsp:include>
	<div id="sitecontent">
		<div class="npagePage">
			<div class="content">
				<iframe style="border-right:1px solid rgba(255, 255, 255, .1)" src="left.html" width="183px" height="1000px" frameborder="0" scrolling="no" allowtransparency="true"></iframe>
				<iframe src="customerMain.jsp" width="82%" height="1000px" frameborder="0" scrolling="no" name="rightFrame" id="rightFrame" title="rightFrame"></iframe>
			</div>		
		</div>
	</div>
<jsp:include page="../footer.jsp" ></jsp:include>  
  
  
  
</body>
</html>