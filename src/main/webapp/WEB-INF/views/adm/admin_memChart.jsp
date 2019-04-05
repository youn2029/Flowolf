<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="col-md-10 admin-con-wrap">
	
	<!-- title -->
	<div class="dis-block posi-re">
		<strong class="dis-inblock size-30 color-black">회원 통계</strong>
		<span class="dis-inblock marleft-15 size-18 color-gray">Member Statistics</span>
	</div>
	
	<!-- 회원수 통계:s -->
	<div class="container martop-30">
		<div class="row">
		
			<div class="col-md-3">
				<div class="posi-re pad-20 back-color-white">
					<strong class="dis-block marbtm-30">FLOWOLF ALL MEMBER</strong>
					<i class="far fa-chart-bar size-30 default-color"></i>
					<span class="count-box color-white default-back-color">${map.asum }</span>
				</div>
			</div>
		
			<div class="col-md-3">
				<div class="posi-re pad-20 back-color-white">
					<strong class="dis-block marbtm-30">General Members</strong>
					<i class="far fa-chart-bar size-30 color-blue-l"></i>
					<span class="count-box color-white back-color-blue-l">${map.bsum }</span>
				</div>
			</div>
		
			<div class="col-md-3">
				<div class="posi-re pad-20 back-color-white">
					<strong class="dis-block marbtm-30">KAKAO Members</strong>
					<i class="far fa-chart-bar size-30 color-yellow-d"></i>
					<span class="count-box color-white back-color-yellow-d">${map.ksum }</span>
				</div>
			</div>
		
			<div class="col-md-3">
				<div class="posi-re pad-20 back-color-white">
					<strong class="dis-block marbtm-30">GOOGLE Members</strong>
					<i class="far fa-chart-bar size-30 color-red"></i>
					<span class="count-box color-white back-color-red">${map.gsum }</span>
				</div>
			</div>
			
		</div>
	</div>
	<!-- 회원수 통계:f -->
	
	
	<!-- member chart box:s -->
	<div id="curve_chart" class="admin-content martop-20">
		<div id="container" style="width:100%;">
			<canvas id="canvas"></canvas>
		</div>
		<script>
			
			var janb = ${map.janb};
			var febb = ${map.febb};
			var marb = ${map.marb};
			var aplb = ${map.aplb};
			var mayb = ${map.mayb};
			var junb = ${map.junb};
			var julb = ${map.julb};
			var augb = ${map.augb};
			var sepb = ${map.sepb};
			var octb = ${map.octb};
			var novb = ${map.novb};
			var decb = ${map.decb};
			
			
			var jank = ${map.jank};
			var febk = ${map.febk};
			var mark = ${map.mark};
			var aplk = ${map.aplk};
			var mayk = ${map.mayk};
			var junk = ${map.junk};
			var julk = ${map.julk};
			var augk = ${map.augk};
			var sepk = ${map.sepk};
			var octk = ${map.octk};
			var novk = ${map.novk};
			var deck = ${map.deck};
			
			
			var jang = ${map.jang};
			var febg = ${map.febg};
			var marg = ${map.marg};
			var aplg = ${map.aplg};
			var mayg = ${map.mayg};
			var jung = ${map.jung};
			var julg = ${map.julg};
			var augg = ${map.augg};
			var sepg = ${map.sepg};
			var octg = ${map.octg};
			var novg = ${map.novg};
			var decg = ${map.decg};
			
			
			var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
			var color = Chart.helpers.color;
			var barChartData = {
				labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
				datasets: [{
					label: '일반 회원 가입 수',
					backgroundColor: color(window.chartColors.lightBlue).alpha(0.5).rgbString(),
					borderColor: window.chartColors.lightBlue,
					borderWidth: 1,
					data: [
					       janb,
					       febb,
					       marb,
					       aplb,
					       mayb,
					       junb,
					       julb,
					       augb,
					       sepb,
					       octb,
					       novb,
					       decb
					]
				}, {
					label: '카카오 회원 가입 수',
					backgroundColor: color(window.chartColors.darkYellow).alpha(0.5).rgbString(),
					borderColor: window.chartColors.darkYellow,
					borderWidth: 1,
					data: [
					       jank,
					       febk,
					       mark,
					       aplk,
					       mayk,
					       junk,
					       julk,
					       augk,
					       sepk,
					       octk,
					       novk,
					       deck
					]
				},{
					label: '구글 회원 가입 수',
					backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
					borderColor: window.chartColors.red,
					borderWidth: 1,
					data: [
					       jang,
					       febg,
					       marg,
					       aplg,
					       mayg,
					       jung,
					       julg,
					       augg,
					       sepg,
					       octg,
					       novg,
					       decg
					]
				}]
	
			};
	
			window.onload = function() {
				var ctx = document.getElementById('canvas').getContext('2d');
				window.myBar = new Chart(ctx, {
					type: 'bar',
					data: barChartData,
					options: {
						responsive: true,
						legend: {
							position: 'top',
						},
						title: {
							display: false,
							text: 'Chart.js Bar Chart'
						}
					}
				});
	
			};
		</script>
	</div>
	<!-- member chart box:f -->
</section>