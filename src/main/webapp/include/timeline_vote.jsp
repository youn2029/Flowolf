<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="timeline-article con-vote">
	<div class="container">
		<form action="/vote/viu" method="post">
		
			<!-- 투표제목:s -->
			<div class="input-box posi-re">
				<strong class="dis-block font-bold size-24 color-black">
					${timeLine.voteVo.vote_title }
				</strong>
				<div class="posi-ab size-18 color-gray" style="top:0;right:0">
					<i class="far fa-calendar-times maright-10"></i>
					${timeLine.voteVo.vote_end_time }
				</div>
			</div>
			<!-- 투표제목:f -->
			
			<c:set var="viu_chk" value="n"/>
			
			<c:forEach items="${timeLine.viList }" var="viVo">
				<c:if test="${viVo.viu_chk > 0 }">
					<c:set var="viu_chk" value="y"/>
				</c:if>
			</c:forEach>
		
			<!-- 투표내용:s -->
			<c:choose>
			
				<c:when test="${viu_chk == 'y' }">
					<c:forEach items="${timeLine.viList }" var="viVo" varStatus="status">
						<c:if test="${status.index > 0 }">
							<c:set var="mar" value="martop-10"/>
						</c:if>
						<div class="time-vote-con ${mar }">
							<c:choose>
								<c:when test="${viVo.viu_chk == 1 }">
								<input type="hidden" name="voting_vi_no" value="${viVo.vi_no }">
								<input type="radio" checked="checked" name="vi_no" value="${viVo.vi_no }" id="voteCon_vi${viVo.vi_no }" data-no="${viVo.vi_no }" class="custom-radio-input" disabled="disabled">
								</c:when>
								<c:otherwise>
								<input type="radio" name="vi_no" value="${viVo.vi_no }" id="voteCon_vi${viVo.vi_no }" data-no="${viVo.vi_no }" class="custom-radio-input" disabled="disabled">
								</c:otherwise>
							</c:choose>				
							<label for="voteCon_vi${viVo.vi_no }">
								<strong class="dis-block font-bold size-16 color-black">${viVo.vi_cont }</strong>
								<span class="vote-progress-bar martop-10">
									<span class="vote-range"></span>
								</span>
							</label>
							<div class="vote-count color-gray">
								<i class="fas fa-user"></i>
								<span class="vote-count-result marleft-10">${viVo.viu_cnt }</span>
							</div>
						</div>
					</c:forEach>
				</c:when>				
				<c:otherwise>
					<c:forEach items="${timeLine.viList }" var="viVo" varStatus="status">
						<c:if test="${status.index > 0 }">
							<c:set var="mar" value="martop-10"/>
						</c:if>
						<div class="time-vote-con ${mar }">
							<input type="radio" name="vi_no" value="${viVo.vi_no }" id="voteCon_vi${viVo.vi_no }" data-no="${viVo.vi_no }" class="custom-radio-input">
							<label for="voteCon_vi${viVo.vi_no }">
								<strong class="dis-block font-bold size-16 color-black">${viVo.vi_cont }</strong>
								<span class="vote-progress-bar martop-10">
									<span class="vote-range"></span>
								</span>
							</label>
							<div class="vote-count color-gray">
								<i class="fas fa-user"></i>
								<span class="vote-count-result marleft-10">${viVo.viu_cnt }</span>
							</div>
						</div>
					</c:forEach>					
				</c:otherwise>
			</c:choose>			
			<!-- 투표내용:f -->
			
			<div class="float-left martop-20 text-center" style="width:100%">
				<c:choose>
					<c:when test="${viu_chk == 'y' }">
						<input type="button" value="다시 투표하기" class="color-white default-back-color" onclick="fn_voteSubmit(this)">
						<input type="submit" value="투표하기" class="color-white default-back-color" style="display:none">
						<input type="button" value="취소" class="vote-cancel marleft-10 color-gray back-color-white" style="display:none" onclick="fn_voteCancel(this)">
					</c:when>
					<c:otherwise>
						<input type="button" value="다시 투표하기" class="color-white default-back-color" style="display:none" onclick="fn_voteSubmit(this)">
						<input type="submit" value="투표하기" class="color-white default-back-color">
						<input type="button" value="취소" class="vote-cancel marleft-10 color-gray back-color-white" style="display:none" onclick="fn_voteCancel(this)">
					</c:otherwise>
				</c:choose>
			</div>			
			
		</form>
	</div>
</div>


	
<!-- 투표 수정:s -->
<form action="/vote/update" method="post" class="article-edit-form con-todo">

	<input type="hidden" name="vote_no" value="${timeLine.voteVo.vote_no }">

	<!-- article edit box:s -->
	<div class="article-edit-box">
	
		<!-- 투표제목:s -->
		<div class="input-box">
			<input type="text" name="vote_title" class="font-bold size-18" placeholder="투표 제목을 입력하세요." value="${timeLine.voteVo.vote_title }" required="required">
		</div>
		<!-- 투표제목:f -->
		
		<!-- 투표항목:s -->
		<div class="input-box vote-box">
			<c:forEach items="${timeLine.viList }" var="viVo" varStatus="status">
				<dl>
					<dt class="maright-20"><i class="fas fa-minus-circle color-red cursor-point" data-no="${viVo.vi_no }" onclick="removeVoteItem(this)"></i></dt>
					<dd class="posi-re">
						<!-- 할일 내용 입력 input -->
						<input type="hidden" name="updateViList[${status.index }].vi_no" value="${viVo.vi_no }">
						<input type="text" name="updateViList[${status.index }].vi_cont" class="vote-input" placeholder="투표 항목 입력(Enter or Tab 입력시 아래에 투표 항목 추가됨)" value="${viVo.vi_cont }" onkeydown="fn_keyDown(event, this)" required="required">
					</dd>
				</dl>
			</c:forEach>
		</div>
		<!-- 투표항목:f -->
		
		<!-- 투표 마감일:s -->
		<div class="input-box">
			<dl>
				<dt class="maright-20"><i class="far fa-calendar-times"></i></dt>
				<dd class="posi-re">
					<input type="text" class="vote-date" value="${timeLine.voteVo.vote_end_time }" placeholder="마감날짜와 시간을 선택해주세요(2018-01-01 00:00)" onfocus="fn_voteDateClick(this)">
					<input type="text"
					name = "vote_end_time"
					placeholder="마감날짜와 시간을 선택해주세요(2018-01-01 00:00)"
					data-timepicker="true"
					data-time-format='hh:ii'
					data-language='ko'
					class="datepicker-here"
					style="width:100%"/>
				</dd>
			</dl>
		</div>
		<!-- 투표 마감일:f -->
		
	</div>
	<!-- article edit box:f -->
	
	<!-- article edit dn:s -->
	<div class="article-edit-dn">		
		<!-- submit & cancel 버튼 -->
		<input type="submit" value="수정하기" class="article-submit-btn font-bold size-16 color-white text-center default-back-color">
		<input type="button" value="취소" onclick="fn_editCancel(this)" 
		class="article-submit-btn maright-10 font-bold size-16 color-gray text-center back-color-white"
		style="border:1px solid #ddd">
	</div>
	<!-- article edit dn:f -->
</form>
<!-- 투표 수정:f -->








