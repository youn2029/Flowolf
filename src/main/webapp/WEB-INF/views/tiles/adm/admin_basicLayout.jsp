<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maxium-scale=1.0, minimum-scale=1.0, width=device-width"/>
		<title>FLOWOLF ADMIN</title>
		
		<!-- font-awesome CSS -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
		
		<!-- KAKAO login JS -->
		<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
		
		<!-- bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		
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
		
		<!-- FLOWOLF CUSTOM JS -->
		<script src="<%=request.getContextPath() %>/js/flowolf_custom.js"></script>
		
		<!-- datepicker CSS & JS -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/datepicker.min.css">
		<script src="<%=request.getContextPath() %>/js/datepicker.min.js"></script>
		<script src="<%=request.getContextPath() %>/js/datepicker.en.js"></script>
		<script src="<%=request.getContextPath() %>/js/datepicker.ko.js"></script>

		<!-- swiper CSS & JS -->		
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/swiper.min.css">
		<script src="<%=request.getContextPath() %>/js/swiper.min.js"></script>
		
		<!-- Chart JS -->
		<script src="<%=request.getContextPath() %>/js/utils.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
		
		<!-- custom style -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_color.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_font.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_margin.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_padding.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_admin.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_post.css">
		
	</head>
	<body>
		
		<div class="body-wrap-full admin-body-wrap">
			<div class="container">
			
				<!-- admin_top.jsp -->
				<tiles:insertAttribute name="top"/>
	
				<!-- admin_aside.jsp -->
				<tiles:insertAttribute name="aside"/>
				
				<!-- contents -->
				<tiles:insertAttribute name="content"/>
				
				<!-- layer pop up contents -->
				<%@include file="/WEB-INF/views/tiles/layerPopCon.jsp" %>
				
			</div>
		</div>
		
		<div class="alert flowolf-alert"></div>
		
		<!-- bootstrap JS -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	</body>
</html>