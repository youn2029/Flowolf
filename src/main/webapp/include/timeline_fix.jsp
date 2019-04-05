<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="panel panel-default">

	<!-- accordion title : s -->
	<div class="article-fix-top" role="tab" id="fixedTop_${fixStart.index }">
		<a href="#fixedCon_${fixStart.index }" class="collasped size-18 color-black" 
		data-toggle="collapse" data-parent="#accordion" aria-expanded="false" aria-controls="fixedCon_${fixStart.index }"
		onchange="fn_fixedIconChange(this)">
			<c:choose>
				<c:when test="${timeLine.basicVo != null }">
					<c:set var="articleKind" value="일반"/>
					<c:set var="articleTitle" value="${timeLine.basicVo.basic_cont }"/>
					<input type="hidden" class="col-no" data-col="basic_no" data-no="${timeLine.basicVo.basic_no }">
				</c:when>
				<c:when test="${timeLine.taskVo != null }">
					<c:set var="articleKind" value="업무"/>
					<c:set var="articleTitle" value="${timeLine.taskVo.task_title }"/>
					<input type="hidden" class="col-no" data-col="task_no" data-no="${timeLine.taskVo.task_no }">
				</c:when>
				<c:when test="${timeLine.todoVo != null }">
					<c:set var="articleKind" value="할일"/>
					<c:if test="${timeLine.todoVo.todo_title == null }">
						<c:set var="articleTitle" value="${timeLine.tiList[0].ti_cont }"/>
					</c:if>
					<c:set var="articleTitle" value="${timeLine.todoVo.todo_title }"/>
					<input type="hidden" class="col-no" data-col="todo_no" data-no="${timeLine.todoVo.todo_no }">
				</c:when>
				<c:when test="${timeLine.voteVo != null }">
					<c:set var="articleKind" value="투표"/>
					<c:set var="articleTitle" value="${timeLine.voteVo.vote_title }"/>
					<input type="hidden" class="col-no" data-col="vote_no" data-no="${timeLine.voteVo.vote_no }">
				</c:when>
				<c:otherwise>
					<c:set var="articleKind" value="일정"/>
					<c:set var="articleTitle" value="${timeLine.schdVo.schd_title }"/>
					<input type="hidden" class="col-no" data-col="schd_no" data-no="${timeLine.schdVo.schd_no }">
				</c:otherwise>
			</c:choose>
			<i class="fas fa-map-pin maright-15 default-color"></i>
			<span class="font-bold default-color">[${articleKind }]</span> ${articleTitle}
			<i class="fas fa-angle-left size-24 color-gray icon-arrow"></i>
		</a>
	</div>
	<!-- accordion title : f -->
    
    <!-- accordion content : s -->
	<div id="fixedCon_${fixStart.index }" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fixedTop_${fixStart.index }">

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
			
			<!-- article icon : s -->
			<ul class="article-top-icon">
				
				<c:if test="${proVo.mem_id == memVo.mem_id }">
					<!-- article pick button -->
					<li>
						<a href="#fixCheck" class="pick-check-btn fixed">
							<c:choose>
								<c:when test="${timeLine.fix_chk == 'y' }">
									<i class="fas fa-map-pin size-24 cursor-point pick-active"></i>
								</c:when>
								<c:otherwise>
									<i class="fas fa-map-pin size-24 cursor-point"></i>
								</c:otherwise>
							</c:choose>
						</a>
					</li>
				</c:if>
			</ul>
			<!-- article icon : f -->		
	
		</div>
		<!-- timeline header:f -->
		
		<!-- timeline content:s -->	
		<div class="timeline-content">
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
		
	</div>
	<!-- accordion content : f -->
</div>
	
