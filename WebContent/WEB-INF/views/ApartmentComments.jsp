<!DOCTYPE html>
<%@page import="com.universityHelper.models.ApartmentComment"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Comments page</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/blog-post.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body
	style="background: url(resources/images/reducedopacity_sm_07.jpg) no-repeat center 0px;">


	<!-- Page Content -->
	<div class="container">
		<div class="row" style="margin-left: 30px;">
			<div class="col-md-8"></div>
			<div class="col-md-2">

				<a href="StudentHome"><img src="resources/images/restart-1.png">Student
					Home</a>
			</div>
			<div class="col-md-2">

				<a href="SearchApartment"><img
					src="resources/images/restart-1.png">Search Apartment</a>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-1"></div>
			<!-- Blog Post Content Column -->
			<div class="col-lg-10">
				<h1>Feedbacks for the Apartment</h1>
				<div class="card" z-default=80 z-hover=120 height="200px"
					style="background-color: white;">
					<!-- Blog Post -->

					<!-- Title -->
					<h1><%=request.getParameter("apartmentName")%></h1>

					<!-- Author -->
					<p class="lead">
						<a href="#"><%=request.getParameter("address")%></a>
					</p>

					<hr>

					<!-- Blog Comments -->



					<%@ page import="com.universityHelper.models.ApartmentComment"%>
					<%@ page import="java.util.ArrayList"%>

					<%
						ArrayList<ApartmentComment> acmList = (ArrayList<ApartmentComment>) request.getAttribute("commentsList");
					%>

					<!-- Posted Comments -->

					<!-- Comment -->

					<%
						for (ApartmentComment acm : acmList) {
					%>
					<div class="media"">
						<a class="pull-left" href="#"> <img class="media-object"
							src="resources/uploads/student/<%=acm.getStudent().getStudentId()%>/profile/img1.jpg"
							alt="" height="64px" width="64px" alt="">
						</a>
						<div class="media-body">
							<h4 class="media-heading">
								<%=acm.getStudent().getStudentProfile().getUserName()%>
								<small><%=acm.getDateAndTime().toString()%></small>
							</h4>
							<%=acm.getDescription()%>
						</div>
						<form action="ViewApartmentComments" method="post">
							<%
								if (request.getSession().getAttribute("StudentId") !=null && request.getSession().getAttribute("StudentId").toString().equals(acm.getStudent().getStudentId())) {
							%>
							<input type="hidden" name="commentId" value="<%=acm.getId()%>">
							<input type="hidden" name="apartmentKey" value="<%=request.getParameter("apartmentKey")%>">
							<input type="hidden" name="apartmentName" value="<%=request.getParameter("apartmentName")%>">
							<input type="hidden" name="address" value="<%=request.getParameter("address")%>">
							<a href="" onclick="parentNode.submit();return false;"><p
									style="font-size: 11px;">delete</p></a>

							<%
								}
							%>
						</form>
					</div>
					<hr>
					<%
						}
					%>


					<!-- Comment -->
					<!-- Comments Form -->
					<div class="well">
						<h4>Leave a Comment:</h4>
						<form role="form" action="AddApartmentComments" method="post">
							<div class="form-group">
								<textarea class="form-control" rows="3" name="comment"></textarea>
							</div>
							<input type="hidden" name="apartmentKey"
								value="<%=request.getParameter("apartmentKey")%>"> <input
								type="hidden" name="apartmentName"
								value="<%=request.getParameter("apartmentName")%>"> <input
								type="hidden" name="address"
								value="<%=request.getParameter("address")%>">
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>

					<hr>

				</div>


			</div>
		</div>
	</div>
	<!-- /.row -->

	<hr>

	<!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; HS-Solutions</p>
			</div>
		</div>
		<!-- /.row -->
	</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="resources/js/jquery-1.9.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/card-depth.js"></script>
</body>

</html>
