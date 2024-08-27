<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<html>
<head>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f5f5f5;
        }

        h2 {
            margin-top: 20px;
            font-size: 28px;
            text-align: center;
            font-weight: bold;
            color: #333;
        }

        .carousel {
            margin-top: 30px;
        }

        .carousel-inner img {
            height: 500px;
            object-fit: cover;
            border-radius: 10px;
        }

        .carousel-indicators li {
            background-color: #333;
        }

        .carousel-control-prev-icon,
        .carousel-control-next-icon {
            background-color: rgba(0, 0, 0, 0.3);
            padding: 20px;
            border-radius: 50%;
        }

        footer {
            margin-top: 50px;
            padding: 20px;
            background-color: #333;
            color: white;
            text-align: center;
        }

        .container {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to Our Store</h2>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
        
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
                <li data-target="#myCarousel" data-slide-to="4"></li>
            </ol>

            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img alt="Slide 1" src="<c:url value='/resources/images/s6.jpg' />" class="d-block w-100">
                </div>
                <div class="carousel-item">
                    <img alt="Slide 2" src="<c:url value='/resources/images/h7.jpeg' />" class="d-block w-100">
                </div>
                <div class="carousel-item">
                    <img alt="Slide 3" src="<c:url value='/resources/images/h5.jpg' />" class="d-block w-100">
                </div>
                <div class="carousel-item">
                    <img alt="Slide 4" src="<c:url value='/resources/images/h6.jpg' />" class="d-block w-100">
                </div>
                <%-- <div class="carousel-item">
                    <img alt="Slide 5" src="<c:url value='/resources/images/s6.jpg' />" class="d-block w-100">
                </div> --%>
            </div>

            <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 E-Commerce Site. All rights reserved.</p>
    </footer>

    <script src="<c:url value='/resources/js/jquery.min.js' />"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
</body>
</html>
