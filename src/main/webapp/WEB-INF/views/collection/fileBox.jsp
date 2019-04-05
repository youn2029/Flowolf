<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<section class="content">

	<!-- file all content : s -->
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	
		<!-- file all top : s -->
		<div class="coll-file-top dis-block marbtm-20">
		
			<!-- file box title -->
			<c:choose>
				<c:when test="${filesKind == 'pro' }">
					<strong class="size-20 color-gray">프로젝트 : ${proVo.pro_name } (${filesList.size() })</strong>					
				</c:when>
				<c:otherwise>
					<strong class="size-20 color-gray">전체 파일 (${filesList.size() })</strong>
				</c:otherwise>
			</c:choose>
			
			<!-- file box search : s -->
			<div class="file-search-box">
				<i class="fas fa-search color-gray"></i>
				<input type="text" id="searchFilter" onkeyup="{ filter(this); return false; }" 
				onkeypress="javascript:if(event.keyCode==13){ filter(this); return false; }">
			</div>
			<!-- file box search : f -->
		</div>
	
		<!-- collection content wrap : s -->
		<div class="collection-con-wrap files-con-wrap">
			
			<table class="table marbtm-0 text-center" style="letter-spacing:0">
				<colgroup>
					<col width="5%">
					<col width="40%">
					<c:if test="${filesKind != 'pro' }">
						<col width="15%">						
					</c:if>
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<td>번호</td>
						<td>파일명</td>
						<c:if test="${filesKind != 'pro' }">
							<td>프로젝트명</td>
						</c:if>
						<td>작성자</td>
						<td>등록일</td>
						<td>파일크기</td>
						<td>다운로드</td>
					</tr>
				</thead>
				<tbody id="filesTbody">
					<c:forEach items="${filesList }" var="filesVo" varStatus="fileStatus">
						<tr data-name="${filesVo.files_name }">
							<td>${fileStatus.count }</td>
							<td class="files-name-td">
								<i class="dis-inblock file-icon-s" data-name="${filesVo.files_name }"></i>
								<span class="dis-inblock">${filesVo.files_name }</span>
							</td>
							<c:if test="${filesKind != 'pro' }">
								<td>${filesVo.pro_name }</td>
							</c:if>
							<td>${filesVo.mem_nick }</td>
							<td><fmt:formatDate value="${filesVo.files_time }" pattern="yy/MM/dd"/> </td>
							<td>${filesVo.files_size }</td>
							<td>
								<a href="/files/download?files_no=${filesVo.files_no }" class="coll-file-down-btn dis-inblock"><i class="fas fa-download"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
		<!-- collection content wrap : f -->

	</div>
	<!-- file all content : f -->
	<script type="text/javascript">
		$(function(){
			
			// 첨부파일 이미지 바꾸기
			$("#filesTbody tr").each(function(i, e){
				var iconTag = $(this).find("i.dis-inblock");
				var dataName = iconTag.attr("data-name");
				fileExCheck(iconTag);
			});
			
		});
	</script>
	
</section>