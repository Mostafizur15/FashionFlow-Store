<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<br>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered" align="center">
			<tr class="denger">
				<td colspan="6"><h3 align="center">RECEIPT</h3></td>
			</tr>
			<tr class="info">
				<td>ORDER ID</td>
				<td>ORD00${orderDetail.orderId }</td>
				<td>Date</td>
				<td colspan="2">${orderDetail.orderDate }</td>
			</tr>
			<tr>
				<td colspan="5"><h4 align="center">Order Items</h3></td>
			</tr>
			<tr>
				<td>Product Id</td>
				<td>Product Name</td>
				<td>Quantity</td>
				<td>Price </td>
				<td>SubTotal </td>
			</tr>
			<c:forEach items="${cartList }" var="cartItem">
				<tr class="info">
					<td>${cartItem.productId }</td>
					<td>${cartItem.productName }</td>
					<td>${cartItem.quantity }</td>
					<td>${cartItem.price }$</td>
					<td>${cartItem.price}*${cartItem.quantity }</td>
				</tr>
			</c:forEach>
			<tr class="warning">
				<td colspan="4">Total Purchase Amount</td>
				<td colspan="1">${grandTotal }$</td>
			</tr>
			
			<tr class="warning">
				<td colspan="5"><h4 align="center">Shipping Address</h4></td>
			</tr>
			<tr class="info">
				<td>Address</td>
				<td colspan="4">${addr}</td>
			</tr>
			
		</table>
	
	</div>
</body>
</html>