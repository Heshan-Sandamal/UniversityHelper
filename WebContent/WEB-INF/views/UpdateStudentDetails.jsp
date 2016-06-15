<html>
<head>
<link rel="stylesheet" href="resources/css/logInStyle.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Update Student Details</title>
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


	<%@ page import="com.universityHelper.models.Student"%>
	<%@ page import="java.text.SimpleDateFormat"%>
	<%@ page import="java.text.DateFormat"%>
	<%@ page import="java.text.ParseException"%>
	<%@ page import="java.util.Calendar"%>
	<%@ page import="java.util.Date"%>
	<%@ page import="com.universityHelper.models.Course"%>
	<%@ page import="java.util.ArrayList"%>



	<%
		Student student = (Student) request.getAttribute("student");

		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date date = null;

		String formatedDate=null;
		if (student.getDob() != null) {
			try {
				date = (Date) formatter.parse(student.getDob().toString());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			if ((cal.get(Calendar.MONTH) + 1) < 10) {
				formatedDate = cal.get(Calendar.YEAR) + "-0" + (cal.get(Calendar.MONTH) + 1) + "-"
						+ cal.get(Calendar.DATE);
			} else {
				formatedDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
						+ cal.get(Calendar.DATE);
			}
		}

	%>


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
						<form role="form" action="UpdateStudentDetails" method="post">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="firstName" id="first_name"
											value="<%=student.getFirstName()%>"
											class="form-control input-sm" placeholder="First Name" required="required">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="lastName" id="last_name"
											value="<%=student.getLastName()%>"
											class="form-control input-sm" placeholder="Last Name" required="required">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input type="email" name="email" id="email"
									value="<%=student.getEmail()%>" class="form-control input-sm"
									placeholder="Email Address" required="required">
							</div>


							<div class="form-group">
								<input type="text" name="userName" id="email"
									value="<%=student.getStudentProfile().getUserName()%>"
									class="form-control input-sm" placeholder="User Name" readonly="readonly" required="required">
							</div>


							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password" id="password"
											value="<%=student.getStudentProfile().getPassword()%>"
											class="form-control input-sm" placeholder="Password" required="required">

									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											value="<%=student.getStudentProfile().getPassword()%>"
											id="password_confirmation" class="form-control input-sm"
											placeholder="Confirm Password" required="required">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input type="text" name="address" id="email"
									value="<%=student.getHomeTown()%>"
									class="form-control input-sm" placeholder="Address/ Home town" required="required">
							</div>

							<div class="form-group">
								<input type="date" name="birthday" id="birthday"
									value="<%=formatedDate%>" class=" form-control input-sm"
									placeholder="birthday" required="required">

							</div>

							<div class="form-group">
								<input type="number" name="examYear" id="email"
									value="<%=student.getExamYear()%>"
									class="form-control input-sm" placeholder="A/L exam year" required="required" min="1990">
							</div>

							<!-- Single button -->
							<div class="btn-group form-group">
								<input type="text" id="pac-input" name="course"
									class="form-control input-sm" readonly="readonly"
									required="required" value="<%=student.getCourse().getName()%>">

								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									Select Course <span class="caret"></span>
								</button>
								<ul name="university" class="dropdown-menu"
									value="<%=student.getCourse().getName()%>"
									text="<%=student.getCourse().getName()%>">

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
									value="<%=student.getContactNo()%>"
									class="form-control input-sm" placeholder="Contact No">
							</div>

							<div class="form-group">
								<input type="text" name="fburl" id="email"
									value="<%=student.getFburl()%>" class="form-control input-sm"
									placeholder="Facebook link">
							</div>


							<input type="submit" value="Register"
								class="btn btn-info btn-block" onclick="return Validate()">

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
	
	<script type="text/javascript">
		function Validate() {
			var password = document.getElementById("password").value;
			var confirmPassword = document
					.getElementById("password_confirmation").value;
			if (password != confirmPassword) {
				alert("Passwords do not match.");
				return false;
			}
			return true;
		}
	</script>
	


</body>
</html>