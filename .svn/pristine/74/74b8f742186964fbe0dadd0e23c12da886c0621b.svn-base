<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="dim-layer">
	<div class="dimBg"></div>
	
    <div id="memPwEditPop" class="pop-layer">
		<form action="/mem/memPwUpdate" method="get" id="pwFrm">
    		<!-- pop header -->
    		<header class="pop-top border-box">
    			비밀번호 변경하기
    			<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
    		</header>
    		
    		<!-- pop con -->
	   		<section class="pop-con border-box">
	   		
	   			<p>
	   				안전한 비밀번호로 내정보를 보호하세요.<br>
	   				<span class="dis-block color-red">다른 아이디/사이트에서 사용한 적 없는 비밀번호</span>
	   				<span class="color-red">이전에 사용한 적 없는 비밀번호</span>가 안전합니다.
	   			</p>
	   			
	   			<input type="password" placeholder="현재 비밀번호" class="mem-pw-edit-input" name="pw" id="pw">
	   			<input type="password" placeholder="새 비밀번호" class="martop-10 mem-pw-edit-input" name="newPw" id="newPw">
	   			<input type="password" placeholder="새 비밀번호 확인" class="martop-10 mem-pw-edit-input" name="newPwChk" id="newPwChk">
	   			
			</section>
			
			<!-- pop footer -->
			<footer class="pop-footer border-box">
				<input type="button" value="취소" class="pop-btn default-btn btn-close">
				<input type="button" value="변경하기" class="pop-btn submit-btn marleft-5 back-color-pupple-l" id="submitBtnPw">
			</footer>
		</form>
		<script type="text/javascript">
			$("#submitBtnPw").on("click", function(){
				var pw = $("#pw").val();
				var newPw = $("#newPw").val();
				var newPwChk = $("#newPwChk").val();
				
				if(!pwReg.test($("#newPw").val())){
					alert("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
					return false;
				}else{
					$.ajax({
					   	 url: "/mem/memPwChk", 
						 data: {pw:pw, newPw:newPw, newPwChk:newPwChk},
						 dataType: 'json',
						 type: 'POST',
						 success: function (data) {
							 alertCustom(data.result, "alert-success");
							if(data.upd == 1){
								$("#pwFrm").submit();
							}
						 },
						 error: function (data) {
// 						   alert("실패");
						 }
			   		 });
				}
				
		});
		</script>
	</div>
	
</div>
