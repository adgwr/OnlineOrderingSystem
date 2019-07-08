<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>
<!DOCTYPE html>
<html >
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css" />
<title>Order Manage</title>
<style type="text/css">body {margin-bottom:300px;}</style>
</head>
<body>
	<div class="main">
		<div class="main-content">
			<div class="container-fluid">
				<h3 class="page-title">订单管理</h3>
				<div class="row">

					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">待接单</h3>
						</div>
						<div class="panel-body">
							<form method="post"
								action="/receiveOrder">
								<table class="table">

									<thead>
										<tr>
											<th></th>
											<th>订单ID</th>
											<th>用户ID</th>
											<th>收货人姓名</th>
											<th>收货人地址</th>
											<th>收货人电话</th>
											<th>订单日期</th>
											<th>订单状态</th>
											<th>配送方法</th>
											<th>订单项</th>
										</tr>
									</thead>
										<tr>
											<td width="40"><input type="checkbox" name="paidorder"
												value="${paid.orderID}"></td>

											<td>${paid.orderID}</td>
											<td>${paid.customerID}</td>
											<td>${paid.receiver.name}</td>
											<td>${paid.receiver.address}</td>
											<td>${paid.receiver.tel}</td>
											<td>${paid.date}</td>
											<td>${paid.state}</td>
											<td>${paid.shipMethod}</td>
								<input type="submit" name="paid_submit" value="接单">

							</form>
						</div>
					</div>

					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">待配送</h3>
						</div>
						<div class="panel-body">
							<form method="post"
								action="${pageContext.request.contextPath}/OrderDoingToDelivering.do">
								<table class="table">
									<thead>
										<tr>
											<th></th>
											<th>订单ID</th>
											<th>用户ID</th>
											<th>收货人姓名</th>
											<th>收货人地址</th>
											<th>收货人电话</th>
											<th>订单日期</th>
											<th>订单状态</th>
											<th>配送方法</th>
											<th>订单项</th>
										</tr>
									</thead>
									<c:forEach var="doing" items="${doinglist}"
										varStatus="doingLoopCount">
										<tr>
											<td width="40"><input type="checkbox" name="doingorder"
												value="${doing.orderID}"></td>
											<td>${doing.orderID}</td>
											<td>${doing.customerID}</td>
											<td>${doing.receiver.name}</td>
											<td>${doing.receiver.address}</td>
											<td>${doing.receiver.tel}</td>
											<td>${doing.date}</td>
											<td>${doing.state}</td>
											<td>${doing.shipMethod}</td>
											<td><table>
													<c:forEach var="lineItem" items="${doing.lineItems}">
														<tr>
															<td>${lineItem.name}×${lineItem.amount}</td>
														</tr>
													</c:forEach>
												</table></td>
										</tr>
									</c:forEach>
								</table>
								<input type="submit" name="doing_submit" value="配送">

							</form>
						</div>
					</div>

					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">配送中</h3>
						</div>
						<div class="panel-body">

							<table class="table">
								<thead>
									<tr>
										<th></th>
										<th>订单ID</th>
										<th>用户ID</th>
										<th>收货人姓名</th>
										<th>收货人地址</th>
										<th>收货人电话</th>
										<th>订单日期</th>
										<th>订单状态</th>
										<th>配送方法</th>
										<th>订单项</th>
									</tr>
								</thead>
								<c:forEach var="delivering" items="${deliveringlist}"
									varStatus="doingLoopCount">
									<tr>
										<td>${delivering.orderID}</td>
										<td>${delivering.customerID}</td>
										<td>${delivering.receiver.name}</td>
										<td>${delivering.receiver.address}</td>
										<td>${delivering.receiver.tel}</td>
										<td>${delivering.date}</td>
										<td>${delivering.state}</td>
										<td>${delivering.shipMethod}</td>
										<td><table>
												<c:forEach var="lineItem" items="${delivering.lineItems}">
													<tr>
														<td>${lineItem.name}×${lineItem.amount}</td>
													</tr>
												</c:forEach>
											</table></td>
									</tr>
								</c:forEach>
							</table>



						</div>
					</div>

					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">已完成</h3>
						</div>
						<div class="panel-body">
							<table align="center">
								<tr>
									<td width="150px">Search Date</td>
									<td width="350px">
										<form method="POST" name="SearchOrders"
											action="${pageContext.request.contextPath}/OrderSearch.do">
											<mytag:OrderMonthSelect />
											<mytag:OrderDaySelect />
											<input type="submit" value="搜索">
										</form>
									</td>
								</tr>
							</table>
							<table class="table">
								<thead>
									<tr>
										<th>订单ID</th>
										<th>用户ID</th>
										<th>收货人姓名</th>
										<th>收货人地址</th>
										<th>收货人电话</th>
										<th>订单日期</th>
										<th>订单状态</th>
										<th>配送方法</th>
										<th>订单项</th>
									</tr>
								</thead>
								<c:forEach var="completed" items="${completedlist}"
									varStatus="completedLoopCount">
									<tr>
										<td>${completed.orderID}</td>
										<td>${completed.customerID}</td>
										<td>${completed.receiver.name}</td>
										<td>${completed.receiver.address}</td>
										<td>${completed.receiver.tel}</td>
										<td>${completed.date}</td>
										<td>${completed.state}</td>
										<td>${completed.shipMethod}</td>
										<td><table>
												<c:forEach var="lineItem" items="${completed.lineItems}">
													<tr>
														<td>${lineItem.name}×${lineItem.amount}</td>
													</tr>
												</c:forEach>
											</table></td>
									</tr>
								</c:forEach>

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