<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 정규식 -->
<script src="<%=request.getContextPath() %>/js/regEx.js"></script>

<section class="content main">

	<strong class="mem-edit-tit">환경설정<span>Preferences</span></strong>
	
	<!-- member edit wrap : s -->
	<div class="mem-edit-wrap">
	
		<!-- FLOWOLF Profile : s -->
		<div class="col-md-6">
			<div class="mem-box">
				<i class="fas fa-user-circle color-gray"></i>
				
				<div class="mem-box-info">
					<strong class="dis-block marbtm-10 size-24">FLOWOLF 프로필</strong>
					<p class="marbtm-15 size-17 color-black text-justify">
						FLOWOLF에서 <span class="color-red">'나'를 표현하는 프로필</span>정보입니다. 수정화면에서 프로필 사진과 정보를 수정하세요.
					</p>
					
					<a href="#memInfoEditPop" class="mem-edit-pop-btn">수정</a>
				</div>
				
				<%@include file="/include/mem_edit_info.jsp" %>
			</div>
		</div>
		<!-- FLOWOLF Profile : f -->
	
		<!-- Password Edit : s -->
		<div class="col-md-6">
			<div class="mem-box">
			
				<c:if test="${memVo.mem_howjoin == 'g' || memVo.mem_howjoin == 'k'}">
				<div class="coming-soon-bg"></div>
				<div class="coming-soon-txt pw-edit-soon">비밀번호 수정을 원하시면 해당 사이트(카카오 or 구글)에서 이용해주시기 바랍니다.</div>
				</c:if>
				
				<i class="fas fa-unlock color-gray"></i>
				
				<div class="mem-box-info">
					<strong class="dis-block marbtm-10 size-24">비밀번호 변경</strong>
					<p class="marbtm-15 size-17 color-black text-justify">
						FLOWOLF <span class="color-red">비밀번호를 변경</span>할 수 있습니다. 주기적인 비밀번호 변경을 통해 개인정보를 안전하게 보호하세요. 
					</p>
					
					<a href="#memPwEditPop" class="mem-edit-pop-btn">수정</a>
				</div>
				
				<%@include file="/include/mem_edit_pw.jsp" %>
			</div>
		</div>
		<!-- Password Edit : f -->
	
		<!-- Alim Edit : s -->
		<div class="col-md-6">
			<div class="mem-box martop-20">
			
				<div class="coming-soon-bg"></div>
				<div class="coming-soon-txt">준비중입니다.</div>
				
				<i class="far fa-bell color-gray"></i>
				
				<div class="mem-box-info">
					<strong class="dis-block marbtm-10 size-24">알림설정</strong>
					<p class="marbtm-15 size-17 color-black text-justify">
						FLOWOLF 내 각종 <span class="color-red">알림에대한 설정</span>을 할 수 있습니다.
					</p>
					
					<a href="#memAlimEditPop" class="mem-edit-pop-btn">수정</a>
				</div>
			</div>
		</div>
		<!-- Alim Edit : f -->
	
		<!-- Member Out : s -->
		<div class="col-md-6">
			<div class="mem-box martop-20">
				<i class="fas fa-user-alt-slash color-gray"></i>
				
				<div class="mem-box-info">
					<strong class="dis-block marbtm-10 size-24">회원탈퇴</strong>
					<p class="marbtm-15 size-17 color-black text-justify">
						<span class="color-red">탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가</span>하오니 신중하게 선택하시기 바랍니다.
					</p>
					
					<a href="#memOutPop" class="mem-edit-pop-btn">회원탈퇴</a>
				</div>
				
				<%@include file="/include/mem_edit_out.jsp" %>
			</div>
		</div>
		<!-- Member Out : f -->
		
	</div>
	<!-- member edit wrap : f -->
	
	<script type="text/javascript">
	$(function(){
		// 각 수정 버튼 클릭시 layer popup 띄우기
		$('.mem-edit-pop-btn').click(function(){
			var $href = $(this).attr('href');
			layer_popup($href);
		});
	});
	</script>
</section>
