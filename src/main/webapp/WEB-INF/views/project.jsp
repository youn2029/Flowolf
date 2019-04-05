<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<section class="content project-detail">

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
	
	
	
	<div class="project-wrap">
		<!-- project left content:s -->
		<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 padleft-0">
		
			<!-- project title(프로젝트 제목):s -->
			<div id="proTitle" class="pro-detail-box project-title ${proVo.pro_user_color }">
				<div class="pro-tit">
					<c:choose>
						<c:when test="${proVo.imp_chk == 1 }">
							<i class="fas fa-star size-20 color-yellow maright-15 cursor-point" data-prono="${proVo.pro_no }"></i>
						</c:when>
						<c:otherwise>
							<i class="fas fa-star size-20 color-gray-l maright-15 cursor-point" data-prono="${proVo.pro_no }"></i>
						</c:otherwise>
					</c:choose>
					<span class="size-20 color-white">${proVo.pro_name }</span>
				</div>
				<ul class="pro-edit-nav">
					<li>
						<i class="fas fa-palette size-30 color-white cursor-point edit-color-btn" onclick="fn_editColor(this)"></i>
						<div class="edit-box edit-color-box">
							<div class="color-sample default-back-color"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-red"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-pink"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-orange"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-yellow-d"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-green"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-green-l"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-blue-l"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-blue-d"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-pupple"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-pupple-l"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-gray"><i class="fas fa-check-circle size-16"></i></div>
							<div class="color-sample back-color-black"><i class="fas fa-check-circle size-16"></i></div>
						</div>
					</li>
					<li>
						<button id="projectEdit" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="fas fa-ellipsis-v size-30 color-white"></i>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="projectEdit">
							<li class="drop-tit">프로젝트 설정</li>
							<li class="cursor-point" onclick="boxProEdit()">보관함 설정</li>
							<li class="cursor-point" onclick="deleteProUser()">프로젝트 나가기</li>
							<li class="cursor-point" onclick="proUpdate()">프로젝트 수정</li>
							<c:if test="${proVo.mem_id eq memVo.mem_id }">
								<li class="cursor-point color-red" onclick="deletePro()">프로젝트 삭제</li>
							</c:if>
						</ul>
					</li>
				</ul>
			</div>
			
			<script type="text/javascript">
			$(function() {
				
				// 중요프로젝트 체크(icon click)
				$(".pro-tit > i").on("click", function(){
					if($(this).hasClass("color-gray-l")){
						$(this).removeClass("color-gray-l");
						$(this).addClass("color-yellow");
						
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
						$(this).removeClass("color-yellow");
						$(this).addClass("color-gray-l");
						
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
				
				// check color : 현재 프로젝트 색상과 같은 색상리스트를 찾아 체크표시
				var backColor = $("#proTitle").attr("class").split(' ').pop(); // 현재 적용된 색상명(클래스명)
				$(".edit-color-box").find("div").each(function(i, e){
					var selectColor = $(this).attr("class").split(' ').pop();
					
					if(backColor == selectColor) {
						$(this).addClass("select-color");
					}
				});
				
				// 다른 색상을 선택했을 때 색상바꾸기
				$(".edit-color-box").find("div").on("click", function(){
					var changeColor = $(this).attr("class").split(' ').pop();
					$("#proTitle").removeClass(backColor);
					$("#proTitle").addClass(changeColor);
					backColor = changeColor;
					
					$.ajax({
						
						url : "/proUser/update",
						method : "get",
						data : {pro_user_color:changeColor},
						dataType : "json",
						success : function(data){
							if(data==1){
								alertCustom("변경되었습니다.", "alert-warning");
							}
						}
					});
					
					$(this).addClass("select-color");
					$(".edit-color-box").find("div").not(this).removeClass("select-color");
					
				});				
			});
			
			// 프로젝트 보관함 popup
			function boxProEdit(){
// 				$(".proFolderEdit-form #pro_no").val("${proVo.pro_no}");
				layer_popup("#proFolderEdit");
			}
			
			// 프로젝트 수정 popup
			function proUpdate(){
				layer_popup("#editProject");
			}
			
			// 프로젝트 나가기 popup
			function deleteProUser(){
				layer_popup("#deleteProUser");
			}
			
			// 프로젝트 삭제 popup
			function deletePro(){
				layer_popup("#deletePro");
			}
			
			</script>
			<!-- project title(프로젝트 제목):f -->
			
			<!-- project task report(업무리포트):s -->
			<div class="pro-detail-box pro-task-report martop-20" style="display:none">
				<h3 class="size-16 marbtm-20"><i class="fas fa-chart-pie maright-10 size-20 color-green-l"></i> 업무리포트(전체 <span></span>건)</h3>
				<%@include file="/include/task_report.jsp" %>
			</div>
			<!-- project task report(업무리포트):f -->
			
			<!-- '할 일' 모아보기 제목(클릭 이벤트는 'project_right.jsp'에 있음) -->
			<div class="coll-todo-tit float-left martop-20 font-bold size-20 color-black" style="display:none">
				할 일 모아보기 <span class="color-blue-l cursor-point" onclick="fn_collCancel()">취소</span>
			</div>
			
			<!-- '투표' 모아보기 제목(클릭 이벤트는 'project_right.jsp'에 있음) -->
			<div class="coll-vote-tit float-left martop-20 font-bold size-20 color-black" style="display:none">
				투표 모아보기 <span class="color-blue-l cursor-point" onclick="fn_collCancel()">취소</span>
			</div>
			
			<!-- project write tab(프로젝트 타임라인 글쓰기 탭박스):s -->
			<div class="pro-detail-box pro-tab-box martop-20">
				<div class="tabs-box">
					<ul class="tabs">
						<li data-id="tab-1" class="active"><i class="fas fa-edit maright-10"></i>글쓰기</li>
						<li data-id="tab-2"><i class="fas fa-laptop maright-10"></i>업무</li>
						<li data-id="tab-3"><i class="far fa-calendar-alt maright-10"></i>일정</li>
						<li data-id="tab-4"><i class="fas fa-list maright-10"></i>할일</li>
						<li data-id="tab-5"><i class="fas fa-check maright-10"></i>투표</li>
					</ul>
					<div class="tabs-container">
						<!-- 글쓰기:s -->
						<div id="tab-1" class="tabs-content active">
							<%@include file="/include/tab_write_article.jsp" %>
						</div>
						<!-- 글쓰기:f --> 
						
						<!-- 업무:s -->
						<div id="tab-2" class="tabs-content con-task">
							<%@include file="/include/tab_write_task.jsp" %>
						</div>
						<!-- 업무:f -->
						
						<!-- 일정:s -->
						<div id="tab-3" class="tabs-content con-schedule">
							<%@include file="/include/tab_write_schedule.jsp" %>
						</div>
						<!-- 일정:f -->
						
						<!-- 할일:s -->
						<div id="tab-4" class="tabs-content con-todo">
							<%@include file="/include/tab_write_todo.jsp" %>
						</div>
						<!-- 할일:f -->
						
						<!-- 투표:s -->
						<div id="tab-5" class="tabs-content con-vote">
							<%@include file="/include/tab_write_vote.jsp" %>
						</div>
						<!-- 투표:f -->
					</div>
				</div>
			</div>
			
			<script type="text/javascript">
			$(function(){
				// 탭메뉴 설정 : 탭메뉴(li)에 설정된 data-id 값과 같은 id값을 가진 content box 노출
				$("ul.tabs li").on("click", function(){
					var tab_id = $(this).attr("data-id");
					$("ul.tabs li").removeClass("active");
					$(".tabs-content").removeClass("active");
					
					$(this).addClass("active");
					$("#"+tab_id).addClass("active");
				});
			});
			</script>
			<!-- project write tab(프로젝트 타임라인 글쓰기 탭박스):f -->
			
			<!-- top pick article(상단고정글):s -->
			<div class="top-fixed-article martop-20">
				<h5 class="marbtm-10">상단고정글</h5>
				
				<div class="fix-article-box panel-group" id="accordion" role="tablist" aria-multiselectable="true">		
					<c:forEach items="${timeLineList }" var="timeLine" varStatus="fixStart">
						<c:if test="${timeLine.fix_chk == 'y' }">
							<%@include file="/include/timeline_fix.jsp" %>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<!-- top pick article(상단고정글):f -->
			
			<!-- project timeline:s -->
			<c:forEach items="${timeLineList }" var="timeLine" varStatus="start">
				<div class="timeline-box martop-20">
				<c:choose>
					<c:when test="${timeLine.basicVo != null }">
						<input type="hidden" class="col-no" data-col="basic_no" data-no="${timeLine.basicVo.basic_no }">
					</c:when>
					<c:when test="${timeLine.taskVo != null }">
						<input type="hidden" class="col-no"  data-col="task_no" data-no="${timeLine.taskVo.task_no }">
					</c:when>
					<c:when test="${timeLine.todoVo != null }">
						<input type="hidden" class="col-no" data-col="todo_no" data-no="${timeLine.todoVo.todo_no }">
					</c:when>
					<c:when test="${timeLine.voteVo != null }">
						<input type="hidden" class="col-no" data-col="vote_no" data-no="${timeLine.voteVo.vote_no }">
					</c:when>
					<c:otherwise>
						<input type="hidden" class="col-no" data-col="schd_no" data-no="${timeLine.schdVo.schd_no }">
					</c:otherwise>
				</c:choose>
				
					<!-- timeline header:s -->
					<div class="timeline-header back-color-white">
						<!-- article writer info -->
						<div class="article-writer-info">
							<dl>
								<dt class="posi-re maright-15 cursor-point" onclick="fn_openPopup(this)" 
								data-id="${timeLine.mem_id }" data-nick="${timeLine.mem_nick }" data-my="${memVo.mem_id }">
									<i class="flow-icon icon-circle circle-s"></i>
									<img src="/mem/pic?mem_id=${timeLine.mem_id }" onerror="this.src=('/image/user-pic-sample.png')" height="40">
								</dt>
								<dd>
									<strong class="dis-block size-18 color-black">${timeLine.mem_nick }</strong>
									<span class="dis-block size-14 color-gray-l">
										<fmt:formatDate value="${timeLine.time }" pattern="yyyy-MM-dd HH:mm"/>
									</span>
								</dd>
							</dl>
						</div>
						
						<!-- article icon : s -->
						<ul class="article-top-icon">
							
							<c:if test="${proVo.mem_id == memVo.mem_id }">
								<!-- article pick button -->
								<li>
									<a href="#fixCheck" class="pick-check-btn">
										<c:choose>
											<c:when test="${timeLine.fix_chk == 'y' }">
												<i class="fas fa-map-pin size-24 cursor-point pick-active"></i>
											</c:when>
											<c:otherwise>
												<i class="fas fa-map-pin size-24 cursor-point"></i>
											</c:otherwise>
										</c:choose>
									</a>
								</li>
							</c:if>
						
							<!-- article edit : s -->
							<c:if test="${timeLine.mem_id == memVo.mem_id }">
								<li class="posi-re float-left">
									<button id="articleEdit" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<i class="fas fa-ellipsis-v size-24 color-gray"></i>
									</button>
									<ul class="dropdown-menu" role="menu" aria-labelledby="articleEdit">
										<li class="cursor-point" onclick="fn_editArticle(this)">글 수정</li>
										<li class="cursor-point timeline-delete-btn">글 삭제</li>
									</ul>
								</li>
							</c:if>
							<!-- article edit : f -->
						</ul>
						<!-- article icon : f -->		
			
					</div>
					<!-- timeline header:f -->
					
					<!-- timeline content:s -->	
					<div class="timeline-content">
						<!-- if문  -->
						<c:choose>
							<c:when test="${timeLine.basicVo != null }">
								<%@include file="/include/timeline_article.jsp" %>
							</c:when>
							<c:when test="${timeLine.taskVo != null }">
								<%@include file="/include/timeline_task.jsp" %>
							</c:when>
							<c:when test="${timeLine.todoVo != null }">
								<%@include file="/include/timeline_todo.jsp" %>
							</c:when>
							<c:when test="${timeLine.voteVo != null }">
								<%@include file="/include/timeline_vote.jsp" %>
							</c:when>
							<c:otherwise>
								<%@include file="/include/timeline_schedule.jsp" %>
							</c:otherwise>
						</c:choose>
					</div>
					
					<!-- timeline content:f -->
					
					<!-- timeline footer:s -->
					<div class="timeline-footer">
					
						<!-- 좋아요 / 댓글 개수:s -->
						<div class="article-etc-info">
						
							<!-- emoUserList에 회원이 등록한 이모티콘이 있는지 확인 -->
							<c:set var="emo_user_chk" value="false" />
							<c:set var="my_emo_no" value="" />
							<c:set var="my_emo_name" value="" />
							<c:set var="my_emo_user_no" value="" />
							
							<c:forEach items="${timeLine.emoUserList }" var="emoUserVo">
								<c:if test="${not emo_user_chk }">
									<c:if test="${emoUserVo.mem_id == memVo.mem_id }">
										<c:set var="emo_user_chk" value="true" />
										<c:set var="my_emo_no" value="${emoUserVo.emo_no }" />
										<c:set var="my_emo_name" value="${emoUserVo.emo_name }" />
										<c:set var="my_emo_user_no" value="${emoUserVo.emo_user_no }" />
									</c:if>
								</c:if>
							</c:forEach>						
						
							<!-- 좋아요 선택 시 이모티콘 나올 부분 -->
							<div class="like-result cursor-point" onclick="fn_emoUserPop(${start.index })">
								<c:forEach items="${timeLine.emoUserList }" var="emoUserVo" end="2">
									<img src="/emo/view?emo_no=${emoUserVo.emo_no }" data-no="${emoUserVo.emo_user_no }" width="20" class="maright-10">
								</c:forEach>
								<div class="like-mem dis-inblock" data-size="${timeLine.emoUserList.size() }">
								<c:choose>
									<c:when test="${emo_user_chk}">
										<strong class="me">${memVo.mem_nick }</strong>	님
										<c:if test="${timeLine.emoUserList.size()-1 != 0 }">
											  외 ${timeLine.emoUserList.size()-1 }명
										</c:if>
									</c:when>
									<c:otherwise>
										<c:if test="${timeLine.emoUserList.size() != 0 }">
											${timeLine.emoUserList.size() }명
										</c:if>
									</c:otherwise>									
								</c:choose>
								</div>
							</div>
							
							<!-- 이모티콘 사용자 리스트 팝업:s -->
							<div class="dim-layer">
								<div class="dimBg"></div>
							
								<div id="emoUser_${start.index }" class="pop-layer">
									<!-- pop header -->
									<header class="pop-top border-box">
										리액션 확인
										<a href="#" class="posi-ab dis-block over-hidden icon-close btn-close">close</a>
									</header>
									
									<!-- pop con -->
									<section class="pop-con border-box">
										<!-- 좋아요 개수 : s -->
										<ul class="like-count-info">
											<li>총 <span>${timeLine.emoUserList.size() }</span></li>
										</ul>
										<!-- 좋아요 개수 : f -->
										
										<!-- 좋아요 리스트 : s -->
										<div class="like-count-list" data-simplebar>
											<c:forEach items="${timeLine.emoUserList }" var="emoUserVo">
												<dl data-id="${emoUserVo.mem_id }">
													<dt	class="posi-re cursor-point" onclick="fn_openPopup(this)" 
													data-id="${timeLine.mem_id }" data-nick="${timeLine.mem_nick }" data-my="${memVo.mem_id }">
														<i class="icon-circle circle-s"></i>
														<img src="/mem/pic?mem_id=${emoUserVo.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="40">
													</dt>
													<dd>
														<div class="like-user-name">${emoUserVo.mem_nick }</div>
														<div class="like-user-emoticon"><img src="/emo/view?emo_no=${emoUserVo.emo_no }" width="40"></div>
													</dd>
												</dl>
											</c:forEach>
										</div>
										<!-- 좋아요 리스트 : f -->
									</section>									
								</div>
							</div>
							<!-- 이모티콘 사용자 리스트 팝업:f -->
							
							<!-- 댓글 개수 -->
							<div class="comment-count back-color-gray-l color-white">
								<i class="fas fa-comment maright-10"></i> ${timeLine.repList.size() }개
							</div>
							
							<!-- 좋아요 / 댓글작성 / 담아두기 버튼 -->
							<ul class="article-etc-menu martop-10 marbtm-0">
								<li class="posi-re cursor-point">							
									
									<c:choose>
										<c:when test="${emo_user_chk }">
											<!-- like button : s -->
											<div id="emoticonToggle" class="emoticon-btn cursor-point" 
											data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="display:none">
												<i class="fas fa-thumbs-up maright-10"></i>좋아요
											</div>
											<!-- like button : f -->
											
											<!-- Chagned like button : s -->
											<div class="emoticon-after-btn cursor-point" data-emouser="${my_emo_user_no }" style="display:block">
												<img src="/emo/view?emo_no=${my_emo_no }" width="20" class="maright-10">
												<span class="size-14 default-color">${my_emo_name }</span>
											</div>
											<!-- Chagned like button : f -->
										</c:when>
										<c:otherwise>
											<!-- like button : s -->
											<div id="emoticonToggle" class="emoticon-btn cursor-point" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
												<i class="fas fa-thumbs-up maright-10"></i>좋아요
											</div>
											<!-- like button : f -->
											
											<!-- Chagned like button : s -->
											<div class="emoticon-after-btn cursor-point" data-emouser="">
												<img src="" width="20" class="maright-10">
												<span class="size-14 default-color"></span>
											</div>
											<!-- Chagned like button : f -->
										</c:otherwise>
									</c:choose>
									<!-- Emoticon list box -->
									<div class="dropdown-menu emoticon-box" aria-labelledby="emoticonToggle">
										<ul>
											<c:forEach items="${emoList }" var="emo">
												<li class="posi-re" data-emono="${emo.emo_no }">
													<img src="/emo/view?emo_no=${emo.emo_no }">
													<span>${emo.emo_name }</span>
												</li>
											</c:forEach>											
										</ul>
									</div>
								</li>
								<li class="cursor-point" onclick="fn_commentFocus(this)"><i class="fas fa-comment-alt maright-10"></i> 댓글작성</li>
								<c:choose>
									<c:when test="${timeLine.coll_chk != 0 }">
										<li class="cursor-point coll-btn default-color" data-collno="${timeLine.coll_chk }">
											<i class="fas fa-bookmark maright-10"></i>
											<span>담아두기 취소</span>
										</li>
									</c:when>
									<c:otherwise>
										<li class="cursor-point coll-btn" data-collno="${timeLine.coll_chk }">
											<i class="fas fa-bookmark maright-10"></i>
											<span>담아두기</span>
										</li>
									</c:otherwise>
								</c:choose>
								
							</ul>
						</div>
						<!-- 좋아요 / 댓글 개수:f -->
					
						<!-- 댓글:s -->
						<div class="timeline-comment-wrap">
							<c:forEach items="${timeLine.repList }" var="repList" varStatus="status">
								<!-- 댓글 리스트:s -->
								<div class="comment-list-box" data-repno="${repList['repVo'].rep_no }">
									<dl>
										<dt class="posi-re cursor-point" onclick="fn_openPopup(this)" 
										data-id="${timeLine.mem_id }" data-nick="${timeLine.mem_nick }" data-my="${memVo.mem_id }">
											<i class="flow-icon icon-circle circle-s-re"></i>
											<img src="/mem/pic?mem_id=${repList['repVo'].mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="40">
										</dt>
										<dd class="posi-re">
										
											<!-- 댓글 작성자 정보 -->
											<div class="comment-user-info">
												<div class="dis-inblock font-bold size-15 color-black maright-10">${repList['repVo'].mem_nick }</div>
												<div class="dis-inblock size-15 color-gray maright-20"><fmt:formatDate value="${repList['repVo'].rep_time }" pattern="yyyy-MM-dd hh:mm"/> </div>
<!-- 												<div class="dis-inblock size-15 color-gray cursor-point" onclick="fn_likeChange(this)"> -->
<!-- 													<i class="fas fa-thumbs-up maright-10"></i><span>좋아요</span> -->
<!-- 												</div> -->
											</div>
											
											<!-- 댓글내용 -->
											<div class="article-txt martop-5">
												<pre class="font-thin size-16 color-gray">${repList['repVo'].rep_cont }</pre>
											</div>
											
											<!-- 댓글 이미지 목록 : s -->
											<div class="comment-img-list">
												<c:forEach items="${repList['filesList'] }" var="filesVo">
													<c:if test="${filesVo.files_kind == 'img' }">
														<div class="upload-img-info martop-20">
															<div class="upload-img" style="background-image:url('/files/view?files_no=${filesVo.files_no}')"></div>
														</div>
													</c:if>
												</c:forEach>
											</div>
											<!-- 댓글 이미지 목록 : f -->
											
											<!-- 댓글 첨부파일 목록 : s -->
											<div class="comment-file-list">
												<c:forEach items="${repList['filesList'] }" var="filesVo">
													<c:if test="${filesVo.files_kind == 'fil' }">
														<div class="upload-file-info martop-10">
															<dl>
																<dt>
																	<i class="dis-inblock file-icon-s" data-name="${filesVo.files_name }"></i>
																</dt>
																<dd>
																	<div class="dis-block size-14 color-black" style="height:26px;line-height:26px;">
																		${filesVo.files_name }<span class="marleft-10 color-blue-l">(${filesVo.files_size })</span>
																	</div>
																	<a href="/files/download?files_no=${filesVo.files_no }" class="comment-file-down">다운로드</a>
																</dd>
															</dl>
														</div>
													</c:if>
												</c:forEach>
											</div>
											<!-- 댓글 첨부파일 목록 : f -->
											
											<!-- 댓글 수정 박스 -->
											<div class="comment-edit-box">
												<form action="/rep/update" method="post" class="comment-edit-form" enctype="multipart/form-data">
													<input type="hidden" name="rep_no" value="${repList['repVo'].rep_no }">
													<div class="comment-textarea">
														<textarea rows="5" cols="50" class="rep_cont" name="rep_cont" 
														onkeyup="autoTextarea(this, 40, 300)" onkeydown="fn_keyDownEsc(event, this)" required>${repList['repVo'].rep_cont }</textarea>
													</div>
													<div class="dis-block float-left martop-5 marbtm-10 size-13 color-gray" style="width:100%"><span class="default-color">취소</span> 하실려면 <span class="color-red">Esc</span>키를 누르세요.</div>
													
													<!-- 파일첨부 -->
													<label for="commentEditFile_${status.count }" class="marbtm-0">
														<i class="fas fa-paperclip martop-10 size-24 color-gray cursor-point"></i>
													</label>
													<input type="file" id="commentEditFile_${status.count }" class="dis-none" onchange="commentFileUpload(this)">
													
													<!-- 이미지 목록이 나올부분 -->
													<div class="comment-upload-img-list">
														<c:forEach items="${repList['filesList'] }" var="filesVo">
															<c:if test="${filesVo.files_kind == 'img' }">
																<div class="upload-img-info martop-20" data-no="${filesVo.files_no }">
																	<div class="upload-img" style="background-image:url('/files/view?files_no=${filesVo.files_no}')"></div>
																	<i class="fas fa-times-circle img-close-btn" onclick="commentFileDelete(this)"></i>
																</div>
															</c:if>
														</c:forEach>												
													</div>
													
													<!-- 첨부파일 목록이 나올부분 -->
													<div class="comment-upload-file-list">
														<c:forEach items="${repList['filesList'] }" var="filesVo">
															<c:if test="${filesVo.files_kind == 'fil' }">
																<div class="upload-file-info martop-10" data-no="${filesVo.files_no }">
																	<dl>
																		<dt>
																			<i class="dis-inblock file-icon-s" data-name="${filesVo.files_name }"></i>
																		</dt>
																		<dd>
																			<div class="dis-block size-14 color-black" style="height:26px;line-height:26px;">
																				${filesVo.files_name }<span class="marleft-10 color-blue-l">(${filesVo.files_size })</span>
																			</div>
																		</dd>
																	</dl>
																	<i class="far fa-times-circle file-close-btn" onclick="commentFileDelete(this)"></i>
																</div>
															</c:if>
														</c:forEach>
													</div>
												</form>
											</div>
											<c:if test="${repList['repVo'].mem_id == memVo.mem_id }">
												<!-- 댓글 수정,삭제 버튼 -->
												<ul class="comment-edit-btn">
													<li class="cursor-point" onclick="fn_commentEdit(this)">수정</li>
													<li class="cursor-point reply-delete">삭제</li>
												</ul>
											</c:if>
										</dd>
									</dl>
								</div>
								<!-- 댓글 리스트:f -->
							</c:forEach>
							<!-- 댓글 입력:s -->
							<form action="/rep/insert" method="post" enctype="multipart/form-data">
								<input type="hidden" class="timeline_col" name="timeline_col" value="">
								<input type="hidden" class="timeline_no" name="timeline_no" value="">
								<div class="comment-insert-box">
									<dl>
										<dt class="posi-re">
											<i class="flow-icon icon-circle circle-s-re"></i>
											<img src="/mem/pic?mem_id=${memVo.mem_id }" onerror="this.src='/image/user-pic-sample.png'" width="40">
										</dt>
										<dd>
											<div class="comment-textarea">
												<textarea rows="5" cols="50" class="rep_cont" name="rep_cont"
												placeholder="댓글을 입력하세요.(Enter는 입력, shift + Enter는 줄바꿈)"
												onkeyup="autoTextarea(this, 36, 300)" onkeydown="fn_commentKeyDown(event, this)" required ></textarea>
											</div>
											
											<!-- 파일첨부 -->
											<label for="commentFile_${start.count }" class="marbtm-0">
												<i class="fas fa-paperclip martop-10 size-24 color-gray cursor-point"></i>
											</label>
											<input type="file" id="commentFile_${start.count }" class="dis-none" onchange="commentFileUpload(this)">
											
											<!-- 이미지 목록이 나올부분 -->
											<div class="comment-upload-img-list">
											</div>
											
											<!-- 첨부파일 목록이 나올부분 -->
											<div class="comment-upload-file-list">
											</div>
											
										</dd>
									</dl>
								</div>
							</form>
							<!-- 댓글 입력:f -->
						</div>
						<!-- 댓글:f -->
						
					</div>
					<!-- timeline footer:f -->
					
				</div>
			</c:forEach>
			
			<!-- project timeline:f -->
			
			<form action="/task/rate" class="edit-rate-form">
				<input type="hidden" name="task_no" value="">
				<input type="hidden" name="task_rate" value="">
			</form>
			
			<script type="text/javascript">
			// article img slide
			var swiper = new Swiper('.swiper-container-img', {
				slidesPerView: 1,
				spaceBetween: 20,
				slidesPerGroup: 1,
				loop: false,
				loopFillGroupWithBlank: true,
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				},
			});
			
			// task 상태 수정 팝업
			function fn_editTaskState(el){
				
				var item = $(el);
				var stateList = item.parent('.task-state-list');
				var layerPopCon = $("#editTaskState");
				
				// task_no & task_state
				var task_no = stateList.siblings(".edit-confirm").data("taskno");
				var task_state = item.children().val();
				
				// 값 이동
				layerPopCon.children('form').children("input[name=task_no]").val(task_no);
				layerPopCon.children('form').children("input[name=task_state]").val(task_state);
				
				layer_popup(layerPopCon);				
				
			}
			
			// task 진척도 수정 
			function fn_timeProgressSelect(el){
				var item = $(el);
				var task_rate = item.children('span').text();
				var task_no = item.siblings('input').data("taskno");
				
				$(".edit-rate-form").children("input[name=task_no]").val(task_no);
				$(".edit-rate-form").children("input[name=task_rate]").val(task_rate);
				
				$(".edit-rate-form").submit();
			}
			
			// 이모티콘 유저 리스트 팝업
			function fn_emoUserPop(count){
				layer_popup("#emoUser_"+count);
			}
			
			$(function(){
				
				// 상단 고정 버튼 클릭시
				$(".pick-check-btn").click(function(){			
					
					// layer pop up show
					var $href = $(this).attr('href');
					layer_popup($href);
					
					// layer pop text show & hide
					var item = $(this);
					var icon = item.children();
					var layerWrap = $($href);
					
					var timeline_col = $(this).parents(".timeline-box").children(".col-no").data("col");
					var timeline_no = $(this).parents(".timeline-box").children(".col-no").data("no");
					
					// 고정되어있는 글
					if(item.hasClass('fixed')){
						alert("있다~");
						var fixedCon = item.parent().parent().parent().parent();
						var fixedTop = fixedCon.siblings(".article-fix-top");
						var colNo = fixedTop.children().children(".col-no");
						
						timeline_col = colNo.data("col");
						timeline_no = colNo.data("no");
					}
					
					$(".fix-form .timeline_col").val(timeline_col);
					$(".fix-form .timeline_no").val(timeline_no);
					
					if(icon.hasClass('pick-active')){		// 고정되어있음
						layerWrap.find('p.fix-n').hide();
						layerWrap.find('p.fix-y').show();	// 해제
					} else {
						layerWrap.find('p.fix-y').hide();
						layerWrap.find('p.fix-n').show();	// 고정
					}					
				});
				
				// 좋아요 클릭 이벤트
				$(".emoticon-box li").click(function(){
					var item = $(this);
					var emo_no = $(this).data("emono");
					var timeline_col = $(this).parents(".timeline-box").children(".col-no").data("col");
					var timeline_no = $(this).parents(".timeline-box").children(".col-no").data("no");
					
					var emoticonAfterBtn = $(this).parents(".dropdown-menu").siblings(".emoticon-after-btn");
					var likeResult = item.parents(".article-etc-menu").siblings(".like-result");
					var likeImg = likeResult.children("img");
					var likeMem = likeResult.children(".like-mem");
					var size = likeMem.data("size");
					
					var emoUserListPop = likeResult.siblings(".dim-layer");
					var popCon = emoUserListPop.children(".pop-layer").children(".pop-con");
					var emoUserCntSpan = popCon.children("ul").find("span");
					var emoUserCnt = Number(popCon.children("ul").find("span").text());
					
					var likeCountList = popCon.children(".like-count-list");
					var simplebarCon = likeCountList.children(".simplebar-scroll-content").children(".simplebar-content");
					
					$.ajax({
						url : "/emoUser/insert",
						method : "get",
						data : {emo_no:emo_no, timeline_col:timeline_col, timeline_no:timeline_no},
						dataType : "json",
						success : function(data){
							fn_emoticon(item);
							emoticonAfterBtn.data("emouser", data);
							
							// 이모티콘 이미지
							if(likeImg.length < 3){
								likeResult.prepend("<img src=\"/emo/view?emo_no="+emo_no+"\" data-no="+data+" width=\"20\" class=\"maright-10\">");
							}
							
							// 좋아요 누른 회원
							if(size > 0){								
								likeMem.html("<strong>${memVo.mem_nick }</strong> 님  외"+size+"명");
							}else{
								likeMem.html("<strong class=\"me\">${memVo.mem_nick }</strong> 님");
							}
							
							// data-size : +1
							likeMem.data("size", size+1);
							
							// append 내용
							var str = "<dl data-id=\"${memVo.mem_id }\">"
										+ "<dt class=\"posi-re\">"
											+ "<i class=\"icon-circle circle-s\"></i>"
											+ "<img src=\"/mem/pic?mem_id=${memVo.mem_id }\" onerror=\"this.src='/image/user-pic-sample.png'\" width=\"40\">"
										+ "</dt>"
										+ "<dd>"
											+ "<div class=\"like-user-name\">${memVo.mem_nick }</div>"
											+ "<div class=\"like-user-emoticon\"><img src=\"/emo/view?emo_no="+emo_no+"\" width=\"40\"></div>"
										+ "</dd>"
									+ "</dl>";
							
							emoUserCntSpan.html(emoUserCnt+1);	// 인원수 추가
							simplebarCon.append(str);			// 리스트 추가
							
						}
					});
				});
				
				// 이모티콘 취소 이벤트
				$(".emoticon-after-btn").click(function(){
					var item = $(this);
					var emo_user_no = item.data("emouser");
					
					var likeResult = item.parents(".article-etc-menu").siblings(".like-result");
					var likeImg = likeResult.children("img");
					var likeMem = likeResult.children(".like-mem");
					var size = likeMem.data("size");					
					
					var emoUserListPop = likeResult.siblings(".dim-layer");
					var popCon = emoUserListPop.children(".pop-layer").children(".pop-con");
					var emoUserCntSpan = popCon.children("ul").find("span");
					var emoUserCnt = Number(popCon.children("ul").find("span").text());
					
					var likeCountList = popCon.children(".like-count-list");
					var simplebarCon = likeCountList.children(".simplebar-scroll-content").children(".simplebar-content");
					var emoUserOne = simplebarCon.children("dl");
					
					$.ajax({
						url : "/emoUser/delete",
						method : "get",
						data : {emo_user_no:emo_user_no},
						dataType : "json",
						success : function(data){
							fn_emoResultBtn(item);
							item.data("emouser", "");
							
							// 이모티콘 이미지
							likeImg.each(function(i, e){
								if(likeImg.eq(i).data("no") == emo_user_no){
									likeImg.eq(i).remove();
								}
							});
							
							// 좋아요 누른 회원
							if(size == 1 && likeMem.children("strong").hasClass("me")){
								likeMem.html("");
							}else if(size > 0){								
								likeMem.html(size-1+"명");
							}else{
								likeMem.html("");
							}
							
							// data-size : -1
							likeMem.data("size", size-1);
							
							emoUserCntSpan.html(emoUserCnt-1);	// 인원수 감소
							emoUserOne.each(function(i, e){		// 리스트 삭제
								if (emoUserOne.eq(i).data("id") == '${memVo.mem_id }') {
									emoUserOne.eq(i).remove();
								}
							});
						}
					});
				});
				
				// 담아두기 버튼 이벤트
				$(".coll-btn").click(function(){
					
					var item = $(this);
					var coll_no = item.data("collno");
					var timeline_col = $(this).parents(".timeline-box").children(".col-no").data("col");
					var timeline_no = $(this).parents(".timeline-box").children(".col-no").data("no");
										
					if(item.hasClass('default-color')){		// 취소					
					
						$.ajax({
							url : "/coll/delete",
							method : "get",
							data : {coll_no:coll_no},
							dataType : "json",
							success : function(data){
								
							}
						});		
					
					}else{									// 등록
						
						$.ajax({
							url : "/coll/insert",
							method : "get",
							data : {timeline_col:timeline_col, timeline_no:timeline_no},
							dataType : "json",
							success : function(data){
								item.data("collno", data);
							}
						});
					}
					
					fn_likeChange(item);
				});
				
				// 타임라인 글 삭제 이벤트
				$(".timeline-delete-btn").click(function(){
					
					var timeline_col = $(this).parents(".timeline-box").children(".col-no").data("col");
					var timeline_no = $(this).parents(".timeline-box").children(".col-no").data("no");
					
					$("#deleteTimeLine .timeline_col").val(timeline_col);
					$("#deleteTimeLine .timeline_no").val(timeline_no);
					
					// layer pop up show
					layer_popup("#deleteTimeLine");					
				});
				
				// 댓글 삭제 이벤트
				$(".reply-delete").click(function(){					
					var item = $(this);
					var commentListBox = item.parent().parent().parent().parent();
					var rep_no = commentListBox.data("repno");
					
					$("#deleteTimeLine .timeline_col").val("rep_no");
					$("#deleteTimeLine .timeline_no").val(rep_no);
					
					// layer pop up show
					layer_popup("#deleteTimeLine");	
					
				});
				
				// 첨부파일 이미지 바꾸기
				$(".upload-file-info").each(function(i, e){
					var iconTag = $(this).find("i.dis-inblock");
					var dataName = iconTag.attr("data-name");
					fileExCheck(iconTag);
				});
				
				// '할 일' 항목 개수에 따라 각 항목 % 정하기
				var percent = 0;
				$(".todo-content").each(function(i,e){
					if($(this).children("dl").length == 1) {
						percent = 100;
						$(this).children("dl").find('.todo-percent-txt').html(percent);
					} else if($(this).children("dl").length == 2) {
						percent = 50;
						$(this).children("dl").find('.todo-percent-txt').html(percent);
					} else if($(this).children("dl").length == 3) {
						percent = 33;
						$(this).children("dl").find('.todo-percent-txt').html(percent);
						$(this).children("dl").eq(2).find('.todo-percent-txt').html(percent+1);
					} else if($(this).children("dl").length == 4) {
						percent = 25;
						$(this).children("dl").find('.todo-percent-txt').html(percent);
					} else if($(this).children("dl").length == 5) {
						percent = 20;
						$(this).children("dl").find('.todo-percent-txt').html(percent);
					}
				});
				
				// '할 일' 완료 % 및 개수, 전체 개수 구하기
				$(".todo-content").each(function(i, e){
					var todoItemLength = $(this).find('dl').length;					// 할일 항목 개수
					var todoItemSuccess = $(this).find('dl[data-chk=y]').length;	// 할일 항목 완료 개수
					var todoPercent = $(this).siblings('.todo-info').find('.todo-percent-cnt');		// 할일 완료 %
					var todoAllCount = $(this).siblings('.todo-info').find('.todo-all-cnt');		// 할일 항목 전체 개수
					var todoFinishCount = $(this).siblings('.todo-info').find('.todo-finish-cnt');	// 할일 항목 완료 개수
					var todoRange = $(this).siblings('.todo-progress-bar').find('.todo-range');		// 할일 % 게이지 바
					
					todoAllCount.text(todoItemLength);
					todoFinishCount.text(todoItemSuccess);
					
					var itemPcnt = Math.floor(100 / todoItemLength);
					var successPcnt = itemPcnt * todoItemSuccess;
					todoPercent.html(successPcnt);
					todoRange.css("width", successPcnt+"%");
				});
			
				// 상단 고정글 항목 우측 화살표 아이콘 변경
				var fixTopLink = $(".article-fix-top a");
				fixTopLink.on("click", function(){
					if(!$(this).parent().siblings(".panel-collapse").hasClass("in")){
						fixTopLink.find("i.icon-arrow").removeClass("fa-angle-down");
						fixTopLink.find("i.icon-arrow").addClass("fa-angle-left");
						$(this).find("i.icon-arrow").removeClass("fa-angle-left");
						$(this).find("i.icon-arrow").addClass("fa-angle-down");
					} else {
						$(this).find("i.icon-arrow").removeClass("fa-angle-down");
						$(this).find("i.icon-arrow").addClass("fa-angle-left");
					}
				});
				
				// 투표 상태바 처리
				$(".time-vote-con").each(function(i, e){
					var voteCount = 0;
					var voteCountResult = $(this).find(".vote-count-result").text();
					
					voteCount += parseInt(voteCountResult);
					var votePercent = parseInt(voteCountResult);
					var pcntResult = (votePercent / voteCount) * 100;
					
					$(this).find(".vote-range").css("width", pcntResult + '%');
				});
	
			});
			</script>
			
		</div>
		<!-- project left content:f -->
		
		<!-- project right content:s -->
		<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 padright-0">
			<%@include file="/include/project_right.jsp" %>
		</div>
		<!-- project right content:f -->
		
	</div>
	
	<!-- google map -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAmxDFvVfjjBQ0eWrQ2Pgv8odc0L8rbJU4&libraries=places&callback=initMap" async defer></script>
	<script src="<%=request.getContextPath() %>/js/googleMap.js"></script>
		
		
</section>