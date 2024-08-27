<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
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
<%
System.out.println("${message}");
%>
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

		<form action="addCategory" method="post">
			<table class="form-table">
				<tr>
					<td colspan="2">
						<h3>Category</h3>
					</td>
				</tr>
				<tr>
					<td>Category Name</td>
					<td><input type="text" name="categoryName" /></td>
				</tr>
				<tr>
					<td>Category Description</td>
					<td><input type="text" name="categoryDesc" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add Category"
						class="btn btn-success"></td>
				</tr>
			</table>
		</form>
		<table class="data-table">
			<tr>
				<th>Category Id</th>
				<th>Category Name</th>
				<th>Category Description</th>
				<th>Category Operation</th>
			</tr>
			<c:forEach items="${listOfCategory}" var="list">
				<tr>
					<td>${list.categoryId}</td>
					<td>${list.categoryName}</td>
					<td>${list.categoryDesc}</td>
					<td><a
						href="${pageContext.request.contextPath }/deleteCategory/${list.categoryId}"><i
							class="fas fa-trash text-danger"></i></a> &nbsp<a
						href="${pageContext.request.contextPath }/updateCategory/${list.categoryId}"><i
							class="fas fa-pencil-alt"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
