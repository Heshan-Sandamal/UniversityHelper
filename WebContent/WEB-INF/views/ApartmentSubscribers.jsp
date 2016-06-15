<%@page import="com.universityHelper.models.Apartment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<link href="resources/css/bootstrap.css" type="text/css"
	rel="stylesheet" media="all">
<link href="resources/css/styleStudentProfile.css" type="text/css"
	rel="stylesheet" media="all">


<link rel="stylesheet" href="resources/css/materialDesignBlogCard.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apartment Subscribers</title>
</head>
<body>
	<div class="top-nav wow">
		<div class="container">
			<div class="navbar-header logo">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					Menu</button>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<div class="menu">
					<ul class="nav navbar">
						<li><a href="LLHome" class="scroll">Home</b>
								</li>
						<li><a href="SearchApartment" class="scroll">Search
								Apartment</a></li>
						<li><a href="AddApartment" class="scroll">Add Apartment</a></li>
						<li><a href="#MyApartments" id="nav" class="scroll">My
								Apartments</a></li>
						<li><a href="UpdateLandLordDetails" class="scroll">Update
								Details</a></li>
						<li><a href="" class="scroll" data-toggle="modal"
							data-target="#myModalLogOut">Log out</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">



		<%@ page import="com.universityHelper.models.Student"%>
		<%@ page import="java.util.ArrayList"%>

		<%
			ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");
			int i = 0;
		%>
		<hr>
		<h2>
			All Subscribed Apartments

			<div class="row">

				<%
					for (Student student : studentList) {
				%>
				<div class="col-md-3 col-xs-12">
					<div class="wrapper">

						<div class="card radius shadowDepth1">
							<div class="card__image border-tlr-radius">
								<img
									src="resources/uploads/student/<%=student.getStudentId()%>/profile/img1.jpg"
									height="230px" alt="image" class="border-tlr-radius">
							</div>

							<div class="card__content card__padding">
								<div class="card__share">
									<div class="card__social"></div>

									<a id="share" class="share-toggle share-icon" href="#"></a>
								</div>

								<div class="card__meta">
									<form action="ViewApartmentDetails" method="post">
										<input type="hidden" name="apartmentKey"
											value="<%=student.getStudentId()%>"> <a href="#"><h4
												style="font-family: Roboto; line-height: 1.6;"><%=student.getFirstName()%>
												<%=student.getLastName()%></h4></a>
									</form>
									<h5 style="font-family: Roboto; line-height: 1.6;">
										<%=student.getCourse().getName()%>
										@
										<%=student.getCourse().getUniversity().getName()%>


									</h5>
								</div>

								<article class="card__article">
								<h6>
									address:
									<%=student.getHomeTown()%>
								</h6>

								<h6>
									contact:
									<%=student.getContactNo()%>
								</h6>
								</article>
							</div>

						</div>
					</div>
				</div>
				<%
					}
				%>

			</div>
	</div>
	<div class="modal fade" id="myModalLogOut" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form action="ApartmentLogOut" method="get">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<div class="row">
							<div class="col-md-3">
								<img src="resources/images/logout-button-hi.png">
							</div>
							<div class="" col-md-9>
								<h3 class="modal-title">Are you sure to Log out??</h3>
							</div>
						</div>
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
</body>
<script type="text/javascript">
	$(document).ready(function($) {

		$('.card__share > a').on('click', function(e) {
			e.preventDefault() // prevent default action - hash doesn't appear in url
			$(this).parent().find('div').toggleClass('card__social--active');
			$(this).toggleClass('share-expanded');
		});

	});
</script>
</html>