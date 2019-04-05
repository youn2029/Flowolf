<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

			
<!-- top chat tab(상단 채팅 탭메뉴):s -->
<div class="top-wrap">

	<ul class="chat-drop-left float-left">
		<li data-id="chat-tab-1" class="active">채팅</li>
		<li data-id="chat-tab-2">동료</li>
		<li data-id="chat-tab-3">프로젝트</li>
	</ul>
	
	<ul class="chat-drop-right float-right">
		<li>
			<i class="flow-icon icon-chat-plus cursor-point chat-create"></i>
		</li>
	</ul>
</div>
<!-- top chat tab(상단 채팅 탭메뉴):f -->

<!-- 공통
<div class="top-wrap">
	<ul class="top">
		<li class="top-left">
			<a href="#" class="chat-btn">채팅</a> 
			<a href="#" class="ptn-btn">동료</a> 
			<a href="#" class="pro-btn">프로젝트참여자</a>
		</li>
		<li class="top-right">
			<a href="#" class="top-right-f"> 
				<img src="/image/alr_icon.png">
			</a> 
			<a href="#" class="top-right-s"> 
				<img src="/image/chat_plus_icon.png" class="chat-create">
			</a>
		</li>
	</ul>
</div> -->


<!-- tab content : 채팅 : s -->
<div id="chat-tab-1" class="chat-tab-content active">

	<!-- chat form : s -->
	<form name="chatFrm" id="chatFrm" action="/chat/detail" class="chat-from">
	
		<!-- chat drop content wrap : s -->
		<div class="chat-drop-con-wrap">
		
			<!-- chat search : s -->
			<div class="chat-search-box chat-search-chk">
				<i class="fas fa-search color-gray"></i>
				<input type="text" class="chat-search-input" placeholder="채팅방 제목검색"
				onkeyup="{ filter(this); return false; }" onkeypress="javascript:if(event.keyCode==13){ filter(this); return false; }">
			</div>
			<!-- chat search : f -->
		
			<!-- chat box wrap : s -->
			<div class="chat-box-wrap" data-simplebar>
			
				<!-- chat box basic : s -->
				<div class="chat-box-basic">
					<c:forEach items="${getChatList }" var="list">
					<div class="chat-box cursor-point" data-number="${list.in_mem_num }" data-name="${list.chat_title }" data-chat_no="${list.chat_no }" 
					data-mem_nick="${memVo.mem_nick }" data-ip="${list.chat_ip }">
					
						<!-- 참여자가 3명 이상이면 채팅리스트 프로필사진 다수 아이콘으로 변경 -->
						<div class="profile-img" id="room${list.chat_no }" data-ptn-id="${list.ptn_id }" data-mem-id="${list.mem_id }">
							<i class="icon-circle circle-s cursor-point"></i>
							<img src="" width="40">
						</div>
						
						<div class="chat-info-box chat_room">
							<div id="chat${list.chat_no }" class="chat-id dis-block">
								<span class="dis-inblock size-16 color-black">${list.chat_title }</span>
							</div>
							<span class="chat-cont martop-5 size-14 color-gray">${list.chat_cont }</span>
							<span class="chat-date dis-block martop-10 size-14 color-gray-l">${list.chat_con_time }</span>
						</div>
					</div>
					</c:forEach>
					
					<!-- 채팅인원이 2명이상인경우 이부분 -->
					<script type="text/javascript">
					$(function(){
						$(".chat-box").each(function(i, e){
							var num = $(this).attr('data-number');
							var profileImg = $(this).find('.profile-img');
							var ptnId = profileImg.attr('data-ptn-id');
							var memId = profileImg.attr('data-mem-id');
							
							var people = "/image/chat-people-icon.png";		// 여러명
							var user = "/mem/pic?mem_id=" + ptnId;	// 상대방
							var mine = "/mem/pic?mem_id=" + memId;	// 나일 경우
							var peopleNum = "<span class='in_mem_num'><i class='fas fa-user maright-5'></i>" + num + "</span>";
							
							if(num > 2) {
								$(".chat-box").eq(i).find('.profile-img').children('img').attr('src', people);
								$(".chat-box").eq(i).find('.chat-id').append(peopleNum);
							} else if(num == 1) {
								$(".chat-box").eq(i).find('.profile-img').children('img').attr('src', mine);
							} else {
								$(".chat-box").eq(i).find('.profile-img').children('img').attr('src', user);
							}
						});
					});
					</script>
					
				</div>
				<!-- chat box basic : f -->
				
				<input type="hidden" name="chat_no" id="chat_no">
				<input type="hidden" name="mem_id0" id="mem_id0">
				<input type="hidden" name="mem_nick" id="mem_nick">
				<input type="hidden" name="chat_ip" id="chat_ip">
			</div>
			<!-- chat box wrap : s -->
				
		</div>
		<!-- chat drop content wrap : f -->
		
	</form>
	<!-- chat form : f -->
</div>
<!-- tab content : 채팅 : f -->


<!-- tab content : 동료(파트너) : s -->
<div id="chat-tab-2" class="chat-tab-content">

	<!-- chat insert form : s -->
	<form name="chatInsert" action="/chat/insert" class="ptn-from">
	
		<!-- chat drop content wrap : s -->
		<div class="chat-drop-con-wrap">
		
			<!-- chat search : s -->
			<div class="chat-search-box ptn-search-chk">
				<i class="fas fa-search color-gray"></i>
				<input type="text" class="chat-search-input" placeholder="이메일, 닉네임 검색"
				onkeyup="{ filter(this); return false; }" onkeypress="javascript:if(event.keyCode==13){ filter(this); return false; }">
			</div>
			<!-- chat search : f -->
			
			<!-- chat box wrap : s -->
			<div class="chat-box-wrap" data-simplebar>
			
				<!-- my profile : s -->
				<div class="chat-profile-wrap my-profile">
					<p class="marbtm-10 size-15 color-black">내 프로필</p>
					
					<div class="chat-profile-box">
						<!-- my profile image -->
						<a href="#profileMyPopup" class="chat-profile-img my-pop"> 
							<i class="icon-circle circle-s"></i>
							<img src="/mem/pic?mem_id=${memVo.mem_id}" onerror="this.src='/image/user-pic-sample.png'" width="40"/>
						</a>
						
						<!-- my profile info -->
						<div class="chat-profile-info">
							<strong class="size-18 color-black">${memVo.mem_nick}</strong>
							<i class="far fa-comment size-28 color-gray cursor-point" data-chat_title="${memVo.mem_nick}"></i>
						</div>
					</div>
				</div>
				<!-- my profile : f -->
				
				<!-- friend profile : s -->
				<div class="chat-profile-wrap friend-profile" id="friend-box-ptn">
					<p class="marbtm-10 size-15 color-black">전체 연락처</p>
					
					<c:forEach items="${ptnMyList }" var="list">
					<div class="chat-profile-box friend-list" data-id="${list.mem_id }" data-name="${list.mem_nick}">
					
						<!-- profile image -->
						<a href="#ptnPopup" class="chat-profile-img ptn-pop" data-id="${list.mem_id }"> 
							<i class="icon-circle circle-s"></i>
							<img src="/mem/pic?mem_id=${list.mem_id}" onerror="this.src='/image/user-pic-sample.png'" width="40"/>
						</a>
						
						<!-- profile info -->
						<div class="chat-profile-info">
							<span class="dis-block size-15 color-black">${list.mem_nick}</span>
							<span class="dis-block size-13 color-gray chat-ptn-id">${list.mem_id }</span>
							<i class="far fa-comment size-28 color-gray cursor-point" data-chat_title="${list.mem_nick}" data-ptn_id="${list.mem_id }"></i>
						</div>
						
					</div>
					</c:forEach>
					
					<c:forEach items="${memAllList }" var="list">
					<div class="chat-profile-box all-mem-list" data-id="${list.mem_id }" data-name="${list.mem_nick}" style="display:none;">
					
						<!-- profile image -->
						<a href="#ptnPopup" class="chat-profile-img ptn-pop" data-id="${list.mem_id }"> 
							<i class="icon-circle circle-s"></i>
							<img src="/mem/pic?mem_id=${list.mem_id}" onerror="this.src='/image/user-pic-sample.png'" width="40"/>
						</a>
						
						<!-- profile info -->
						<div class="chat-profile-info">
							<span class="dis-block size-15 color-black">${list.mem_nick}</span>
							<span class="dis-block size-13 color-gray">${list.mem_id }</span>
							<i class="far fa-comment size-28 color-gray cursor-point" data-chat_title="${list.mem_nick}" data-ptn_id="${list.mem_id }"></i>
						</div>
					</div>
					</c:forEach>
				</div>
				<!-- friend profile : f -->
				
				<input type="hidden" name="mem_id" id="mem_id">
				<input type="hidden" name="chat_title" id="chat_title">
				<input type="hidden" name="ptn_id" id="ptn_id">
			</div>
			<!-- chat box wrap : f -->
			
		</div>
		<!-- chat drop content wrap : f -->
		
	</form>
	<!-- chat insert form : f -->
	
</div>
<!-- tab content : 동료(파트너) : f -->


<!-- tab content : 프로젝트 참여자들 : s -->
<div id="chat-tab-3" class="chat-tab-content">

	<!-- chat drop content wrap : s -->
	<div class="chat-drop-con-wrap">
		
		<!-- chat search : s -->
		<div class="chat-search-box pro-search-chk">
			<i class="fas fa-search color-gray"></i>
			<input type="text" class="chat-search-input" placeholder="이메일, 닉네임 검색"
			onkeyup="{ filter(this); return false; }" onkeypress="javascript:if(event.keyCode==13){ filter(this); return false; }">
		</div>
		<!-- chat search : f -->
			
		<!-- chat box wrap : s -->
		<div class="chat-box-wrap" data-simplebar>
				
			<!-- project user profile : s -->
			<div class="chat-profile-wrap friend-profile" id="friend-box-ptn">
				<p class="marbtm-10 size-15 color-black">전체 연락처</p>
				
				<c:forEach items="${getMemProUserList }" var="list">
				<div class="chat-profile-box friend-list" data-id="${list.mem_id }" data-name="${list.mem_nick}">
				
					<!-- profile image -->
					<a href="#proPopup" class="chat-profile-img pro-pop" data-id="${list.mem_id }"> 
						<i class="icon-circle circle-s"></i>
						<img src="/mem/pic?mem_id=${list.mem_id}" onerror="this.src='/image/user-pic-sample.png'" width="40"/>
					</a>
					
					<!-- profile info -->
					<div class="chat-profile-info">
						<span class="dis-block size-15 color-black">${list.mem_nick}</span>
						<span class="dis-block size-13 color-gray">${list.mem_id }</span>
						<i class="far fa-comment size-28 color-gray cursor-point" data-pro_title="${list.mem_nick }" data-pro_id="${list.mem_id }"></i>
					</div>
					
				</div>
				</c:forEach>
			</div>
			<!-- project user profile : f -->
			
		</div>
		<!-- chat box wrap : f -->
		
	</div>
	<!-- chat drop content wrap : f -->
		
	
</div>
<!-- tab content : 프로젝트 참여자들 : f -->
	
	
<script type="text/javascript">
	$(function(){
		
		// 채팅 탭메뉴 설정 : 탭메뉴(li)에 설정된 data-id 값과 같은 id값을 가진 content box 노출
		$("ul.chat-drop-left li").on("click", function(){
			var tab_id = $(this).attr("data-id");
			$("ul.chat-drop-left li").removeClass("active");
			$(".chat-tab-content").removeClass("active");
			
			$(this).addClass("active");
			$("#"+tab_id).addClass("active");
		});
	
		// 채팅 알림설정 버튼
		$(".chat-alim-btn").on("click", function(){
			var item = $(this);
			var icon = item.children("i");
			var text = item.children("span");
			if(icon.hasClass("fa-bell")){
				icon.removeClass("fa-bell");
				icon.addClass("fa-bell-slash");
				text.html("알람꺼짐");
			} else {
				icon.removeClass("fa-bell-slash");
				icon.addClass("fa-bell");
				text.html("알람켜짐");
			}
		});
		
	});
	
	// 채팅 내용 등록시 채팅 리스트 새로 조회 
	function search(){
		$.ajax({
			url : "/chat/search", //조회하는 메서드
			method : "POST",
			dataType : "json", // server로 부터 받을 data type
			data : { mem_id:"${memVo.mem_id}" },
			success : function(data) {
				var str = "";
				
				for(var i=0; i<data.getChatList.length; i++){
					str += "<div id=\"chat_no" + data.getChatList[i].chat_no + "\" class=\"chat-box cursor-point\" data-name=\"" + data.getChatList[i].chat_title + "\" data-chat_no=\"" + data.getChatList[i].chat_no + "\" data-mem_nick=\"${memVo.mem_nick }\" data-ip=\"" + data.getChatList[i].chat_ip + "\">";
					
						str += "<div class=\"profile-img\" id=\"room" + data.getChatList[i].chat_no+"\">";
							str += "<i class=\"icon-circle circle-s cursor-point\"></i>";
							if(data.getChatList[i].in_mem_num > 2) {
								str += "<img src=\"/image/chat-people-icon.png\"/ width=\"40\">";
							} else if(data.getChatList[i].in_mem_num == 1) {
								str += "<img src=\"/mem/pic?mem_id="+data.getChatList[i].mem_id+"\" width=\"40\">";
							}else{
								str += "<img src=\"/mem/pic?mem_id="+data.getChatList[i].ptn_id+"\" width=\"40\">";
							}
						str += "</div>";
					
						str += "<div class=\"chat-info-box chat_room\">";
							str += "<div class=\"chat-id dis-block\">";
								str += "<span class=\"dis-inblock size-16 color-black\">" +data.getChatList[i].chat_title + "</span>";
						
								if(data.getChatList[i].in_mem_num > 2){
									str += "<span class=\"in_mem_num\"><i class=\"fas fa-user maright-5\"></i>" + data.getChatList[i].in_mem_num + "</span>";
								}
						
							str += "</div>";
							str += "<span class=\"chat-cont martop-5 size-14 color-gray\">" + data.getChatList[i].chat_cont + "</span>";
							str += "<span class=\"chat-date dis-block martop-10 size-14 color-gray-l\">" + data.getChatList[i].chat_con_time + "</span>";
						str += "</div>";
					str += "</div>";
				}
				
				$(".chat-box-basic").html(str);
			},
			error : function(error) {
			}
		});
	};
	
	var mem_id = "${memVo.mem_id}"; //내 아이디
	
	// 동료에서 채팅아이콘 클릭시
	$("#chat-tab-2 .chat-profile-info i.fa-comment").on("click", function(){
		$("#mem_id").val(mem_id);
		$("#chat_title").val($(this).data("chat_title"));
		$("#ptn_id").val($(this).data("ptn_id"));
		
		var check = document.chatInsert;
		window.open('', "new", "width=467,height=640,top=100,left=100");
		check.action='/chat/insert';
		check.target='new';
		check.submit();
	});
	
	// 프로젝트참여자서 채팅아이콘 클릭시
	$("#chat-tab-3 .chat-profile-info i.fa-comment").on("click", function(){
		$("#mem_id").val(mem_id);
		$("#chat_title").val($(this).data("pro_title"));
		$("#ptn_id").val($(this).data("pro_id"));
		
		var check = document.chatInsert;
		window.open('', "new", "width=467,height=640,top=100,left=100");
		check.action='/chat/insert';
		check.target='new';
		check.submit();
	});
	
	// 초대
	$(".chat-create").on("click", function(){
		window.open("/chat/createChat", "new", "width=467,height=650,top=100,left=100");
	});
	
	// 채팅 박스 클릭시
	$(document).on('click', '.chat-box', function(){ 
		$("#chat_no").val($(this).data("chat_no"));
		$("#mem_nick").val($(this).data("mem_nick"));
		$("#chat_ip").val($(this).data("ip"));
		$("#mem_id0").val(mem_id);
		
		var check =document.chatFrm;
		window.open('', 'new', "width=467,height=640,top=100,left=100");
		check.action='/chat/detail';
		check.target='new';
		check.submit();
	});
	
	// 내 프로필 클릭시 팝업
	$(".my-pop").click(function() {
		var mem_id = "${memVo.mem_id}";
		$.ajax({
			url : "/chat/pop",
			method : "POST",
			dataType : "json", // server로 부터 받을 data type
			data : {mem_id : mem_id},
			success : function(data) {
				if (data) {
					$("#profileMyPopup .flnm").text(data.mem_nick);
					$("#profileMyPopup .cmnm").text(data.mem_id);
					$("#profileMyPopup .phone").text(data.mem_phone);
					layer_popup("#profileMyPopup"); 
				} else {
					alert("해당 회원이 존재하지 않습니다.");
				}
			},
			error : function(error) {
				alert("error");
			}
		});
	});
	
	// 파트너 프로필 클릭시 팝업
	$(".ptn-pop").click(function() {
		var mem_id = $(this).data("id");
		var my_id = "${memVo.mem_id}";
		var src = $(this).children("img").attr("src");
		var item = $(this);
		
		$.ajax({
			url : "/chat/pop2",
			method : "POST",
			dataType : "json", // server로 부터 받을 data type
			data : {mem_id : mem_id, my_id:my_id},
			success : function(data) {
				if (data) {
					$("#ptnPopup .flnm").text(data.memVo.mem_nick);
					$("#ptnPopup .cmnm").text(data.memVo.mem_id);
					$("#ptnPopup .phone").text(data.memVo.mem_phone);
					$("#ptnPopup .my_id").text(data.my_id);
					$("#ptnPopup .pop-pic img").attr('src', src);
					
					layer_popup("#ptnPopup");
					
					// 이미 동료사이일 때, '친구신청' 버튼 가리기
					$("#chat-tab-2").find(".friend-list").each(function(i, e){
						
						if($("#chat-tab-2").find(".friend-list").eq(i).find(".chat-ptn-id").text() == $("#ptnPopup .cmnm").text()){
							$("#ptnPopup #apply-btn-ptn").hide();
							return false;
						} else {
							$("#ptnPopup #apply-btn-ptn").show();
						}
					});
					
					
				} else {
					alert("해당 회원이 존재하지 않습니다.");
				}
			},
			error : function(error) {
				alert("error");
			}
		});
	});
	
	// 프로젝트 참여자 프로필 클릭시 팝업
	$(".pro-pop").click(function() {
		var mem_id = $(this).data("id");
		var my_id = "${memVo.mem_id}";
		var src = $(this).children("img").attr("src");
		
		$.ajax({
			url : "/chat/pop2",
			method : "POST",
			dataType : "json", // server로 부터 받을 data type
			data : {mem_id : mem_id, my_id:my_id},
			success : function(data) {
				if (data) {
					$("#proPopup .flnm").text(data.memVo.mem_nick);
					$("#proPopup .cmnm").text(data.memVo.mem_id);
					$("#proPopup .phone").text(data.memVo.mem_phone);
					$("#proPopup .my_id").text(data.my_id);
					$("#proPopup .pop-pic img").attr('src', src);
					layer_popup("#proPopup"); 
				} else {
					alert("해당 회원이 존재하지 않습니다.");
				}
			},
			error : function(error) {
				alert("error");
			}
		});
	});
</script>


