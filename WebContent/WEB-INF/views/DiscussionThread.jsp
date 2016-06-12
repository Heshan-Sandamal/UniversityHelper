<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>My Resume a Personal Category Flat Bootstrap Responsive
	Website Template | Home :: w3layouts</title>
<!--mobile apps-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="My Resume Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 







</script>
<!--mobile apps-->
<!--Custom Theme files-->
<link href="resources/css/bootstrap.css" type="text/css"
	rel="stylesheet" media="all">
<link href="resources/css/styleStudentProfile.css" type="text/css"
	rel="stylesheet" media="all">
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
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			//event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!--//end-smooth-scrolling-->
</head>
<body>
	<!--banner-->


	<!--//banner-->
	<!--top-nav-->
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
						<li><a href="SearchApartment" class="scroll">Search
								Apartment</a></li>
						<li><a href="#work" class="scroll">Discussion Thread</a></li>
						<li><a href="#education" class="scroll">Student Details</a></li>
						<li><a href="#skills" class="scroll">Update Details</a></li>
						<li><a href="#projects" class="scroll">Settings</a></li>
						<li><a href="ApartmentLogOut" class="scroll">Log out</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--//top-nav-->


	<%@ page import="com.universityHelper.models.Post"%>
	<%@ page import="java.util.ArrayList"%>

	<%
		ArrayList<Post> postList = (ArrayList<Post>) request.getAttribute("postList");
	%>


	<hr>
	<div class="col-sm-2"></div>
	<!--center-->
	<div class="col-sm-6">

		<%
			for (Post post : postList) {
		%>
		<div class="row">
			<div class="col-xs-12">
				<form action="ViewPostDetails" method="post">
					<a href="" onclick="parentNode.submit();return false;"><h2><%=post.getTopic()%></h2></a>
					<h6>
						by <a href="#"><%=post.getStudent().getStudentProfile().getUserName()%></a>
					</h6>
					<p><%=post.getContent()%></p>
					<p class="lead">

						<input type="hidden" name="postId" value="<%=post.getId()%>">
						<button class="btn btn-default">view More</button>
				</form>
				</p>
				<p class="pull-right">
					<span class="label label-default">keyword</span> <span
						class="label label-default">tag</span> <span
						class="label label-default">post</span>
				</p>
				<ul class="list-inline">
					<li><a href="#"><%=post.getDateTime().toString()%></a></li>
					<li><a href="#"><i class="glyphicon glyphicon-comment"></i>
							<%=post.getComments().size()%> Comments</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-share"></i>
							14 Shares</a></li>
				</ul>
			</div>
		</div>
		<hr>
		<%
			}
		%>

		<div class="row">
			<div class="col-xs-12">
				<h2>Article Heading</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis
					pharetra varius quam sit amet vulputate. Quisque mauris augue,
					molestie tincidunt condimentum vitae, gravida a libero. Aenean sit
					amet felis dolor, in sagittis nisi. Sed ac orci quis tortor
					imperdiet venenatis. Duis elementum auctor accumsan. Aliquam in
					felis sit amet augue.</p>
				<p class="lead">
					<button class="btn btn-default">Read More</button>
				</p>
				<p class="pull-right">
					<span class="label label-default">keyword</span> <span
						class="label label-default">tag</span> <span
						class="label label-default">post</span>
				</p>
				<ul class="list-inline">
					<li><a href="#">4 Days Ago</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-comment"></i>
							7 Comments</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-share"></i>
							56 Shares</a></li>
				</ul>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-xs-12">
				<h2>Article Heading</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis
					pharetra varius quam sit amet vulputate. Quisque mauris augue,
					molestie tincidunt condimentum vitae, gravida a libero. Aenean sit
					amet felis dolor, in sagittis nisi. Sed ac orci quis tortor
					imperdiet venenatis. Duis elementum auctor accumsan. Aliquam in
					felis sit amet augue.</p>
				<p class="lead">
					<button class="btn btn-default">Read More</button>
				</p>
				<p class="pull-right">
					<span class="label label-default">keyword</span> <span
						class="label label-default">tag</span> <span
						class="label label-default">post</span>
				</p>
				<ul class="list-inline">
					<li><a href="#">1 Week Ago</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-comment"></i>
							4 Comments</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-share"></i>
							34 Shares</a></li>
				</ul>
			</div>
		</div>
		<hr>
	</div>
	<!--/center-->


	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>