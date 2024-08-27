<%-- <%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="row">
	<c:forEach items="${listOfProduct }" var="product">
	
	<div class="col-sm-4 col-md-3">
		<a href="<c:url value="totalProductDisplay/${product.productId }"/>" class="thumbnail">
			<img src="<c:url value='/resources/images/${product.productId}.jpg' />" alt="Generic Placeholder thumbnail">
		</a>
		<p align="center" >product name: ${product.productName } </p>
		<p align="center" >price: ${product.price } </p>
		<p align="center" >stock: ${product.stock } </p>
	</div>
	
	</c:forEach>
</div> --%>
<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<style>
    .product-container {
        margin-left: auto;
        margin-right: auto;
    }
    .card {
        border: 1px solid #ddd;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        border-radius: 4px;
        overflow: hidden;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
    }
    .card img {
        max-width: 100%;
        height: auto;
    }
    .card-body {
        padding: 10px;
        text-align: center;
    }
    .text-left {
        text-align: left;
    }
</style>

<div class="container product-container mt-4">
    <div class="row">
        <c:forEach items="${listOfProduct}" var="product">
            <div class="col-6 col-md-4 col-lg-2 mb-4">
                <div class="card h-100">
                    <a href="<c:url value='totalProductDisplay/${product.productId}'/>" class="thumbnail">
                        <img src="<c:url value='/resources/images/${product.productId}.jpg'/>"
                             class="card-img-top"
                             alt="${product.productName}">
                    </a>
                    <div class="card-body text-center">
                        <h5 class="card-title">${product.productName}</h5>
                        <p class="card-text">Price: $${product.price}</p>
                        <p class="card-text">Stock: ${product.stock}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>



