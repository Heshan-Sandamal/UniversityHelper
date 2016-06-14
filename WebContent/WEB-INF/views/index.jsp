<!DOCTYPE html>
<html lang="en">
<head>
  <title>University Helper</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">  
  <link rel="stylesheet" href="resources/css/animate.css">
   <link rel="stylesheet" href="resources/css/style.css">
    
    <script src="resources/js/jquery-1.9.1.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
   
    <script src="resources/js/jquery.flexisel.js"></script>
    <script src="resources/js/jquery.lettering-0.6.1.min.js"></script>
    <script src="resources/js/jquery.textillate.js"></script>
    
</head>
<body style="background-image:url('resources/images/photodune-3517559-idea-s.jpg');">

<div class="container-fluid">
    <div class="page-header">
      <h1  class="tlt">Welcome to the University Helper</h1>
      <p  class="tlt2">This is an application for finding apartments for university students and building a network among them</p> 
    </div>
    
   <div class="page-content">
        <div  class="jumbotron">
             <div class="row" style="padding:0px 20px;">
                <div class="col-sm-6">
                    <ul style="list-style: none;padding:0;margin:0;"><h2><li style="background: url('resources/images/landlord.png') no-repeat left top; padding:  10px 100px;height:  65px;">Apartment owner</li></h2></ul>
                    <p>who owns students' apartments</p>
                    <p style="font-size:.9em;"><b>This is a great platform for all of the the apartment owners who are looking for university students for their apartments. This provides an easier and attractive way to display your apartment details and provide access from all over the world. </b> </p>
                    <a href="LLLogIn"><button type="button" class="btn btn-primary btn-lg">Log In as apartment owner</button></a>
                    <p style="font-size:100%">
                        <a href="LandLordSignUp">Not yet registered as apartment owner.Then sign up</a>
                    </p>
                </div>
                 
                <div class="col-sm-6" style="padding:0px 20px;"> 
                    <ul style="list-style: none;padding:0;margin:0;"><h2><li style="background: url('resources/images/Studentsicon.png') no-repeat left top; padding:  10px 65px;height:  65px;">Student</li></h2></ul>
                    <p>University student of Sri Lanka</p>
                    <p style="font-size:.9em;"><b>This application provides two main services which are buidling a network among university students and finding an apartment nearby their university. There are so many features built in this application for the convinience of student.</b> </p>
                    <a href="StudentLogIn"><button type="button" class="btn btn-success btn-lg">Log In as Student</button></a>
                    <p style="font-size:100%">
                        <a href="StudentSignUp">Not yet registered as a student.Then sign up</a>
                    </p>
                 </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12"  style="border-bottom: 1px solid #eee;"> 
             <ul id="flexiselDemo1">
			<li><img src="resources/images/200px-Logo-SUSL.png" /><div class="grid-flex"></div></li>
			<li><img src="resources/images/crest.png" /><div class="grid-flex"></div></li>
			<li><img src="resources/images/download%20(1).png" /><div class="grid-flex"></div></li>
			<li><img src="resources/images/download.png" /><div class="grid-flex"></div></li>
			<li><img src="resources/images/images%20(1).png" /><div class="grid-flex"></div></li>
			<li><img src="resources/images/images.png" /><div class="grid-flex"></div></li>
			<li><img src="resources/images/usjp-logo1.png" /><div class="grid-flex"></div></li>
			<li><img src="resources/images/uva.png" /><div class="grid-flex"></div></li>
		 </ul>
	    <script type="text/javascript">
		 $(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 7,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	   </script>
	
        </div>
        
        <div class="col-sm-4"></div>
    </div>
</div>
<script>
	$('.tlt').textillate({initialDelay:1000});
	$('.tlt2').textillate({initialDelay:1200,out:{effect:'shake'}});
	//$('.tlt2').textillate({initialDelay:1200,loop:true,out:{effect:'shake'}});
	</script>
</body>
</html>