<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap4.css" rel="stylesheet" />
<link href="resources/css/bootstrap.css rel="stylesheet">

<link rel="stylesheet" href="resources/css/swipebox.css">
<!--//Custom Theme files-->
<!--js-->
<script src="resources/js/jquery-1.11.1.min.js"></script>


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link href="resources/css/styleStudentProfile.css" type="text/css"
	rel="stylesheet" media="all">
	<link href='//fonts.googleapis.com/css?family=Overlock:400,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>
<style>
.active {
	padding-right: 3px;
}
</style>

</head>
<body>

	<div class="page-header"
		style="background-image: url('resources/images/a.jpg'); background-repeat: no-repeat; margin: 0;">
		<div class="row">
			<div class="col-md-2">
				<img src="resources/images/img1.jpg"
					class="img-responsive" alt="Responsive image"
					style="margin: 5px; height: 130px; border: 4px solid white; padding: 5px;">
			</div>
			<div class="col-md-8" style="color: white;">
				<h1>Heshan Sandamal Gunarathne</h1>
				<h5>Weedagama,Bandaragama</h5>
				<h5>0117445355</h5>


			</div>
		</div>
	</div>

	<div class="top-nav wow">
		<div class="container">
			<div class="navbar-header logo">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">Menu</button>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<div class="menu">
					<ul class="nav navbar">
						<li><a href="SearchApartment" class="scroll">Search
								Apartment</a></li>
						<li><a href="#work" class="scroll">Discussion Thread</a></li>

						<li><a href="#projects" class="scroll">Settings</a></li>
						<li><a href="ApartmentLogOut" class="scroll">Log out</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<hr>
		<div class="row">
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="com.universityHelper.models.Apartment"%>
			<%
				ArrayList<Apartment> aptList = (ArrayList<Apartment>) request.getAttribute("apartmentList");
			%>

			<%
				for (Apartment apt : aptList) {
			%>
			<div class="col-md-3 col-xs-12">
				<div class="card navbar navbar-inverse">
					<div class="card-block" style="padding-bottom: 2px;">
						<h4 class="card-title  text-muted"><%=apt.getName()%></h4>
						<h6 class="card-subtitle text-muted"><%=apt.getAddress()%></h6>

					</div>
					<hr style="margin-bottom: 8px;">
					<img src="resources/images/549008_13121012550017865074_std.png"
						class="img-responsive"
						style="margin: auto; margin-top: 0px; width: 100%; height: 150px; padding-left: 7px; padding-right: 7px;"
						alt="Card image">
					<hr style="margin-top: 8px;">
					<div class="card-block" style="padding-top: 2px;">

						<span><button class="btn btn-info btn-sm">
								<a href="#" class="card-link">Update Details</a>
							</button></span> <span style="float: left; margin-right: 10px;">
							<form action="AddApartmentImages" method="get">
								<input type="hidden" name="ApartmentId"
									value="<%=apt.getApartmentKey()%>"> <input
									type="hidden" name="name" value="<%=apt.getName()%>"> <input
									type="hidden" name="address" value="<%=apt.getAddress()%>">
								<button class="btn btn-info btn-sm" type="submit">Add
									Images</button>
							</form>
						</span>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<hr>

	</div>
	<hr>


	<div class="row">
		<div class="col-md-5">
			<p>THis is home page</p>
		</div>

	</div>

	<div class="page-footer"></div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resources/js/jquery-1.9.1.min.js"></script>
	<script src="resources/js/holder.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>