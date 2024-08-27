<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp" %>
<br><br>
<div class="container">

	<table class="table table-bordered">
		<tr class="danger">
			<td colspan="6">
				<center>Order Items</center>
			</td>
		</tr>
		
		<tr>
			<td>Product Id</td>
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Sub-Total</td>
		</tr>
		
		<c:forEach items="${cartList }" var="cartItem">
			<tr class="info">
				<td>${cartItem.productId }</td>
				<td>${cartItem.productName }</td>
				<td>${cartItem.quantity }</td>
				<td>${cartItem.price }$</td>
				<td>${cartItem.price*cartItem.quantity }$</td>
			</tr>
		</c:forEach>
		<tr class="warning">
			<td colspan="4">Total purchase amount</td>
			<td colspan="1">${grandTotal }$</td>	
		</tr>
		<tr class="warning">
		<td colspan="5">Shipping Address</td>
		</tr>
		
		<form action="<c:url value="/updateaddr"/>" method="post">
			<tr class="info">
				<td>Address</td>
				<td colspan="3">
					<textarea name="addr" cols="32" rows="1">${addr }</textarea>
				</td>
				<td>
					<input type="submit" value="Update Address" class="btn btn-success"/>
				</td>
			</tr>
		</form> 
		
		<tr class="warning">
			<td colspan="5"></td>
		</tr>
		<tr class="info">
		<td colspan="2">
			<center><a href="<c:url value="/cart"/>" class="btn btn-success">Modify Cart</a></center>
		</td>
		<td colspan="3">
			<center><a href="<c:url value="/payment"/>" class="btn btn-success">Order Confirm</a></center>
		</td>
	</table>














</div>