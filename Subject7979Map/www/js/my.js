var areaCoords = [];

var areasMap = [];

var defaultLatLng;

var markers = [];

var structMark;

var myOptions = {

	zoom : 16,

	center : '',

	mapTypeId : google.maps.MapTypeId.ROADMAP,

	disableDefaultUI : true,

};

var map;

var image;

function mapClick (e){
	
		var strLatLgn = e.latLng;

		var myLatLgn = strLatLgn.toString();

		var n = myLatLgn.length;

		myLatLgn = myLatLgn.substr(1,(n - 2));

		var newMyPos = myLatLgn.split(",");

		areaCoords[areaCoords.length] = {
			'lat' : parseFloat(newMyPos[0]),
			'lng' : parseFloat(newMyPos[1])
		};

		structMark = new google.maps.LatLng(
				parseFloat(newMyPos[0]),
				parseFloat(newMyPos[1]));

		map.panTo(structMark);

		markers[markers.length] = new google.maps.Marker(
				{

					position : structMark,

					map : map,

					icon : image,

				});

		if (areaCoords.length >= 3) {

			/**
			 * Borrar los anteriores
			 * poligonos
			 */
			$.each(areasMap, function(index, item) {

				item.setMap(null);

			});

			areaCoords[areaCoords.length] = areaCoords[0];

			areasMap[areasMap.length] = new google.maps.Polygon(
					{

						paths : areaCoords,

						strokeColor : '#FF0000',

						strokeOpacity : 1,

						strokeWeight : 2,

						fillColor : '#FF0000',

						fillOpacity : 0.35

					});

			areasMap[areasMap.length - 1].setMap(map);

			areaCoords.pop();

		}

	
	
}

function drawMap(latlng) {
	
	myOptions.center = latlng;
	
	map = new google.maps.Map(document.getElementById("map-canvas"), myOptions);

	var centerControlDiv = document.createElement('div');

	var centerControl = new CenterControl(centerControlDiv,map);

	centerControlDiv.index = 1;

	map.controls[google.maps.ControlPosition.TOP_CENTER].push(centerControlDiv);

	var controlDiv = document.createElement('div');

	var centerControl = new CenterControlButton(controlDiv,map);

	controlDiv.index = 2;

	map.controls[google.maps.ControlPosition.TOP_CENTER].push(controlDiv);

	image = {

		url : 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',

		size : new google.maps.Size(20, 32),

		origin : new google.maps.Point(0, 0),

		anchor : new google.maps.Point(0, 32)
	};

	/**
	 * Evento cuando se hace click en cualquier area del
	 * mapa.
	 */
	map.addListener('click', mapClick);

}

function CenterControlButton(controlDiv, map) {

	var controlUI = document.createElement('div');

	controlUI.style.backgroundColor = '#fff';

	controlUI.style.border = '1px solid #fff';

	controlUI.style.borderRadius = '5px';

	controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';

	controlUI.style.cursor = 'pointer';

	controlUI.style.marginBottom = '0px';

	controlUI.style.textAlign = 'center';

	controlUI.title = 'Click to reset area';

	controlDiv.appendChild(controlUI);

	var controlText = document.createElement('div');

	controlText.style.color = 'rgb(25,25,25)';

	controlText.style.fontFamily = 'Roboto,Arial,sans-serif';

	controlText.style.fontSize = '14px';

	controlText.style.lineHeight = '25px';

	controlText.style.paddingLeft = '5px';

	controlText.style.paddingRight = '5px';

	controlText.innerHTML = 'Reset area';

	controlUI.appendChild(controlText);

	controlUI.addEventListener('click', function() {

		if (areasMap.length) {
			
			/**
			 * Se borran todos los poligonos creados.
			 */
			$.each(areasMap, function(index, item) {

				item.setMap(null);

			});
			
			areasMap = [];
			
			$.each(markers, function(index, item) {

				item.setMap(null);

			});
			
			areaCoords = [];
			
			
		}else {
			
			alert("There is not any area created yet");
			
		}

	});

}

function CenterControl(controlDiv, map) {

	var controlUI = document.createElement('div');

	controlUI.style.backgroundColor = '#fff';

	controlUI.style.border = '1px solid #fff';

	controlUI.style.borderRadius = '5px';

	controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';

	controlUI.style.cursor = 'pointer';

	controlUI.style.marginBottom = '0px';

	controlUI.style.textAlign = 'center';

	controlUI.title = 'Click to calculate the area';

	controlDiv.appendChild(controlUI);

	var controlText = document.createElement('div');

	controlText.style.color = 'rgb(25,25,25)';

	controlText.style.fontFamily = 'Roboto,Arial,sans-serif';

	controlText.style.fontSize = '14px';

	controlText.style.lineHeight = '25px';

	controlText.style.paddingLeft = '5px';

	controlText.style.paddingRight = '5px';

	controlText.innerHTML = 'Calcutate total Area';

	controlUI.appendChild(controlText);

	controlUI.addEventListener('click', function() {

		if (areasMap.length) {

			alert("There are "
					+ parseInt(google.maps.geometry.spherical
							.computeArea(areasMap[areasMap.length - 1]
									.getPath())) + " square meters ");

			console.log(areaCoords);

		} else {

			alert("Please first create an area.");
		}
	});

}

$(document).on("pageinit","#map-page",function() {

		defaultLatLng = new google.maps.LatLng(34.0983425, -118.3267434); // Default to Hollywood, CA when no

		if (navigator.geolocation) {
						
			function success(pos) {
					drawMap(new google.maps.LatLng(pos.coords.latitude,pos.coords.longitude));
			}

			function fail(error) {
					drawMap(defaultLatLng);
			}

			navigator.geolocation.getCurrentPosition(success, fail,{maximumAge : 500000,enableHighAccuracy : true,timeout : 6000});
						
		} else {
			drawMap(defaultLatLng);

		}

});
