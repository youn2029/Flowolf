<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section class="content project-detail">
	<div class="project-wrap">
	
		<!-- collection article left content : s -->
		<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 padleft-0">
			
			<c:choose>
				<c:when test="${artKind == 'coll' }">
					<!-- coll article title -->
					<strong class="dis-block size-20 color-gray">담아둔 글 보기</strong>
				</c:when>
				<c:otherwise>
					<!-- coll article title -->
					<strong class="dis-block size-20 color-gray">내 게시물 글보기</strong>
				</c:otherwise>
			</c:choose>
			
			<!-- collection timeline : s -->
			<c:forEach items="${timeLineList }" var="timeLine" varStatus="start">
			<div class="timeline-box martop-20">
				<c:choose>
					<c:when test="${timeLine.basicVo != null }">
						<input type="hidden" class="col-no" data-col="basic_no" data-no="${timeLine.basicVo.basic_no }">
						<c:set var="proName" value="${timeLine.basicVo.pro_name }"/>
						<c:set var="proNo" value="${timeLine.basicVo.pro_no }"/>
					</c:when>
					<c:when test="${timeLine.taskVo != null }">
						<input type="hidden" class="col-no"  data-col="task_no" data-no="${timeLine.taskVo.task_no }">
						<c:set var="proName" value="${timeLine.taskVo.pro_name }"/>
						<c:set var="proNo" value="${timeLine.taskVo.pro_no }"/>
					</c:when>
					<c:when test="${timeLine.todoVo != null }">
						<input type="hidden" class="col-no" data-col="todo_no" data-no="${timeLine.todoVo.todo_no }">
						<c:set var="proName" value="${timeLine.todoVo.pro_name }"/>
						<c:set var="proNo" value="${timeLine.todoVo.pro_no }"/>
					</c:when>
					<c:when test="${timeLine.voteVo != null }">
						<input type="hidden" class="col-no" data-col="vote_no" data-no="${timeLine.voteVo.vote_no }">
						<c:set var="proName" value="${timeLine.voteVo.pro_name }"/>
						<c:set var="proNo" value="${timeLine.voteVo.pro_no }"/>
					</c:when>
					<c:otherwise>
						<input type="hidden" class="col-no" data-col="schd_no" data-no="${timeLine.schdVo.schd_no }">
						<c:set var="proName" value="${timeLine.schdVo.pro_name }"/>
						<c:set var="proNo" value="${timeLine.schdVo.pro_no }"/>
					</c:otherwise>
				</c:choose>
				
				<!-- project go link : s -->
				<div class="timeline-coll-head">
					<strong class="size-20 default-color">${proName }</strong>
					<a href="/pro/detail?pro_no=${proNo }" class="coll-head-link">
						프로젝트 바로가기<i class="fas fa-angle-double-right marleft-10"></i>
					</a>
				</div>
				<!-- project go link : f -->
				
				<!-- timeline header:s -->
				<div class="timeline-header back-color-white">
					<!-- article writer info -->
					<div class="article-writer-info">
						<dl>
							<dt class="posi-re maright-15 cursor-point" onclick="fn_openPopup(this)"
							data-id="${timeLine.mem_id }" data-nick="${timeLine.mem_nick }" data-my="${memVo.mem_id }">
								<i class="flow-icon icon-circle circle-s"></i>
								<img src="/mem/pic?mem_id=${timeLine.mem_id }" onerror="this.src=('/image/user-pic-sample.png')" height="40">
							</dt>
							<dd>
								<strong class="dis-block size-18 color-black">${timeLine.mem_nick }</strong>
								<span class="dis-block size-14 color-gray-l">
									<fmt:formatDate value="${timeLine.time }" pattern="yyyy-MM-dd HH:mm"/>
								</span>
							</dd>
						</dl>
					</div>
				</div>
				<!-- timeline header:f -->
					
				<!-- timeline content:s -->	
				<div class="timeline-content">
					<!-- if문  -->
					<c:choose>
						<c:when test="${timeLine.basicVo != null }">
							<%@include file="/include/timeline_article.jsp" %>
						</c:when>
						<c:when test="${timeLine.taskVo != null }">
							<%@include file="/include/timeline_task.jsp" %>
						</c:when>
						<c:when test="${timeLine.todoVo != null }">
							<%@include file="/include/timeline_todo.jsp" %>
						</c:when>
						<c:when test="${timeLine.voteVo != null }">
							<%@include file="/include/timeline_vote.jsp" %>
						</c:when>
						<c:otherwise>
							<%@include file="/include/timeline_schedule.jsp" %>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- timeline content:f -->
					
				<!-- timeline footer:s -->
				<div class="timeline-footer">
				
					<!-- 좋아요 / 댓글 개수:s -->
					<div class="article-etc-info">
					
						<!-- emoUserList에 회원이 등록한 이모티콘이 있는지 확인 -->
						<c:set var="emo_user_chk" value="false" />
						<c:set var="my_emo_no" value="" />
						<c:set var="my_emo_name" value="" />
						<c:set var="my_emo_user_no" value="" />
						
						<c:forEach items="${timeLine.emoUserList }" var="emoUserVo">
							<c:if test="${not emo_user_chk }">
								<c:if test="${emoUserVo.mem_id == memVo.mem_id }">
									<c:set var="emo_user_chk" value="true" />
									<c:set var="my_emo_no" value="${emoUserVo.emo_no }" />
									<c:set var="my_emo_name" value="${emoUserVo.emo_name }" />
									<c:set var="my_emo_user_no" value="${emoUserVo.emo_user_no }" />
								</c:if>
							</c:if>
						</c:forEach>						
						
						<!-- 좋아요 선택 시 이모티콘 나올 부분 : s -->
						<div class="like-result cursor-point" onclick="fn_emoUserPop(${start.index })">
							<c:forEach items="${timeLine.emoUserList }" var="emoUserVo" end="2">
								<img src="/emo/view?emo_no=${emoUserVo.emo_no }" data-no="${emoUserVo.emo_user_no }" width="20" class="maright-10">
							</c:forEach>
							<div class="like-mem dis-inblock" data-size="${timeLine.emoUserList.size() }">
							<c:choose>
								<c:when test="${emo_user_chk}">
									<strong class="me">${memVo.mem_nick }</strong>	님
									<c:if test="${timeLine.emoUserList.size()-1 != 0 }">
										  외 ${timeLine.emoUserList.size()-1 }명
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${timeLine.emoUserList.size() != 0 }">
										${timeLine.emoUserList.size() }명
									</c:if>
								</c:otherwise>									
							</c:choose>
							</div>
						</div>
						<!-- 좋아요 선택 시 이모티콘 나올 부분 : f -->
							
						<!-- 이모티콘 사용자 리스트 팝업 : s -->
						<div class="dim-layer">
							<div class="dimBg"></div>
						
							<div id="emoUser_${start.index }" class="pop-layer">
								<!-- pop header -->
								<header class="pop-top border-box">
									리액션 확인
									<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
								</header>
								
								<!-- pop con -->
								<section class="pop-con border-box">
									<!-- 좋아요 개수 : s -->
									<ul class="like-count-info">
										<li>총 <span>${timeLine.emoUserList.size() }</span></li>
									</ul>
									<!-- 좋아요 개수 : f -->
									
									<!-- 좋아요 리스트 : s -->
									<div class="like-count-list" data-simplebar>
										<c:forEach items="${timeLine.emoUserList }" var="emoUserVo">
											<dl>
												<dt	class="posi-re">
													<i class="icon-circle circle-s"></i>
													<img src="/mem/pic?mem_id=${emoUserVo.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="40">
												</dt>
												<dd>
													<div class="like-user-name">${emoUserVo.mem_nick }</div>
													<div class="like-user-emoticon"><img src="/emo/view?emo_no=${emoUserVo.emo_no }" width="40"></div>
												</dd>
											</dl>
										</c:forEach>
									</div>
									<!-- 좋아요 리스트 : f -->
								</section>									
							</div>
						</div>
						<!-- 이모티콘 사용자 리스트 팝업 : f -->
							
						<!-- 좋아요 / 담아두기 버튼 : s-->
						<ul class="article-etc-menu martop-10 marbtm-0">
							<li class="posi-re cursor-point">							
									
								<c:choose>
									<c:when test="${emo_user_chk }">
										<!-- like button : s -->
										<div id="emoticonToggle" class="emoticon-btn cursor-point" 
										data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="display:none">
											<i class="fas fa-thumbs-up maright-10"></i>좋아요
										</div>
										<!-- like button : f -->
										
										<!-- Chagned like button : s -->
										<div class="emoticon-after-btn cursor-point" data-emouser="${my_emo_user_no }" style="display:block">
											<img src="/emo/view?emo_no=${my_emo_no }" width="20" class="maright-10">
											<span class="size-14 default-color">${my_emo_name }</span>
										</div>
										<!-- Chagned like button : f -->
									</c:when>
									<c:otherwise>
										<!-- like button : s -->
										<div id="emoticonToggle" class="emoticon-btn cursor-point" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											<i class="fas fa-thumbs-up maright-10"></i>좋아요
										</div>
										<!-- like button : f -->
										
										<!-- Chagned like button : s -->
										<div class="emoticon-after-btn cursor-point" data-emouser="">
											<img src="" width="20" class="maright-10">
											<span class="size-14 default-color"></span>
										</div>
										<!-- Chagned like button : f -->
									</c:otherwise>
								</c:choose>
								<!-- Emoticon list box -->
								<div class="dropdown-menu emoticon-box" aria-labelledby="emoticonToggle">
									<ul>
										<c:forEach items="${emoList }" var="emo">
											<li class="posi-re" data-emono="${emo.emo_no }">
												<img src="/emo/view?emo_no=${emo.emo_no }">
												<span>${emo.emo_name }</span>
											</li>
										</c:forEach>											
									</ul>
								</div>
							</li>
							<c:choose>
								<c:when test="${timeLine.coll_chk != 0 }">
									<li class="cursor-point coll-btn default-color" data-collno="${timeLine.coll_chk }">
										<i class="fas fa-bookmark maright-10"></i>
										<span>담아두기 취소</span>
									</li>
								</c:when>
								<c:otherwise>
									<li class="cursor-point coll-btn" data-collno="${timeLine.coll_chk }">
										<i class="fas fa-bookmark maright-10"></i>
										<span>담아두기</span>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
						<!-- 좋아요 / 담아두기 버튼 : f-->
						
					</div>
					<!-- 좋아요 / 댓글 개수:f -->
						
				</div>
				<!-- timeline footer:f -->
				
			</div>
			</c:forEach>
			<!-- collection timeline : f -->
			
		</div>
		<!-- collection article left content : f -->
		
	</div>
	<form action="/coll/collArticle" id="collFrm"></form>
<script type="text/javascript">
//article img slide
var swiper = new Swiper('.swiper-container-img', {
	slidesPerView: 1,
	spaceBetween: 20,
	slidesPerGroup: 1,
	loop: false,
	loopFillGroupWithBlank: true,
	navigation: {
		nextEl: '.swiper-button-next',
		prevEl: '.swiper-button-prev',
	},
});

//이모티콘 유저 리스트 팝업
function fn_emoUserPop(count){
	layer_popup("#emoUser_"+count);
}

//task 상태 수정 팝업
function fn_editTaskState(el){
	
	var item = $(el);
	var stateList = item.parent('.task-state-list');
	var layerPopCon = $("#editTaskState");
	
	// task_no & task_state
	var task_no = stateList.siblings(".edit-confirm").data("taskno");
	var task_state = item.children().val();
	
	// 값 이동
	layerPopCon.children('form').children("input[name=task_no]").val(task_no);
	layerPopCon.children('form').children("input[name=task_state]").val(task_state);
	
	layer_popup(layerPopCon);	
}

// task 진척도 수정 
function fn_timeProgressSelect(el){
	var item = $(el);
	var task_rate = item.children('span').text();
	var task_no = item.siblings('input').data("taskno");
	
	$(".edit-rate-form").children("input[name=task_no]").val(task_no);
	$(".edit-rate-form").children("input[name=task_rate]").val(task_rate);
	
	$(".edit-rate-form").submit();
}

$(function(){
	
	// 좋아요 클릭 이벤트
	$(".emoticon-box li").click(function(){
		var item = $(this);
		var emo_no = $(this).data("emono");
		var timeline_col = $(this).parents(".timeline-box").children(".col-no").data("col");
		var timeline_no = $(this).parents(".timeline-box").children(".col-no").data("no");
		
		var emoticonAfterBtn = $(this).parents(".dropdown-menu").siblings(".emoticon-after-btn");
		var likeResult = item.parents(".article-etc-menu").siblings(".like-result");
		var likeImg = likeResult.children("img");
		var likeMem = likeResult.children(".like-mem");
		var size = likeMem.data("size");
		
		var emoUserListPop = likeResult.siblings(".dim-layer");
		var popCon = emoUserListPop.children(".pop-layer").children(".pop-con");
		var emoUserCntSpan = popCon.children("ul").find("span");
		var emoUserCnt = Number(popCon.children("ul").find("span").text());
		
		var likeCountList = popCon.children(".like-count-list");
		var simplebarCon = likeCountList.children(".simplebar-scroll-content").children(".simplebar-content");
		
		$.ajax({
			url : "/emoUser/insert",
			method : "get",
			data : {emo_no:emo_no, timeline_col:timeline_col, timeline_no:timeline_no},
			dataType : "json",
			success : function(data){
				fn_emoticon(item);
				emoticonAfterBtn.data("emouser", data);
				
				// 이모티콘 이미지
				if(likeImg.length < 3){
					likeResult.prepend("<img src=\"/emo/view?emo_no="+emo_no+"\" data-no="+data+" width=\"20\" class=\"maright-10\">");
				}
				
				// 좋아요 누른 회원
				if(size > 0){								
					likeMem.html("<strong>${memVo.mem_nick }</strong> 님  외"+size+"명");
				}else{
					likeMem.html("<strong class=\"me\">${memVo.mem_nick }</strong> 님");
				}
				
				// data-size : +1
				likeMem.data("size", size+1);
				
				// append 내용
				var str = "<dl data-id=\"${memVo.mem_id }\">"
							+ "<dt class=\"posi-re\">"
								+ "<i class=\"icon-circle circle-s\"></i>"
								+ "<img src=\"/mem/pic?mem_id=${memVo.mem_id }\" onerror=\"this.src='/image/user-pic-sample.png'\" width=\"40\">"
							+ "</dt>"
							+ "<dd>"
								+ "<div class=\"like-user-name\">${memVo.mem_nick }</div>"
								+ "<div class=\"like-user-emoticon\"><img src=\"/emo/view?emo_no="+emo_no+"\" width=\"40\"></div>"
							+ "</dd>"
						+ "</dl>";
				
				emoUserCntSpan.html(emoUserCnt+1);	// 인원수 추가
				simplebarCon.append(str);			// 리스트 추가
				
			}
		});
	});
	
	// 이모티콘 취소 이벤트
	$(".emoticon-after-btn").click(function(){
		var item = $(this);
		var emo_user_no = item.data("emouser");
		
		var likeResult = item.parents(".article-etc-menu").siblings(".like-result");
		var likeImg = likeResult.children("img");
		var likeMem = likeResult.children(".like-mem");
		var size = likeMem.data("size");					
		
		var emoUserListPop = likeResult.siblings(".dim-layer");
		var popCon = emoUserListPop.children(".pop-layer").children(".pop-con");
		var emoUserCntSpan = popCon.children("ul").find("span");
		var emoUserCnt = Number(popCon.children("ul").find("span").text());
		
		var likeCountList = popCon.children(".like-count-list");
		var simplebarCon = likeCountList.children(".simplebar-scroll-content").children(".simplebar-content");
		var emoUserOne = simplebarCon.children("dl");
		
		$.ajax({
			url : "/emoUser/delete",
			method : "get",
			data : {emo_user_no:emo_user_no},
			dataType : "json",
			success : function(data){
				fn_emoResultBtn(item);
				item.data("emouser", "");
				
				// 이모티콘 이미지
				likeImg.each(function(i, e){
					if(likeImg.eq(i).data("no") == emo_user_no){
						likeImg.eq(i).remove();
					}
				});
				
				// 좋아요 누른 회원
				if(size == 1 && likeMem.children("strong").hasClass("me")){
					likeMem.html("");
				}else if(size > 0){								
					likeMem.html(size-1+"명");
				}else{
					likeMem.html("");
				}
				
				// data-size : -1
				likeMem.data("size", size-1);
				
				emoUserCntSpan.html(emoUserCnt-1);	// 인원수 감소
				emoUserOne.each(function(i, e){		// 리스트 삭제
					if (emoUserOne.eq(i).data("id") == '${memVo.mem_id }') {
						emoUserOne.eq(i).remove();
					}
				});
			}
		});
	});
	
	// 담아두기 버튼 이벤트
	$(".coll-btn").click(function(){
		
		var item = $(this);
		var coll_no = item.data("collno");
		var timeline_col = $(this).parents(".timeline-box").children(".col-no").data("col");
		var timeline_no = $(this).parents(".timeline-box").children(".col-no").data("no");
							
		if(item.hasClass('default-color')){		// 취소					
		
			$.ajax({
				url : "/coll/delete",
				method : "get",
				data : {coll_no:coll_no},
				dataType : "json",
				success : function(data){
					if('${artKind }' == 'coll'){
						$("#collFrm").submit();						
					}
				}
			});		
		}else{									// 등록
			
			$.ajax({
				url : "/coll/insert",
				method : "get",
				data : {timeline_col:timeline_col, timeline_no:timeline_no},
				dataType : "json",
				success : function(data){
					item.data("collno", data);
				}
			});
		}
		
		fn_likeChange(item);
	});
	
	// '할 일' 항목 개수에 따라 각 항목 % 정하기
	var percent = 0;
	$(".todo-content").each(function(i,e){
		if($(this).children("dl").length == 1) {
			percent = 100;
			$(this).children("dl").find('.todo-percent-txt').html(percent);
		} else if($(this).children("dl").length == 2) {
			percent = 50;
			$(this).children("dl").find('.todo-percent-txt').html(percent);
		} else if($(this).children("dl").length == 3) {
			percent = 33;
			$(this).children("dl").find('.todo-percent-txt').html(percent);
			$(this).children("dl").eq(2).find('.todo-percent-txt').html(percent+1);
		} else if($(this).children("dl").length == 4) {
			percent = 25;
			$(this).children("dl").find('.todo-percent-txt').html(percent);
		} else if($(this).children("dl").length == 5) {
			percent = 20;
			$(this).children("dl").find('.todo-percent-txt').html(percent);
		}
	});
	
	// '할 일' 완료 % 및 개수, 전체 개수 구하기
	$(".todo-content").each(function(i, e){
		var todoItemLength = $(this).find('dl').length;					// 할일 항목 개수
		var todoItemSuccess = $(this).find('dl[data-chk=y]').length;	// 할일 항목 완료 개수
		var todoPercent = $(this).siblings('.todo-info').find('.todo-percent-cnt');		// 할일 완료 %
		var todoAllCount = $(this).siblings('.todo-info').find('.todo-all-cnt');		// 할일 항목 전체 개수
		var todoFinishCount = $(this).siblings('.todo-info').find('.todo-finish-cnt');	// 할일 항목 완료 개수
		var todoRange = $(this).siblings('.todo-progress-bar').find('.todo-range');		// 할일 % 게이지 바
		
		todoAllCount.text(todoItemLength);
		todoFinishCount.text(todoItemSuccess);
		
		var itemPcnt = Math.floor(100 / todoItemLength);
		var successPcnt = itemPcnt * todoItemSuccess;
		todoPercent.html(successPcnt);
		todoRange.css("width", successPcnt+"%");
	});
	
	// 첨부파일 이미지 바꾸기
	$(".upload-file-info").each(function(i, e){
		var iconTag = $(this).find("i.dis-inblock");
		var dataName = iconTag.attr("data-name");
		fileExCheck(iconTag);
	});
});
</script>
</section>