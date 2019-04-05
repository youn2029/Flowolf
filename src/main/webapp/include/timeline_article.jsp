<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="timeline-article con-article">
	<!-- 내용:s -->
	<div class="article-txt">
		<pre>${timeLine.basicVo.basic_cont }</pre>		
	</div>
	<!-- 내용:f -->
	
	<!-- 이미지:s -->
	<div class="article-img martop-20">
		<div class="swiper-container-img">
			<div class="swiper-wrapper">
				<c:forEach items="${timeLine.filesList }" var="filesVo">
					<c:if test="${filesVo.files_kind == 'img' }">
						<div class="swiper-slide img-con" style="background-image:url('/files/view?files_no=${filesVo.files_no}')"></div>
					</c:if>
				</c:forEach>
			</div>
			<!-- Add Arrows -->
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>
	</div>
	<!-- 이미지:f -->
	
	<!-- 파일리스트:s -->
	<div class="article-file float-left" style="width:100%;">
		<c:forEach items="${timeLine.filesList }" var="filesVo">
			<c:if test="${filesVo.files_kind == 'fil' }">
				<div class="upload-file-info float-left martop-20">
					<dl>
						<dt>
							<i class="dis-inblock file-icon" data-name="${filesVo.files_name }"></i>
						</dt>
						<dd>
							<span class="dis-block size-18 color-black">${filesVo.files_name }</span>
							<span class="dis-block martop-5 size-14 color-gray">${filesVo.files_size }</span>
						</dd>
					</dl>
					<a href="/files/download?files_no=${filesVo.files_no }" class="file-down-btn"><i class="fas fa-download maright-10"></i> 다운로드</a>
				</div>
			</c:if>
		</c:forEach>
	</div>
	<!-- 파일리스트:f -->
</div>

	
<!-- 일반 게시글 수정:s -->
<form action="/basic/update" method="post" class="article-edit-form" enctype="multipart/form-data">
	<input type="hidden" name="basic_no" value="${timeLine.basicVo.basic_no }">

	<!-- article edit box:s -->
	<div class="article-edit-box">
		<textarea rows="5" cols="50" placeholder="글을 작성하세요." name="basic_cont"
		onkeyup="autoTextarea(this, 120, 500)" required="required">${timeLine.basicVo.basic_cont }</textarea>
		
		<!-- 이미지 목록이 나올부분 -->
		<div class="upload-img-list">
			<c:forEach items="${timeLine.filesList }" var="filesVo">
				<c:if test="${filesVo.files_kind == 'img' }">
					<div class="upload-img-info martop-20" data-no="${filesVo.files_no }">
						<div class="upload-img" style="background-image:url('/files/view?files_no=${filesVo.files_no}')"></div>
						<i class="fas fa-times-circle img-close-btn" onclick="fileDelete(this)"></i>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<!-- 첨부파일 목록이 나올부분 -->
		<div class="upload-file-list">
			<c:forEach items="${timeLine.filesList }" var="filesVo">
				<c:if test="${filesVo.files_kind == 'fil' }">
					<div class="upload-file-info martop-20" data-no="${filesVo.files_no }">
						<dl>
							<dt>
								<i class="dis-inblock file-icon" data-name="${filesVo.files_name }"></i>
							</dt>
							<dd>
								<span class="dis-block size-18 color-black">${filesVo.files_name }</span>
								<span class="dis-block martop-5 size-14 color-gray">${filesVo.files_size }</span>
							</dd>
						</dl>
						<i class="far fa-times-circle file-close-btn" onclick="fileDelete(this)"></i>
					</div>
				</c:if>
			</c:forEach>	 
		</div>
	</div>
	<!-- article edit box:f -->
	
	<!-- article edit dn:s -->
	<div class="article-edit-dn">
		<!-- 파일첨부 -->
		<label for="articleEditFile_b${timeLine.basicVo.basic_no }" class="float-left maright-20 marbtm-0 font-thin size-18">
			<i class="fas fa-paperclip maright-10"></i>파일첨부
		</label>
		<input type="file" name="articleFile" id="articleEditFile_b${timeLine.basicVo.basic_no }" class="dis-none" onchange="fileUpload(this)">
		
		<!-- 이미지첨부 -->
		<label for="articleEditImg_b${timeLine.basicVo.basic_no }" class="float-left marbtm-0 font-thin size-18">
			<i class="fas fa-camera maright-10"></i>이미지첨부
		</label>
		<input type="file" name="imageFile" id="articleEditImg_b${timeLine.basicVo.basic_no }" class="dis-none" onchange="imgUpload(this)" accept="image/*">
		
		<!-- submit & cancel 버튼 -->
		<input type="submit" value="수정하기" class="article-submit-btn font-bold size-16 color-white text-center default-back-color">
		<input type="button" value="취소" onclick="fn_editCancel(this)" 
		class="article-submit-btn maright-10 font-bold size-16 color-gray text-center back-color-white"
		style="border:1px solid #ddd">
	</div>
	<!-- article edit dn:f -->
</form>
<!-- 일반 게시글 수정:f -->
			