<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!-- 이전화면으로 -->
<div class="pro-right-box">
	<a href="/pro/main" class="pro-prev-btn size-18 default-color">
		<i class="fas fa-angle-left maright-15"></i> 이전화면
	</a>
</div>

<!-- 파일함,업무,일정,할일,투표 -->
<div class="pro-right-box martop-15">
	<ul class="pro-gather-nav">
		<li>
			<a href="/files/proFilesBox?pro_no=${proVo.pro_no }">
				<i class="fas fa-download color-blue-l"></i>
				<span class="dis-block size-14 color-gray">파일함</span>
			</a>
		</li>
		<li>
			<a href="/task/proTask">
				<i class="fas fa-laptop colo-green-l"></i>
				<span class="dis-block size-14 color-gray">업무</span>
			</a>
		</li>
		<li>
			<a href="/schd/callSchd">
				<i class="far fa-calendar-alt color-red"></i>
				<span class="dis-block size-14 color-gray">일정</span>
			</a>
		</li>
		<li>
			<a href="#todoOnly" class="pro-todo-only">
				<i class="fas fa-list-ul color-pupple"></i>
				<span class="dis-block size-14 color-gray">할일</span>
			</a>
		</li>
		<li>
			<a href="#voteOnly" class="pro-vote-only">
				<i class="fas fa-check color-orange"></i>
				<span class="dis-block size-14 color-gray">투표</span>
			</a>
		</li>
	</ul>
</div>

<script type="text/javascript">
$(function(){
	// 우측 '할일'모아보기 아이콘 클릭 시
	$(".pro-todo-only").on("click", function(){
		var tabBox = $(".pro-tab-box");			// 상단 탭박스
		var fixBox = $(".top-fixed-article");	// 고정글 박스
		var timelineBox = $(".timeline-box");	// 전체 타임라인 박스
		var collTodoTit = $(".coll-todo-tit");	// '할일'모아보기 제목
		var collVoteTit = $(".coll-vote-tit");	// '투표'모아보기 제목
		var timeTodo = $(".con-todo").parent().parent(".timeline-box");		// '할일'박스
		var timeVote = $(".con-vote").parent().parent(".timeline-box");		// '투표'박스
		
		tabBox.hide();			// 탭박스 가리기
		fixBox.hide();			// 고정글 가리기
		collVoteTit.hide();		// '투표' 모아보기 제목 가리기
		collTodoTit.fadeIn();	// '할일' 모아보기 제목 보이기
		timelineBox.hide();		// 전체 타임라인 박스 가리기
		timeTodo.fadeIn();		// '할일'박스 보이기
		timeVote.hide();		// '투표'박스 가리기
	});
	
	// 우측 '투표'모아보기 아이콘 클릭 시
	$(".pro-vote-only").on("click", function(){
		var tabBox = $(".pro-tab-box");			// 상단 탭박스
		var fixBox = $(".top-fixed-article");	// 고정글 박스
		var timelineBox = $(".timeline-box");	// 전체 타임라인 박스
		var collTodoTit = $(".coll-todo-tit");	// '할일'모아보기 제목
		var collVoteTit = $(".coll-vote-tit");	// '투표'모아보기 제목
		var timeTodo = $(".con-todo").parent().parent(".timeline-box");		// '할일'박스
		var timeVote = $(".con-vote").parent().parent(".timeline-box");		// '투표'박스
		
		tabBox.hide();			// 탭박스 가리기
		fixBox.hide();			// 고정글 가리기
		collVoteTit.fadeIn();	// '투표' 모아보기 제목 보이기
		collTodoTit.hide();		// '할일' 모아보기 제목 가리기
		timelineBox.hide();		// 전체 타임라인 박스 가리기
		timeTodo.hide();		// '할일'박스 가리기
		timeVote.fadeIn();		// '투표'박스 보이기
	});
	
});

// '할일', '투표' 모아보기 제목 클릭시
function fn_collCancel(){
	var timeline = $(".timeline-box");
	var timeTodo = $(".con-todo").parent().parent(".timeline-box");
	var timeVote = $(".con-vote").parent().parent(".timeline-box");
	var timeTodoTit = $(".coll-todo-tit");
	var timeVoteTit = $(".coll-vote-tit");
	var fixBox = $(".top-fixed-article");
	var tabBox = $(".pro-tab-box");

	timeTodo.hide();
	timeVote.hide();
	timeTodoTit.hide();
	timeVoteTit.hide();
	timeline.fadeIn();
	fixBox.fadeIn();
	tabBox.fadeIn();
}
</script>

<!-- 초대하기 button : s -->
<div class="pro-right-box martop-15">
	<a href="#invitePop" class="right-link-btn invite-btn default-back-color color-white">
		<i class="fas fa-user-plus maright-10"></i>초대하기
	</a>
</div>
<!-- 초대하기 button : f -->

<!-- 화상채팅 button : s -->
<div class="pro-right-box martop-15">
	<a href="#faceChatPop" class="right-link-btn face-chat-btn back-color-orange color-white">
		<i class="fas fa-users maright-10"></i>화상회의
	</a>
</div>
<!-- 화상채팅 button : f -->

<!-- 프로젝트 채팅 button : s -->
<div class="pro-right-box martop-15">
	<a class="right-link-btn back-color-green-l color-white" id="proChat" style="cursor:pointer;">
		<i class="fas fa-comments maright-10"></i>프로젝트 채팅
	</a>
</div>
<!-- 프로젝트 채팅 button : f -->

<!-- 프로젝트 참여자 리스트 : s -->
<div class="pro-right-box pro-right-user-list" data-simplebar>

	<!-- 프로젝트 관리자 : s -->
	<span class="dis-block float-left marbtm-5 padleft-15 padright-15 color-gray size-16">프로젝트 관리자</span>
	<c:forEach items="${proUserList }" var="proUserVo">
		<c:if test="${proUserVo.pro_user_man_chk == 'y' }">
			<dl class="marbtm-0 cursor-point" onclick="fn_openPopup(this)" 
			data-id="${proUserVo.mem_id }" data-nick="${proUserVo.mem_nick }" data-my="${memVo.mem_id }">
				<dt class="posi-re">
					<i class="icon-circle circle-xs cursor-point"></i>
					<img src="/mem/pic?mem_id=${proUserVo.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="24" class="cursor-point">
				</dt>
				<dd>
					<span class="size-18 color-gray">${proUserVo.mem_nick }</span>
					<!-- <i class="far fa-comment size-18 cursor-point"></i> -->
				</dd>
			</dl>
		</c:if>
	</c:forEach>	
	
	<!-- 프로젝트 관리자 : f -->
	
	<!-- 프로젝트 참여자 : s -->
	<span class="dis-block float-left martop-15 marbtm-5 padleft-15 padright-15 color-gray size-16">프로젝트 참여자(${proUserList.size()-1 })</span>
	<c:forEach items="${proUserList }" var="proUserVo">
		<c:if test="${proUserVo.pro_user_man_chk == 'n' }">
			<dl class="marbtm-0 cursor-point" onclick="fn_openPopup(this)" 
			data-id="${proUserVo.mem_id }" data-nick="${proUserVo.mem_nick }" data-my="${memVo.mem_id }">
				<dt class="posi-re">
					<i class="icon-circle circle-xs cursor-point"></i>
					<img src="/mem/pic?mem_id=${proUserVo.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="24" class="cursor-point">
				</dt>
				<dd>
					<span class="size-18 color-gray">${proUserVo.mem_nick }</span>
					<!-- <i class="far fa-comment size-18 cursor-point"></i> -->
				</dd>
			</dl>
		</c:if>
	</c:forEach>	
	<!-- 프로젝트 참여자 : f -->
	
	<form action="/chat/insertMulti" method="get" id="chatInsertMulti" name="chatInsertMulti">
		<c:forEach items="${proUserList }" var="list">
			<c:if test="${list.mem_id ne memVo.mem_id }">
				<input type="hidden" value="${list.mem_id }" name="ptn">
			</c:if>
		</c:forEach>
		<input type="hidden" value="${memVo.mem_id }" name="mem_id">
	</form>
	
	<script type="text/javascript">
		$("#proChat").on("click", function() {
			var check =document.chatInsertMulti;
			window.open('', 'new', "width=467,height=640,top=100,left=100");
			check.action='/chat/insertMulti';
			check.target='new';
			check.submit();
		});
	</script>
	
</div>
<!-- 프로젝트 참여자 리스트 : f -->

<!-- 화상채팅 layer pop up : s -->
<div class="dim-layer">
	<div class="dimBg"></div>
		
		<script type="text/javascript">
		$(function(){
			var mem_id = "${memVo.mem_id}";
			var ip = "${ip}";
			var ipRoom ="${fcVo.fc_ip}";
			var pro_no = ${proVo.pro_no };			
			
			$(".face-chat-btn").on("click", function(){
				if(ipRoom == ''){
					window.open("https://" + ip + ":8443/faceChat/faceChat?ip="+ip+"&mem_id="+mem_id+"&pro_no="+pro_no, "faceChatMake", "width=700,height=700,top=100,left=100");
				}else{
					window.open("https://" + ipRoom + ":8443/faceChat/faceChatRoom?mem_id="+mem_id+"&pro_no="+pro_no, "faceChatRoom", "width=700,height=700,top=100,left=100");
				}
				
			});
			// 화상회의 만들기
			$(".face-chat-make").on("click", function(){				
				
				$.ajax({
					url : "/faceChat/faceChatMake",
					method : "POST",
					dataType : "json", // server로 부터 받을 data type
					data : {fc_ip:ip, pro_no:pro_no, mem_id:mem_id},
					success : function(data) {
						alert("success");
					},
					error : function(error) {
						alert("error");
					}
				});
				
				window.open("https://" + ip + ":8443/faceChat/faceChat?ip="+ip+"&mem_id="+mem_id+"&pro_no="+pro_no, "faceChatMake", "width=1000,height=1000,top=100,left=100");
				
			});
			
			// 화상회의 참여하기
			$(".face-chat-room").on("click", function(){
				window.open("https://" + ipRoom + ":8443/faceChat/faceChatRoom?mem_id="+mem_id+"&pro_no="+pro_no, "faceChatRoom", "width=1000,height=1000,top=100,left=100");
			});
		});
		</script>
<!-- 	</div> -->

</div>
<!-- 화상채팅 layer pop up : f -->

<!-- 초대하기  layer pop up : s -->
<div class="dim-layer">
	<div class="dimBg"></div>
		
	<div id="invitePop" class="pop-layer">
	
   		<!-- pop header -->
   		<header class="pop-top border-box text-center">
   			<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
   			<strong class="dis-block size-28 color-black text-center">프로젝트 제목</strong>
   		</header>
   		
		<!-- pop con -->
   		<section class="pop-con border-box">
   		
   			<div class="invite-kind-box back-color-white cursor-point" data-id="invitePartner" onclick="fn_subPopOpen(this)">
   				<dl>
   					<dt class="maright-20 padtop-5 back-color-green-l"><i class="fas fa-building size-30 color-white"></i></dt>
   					<dd>
		   				<strong class="dis-block size-24 color-black">동료 초대</strong>
		   				<strong class="dis-block size-18 color-gray-l">동료를 초대할 수 있습니다.</strong>
   					</dd>
   				</dl>
   			</div>
   			
   			<div class="invite-kind-box back-color-white cursor-point martop-15" data-id="inviteProjectMem" onclick="fn_subPopOpen(this)">
   				<dl>
   					<dt class="maright-20 padtop-5 back-color-pupple-l"><i class="fas fa-users size-30 color-white"></i></dt>
   					<dd>
		   				<strong class="dis-block size-24 color-black">프로젝트 참여자</strong>
		   				<strong class="dis-block size-18 color-gray-l">프로젝트를 함께 했던 사람을 초대할 수 있습니다.</strong>
   					</dd>
   				</dl>
   			</div>
   			<div class="invite-kind-box back-color-white cursor-point martop-15" data-id="inviteEmail" onclick="fn_subPopOpen(this)">
   				<dl>
   					<dt class="maright-20 padtop-5 back-color-orange"><i class="fas fa-envelope size-30 color-white"></i></dt>
   					<dd>
		   				<strong class="dis-block size-24 color-black">이메일로 초대장 발송</strong>
		   				<strong class="dis-block size-18 color-gray-l">초대장을 이메일로 발송할 수 있습니다</strong>
   					</dd>
   				</dl>
   			</div>
   			<div class="invite-kind-box back-color-white cursor-point martop-15" onclick="copyToClipboard('http://localhost:8180/proUser/copyTo?pro_no=${proVo.pro_no }&mem_id=${memVo.mem_id }')">
   				<dl>
   					<dt class="maright-20 padtop-5 back-color-red"><i class="fas fa-link size-30 color-white"></i></dt>
   					<dd>
		   				<strong class="dis-block size-24 color-black">초대 링크</strong>
		   				<strong class="dis-block posi-re size-18 color-gray-l">
		   					<span>https://localhost:8180/proUser/copyTo</span>
		   					<i class="fas fa-clone cursor-point" onclick="copyToClipboard('http://localhost:8180/proUser/copyTo?pro_no=${proVo.pro_no }&mem_id=${memVo.mem_id }')"></i>
		   				</strong>
   					</dd>
   				</dl>
   			</div>
		</section>
		
		<!-- 동료초대 :s -->
		<div id="invitePartner" class="popup-sub-box">
			<%@include file="/include/pop_invite_partner.jsp" %>
		</div>
		<!-- 동료초대 :f -->
		
		<!-- 프로젝트 참여자 초대 :s -->
		<div id="inviteProjectMem" class="popup-sub-box">
			<%@include file="/include/pop_invite_proMem.jsp" %>
		</div>
		<!-- 프로젝트 참여자 :f -->
		
		<!-- 이메일 초대 :s -->
		<div id="inviteEmail" class="popup-sub-box">
			<%@include file="/include/pop_invite_email.jsp" %>
		</div>
		<!-- 이메일 초대 :f -->
	</div>
	<!-- 초대하기 List pop : f -->
	
</div>
<!-- 초대하기  layer pop up : f -->

<script type="text/javascript">
$(function(){

	// 초대하기 layerPop 띄우기
	$(".invite-btn").click(function(){
		var $href = $(this).attr('href');
		layer_popup($href);
	});
	
	// 화상회의 layerPop 띄우기
	$(".face-chat-btn").click(function(){
		var $href = $(this).attr('href');
		layer_popup($href);
	});
	
	// 초대하기 버튼 클릭 이벤트
	$(".invate-frm-submit").click(function(){
		var item = $(this);
		var popCon = item.parent().siblings(".pop-con-sub");
		var selectUserList = popCon.children(".select-user-list");
		var ptnInviteForm = popCon.parent("form");
		
		// 초대한 회원이 없을 때
		if(selectUserList.children("div").length == 0){
			alertCustom("초대할 회원을 선택해주세요","alert-danger");
			return false;
		}
		
		// submit
		ptnInviteForm.submit();
		
	});

});
</script>

