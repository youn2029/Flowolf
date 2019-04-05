<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>폴링테스트 db check test</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
(function(){
	var poll = function(){
		$.ajax({
			url : '/schd/dbcheck', 	//요청 보내는 url
			type : 'get',			//메서드 타입
			dataType : 'json', 		//서버로부터 되돌려 받는 데이터타입 명시
			data : 
				{
				"member_id" : "${mem_id}"
				},
			success : function(data){
				console.log(data.test);
// 				console.log(data.string);
// 				console.log(data.test.t2);
				$('#t1').val(data.test.length);
				for(var i=0 ; i<data.test.length ; i++){
					$('#h'+(i+1)).html(data.test[i].schd_title);
				}
				console.log(data);	
				alert('현재 알림은'+data.test.length+'입니다');
					
			},
			error:function(request, status, error){
				console.log("[ajax error]");
				console.log("code:"+request.status+"\n"+"message : "+request.responseText+"\n"+"error:"+error);
			}
		});	
	};
	poll();
	
	setInterval(function(){
		poll();
	}, 6000);
})
();
	
</script>
<body>
총 알림 갯수는 : <input id="t1"><br>
알림 내용은 : <label id="h1"></label><br>
알림 내용은 : <label id="h2"></label><br>
알림 내용은 : <label id="h3"></label>
</body>
</html>