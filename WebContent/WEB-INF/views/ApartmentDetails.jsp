<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">  
  <link rel="stylesheet" href="resources/css/etalage.css">  
  <link rel="stylesheet" href="resources/css/star-rating.css">  
     <link rel="stylesheet" href="resources/css/animate.css">
    
<script src="resources/js/jquery-1.9.1.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
  <script src="resources/js/star-rating.js"></script>
    <script src="resources/js/jquery.lettering-0.6.1.min.js"></script>
    <script src="resources/js/jquery.textillate.js"></script>
    <script src="resources/js/jquery.flexisel.js"></script>
    <script src="resources/js/jquery.etalage.min.js"></script>
    
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
        
      }
      #map {
          
        margin:auto;
        height: 80%;
        width: 95%;
        max-width:410px; 
      }
      .controls {
        margin-top: 10px;
        border: 1px solid transparent;
        border-radius: 2px 0 0 2px;
        box-sizing: border-box;
        -moz-box-sizing: border-box;
        height: 32px;
        outline: none;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
      }

    
        
      #pac-input {
        background-color: #fff;
        font-family: Roboto;
        font-size: 15px;
        font-weight: 300;
        margin-left: 12px;
        padding: 0 11px 0 13px;
        text-overflow: ellipsis;
        width: 300px;
      }

      #pac-input:focus {
        border-color: #4d90fe;
      }

      .pac-container {
        font-family: Roboto;
      }

      #type-selector {
        color: #fff;
        background-color: #4d90fe;
        padding: 5px 11px 0px 11px;
      }

      #type-selector label {
        font-family: Roboto;
        font-size: 13px;
        font-weight: 300;
      }
      #target {
        width: 345px;
      }
    </style>
    
        
    
    <script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});

			});
		</script>
		<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>
<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
				<!-- start menu -->
<link href="resources/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="resources/js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
     
</head>
<body>

        <div class="row" style="margin-left:30px;">
            <h1 class="tlt2"><b><%=request.getAttribute("apartmentName") %></b></h1> 
        </div>
    
           <div class="col-md-8">
                <div class="col-md-5 single-top">	
						<ul id="etalage">
							<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image img-responsive" src="resources/uploads/<%= request.getAttribute("apartmentKey") %>/s1.png" alt="" >
									<img class="etalage_source_image img-responsive" src="resources/uploads/<%= request.getAttribute("apartmentKey") %>/s11.jpg" alt="" >
								</a>
							</li>
							<li>
								<img class="etalage_thumb_image img-responsive" src="resources/uploads/<%= request.getAttribute("apartmentKey") %>/s2.png" alt="" >
								<img class="etalage_source_image img-responsive" src="resources/uploads/<%= request.getAttribute("apartmentKey") %>/s12.jpg" alt="" >
							</li>
							<li>
								<img class="etalage_thumb_image img-responsive" src="resources/uploads/<%= request.getAttribute("apartmentKey") %>/s3.png" alt=""  >
								<img class="etalage_source_image img-responsive" src="resources/uploads/<%= request.getAttribute("apartmentKey") %>/s13.jpg" alt="" >
							</li>
						    <li>
								<img class="etalage_thumb_image img-responsive" src="resources/uploads/<%= request.getAttribute("apartmentKey") %>/s4.png"  alt="" >
								<img class="etalage_source_image img-responsive" src="resources/uploads/<%= request.getAttribute("apartmentKey") %>/s14.jpg" alt="" >
							</li>
						</ul>

					</div>	
                <div class="col-md-7" style="padding:0px;">
                    <table class="table table-striped">
                      
                      <tbody>
                        <tr>
                          <td>Address</td>
                          <td><%= request.getAttribute("address") %></td>
                          
                        </tr>
                          
                        <tr>
                          <td>Full places</td>
                          <td><%= request.getAttribute("availability") %></td>
                         
                        </tr>
                        <tr>
                          <td>Avilable places</td>
                          <td><%= request.getAttribute("availability") %></td>
                         
                        </tr>
                        <tr>
                          <td>Payment</td>
                          <td><%= request.getAttribute("payment") %></td>
                          
                        </tr>
                          
                        <tr>
                          <td>Distance from university</td>
                          <td>1km</td>
                          
                        </tr>
                          
                          <tr>
                          <td>Contact No:</td>
                          <td>07155252133</td>
                          
                        </tr>
                          
                          <tr>
                          <td>Other details</td>
                          <td>2000</td>
                          
                        </tr>
            
                          <tr>
                          <td>For students of:</td>
                          <td>University of Moratuwa</td>
                          
                        </tr>
                      </tbody>
                    </table>
                    <div>
                        <h4>ratings</h4>
                        <input id="input-21e" value="0" type="number" class="rating hide" min="0" max="5" step="0.5" data-size="xs" disabled>

                    </div>
                    <div>
                        <h4>Subscribe to apartment</h4>
                        <p>You wil get notifications about the future updates of this apartment</p>
                        <button type="button" class="btn btn-success btn-md">Subscribe</button>
                    </div>
                    <div style="padding-bottom: 10px;">
                        <h4>View feedbacks</h4>
                        <p>These are the comments which are given by past students</p>
                        <button type="button" class="btn btn-warning btn-md">View feedbacks</button>
                    </div>
                </div>
                
                 

            </div>
        <input id="pac-input" class="controls" type="text" placeholder="Search Box" >
      
      <div id="map">
            
    </div>
    
        
   <script>
	$('.tlt2').textillate({initialDelay:1200,loop:true,out:{effect:'pulse',delay:200},in:{effect:'pulse'}});
	</script>
    <script>
        
        $('#input-21e').val(3);
          var marker;
        var map;
        var searchBox;
    function placeMarker(location) {

            if (marker == undefined){
                marker = new google.maps.Marker({
                    position: location,
                    map: map
                });
            }
            else{
                marker.setPosition(location);
            }
            //map.setCenter(location);

        }
        
      function initAutocomplete() {
    	  var lat=Number('${lattitude}');
    	  var longitude=Number('${longitude}');

        map= new google.maps.Map(document.getElementById('map'), {
          center: {lat:lat, lng: longitude},
          zoom: 17,
          mapTypeId: google.maps.MapTypeId.SATELLITE
        });

        // Create the search box and link it to the UI element.
        var input = document.getElementById('pac-input');
        searchBox = new google.maps.places.SearchBox(input);
        map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

        // Bias the SearchBox results towards current map's viewport.
        map.addListener('bounds_changed', function() {
          searchBox.setBounds(map.getBounds());
        });

        
          
        var markers = [];
     // Clear out the old markers.
        markers.forEach(function(marker) {
          marker.setMap(null);
        });
        markers = [];

        var myCenter=new google.maps.LatLng(lat,longitude);
        

        var mk1=new google.maps.Marker({
          map: map,
          title: "places",
          position:myCenter
        });  
         
        markers.push(mk1);
        // Listen for the event fired when the user selects a prediction and retrieve
        // more details for that place.
        searchBox.addListener('places_changed', function() {
          
          var places = searchBox.getPlaces();

          if (places.length == 0) {
            return;
          }

          // Clear out the old markers.
          markers.forEach(function(marker) {
            marker.setMap(null);
          });
          markers = [];

          var myCenter=new google.maps.LatLng(lat,longitude);
          

          var mk1=new google.maps.Marker({
            map: map,
            title: "places",
            position:myCenter
          });  
           
          markers.push(mk1);

          // For each place, get the icon, name and location.
          var bounds = new google.maps.LatLngBounds();
          places.forEach(function(place) {
            var icon = {
              url: place.icon,
              size: new google.maps.Size(71, 71),
              origin: new google.maps.Point(0, 0),
              anchor: new google.maps.Point(17, 34),
              scaledSize: new google.maps.Size(17, 17)
                  
            };
              
            

            // Create a marker for each place.
            markers.push(new google.maps.Marker({
              map: map,
              icon: icon,
              title: place.name,
              position: place.geometry.location
            }));
              
            
            var myCenter=new google.maps.LatLng(lat,longitude);
   

            var mk1=new google.maps.Marker({
              map: map,
              title: "places",
              position:myCenter
            });  
             
            markers.push(mk1);
              
              
              

            if (place.geometry.viewport) {
              // Only geocodes have viewport.
              bounds.union(place.geometry.viewport);
            } else {
              bounds.extend(place.geometry.location);
            }
          });
          map.fitBounds(bounds);
            
        map.setZoom(25);
        });
      }
    </script>
     <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBvHohFe2Dm4cVd1ZP81MUmCG7S-GTGt34&libraries=places&callback=initAutocomplete"
         async defer></script>
</body>
</html>