<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<section class="col-md-10 admin-con-wrap">
	
	<!-- title -->
	<div class="dis-block posi-re">
		<strong class="dis-inblock size-30 color-black">프로젝트 관리</strong>
		<span class="dis-inblock marleft-15 size-18 color-gray">Project Management</span>
	</div>
	
	
	<!-- project kind edit box:s -->
	<div class="admin-content martop-20">
		
		<strong class="dis-block font-bold size-20 marbtm-15">프로젝트 분류</strong>
		
		<table class="table">
			<colgroup>
				<col width="20%">
				<col width="35%">
				<col width="35%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<td>분류명</td>
					<td>분류명</td>
					<td>등록일</td>
					<td>삭제여부</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${kindAllList }" var="list" varStatus="kindStatus">
					<tr>
						<td>FK0000${kindStatus.count }</td>
						<td>${list.kind_name }</td>
						<td><fmt:formatDate value="${list.kind_date }" pattern="yyyy-MM-dd hh:ss"/></td>
						<td>
							<span class="del-chk-btn back-color-green cursor-point" onclick="fn_delChk(this)">
								<i class="del-chk-circle on"></i>
								<input type="hidden" value="${list.kind_no }" class="kind_no">
							</span>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="kind-insert-box martop-20">
			<form action="/kind/insert">
				<input type="text" name="kind_name" placeholder="추가할 분류명을 입력하세요" value=""><input type="submit" class="color-white default-back-color" value="등록">
			</form>
		</div>
	</div>
	<!-- project kind edit box:f -->
		
	<!-- project list box:s -->
	<div class="admin-content pro-list-box martop-20">
		
		<strong class="dis-block font-bold size-20 marbtm-15">프로젝트 목록</strong>
		
		<table class="table">
			<colgroup>
				<col width="5%">
				<col width="30%">
				<col width="15%">
				<col width="20%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<td>No</td>
					<td>프로젝트 명</td>
					<td>분류명</td>
					<td>관리자</td>
					<td>등록일</td>
					<td>삭제여부</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${proPageAllList }" var="list">
					<tr>
						<td>${list.rn }</td>
						<td>${list.pro_name }</td>
						<td>${list.kind_name }</td>
						<td>${list.mem_nick }(${list.mem_id })</td>
						<td><fmt:formatDate value="${list.pro_date }" pattern="yyyy-MM-dd hh:ss"/></td>
						<td>${list.pro_del_chk }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- admin_proEdit pagination : s -->
		<div class="text-center">
			<ul class="pagination">
 				${pageNavi }
			</ul>
		</div>
		<!-- admin_proEdit pagination : f -->
		
	</div>
	<!-- project list box:f -->
</section>