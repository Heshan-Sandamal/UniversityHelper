<html>
<head>
<link rel="stylesheet" href="resources/css/signUp.css">
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
<title>Add Apartment Owner cover</title>
</head>

<body
	style="background: url('resources/images/ayside.jpg') no-repeat center center fixed; background-size: 100%; -webkit-background-size: 100%;">

	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Add images to apartment
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="AddLandLordCover" method="post" enctype="multipart/form-data">

							<div class="form-group">
								<input type="text" name="studentId" id="id"
									class="form-control input-sm" placeholder="ID" value="<%= request.getAttribute("ApartmentOwnerId") %>">
							</div>


							<div class="form-group">
								<input type="text"  id="name"
									class="form-control input-sm" placeholder="Apartment Name" value="<%= request.getAttribute("name") %>">
							</div>

							
							<div class="form-group">
								Specify file: <input name="file" type="file" id="file" multiple>
							</div>

							<input type="submit" value="Register"
								class="btn btn-info btn-block">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>