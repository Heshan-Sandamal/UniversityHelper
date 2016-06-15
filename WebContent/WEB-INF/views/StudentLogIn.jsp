<html>
<head>
<link rel="stylesheet" href="resources/css/logInStyle.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/logInScript.js"></script>
<title>Student LogIn</title>
</head>

<body
	style="background: url('resources/images/o-UNIVERSITY-STUDENT-facebook.jpg') no-repeat center center fixed;">

	<div class="container">
		<div class="row" id="pwd-container">
			<div class="col-md-4"></div>

			<div class="col-md-4">
				<section class="login-form">
					<form method="post" action="StudentLogIn" role="login">
						<div class="row">
							<h2>Student Sign In</h2>
						</div>

						<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive"
							alt="" /> <input type="text" name="userName" placeholder="Email"
							required class="form-control input-lg"
							value="joestudent@gmail.com" /> <input type="password"
							class="form-control input-lg" name="password" id="password"
							placeholder="Password" required="" />


						<div class="pwstrength_viewport_progress"></div>


						<button type="submit" name="go"
							class="btn btn-lg btn-primary btn-block">Sign in</button>

						<div>
							<a href="StudentSignUp">Create account</a> or <a href=""
								class="scroll" data-toggle="modal" data-target="#sendMail"
								onclick="return false;">Remember password</a>
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


	</div>

	<div class="modal fade" id="sendMail" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form action="SendMail" method="post">
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
						<input type="text" class="form-input" name="userName"
							placeholder="User Name">
					</div>
					<div class="modal-footer">

						<button class="btn btn-warning btn-lg" type="submit">Send</button>
						<button type="button" class="btn btn-default btn-lg"
							data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>

		</div>
	</div>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>