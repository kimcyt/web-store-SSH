<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>sign up</title>
    <link href="${pageContext.request.contextPath}/css/signup.css" rel="stylesheet">
</head>
<body>
	
    <div class="header">
        <div class="center">
            <div class="left_block">
                <img src="${pageContext.request.contextPath}/img/logo.png">
            </div>
            <div class="right_block">
                <p>Already have an account? <a href="${pageContext.request.contextPath}/"><em>Login Here</em></a></p>
            </div>
        </div>

    </div>

    <div class="body">
        <div class="form">
            <form onsubmit="return validateInputs()" method="post">
            	<div><label>user Id</label><input id="userId" type="text" name="userId" required autofocus><br></div>
                <div><label>username</label><input id="username" type="text" name="username" required><br></div>
                <div><label>password</label><input id="password1" type="password" name="password" required><br></div>
                <div><label>password</label><input id="password2" type="password" name="repassword" required><br></div>
                <p id="error"></p>
                <div id="submit"><input type="submit" value="Create Account"></div>
            </form>
            
        </div>
        
        <div class="footer">
			<div class="col-md">
				<%@ include file="footer.jsp" %>
			</div>
		</div>
    </div>

	<script type="text/javascript">
	
		function validateInputs(){
			console.log("validating inputs");
			let userId = $("#userId").val();
			let username = $("#username").val();
			let pwd1 = $("#password1").val();
			let pwd2 = $("#password2").val();

			console.log("inputs:", userId, username,pwd1,pwd2);
			if(!userId || !username || !pwd1 || !pwd2){
				displayMsg("Please enter all the required fields");
				return false;
			}
			if(pwd1 !== pwd2){
				displayMsg("Passwords do not match");
				return false;
			}
			//let form = document.getElementById("signupForm");
			//form.submit(); 
			let args = {userId: userId, username: username, password: pwd1};
			$.post("${pageContext.request.contextPath}/user", args, function(result){
				console.log(result);
				//let result = $.parseJSON(data);
				if(result.error == null){
					console.log("directing to main");
					location.href = "${pageContext.request.contextPath}" + result.url;	
				} else {
					displayMsg(result.error);
				}
			
			})
			return false;
		}
		
		function displayMsg(msg){
			$("#error").text(msg);
			setTimeout(function(){
				$("#error").text("");
			}, 3000);
		}
		
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>