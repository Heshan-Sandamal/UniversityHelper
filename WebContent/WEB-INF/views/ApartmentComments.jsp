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

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="SearchApartment">Search Apartment</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">About</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<!-- Blog Post Content Column -->
			<div class="col-lg-8">

				<!-- Blog Post -->

				<!-- Title -->
				<h1><%= request.getParameter("apartmentName")%></h1>

				<!-- Author -->
				<p class="lead">
					 <a href="#"><%= request.getParameter("address")%></a>
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
				<div class="media">
					<a class="pull-left" href="#"> <img class="media-object"
						src="resources/uploads/student/<%=acm.getStudent().getStudentId()%>/profile/img1.jpg" alt="" height="64px" width="64px" alt="" >
					</a>
					<div class="media-body">
						<h4 class="media-heading">
							<%=acm.getStudent().getStudentProfile().getUserName()%>
							<small><%=acm.getDateAndTime().toString()%></small>
						</h4>
						<%=acm.getDescription()%>
					</div>
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
						<input type="hidden" name="apartmentKey" value="<%= request.getParameter("apartmentKey")%>">
						<input type="hidden" name="apartmentName" value="<%= request.getParameter("apartmentName")%>">
						<input type="hidden" name="address" value="<%= request.getParameter("address")%>">
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>

				<hr>

			</div>

			<!-- Blog Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Blog Search Well -->
				<div class="well">
					<h4>Blog Search</h4>
					<div class="input-group">
						<input type="text" class="form-control"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
					<!-- /.input-group -->
				</div>

				<!-- Blog Categories Well -->
				<div class="well">
					<h4>Blog Categories</h4>
					<div class="row">
						<div class="col-lg-6">
							<ul class="list-unstyled">
								<li><a href="#">Category Name</a></li>
								<li><a href="#">Category Name</a></li>
								<li><a href="#">Category Name</a></li>
								<li><a href="#">Category Name</a></li>
							</ul>
						</div>
						<div class="col-lg-6">
							<ul class="list-unstyled">
								<li><a href="#">Category Name</a></li>
								<li><a href="#">Category Name</a></li>
								<li><a href="#">Category Name</a></li>
								<li><a href="#">Category Name</a></li>
							</ul>
						</div>
					</div>
					<!-- /.row -->
				</div>

				<!-- Side Widget Well -->
				<div class="well">
					<h4>Side Widget Well</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Inventore, perspiciatis adipisci accusamus laudantium odit aliquam
						repellat tempore quos aspernatur vero.</p>
				</div>

			</div>

		</div>
		<!-- /.row -->

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
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

</body>

</html>
