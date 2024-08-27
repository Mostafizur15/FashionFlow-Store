<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${pageinfo }">FashionFlow</c:out></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="${pageContext.request.contextPath}">FashionFlow</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<c:choose>
					<c:when test="${!sessionScope.loggedIn}">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link"
								href="<c:url value='/login'/>">Login</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value='/register'/>">Register</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value='/contact'/>">Contact Us</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value='/about'/>">About Us</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${sessionScope.role == 'ROLE_ADMIN'}">
								<ul class="navbar-nav">
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/adminHome'/>">Home</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/product'/>">Manage Product</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/category'/>">Manage Category</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/productDisplay'/>">Product Catalog</a></li>

								</ul>
							</c:when>
							<c:otherwise>
								<ul class="navbar-nav">
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/userHome'/>">Home</a></li>
									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
										role="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> CATEGORY </a>
										<div class="dropdown-menu" aria-labelledby="navbarDropdown">
											<a class="dropdown-item" href="<c:url value='/mens'/>">Men's</a>
											<a class="dropdown-item"
												href="<c:url value='/womens'/>">Women's</a> <a
												class="dropdown-item"
												href="<c:url value='/kids'/>">Kid's</a>
										</div></li>
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/contact'/>">Contact Us</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/about'/>">About Us</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/cart'/>">Cart</a></li>
								</ul>
							</c:otherwise>
						</c:choose>
						<div class="navbar-nav ml-auto">
							<span class="navbar-text text-white">Welcome:
								${sessionScope.userName}</span> <a
								href="<c:url value='/perform_logout'/>"
								class="btn btn-danger ml-2">Logout</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</nav>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
