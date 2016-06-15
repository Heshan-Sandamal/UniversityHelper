<!DOCTYPE html>
<%@page import="com.universityHelper.models.ApartmentComment"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>View Post Details</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" type="text/css"
	rel="stylesheet" media="all">
<link href="resources/css/styleStudentProfile.css" type="text/css"
	rel="stylesheet" media="all">
<!-- Custom CSS -->
<link href="resources/css/blog-post.css" rel="stylesheet">

<link rel="stylesheet" href="resources/css/swipebox.css">
<!--//Custom Theme files-->
<!--js-->
<script src="resources/js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!--web-fonts-->
<link
	href='//fonts.googleapis.com/css?family=Overlock:400,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<!--//web-fonts-->
<!--start-smooth-scrolling-->
<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>


<body style="padding-top: 0px;">
	<!-- Page Content -->
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
						<li><a href="StudentHome" class="scroll">Home</a></li>
						<li><a href="SearchApartment" class="scroll">Search
								Apartment</a></li>
						<li><a href="MyApartments" class="scroll">My Apartments</a></li>
						<li><a href="DiscussionThread" class="scroll">
									Discussion Thread</a></li>
						<li><a href=AddPost class="scroll">Add New post</a></li>
						<li><a href="ViewMyPosts" class="scroll">My posts</a></li>
						<li><a href="UpdateStudentDetails" class="scroll">Update
								Details</a></li>
						<li><a href="ViewStudents" class="scroll">Student Details</a></li>
						<li><a href="" class="scroll" data-toggle="modal"
							data-target="#myModalLogOut">Log out</a></li>

					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">

		<div class="row">

			<!-- Blog Post Content Column -->
			<div class="col-lg-1"></div>
			<div class="col-lg-10" style="background-color: white;">
				<div class="card" z-default=80 z-hover=120 height="200px">
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
								<a href="" onclick="parentNode.submit();return false;"><p
										style="font-size: 11px;">delete</p></a>

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

		</div>
		<!-- /.container -->
	</div>
	<!-- jQuery -->
	<script src="resources/js/jquery-1.9.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/card-depth.js"></script>
</body>

</html>
