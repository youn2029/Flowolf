<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="col-md-10 admin-con-wrap">

	<!-- post detail wrap : s -->
	<div class="post-detail-wrap float-left">
	
		<!-- post detail header : s-->
		<div class="post-header">
			<div class="post-nav float-left marbtm-20">
				<a href="/adm/memList" class="color-gray">HOME</a>
				<a href="/adm/postList?post_kind=${postVo.post_kind }" class="color-gray">
					<c:choose>
						<c:when test="${postVo.post_kind == 'qa' }">문의게시판</c:when>
						<c:otherwise>공지사항</c:otherwise>
					</c:choose>
				</a>
			</div>
			<strong class="float-left marbtm-30 size-30 color-black">${postVo.post_title }</strong>
			<ul class="post-info float-left">
				<li><i class="far fa-user maright-5"></i> ${postVo.mem_nick }</li>
				<li><i class="far fa-clock maright-5"></i> <fmt:formatDate value="${postVo.post_date }" pattern="yyyy.MM.dd hh:mm"/> </li>
			</ul>
		</div>
		<!-- post detail header : f-->

		<!-- post detail contents : s -->
		<div class="post-detail-content">
			<div class="article-txt">
				<pre>${postVo.post_cont}</pre>
			</div>
				
			<!-- 게시글 첨부파일 : s -->
			<div class="article-file float-left" style="width:100%;">
				<c:forEach items="${filesList }" var="list">
				<div class="upload-file-info float-left martop-20">
					<dl>
						<dt>
							<i class="dis-inblock file-icon file-default"></i>
						</dt>
						<dd>
							<span class="dis-block size-18 color-black">${list.files_name }</span>
							<span class="dis-block martop-5 size-14 color-gray">${list.files_size }</span>
						</dd>
					</dl>
					<a href="/files/download?files_no=${list.files_no }" class="file-down-btn"><i class="fas fa-download maright-10"></i> 다운로드</a>
					<input type="hidden" name="articleFile" value="fileValue">
				</div>
				</c:forEach>
			</div>
			<!-- 게시글 첨부파일 : f -->
		
			<!-- 게시글 버튼(목록/수정/삭제/글쓰기) : s -->
			<div class="post-btn-box">
				<a href="/adm/postList?post_kind=${postVo.post_kind }">목록</a>
			
				<ul class="float-right marbtm-0">
					<li><a href="/adm/updateView?post_no=${postVo.post_no }">수정</a></li>
					<li><a class="post-delete-btn" data-no="${postVo.post_no }" style="cursor:pointer">삭제</a></li>
					<li><a href="/adm/insertView" class="color-white back-color-pupple-l">글쓰기</a></li>
				</ul>
			</div>
			<!-- 게시글 버튼(목록/수정/삭제/글쓰기) : f -->
			
		</div>
		<!-- post detail contents : f -->
		
	</div>
	<!-- post detail wrap : f -->
		
	<!-- post detail footer : s -->
	<div class="post-footer">

		<!-- 댓글박스 : s -->
		<div class="post-comment-box">
			<c:forEach items="${postReplyList }" var="postRep">
			<c:if test="${postRep.post_rep_del_chk == 'n' }">
			<div class="post-comment-list">
			
				<!-- 댓글 작성자 프로필 : s -->
				<div class="post-comment-img">
					<i class="icon-circle circle-s-re"></i>
					<img src="/mem/pic?mem_id=${postRep.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="40">
				</div>
				<!-- 댓글 작성자 프로필 : f -->
				
				<!-- 댓글 내용 : s -->
				<div class="post-comment-con">
							
					<!-- 댓글 작성자 정보 -->
					<div class="dis-inblock comment-user-info">
						<div class="dis-inblock font-bold size-15 color-black maright-10">${postRep.mem_nick }</div>
						<div class="dis-inblock size-15 color-gray maright-20">
							<fmt:formatDate value="${postRep.post_rep_date }" pattern="yyyy-MM-dd hh:mm"/>
						</div>
						<i class="fas fa-edit dis-inblock size-15 color-gray cursor-point" onclick="fn_postCommentEdit(this)"></i>
						<i class="fas fa-trash-alt dis-inblock size-15 color-gray cursor-point" data-no="${postRep.post_rep_no}" onclick="fn_postCommentDel(this)"></i>
					</div>
					
					<!-- 댓글내용 -->
					<div class="article-txt martop-5">
						<pre class="font-thin size-16 color-gray">${postRep.post_rep_cont }</pre>
					</div>
					
					<!-- 댓글 수정 박스 : s -->
					<div class="comment-edit-box martop-5">
						<form action="/postReply/update" method="post">
							<input type="hidden" name="post_no" value="${postVo.post_no }">
							<input type="hidden" name="post_rep_no" value="${postRep.post_rep_no }">
							<div class="comment-textarea">
								<textarea name="post_rep_cont"
								placeholder="댓글을 입력하세요.(Enter는 입력, shift + Enter는 줄바꿈)"
								onkeyup="autoTextarea(this, 60, 300)" onkeydown="fn_keyDownEsc(event, this)" required>${postRep.post_rep_cont }</textarea>
							</div>
							<div class="dis-block float-left martop-5 size-13 color-gray">
								<span class="default-color">Enter</span>는 <span class="color-green">등록</span>,
								<span class="default-color">Shift + Enter</span>는 <span class="color-green">줄바꿈</span>,
								<span class="default-color">취소</span> 하실려면 <span class="color-red">Esc</span>키를 누르세요.
							</div>
						</form>
					</div>
					<!-- 댓글 수정 박스 : f -->
				</div>
			</div>
			</c:if>
			</c:forEach>
			
			<!-- 댓글 삭제 레이어 팝업 : s -->
			<div class="dim-layer">
				<div class="dimBg"></div>
				
			    <div id="deletePostReply" class="pop-layer">
		    		<!-- pop con -->
			   		<section class="pop-con border-box">
			   			<p class="marbtm-0 padtop-20 size-20 color-gray text-center">
			   				<span class="color-pupple-l">댓글</span>을 정말로 <span class="color-red">삭제</span>하시겠습니까?<br>
			   				<span class="color-red">삭제</span>된 댓글은 복구할 수 없습니다.
			   			</p>
					</section>
					
					<!-- pop footer -->
					<footer class="pop-footer border-box">
						<input type="button" class="pop-btn default-btn btn-close" value="취소">
						<input type="button" class="pop-btn submit-btn marleft-5 back-color-pupple-l" value="삭제하기">
					</footer>
				</div>
			</div>
			<!-- 댓글 삭제 레이어 팝업:f -->
			
			<script type="text/javascript">
			function fn_postCommentDel(el){
				var item = $(el);
				var post_rep_no = item.attr("data-no");
				
				layer_popup("#deletePostReply");
				
				$("#deletePostReply .submit-btn").on("click", function(){
					
					$.ajax({
						url : "/postReply/delete?post_rep_no="+post_rep_no,
						dataType : "json",
						success : function(data){
							$("#deletePostReply").parent(".dim-layer").fadeOut();
							item.parent().parent().parent(".post-comment-list").remove();
							alertCustom("댓글이 삭제되었습니다", "alert-danger");
						}
					});
					
				});
			}
			
			// 게시글 삭제 이벤트
			$(".post-delete-btn").click(function(){
				
				var post_no = $(this).data("no");
				
				$("#deleteTimeLine .timeline_col").val("adm_post_no");
				$("#deleteTimeLine .timeline_no").val(post_no);
				
				// layer pop up show
				layer_popup("#deleteTimeLine");					
			});
			</script>
			
			<!-- 댓글 등록 : s -->
			<div class="post-comment-insert">
				<form action="/postReply/insert" method="post">
					<input type="hidden" name="post_no" value="${postVo.post_no }"/>
					<div class="post-comment-text">
						<textarea name="post_rep_cont" placeholder="댓글을 입력하세요." onkeyup="autoTextarea(this, 60, 300)" required></textarea>
					</div>
					<div class="post-comment-btn">
						<input type="submit" class="color-white back-color-pupple-l" value="등록">
					</div>
				</form>
			</div>
			<!-- 댓글 등록 : f -->
		</div>
		<!-- 댓글박스 : f -->
			
	</div>
	<!-- post detail footer : f -->
	
</section>
					
