<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>View Student Profile</title>
<!--mobile apps-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="My Resume Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--mobile apps-->
<!--Custom Theme files-->
<link href="resources/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="resources/css/styleStudentProfile.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="resources/css/swipebox.css">
<!--//Custom Theme files-->
<!--js-->
<script src="resources/js/jquery-1.11.1.min.js"></script> 
<!-- //js -->
<!--web-fonts-->
<link href='//fonts.googleapis.com/css?family=Overlock:400,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//web-fonts-->
<!--start-smooth-scrolling-->
<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>	
<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				//event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
</script>
<!--//end-smooth-scrolling-->
</head>
<body>
	<!--banner-->
	
	<%@ page import="com.universityHelper.models.Student"%>
	
	<% Student student=(Student)request.getAttribute("Student"); %>
	
	<div id="home" class="banner" style="background:url(resources/uploads/student/<%= student.getStudentId() %>/cover/img1.jpg)no-repeat center 0px;">
		<div class="banner-info">
			<div class="container">
				<div class="col-md-4 header-left">
					<img src="resources/uploads/student/<%= student.getStudentId() %>/profile/img1.jpg" alt=""/>
					
				</div>
				<div class="col-md-8 header-right">
					<h2>Hello</h2>
					<h1>I'm <%= student.getFirstName() %> <%= student.getLastName() %></h1>
					<h6>Study <%= student.getCourse().getName() %> at <%= student.getCourse().getUniversity() %> </h6>
					<ul class="address">
						<li>
							<ul class="address-text">
								<li><b>D.O.B</b></li>
								<li><%= student.getDob() %></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>PHONE </b></li>
								<li><%= student.getContactNo() %></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>ADDRESS </b></li>
								<li><%= student.getHomeTown() %>.</li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>Facebbok </b></li>
								<li><a href="<%=student.getFburl()%>" target="_blank"><%=student.getFburl()%></a></li>
							</ul>
						</li>
						
						
					</ul>
				</div>
				<div class="clearfix"> </div>
				
			</div>
			
		</div>
		
	</div>

	<div id="about" class="about" style="padding-top: 20px;">
		<div class="container"  style="padding-top: 20px;">
			<h3 class="title"> About Me</h3>
			<div class="col-md-12 about-left">
				<p><%=student.getAboutMe()%></p>
			</div>
			
			<div class="clearfix"> </div>
		</div>
	</div>
	
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="resources/js/bootstrap.js"></script>
</body>
</html>