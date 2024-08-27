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
	width: 80%;
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

/* .form-table input[type="submit"] { */
/* 	width: 100%; */
/* 	padding: 10px; */
/* 	background-color: #4CAF50; */
/* 	color: white; */
/* 	border: none; */
/* 	cursor: pointer; */
/* 	border-radius: 4px; */
/* } */
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
<script>
	function goBack() {
		window.location.href = '<c:url value="/category"/>';
	}
</script>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath }/addCategory"
			method="post">
			<input type="hidden" name="categoryId"
				value="${category.categoryId }" />
			<table class="form-table">
				<tr>
					<td colspan="2">
						<h3>Category</h3>
					</td>
				</tr>
				<tr>
					<td>Category Name</td>
					<td><input type="text" name="categoryName"
						value="${category.categoryName }" /></td>
				</tr>
				<tr>
					<td>Category Description</td>
					<td><input type="text" name="categoryDesc"
						value="${category.categoryDesc }" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Update"
						class="btn btn-success" /> <input type="button" value="Return"
						class="btn btn-success" onclick="goBack()" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
