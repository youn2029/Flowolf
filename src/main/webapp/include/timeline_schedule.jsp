<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="timeline-article con-schedule">
	<div class="container">
		<div class="schedule-header">
			<dl>
				<dt class="maright-15">
					<span class="dis-block font-thin size-20 color-red text-center">${fn:substring(timeLine.schdVo.schd_start_time, 5, 7) }월</span>
					<strong class="dis-block font-bold size-40 color-black text-center">${fn:substring(timeLine.schdVo.schd_start_time, 8, 10) }</strong>
				</dt>
				<dd class="font-bold size-20 color-black">${timeLine.schdVo.schd_title }</dd>
				<dd class="martop-10 font-bold size-16 color-black">${timeLine.schdVo.schd_start_time }   -   ${timeLine.schdVo.schd_end_time }</dd>
			</dl>
		</div>
		
		<!-- 위치 검색:s -->
		<c:choose>
			<c:when test="${timeLine.schdVo.schd_loc != null }">
				<div class="input-box">
					<dl>
						<dt class="maright-20"><i class="fas fa-map-marker-alt"></i></dt>
						<dd>
							<div class="dis-block marbtm-15">${timeLine.schdVo.schd_loc }<a href="https://maps.google.com?q=${timeLine.schdVo.schd_loc }" target="google_blank" class="marleft-15">지도보기</a></div>
							<div id="googleMap" class="dis-block" >
								<img src="https://maps.googleapis.com/maps/api/staticmap?center=${timeLine.schdVo.schd_lat },${timeLine.schdVo.schd_lon }&amp;zoom=15&amp;size=800x200&amp;markers=color:red|${timeLine.schdVo.schd_lat },${timeLine.schdVo.schd_lon }&amp;key=AIzaSyAmxDFvVfjjBQ0eWrQ2Pgv8odc0L8rbJU4" style="height:100%; width:100%">
							</div>
						</dd>
					</dl>
				</div>
			</c:when>
		</c:choose>
		<!-- 위치 검색:f -->
		
		<!-- 메모:s -->
		<c:choose>
			<c:when test="${timeLine.schdVo.schd_memo != null}">
				<div class="input-box martop-15">
					<dl>
						<dt class="maright-20"><i class="fas fa-sticky-note"></i></dt>
						<dd>
							${timeLine.schdVo.schd_memo }
						</dd>
					</dl>
				</div>
			</c:when>
		</c:choose>
		<!-- 메모:f -->
		
		<!-- 알람:s -->
		<c:choose>
			<c:when test="${timeLine.schdVo.minute != null}">
				<div class="input-box martop-15" style="border:0">
					<dl>
						<dt class="maright-20"><i class="fas fa-bell"></i></dt>
						<dd>
							${timeLine.schdVo.minute} 전 미리알림
						</dd>
					</dl>
				</div>
			</c:when>
			<c:otherwise>
				<div class="input-box martop-15" style="border:0">
					<dl>
						<dt class="maright-20"><i class="fas fa-bell"></i></dt>
						<dd>
							미리알림 없음
						</dd>
					</dl>
				</div>
			</c:otherwise>
		</c:choose>
		<!-- 알람:f -->
	</div>
</div>

	
<!-- 일정 수정:s -->
<form action="/schd/update" class="article-edit-form" method="POST">
<input type="hidden" name="schd_no"value="${timeLine.schdVo.schd_no }">
<input type="hidden" name="pro_no"value="${proVo.pro_no }">
	<!-- article edit box:s -->
	<div class="article-edit-box">
	
		<!-- 일정제목:s -->
		<div class="input-box">
			<input type="text" name="schd_title" class="font-bold size-18" value=" ${timeLine.schdVo.schd_title }" required="required">
		</div>
		<!-- 일정제목:f -->
		
		<!-- 일정 시간 설정:s -->
		<div class="input-box martop-15">
			<dl>
				<dt class="maright-20"><i class="far fa-clock"></i></dt>
				<dd>
					<input type="hidden" value="${timeLine.schdVo.schd_start_time }   -   ${timeLine.schdVo.schd_end_time }" name="defaultDate">
					<input type="text"
<%-- 					placeholder="${timeLine.schdVo.schd_start_time }   -   ${timeLine.schdVo.schd_end_time }" --%>
					placeholder="${timeLine.schdVo.schd_start_time }   -   ${timeLine.schdVo.schd_end_time }"
					data-range="true"
					data-multiple-dates-separator="   -   "
					class="datepicker-here"
					id="datetime"
					name="datetime"
					style="width:100%"/>
				</dd>
			</dl>
		</div>
		<!-- 일정 시간 설정:f -->
		<!-- 위치 검색:s -->
		<!-- 위치 검색:f -->
		<div class="input-box martop-15">
			<dl>
				<dt class="maright-20"><i class="fas fa-map-marker-alt"></i></dt>
				<c:choose>
					<c:when test="${timeLine.schdVo.schd_loc != null }">
						<dd>
							<input id="searchInput2" name ="schd_loc" class="controls" type="text" value="${timeLine.schdVo.schd_loc }"   style="width:90%">
							<div id="map" class="dis-block" style="width:100%;"></div>
<%-- 							<img src="https://maps.googleapis.com/maps/api/staticmap?center=${timeLine.schdVo.schd_lat },${timeLine.schdVo.schd_lon }&amp;zoom=15&amp;size=630x300&amp;markers=color:red|${timeLine.schdVo.schd_lat },${timeLine.schdVo.schd_lon }&amp;key=AIzaSyADjbtMn46r9DGFyo_ZRz3c6fOXzuOKWCw" style="width:100%; height:100%;"> --%>
							<input type="hidden" id="schd_lat2" class="schd_lat2"name="schd_lat" value="${timeLine.schdVo.schd_lat}"> 
							<input type="hidden" id="schd_lon2" class="schd_lon2"name="schd_lon" value="${timeLine.schdVo.schd_lon}">
						</dd>
					</c:when>
					<c:otherwise>
						<dd>
							<input id="searchInput2" name ="schd_loc" class="controls" type="text" style="width:90%">
							<input type="hidden" class="schd_lat2" id="schd_lat2" name="schd_lat" value="${timeLine.schdVo.schd_lat}"> 
							<input type="hidden" class="schd_lon2" id="schd_lon2" name="schd_lon" value="${timeLine.schdVo.schd_lon}">
						</dd>
					</c:otherwise>
				</c:choose>
			</dl>
		</div>
		
		
		
		<script>
			$('.datepicker-here').datepicker({
				timepicker : true,
				language : 'ko',
				startMinute : 0,
				maxMinutes : 50,
				minutesStep : 10,
				autoClose : true
			})
		</script>
		
		
		<!-- 메모:s -->
		<div class="input-box martop-15">
			<dl>
				<dt class="maright-20"><i class="fas fa-sticky-note"></i></dt>
				<dd>
					<c:choose>
						<c:when test="${timeLine.schdVo.schd_memo !=null }">
							<textarea rows="2" cols="" name="schd_memo" >${timeLine.schdVo.schd_memo }</textarea>
						</c:when>
						<c:otherwise>
							<textarea rows="2" cols="" name="schd_memo" ></textarea>
						</c:otherwise>
					</c:choose>
				</dd>
			</dl>
		</div>
		<!-- 메모:f -->
		
		<!-- 알람:s -->
		<div class="input-box martop-15">
			<dl>
				<dt class="maright-20"><i class="fas fa-bell"></i></dt>
				<dd>
					<select name="alert_time" onchange="getSelectValue(this.form);">
						<option value="0">없음</option>
						<option value="10">10분전 미리알림</option>
						<option value="30">30분전 미리알림</option>
						<option value="60">1시간전 미리알림</option>
						<option value="120">2시간전 미리알림</option>
						<option value="180">3시간전 미리알림</option>
						<option value="1440">1일전</option>
						<option value="2880">2일전</option>
						<option value="10080">7일전</option>
					</select>
				</dd>
			</dl>
		</div>
		<!-- 알람:f -->
	</div>
	<!-- article edit box:f -->
	
	<!-- article edit dn:s -->
	<div class="article-edit-dn">		
		<!-- submit & cancel 버튼 -->
		<input type="submit" value="수정하기" class="article-submit-btn font-bold size-16 color-white text-center default-back-color">
		<input type="button" value="취소" onclick="fn_editCancel(this)" 
		class="article-submit-btn maright-10 font-bold size-16 color-gray text-center back-color-white"
		style="border:1px solid #ddd">
	</div>
	<!-- article edit dn:f -->
</form>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB3F6HUmoF9DMA6KsovfusumiMHCDmjKPg&libraries=places&callback=autoComplete" async defer></script>
			<script type="text/javascript">
			/*******************************************
			* Google Map Api
			* 팀명 : #DEV
			* 최초작성일 : 2018-10-06
			* 작성자 : TA(Kim jin young)
			*******************************************/

			function autoComplete() {
				var map = new google.maps.Map(document.getElementById('map'), {
					center : {
						lat : -33.8688,
						lng : 151.2195
					},
					zoom : 13
				});
				var input = document.getElementById('searchInput2');
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

					$('#schd_lat2').val(place.geometry.location.lat());
					$('#schd_lon2').val(place.geometry.location.lng());
					console.log('위도'+place.geometry.location.lat());
					console.log('경도'+place.geometry.location.lng());
				});
			}
			</script>
<!-- 일정 수정:f -->