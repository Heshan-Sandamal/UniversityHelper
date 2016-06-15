<html>
<head>
<link rel="stylesheet" href="resources/css/logInStyle.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery-1.9.1.min.js"></script>
<title>Apartment Owner LogIn</title>
</head>

<body
	style="background: url('resources/images//homeOwner.jpg') no-repeat center center fixed; background-size: 100%; -webkit-background-size: 100%;">

	<div class="container">
		<div class="row" id="pwd-container">
			<div class="col-md-4"></div>

			<div class="col-md-4">
				<section class="login-form">
					<form method="post" action="LLLogIn" role="login">
						<div class="row">
							<h2>Apartment owner Sign In</h2>
						</div>

						<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive"
							alt="" /> <input type="text" name="userName" required
							class="form-control input-lg" value="HS" /> <input
							type="password" name="password" class="form-control input-lg"
							id="password" placeholder="121212" required="" /> <span>
							<ul>

								<%
									if (request.getAttribute("error") != null) {
								%>

								<li><%=request.getAttribute("error")%></li>

								<%
									}
								%>

							</ul>
						</span>



						<button type="submit" name="go"
							class="btn btn-lg btn-primary btn-block" id="formSubmitButton">Sign in</button>
						<div>
							<a href="LandLordSignUp">Create account</a> or <a href="" class="scroll"
								data-toggle="modal" data-target="#sendMail"
								onclick="return false;" id="remPasswordLink">Remember password</a>
								
						</div>
					</form>

					<div class="form-links">
						<a href="#">www.website.com</a>
					</div>
				</section>
			</div>

			<div class="col-md-4"></div>


		</div>

		<p>
			<a
				href="http://validator.w3.org/check?uri=http%3A%2F%2Fbootsnipp.com%2Fiframe%2FW00op"
				target="_blank"><small>HTML</small><sup>5</sup></a> <br> <br>

		</p>

		<div class="modal fade" id="sendMail" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<form action="RecoverLLPassword" method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<div class="row">
								<div class="col-md-3">
									<img src="resources/images/logout-button-hi.png">
								</div>
								<div class="" col-md-9>
									<h3 class="modal-title">Enter your userName</h3>
								</div>
							</div>
						</div>
						<div class="model-body">
							<input type="text" class="form-control input-lg" name="userName"
								placeholder="User Name" id="remPasswordUserName">
						</div>
						<div class="modal-footer">

							<button class="btn btn-warning btn-lg" type="submit" id="passwordSendButton">Send</button>
							<button type="button" class="btn btn-default btn-lg"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<script src="resources/js/bootstrap.js"></script>
	<script>
		$('#messages').text("password oe");
	</script>
</body>
</html>