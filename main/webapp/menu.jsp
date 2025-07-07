<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<div class="nav-bar">
	<div class="nav-title">Book Market.</div>
	<div class="nav-btn">
		<div class="nav-btn-item">
			<a href="#">홈</a>
		</div>
		<div class="nav-btn-item">
			<a href=#>도서 목록</a>
		</div>
		<div class="nav-btn-item">
			<a href="/BoardListAction.do?pageNum=1" class="nav-btn-link">게시판</a>

		</div>
		<div class="nav-btn-item">
			<a href=#>로그인</a>
		</div>
		<div class="nav-btn-item">
			<a href=#>회원가입</a>
		</div>
	</div>
</div>