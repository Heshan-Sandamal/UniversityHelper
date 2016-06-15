<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Apartment Owner Profile</title>

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
<link
	href='//fonts.googleapis.com/css?family=Overlock:400,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>
<style>
.active {
	padding-right: 3px;
}
</style>

</head>
<body>


	<%@ page import="com.universityHelper.models.LandLord"%>

	<%
		LandLord landLord = (LandLord) request.getAttribute("landLord");
	%>

	<div id="home" class="banner"
		style="background:url(resources/uploads/landLord/<%=landLord.getLandLordId()%>/cover/img1.jpg)no-repeat center 0px;">
		<div class="banner-info">
			<div class="container">
				<div class="col-md-4 header-left">
					<img
						src="resources/uploads/landLord/<%=landLord.getLandLordId()%>/profile/img1.jpg"
						alt="" />

				</div>
				<div class="col-md-8 header-right">
					<h2>Hello</h2>
					<h1>
						I'm
						<%=landLord.getFirstName()%>
						<%=landLord.getLastName()%></h1>
					<h6>I have best apartments for the university students</h6>
					<ul class="address">
						<li>
							<ul class="address-text">
								<li><b>email</b></li>
								<li><%=landLord.getEmail()%></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>PHONE </b></li>
								<li></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>ADDRESS </b></li>
								<li><%=landLord.getAddress()%>.</li>
							</ul>
						</li>


					</ul>
				</div>
				<div class="clearfix"></div>

			</div>

		</div>

	</div>



	<div class="container-fluid">
		<h3 class="title">My Other Apartments</h3>
		<div class="row">
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="com.universityHelper.models.Apartment"%>
			<%
				ArrayList<Apartment> aptList = new ArrayList(landLord.getApartmentList());
			%>

			<%
				for (Apartment apt : aptList) {
			%>
			<div class="col-md-4 col-xs-12">
				<div class="card" z-default=30 z-hover=80 height="200px"padding:"2px">
					<div class="card navbar navbar-inverse" style="margin: 10px;">
						<div class="card-block" style="padding-bottom: 2px;">
							<h4 class="card-title  text-muted"><%=apt.getName()%></h4>
							<h6 class="card-subtitle text-muted"><%=apt.getAddress()%></h6>

						</div>
						<hr style="margin-bottom: 8px;">
						<img src="resources/uploads/apartment/<%=apt.getApartmentKey()%>/img0.jpg"
							class="img-responsive"
							style="margin: auto; margin-top: 0px; width: 100%; height: 150px; padding-left: 7px; padding-right: 7px;"
							alt="Card image">
						<hr style="margin-top: 8px;">
						<div class="card-block" style="padding-top: 2px;">

							<span>
								<form action="ViewApartmentDetails" method="post">
									<button type="submit" class="btn btn-info btn-md">
										View Details</button>
									<input type="hidden" name="apartmentKey"
										value="<%=apt.getApartmentKey()%>">
							</span> <span style="float: left; margin-right: 10px;">
								</form>
							</span>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>

	</div>
	<div id="about" class="about" style="padding-top: 20px;">
		<div class="container" style="padding-top: 20px;">
			<h3 class="title">About Me</h3>
			<div class="col-md-12 about-left">
				<p><%=landLord.getAboutMe()%></p>
			</div>
			
			<div class="clearfix"></div>
		</div>
	</div>

	

	<div class="page-footer"></div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resources/js/jquery-1.9.1.min.js"></script>
	<script src="resources/js/holder.js"></script>
	<script src="resources/js/card-depth.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>