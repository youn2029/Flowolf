<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="col-md-10 admin-con-wrap">
	
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
	
	<!-- title -->
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
		<div class="mem-search-box">
			<form action="/adm/search" method="get">
				<select class="flow-icon" name="searchField">
					<option value="post_title">제목</option>
					<option value="post_cont">내용</option>
				</select>
				<input type="hidden" value="${post_kind }" name="post_kind">
				<input type="text" name="searchData" class="marleft-5" placeholder="검색할 내용을 입력하세요">
				<button type="submit" class="default-back-color"><i class="fas fa-search color-white"></i></button>
			</form>
		</div>
	</div>
	
	<!-- article list box:s -->
	<div id="post-list-table" class="post-content admin-content martop-20">
		<table class="table table-hover">
			<colgroup>
				<col width="5%">
				<col width="50%">
				<col width="20%">
				<col width="25%">
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
		<form action="/adm/insertView" method="get" class="martop-30">
			<input type="hidden" name="post_kind" value="${post_kind }"/>
			<input type="submit" class="post-insert-btn float-right color-white back-color-pupple-l" value="글쓰기"/>
		</form>
		<!-- post insert button : f -->
		
		<!-- post pagination : s -->
		<div class="text-center">
			<ul class="pagination">
 				<%=request.getAttribute("pageNavi") %> 
			</ul>
		</div>
		<!-- post pagination : f -->
		
		<!-- post detail form : s-->
		<form id="post-list-form" action="/adm/postDetail" method="get">
			<input type="hidden" id="pno" name="post_no">
		</form>
		<script type="text/javascript">
		$(function(){
			
			$("#post-list-table tbody tr[data-id]").on("click", function(){
				var item = $(this);
				var dataId = item.attr("data-id");
				
				$("#pno").val($(this).data("id"));
				$("#post-list-form").submit();
				
			});
		});
		</script>
		<!-- post detail form : f-->
		
	</div>
	<!-- article list box:f -->
	
</section>