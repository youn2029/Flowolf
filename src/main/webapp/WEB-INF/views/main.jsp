<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section class="content main">

	<!-- alertCustom -->
	<input type="hidden" class="alert-msg" value="${msg }">
	<input type="hidden" class="alert-className" value="${className }">
	<script type="text/javascript">
		$(function(){
			var msg = $(".alert-msg").val();
			var className = $(".alert-className").val();
			
			if(msg.length != 0){
				alertCustom(msg, className);
				<%
					session.setAttribute("msg", "");
					session.setAttribute("className", "");
				%>
			}
		});
	</script>

	<!-- total count -->
	<h1>전체(${myProList.size() })</h1>
	
	<!-- project list:s -->
	<div class="project-wrap">
		<div class="col-xs-12 col-sm-6 col-md-3 col-lg-2">
			<a href="#addProject" class="project-box add-project add-pro-link">
				<i class="flow-icon icon-plus"></i>
				<strong class="dis-block martop-10 size-24 color-blue-l text-center">프로젝트 만들기</strong>
			</a>
		</div>
		
		<c:forEach items="${myProList }" var="proList">
			<div class="col-xs-12 col-sm-6 col-md-3 col-lg-2">
				<div class="project-box">
					<!-- project title box -->
					<div class="pro-tit-box ${proList['proVo'].pro_user_color }">
						<c:choose>
							<c:when test="${proList['proVo'].imp_chk == 1 }">
								<div class="check-import" data-prono="${proList['proVo'].pro_no }"><i class="fas fa-star size-20 color-yellow cursor-point"></i></div>
							</c:when>
							<c:otherwise>
								<div class="check-import" data-prono="${proList['proVo'].pro_no }"><i class="fas fa-star size-20 color-gray-l cursor-point"></i></div>
							</c:otherwise>
						</c:choose>
						<span class="dis-block size-24 color-white text-center cursor-point pro-click">${proList['proVo'].pro_name }</span>
					</div>
					
					<!-- project member list -->
					<div class="pro-mem-list-box dis-block cursor-point pro-click-mem">
						<ul class="pro-mem-photo">
							<c:forEach items="${proList['proUserList'] }" var="proUserVo" end="2">
								<li>
									<i class="icon-circle circle-s"></i>
									<img src="/mem/pic?mem_id=${proUserVo.mem_id }" width="40px">
								</li>								
							</c:forEach>
						</ul>
						<div class="pro-mem-info">
							<c:choose>
								<c:when test="${proList['proUserList'].size()-1 == 0 }">
									<strong>${memVo.mem_nick }</strong>님 참여중
								</c:when>
								
								<c:otherwise>
									<strong>${proList['proUserList'][0].mem_nick }</strong>님 외 ${proList['proUserList'].size()-1 }명
								</c:otherwise>								
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<form id="detailFom" action="/pro/detail" method="get">
		<input type="hidden" id="prono" name="pro_no" value="" >
	</form>
	
	<script type="text/javascript">
	$(function(){
		
		// 프로젝트 타이틀 길이에 따라 위치 다르게 적용하기
		$(".pro-click").each(function(){
			var height = $(this).height();
			var result = -(height / 2) + 10;
			$(this).css("margin-top", result+"px");
		});
		
		// project import check(main page)
		$(".check-import").on("click", function(){
			if($(this).find("i").hasClass("color-gray-l")){
				$(this).find("i").removeClass("color-gray-l");
				$(this).find("i").addClass("color-yellow");				
				
				var pro_no = $(this).data("prono");		
				
				$.ajax({					
					
					url : "/imp/insert",
					method : "get",
					data : {pro_no:pro_no},
					dataType : "json",
					success : function(data){
						if(data==1){
							alertCustom("변경되었습니다.", "alert-warning");
						}
					}
				});
			} else {
				$(this).find("i").removeClass("color-yellow");
				$(this).find("i").addClass("color-gray-l");
				
				var pro_no = $(this).data("prono");			
				
				$.ajax({					
					
					url : "/imp/delete",
					method : "get",
					data : {pro_no:pro_no},
					dataType : "json",
					success : function(data){
						if(data==1){
							alertCustom("변경되었습니다.", "alert-warning");
						}
					}
				});
			}
		});
		
		// pro-click 클릭이벤트
		$(".pro-click").click(function(){
			var pro_no = $(this).siblings(".check-import").data("prono");
			$("#prono").val(pro_no);
			$("#detailFom").submit();
		});
		
		// pro-click-mem 클릭이벤트
		$(".pro-click-mem").click(function(){
			var item = $(this);
			var proClick = item.siblings(".pro-tit-box").children(".pro-click");
			proClick.click();
		});
		
	});
	</script>
	<!-- project list:f -->
	
</section>