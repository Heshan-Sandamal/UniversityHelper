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
			<div class="col-lg-10">
				<div class="card" z-default=30 z-hover=40 height="200px">
					<!-- Blog Post -->


					<%@ page import="com.universityHelper.models.Post"%>
					<%
						Post post = (Post) request.getAttribute("post");
					%>

					<!-- Title -->
					<h1><%=post.getTopic()%></h1>




					<!-- Author -->
					<form action="ViewStudentProfile" method="get" id="my_form">
						<input type="hidden" name="userName"
							value="<%=post.getStudent().getStudentProfile().getUserName()%>">
						<p class="lead">
							by <a href="javascript:{}"
								onclick="document.getElementById('my_form').submit();return false;"><%=post.getStudent().getStudentProfile().getUserName()%></a>
						</p>
					</form>
					<hr>

					<!-- Date/Time -->
					<p>
						<span class="glyphicon glyphicon-time"></span> Posted on
						<%=post.getDateTime()%></p>

					<hr>
					<!-- Blog Comments -->

					<!-- Post Content -->
					<p><%=post.getContent()%></p>

					<hr>


					<%@ page import="com.universityHelper.models.Comment"%>
					<%@ page import="java.util.Collection"%>

					<%
						Collection<Comment> acmList = (Collection<Comment>) post.getComments();
					%>

					<p><%=acmList.size()%>
						Comments
					</p>

					<div class="well">
						<h4>Leave a Comment:</h4>
						<form role="form" action="AddPostComments" method="post">
							<div class="form-group">
								<textarea class="form-control" rows="3" name="comment"></textarea>
							</div>
							<input type="hidden" name="studentId"
								value="<%=request.getSession().getAttribute("StudentId")%>">
							<input type="hidden" name="postId" value="<%=post.getId()%>">

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>


					<!-- Posted Comments -->

					<!-- Comment -->

					<%
						for (Comment acm : acmList) {
					%>
					<div class="media">
						<a class="pull-left" href="#"> <img class="media-object"
							src="resources/uploads/student/<%=acm.getStudent().getStudentId()%>/profile/img1.jpg"
							alt="" height="64ppx" width="64px">
						</a>
						<div class="media-body">
							<h4 class="media-heading">
								<form action="ViewStudentProfile" method="get" id="my_form1">
									<input type="hidden" name="userName"
										value="<%=acm.getStudent().getStudentProfile().getUserName()%>">

									<a href="javascript:{}"
										onclick="document.getElementById('my_form1').submit();return false;"><%=acm.getStudent().getStudentProfile().getUserName()%></a>

								</form>
								<small><%=acm.getTimeStamp().toString()%></small>
							</h4>



							<p><%=acm.getContent()%></p>
							<form action="ViewPostDetails" method="post">
								<%
									if (request.getSession().getAttribute("StudentId").toString().equals(acm.getStudent().getStudentId())
												|| request.getSession().getAttribute("StudentId").toString()
														.equals(acm.getPost().getStudent().getStudentId())) {
								%>
								<input type="hidden" name="commentId" value="<%=acm.getId()%>">
								<input type="hidden" name="postId" value="<%=post.getId()%>">
								<a href="" onclick="parentNode.submit();return false;"><p style="font-size: 11px;">delete</p></a>

								<%
									}
								%>
							</form>
						</div>

					</div>
					<hr>
					<%
						}
					%>


					<!-- Comment -->
					<!-- Comments Form -->
				</div>
				<hr>

			</div>
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
		<script src="resources/js/card-depth.js"></script>
</body>

</html>
