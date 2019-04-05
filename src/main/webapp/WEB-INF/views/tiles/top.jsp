<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<header id="goTop" class="head-top">

	<!-- logo -->
	<div class="logo"><a href="/pro/main"><img src="<%=request.getContextPath() %>/image/logo.png"></a></div>
	
	<!-- other icon navigation:s -->
	<div class="float-right">
		<div class="top-icon-nav">
			<!-- icon navigation list -->
			<ul class="icon-nav-list">
				<!-- 검색보류 <li><a href="#searchBox" class="top-icon flow-icon icon-search"></a></li> -->
				<li><a href="/post/list?post_kind=notice" class="top-icon flow-icon icon-mark"></a></li>
				<li><a href="/post/list?post_kind=qa" class="top-icon flow-icon icon-question"></a></li>
				<li class="chat-ptn cursor-point"><i class="top-icon flow-icon icon-comment"></i></li>
				<li>
					<!-- alim btn -->
					<a id="alimToggle" class="top-icon flow-icon icon-bell cursor-point" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
					
					<!-- alim content box:s -->
					<div class="dropdown-menu alim-con-box" aria-labelledby="alimToggle">
						<div style="display:flex;overflow:auto;height:100%" data-simplebar>
							<c:forEach items="${alimList }" var="list">
								<c:choose>
									<c:when test="${list.ptn_no != null && list.accept_date == null }">
									<dl class="cursor-point no-check alim-pop" data-alim_no="${list.alim_no }" data-apply="${list.apply }" data-ptn_no="${list.ptn_no }" data-alim_no="${list.alim_no }">
										<dt class="posi-re">
											<i class="icon-circle circle-s"></i>
											<img src="/mem/pic?mem_id=${list.apply }" onerror="this.src='/image/user-pic-sample.png'" width="40">
										</dt>
										<dd>
		<!-- 									<div class="dis-block martop-5 font-bold size-18 color-black">친구신청</div> -->
											<div class="dis-block martop-5 size-15 color-black">${list.alim_cont }</div>
											<div class="dis-block size-13 color-gray"><fmt:formatDate value="${list.alim_time }" pattern="yyyy-MM-dd hh:ss"/></div>
										</dd>
									</dl>
									</c:when>
									<c:otherwise>
									<dl class="cursor-point no-check" data-alim_no="${list.alim_no }" data-apply="${list.apply }" data-ptn_no="${list.ptn_no }" data-alim_no="${list.alim_no }">
										<dt class="posi-re">
											<i class="icon-circle circle-s"></i>
											<img src="/mem/pic?mem_id=${list.apply }" onerror="this.src='/image/user-pic-sample.png'" width="40">
										</dt>
										<dd>
		<!-- 									<div class="dis-block martop-5 font-bold size-18 color-black">친구신청</div> -->
											<div class="dis-block martop-5 size-15 color-black">${list.alim_cont }</div>
											<div class="dis-block size-13 color-gray"><fmt:formatDate value="${list.alim_time }" pattern="yyyy-MM-dd hh:ss"/></div>
										</dd>
									</dl>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</div>
					<!-- alim content box:f -->
				</li>
				<li>
					<!-- user info btn:s -->
					<div id="userInfo" class="martop-8 cursor-point" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<div class="posi-re dis-inblock maright-10">
							<i class="icon-circle circle-xs"></i>
							<img src="/mem/pic?mem_id=${memVo.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="24">
						</div>
						<span class="dis-inblock maright-20 size-16 color-gray">${memVo.mem_nick }</span>
						<i class="fas fa-caret-down color-gray"></i>
					</div>
					<!-- user info btn:f -->
					
					<!-- user info box:s -->
					<div class="dropdown-menu user-info-box" aria-labelledby="userInfo">
						<div class="posi-re user-info-photo">
							<i class="icon-circle circle-m"></i>
							<img src="/mem/pic?mem_id=${memVo.mem_id }" width="60">
						</div>
						<ul class="dis-block martop-10 marbtm-15 padbtm-15 text-center" style="border-bottom:1px solid #ccc">
							<li class="size-18 color-black">${memVo.mem_nick }</li>
							<li class="size-16 color-gray">${memVo.mem_id }</li>
						</ul>
						<ul class="user-info-nav">
							<li><a href="/mem/memEdit"><i class="float-left maright-10 flow-icon top-icon icon-gear"></i>환경설정</a></li>
							<li><a class="logout" style="cursor:pointer;"><i class="float-left maright-10 flow-icon top-icon icon-out"></i>로그아웃</a></li>
						</ul>
					</div>
					<!-- user info box:f -->
				</li>
			</ul>
			
			<!-- 송희 추가 : 채팅 아이콘  클릭시 나오는 팝업부분 : s -->
			<div class="chat-ptn-wrap" style="display: none">
				<%@include file="/include/top_chat_drop_box.jsp" %>
			</div>
			<!-- 송희 추가 : 채팅 아이콘  클릭시 나오는 팝업부분 : f -->
			
		</div>
	</div>
	<!-- other icon navigation:f -->


	<!-- search form:s -->
	<div class="search-box">
		<form name="" action="">
			<div class="col-sm-3 col-md-2 col-lg-2">
				<select name="">
					<option value="all" selected>ALL</option>
					<option value="project">프로젝트</option>
					<option value="article">글</option>
					<option value="people">참여자</option>
				</select>
			</div>
			<div class="posi-re col-sm-9 col-md-10 col-lg-10 padleft-50">
				<input type="text" name="" class="col-md-10 search-input" placeholder="검색할 내용을 입력하세요">
				<button type="submit" class="search-icon">search</button>
				<button type="button" class="close-icon">close</button>
			</div>
		</form>
	</div>
	<!-- search form:f -->
	
	<!-- logout form:s -->
	<form action="/login/logout" id="logout" method="get"></form>
	<div class="g-signin2 martop-10 dis-none border-box" data-onsuccess="onSignIn" data-width="378" data-height="60" style="border:1px solid #ddd;"></div>
	<!-- logout form:f -->
	
	<script type="text/javascript">
	$(function(){
		// search box open
		$(".icon-search").on("click", function(){
			$(".search-box").slideDown();
			$(".search-input").focus();
		});
		
		// search box close
		$(".close-icon").on("click", function(){
			$(".search-box").slideUp();
			$(".search-input").val();
		});
		
		// chat drop box slideUp & Down
		// : 채팅아이콘 클릭시 채팅 메뉴박스 보이기
		$(".chat-ptn").on("click", function(){
			if($(".chat-ptn-wrap").css("display") == "none"){
				$(".chat-ptn-wrap").slideDown();
			} else {
				$(".chat-ptn-wrap").slideUp();
			}
		});
		
		// logout
		$(".logout").on("click", function(){
			signOut();
			$("#logout").submit();
		});
		
		$("dl.alim-pop").on("click", function(){
			var mem_id = $(this).data("apply");
			var ptn_no = $(this).data("ptn_no");
			var alim_no = $(this).data("alim_no");
			var my_id = "${memVo.mem_id}";
			var src = $(this).children("dt.posi-re").children("img").attr("src");
			
			$.ajax({
				url : "/chat/pop2",
				method : "POST",
				dataType : "json", // server로 부터 받을 data type
				data : {mem_id : mem_id, my_id:my_id},
				success : function(data) {
					if (data) {
						$("#ptnAcceptPopup .flnm").text(data.memVo.mem_nick);
						$("#ptnAcceptPopup .cmnm").text(data.memVo.mem_id);
						$("#ptnAcceptPopup .phone").text(data.memVo.mem_phone);
						$("#ptnAcceptPopup .ptn_no").text(ptn_no);
						$("#ptnAcceptPopup .alim_no").text(alim_no);
						$("#ptnAcceptPopup .pop-pic img").attr('src', src);
						layer_popup("#ptnAcceptPopup"); 
					} else {
						alert("해당 회원이 존재하지 않습니다.");
					}
				},
				error : function(error) {
					alert("error");
				}
			});
			
		});
		
	});
	
	function signOut() {
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signOut().then(function () {
			console.log('User signed out.');			
		});
	}
	
	//longpolling alert
	(function(){
		var poll = function(){
			$.ajax({
				url : '/schd/dbcheck', 	//요청 보내는 url
				type : 'get',			//메서드 타입
				dataType : 'json', 		//서버로부터 되돌려 받는 데이터타입 명시
				data : 
					{
					"member_id" : "${memVo.mem_id }"
					},
				success : function(data){
					if(data.schdVo.length >0){
						var msg = '';
						for(i = 0; i < data.schdVo.length ; i++ ){
							msg += '<br>'+(i+1)+' 번째 일정명 :' +data.schdVo[i].schd_title+'['+data.schdVo[i].schd_start_time+']' ;
						}
						alertCustom2('현재 '+data.schdVo.length+' 개의 미리알림 일정이 있습니다.'+msg, 'alert-warning');
					}
						
				},
				error:function(request, status, error){
					console.log("[ajax error]");
					console.log("code:"+request.status+"\n"+"message : "+request.responseText+"\n"+"error:"+error);
				}
			});	
			
		};
		poll();
		
		setInterval(function(){
// 			poll();
		}, 6000);
		
		setInterval(function(){
// 			search();
		}, 3000);
	})
	();
	
	function alertCustom2(text, className){
		var alertBox = $('.alert');
		
		alertBox.html(text);
		alertBox.addClass(className);
		alertBox.css('margin-left', -(alertBox.outerWidth()/2));
		alertBox.css('color', 'black');
		alertBox.fadeIn();
		setTimeout(function(){alertBox.fadeOut()}, 8000);
	}
		
	</script>
</header>








