<html>
<head>
<link rel="stylesheet" href="resources/css/logInStyle.css">        
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">   
<link rel="stylesheet" href="resources/css/bootstrap.css">   
<script src="resources/js/jquery-1.9.1.min.js"></script>

</head>

<body style="background: url('resources/images//homeOwner.jpg') no-repeat center center fixed; background-size:100%;-webkit-background-size:100%;">
 
<div class="container"> 
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
        <form method="post" action="LLLogIn" role="login">
            <div class="row">
                 <h2>Apartment owner Sign In</h2>
            </div>
             
          <img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />
           
          <input type="text" name="userName" required class="form-control input-lg" value="HS" />
          
          <input type="password" name="password" class="form-control input-lg" id="password" placeholder="121212" required="" />
          
          <span>
          	<ul>
      			
      				<% if(request.getAttribute("error")!=null){ %>
        	 
        	 			<li><%= request.getAttribute("error")%></li>
        	 
         			<% } %>
      			
          	</ul>
          </span>
         
          
          
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
          <div>
            <a href="#">Create account</a> or <a href="#">Remember password</a>
          </div>
          
        </form>
        
        <div class="form-links">
          <a href="#">www.website.com</a>
        </div>
      </section>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
  
  <p>
    <a href="http://validator.w3.org/check?uri=http%3A%2F%2Fbootsnipp.com%2Fiframe%2FW00op" target="_blank"><small>HTML</small><sup>5</sup></a>
    <br>
    <br>
    
  </p>     
  
  
</div>
<script>$('#messages').text("password oe");</script>
</body>
</html>