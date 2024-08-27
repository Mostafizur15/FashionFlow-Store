<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Update Product</title>
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

.form-table {
    width: 100%;
    margin-top: 20px;
    border-collapse: collapse;
}

.form-table td {
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

.form-table th {
    background-color: #f2f2f2;
    text-align: left;
}
</style>
</head>
<%-- "${pathContext.request.contextPath }/addProduct" --%>
<%-- "${pageContext.request.contextPath }/addProduct" --%>
<body>
    <div class="container">
        <form:form action="${pageContext.request.contextPath }/addProduct" method="post" modelAttribute="fetchProduct" enctype="multipart/form-data">
            <form:input type="hidden" path="productId" value="${fetchProduct.productId }" />
            <table class="form-table">
                <tr>
                    <th colspan="2">
                        <center>Product Information</center>
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
                    <td>
                        <form:select path="categoryId">
                            <form:option value="0" label="Select List" />
                            <form:options items="${categoryList}" itemValue="categoryId" itemLabel="categoryDesc" />
                        </form:select>
                    </td>
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
                    <td colspan="2">
                        <input type="submit" value="Update Product" class="btn btn-success" />
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
