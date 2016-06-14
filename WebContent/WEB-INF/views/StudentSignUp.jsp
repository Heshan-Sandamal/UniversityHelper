<html>
<head>
<link rel="stylesheet" href="resources/css/logInStyle.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">

<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/logInScript.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<style>
body {
	background-color: #525252;
}

.centered-form {
	margin-top: 60px;
}

.centered-form .panel {
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
</style>
<script>
	$(function() {

		$(".dropdown-menu").on('click', 'li a', function() {
			$(".btn:first-child").text($(this).text());
			$(".btn:first-child").val($(this).text());
		});

	});
</script>

</head>

<body
	style="background: url('resources/images/signUp.jpg') no-repeat center center fixed;">
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="com.universityHelper.models.Course"%>
	<%
		ArrayList<Course> courseList = (ArrayList<Course>) request.getAttribute("courseList");
	%>
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Student sign up for University Helper <small>It's free!</small>
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="StudentSignUp" method="post">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="firstName" id="first_name"
											class="form-control input-sm" placeholder="First Name">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="lastName" id="last_name"
											class="form-control input-sm" placeholder="Last Name">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input type="email" name="email" id="email"
									class="form-control input-sm" placeholder="Email Address">
							</div>


							<div class="form-group">
								<input type="text" name="userName" id="email"
									class="form-control input-sm" placeholder="User Name">
							</div>


							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password" id="password"
											class="form-control input-sm" placeholder="Password">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											id="password_confirmation" class="form-control input-sm"
											placeholder="Confirm Password">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input type="text" name="address" id="email"
									class="form-control input-sm" placeholder="Address/ Home town">
							</div>

							<div class="form-group">
								<input type="date" name=birthday id="birthday"
									class="form-control input-sm" placeholder="birthday" required>
							</div>

							<div class="form-group">
								<input type="number" name="examYear" id="email"
									class="form-control input-sm" placeholder="A/L exam year">
							</div>

							<!-- Single button -->
							<div class="btn-group form-group">

								<input type="text" id="pac-input" name="course" class="form-control input-sm" readonly="readonly" required="required">

								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									Select University <span class="caret"></span>
								</button>
								<ul name="university" class="dropdown-menu">
									<%
										for (Course course : courseList) {
									%>
									<li><a href="#"><%=course.getName()%></a></li>
									<%
										}
									%>
								</ul>
							</div>

							<div class="form-group">
								<input type="tel" name="contactNo" id="email"
									class="form-control input-sm" placeholder="Contact No">
							</div>

							<div class="form-group">
								<input type="text" name="fburl" id="email"
									class="form-control input-sm" placeholder="Facebook link">
							</div>


							<input type="submit" value="Register"
								class="btn btn-info btn-block">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script>
		$(".dropdown-menu li a").click(
				function() {
					var selText = $(this).text();
					$(this).parents('.btn-group').find('.dropdown-toggle')
							.html(selText + ' <span class="caret"></span>');
					$("#pac-input").val(selText);
					//$("ul#universityList").appendTo("li").text(selText);

				});
	</script>

</body>
</html>