<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>채팅</title>
	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_color.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_font.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_margin.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_padding.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_chat_icon_popup.css">

	<!-- jQuery 3.3.1 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
	<!-- font-awesome CSS -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
	
	<script type="text/javascript">
		var wsocket;
		connect();
		
		// 여기로 클릭한 ip, port 번호 넘어오게 해야함
		function connect() {
			var ip = "${chatVo.chat_ip}";
			var port = ${chatVo.chat_port};
			wsocket = new WebSocket("ws://"+ip+":"+port+"/chat-ws");
			wsocket.onopen = onOpen;
			//서버로부터 메시지를 받으면 호출되는 함수 지정
			wsocket.onmessage = onMessage;
			wsocket.onclose = onClose;	
		}
		
		// 연결이 끊켰을 때
		function disconnect() {
			var msg = "msg-e:" + "," +"<div class=\"textMsgBoxWrap\" style=\"width:100%\"><p class=\"outMsg\" style=\"text-align:center\">"+  $('#nickname').val() + "님 퇴장!</p></div>";
			wsocket.send(msg);
		}
		
		function onOpen(evt) {
			console.log("연결됨");
	// 		var msg = 'msg:[' + "${memberVo.mem_nick}" + '님 입장!]';
	// 		wsocket.send(msg);
		}
		
		function onMessage(evt) {
			var data = evt.data;
			var mem_id = "${memberVo.mem_id}";
			
			if(data.substring(0,6) == 'msg-t:') {
				var chat = data.substring(6).split(",");
				
				if(mem_id == chat[0]){
					// 오른쪽으로 붙는 태그
					appendMessage("<div class=\"textMsgBoxWrap\"><p class=\"date left\">" + chat[3] + "</p><div class=\"textMsgBox\"><div class=\"myTextBox\"><span>" + chat[2] + "</span></div></div></div>" + '<br>');
				}else {
					// 왼쪽으로 붙는 태그
					appendMessage("<div class=\"textMsgBoxWrap left\"><div class=\"frofile-img\">" +
							"<img src=\"/mem/pic?mem_id=" + chat[0]  + "\" />" +
							"</div>" +
							"<div class=\"left\">" +
									"<p class=\"nick\">" + chat[1] + "</p>" +
									"<p class=\"date right\">" + chat[3] +
									"</p>" +
									"<div class=\"textMsgBox left\">" +
										"<div class=\"youTextBox\">" +
										"<span>" + chat[2] + "</span>" +
										"</div>" +
									"</div>" +
								"</div>" +
							"</div>" + '<br>');
				}
				
				if(data.substring(7,data.lastIndexOf('퇴장!')) 
						== $('#nickname').val() && data.lastIndexOf('퇴장!') != -1) {
					wsocket.close();
				}
			}else if(data.substring(0,6) == 'msg-f:'){
				//id nick tag time
				var file = data.substring(6).split(",");
				if(mem_id == file[0]){
					appendMessage("<div class=\"textMsgBoxWrap\"><p class=\"date left\">" + file[3] + "</p><div class=\"textMsgBox\"><div class=\"myTextBox\"><span>" + file[2] + "</span></div></div></div>" + '<br>');
				}else{
					appendMessage("<div class=\"textMsgBoxWrap left\"><div class=\"frofile-img\">" +
							"<img src=\"/mem/pic?mem_id=" + file[0]  + "\" />" +
							"</div>" +
							"<div class=\"left\">" +
									"<p class=\"nick\">" + file[1] + "</p>" +
									"<p class=\"date right\">" + file[3] +
									"</p>" +
									"<div class=\"textMsgBox left\">" +
										"<div class=\"youTextBox\">" +
										"<span>" + file[2] + "</span>" +
										"</div>" +
									"</div>" +
								"</div>" +
							"</div>" + '<br>');
				}
				
			}else if(data.substring(0,6) == 'msg-i:'){
				//id nick tag time
				var img = data.substring(6).split(",");
				if(mem_id == img[0]){
					appendMessage("<div class=\"textMsgBoxWrap\"><p class=\"date left\">" + img[3] + "</p><div class=\"textMsgBox\"><div class=\"myTextBox\"><span>" + img[2] + "</span></div></div></div>" + '<br>');
				}else{
					appendMessage("<div class=\"textMsgBoxWrap left\"><div class=\"frofile-img\">" +
							"<img src=\"/mem/pic?mem_id=" + img[0]  + "\" />" +
							"</div>" +
							"<div class=\"left\">" +
									"<p class=\"nick\">" + img[1] + "</p>" +
									"<p class=\"date right\">" + img[3] +
									"</p>" +
									"<div class=\"textMsgBox left\">" +
										"<div class=\"youTextBox\">" +
										"<span>" + img[2] + "</span>" +
										"</div>" +
									"</div>" +
								"</div>" +
							"</div>" + '<br>');
				}
				
			}else if(data.substring(0,6) == 'msg-e:'){
				var msg = data.substring(6).split(",");
				appendMessage(msg[1]);
			}
		}
		
		function onClose(evt) {
			//퇴장 한 이후 부과적인 작업이 있을 경우 명시
			$('#nickname').val("");
			$('#message').attr('disabled',true);
		}
		
		function send() { // 전송되면 채팅 리스트 리로드,..
	// 		window.opener.location.reload(); //새로고침 
			// 요섭오빠 파일 전송할때 작업
			var nickname = $('#nickname').val();
			var msg = $('#message').val();
			var fileEx = $("#sendFile").val();
			var fileValue = $("#sendFile").val().split("\\");
			var fileName = fileValue[fileValue.length-1]; 
			var form = $('#FILE_FORM')[0];
	        var formData = new FormData(form);
	        
	        var fileExt = fileEx.slice(fileEx.indexOf(".") + 1).toLowerCase(); //파일 확장자를 잘라내고, 비교를 위해 소문자로 만듭니다.
	
			if(msg.trim() == '' && fileName != ''){
				$.ajax({
					   url: "/chat/insertChatFile", //컨트롤러 URL
						 data: formData,
						 dataType: 'json',
						 processData: false,
						 contentType: false,
						 type: 'POST',
						 success: function (response) {
							if(fileExt == "jpg" || fileExt == "png" ||  fileExt == "gif" ||  fileExt == "bmp"){ //확장자를 확인합니다.
								wsocket.send("msg-i:" +response.mem_id +","+ nickname + "," +"<a href=/chat/fileDownload?chat_file_no="+response.chat_file_no+"><img src=/chat/img?chat_file_no="+response.chat_file_no+"></a>"+","+response.time);
								opener.parent.search();
							}else{
								wsocket.send(
									"msg-f:" +response.mem_id +","+ nickname + "," 
									+ "<a href=/chat/fileDownload?chat_file_no="+response.chat_file_no+">"+
											"<i class=\"dis-inblock maright-10 file-icon-s file-default\"></i>" + fileName
									+"</a>"+","+response.time);
								opener.parent.search();
							}
						 },error: function (jqXHR) {
						   alert(jqXHR.responseText);
						 }
			   		 });
			}else if(msg.trim() != '' && fileName == ''){
				$.ajax({
					url : "/chat/insertChatCon",
					method : "POST",
					dataType : "json", // server로 부터 받을 data type
					data : {msg:msg, chat_no:"${chatVo.chat_no }", mem_id:"${memberVo.mem_id }", nick:nickname},
					success : function(data) {
						if (data) {
							wsocket.send("msg-t:" + data.mem_id+","+nickname + "," + data.chat_cont + ","+ data.time);
							opener.parent.search();
						} else {
						}
					},
					error : function(error) {
						alert("error");
					}
				});
			}else if(msg.trim() != '' && fileName != ''){
				$.ajax({
					url : "/chat/insertChatCon",
					method : "POST",
					dataType : "json", // server로 부터 받을 data type
					data : {msg:msg, chat_no:"${chatVo.chat_no }", mem_id:"${memberVo.mem_id }", nick:nickname},
					success : function(data) {
						if (data) {
							wsocket.send("msg-t:" + data.mem_id+","+nickname + "," + data.chat_cont + ","+ data.time);
							opener.parent.search();
						} else {
						}
					},
					error : function(error) {
						alert("error");
					}
				});
				
				$.ajax({
					   url: "/chat/insertChatFile", //컨트롤러 URL
						 data: formData,
						 dataType: 'json',
						 processData: false,
						 contentType: false,
						 type: 'POST',
						 success: function (response) {
							if(fileExt == "jpg" || fileExt == "png" ||  fileExt == "gif" ||  fileExt == "bmp"){ //확장자를 확인합니다.
								wsocket.send("msg-i:" +response.mem_id +","+ nickname + "," +"<a href=/chat/fileDownload?chat_file_no="+response.chat_file_no+"><img src=/chat/img?chat_file_no="+response.chat_file_no+"></a>"+","+response.time);
								opener.parent.search();
							}else{
								wsocket.send(
									"msg-f:" +response.mem_id +","+ nickname + "," 
									+ "<a href=/chat/fileDownload?chat_file_no="+response.chat_file_no+">"+
											"<i class=\"dis-inblock maright-10 file-icon-s file-default\"></i>" + fileName
									+"</a>"+","+response.time);
								opener.parent.search();
							}
						 },error: function (jqXHR) {
						   alert(jqXHR.responseText);
						 }
			   		 });
			}
	
			$('#message').val('');
			$('#sendFile').val('');
			
		}
		
		function appendMessage(msg) {
			$('#chatMessageArea').append(msg);
			
			// 채팅 추가되면 스크롤 자동밑으로
			var objDiv = document.getElementById("chatArea");
			objDiv.scrollTop = objDiv.scrollHeight;
			
			opener.parent.search(); // 채팅리스트 리셋
			
			var chat_no = ${chatVo.chat_no};
			
			//채팅 유저 리스트 갱신
			$.ajax({
				url : "/chat/chatUserList",
				data : {chat_no:chat_no},
				dataType : 'json',
				type : 'POST',
				success : function(data) {
					var str = "";
					
					$.each(data.chatUserList, function(index, chatUserList){
						str += "<div class=\"user-list\">";
							str += "<div class=\"user-profile-img\">";
								str += "<i class=\"icon-circle circle-s\"></i>";
								str += "<img src=\"/mem/pic?mem_id=" + chatUserList.mem_id + "\" width=\"40\">";
							str += "</div>";
							str += "<div class=\"user-profile-info\">";
								str += "<strong class=\"size-14 color-black\">" + chatUserList.mem_nick + "</strong>";
							str += "</div>";
						str += "</div>";
					});
					
					$(".chat-aside-con").html(str);
					
				},
				error : function(data) {
					alert("실패");
				}
			});
			
		}
		
		//글자수 제한 체크 
		function len_chk(){  
		  var frm = $("#message").val(); 
		     
		  if(frm.length > 4000){  
		       alert("글자수는 영문4000, 한글2000자로 제한됩니다.!");  
		       frm = frm.substring(0,4000);  
		       $("#message").focus();  
		  } 
		}
		
		$(document).ready(function() {
			$('#message').keypress(function(event) {
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if(keycode == '13') {
					send();
				}
				event.stopPropagation();
			});
			$('#sendBtn').click(function(){
				send();
			});
			$('#enterBtn').click(function(){
				if($('#nickname').val() == ''){
					alert('이름을 입력하세요!');
					$('#nickname').focus();
					return;
				}
				connect();
			});
			
			// 채팅방 들어가기전에 나가면 채팅방에 안 떠야 하는거 아님요
			$('.exitBtn').click(function(){
				var chat_no = ${chatVo.chat_no };
				var mem_id = "${memberVo.mem_id}";
				
				$.ajax({
					url: "/chat/deleteChat", 
					data: {chat_no:chat_no, mem_id:mem_id},
					dataType: 'json',
					type: 'POST',
					success: function (data) {
						$(opener.document).find("#chat_no"+chat_no).remove();
						disconnect();
						self.close();
					},
					error: function (data) {
						alert("실패");
					}
				});
			});
			
		});
	</script>
</head>

<body style="min-width: 455px; position: relative; height:650px; overflow:hidden; background:#fff;" >
	
	<!-- chat aside : s -->
	<aside class="chat-room-aside">
		<strong class="aside-tit">채팅 참여자 목록</strong>
		
		<div class="chat-aside-con">
			<c:forEach items="${chatUserList }" var="userList">
			<div class="user-list">
				<!-- user profile img -->
				<div class="user-profile-img">
					<i class="icon-circle circle-s"></i>
					<img src="/mem/pic?mem_id=${userList.mem_id }" width="40">
				</div>
				
				<!-- user profile info -->
				<div class="user-profile-info">
					<strong class="size-14 color-black">${userList.mem_nick }</strong>
				</div>
			</div>
			</c:forEach>
		</div>
		
		<!-- aside footer -->
		<div class="aside-footer">
			<a href="#close" class="exitBtn float-left size-14">
				<i class="fas fa-sign-out-alt maright-10"></i>나가기
			</a>
			
			<a href="#chatRoomModify" class="my-pop-on float-right">
				<i class="fas fa-cog color-gray"></i>
			</a>
		</div>
		
	</aside>
	<!-- chat aside : f -->
	
	<!-- 메뉴버튼 클릭하면 화면이 어두워지게 -->
	<div class="overlay"></div>
	
	<input type="hidden" id="nickname" value=${nick }>
		
	<!-- body wrap full : s -->
	<div class="body-wrap-full">

		<!-- chat room header : s -->
		<header class="chat-room-head back-color-pupple-l">
		
			<!-- chat room title : s -->
			<strong class="chat-room-title dis-block size-18 color-white">${chatVo.chat_title }</strong>
			<!-- chat room title : f -->
			
			<!-- char aside button -->
			<i class="fas fa-bars chat-room-aside-btn size-24 color-white cursor-point"></i>
			
			<script type="text/javascript">
			$(function(){
				// aside toggle button clicked
				$(".chat-room-aside-btn").on("click", function(){
					var aside = $(".chat-room-aside");
					
					if(aside.css("right") == "-230px"){
						aside.css("right", "0");
						$(".overlay").show();
					} else {
						aside.css("right", "-230px");
						$(".overlay").hide();
					}
				});
				
				// overlay clicked
				$(".overlay").on("click", function(){
					$(".chat-room-aside").css("right", "-230px");
					$(this).fadeOut();
				});
			});
			</script>
			
		</header>
	
		<!-- 채팅화면 -->
		<div id="chatArea">
			<div id="chatMessageArea" >
			</div>
		</div>
		
		<!-- fileBox : s -->
		<div class="fileBox">
			<form id="FILE_FORM" method="post" enctype="multipart/form-data" action="/chat/insertChatFile">
				<label for="sendFile" class="fileLable"></label>
				<input type="file" id="sendFile" name="sendFile">
				<p class="fileName"></p>
				<input type="hidden" id="chat_no" name="chat_no" value="${chatVo.chat_no }">
				<input type="hidden" id="mem_id" name="mem_id" value="${memberVo.mem_id }">
			</form>
			<script type="text/javascript">
				// 파일 선택시 파일명추가
				$(document).ready(function(){
					$('input[type=file]').change(function(e){
						 $(".fileName").text($('input[type=file]')[0].files[0].name); 
					});	
					$("#sendBtn").on("click",function(){
						$(".fileName").empty();
					});
				});
			</script>
		</div>
		<!-- fileBox : f -->
		
		<!-- msgBox : s -->
		<div class="msgBox">
			<textarea rows="3" id="message"  onkeyup="len_chk()" placeholder="메세지를 입력하세요."></textarea>
			<input type="button" id="sendBtn" value="전송">
		</div>
		<!-- msgBox : f -->

		<!-- 채팅 수정 클릭시 팝업창  -->
		<div class="dim-layer">
			<div class="dimBg"></div>
		    <div id="chatRoomModify" class="pop-layer pop-layer-style" style="width: 350px; margin-left: -167px;">
				<!-- pop header -->
	    		<header class="pop-top border-box">
	    			채팅방이름 변경
	    			<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
	    		</header>
			
	    		<!-- pop con -->
		   		<section class="pop-con border-box" style="margin: 15px 0;">
		   			<div class="prof_thumb">
			   			<input type="text" name="chatRoom_name" id="chatRoomName" class="pop-input input-line" placeholder="채팅방명 입력(최대 30자)" required="required"
			   			style="width: 87%; margin: 0px 10px;" value="${chatVo.chat_title }">
		   			</div>
				</section>
				<!-- pop footer -->
				<footer class="pop-footer border-box">
					<input type="button" class="pop-btn default-btn btn-close" value="취소">
					<input type="button" class="pop-btn submit-btn marleft-5 back-color-pupple-l btn-close" id="modify-btn" value="변경하기"/>
				</footer>
			</div>
		</div>
		
		<script type="text/javascript">
		// 채팅 팝업 동료 탭에서 내 프로필 클릭시 자세히보기
		$('.my-pop-on').click(function(){
			var $href = $(this).attr('href');
			layer_popup($href);
		});
		
		//채팅방 이름 수정시 팝업
		$("#modify-btn").on("click", function(){
			// 송희 :: 채팅내용저장 , ajax 채팅리스트 동적으로 변경함 
			var chat_name = $("#chatRoomName").val();
			
			$.ajax({
				url : "/chat/chatModify",
				method : "POST",
				dataType : "json", // server로 부터 받을 data type
				data : {chatRoom_name:chat_name, chat_no:"${chatVo.chat_no }", mem_id:"${memberVo.mem_id }", nick:"${memberVo.mem_nick }", chat_ip:"${chatVo.chat_ip}"},
				success : function(data) {
					var str = "<a>"+data.chat_title+"</a>";
					$(".chatRoomTitle").html(str);
					opener.parent.search();
					send();
				},
				error : function(error) {
					alert("error");
				}
			});
		});
		
		</script>
		<script src="<%=request.getContextPath() %>/js/layerPop.js"></script>
	
	</div>
	<!-- body wrap full : f -->
	
	
</body>
</html>