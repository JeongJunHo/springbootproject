<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	input[type=password]{
		font-family: auto;
	}
	
	#loginUser{
		color: white;
		padding: 15px;
		margin: 0px;
	}
	
	.dropdown-menu{
		width:350px;
		}
</style>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/food/index" style="padding: 5px;"> <img
				alt="Brand" src="../img/ssafy_logo.png" style="max-height: 40px;">
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/board/listboard">공지 사항 <span class="sr-only">(current)</span></a></li>
				<li><a href="/food/productinfo">상품 정보</a></li>
				<li><a href="/food/bestintakeinfo">베스트 섭취 정보</a></li>
				<li><a href="/food/materialusechart">성분첨가빈도</a></li>
				<li><a href="/member/allergymaterialrank">전체사용자 알러지정보</a></li>
				<c:if test="${not empty loginid}">
				<li><a href="/food/allergyfood">알러지 주의 리스트</a></li>
				<li><a href="/food/fitcombsearch">맞춤 섭취 조회</a></li>
				<li><a href="/eatfood/eatfoodinfo">섭취 식품 조회</a></li>
				<li><a href="/eatfood/eatfoodchart">섭취 식품 통계</a></li>
				<li><a href="/dibfood/searchall">찜목록 조회</a></li>
				<li><a href="/dibfood/dibchartpage">찜 식품 성분 통계</a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<c:choose>
						<c:when test="${empty loginid}">
							<a class="btn btn-sm" href="/member/signup"> <span class="glyphicon glyphicon-user" aria-hidden="true"></span> <span>&nbsp;Sign Up</span></a>
						</c:when>
						<c:otherwise>
							<p id="loginUser">${loginid}님 환영합니다.</p>
						</c:otherwise>
					</c:choose>
				</li>
				
				<c:if test="${empty loginid}">
					<li>
						<ul class="nav navbar-nav pull-right">
							<li class="dropdown">
								<a class="btn btn-sm dropdown-toggle" href="#" data-toggle="dropdown">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span> 
								<span>&nbsp;Login</span>
								</a>
	
	
								<div class="dropdown-menu" style="padding: 17px;">
	
									<form action="/member/login" method="post">
										<div class="form-group">
											<label for="id">아이디</label> <input type="text"
												class="form-control" id="pid" name="pid" placeholder="ID">
										</div>
										<div class="form-group">
											<label for="pw">패스워드</label> <input type="password"
												class="form-control" id="ppw" name="ppw"
												placeholder="Password">
										</div>
										<div class="form-group">
											<button type="submit" class="btn btn-block btn-primary">로그인</button>
										</div>
									</form>
									<a href="/member/findidpage" class="btn btn-block btn-warning">아이디 찾기</a> 
									<a href="/member/deleteinfo" class="btn btn-block btn-danger">회원정보 삭제 </a>
								</div>
							</li>
						</ul>
					</li>
				</c:if>
				
				<c:if test="${not empty loginid}">
					<li>
						<a class="btn btn-sm" href="/member/logout">
							<span class="glyphicon glyphicon-lock" aria-hidden="true"></span> 
							<span>&nbsp;Logout</span>
						</a>
					</li>
					
					<li>
						<ul class="nav navbar-nav pull-right">
							<li class="dropdown">
								<a class="btn btn-sm dropdown-toggle" href="#" data-toggle="dropdown">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span> 
								<span>&nbsp;menu</span>
								</a>
	
								<div class="dropdown-menu" style="padding: 17px;">
									<a href="/member/infomem?pid=${loginid }" class="btn btn-block btn-info">회원정보 수정 </a> 
								</div>
							</li>
						</ul>
					</li>
				</c:if>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>