
<%@page import="kr.or.dev.board.post.model.PostVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.dev.user.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

<section class="content main">

	<!-- post list top : s -->
	<div class="dis-block posi-re">
		<c:choose>
			<c:when test="${post_kind == 'qa' }">
				<strong class="dis-inblock size-30 color-black">문의게시판</strong>
				<span class="dis-inblock marleft-15 size-18 color-gray">Q & A</span>
			</c:when>
			<c:otherwise>
				<strong class="dis-inblock size-30 color-black">공지사항</strong>
				<span class="dis-inblock marleft-15 size-18 color-gray">Notice</span>
			</c:otherwise>
		</c:choose>
		
		<!-- search -->
		<div class="post-search-box">
			<form action="/post/search" method="get">
				<select class="flow-icon" name="searchField">
					<option value="post_title">제목</option>
					<option value="post_cont">내용</option>
					<c:if test="${post_kind == 'qa' }"><option value="mem_nick">작성자</option></c:if>
				</select>
				<input type="text" name="searchData" class="marleft-5" placeholder="검색할 내용을 입력하세요">
				<input type="hidden" value="${post_kind }" name="post_kind">
				<button type="submit" class="default-back-color"><i class="fas fa-search color-white"></i></button>
			</form>
		</div>
	</div>
	<!-- post list top : f -->
	
	<!-- post list content : s -->
	<div id="post-list-table" class="post-content martop-20">
		<table class="table table-hover">
			<colgroup>
				<col width="8%">
				<col width="68%">
				<col width="12%">
				<col width="12%">
			</colgroup>
			<thead>
				<tr>
					<td>No</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${postList }" var="post">
					<c:choose>
						<c:when test="${post.post_del_chk == 'n' }">
						<tr data-id="${post.post_no }">
							<td>${post.post_no }</td>
							<td class="text-left">
								<c:if test="${post.post_pw_chk == 'y'}"><i class="fas fa-lock maright-10 color-gray"></i></c:if>
								${post.post_title }
							</td>
							<td>${post.mem_nick }</td>
							<td><fmt:formatDate value="${post.post_date }" pattern="yyyy-MM-dd"/></td>
						</tr>
						</c:when>
					</c:choose>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- post insert button : s -->
		<c:if test="${post_kind == 'qa' }">
		<form action="/post/insertView" method="get" class="martop-30">
			<input type="hidden" name="post_kind" value="${post_kind }"/>
			<input type="submit" class="post-insert-btn float-right color-white back-color-pupple-l" value="글쓰기"/>
		</form>
		</c:if>
		<!-- post insert button : f -->
		
		<!-- post pagination : s -->
		<div class="text-center">
			<ul class="pagination">
 				<%=request.getAttribute("pageNavi") %> 
			</ul>
		</div>
		<!-- post pagination : f -->
		
		<!-- 비밀글 비밀번호 확인 팝업창 : s -->
		<div class="dim-layer">
			<div class="dimBg"></div>
			
		    <div id="checkSecretPost" class="pop-layer">
	    		<!-- pop header -->
	    		<header class="pop-top border-box">
	    			비밀번호 확인
	    			<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
	    		</header>
	    		
	    		<!-- pop con -->
		   		<section class="pop-con border-box">
		   			<input type="password" name="post_pw" class="pop-input" placeholder="비밀글에대한 비밀번호를 입력해주세요." required="required">
				</section>
				
				<!-- pop footer -->
				<footer class="pop-footer border-box">
					<input type="button" class="pop-btn default-btn btn-close" value="취소">
					<input type="button" name="passCheckBtn" class="pop-btn submit-btn marleft-5 back-color-pupple-l" value="확인">
				</footer>
			</div>
			
		</div>
		<!-- 비밀글 비밀번호 확인 팝업창 : f -->
		
		<!-- post detail form : s-->
		<form id="post-list-form" action="/post/detail" method="get">
			<input type="hidden" id="pno" name="post_no">
		</form>
		<script type="text/javascript">
		$(function(){
			
			$("#post-list-table tbody tr[data-id]").on("click", function(){
				var item = $(this);
				var dataId = item.attr("data-id");
				
				if(item.find("i.fas.fa-lock").length > 0){
					layer_popup("#checkSecretPost");
					$("#checkSecretPost").find("input[type=password]").focus();
					
					$("#checkSecretPost .submit-btn").on("click", function(){
						
						var post_no = dataId;
						var post_pw = $('#checkSecretPost').find('input[type=password]').val();
						
						$.ajax({
							url : "/post/passCheck",
							method : "post",
							dataType : "json",					// server로 부터 받을 data type
							data : {post_no:post_no, post_pw:post_pw},
							success : function(data){
								if(data==1){
									$("#checkSecretPost").parent(".dim-layer").fadeOut();
									$("#pno").val(post_no);
									$("#post-list-form").submit();
								} else {
									alertCustom("비밀번호가 일치하지 않습니다.", "alert-danger");
								}
							}
						});
						
					});
				} else {
					$("#pno").val($(this).data("id"));
					$("#post-list-form").submit();
				}
			});
		});
		</script>
		<!-- post detail form : f-->
	</div>
	<!-- post list content : f -->
	
</section>

	