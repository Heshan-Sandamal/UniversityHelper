<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Post</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/blog-post.css" rel="stylesheet">
</head>
<body
	style="background: url('resources/images//Documenting-success.jpg') no-repeat center center fixed; background-size: 100%; -webkit-background-size: 100%;">
	<div class="container-fluid">


		<%@ page import="com.universityHelper.models.Post"%>
		<%
			Post post = (Post) request.getAttribute("post");
		%>

		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="card" z-default=30 z-hover=40 height="300px">
				<h2>Add post Details</h2>
				<div class="well">
					<form role="form" action="UpdatePost" method="post">
						<h4>Update post</h4>
						<input type="text" class="form-control" name="topic" value="<%=post.getTopic()%>">
						<h4>Post Content</h4>
						<div class="form-group">
							<textarea class="form-control" rows="3" name="content"><%=post.getContent()%></textarea>
						</div>
						<input type="hidden" class="form-control" name="postId" value="<%=post.getId()%>">
						<button type="submit" class="btn btn-success">Submit</button>
						<a href="ViewMyPosts"><button type="button"
								class="btn btn-warning">cancel</button></a>
					</form>

				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/card-depth.js"></script>
</body>
</html>