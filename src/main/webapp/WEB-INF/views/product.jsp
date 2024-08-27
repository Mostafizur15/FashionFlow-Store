<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Product Management</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

.container {
	width: 1200px;
	margin: auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h3 {
	text-align: center;
	color: #333;
}

.form-table, .data-table {
	width: 100%;
	margin-top: 20px;
	border-collapse: collapse;
}

.form-table td, .data-table th, .data-table td {
	padding: 10px;
	border: 1px solid #ddd;
}

.form-table input[type="text"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
}

.form-table input[type="submit"]:hover {
	background-color: #45a049;
}

.data-table th {
	background-color: #f2f2f2;
	text-align: left;
}

.data-table tr:nth-child(even) {
	background-color: #f9f9f9;
}

.data-table tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div class="container">
		<c:if test="${not empty message}">
            <div class="alert alert-success" align="center">
                ${message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" align="center">
                ${errorMessage}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
		<form:form action="addProduct" method="post" modelAttribute="product"
			enctype="multipart/form-data">
			<table class="form-table table-bordered">
				<tr>
					<th colspan="2">
						<center><h3>Product Information<h3></h3></center>
					</th>
				</tr>

				<tr>
					<td>Product Name</td>
					<td><form:input path="productName" /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td>Stock</td>
					<td><form:input path="stock" /></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><form:select path="categoryId">
							<form:option value="0" label="Select List" />
							<form:options items="${categoryList}" itemValue="categoryId"
								itemLabel="categoryName" />
						</form:select></td>
				</tr>
				<tr>
					<td>Supplier</td>
					<td><form:input path="supplierId" /></td>
				</tr>
				<tr>
					<td>Product Description</td>
					<td><form:input path="productDesc" /></td>
				</tr>
				<tr>
					<td>Product Image</td>
					<td><form:input type="file" path="pImage" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add Product"
						class="btn btn-success" /></td>
				</tr>
			</table>
		</form:form>

		<br />

		<table class="data-table table-bordered">
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Stock</th>
					<th>Supplier</th>
					<th>Operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfProduct}" var="list">
					<tr>
						<td>${list.productId}</td>
						<td>${list.productName}</td>
						<td>${list.price}</td>
						<td>${list.stock}</td>
						<td>${list.supplierId}</td>
						<td><a
							href="${pageContext.request.contextPath}/deleteProduct/${list.productId}">
								<i class="fas fa-trash text-danger"></i>
						</a> &nbsp; <a
							href="${pageContext.request.contextPath}/updateProduct/${list.productId}">
								<i class="fas fa-pencil-alt"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
