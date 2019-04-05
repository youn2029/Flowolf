<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maxium-scale=1.0, minimum-scale=1.0, width=device-width"/>	
		
		<meta name="google-signin-scope" content="profile email">
		<meta name="google-signin-client_id" content="1081075870716-k7q8bgo2f1eip8pgkjeejr16imo0s9r5.apps.googleusercontent.com">		
   		
		<title>FLOWOLF</title>
		
		<!-- favicon -->
		<link rel="shortcut icon" href="<%=request.getContextPath() %>/image/favicon.ico">
		
		<!-- font-awesome css -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
		
		<!-- bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		
		<!-- bootstrap-theme CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		
		<!-- bootstrap JS -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
		<!-- jquery 3.3.1 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<!-- 정규식 -->
		<script src="<%=request.getContextPath() %>/js/regEx.js"></script>
		
		<!-- kakao login js -->
		<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
		
		<!-- google -->
		<script src="https://apis.google.com/js/platform.js" async defer></script>	
		
		<!-- custom style -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_login.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_color.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_font.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_margin.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_padding.css">
		
	</head>
	<body>
	
		<!-- body-wrap-full:s -->
		<div class="body-wrap-full">
			<!-- body-wrap-basic:s -->
			<div class="body-wrap-basic login-wrap">
				
				<!-- logo -->
				<div class="login-logo marbtm-30">
					<img src="/image/logo_b.png">
				</div>
				
				<!-- login nav -->
				<ul class="login-nav">
					<li class="sign-up-link default-back-color">회원가입</li>
					<li class="find-id-link back-color-green">아이디</li>
					<li class="find-pw-link back-color-red">비밀번호</li>
				</ul>
				
				<!-- page script -->
				<script type="text/javascript">
				$(function(){
					
					// set
					var $bodyWrap = $(".body-wrap-full")
						, $loginNav = $bodyWrap.find("ul.login-nav")
						, $signUpLink = $loginNav.find("li.sign-up-link")
						, $findIdLink = $loginNav.find("li.find-id-link")
						, $findPwLink = $loginNav.find("li.find-pw-link")
						, $logo = $bodyWrap.find(".login-logo img")
						, $loginForm = $bodyWrap.find(".login-form")
						, $signUpForm = $bodyWrap.find(".sign-up-form")
						, $findIdForm = $bodyWrap.find(".find-id-form")
						, $findPwForm = $bodyWrap.find(".find-pw-form");
					
					// logo click
					$logo.on("click", function(){
						$signUpLink.animate({left:'0'}, 500);
						$findIdLink.animate({left:'0'}, 500);
						$findPwLink.animate({left:'0'}, 500);
						
						$loginForm.css("display","block");
						$signUpForm.css("display","none");
						$findIdForm.css("display","none");
						$findPwForm.css("display","none");
					});
					
					// sign-up lick
					$signUpLink.on("click", function() {
						$signUpLink.animate({left:'20px'}, 500);
						$findIdLink.animate({left:'0'}, 500);
						$findPwLink.animate({left:'0'}, 500);
						
						$loginForm.css("display","none");
						$signUpForm.css("display","block");
						$findIdForm.css("display","none");
						$findPwForm.css("display","none");
					});
					
					// find-id lick
					$findIdLink.on("click", function() {
						$signUpLink.animate({left:'0'}, 500);
						$findIdLink.animate({left:'20px'}, 500);
						$findPwLink.animate({left:'0'}, 500);
						
						$loginForm.css("display","none");
						$signUpForm.css("display","none");
						$findIdForm.css("display","block");
						$findPwForm.css("display","none");
					});
					
					// find-pw lick
					$findPwLink.on("click", function() {
						$signUpLink.animate({left:'0'}, 500);
						$findIdLink.animate({left:'0'}, 500);
						$findPwLink.animate({left:'20px'}, 500);
						
						$loginForm.css("display","none");
						$signUpForm.css("display","none");
						$findIdForm.css("display","none");
						$findPwForm.css("display","block");
					});
				});
				
				// alert Pop
				function alertPop(id, text, color){
					var alertBox = $(id).next(".alert-box");
					alertBox.html(text);
					alertBox.show();
					alertBox.removeClass("color-red");
					alertBox.removeClass("color-green-l");
					alertBox.addClass(color);
				}
				
				</script>
				
				<!-- login form wrap box:s -->
				<div class="login-box border-box">
				
					<!-- login:s -->
					<form name="" class="login-form" action="/pro/main" method="post">
						<input type="hidden" name="pro_no" value="${pro_no }">
						<input type="hidden" name="mem_nick" value="${mem_nick }">
						<input type="hidden" name="apply" value="${apply }">
						<!-- id input -->
						<div class="input-box dis-block border-box">
							<input type="text" id="mem_id" placeholder="이메일 아이디">
						</div>
						
						<!-- password input -->
						<div class="input-box dis-block martop-20 border-box">
							<input type="password" id="mem_pw" placeholder="비밀번호" value="Asdf1234!">
						</div>

						<!-- remember id -->
						<div class="remember-box martop-20">
							<input type="checkbox" id="rememberId" name="rememberId" class="custom-check-input">
							<label for="rememberId">아이디 기억</label>
						</div>
						
						<!-- remember id script -->
						<script type="text/javascript">
						
							function getCookie(name){
					    		var cookies = document.cookie;
					    		
					    		var cookieArr = cookies.split("; ");
					    		var cookieResult = "";
					    		
					    		for(var i in cookieArr){
					    			var cookie = cookieArr[i];
					    			var cookieNameValue = cookie.split("=");
					    			
					    			var cookieName = cookieNameValue[0];
					    			var cookieValue = cookieNameValue[1];
					    			
					    			if(name == cookieName){
					    				cookieResult = cookieValue;
					    				break;
					    			}
					    		}
					    		return cookieResult;
					    	}
					    	
					    	// 쿠키 추가
					    	function setCookie(cookieName, cookieValue, expires){
					    		var dt = new Date();
					    		dt.setDate(dt.getDate() + parseInt(expires));
					    		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + dt.toGMTString();
					    	}
					    	
					    	// 쿠키 삭제
					    	function deleteCookie(cookieName){
						    	setCookie(cookieName, "", -1);	
					    	}
					    	
					    	// 문서 로딩 완료후 실행
					    	$(function(){
					    		if(getCookie("rememberId") == "y"){
						    		// userId input에 userId cookie 값을 설정
						    		$(".login-form #mem_id").val(getCookie("mem_id"));
						    		$("#rememberId").attr("checked", true);
						    		$("#rememberId").val(getCookie("rememberId"));
						    	}	
					    		
					    		// rememberId 체크박스 클릭이벤트
					    		$("#rememberId").on("click", function(){
					    			if($(this).is(":checked")){
					    				// rememberMe cookie 설정
					    				setCookie("rememberId", "y", 30);
					    				setCookie("mem_id", $(".login-form #mem_id").val(), 30);
					    			}else{
					    				// 쿠키 제거
					    				deleteCookie("rememberId");
					    			}
					    		});
					    	});
						</script>
						
						<!-- login btn -->
						<button type="button" name="loginBtn" onclick="fn_loginClick()" class="login-btn dis-block martop-50 default-back-color">로그인</button>
						
						<!-- basic login script -->
						<script type="text/javascript">
						function fn_loginClick() {
							
							var mem_id = $(".login-form").find("#mem_id").val();
							var mem_pw = $(".login-form").find("#mem_pw").val();
							var pro_no = $(".login-form").find("input[name=pro_no]").val();
							var apply = $(".login-form").find("input[name=apply]").val();
							var mem_nick = $(".login-form").find("input[name=mem_nick]").val();
							
							var loginFrm = $(".login-form");
							
							$.ajax({
								url : "/login/login",
								method : "post",
								data : {mem_id:mem_id
									  , mem_pw:mem_pw
									  , pro_no:pro_no
									  , mem_nick:mem_nick
									  , apply:apply },
								dataType : "json",
								success : function(data){
									if(data == 1){
										loginFrm.attr('action', '/pro/main');
										loginFrm.submit();
									}else if(data == 2){
										loginFrm.attr('action', '/adm/memList');
										loginFrm.submit();
									}else if(data == 3){
										alert("탈퇴한 회원입니다.");
										return false;
									}else{
										alert("아이디 또는 비밀번호를 다시 확인하세요.");
										return false;
									}
								}
							});
						}
						
						$(function(){
							$(".login-box #mem_pw").keydown(function(key){
								if(key.keyCode == 13){
									key.preventDefault(); // Enter 키 값 초기화(submit event reset)
									fn_loginClick();
								}
							});
						});
						</script>	
											
						<!-- kakao login btn -->
						<!-- 기본스크립트만 넣어놨으니 아래수정 후에 작업완료되면 이 주석은 지워주세요 -->
						<a id="custom-login-btn" href="javascript:loginWithKakao()"  class="login-btn login-kakao martop-10">
							<!-- <img src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="380"/> -->
							<i class="login-icon icon-talk">icon-talk</i>
							카카오계정으로 로그인
						</a>			
						
						<!-- kakao login script -->
						<script type='text/javascript'>							
						//<![CDATA[
						    // 사용할 앱의 JavaScript 키를 설정해 주세요.
						    Kakao.init('98239550a54bf93bed19bcecd073ba96'); //98239550a54bf93bed19bcecd073ba96
						    // 카카오 로그인 버튼을 생성합니다.
						    function loginWithKakao() {
						    	
						    	var pro_no = $(".login-form").find("input[name=pro_no]").val();
								var apply = $(".login-form").find("input[name=apply]").val();
								var apply_nick = $(".login-form").find("input[name=mem_nick]").val();
						    	
							    // 로그인 창을 띄웁니다.
							    Kakao.Auth.login({
									success: function(authObj) {
										Kakao.API.request({
											url: '/v1/user/me',
											success: function(res) {
// 												alert(JSON.stringify(res)); //<---- kakao.api.request 에서 불러온 결과값 json형태로 출력
// 												alert(JSON.stringify(authObj)); //<----Kakao.Auth.createLoginButton에서 불러온 결과값 json형태로 출력
												console.log("id : "+res.id);//<---- 콘솔 로그에 id 정보 출력(id는 res안에 있기 때문에  res.id 로 불러온다)
												console.log("email : "+res.kaccount_email);//<---- 콘솔 로그에 email 정보 출력 (어딨는지 알겠죠?)
												console.log("nick : "+res.properties['nickname']);//<---- 콘솔 로그에 닉네임 출력(properties에 있는 nickname 접근 
												// res.properties.nickname으로도 접근 가능 )
												console.log("token : "+authObj.access_token);//<---- 콘솔 로그에 토큰값 출력
												
												$.ajax({
													url : "/login/kakao",
													method : "post",
													data : {
														mem_id:res.kaccount_email,
														mem_nick:res.properties['nickname'],
														mem_pic:res.properties['profile_image'],
														pro_no : pro_no,
														apply : apply,
														apply_nick : apply_nick},
													dataType : "json",
													success : function(data) {
														if(data == 1){
															$(".login-form").submit();
														}else{
															alert("카카오 로그인 실패");
														}																	
													}
												});												
											}
										})
									},
									fail: function(err) {
										alert(JSON.stringify(err));
									}
							    });
						    };
						//]]>
						</script>
						
						
						<!-- google login btn -->
						<div class="g-signin2 martop-10 border-box" data-onsuccess="onSignIn" data-width="380" data-height="60">
						</div>
						<!-- 
						<div class="login-btn login-google martop-10 cursor-point">
							<i class="login-icon icon-google">icon-google</i>
							구글계정으로 로그인
						</div> -->
						<!-- 구글연동 end -->				
						
						<style>
							.abcRioButton {box-shadow:none !important}
							.abcRioButton:hover {box-shadow:none !important}
							.abcRioButtonIcon, .abcRioButtonContents {display:none}
							.g-signin2 .abcRioButton.abcRioButtonLightBlue{background:url("/image/google-login.gif") no-repeat !important}
						</style>
						
						<!-- google login scripte -->
						<script type="text/javascript">
						function onSignIn(googleUser) {
							
							var pro_no = $(".login-form").find("input[name=pro_no]").val();
							var apply = $(".login-form").find("input[name=apply]").val();
							var apply_nick = $(".login-form").find("input[name=mem_nick]").val();
						
							// Useful data for your client-side scripts:
							var profile = googleUser.getBasicProfile();
							console.log("ID: " + profile.getId()); // Don't send this directly to your server!
							console.log('Full Name: ' + profile.getName());
							console.log('Given Name: ' + profile.getGivenName());
							console.log('Family Name: ' + profile.getFamilyName());
							console.log("Image URL: " + profile.getImageUrl());
							console.log("Email: " + profile.getEmail());
							
							// The ID token you need to pass to your backend:
							var id_token = googleUser.getAuthResponse().id_token;
							console.log("ID Token: " + id_token);
							
							$.ajax({
								url : "/login/google",
								method : "post",
								data : {
									mem_id:profile.getEmail(),
									mem_nick:profile.getName(),
									mem_pic:profile.getImageUrl(),
									pro_no : pro_no,
									apply : apply,
									apply_nick : apply_nick},
								dataType : "json",
								success : function(data) {
									if(data == 1){
										$(".login-form").submit();
									}else{
										alert("구글 로그인 실패");
									}																	
								}
							});
						};	
					      
						function signOut() {
							var auth2 = gapi.auth2.getAuthInstance();
							auth2.signOut().then(function () {
								console.log('User signed out.');
							});
						}						

						</script>
					</form>
					<!-- login:f -->
					
					<!-- sign up:s -->					
					<form name="signUp" action="/login/view" method="post" class="sign-up-form" style="display:none" enctype="multipart/form-data">
					
						<!-- profile photo -->
						<div class="photo-box">
							<!-- img box -->
							<div class="img-box">
								<i class="icon-circle"></i>
								<img src="" class="profile-pic" height="150" onerror="this.src=('/image/user-pic-sample.png')">
							</div>
							
							<!-- file btn -->
							<div class="file-btn-box">
								<i class="fa fa-camera upload-btn"></i>
								<input type="file" name="mem_pic" class="photo-upload" accept=".png, .jpg, .jpeg, .gif">
							</div>
						</div>
						
						<!-- photo image change script //-->
						<!-- 건들지 마세요 -->
						<script type="text/javascript">
						$(document).ready(function() {
						    var readURL = function(input) {
						        if (input.files && input.files[0]) {
						            var reader = new FileReader();
		
						            reader.onload = function (e) {
						                $('.profile-pic').attr('src', e.target.result);
						            }
						            reader.readAsDataURL(input.files[0]);
						        }
						    }
		
						    $(".photo-upload").on('change', function(){
						        readURL(this);
						    });
						    
						    $(".upload-btn").on('click', function() {
						       $(".photo-upload").click();
						    });
						});
						</script>
						<!--// photo image change script -->
						
						<!-- name input -->						
						<div class="input-box dis-block martop-30 border-box">
							<input type="text" id="mem_name" name="mem_name" placeholder="이름"> <!-- required-->
							<div class="color-green-l alert-box">
							</div>
						</div>
						
						<!-- email id input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="text" id="mem_id" name="mem_id" placeholder="이메일 아이디" >
							<div class="color-green-l alert-box">
							</div>
							<a id="Id_chBtn" class="check-btn color-gray"><i class="fas fa-check"></i></a>
						</div>
						
						<!-- password input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="password" id="mem_pw" name="mem_pw" placeholder="비밀번호">
							<div class="color-green-l alert-box">
							</div>
						</div>
						
						<!-- password check input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="password" id=pwChk name="pwChk" placeholder="비밀번호 확인">
							<div class="color-green-l alert-box">
							</div>
						</div>
						
						<!-- nick name input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="text" id="mem_nick" name="mem_nick" placeholder="닉네임">
							<div class="color-green-l alert-box">
							</div>
							<a id="nick_chBtn" class="check-btn color-gray"><i class="fas fa-check"></i></a><!-- default -->
						</div>
						
						<!-- phone number input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="text" id="mem_phone" name="mem_phone" placeholder="핸드폰 번호">
							<div class="color-green-l alert-box">
							</div>
							<a id="Phone_msgBtn" class="check-btn color-gray"><i class="far fa-envelope"></i></a>
						</div>
						
						<!-- phone number check input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="text" id="phoneChkNum" name="phoneChkNum" placeholder="인증번호">
							<div class="color-green-l alert-box">
							</div>
							<a id="PhoneCf_chBtn" class="check-btn color-gray"><i class="fas fa-check"></i></a><!-- default -->
						</div>
						
						<!-- submit btn-->
						<input type="button" id="singUp" name="singUp" value="회원가입" class="submit-btn default-back-color martop-30">						
					</form>
					
					<script type="text/javascript">
					$(function() {
						
						var name = "n";
						var id = "n";
						var pw = "n";
						var pwChk = "n";
						var nick = "n";
						var phone = "n";
						var phoneChk = "n";
						var phoneNum = "0";
						
						// name 정규식
						$(".sign-up-form #mem_name").blur(function(){
							if(!nameReg.test($(this).val())){
								alertPop(".sign-up-form #mem_name", "한글과 영문 대 소문자를 사용하세요.","color-red");
								name = "n";
								return false;
							}else{
								$(this).next(".alert-box").hide();
								name = "y";
								return false;
							}
						});							
						
						// id 정규식 & 중복체크
						$(".sign-up-form #mem_id").blur(function(){
							var mem_id = $(".sign-up-form #mem_id").val();
							var chkBtn = $(".sign-up-form #Id_chBtn");
							var alertBox = $(this).next(".alert-box");
							
							$.ajax({
								url : "/login/idChk",
								method : "post",
								dataType : "json",					// server로 부터 받을 data type
								data : {mem_id : mem_id},
								success : function(data){
									if(!idReg.test(mem_id)){
										chkBtn.removeClass("color-gray");
										chkBtn.removeClass("color-green-l");
										chkBtn.addClass("color-red");
										alertPop(".sign-up-form #mem_id", "이메일형식으로 작성해주세요", "color-red");
										id = "n";
										return false;
									}else if(data > 0){
										chkBtn.removeClass("color-gray");
										chkBtn.removeClass("color-green-l");
										chkBtn.addClass("color-red");
										alertPop(".sign-up-form #mem_id", "사용중인 아이디입니다.", "color-red");
										id = "n";
										return false;
									}else{
										chkBtn.removeClass("color-gray");
										chkBtn.removeClass("color-red");
										chkBtn.addClass("color-green-l");
										alertPop(".sign-up-form #mem_id", "사용가능한 아이디입니다.", "color-green-l");											
										setTimeout(function(){alertBox.fadeOut()}, 3000);
										id = "y";
										return false;
									}
								},
								error : function(error){
									alert("error");
								}
							});		
						});
						
						// pw 정규식
						$(".sign-up-form #mem_pw").blur(function(){
							if(!pwReg.test($(this).val())){
								alertPop(".sign-up-form #mem_pw", "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.", "color-red");
								pw = "n";
								return false;
							}else{
								$(this).next(".alert-box").hide();
								pw = "y";
								return false;
							}	
						});	
						
						// pw 확인
						$(".sign-up-form #pwChk").blur(function(){
							if($(".sign-up-form #mem_pw").val() != $(this).val()){
								alertPop(".sign-up-form #pwChk", "비밀번호가 일치하지 않습니다.", "color-red");
								pwChk = "n";
								return false;
							}else{
								$(this).next(".alert-box").hide();
								pwChk = "y";
								return false;
							}	
						});	
						
						// nick 정규식
						$(".sign-up-form #mem_nick").blur(function(){
							
							var mem_nick = $(".sign-up-form #mem_nick").val();
							var chkBtn = $(".sign-up-form #nick_chBtn");
							var alertBox = $(this).next(".alert-box");
							
							$.ajax({
								url : "/login/nickChk",
								method : "post",
								dataType : "json",					// server로 부터 받을 data type
								data : {mem_nick : mem_nick},
								success : function(data){
									if(!nickReg.test(mem_nick)){
										chkBtn.removeClass("color-gray");
										chkBtn.removeClass("color-green-l");
										chkBtn.addClass("color-red");
										alertPop(".sign-up-form #mem_nick", "2~16자 한글, 영어, 숫자만 사용 가능합니다.", "color-red");
										nick = "n";
										return false;
									}else if(data > 0){
										chkBtn.removeClass("color-gray");
										chkBtn.removeClass("color-green-l");
										chkBtn.addClass("color-red");
										alertPop(".sign-up-form #mem_nick", "사용중인 닉네임입니다.", "color-red");
										nick = "n";
										return false;
									}else{
										chkBtn.removeClass("color-gray");
										chkBtn.removeClass("color-red");
										chkBtn.addClass("color-green-l");
										alertPop(".sign-up-form #mem_nick", "사용가능한 닉네임입니다.", "color-green-l");											
										setTimeout(function(){alertBox.fadeOut()}, 3000);
										nick = "y";
										return false;
									}
								},
								error : function(error){
									alert("error");
								}
							});	
						});	
						
						// phone 정규식
						$(".sign-up-form #mem_phone").blur(function(){
							
							var smgBtn = $(".sign-up-form #Phone_msgBtn");
							
							if(!phoneReg.test($(this).val())){
								smgBtn.removeClass("color-gray");
								smgBtn.removeClass("color-green-l");
								smgBtn.removeClass("cursor-point");
								smgBtn.addClass("color-red");
								alertPop(".sign-up-form #mem_phone", "핸드폰번호를 정확히 입력해주세요", "color-red");
								phone = "n";
								return false;
							}else{
								smgBtn.removeClass("color-gray");
								smgBtn.removeClass("color-red");
								smgBtn.addClass("color-green-l");
								smgBtn.addClass("cursor-point");
								$(this).next(".alert-box").hide();
								phone = "y";
								
								// msgSend
								if($(".sign-up-form #Phone_msgBtn").hasClass("color-green-l")){
									$(".sign-up-form #Phone_msgBtn").click(function(){
										
										var mem_phone = $(".sign-up-form #mem_phone").val();
										phoneNum = Math.floor(Math.random()*99000-(88000-1)+88000);
										
										$.ajax({
											url : "/login/msgSend",
											method : "post",
											dataType : "json",					// server로 부터 받을 data type
											data : {mem_phone:mem_phone, phoneNum:phoneNum},
											success : function(data){
												if(data == 1){
													alert("인증번호를 발송하였습니다.");
												}else{
													alert("인증 발송 실패");
												}
											},
											error : function(error){
												alert("error");
											}
										});
									});					
								}
																
								return false;
							}	
						});			
						
						// phone Number check
						$(".sign-up-form #phoneChkNum").blur(function(){
							
							var chkBtn = $(".sign-up-form #PhoneCf_chBtn");							
							
							if($(this).val() != phoneNum){
								chkBtn.removeClass("color-gray");
								chkBtn.removeClass("color-green-l");
								chkBtn.addClass("color-red");
								alertPop(".sign-up-form #phoneChkNum", "인증번호가 일치하지 않습니다.", "color-red");
								phoneChk = "n";
								return false;
							}else{
								chkBtn.removeClass("color-gray");
								chkBtn.removeClass("color-red");
								chkBtn.addClass("color-green-l");
								$(this).next(".alert-box").hide();
								phoneChk = "y";
								return false;
							}
						});
						
						$("input#singUp").on("click", function(){
							
							if(name != "y"){
								alert("name 확인 바랍니다");
								return false;
							}else if(id != "y"){
								alert("id 확인 바랍니다");
								return false;
							}else if(pw != "y"){									
								alert("pw 확인 바랍니다");									
								return false;
							}else if(pwChk != "y"){									
								alert("pwChk 확인 바랍니다");									
								return false;
							}else if(nick != "y"){									
								alert("nick 확인 바랍니다");									
								return false;
							}else if(phone != "y"){									
								alert("phone 확인 바랍니다");									
								return false;
							}else if(phoneChk != "y"){									
								alert("phoneChk 확인 바랍니다");									
								return false;
							}else{								
								
								var formData = new FormData($(".sign-up-form")[0]);
								
								$.ajax({
									url : "/login/signup",
									type : "post",
									method : "post",
									dataType : "json",
									data : formData,
									processData : false,
						            contentType : false,
									success : function(data){
										if(data == 1){
											alert("회원가입 되었습니다.");
											$(".sign-up-form").submit();
										}else{
											alert("회원가입에 실패하였습니다.");
										}
									},
									error : function(error){
										alert("error");
									}
									
								});
							}
							
						});							
					});	
					</script>
					<!-- sign up:f -->
					
					
					<!-- 아이디 찾기 -->
					<!-- find id:s -->
					<form action="/login/view" method="post" class="find-id-form" style="display:none">
						<!-- name input -->
						<div class="input-box dis-block border-box">
							<input type="text" id="mem_name" name="mem_name" placeholder="이름">
							<div class="color-green-l alert-box">
							</div>
						</div>
						
						<!-- phone number input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="text" id="mem_phone" name="mem_phone" placeholder="핸드폰 번호">
							<div class="color-green-l alert-box">
							</div>
							<a id="Phone_msgBtn" class="check-btn color-gray"><i class="far fa-envelope"></i></a>
						</div>
				
						<!-- phone number check input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="text" id="phoneChkNum" name="phoneChkNum" placeholder="인증번호">
							<div class="color-green-l alert-box">
							</div>
							<a id="PhoneCf_chBtn" class="check-btn color-gray"><i class="fas fa-check"></i></a><!-- default -->
						</div>
						
						<!-- submit btn-->
						<input type="button" id="findIdSubmit" name="findIdbtn" value="아이디 찾기" class="submit-btn default-back-color martop-30">
						
					</form>	
					<!-- find id script -->
					<script type="text/javascript">
					$(function(){
						
						var name = "n";
						var phone = "n";
						var phoneChk = "n";
						var phoneNum = "0";
						
						// name 정규식
						$(".find-id-form #mem_name").blur(function(){
							if(!nameReg.test($(this).val())){
								alertPop(".find-id-form #mem_name", "한글과 영문 대 소문자를 사용하세요.","color-red");
								name = "n";
								return false;
							}else{
								$(this).next(".alert-box").hide();
								name = "y";
								return false;
							}							
						});
						
						// phone 정규식
						$(".find-id-form #mem_phone").blur(function(){
							
							var smgBtn = $(".find-id-form #Phone_msgBtn");
							
							if(!phoneReg.test($(this).val())){
								smgBtn.removeClass("color-gray");
								smgBtn.removeClass("color-green-l");
								smgBtn.removeClass("cursor-point");
								smgBtn.addClass("color-red");
								alertPop(".find-id-form #mem_phone", "핸드폰번호를 정확히 입력해주세요", "color-red");
								phone = "n";
								return false;
							}else{
								smgBtn.removeClass("color-gray");
								smgBtn.removeClass("color-red");
								smgBtn.addClass("color-green-l");
								smgBtn.addClass("cursor-point");
								$(this).next(".alert-box").hide();
								phone = "y";
								
								// msgSend
								if($(".find-id-form #Phone_msgBtn").hasClass("color-green-l")){
									$(".find-id-form #Phone_msgBtn").click(function(){
										
										var mem_phone = $(".find-id-form #mem_phone").val();
										phoneNum = Math.floor(Math.random()*99000-(88000-1)+88000);
										
										$.ajax({
											url : "/login/msgSend",
											method : "post",
											dataType : "json",					// server로 부터 받을 data type
											data : {mem_phone:mem_phone, phoneNum:phoneNum},
											success : function(data){
												if(data == 1){
													alert("인증번호를 발송하였습니다.");
												}else{
													alert("인증 발송 실패");
												}
											},
											error : function(error){
												alert("error");
											}
										});
									});					
								}
																
								return false;
							}	
						});					
						
						// phone Number check
						$(".find-id-form #phoneChkNum").blur(function(){
							
							var chkBtn = $(".find-id-form #PhoneCf_chBtn");
							
							if($(this).val() != phoneNum){
								chkBtn.removeClass("color-gray");
								chkBtn.removeClass("color-green-l");
								chkBtn.addClass("color-red");
								alertPop(".find-id-form #phoneChkNum", "인증번호가 일치하지 않습니다.", "color-red");
								phoneChk = "n";
								return false;
							}else{
								chkBtn.removeClass("color-gray");
								chkBtn.removeClass("color-red");
								chkBtn.addClass("color-green-l");
								$(this).next(".alert-box").hide();
								phoneChk = "y";
								return false;
							}
						});
						
						
						// findId submit button
						$("#findIdSubmit").click(function(){
							
							if(name != "y"){				// name check
								alert("name 확인 바랍니다");
								return false;								
							}else if(phone != "y"){			// phone check
								alert("phone 확인 바랍니다");
								return false;								
							}else if(phoneChk != "y"){		// phone number check
								alert("phoneChk 확인 바랍니다");
								return false;								
							}else{
								
								var mem_name = $(".find-id-form #mem_name").val();
								var mem_phone = $(".find-id-form #mem_phone").val();								 
								
								// 해당 회원의 ID 조회
								$.ajax({
									url : "/login/findId",
									method : "post",
									dataType : "json",					// server로 부터 받을 data type
									data : {mem_name:mem_name, mem_phone:mem_phone},
									success : function(data){
										if(data.mem_id){
											$(".result-id").html(data.mem_id);
											layer_popup("#alertFindId");
										}else{
											alert("해당 ID가 존재하지 않습니다.");
										}
									},
									error : function(error){
										alert("error");
									}
								});
							}
							
						});
						
					});
					</script>
					<!-- find id:f -->
					
					<!-- find password:s -->
					<form action="findPw" class="find-pw-form" style="display:none">
						<!-- name input -->
						<div class="input-box dis-block border-box">
							<input id="mem_name" type="text" name="mem_name" placeholder="이름">
							<div class="color-green-l alert-box">
							</div>
						</div>
						
						<!-- id input -->
						<div class="input-box dis-block martop-10 border-box">
							<input id="mem_id" type="text" name="mem_id" placeholder="이메일 아이디">
							<div class="color-green-l alert-box">
							</div>
						</div>
						
						<!-- phone number input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="text" id="mem_phone" name="mem_phone" placeholder="핸드폰 번호">
							<div class="color-green-l alert-box">
							</div>
							<a id="Phone_msgBtn" class="check-btn color-gray"><i class="far fa-envelope"></i></a>
						</div>
						
						<!-- phone number check input -->
						<div class="input-box dis-block martop-10 border-box">
							<input type="text" id="phoneChkNum" name=phoneChkNum placeholder="인증번호">
							<div class="color-green-l alert-box">
							</div>
							<a id="PhoneCf_chBtn" class="check-btn color-gray"><i class="fas fa-check"></i></a><!-- default -->
						</div>
						
						<!-- submit btn-->
						<input type="button" id="findPwSubmit" name="findPwSubmit" value="비밀번호 찾기" class="submit-btn default-back-color martop-30">
<!-- 						<a href="#newPwSet" class="submit-btn find-pw-btn default-back-color martop-30">비밀번호 찾기</a> -->
						
					</form>
					
					<script type="text/javascript">
					$(function(){
						
						var name = "n";
						var id = "n";
						var phone = "n";
						var phoneChk = "n";
						var phoneNum = "0";
						
						// name 정규식
						$(".find-pw-form #mem_name").blur(function(){
							if(!nameReg.test($(this).val())){
								alertPop(".find-id-form #mem_name", "한글과 영문 대 소문자를 사용하세요.","color-red");
								name = "n";
								return false;
							}else{
								$(this).next(".alert-box").hide();
								name = "y";
								return false;
							}							
						});
						
						// id 정규식
						$(".find-pw-form #mem_id").blur(function(){
							if(!idReg.test($(this).val())){
								alertPop(".find-pw-form #mem_id", "이메일형식으로 작성해주세요", "color-red");
								id = "n";
								return false;
							}else{
								$(this).next(".alert-box").hide();
								id="y";
								return false;
							}
						});
						
						// phone 정규식
						$(".find-pw-form #mem_phone").blur(function(){
							
							var smgBtn = $(".find-pw-form #Phone_msgBtn");
							
							if(!phoneReg.test($(this).val())){
								smgBtn.removeClass("color-gray");
								smgBtn.removeClass("color-green-l");
								smgBtn.removeClass("cursor-point");
								smgBtn.addClass("color-red");
								alertPop(".find-up-form #mem_phone", "핸드폰번호를 정확히 입력해주세요", "color-red");
								phone = "n";
								return false;
							}else{
								smgBtn.removeClass("color-gray");
								smgBtn.removeClass("color-red");
								smgBtn.addClass("color-green-l");
								smgBtn.addClass("cursor-point");
								$(this).next(".alert-box").hide();
								phone = "y";
								
								// msgSend
								if($(".find-pw-form #Phone_msgBtn").hasClass("color-green-l")){
									$(".find-pw-form #Phone_msgBtn").click(function(){
										
										var mem_phone = $(".find-pw-form #mem_phone").val();
										phoneNum = Math.floor(Math.random()*99000-(88000-1)+88000);
										
										$.ajax({
											url : "/login/msgSend",
											method : "post",
											dataType : "json",					// server로 부터 받을 data type
											data : {mem_phone:mem_phone, phoneNum:phoneNum},
											success : function(data){
												if(data == 1){
													alert("인증번호를 발송하였습니다.");
												}else{
													alert("인증 발송 실패");
												}
											},
											error : function(error){
												alert("error");
											}
										});
									});					
								}
																
								return false;
							}	
						});					
						
						// phone Number check
						$(".find-pw-form #phoneChkNum").blur(function(){
							
							var chkBtn = $(".find-pw-form #PhoneCf_chBtn");
							
							if($(this).val() != phoneNum){
								chkBtn.removeClass("color-gray");
								chkBtn.removeClass("color-green-l");
								chkBtn.addClass("color-red");
								alertPop(".find-pw-form #phoneChkNum", "인증번호가 일치하지 않습니다.", "color-red");
								phoneChk = "n";
								return false;
							}else{
								chkBtn.removeClass("color-gray");
								chkBtn.removeClass("color-red");
								chkBtn.addClass("color-green-l");
								$(this).next(".alert-box").hide();
								phoneChk = "y";
								return false;
							}
						});
						
						// finePw submit button
						$("#findPwSubmit").click(function(){							
							
							if(id != "y"){						// id check
								alert("id 확인 바랍니다");
								return false;
							}else if(name != "y"){				// name check
								alert("name 확인 바랍니다");
								return false;								
							}else if(phone != "y"){				// phone check
								alert("phone 확인 바랍니다");
								return false;								
							}else if(phoneChk != "y"){			// phone number check
								alert("phoneChk 확인 바랍니다");
								return false;								
							}else{								
								
								var mem_name = $(".find-pw-form #mem_name").val();
								var mem_id = $(".find-pw-form #mem_id").val();
								var mem_phone = $(".find-pw-form #mem_phone").val();
								
								// 해당 회원 ID 조회
								$.ajax({
									url : "/login/memChk",
									method : "post",
									dataType : "json",					// server로 부터 받을 data type
									data : {mem_name:mem_name, mem_id:mem_id, mem_phone:mem_phone},
									success : function(data){
										if(data.mem_id){
											$("#result-id").val(data.mem_id);
											layer_popup("#newPwSet");
										}else{
											alert("해당 회원이 존재하지 않습니다.");
										}
									},
									error : function(error){
										alert("error");
									}
								});
							}
							
						});
						
						
					});
					</script>
					<!-- find password:f -->
					
					<!-- copyright -->
					<div class="dn-copy martop-20">&copy;Copyright 2018 #DEV. All Rights Reserved.</div>
					
				</div>
				<!-- login form wrap box:f -->
				
			</div>
			<!-- body-wrap-basic:f -->
			
			<!-- 아이디 정보 노출 레이어 팝업:s -->
			<div class="dim-layer">
				<div class="dimBg"></div>
				
				<div id="alertFindId" class="pop-layer">
					<form action="/login/view">
						<!-- pop header -->
			    		<header class="pop-top border-box">
			    			아이디 알림
			    			<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
			    		</header>
			    		
			    		<!-- pop con -->
				   		<section class="pop-con border-box">
				   			<p class="marbtm-0 padtop-20 size-20 color-gray text-center">
				   				당신의 ID는 <span class="result-id default-color"></span> 입니다.
				   			</p>
						</section>
						
						<!-- pop footer -->
						<footer class="pop-footer border-box">
							<input type="submit" name="" class="pop-btn submit-btn marleft-5 back-color-pupple-l" value="확인">
						</footer>
					</form>
				</div>
				
			</div>
			<!-- 아이디 정보 노출 레이어 팝업:f -->
			
			<!-- 새 비밀번호 입력 레이어 팝업:s -->
			<div class="dim-layer">
				<div class="dimBg"></div>
				
				<div id="newPwSet" class="pop-layer">
					<form id="newPwSet-form" action="/login/view" method="post">
						<input type="hidden" id="result-id" value="">
						<!-- pop header -->
			    		<header class="pop-top border-box">
			    			새 비밀번호 설정
			    			<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
			    		</header>
			    		
			    		<!-- pop con -->
				   		<section class="pop-con border-box">
				   			<div class="dis-block">
				   				새 비밀번호
					   			<input type="password" id="password" class="pop-input martop-5" style="padding:0" placeholder="특수문자, 영문 대/소문자, 숫자포함 8-16자" required="required">
					   			<div class="color-green-l alert-box">
								</div>
				   			</div>
				   			<div class="dis-block martop-15">
				   				새 비밀번호 확인
					   			<input type="password" name="" id="passwordCheck" class="pop-input martop-5" style="padding:0" placeholder="새 비밀번호 입력확인" required="required">
					   			<div class="color-green-l alert-box">
								</div>
				   			</div>
						</section>
						
						<!-- pop footer -->
						<footer class="pop-footer border-box">
							<input type="button" name="" class="pop-btn default-btn btn-close" value="취소">
							<input type="button" id="newPwSet-submit" name="" class="pop-btn submit-btn marleft-5 back-color-pupple-l" value="저장">
						</footer>
					</form>
				</div>
				
			</div>
			<!-- 새 비밀번호 입력 레이어 팝업:f -->
			<script src="<%=request.getContextPath() %>/js/layerPop.js"></script> <!-- layer pop-up js -->
			<script type="text/javascript">
			$(function(){
				
				pw = "n";
				pwChk = "n";
				
				// pw 정규식
				$("#password").blur(function(){
					if(!pwReg.test($(this).val())){
						alertPop("#password", "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.", "color-red");
						pw = "n";
						return false;
					}else{
						$(this).next(".alert-box").hide();
						pw = "y";
						return false;
					}
				});
				
				// pw 확인
				$("#passwordCheck").blur(function(){
					if($("#password").val() != $(this).val()){
						alertPop("#passwordCheck", "비밀번호가 일치하지 않습니다.", "color-red");
						pwChk = "n";
						return false;
					}else{
						$(this).next(".alert-box").hide();
						pwChk = "y";
						return false;
					}	
				});
				
				// newPwSet submit button
				$("#newPwSet-submit").click(function(){
					if(pw != "y"){
						alert("pw 확인 바랍니다");
						return false;
					}else if(pwChk != "y"){
						alert("pwChk 확인 바랍니다");
						return false;
					}else{
						
						var mem_id = $("#result-id").val();
						var mem_pw = $("#password").val();
						
						// 해당 회원의 비밀번호 수정
						$.ajax({
							url : "/login/memPwSet",
							method : "post",
							dataType : "json",					// server로 부터 받을 data type
							data : {mem_id:mem_id, mem_pw:mem_pw},
							success : function(data){
								if(data == 1){
									alert("수정되었습니다.");
									$("#newPwSet-form").submit();
								}else{
									alert("실패하였습니다.");
								}
							},
							error : function(error){
								alert("error");
							}
						});
					}
					
				});				
				
				// 팝업 닫기버튼 클릭시 값 초기화
				$(".btn-close").on("click", function(){
					$("input.pop-input").val('');
				});
			});
			</script>
			
		</div>
		<!-- body-wrap-full:f -->

	</body>
</html>