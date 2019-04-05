<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		<!-- font-awesome CSS -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
		
		<!-- custom style -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_color.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_font.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_margin.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_padding.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_chat_icon_popup.css">
		
		<!-- jQuery 3.3.1 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<!-- FLOWOLF CUSTOM JS -->
		<script src="<%=request.getContextPath() %>/js/flowolf_custom.js"></script>
		
		<!-- scroll custom CSS & JS -->
		<link rel="stylesheet" href="https://unpkg.com/simplebar@latest/dist/simplebar.min.css" />
		<script src="https://unpkg.com/simplebar@latest/dist/simplebar.js"></script>
		
		<style type="text/css">
		body {overflow:hidden;background-color:#fff}
		.create-chat-wrap {position:relative}
		.create-chat-wrap .chat-box-wrap {height:390px}
		
		/* header */
		header.creat-chat-head {display:block;float:left;width:100%}
		header.creat-chat-head .head-title {width:100%;height:50px;font-weight:bold;font-size:15px;color:#fff;line-height:50px;text-align:center}
		header.creat-chat-head ul.head-tab {width:100%;margin:0}
		header.creat-chat-head ul.head-tab li {
			float:left;
			width:50%;
			height:50px;
			font-size:15px;
			color:#999;
			line-height:50px;
			text-align:center;
			background-color:#ddd;
			cursor:pointer
		}
		header.creat-chat-head ul.head-tab li.active {font-weight:bold;color:#746fcc;background-color:#fff}
		
		/* contents */
		section.creat-chat-con {display:none;float:left;width:100%;height:auto;padding:20px}
		section.creat-chat-con.active {display:inherit}
		
		/* button */
		.creat-btn-box {position:fixed;left:0;right:0;bottom:0;padding:15px 0;text-align:center;border-top:1px solid #ccc}
		.creat-btn-box input[type=button],
		.creat-btn-box input[type=submit] {padding:7px 16px;color:#666;border:1px solid #ddd;border-radius:5px;cursor:pointer}
		.creat-btn-box input[type=submit] {margin-left:10px;border:0}
		</style>
	</head>
	
	<body>
	
		<!-- create chat wrap : s -->
		<div class="create-chat-wrap">
		
			<!-- create chat header : s -->
			<header class="creat-chat-head">
				<!-- title -->
				<div class="head-title back-color-pupple-l">대화상대 초대</div>
				
				<!-- tab navigation -->
				<ul class="head-tab">
					<li data-id="creat-tab-1" class="active">동료</li>
					<li data-id="creat-tab-2">프로젝트 참여자</li>
				</ul>
			</header>
			
			<!-- 동료 tab content : s -->
			<section id="creat-tab-1" class="creat-chat-con active">
		
				<!-- chat search : s -->
				<div class="chat-search-box creat-ptn-search-chk">
					<i class="fas fa-search color-gray"></i>
					<input type="text" class="chat-search-input" placeholder="이메일, 닉네임 검색"
					onkeyup="{ filter(this); return false; }" onkeypress="javascript:if(event.keyCode==13){ filter(this); return false; }">
				</div>
				<!-- chat search : f -->
			
				<form action="/chat/insertMulti" method="get" id="chatInsertMulti" name="chatInsertMulti">
				
					<!-- chat box wrap : s -->
					<div class="chat-box-wrap" data-simplebar>
					
					
						<!-- friend profile : s -->
						<div class="chat-profile-wrap friend-profile" id="friend-box-ptn">
							
							<c:forEach items="${ptnMyList }" var="list" varStatus="status">
							<div class="chat-profile-box friend-list" data-id="${list.mem_id }" data-name="${list.mem_nick}">
							
								<!-- profile image -->
								<a href="#ptnPopup" class="chat-profile-img ptn-pop" data-id="${list.mem_id }"> 
									<i class="icon-circle circle-s"></i>
									<img src="/mem/pic?mem_id=${list.mem_id}" onerror="this.src='/image/user-pic-sample.png'" width="40"/>
								</a>
								
								<!-- profile info -->
								<div class="chat-profile-info">
									<span class="dis-block size-15 color-black">${list.mem_nick}</span>
									<span class="dis-block size-13 color-gray">${list.mem_id }</span>
									<input type="checkbox" id="ptn_${status.count }" name="ptn" value="${list.mem_id }" onchange="fn_chatInviteChk(this)" class="dis-none invite-chk-btn">
									<label for="ptn_${status.count }" class="crateChatLabel"></label>
								</div>
								
							</div>
							</c:forEach>
						</div>
						<!-- friend profile : f -->
							
					</div>
					<!-- chat box wrap : f -->
						
					<input type="hidden" id="mem_id" name="mem_id" value="${memVo.mem_id }">
					<div class="creat-btn-box">
						<input type="button" value="취소" onclick="fn_chatInviteCancel()" class="color-black back-color-white">
						<input type="submit" value="초대" class="color-white back-color-pupple-l">
					</div>
				
				</form>
				
			</section>
			<!-- 동료 tab content : f -->
			
			
			<!-- 프로젝트 참여자 : tab content : s -->
			<section id="creat-tab-2" class="creat-chat-con">
		
				<!-- chat search : s -->
				<div class="chat-search-box creat-pro-search-chk">
					<i class="fas fa-search color-gray"></i>
					<input type="text" class="chat-search-input" placeholder="이메일, 닉네임 검색"
					onkeyup="{ filter(this); return false; }" onkeypress="javascript:if(event.keyCode==13){ filter(this); return false; }">
				</div>
				<!-- chat search : f -->
			
				<form action="/chat/insertMulti" method="get" id="chatInsertMulti" name="chatInsertMulti">
			
					<!-- chat box wrap : s -->
					<div class="chat-box-wrap" data-simplebar>
				
						<!-- friend profile : s -->
						<div class="chat-profile-wrap friend-profile" id="friend-box-ptn">
							
							<c:forEach items="${getMemProUserList }" var="list" varStatus="status">
							<div class="chat-profile-box friend-list" data-id="${list.mem_id }" data-name="${list.mem_nick}">
							
								<!-- profile image -->
								<a href="#ptnPopup" class="chat-profile-img ptn-pop" data-id="${list.mem_id }"> 
									<i class="icon-circle circle-s"></i>
									<img src="/mem/pic?mem_id=${list.mem_id}" onerror="this.src='/image/user-pic-sample.png'" width="40"/>
								</a>
								
								<!-- profile info -->
								<div class="chat-profile-info">
									<span class="dis-block size-15 color-black">${list.mem_nick}</span>
									<span class="dis-block size-13 color-gray">${list.mem_id }</span>
									<input type="checkbox" id="pro_${status.count }" name="ptn" value="${list.mem_id }" onchange="fn_chatInviteChk(this)" class="dis-none invite-chk-btn">
									<label for="pro_${status.count }" class="crateChatLabel"></label>
								</div>
								
							</div>
							</c:forEach>
						</div>
						<!-- friend profile : f -->
						
					</div>
					<!-- chat box wrap : f -->
						
					<input type="hidden" id="mem_id" name="mem_id" value="${memVo.mem_id }">
					<div class="creat-btn-box">
						<input type="button" value="취소" onclick="fn_chatInviteCancel()" class="color-black back-color-white">
						<input type="submit" value="초대" class="color-white back-color-pupple-l">
					</div>
				
				</form>
				
			</section>
			<!-- 프로젝트 참여자 : tab content : f -->
	
		</div>
		<!-- create chat wrap : f -->
		
		<script type="text/javascript">
		
		// 인원 count
		var defaultCnt = 0;
		
		$(function(){
			
			// 채팅 탭메뉴 설정 : 탭메뉴(li)에 설정된 data-id 값과 같은 id값을 가진 content box 노출
			$("ul.head-tab li").on("click", function(){
				var tab_id = $(this).attr("data-id");
				$("ul.head-tab li").removeClass("active");
				$(".creat-chat-con").removeClass("active");
				
				$(this).addClass("active");
				$("#"+tab_id).addClass("active");
				
				// checkbox reset
				defaultCnt = 0;
				$("input[type=checkbox]").prop("checked", false);
				$("input[type=submit]").val("초대");
			});
		});
		
		// input checkbox clicked
		function fn_chatInviteChk(el){
			var item = $(el);
			var form = item.parents('#chatInsertMulti');
			var submit = form.find('input[type=submit]');
			
			if(item.is(':checked')){
				defaultCnt += 1;
				submit.val(defaultCnt + "명 초대");
			} else {
				defaultCnt -= 1;
				submit.val("초대");
			}
		}
		
		// input button(cancel) clicked
		function fn_chatInviteCancel(){
			window.close();
		}
		</script>
				
	</body>
</html>