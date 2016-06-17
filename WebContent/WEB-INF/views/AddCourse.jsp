<html>
<head>
<link rel="stylesheet" href="resources/css/logInStyle.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Student sign up</title>
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
	<%@ page import="com.universityHelper.models.University"%>
	<%
		ArrayList<University> uniList = (ArrayList<University>) request.getAttribute("universityList");
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
						<form role="form" action="AddCourse" method="post">
							

							<div class="form-group">
								<input type="text" name="courseName" id="courseName"
									class="form-control input-sm" placeholder="Course Name" required="required">
							</div>

							<!-- Single button -->
							<div class="btn-group form-group">

								<input type="text" id="pac-input" name="universityName" class="form-control input-sm" readonly="readonly" required="required">

								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									Select Course <span class="caret"></span>
								</button>
								<ul name="university" class="dropdown-menu">
									<%
										for (University university : uniList) {
									%>
									<li><a href="#"><%=university.getName()%></a></li>
									<%
										}
									%>
								</ul>
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