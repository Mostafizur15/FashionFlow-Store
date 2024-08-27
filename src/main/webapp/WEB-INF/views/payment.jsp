<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<style>
    .payment-container {
        margin-top: 40px;
    }
    .payment-form {
        background-color: #f8f9fa;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .payment-form h3 {
        margin-bottom: 20px;
        text-align: center;
        color: #28a745;
    }
    .radio-group {
        display: flex;
        justify-content: space-around;
        margin-bottom: 15px;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-control {
        border-radius: 4px;
    }
</style>
<script>
function off(){
	document.getElementById("cardNumber").readOnly=true;
	document.getElementById("valid").readOnly=true;
	document.getElementById("CVV").readOnly=true;
	document.getElementById("name").readOnly=true;
	//cardNumber.readOnly=true;
}
function on(){
// 	alert(122);
	document.getElementById("cardNumber").readOnly=false;
	document.getElementById("valid").readOnly=false;
	document.getElementById("CVV").readOnly=false;
	document.getElementById("name").readOnly=false;
}
</script>
<div class="container payment-container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="<c:url value='/receipt'/>" method="post" class="payment-form">
                <h3>Payment Details</h3>

                <div class="radio-group form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="rd" id="creditCard" value="cc" checked onclick="on()">
                        <label class="form-check-label" for="creditCard">Credit Card</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="rd" id="cod" value="cod" onclick="off()">
                        <label class="form-check-label" for="cod">Cash On Delivery</label>
                    </div>
                </div>
				<div class="container" id="cardInfo">
                <div class="form-group">
                    <label for="cardNumber">Card Number</label>
                    <input type="text" class="form-control" id="cardNumber" name="cardNumber" placeholder="Enter your card number" required>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="valid">Valid</label>
                        <input type="text" class="form-control" id="valid" name="valid" placeholder="MM/YY" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="CVV">CVV</label>
                        <input type="text" class="form-control" id="CVV" name="CVV" placeholder="CVV" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="name">Name on Card</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name on card" required>
                </div>
				</div>
                <div class="form-group text-center">
                    <input type="submit" value="Pay" class="btn btn-success btn-lg">
                </div>
            </form>
        </div>
    </div>
</div>
