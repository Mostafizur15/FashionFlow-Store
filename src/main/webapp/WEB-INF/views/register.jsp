<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<br>
<style>
    /* Optional: Add some CSS for error highlighting */
    .highlight {
        border: 2px solid red;
        background-color: #f8d7da;
    }
</style>
<script>
function valid(event){
    var password1 = document.getElementById('password').value;
    var password2 = document.getElementById('confirmPassword').value;

    // Reset styles
    document.getElementById('password').classList.remove('highlight');
    document.getElementById('confirmPassword').classList.remove('highlight');

    if (password1 === password2) {
        // Form is valid, submit the form
        document.getElementById('form1').submit();
    } else {
        // Prevent form submission
        event.preventDefault();
        alert("Passwords do not match. Please provide the correct password!");
        document.getElementById('password').classList.add('highlight');
        document.getElementById('confirmPassword').classList.add('highlight');
    }
}
</script>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Register</div>
                <div class="card-body">
                    <form id="form1" method="post" action="performRegistration">
                        <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label">Your Name</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="customerName" id="customerName" placeholder="Enter your Name" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Address</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-home fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="address" id="address" placeholder="Enter your Address" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Username</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="userName" id="userName" placeholder="Enter your Username" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Password</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="password" id="password" placeholder="Enter your Password" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="Confirm your Password" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-lg btn-block login-button" onclick="valid(event)">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
