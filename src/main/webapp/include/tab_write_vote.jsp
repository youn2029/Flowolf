<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form action="/vote/insert" method="post">

	<!-- tab-con-box:s -->
	<div class="tab-con-box">
		<!-- 투표제목:s -->
		<div class="input-box">
			<input type="text" name="vote_title" class="font-bold size-18" placeholder="투표 제목을 입력하세요." required="required">
		</div>
		<!-- 투표제목:f -->
		
		<!-- 투표항목:s -->
		<div class="input-box vote-box">
			<dl>
				<dt class="maright-20"><i class="fas fa-minus-circle color-red cursor-point" onclick="removeTodo(this)"></i></dt>
				<dd class="posi-re">
					<!-- 할일 내용 입력 input -->
					<input type="text" name="viList[0].vi_cont" class="vote-input" placeholder="투표 항목 입력(Enter or Tab 입력시 아래에 투표 항목 추가됨)" onkeydown="fn_keyDown(event, this)" required="required">
				</dd>
			</dl>
		</div>
		<!-- 투표항목:f -->
		
		<!-- 투표 마감일:s -->
		<div class="input-box">
			<dl>
				<dt class="maright-20"><i class="far fa-calendar-times"></i></dt>
				<dd class="posi-re">
					<input type="text"
					name = "vote_end_time"
					placeholder="마감날짜와 시간을 선택해주세요(2018-01-01 00:00)"
					data-timepicker="true"
					data-time-format='hh:ii'
					data-language='ko'
					class="datepicker-here"
					style="width:100%"
					required="required"/>
				</dd>
			</dl>
		</div>
		<!-- 투표 마감일:f -->
	</div>
	<!-- tab-con-box:f -->
	
	<!-- tab-dn-box:s -->
	<div class="tab-dn-box">
		<!-- 올리기(submit) 버튼 -->
		<input type="submit" value="올리기" class="article-submit-btn float-right font-bold size-18 color-white text-center default-back-color">
	</div>
	<!-- tab-dn-box:f -->
	
</form>
