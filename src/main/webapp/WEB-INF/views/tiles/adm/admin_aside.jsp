<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside class="col-md-2 admin-aside">
	<nav>
		<ul class="marbtm-0">
			<li><a href="/adm/memList"><i class="fas fa-users-cog maright-20"></i>회원관리</a></li>
			<li><a href="/adm/proEdit"><i class="fas fa-folder-open maright-20"></i>프로젝트 관리</a></li>
			<li>
				<a href="#projectSubMu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle" onclick="fn_ariaExpand(this)">
					<i class="fas fa-chart-pie maright-20"></i>통계
					<i class="fas fa-caret-down color-gray"></i>
				</a>
				<ul class="collapse list-unstyled admin-sub-nav" id="projectSubMu">
				    <li>
				        <a href="/adm/memChart">회원</a>
				    </li>
				    <li>
				        <a href="/adm/proChart">프로젝트</a>
				    </li>
				</ul>
			</li>
			<li><a href="/adm/postList?post_kind=notice"><i class="fas fa-exclamation-circle maright-20"></i>공지사항</a></li>
			<li><a href="/adm/postList?post_kind=qa"><i class="fas fa-question-circle maright-20"></i>문의게시판</a></li>
		</ul>
	</nav>
</aside>

<script type="text/javascript">
function fn_ariaExpand(el) {
	var item = $(el);
	//var navLink = item.children('a');
	
	if(item.hasClass('collapsed')) {
		item.parent().addClass('active');
	} else {
		item.parent().removeClass('active');
	}
}
</script>



