<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="canvas-holder" class="martop-20" style="width:70%;margin:0 auto">
	<div class="task-count" style="display:none">전체<br><span class="count"></span>건</div>
	<canvas id="chart-area"></canvas>
</div>

<script src="<%=request.getContextPath() %>/js/utils.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
<script>
$(function(){
	
	var taskCount = $(".timeline-box .timeline-article.con-task").length;
	var taskState = $(".timeline-box .con-task input[name='edit-task-state']");	// 업무 상태 라디오 버튼
	
	var requestCnt = 0;		// 요청개수
	var progressCnt = 0;	// 진행개수
	var feedbackCnt = 0;	// 피드백개수
	var successCnt = 0;		// 완료개수
	var holdCnt = 0;		// 보류개수
	
	if(taskCount!=0){
		$(".pro-task-report").fadeIn(1500);
	}
	
	// 상단 전체 개수
	$(".pro-task-report h3 span").html(taskCount);
	
	// 업무 상태의 개수 구하기
	taskState.each(function(i, e){
		if(taskState.eq(i).val() == '요청'){
			if(taskState.eq(i).parent().hasClass('checked')){
				requestCnt += 1;
			}
		} else if(taskState.eq(i).val() == "진행"){
			if(taskState.eq(i).parent().hasClass('checked')){
				progressCnt += 1;
			}
		} else if(taskState.eq(i).val() == "피드백"){
			if(taskState.eq(i).parent().hasClass('checked')){
				feedbackCnt+=1;
			}
		} else if(taskState.eq(i).val() == "완료"){
			if(taskState.eq(i).parent().hasClass('checked')){
				successCnt+=1;
			}
		} else if(taskState.eq(i).val() == "보류"){
			if(taskState.eq(i).parent().hasClass('checked')){
				holdCnt+=1;
			}
		}
	});
	
	var config = {
		type: 'doughnut',
		data: {
			datasets: [{
				data: [
					requestCnt,
					//0,
					progressCnt,
					//0,
					feedbackCnt,
					//0,
					successCnt,
					//0,
					holdCnt,
				],
				backgroundColor: [
					window.chartColors.blue,
					//window.chartColors.white,
					window.chartColors.lightGreen,
					//window.chartColors.white,
					window.chartColors.orange,
					//window.chartColors.white,
					window.chartColors.darkBlue,
					//window.chartColors.white,
					window.chartColors.gray,
				],
				label: 'Dataset 1'
			}],
			labels: [
				'요청',
				//'',
				'진행',
				//'',
				'피드백',
				//'',
				'완료',
				//'',
				'보류'
			]
		},
		options: {
			responsive: true,
			legend: {
				position: 'right',
				labels: {
					fontSize: 16
				}
			},
			title: {
				display: false,
				text: 'Chart.js Doughnut Chart'
			},
			animation: {
				animateScale: true,
				animateRotate: true
			}
		}
	};

	window.onload = function() {
		var ctx = document.getElementById('chart-area').getContext('2d');
		window.myDoughnut = new Chart(ctx, config);
		
		$(".task-count span").html(taskCount);
		$(".task-count").fadeIn(1000);
	};

	var colorNames = Object.keys(window.chartColors);
	document.getElementById('addDataset').addEventListener('click', function() {
		var newDataset = {
			backgroundColor: [],
			data: [],
			label: 'New dataset ' + config.data.datasets.length,
		};

		for (var index = 0; index < config.data.labels.length; ++index) {
			newDataset.data.push(randomScalingFactor());

			var colorName = colorNames[index % colorNames.length];
			var newColor = window.chartColors[colorName];
			newDataset.backgroundColor.push(newColor);
		}

		config.data.datasets.push(newDataset);
		window.myDoughnut.update();
	});
	
});
</script>