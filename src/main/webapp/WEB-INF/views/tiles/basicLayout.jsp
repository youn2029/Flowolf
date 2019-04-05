<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maxium-scale=1.0, minimum-scale=1.0, width=device-width"/>
		
		<meta name="google-signin-scope" content="profile email">
		<meta name="google-signin-client_id" content="1081075870716-k7q8bgo2f1eip8pgkjeejr16imo0s9r5.apps.googleusercontent.com">
		
		<title>FLOWOLF</title>
		
		<!-- favicon -->
		<link rel="shortcut icon" href="<%=request.getContextPath() %>/image/favicon.ico">
		
		<!-- font-awesome CSS -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
		
		<!-- KAKAO login JS -->
		<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
		
		<!-- bootstrap CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
		
		<!-- bootstrap-theme CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		
		<!-- jQuery 3.3.1 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<!-- jQuery UI JS -->
		<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		
		<!-- jQuery UI CSS -->
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
		
		<!-- fileEx JS -->
		<script src="<%=request.getContextPath() %>/js/fileEx.js"></script>
		
		<!-- 정규식 -->
		<script src="<%=request.getContextPath() %>/js/regEx.js"></script>
		
		<!-- FLOWOLF CUSTOM JS -->
		<script src="<%=request.getContextPath() %>/js/flowolf_custom.js"></script>
		
		<!-- Get Date JS -->
		<script src="<%=request.getContextPath() %>/js/getDate.js"></script>
		
		<!-- google -->
		<script src="https://apis.google.com/js/platform.js" async defer></script>
		
		<!-- google map -->
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAmxDFvVfjjBQ0eWrQ2Pgv8odc0L8rbJU4&libraries=places&callback=initMap" async defer></script>
		<script src="<%=request.getContextPath() %>/js/googleMap.js"></script>
		
		<!-- datepicker CSS & JS -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/datepicker.min.css">
		<script src="<%=request.getContextPath() %>/js/datepicker.min.js"></script>
		<script src="<%=request.getContextPath() %>/js/datepicker.en.js"></script>
		<script src="<%=request.getContextPath() %>/js/datepicker.ko.js"></script>

		<!-- swiper CSS & JS -->		
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/swiper.min.css">
		<script src="<%=request.getContextPath() %>/js/swiper.js"></script>
		
		<!-- scroll custom CSS & JS -->
		<link rel="stylesheet" href="https://unpkg.com/simplebar@latest/dist/simplebar.min.css" />
		<script src="https://unpkg.com/simplebar@latest/dist/simplebar.js"></script>
		
		<!-- custom style -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_color.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_font.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_margin.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_padding.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_chat_icon_popup.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_collection.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_post.css">
		
	</head>
	<body>
		
		<div class="body-wrap-full open-nav">
			<div class="container">
			
				<!-- body-left-panel:s -->
				<aside class="body-left-panel">
					<tiles:insertAttribute name="aside"/>
				</aside>
				<!-- body-left-panel:f -->
			
				<!-- body-right-panel:s -->
				<div class="body-right-panel">
				
					<!-- aside open&close btn -->
					<div class="nav-toggle-btn"><a href="#toggleBtn" class="flow-icon">aside nav btn</a></div>
					
					<!-- top.jsp -->
					<tiles:insertAttribute name="top"/>
		
					<!-- contents -->
					<tiles:insertAttribute name="content"/>
					
					<!-- layer pop up contents -->
					<tiles:insertAttribute name="layerPopCon"/>
<%-- 					<%@include file="/include/layerPopCon.jsp" %> --%>
					
				</div>
				<!-- body-right-panel:f -->
				
			</div>
		</div>
		
		<script type="text/javascript">
		$(function(){
			
			// nav toggle
			$(".nav-toggle-btn").on("click", function(){
				if($(".body-wrap-full").hasClass("open-nav")){
					$(".body-wrap-full").removeClass("open-nav");
					$(".body-wrap-full").addClass("close-nav");
				} else {
					$(".body-wrap-full").addClass("open-nav");
					$(".body-wrap-full").removeClass("close-nav");
				}
			});
			
			// body click box closed
			$('body').mouseup(function(e){
				var editColorBtn = $(e.target).hasClass("edit-color-btn");	// 프로젝트 컬러 설정 버튼
				var hideItem = $(".edit-color-box");
				
				// 선택(target)한 element가 특정 클래스를 가지고있지 않을 때만, hide() 처리
				if(!editColorBtn){
					hideItem.hide();
				}
			});
			
		});
		
		</script>
		
		<!-- go to top -->
		<a href="#goTop" id="gotoTop"><i class="fas fa-arrow-circle-up size-50 color-black"></i></a>
		
		<!-- alert custom -->
		<div class="alert flowolf-alert"></div>
		
		<!-- bootstrap JS -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	</body>
</html>