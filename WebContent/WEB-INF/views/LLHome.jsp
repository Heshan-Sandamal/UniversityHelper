<!DOCTYPE html>
<%@page import="com.universityHelper.models.LandLord"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Apartment Owner Home</title>

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

	<%@ page import="com.universityHelper.models.Apartment"%>
	<%
		LandLord landLord = (LandLord) request.getAttribute("landLord");
	%>


	<div class="page-header"
		style="background:url(resources/uploads/landLord/<%=landLord.getLandLordId()%>/cover/img1.jpg) no-repeat center 0px; margin: 0;">
		<div class="row">
			<div class="col-md-2">
				<img
					src="resources/uploads/landLord/<%=landLord.getLandLordId()%>/profile/img1.jpg"
					class="img-responsive" alt="Responsive image"
					style="margin: 5px; height: 190px; border: 4px solid white; padding: 5px;">
				<a href="AddLandLordImage">Update profile pic</a>
			</div>
			<div class="col-md-8" style="color: white;">
				<h1><%=landLord.getFirstName()%>
					<%=landLord.getLastName()%></h1>
				<h5><%=landLord.getAddress()%></h5>
				<h5>0117445355</h5>


			</div>
		</div>
		<a href="AddLandLordCover">Update cover pic</a>
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

		<div class="row">

			<div class="col-md-4">
				.
				<div class="card" z-default=30 z-hover=40 height="50px">
					<div class="row">
						<div class="col-md-3">
							<img src="resources/images/commentNotification.png" height="50px">
						</div>
						<div class="col-md-7">
							<h5>Notification about post 1</h5>
						</div>
						<div class="col-md-2">
							<img src="resources/images/accepted.png" height="35px"
								width="30px">

						</div>



					</div>

				</div>

			</div>
			<div class="col-md-4">
				.
				<div class="card" z-default=30 z-hover=40 height="50px">
					<div class="row">
						<div class="col-md-3">
							<img src="resources/images/commentNotification.png" height="50px">
						</div>
						<div class="col-md-7">
							<h5>Notification about post 1</h5>
						</div>
						<div class="col-md-2">
							<img src="resources/images/accepted.png" height="35px"
								width="30px">

						</div>



					</div>

				</div>

			</div>
			<div class="col-md-4">
				.
				<div class="card" z-default=30 z-hover=40 height="50px">
					<div class="row">
						<div class="col-md-3">
							<img src="resources/images/commentNotification.png" height="50px">
						</div>
						<div class="col-md-7">
							<h5>Notification about post 1</h5>
						</div>
						<div class="col-md-2">
							<img src="resources/images/accepted.png" height="35px"
								width="30px">

						</div>



					</div>

				</div>

			</div>

		</div>


		<hr>
		<div class="row">
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="com.universityHelper.models.Apartment"%>
			<%
				ArrayList<Apartment> aptList = new ArrayList(landLord.getApartmentList());
			%>

			<%
				int index = 0;
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
							<div class="row">
								<div class="col-md-5">
									<form action="ApartmentSubscribers" method="get">
										<input type="hidden" name="ApartmentKey"
											value="<%=apt.getApartmentKey()%>">
										<button class="btn btn-info btn-sm" type="submit">
											Subscribers</a>
										</button>
									</form>
								</div>
								<div class="col-md-4">
									<form action="UpdateApartment" method="get">
										<input type="hidden" name="ApartmentId"
											value="<%=apt.getApartmentKey()%>">
										<button class="btn btn-warning btn-sm" type="submit">
											Update</a>
										</button>
									</form>
								</div>
								<div class="col-md-3">
									<button class="btn btn-danger btn-sm" type="button"
										data-toggle="modal" data-target="#myModal<%=index%>">Delete
									</button>


									<div class="modal fade" id="myModal<%=index%>" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<form action="DeleteApartment" method="post">
													<input type="hidden" name="ApartmentId"
														value="<%=apt.getApartmentKey()%>">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<div class="row">
															<div class="col-md-3">
																<img src="resources/images/logout-button-hi.png">
															</div>
															<div class="" col-md-9>
																<h3 class="modal-title">Are you sure to Delete this
																	apartment??</h3>
															</div>
														</div>
													</div>
													<div class="modal-body">
														<h5>Enter UserName:</h5>
														<input type="text" name="userName" id="email"
															class="form-control input-sm" placeholder="User Name">
														<h5>Enter password:</h5>
														<input type="password" name="password"
															class="form-control input-sm" placeholder="Password">
													</div>
													<div class="modal-footer">

														<button class="btn btn-warning btn-lg" type="submit">Yes</button>
														<button type="button" class="btn btn-default btn-lg"
															data-dismiss="modal">No</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-5">
									<form action="AddApartmentImages" method="get">
										<input type="hidden" name="ApartmentId"
											value="<%=apt.getApartmentKey()%>"> <input
											type="hidden" name="name" value="<%=apt.getName()%>">
										<input type="hidden" name="address"
											value="<%=apt.getAddress()%>">
										<button class="btn btn-primary btn-sm" type="submit">Add
											Images</button>
									</form>

								</div>
								<div class="col-md-5"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%
				index++;
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