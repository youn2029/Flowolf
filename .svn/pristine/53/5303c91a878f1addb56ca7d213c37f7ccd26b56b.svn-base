<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<form action="/proUser/invite" method="post">

	<!-- top : pop invite partner : s -->
	<div class="pop-top-sub">
		<i class="fas fa-arrow-left size-20 cursor-point" onclick="fn_popupBack(this)"></i>
		동료 초대하기
		<i class="flow-icon icon-close cursor-point" onclick="fn_popSubClose(this)"></i>
	</div>
	<!-- top : pop invite partner : f -->
	
	<!-- content : pop invite partner : s -->
	<div class="pop-con-sub">
	
		<!-- 추가된 동료 리스트가 나올 부분 -->
		<div class="select-user-list">
			<span class="user-all-del" onclick="fn_userListDelete(this)">전체 삭제</span>
		</div>
		
		<!-- user list:s -->
		<div class="invite-user-list over-y-scroll">
			<c:forEach items="${ptnMyList }" var="ptnVo">			
				<dl class="pop-user-list" data-id="${ptnVo.mem_id }" data-no="${proVo.pro_no }" onclick="fn_inviteUserAdd(this)">
					<dt class="maright-10">
						<i class="icon-circle circle-s"></i>
						<img src="/mem/pic?mem_id=${ptnVo.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="40">
					</dt>
					<dd>
						<strong class="dis-block size-20 color-black">${ptnVo.mem_nick }</strong>
						<span class="dis-block size-14 color-gray-l">${ptnVo.mem_id }</span>
						<button type="button" class="invite-add-btn">
							<i class="fas fa-plus maright-15"></i>
							<span>추가</span>
						</button>
					</dd>
				</dl>
			</c:forEach>
		</div>
		<!-- user list:f -->
		
	</div>
	<!-- content : pop invite partner : f -->
	
	<!-- footer : pop invite partner : s -->
	<div class="pop-footer-sub">
		<input type="button" class="invate-frm-submit submit-btn color-white default-back-color " value="초대">
	</div>
	<!-- footer : pop invite partner : f -->

</form>
