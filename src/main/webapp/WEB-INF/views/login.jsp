<%@ page language="java" contentType="text/html" %>
<%@include file="/WEB-INF/views/header.jsp" %>
<html>
<head>
<style>
    .full-height {
        height: 80vh; /* Full height of the viewport */
    }
    .centered-box {
        margin-top: auto;
        margin-bottom: auto;
    }
</style>
</head>
<body>
    <div class="container full-height">
        <div class="row justify-content-center align-items-center full-height">
            <div class="col-md-8 centered-box">
                <div class="card">
                    <div class="card-header">Login</div>
                    <div class="card-body">
                        <form action="perform_login" method="post">
                            <div class="form-group row">
                                <label for="username" class="col-md-4 col-form-label text-md-right">Username</label>
                                <div class="col-md-6">
                                    <input type="text" id="username" class="form-control" name="username" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control" name="password" required>
                                </div>
                            </div>

                            <div class="form-group row mb-0">
                                <div class="col-12 text-center">
                                    <button type="submit" class="btn btn-primary">
                                        Login
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
