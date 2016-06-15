<%@page import="java.util.ArrayList"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/signUp.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Update Apartment Owner Details</title>
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
	style="background: url('resources/images/ayside.jpg') no-repeat center center fixed; background-size: 100%; -webkit-background-size: 100%;">


	<%@ page import="com.universityHelper.models.LandLord"%>
	<%@ page import="java.util.ArrayList"%>

	<%
		LandLord landLord = (LandLord) request.getAttribute("landLord");
	%>
	<%
		ArrayList contactLIst = new ArrayList(landLord.getContactNoList());

		String contact1 = "";
		String contact2 = "";
		if (contactLIst.size() >= 1) {
			contact1 = contactLIst.get(0).toString();
		}
		String contact = "";
		if (contactLIst.size() >= 2) {
			contact2 = contactLIst.get(0).toString();
		}
	%>

	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							LandLord sign up for University Helper <small>It's free!</small>
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="UpdateLandLordDetails" method="post">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="firstName" id="firstName"
											class="form-control input-sm" placeholder="First Name"
											value="<%=landLord.getFirstName()%>" required="required">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="lastName" id="last_name"
											class="form-control input-sm" placeholder="Last Name"
											value="<%=landLord.getLastName()%>" required="required">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input type="email" name="email" id="email"
									class="form-control input-sm" placeholder="Email Address"
									value="<%=landLord.getEmail()%>" required="required">
							</div>


							<div class="form-group">
								<input type="text" name="userName" id="email"
									class="form-control input-sm" placeholder="User Name"
									value="<%=landLord.getLandLordProfile().getUserName()%>" readonly="readonly" required="required">
							</div>


							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password" id="password"
											class="form-control input-sm" placeholder="Password"
											value="<%=landLord.getLandLordProfile().getPassword()%>" required="required">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											id="password_confirmation" class="form-control input-sm"
											placeholder="Confirm Password"
											value="<%=landLord.getLandLordProfile().getPassword()%>" required="required">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input type="text" name="address" id="email"
									class="form-control input-sm" placeholder="Address/ Home town"
									value="<%=landLord.getAddress()%>" required="required">
							</div>




							<div class="form-group">
								<input type="tel" name="contactNo1" id="email"
									class="form-control input-sm" placeholder="Contact No1:" value="<%=contact1%>" >
							</div>

							<div class="form-group">
								<input type="tel" name="contactNo2" id="email"
									class="form-control input-sm" placeholder="Contact No2:" value="<%=contact2%>">
							</div>

							<input type="submit" value="Register"
								class="btn btn-info btn-block" onclick="return Validate()">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("password_confirmation").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
	
</body>
</html>