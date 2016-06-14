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
<link rel="stylesheet" href="resources/css/searchBox.css">
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
						<li><a href="StudentHome" class="scroll">Home</a></li>
						<li><a href="SearchApartment" class="scroll">Search
								Apartment</a></li>
						<li><a href="MyApartments" class="scroll">My Apartments</a></li>
						<li><a href="DiscussionThread" class="scroll">Discussion
								Thread</a></li>
						<li><a href=AddPost class="scroll">Add New post</a></li>
						<li><a href="ViewMyPosts" class="scroll"><h3>
									<b>My posts</b>
								</h3></a></li>
						<li><a href="#skills" class="scroll">My Details</a></li>
						<li><a href="ViewStudents" class="scroll">Student Details</a></li>
						<li><a href="" class="scroll" data-toggle="modal"
							data-target="#myModalLogOut">Log out</a></li>

					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--//top-nav-->

	<hr>



	<%@ page import="com.universityHelper.models.Post"%>
	<%@ page import="java.util.ArrayList"%>

	<%
		ArrayList<Post> postList = (ArrayList<Post>) request.getAttribute("postList");
		int i = 0;
	%>


	<div class="col-sm-2"></div>
	<!--center-->
	<div class="col-sm-8">
		<div id="custom-search-input">
			<div class="input-group col-md-4">
				<h4>
					<b>Search Discussion Thread</b>
				</h4>
			</div>
			<div class="input-group col-md-8">
				<input type="text" class="  search-query form-control"
					placeholder="Search" /> <span class="input-group-btn">
					<button class="btn btn-danger" type="button">
						<span class=" glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
		</div>
		<hr>
	</div>
	<div class="container-fluid">

		<div class="row">
			<%
				for (Post post : postList) {
			%>
			<div class="col-md-4 col-xs-12">
				<div class="card" z-default=30 z-hover=40 height="200px">
					<form action="ViewPostDetails" method="post">
						<a href="" onclick="parentNode.submit();return false;"><h2><%=post.getTopic()%></h2></a>
						<input type="hidden" value="<%=post.getId()%>">
					</form>
					<h6>
						by <a href="#"><%=post.getStudent().getStudentProfile().getUserName()%></a>
					</h6>
					<hr>
					<p><%=post.getContent()%></p>
					<hr>
					<div class="row">
						<div class="col-md-3">
							<input type="hidden" name="postId" value="<%=post.getId()%>">
							<form action="ViewPostDetails" method="get">
								<input type="hidden" name="postId" value="<%=post.getId()%>">
								<button class="btn btn-info">view Details</button>
							</form>
						</div>
						<div class="col-md-3">
							<form action="UpdatePost" method="get">
								<input type="hidden" name="postId" value="<%=post.getId()%>">
								<button class="btn btn-warning">update post</button>
							</form>

						</div>
						<div class="col-md-3">

							<button class="btn btn-danger" data-toggle="modal"
								data-target="#myModal">delete post</button>

						</div>



						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<form action="DeletePost" method="post">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h3 class="modal-title">Are you sure to delete this
												post??</h3>
										</div>
										<div class="modal-body"></div>

										<div class="modal-footer">
											<input type="hidden" name="postId" value="<%=post.getId()%>">
											<button class="btn btn-warning" type="submit">Yes</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">No</button>
										</div>
									</form>
								</div>

							</div>
						</div>




					</div>
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
			<%
				}
			%>
		</div>
	</div>
	<!--/center-->

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
						<button type="button" class="btn btn-default btn-lg" data-dismiss="modal">No</button>
					</div>
				</form>
			</div>

		</div>
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/card-depth.js"></script>
</body>
</html>