<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<br>
<br>
<script>
function check(sz){
	if(sz==0){
		alert("Please add some product to perform this action!")
		event.preventDefault();
	}
}

</script>
<div class="row" align="center">
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr class="danger">
					<td colspan="6">
						<center>Cart List</center>
					</td>
				</tr>
				<tr>
					<td>Product Id</td>
					<td>Product Name</td>
					<td>Quantity</td>
					<td>Price</td>
					<td>Sub-total</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartList}" var="cartItem">
					<form
						action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>">
						<tr class="info">
							<td>${cartItem.productId}</td>
							<td>${cartItem.productName}</td>
							<td><input type="text" value="${cartItem.quantity}"
								name="quantity"></td>
							<td>${cartItem.price}$</td>
							<td>${cartItem.price * cartItem.quantity}$</td>
							<td><input type="submit" value="Update"
								class="btn btn-success" /> <a
								href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>"
								class="btn btn-danger">Delete</a></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr class="warning">
					<td colspan="4">Total Purchase Amount</td>
					<td colspan="2">${grandTotal}$</td>
				</tr>
				<tr class="info">
					<td colspan="3">
						<center>
							<a href="<c:url value="/productDisplay"/>"
								class="btn btn-success">Continue Shopping</a>
						</center>
					</td>
					<td colspan="3">
						<center>
							<a href="<c:url value='/checkout'/>" class="btn btn-success"
								onclick="check(${cartList.size()})">Check Out</a>
						</center>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
