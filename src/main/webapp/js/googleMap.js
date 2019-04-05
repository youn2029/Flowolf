/*******************************************
* Google Map Api
* 팀명 : #DEV
* 최초작성일 : 2018-10-06
* 작성자 : TA(Kim jin young)
*******************************************/

function initMap() {
	var map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : -33.8688,
			lng : 151.2195
		},
		zoom : 13
	});
	var input = document.getElementById('searchInput');
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

	var autocomplete = new google.maps.places.Autocomplete(input);
	autocomplete.bindTo('bounds', map);

	var infowindow = new google.maps.InfoWindow();
	var marker = new google.maps.Marker({
		map : map,
		anchorPoint : new google.maps.Point(0, -29)
	});

	autocomplete.addListener('place_changed', function() {
		infowindow.close();
		marker.setVisible(false);
		var place = autocomplete.getPlace();
		if (!place.geometry) {
			window.alert("장소를 선택해주세요");
			return;
		}

		// 지역정보가 있으면 맵에 표시하기
		if (place.geometry.viewport) {
			map.fitBounds(place.geometry.viewport);
		} else {
			map.setCenter(place.geometry.location);
			map.setZoom(17);
		}
		marker.setIcon(({
			url : place.icon,
			size : new google.maps.Size(71, 71),
			origin : new google.maps.Point(0, 0),
			anchor : new google.maps.Point(17, 34),
			scaledSize : new google.maps.Size(35, 35)
		}));
		marker.setPosition(place.geometry.location);
		marker.setVisible(true);

		var address = '';
		if (place.address_components) {
			address = [
				(place.address_components[0]
						&& place.address_components[0].short_name || ''),
				(place.address_components[1]
						&& place.address_components[1].short_name || ''),
				(place.address_components[2]
						&& place.address_components[2].short_name || '') ]
				.join(' ');
		}

		infowindow.setContent('<div><strong>' + place.name
				+ '</strong><br>' + address);
		infowindow.open(map, marker);

		$('#location').val(place.formatted_address);
		$('#schd_lat').val(place.geometry.location.lat());
		$('#schd_lon').val(place.geometry.location.lng());
		console.log('위도'+place.geometry.location.lat());
		console.log('경도'+place.geometry.location.lng());
	});
}