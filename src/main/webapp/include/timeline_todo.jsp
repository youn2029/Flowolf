<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="timeline-article con-todo">
	<div class="container">
	
		<input type="hidden" id="todo_no" name="todo_no" value="${timeLine.todoVo.todo_no }">
	
		<!-- 할일제목:s -->
		<div class="todo-title input-box">
			<strong class="size-20 color-black">${timeLine.todoVo.todo_title }</strong>
		</div>
		<!-- 할일제목:f -->
	
		<!-- 할일 정보 -->
		<div class="todo-info float-left color-gray">
			<div class="float-right">
				완료<span class="todo-finish-cnt marleft-10"></span>&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;
				전체<span class="todo-all-cnt marleft-10"></span>건
			</div>
			<span class="todo-percent-cnt float-right maright-30"></span>
		</div>
		
		<!-- 할일 진행률 -->
		<div class="todo-progress-bar float-left martop-20">
			<div class="todo-range"></div>
		</div>
		
		<!-- 할일 내용:s -->
		<div class="todo-content float-left martop-20">
			<c:forEach items="${timeLine.tiList }" var="tiList" varStatus="status">
			<c:choose>
				<c:when test="${tiList.ti_chk == 'y' }">
					<dl data-chk="y">
						<dt class="maright-10">
							<label onchange="fn_checkBoxLabel(this)" data-no="${tiList.ti_no }">
								<i class="far fa-check-circle size-20 default-color back-color-white cursor-point" style="border-radius:50%"></i>
								<input type="checkbox" class="dis-none" checked="checked">
								<span class="dis-none todo-percent-txt"></span>
							</label>
						</dt>
					<dd>
						<span class="color-gray todo-success">${tiList.ti_cont }</span>
						<div class="posi-re float-right cursor-point" onclick="fn_openPopup(this)" 
						data-id="${tiList.ti_mem_id }" data-nick="${tiList.mem_nick }" data-my="${memVo.mem_id }" 
						data-toggle="tooltip" data-placement="bottom" title="${tiList.mem_nick }">
							<i class="icon-circle circle-xs-re"></i>
							<img src="/mem/pic?mem_id=${tiList.ti_mem_id }" class="cursor-point" 
							onerror="this.src='/image/user-pic-sample.png'" width="24">
						</div>
						
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="MM/dd" /></c:set> 
						
						<c:choose>
							<c:when test="${tiList.ti_date < sysYear}">
							<div class="ti-date float-right maright-15 todo-success">
								${tiList.ti_date }
							</div>
							</c:when>
							<c:otherwise>
							<div class="ti-date float-right maright-15 color-black todo-success">
								${tiList.ti_date }
							</div>
							</c:otherwise>
						</c:choose>
						</dd>
					</dl>
				</c:when>
				<c:when test="${tiList.ti_chk == 'n' }">					
					<dl data-chk="n">
						<dt class="maright-10">
							<label onchange="fn_checkBoxLabel(this)" data-no="${tiList.ti_no }">
								<i class="far fa-check-circle size-20 color-gray-l back-color-white cursor-point" style="border-radius:50%"></i>
								<input type="checkbox" class="dis-none">
								<span class="dis-none todo-percent-txt"></span>
							</label>
						</dt>
						<dd>
							<span class="color-gray">${tiList.ti_cont }</span>
							<div class="posi-re float-right cursor-point" onclick="fn_openPopup(this)" 
							data-id="${tiList.ti_mem_id }" data-nick="${tiList.mem_nick }" data-my="${memVo.mem_id }" 
							data-toggle="tooltip" data-placement="bottom" title="${tiList.mem_nick }">
								<i class="icon-circle circle-xs-re"></i>
								<img src="/mem/pic?mem_id=${tiList.ti_mem_id }" class="cursor-point" 
								onerror="this.src='/image/user-pic-sample.png'" width="24">
							</div>
							
							<c:set var="now" value="<%=new java.util.Date()%>" />
							<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="MM/dd" /></c:set> 
							
							<c:choose>
								<c:when test="${tiList.ti_date < sysYear}">
								<div class="ti-date float-right maright-15 color-red">
									${tiList.ti_date }
								</div>
								</c:when>
								<c:otherwise>
								<div class="ti-date float-right maright-15 color-black">
									${tiList.ti_date }
								</div>
								</c:otherwise>
							</c:choose>
						</dd>
					</dl>
				</c:when>
			</c:choose>			
				
			</c:forEach>
		</div>
		<!-- 할일 내용:f -->
		
	</div>
</div>


	
<!-- 할일 수정:s -->
<form action="/todo/update" method="post" class="article-edit-form con-todo">

	<input type="hidden" id="todo_no" name="todo_no" value="${timeLine.todoVo.todo_no }">

	<!-- article edit box:s -->
	<div class="article-edit-box">
	
		<!-- 할일제목:s -->
		<div class="input-box">
			<input type="text" name="todo_title" class="font-bold size-18" placeholder="할일 제목을 입력하세요.(선택)" value="${timeLine.todoVo.todo_title }">
		</div>
		<!-- 할일제목:f -->
		
		<!-- 할일 내용:s -->
		<div class="input-box todo-box">
			<c:forEach items="${timeLine.tiList }" var="tiList" varStatus="status">
			<dl>
				<dt class="maright-20"><i class="fas fa-minus-circle color-red cursor-point" data-no="${tiList.ti_no }" onclick="removeTodoItem(this)"></i></dt>
				<dd class="posi-re">
					<!-- 할일 내용 입력 input -->
					<input type="hidden" name="tiUpdateList[${status.index }].ti_no" value="${tiList.ti_no }">
					<input type="text" name="tiUpdateList[${status.index }].ti_cont" class="todo-input" value="${tiList.ti_cont }" placeholder="할일 입력(Enter or Tab 입력시 아래에 할일 입력 추가됨)" onkeydown="fn_keyDown(event, this)" required="required">
					<input type="hidden" name="tiUpdateList[${status.index }].ti_chk" class="todo-chk" value="${tiList.ti_chk }">
					
					<!-- 날짜, 담당자 아이콘박스 -->
					<div class="todo-icon-box">
						
						<!-- todo date : 날짜추가 : s -->
						<div class="posi-re dis-inblock float-left maright-15">
							<!-- date icon button -->
							<c:set var="now" value="<%=new java.util.Date()%>" />
							<c:set var="sysDate"><fmt:formatDate value="${now}" pattern="MM/dd" /></c:set> 
							<c:choose>
								<c:when test="${tiList.ti_date != null }">
									<c:choose>
										<c:when test="${tiList.ti_date < sysDate}">
											<i id="dateResult" class="cursor-point todo-date-icon color-red"
											data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="datePick(this)">${tiList.ti_date }</i>
										</c:when>
										<c:otherwise>
											<i id="dateResult" class="cursor-point todo-date-icon color-gray" 
											data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="datePick(this)">${tiList.ti_date }</i>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:when test="${tiList.ti_date == null }">
									<i id="dateResult" class="flow-icon todo-icon icon-calendar-plus cursor-point todo-date-icon" 
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="datePick(this)"></i>
								</c:when>
							</c:choose>
							<input type="hidden" name="tiList[${status.index }].ti_date" class="todo-date">
								
							 
							<!-- date-picker box -->
							<div class="dropdown-menu datepicker-here" aria-labelledby="dateResult"></div>
						</div>
						<!-- todo date : 날짜추가 : f -->
						
						
						<!-- todo add manager : 담당자추가 : s -->
						<div class="posi-re dis-inblock float-left todo-add-manager">
						
							<!-- 담당자 추가 버튼 -->
							<div id="todoManager" class="user-add-btn posi-re cursor-point" 
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="icon-circle circle-xs dis-none"></i>
								<i class="flow-icon todo-icon icon-user-plus"></i>
								<input type="hidden" name="tiList[${status.index }].ti_mem_id" class="todo-mem" value="${tiList.ti_mem_id }">
							</div>
					
							<!-- 프로젝트 참여자 리스트(담당자 설정 리스트):s -->
							<div class="dropdown-menu todo-pro-user-list" role="menu" aria-labelledby="todoManager">
								<c:forEach items="${getMemProUserList }" var="proUserVo" end="2">
								<div class="pro-user-info" onclick="userSelect(this)">
									<div class="pro-user-photo maright-10">
										<i class="icon-circle circle-s"></i>
										<img src="/mem/pic?mem_id=${proUserVo.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="40">
									</div>
									<span class="user-id">${proUserVo.mem_id }</span>
								</div>
								</c:forEach>
							</div>
							<!-- 프로젝트 참여자 리스트(담당자 설정 리스트):f -->
					
						</div>
						<!-- todo add manager : 담당자추가 : f -->
					</div>
				</dd>
			</dl>
			</c:forEach>
		</div>
		<!-- 할일 내용:f -->
		
		<div class="input-box martop-15">
			<a href="#addTodo" class="color-black" onclick="fn_addTodo(this)"><i class="fas fa-plus maright-15 default-color"></i>할일 추가</a>
		</div>
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
<!-- 할일 수정:f -->
