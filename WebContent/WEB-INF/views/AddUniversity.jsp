
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Add University</title>
<style>
html, body {
	height: 97%;
	margin: 0;
	padding: 0;
}

#map {
	height: 80%;
}

.controls {
	margin-top: 10px;
	margin-left: 5px;
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
<body style="background:url('resources/images/Welcome-2_3.jpg') no-repeat center center fixed;">

	<div class="page-header">
		<h2>Add University details</h2>
	</div>

	<div class="col-md-5">

		<div class="row centered-form">
			<div class="col-md-2"></div>
			<div class="col-xs-12 col-sm-8 col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Register New University <small>It's free!</small>
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="AddUniversity" method="post">



							<div class="row">
								<div class="col-xs-10 col-sm-10 col-md-10">
									<div class="form-group">
										<input type="text" name="university_name" id="university_name"
											class="form-control input-sm" placeholder="University Name">
									</div>
								</div>

							</div>



							<div class="form-group">
								<input type="text" name="address" id="address"
									class="form-control input-sm" placeholder="Address">
							</div>

							<div class="form-group">
								<input type="text" name="lattitude" id="lattitude"
									class="form-control input-sm"
									placeholder="lattitude(Click Map to set value)" required>
							</div>

							<div class="form-group">
								<input type="text" name="longitude" id="longitude"
									class="form-control input-sm"
									placeholder="longitude(Click Map to set value)" required>
							</div>

							<input type="submit" value="Register"
								class="btn btn-info btn-block">

						</form>
					</div>
				</div>
			</div>
		</div>


	</div>
	<input id="pac-input" class="controls" type="text"
		placeholder="Search Box">

	<div id="map"></div>
	<div class="row"></div>
	<script>
		// This example adds a search box to a map, using the Google Place Autocomplete
		// feature. People can enter geographical searches. The search box will return a
		// pick list containing a mix of places and predicted search terms.

		// This example requires the Places library. Include the libraries=places
		// parameter when you first load the API. For example:
		// <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

		var marker;
		var map;
		var searchBox;
		function placeMarker(location) {

			if (marker == undefined) {
				marker = new google.maps.Marker({
					position : location,
					map : map
				});
			} else {
				marker.setPosition(location);
			}
			//map.setCenter(location);

		}

		function initAutocomplete() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : 6.796557757090544,
					lng : 79.9010257422924
				},
				zoom : 14,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			});

			// Create the search box and link it to the UI element.
			var input = document.getElementById('pac-input');
			searchBox = new google.maps.places.SearchBox(input);
			map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

			// Bias the SearchBox results towards current map's viewport.
			map.addListener('bounds_changed', function() {
				searchBox.setBounds(map.getBounds());
			});

			google.maps.event.addListener(map, 'click', function(e) {
				placeMarker(e.latLng);
				$("#lattitude").val(e.latLng.lat());
				$("#longitude").val(e.latLng.lng());
			});

			var markers = [];
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

				// For each place, get the icon, name and location.
				var bounds = new google.maps.LatLngBounds();
				places.forEach(function(place) {
					var icon = {
						url : place.icon,
						size : new google.maps.Size(71, 71),
						origin : new google.maps.Point(0, 0),
						anchor : new google.maps.Point(17, 34),
						scaledSize : new google.maps.Size(17, 17)

					};

					// Create a marker for each place.
					markers.push(new google.maps.Marker({
						map : map,
						icon : icon,
						title : place.name,
						position : place.geometry.location
					}));

					if (place.geometry.viewport) {
						// Only geocodes have viewport.
						bounds.union(place.geometry.viewport);
					} else {
						bounds.extend(place.geometry.location);
					}
				});
				map.fitBounds(bounds);

				map.setZoom(15);
			});
		}
	</script>

	<script>
		var $inputs = $('#university_name, #pac-input');

		$inputs.keyup(function() {
			$inputs.val($(this).val());
		});
	</script>

	<script>
		$("#university_name").keyup(function(e) {
			//var selText = $(this).text();
			alert(selText);
			$("#pac-input").val(selText);
			google.maps.event.trigger(searchBox, 'place_changed');

		});
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBvHohFe2Dm4cVd1ZP81MUmCG7S-GTGt34&libraries=places&callback=initAutocomplete"
		async defer></script>


</body>
</html>