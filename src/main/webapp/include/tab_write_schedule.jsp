<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<form action="/schd/insert" name="frm" method="POST">
	<!-- tab-con-box:s -->
	<input type="hidden" name="pro_no"value="${proVo.pro_no }">
	<div class="tab-con-box">
		<!-- 일정제목:s -->
		<div class="input-box">
			<input type="text" class="font-bold size-18" name="schd_title" placeholder="일정 제목을 입력하세요." required="required" style="width: 90%">
		</div>
		<!-- 일정제목:f -->

		<!-- 일정 시간 설정:s -->
		<div class="input-box martop-15">
			<dl>
				<dt class="maright-20">
					<i class="far fa-clock"></i>
				</dt>
				<dd>
					<input type="text" required="required" placeholder="시작날짜 - 종료날짜" data-range="true" data-multiple-dates-separator="   -   " class="datepicker-here" id="datetime" name="datetime" style="width: 100%" />
				</dd>
			</dl>
		</div>
		<!-- 일정 시간 설정:f -->
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


		<!-- 위치 검색:s -->
		<div class="input-box martop-15">
			<dl>
				<dt class="maright-20">
					<i class="fas fa-map-marker-alt"></i>
				</dt>
				<dd>
					<input id="searchInput" name="schd_loc" class="controls" type="text" placeholder="장소를입력하세요" style="width: 90%">
					<div id="map"></div>
					<input type="hidden" id="schd_lat" name="schd_lat"> <input type="hidden" id="schd_lon" name="schd_lon">
				</dd>
			</dl>
		</div>
		<!-- 위치 검색:f -->

		<!-- 메모:s -->
		<div class="input-box martop-15">
			<dl>
				<dt class="maright-20">
					<i class="fas fa-sticky-note"></i>
				</dt>
				<dd>
					<textarea rows="2" cols="" placeholder="메모를 입력하세요." name="schd_memo"></textarea>
				</dd>
			</dl>
		</div>
		<!-- 메모:f -->

		<!-- 알람:s -->
		<div class="input-box martop-15">
			<dl>
				<dt class="maright-20">
					<i class="fas fa-bell"></i>
				</dt>
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
	<!-- tab-con-box:f -->

	<!-- tab-dn-box:s -->
	<div class="tab-dn-box">
		<!-- 올리기(submit) 버튼 -->

		<input type="submit" value="올리기" class="article-submit-btn float-right font-bold size-18 color-white text-center default-back-color">
	</div>
	<!-- tab-dn-box:f -->

</form>
<script>
	function getSelectValue(frm) {
		frm.textValue.value = frm.selectBox.options[frm.selectBox.selectedIndex].text;
		frm.optionValue.value = frm.selectBox.options[frm.selectBox.selectedIndex].value;
	}
	
</script>

