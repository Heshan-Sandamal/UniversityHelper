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


	<div id="about" class="about" style="padding-top: 20px;">
		<div class="container" style="padding-top: 20px;">
			<h3 class="title">About Me</h3>
			<div class="col-md-8 about-left">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Suspendisse laoreet sem sit amet dolor luctus pellentesque.
					Pellentesque eleifend tellus at interdum elementum. Nam egestas
					molestie elit. Vivamus sed accumsan quam, a mollis magna. Nam
					aliquet eros eget sapien consequat tincidunt at vel nibh. Duis ut
					turpis mi. Duis nec scelerisque urna, sit amet varius arcu. Aliquam
					aliquet sapien quis mauris semper suscipit. Maecenas pharetra
					dapibus posuere. Praesent odio sem, varius quis dolor vel, maximus
					dapibus mi. Pellentesque mattis mauris neque. Nam aliquam turpis
					ante, at cursus massa ullamcorper ut. Proin id diam id nisi
					sagittis pellentesque sed sit amet eros. In porttitor tempus nulla,
					a porta purus commodo sed. Praesent hendrerit nisi nunc, ut
					porttitor justo pellentesque et ac gravida sem mattis. Donec ornare
					justo nec</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Suspendisse laoreet sem sit amet dolor luctus pellentesque Nam
					egestas molestie elit. Vivamus sed accumsan quam, a mollis magna.
					Nam aliquet eros eget sapien consequat</p>
			</div>
			<div class="col-md-4 about-right">
				<ul>
					<h5>Awards</h5>
					<li><span class="glyphicon glyphicon-menu-right"></span> Lorem
						ipsum dolor sit amet cingelit</li>
					<li><span class="glyphicon glyphicon-menu-right"></span>
						Curabitur id metus rutrum convallis</li>
					<li><span class="glyphicon glyphicon-menu-right"></span> Morbi
						dictum velit vitae porttitor</li>
					<li><span class="glyphicon glyphicon-menu-right"></span> Fusce
						at metus id justo ullamcorper</li>
					<li><span class="glyphicon glyphicon-menu-right"></span>
						Aliquam ac nisl id justo malesuada</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<div class="container-fluid">
		<h3 class="title"> My Other Apartments</h3>
		<hr>
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
										type="hidden" name="name" value="<%=apt.getName()%>">
									<input type="hidden" name="address"
										value="<%=apt.getAddress()%>">
									<button class="btn btn-info btn-sm" type="submit">Add
										Images</button>
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
	<script src="resources/js/card-depth.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>