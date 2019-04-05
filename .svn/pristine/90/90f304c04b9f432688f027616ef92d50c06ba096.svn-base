<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="col-md-10 admin-con-wrap">
	
	<!-- title -->
	<div class="dis-block posi-re">
		<strong class="dis-inblock size-30 color-black">프로젝트 통계</strong>
		<span class="dis-inblock marleft-15 size-18 color-gray">Project Statistics</span>
	</div>

	<!-- 회원수 통계:s -->
	<div class="container martop-30">
		<div class="row">
			
		</div>
	</div>
	<!-- 회원수 통계:f -->
	
	<!-- 분류 이름 가져오기 -->
	<c:forEach items="${kindAllList }" var="list">
	<div class="dis-none kind-name">${list.kind_name }</div>
	</c:forEach>
	
	<div class="container martop-30">
		<div class="row">
		
			<div class="col-md-5" style="padding:0">
				<!-- 전체 프로젝트 개수 : s -->
				<div class="col-md-12">
					<div class="posi-re pad-20 back-color-white">
						<strong class="dis-block marbtm-30">FLOWOLF ALL PROJECT</strong>
						<i class="far fa-chart-bar size-30 default-color"></i>
						<span class="count-box color-white default-back-color">${map.asum }</span>
					</div>
				</div>
				<!-- 전체 프로젝트 개수 : f -->
				
				<!-- 분류별 통계 : s -->
				<div class="col-md-12 martop-30">
					<div id="curve_chart" class="admin-content" style="height:260px;padding:15px">
						<div id="container" style="width:100%;">
							<canvas id="canvasKind"></canvas>
						</div>
					</div>
				</div>
				<!-- 분류별 통계 : f-->
			</div>
			
			<!-- 월별 통계 : s -->
			<div class="col-md-7">
				<div id="curve_chart" class="admin-content" style="height:406px">
					<div id="container" style="width:100%;">
						<canvas id="canvasMonth"></canvas>
					</div>
				</div>
			</div>
			<!-- 월별 통계 : f-->
	
			<!-- 분류-월별 통계 : s -->
			<div class="col-md-12">
				<div id="curve_chart" class="admin-content martop-30">
					<div id="container" style="width:100%;">
						<canvas id="canvas"></canvas>
					</div>
				</div>
			</div>
			<!-- 분류-월별 통계 : f -->
		</div>
	</div>
	
	
	
	<!-- member chart box:f -->
	<script type="text/javascript">

	// engeneering
	var jane = parseInt("${map.jane}");
	var febe = parseInt("${map.febe}");
	var mare = parseInt("${map.mare}");
	var aple = parseInt("${map.aple}");
	var maye = parseInt("${map.maye}");
	var june = parseInt("${map.june}");
	var jule = parseInt("${map.jule}");
	var auge = parseInt("${map.auge}");
	var sepe = parseInt("${map.sepe}");
	var octe = parseInt("${map.octe}");
	var nove = parseInt("${map.nove}");
	var dece = parseInt("${map.dece}");
	var engData = [jane, febe, mare, aple, maye, june, jule, auge, sepe, octe, nove, dece];
	
	// design
	var jand = parseInt("${map.jand}");
	var febd = parseInt("${map.febd}");
	var mard = parseInt("${map.mard}");
	var apld = parseInt("${map.apld}");
	var mayd = parseInt("${map.mayd}");
	var jund = parseInt("${map.jund}");
	var juld = parseInt("${map.juld}");
	var augd = parseInt("${map.augd}");
	var sepd = parseInt("${map.sepd}");
	var octd = parseInt("${map.octd}");
	var novd = parseInt("${map.novd}");
	var decd = parseInt("${map.decd}");
	var desData = [jand, febd, mard, apld, mayd, jund, juld, augd, sepd, octd, novd, decd];
	
	// marketing
	var janm = parseInt("${map.janm}");
	var febm = parseInt("${map.febm}");
	var marm = parseInt("${map.marm}");
	var aplm = parseInt("${map.aplm}");
	var maym = parseInt("${map.maym}");
	var junm = parseInt("${map.junm}");
	var julm = parseInt("${map.julm}");
	var augm = parseInt("${map.augm}");
	var sepm = parseInt("${map.sepm}");
	var octm = parseInt("${map.octm}");
	var novm = parseInt("${map.novm}");
	var decm = parseInt("${map.decm}");
	var makData = [janm, febm, marm, aplm, maym, junm, julm, augm, sepm, octm, novm, decm];
	
	
	var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
	var color = Chart.helpers.color;
	var barChartData = {
		labels: MONTHS,
		datasets: [{
			label: 'Engenieering',
			backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
			borderColor: window.chartColors.red,
			borderWidth: 1,
			data: engData
		}, {
			label: 'Design',
			backgroundColor: color(window.chartColors.lightBlue).alpha(0.5).rgbString(),
			borderColor: window.chartColors.lightBlue,
			borderWidth: 1,
			data: desData
		}, {
			label: 'Marketing',
			backgroundColor: color(window.chartColors.darkYellow).alpha(0.5).rgbString(),
			borderColor: window.chartColors.darkYellow,
			borderWidth: 1,
			data: makData
		}]

	};
	
	// 월별 프로젝트 통계
	var monthCount = ${proMonthCntList};
	var horizontalBarChartData = {
		labels: MONTHS,
		datasets: [{
			label: 'By Monthly',
			backgroundColor: color(window.chartColors.lightGreen).alpha(0.5).rgbString(),
			borderColor: window.chartColors.green,
			borderWidth: 1,
			data: monthCount
		}]

	};
	
	
	// 분류별 프로젝트 통계
	var kindLength = $(".kind-name").length;	// 분류개수
	var kindArray = new Array();				// 분류배열

	// 배열에 분류 저장
	for(var i=0; i < kindLength; i++){
		kindArray.push($(".kind-name").eq(i).text());
	}
	
	var kindCount = ${proKindCntList};
	
	var config = {
		type: 'pie',
		data: {
			datasets: [{
				data: kindCount,
				backgroundColor: [
				  	color(window.chartColors.red).alpha(0.5).rgbString(),
				  	color(window.chartColors.lightBlue).alpha(0.5).rgbString(),
				  	color(window.chartColors.darkYellow).alpha(0.5).rgbString(),
				  	color(window.chartColors.lightPurple).alpha(0.5).rgbString(),
				  	color(window.chartColors.lightGreen).alpha(0.5).rgbString(),
				  	color(window.chartColors.lightGray).alpha(0.5).rgbString()
				],
				label: 'By Category'
			}],
			labels: kindArray
		},
		options: {
			responsive: true,
			legend: {
				display: true,
				position: 'left',
				labels: {
					fontSize: 12
				}
			},
			title: {
				display: false,
				position: 'top',
				text: 'By Category',
				fontSize: 20,
				padding: 10,
				lineHeihgt: 0.5
			}
		}
	};
	
	window.onload = function() {
		// 월별-분류별 통계 (bar)
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
					display: true,
					position: 'top',
					text: 'All Project Chart',
					fontSize: 30,
					padding: 20,
					lineHeight: 0.5
				}
			}
		});
		
		// 월별 통계(horizontal bar)
		var ctx2 = document.getElementById('canvasMonth').getContext('2d');
		window.myHorizontalBar = new Chart(ctx2, {
			type: 'horizontalBar',
			data: horizontalBarChartData,
			options: {
				elements: {
					rectangle: {
						borderWidth: 2,
					}
				},
				responsive: true,
				legend: {
					display: false,
					position: 'top',
				},
				title: {
					display: false,
					position: 'left',
					text: 'By Monthly',
					fontSize: 20,
					padding: 10,
					lineHeight: 0.5
				}
			}
		});

		// 분류별 통계 (Pie)
		var ctx2 = document.getElementById('canvasKind').getContext('2d');
		window.myPie = new Chart(ctx2, config);

	};
	
	
	</script>
</section>