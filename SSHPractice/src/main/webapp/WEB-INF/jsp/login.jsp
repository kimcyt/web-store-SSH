<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4 header" >
            	<img src="${pageContext.request.contextPath}/img/logo.png" alt="local picture" >
			</div>	
		</div>
		
		<div class="row">
			<div class="col-md-4 offset-md-4 middle-part">
	        	<div class="login"> 
	            	<form:form onsubmit="return validateInputs()" modelAttribute="user" action="${pageContext.request.contextPath}/user" method="POST">
	                	<div class="user_inputs">
	                    	<img src="${pageContext.request.contextPath}/img/user.png">
	                    	<form:input id="userId" type="text" path="userId" autofocus="true" required="true"/> 
	                	</div>
	                	<div class="user_inputs">
	                    	<img src="${pageContext.request.contextPath}/img/pwd.png">
	                    	<form:input id="password" type="password" path="password" required="true"/> 
	                	</div>
	                	<div>
	                		<input type="submit" value="Login"> 
	                	</div>
	                	<div class="other-options">
	                    	<a href="">forgot password</a>
	                    	<a href="signUp.jsp">signup</a>
	                	</div>
	            	</form:form>
	        	</div>
				<p id="error">${error}<p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md">
				<%@ include file="footer.jsp" %>
			</div>
		</div>
	</div>
	
	
	<!-- user inputs must match the POJO field types, or the client side may throw error -->
	<script type="text/javascript">
	function validateInputs(){
		console.log("validating inputs");
		let val = parseInt($("#userId").val());
		if(isNaN(val)){
			$("#error").text("userId must be number. Please try again.");
			setTimeout(function(){
				$("#error").text("");
			}, 3000);
			return false;
		}
		let args = {userId: val, password: $("#password").val()};
		$.post("${pageContext.request.contextPath}/user", args, function(data){
			console.log(data);
			$("#error").text(data);
			setTimeout(function(){
				$("#error").text("");
			}, 3000);
		})
		return false;
	}	
		
	</script>
    
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>