<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<br>
<br>
<form action="<c:url value="/addCart/${product.productId }"/>">

	<table class="table-bordered" align="center">
		<tr>
			<td rowspan="9">
            <img src="<c:url value='/resources/images/${product.productId}.jpg'/>" alt="Product Image" height="300">
            </td>
        </tr> 
        <tr>
			<td>Product Id</td>
			<td>${product.productId}</td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td>${product.productName}</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${product.price}</td>
		</tr>
		<tr>
			<td>Stock</td>
			<td>${product.stock}</td>
		</tr>
		<tr>
			<td>Category</td>
			<td>${product.categoryId}</td>
		</tr>
		<tr>
			<td>Supplier Id</td>
			<td>${product.supplierId}</td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td>${product.productDesc}</td>
		</tr>

		<tr>
			<td>Quantity <select name="quantity">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select>

			</td>
			<td><input type="submit" value="BUY" class="btn btn-success"></td>
		</tr>

	</table>

</form>