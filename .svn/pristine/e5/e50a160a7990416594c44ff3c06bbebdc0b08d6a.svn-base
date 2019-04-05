<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="dim-layer">
	<div class="dimBg"></div>
	
    <div id="memOutPop" class="pop-layer">
		<form action="/mem/memOut" method="get" id="outFrm">
    		<!-- pop header -->
    		<header class="pop-top border-box">
    			회원탈퇴
    			<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
    		</header>
    		
    		<!-- pop con -->
	   		<section class="pop-con border-box">
	   		
	   			<p>
		   			사용하고 계신 아이디(<span class="color-green">${memVo.mem_id }</span>)는 탈퇴할 경우 재사용 및 복구가 불가능합니다.
		   			<span class="color-red">탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가</span>하오니 신중하게 선택하시기 바랍니다. 
	   			</p>
	   			<input type="checkbox" id="memOutCheck" name="memOutChk" class="custom-check-input">
				<label for="memOutCheck">위 내용에 동의합니다.</label>
	   			
	   			<input type="password" placeholder="비밀번호 확인" name="mem_pw" id="mem_pw" class="martop-10 mem-pw-edit-input">
	   			
			</section>
			
			<!-- pop footer -->
			<footer class="pop-footer border-box">
				<input type="button" value="취소" class="pop-btn default-btn btn-close">
				<input type="button" value="탈퇴하기" class="pop-btn submit-btn marleft-5 back-color-pupple-l" id="submitBtnOut">
			</footer>
		</form>
		<script type="text/javascript">
		$("#submitBtnOut").on("click", function(){
			var mem_pw = $("#mem_pw").val();
			
			if($("#memOutCheck").prop("checked")){
				$.ajax({
				   	 url: "/mem/memOutPwChk", 
					 data: {mem_pw:mem_pw},
					 dataType: 'json',
					 type: 'POST',
					 success: function (data) {
						 alertCustom(data.result, "alert-success");
						if(data.del == 1){
							$("#outFrm").submit();
						}
					 },
					 error: function (data) {
// 					   alert("실패");
					 }
		   		 });
			} else {
				alertCustom("회원탈퇴 내용에 동의해주세요", "alert-danger");
			}
			
			
		});
		</script>
	</div>
	
</div>
