
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Places Searchbox</title>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	height: 100%;
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
</head>
<body>

	<div class="container">
	<h1 style="text-align: left;">Find an apartment near to the university</h1>
		<div class="row">			
			<div id="combo" class="btn-group controls">
				<a style="width: 250px;"
					class="btn btn-default dropdown-toggle btn-select"
					data-toggle="dropdown" href="#">Select a University <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<%@ page import="java.util.ArrayList"%>

					<%
						ArrayList<String> uniList = (ArrayList<String>) request.getAttribute("UniversityList");
					%>

					<%
						for (String uniName : uniList) {
					%>
					<li><a href="#"><%=uniName%></a></li>
					<%
						}
					%>
					<li class="divider"></li>
					<li><a href="#"><span class="glyphicon glyphicon-star"></span>
							Other</a></li>
				</ul>
			</div>

		</div>

	</div>


	<input id="pac-input" class="controls" type="text"
		placeholder="Search Box">

	<div id="map"></div>
	<script>
		// This example adds a search box to a map, using the Google Place Autocomplete
		// feature. People can enter geographical searches. The search box will return a
		// pick list containing a mix of places and predicted search terms.

		// This example requires the Places library. Include the libraries=places
		// parameter when you first load the API. For example:
		// <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

		function initAutocomplete() {
			var map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : 6.796557757090544,
					lng : 79.9010257422924
				},
				zoom : 11,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			});

			// Create the search box and link it to the UI element.
			var input = document.getElementById('pac-input');
			var input2 = document.getElementById('combo');

			var searchBox = new google.maps.places.SearchBox(input);
			// var searchBox = new google.maps.places.SearchBox(input2);
			map.controls[google.maps.ControlPosition.TOP_LEFT].push(input2);
			map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

			// Bias the SearchBox results towards current map's viewport.
			map.addListener('bounds_changed', function() {
				searchBox.setBounds(map.getBounds());
			});

			var markers = [];
			// Listen for the event fired when the user selects a prediction and retrieve
			// more details for that place.
			searchBox
					.addListener(
							'places_changed',
							function() {
								var places = searchBox.getPlaces();

								if (places.length == 0) {
									return;
								}

								// Clear out the old markers.
								markers.forEach(function(marker) {
									marker.setMap(null);
								});
								markers = [];

								// For each place, get the icon, name and location.
								var bounds = new google.maps.LatLngBounds();
								places
										.forEach(function(place) {
											var icon = {
												url : place.icon,
												size : new google.maps.Size(71,
														71),
												origin : new google.maps.Point(
														0, 0),
												anchor : new google.maps.Point(
														17, 34),
												scaledSize : new google.maps.Size(
														17, 17)

											};

											var val = document
													.getElementById("pac-input").value;

											$
													.get(
															"GetApartments",
															{
																"university" : val
															},
															function(
																	responseJson) {
																//alert(responseJson);
																$
																		.each(
																				responseJson["Apartment"],
																				function(
																						index,
																						item) { // Iterate over the JSON array.
																					//alert(item);
																					var myCenter2 = new google.maps.LatLng(
																							item["lattitude"],
																							item["longitude"]);

																					var mk1 = new google.maps.Marker(
																							{
																								map : map,
																								title : item["apartmentKey"],
																								position : myCenter2
																							});

																					var contentVal = '<div id="content">'
																							+ '<img src="resources/images/s1.png" style="width:100px;height:100px;"/>'
																							+ '<h5 style="padding:0px;margin-top:4px;margin-bottom:1px;">'
																							+ item["name"]
																							+ '</h5>'
																							+ '<p style="padding:0px;margin:0px;">'
																							+ item["address"]
																							+ '</p>'
																							+ '<p style="padding:0px;margin:0px;">Payment: '
																							+ item["payment"]
																							+ '</p>'
																							+ '<p style="padding:0px;margin:0px;">Available places: '
																							+ item["avilablePlaces"]
																							+ '</p>'
																							+ '</div>';

																					var infowindow = new google.maps.InfoWindow(
																							{
																								content : contentVal
																							});

																					mk1
																							.addListener(
																									'mouseover',
																									function() {
																										infowindow
																												.open(
																														map,
																														mk1);

																									});

																					mk1
																							.addListener(
																									'mouseout',
																									function() {
																										infowindow
																												.close();

																									});

																					mk1
																							.addListener(
																									'click',
																									function() {
																										//alert(this.getTitle());
																										var form = document
																												.createElement("form");
																										var element1 = document
																												.createElement("input");
																										var element2 = document
																												.createElement("input");

																										form.method = "POST";
																										form.action = "ViewApartmentDetails";

																										element1.value = this
																												.getTitle();
																										element1.name = "apartmentKey";
																										form
																												.appendChild(element1);

																										element2.value = "dsf";
																										element2.name = "pw";
																										form
																												.appendChild(element2);

																										document.body
																												.appendChild(form);

																										form
																												.submit();

																									});

																					markers
																							.push(mk1);

																					// Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
																				});
															});

											// Create a marker for each place.
											markers
													.push(new google.maps.Marker(
															{
																map : map,
																icon : icon,
																title : place.name,
																position : place.geometry.location
															}));

											var myCenter = new google.maps.LatLng(
													6.8015, 79.8997);
											var myCenter1 = new google.maps.LatLng(
													6.8014, 79.8997);

											if (place.geometry.viewport) {
												// Only geocodes have viewport.
												bounds
														.union(place.geometry.viewport);
											} else {
												bounds
														.extend(place.geometry.location);
											}
										});
								map.fitBounds(bounds);

								map.setZoom(15);
							});
		}
	</script>
	<script>
		$(".dropdown-menu li a").click(
				function() {
					var selText = $(this).text();
					$(this).parents('.btn-group').find('.dropdown-toggle')
							.html(selText + ' <span class="caret"></span>');
					$("#pac-input").val(selText);
					
				});
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBvHohFe2Dm4cVd1ZP81MUmCG7S-GTGt34&libraries=places&callback=initAutocomplete"
		async defer></script>


</body>
</html>