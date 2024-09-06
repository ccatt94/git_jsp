<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>FiveProject</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="author" content="">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resource/css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resource/js/modernizr.js"></script>
</head>

<body class="d-flex flex-column min-vh-100" data-bs-spy="scroll"
	data-bs-target="#navbar" data-bs-root-margin="0px 0px -40%"
	data-bs-smooth-scroll="true" tabindex="0">
	
	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
	      <svg xmlns="http://www.w3.org/2000/svg" id="chevron-left" viewBox="0 0 16 16">
	        <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
	      </svg>
	      <symbol xmlns="http://www.w3.org/2000/svg" id="nav-icon" viewBox="0 0 16 16">
	        <path d="M14 10.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-7a.5.5 0 0 0 0 1h7a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-11a.5.5 0 0 0 0 1h11a.5.5 0 0 0 .5-.5z" />
	      </symbol>
	      <symbol xmlns="http://www.w3.org/2000/svg" id="close" viewBox="0 0 16 16">
	        <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
	      </symbol>
	      <symbol xmlns="http://www.w3.org/2000/svg" id="navbar-icon" viewBox="0 0 16 16">
	        <path d="M14 10.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-7a.5.5 0 0 0 0 1h7a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-11a.5.5 0 0 0 0 1h11a.5.5 0 0 0 .5-.5z" />
	      </symbol>
	</svg>

	<header id="header"class="site-header header-scrolled position-fixed text-black bg-dark">
		<nav id="header-nav" class="navbar navbar-expand-lg px-3">
			<div class="container-fluid">
				<a class="navbar-project" href="index.jsp"><h1 class="display-6 text-uppercase text-white">Five Coding</h1></a>
				<button class="navbar-toggler d-flex d-lg-none order-3 p-2"
					type="button" data-bs-toggle="offcanvas" data-bs-target="#bdNavbar"
					aria-controls="bdNavbar" aria-expanded="false"
					aria-label="Toggle navigation">
					<svg class="navbar-icon">
	              <use xlink:href="#navbar-icon"></use>
	            </svg>
				</button>
				<div class="offcanvas offcanvas-end" tabindex="-1" id="bdNavbar"
					aria-labelledby="bdNavbarOffcanvasLabel">
					<div class="offcanvas-header px-4 pb-0">
						<h1 class="display-1 text-uppercase text-white pb-5">Five
							Coding</h1>
						<button type="button" class="btn-close btn-close-white"
							data-bs-dismiss="offcanvas" aria-label="Close"
							data-bs-target="#bdNavbar"></button>
					</div>
					<div class="offcanvas-body">
						<ul id="navbar"
							class="navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3">
							<li class="nav-item"><a class="nav-link me-4 active"
								href="/index.jsp">Home</a>
							<li class="nav-item dropdown"><a
								class="nav-link me-4 dropdown-toggle link-dark"
								data-bs-toggle="dropdown" href="#" role="button"
								aria-expanded="false">투표</a>
								<ul class="dropdown-menu">
									<li><a href="vote/member.do" class="dropdown-item">후보조회</a></li>
									<li><a href="vote/vote.do" class="dropdown-item">투표하기</a></li>
									<li><a href="vote/voteList.do" class="dropdown-item">투표검수조회</a>
									</li>
									<li><a href="vote/memberRank.do" class="dropdown-item">후보자등수</a>
									</li>
								</ul>
							</li>
							<li class="nav-item dropdown"><a
								class="nav-link me-4 dropdown-toggle link-dark"
								data-bs-toggle="dropdown" href="#" role="button"
								aria-expanded="false">쇼핑몰</a>
								<ul class="dropdown-menu">
									<li><a href="shopping/index.jsp"
										class="dropdown-item">쇼핑몰 회원 관리 홈</a></li>
									<li><a href="shopping/add" class="dropdown-item">회원
											등록</a></li>
									<li><a href="shopping/list"
										class="dropdown-item">회원 목록 조회 및 수정</a></li>
									<li><a href="shopping/result"
										class="dropdown-item">회원 매출 조회</a></li>
								</ul>
							</li>
							<li class="nav-item dropdown"><a
								class="nav-link me-4 dropdown-toggle link-dark"
								data-bs-toggle="dropdown" href="#" role="button"
								aria-expanded="false">골프</a>
								<ul class="dropdown-menu">
									<li><a href="about.html" class="dropdown-item">후보조회</a></li>
									<li><a href="blog.html" class="dropdown-item">투표하기</a></li>
									<li><a href="shop.html" class="dropdown-item">투표검수조회</a></li>
									<li><a href="cart.html" class="dropdown-item">후보자등수</a></li>
								</ul>
							</li>
							<li class="nav-item dropdown"><a
								class="nav-link me-4 dropdown-toggle link-dark"
								data-bs-toggle="dropdown" href="#" role="button"
								aria-expanded="false">게임 하기</a>
								<ul class="dropdown-menu">
									<li><a href="about.html" class="dropdown-item">로또 게임</a></li>
									<li><a href="rpsgame/index.jsp" class="dropdown-item">가위 바위 보 게임</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<section id="mobile-products"
		class="product-store position-relative padding-large">

		<div class="container">

			<div class="row">
			
			

				<div class="col-lg-4 col-md-6 col-sm-12 pb-3">
					<div>
						<div class="product-card position-relative">
							<div class="image-holder">
								<img
									src="${pageContext.request.contextPath}/resource/images/vote1.jpg"
									alt="vote1" class="img-fluid">
							</div>
							<div class="cart-concern position-absolute">
								<div class="cart-button d-flex">
									<a href="vote/main.do" class="btn btn-medium btn-black">투표</a>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="col-lg-4 col-md-6 col-sm-12 pb-3">
					<div>
						<div class="product-card position-relative">
							<div class="image-holder">
								<img
									src="${pageContext.request.contextPath}/resource/images/shopping1.jpg"
									alt="shopping1" class="img-fluid">
							</div>
							<div class="cart-concern position-absolute">
								<div class="cart-button d-flex">
									<a href="shopping/index.jsp" class="btn btn-medium btn-black">쇼핑몰</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 col-sm-12 pb-3">
					<div>
						<div class="product-card position-relative">
							<div class="image-holder">
								<img
									src="${pageContext.request.contextPath}/resource/images/golf1.jpg"
									alt="golf1" class="img-fluid">
							</div>
							<div class="cart-concern position-absolute">
								<div class="cart-button d-flex">
									<a href="#" class="btn btn-medium btn-black">골프</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 col-sm-12 pb-3">
					<div>
						<div class="product-card position-relative">
							<div class="image-holder">
								<img
									src="${pageContext.request.contextPath}/resource/images/lotto1.jpg"
									alt="lotto1" class="img-fluid">
							</div>
							<div class="cart-concern position-absolute">
								<div class="cart-button d-flex">
									<a href="lotto/index.jsp" class="btn btn-medium btn-black">로또 게임</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 col-sm-12 pb-3">
					<div>
						<div class="product-card position-relative">
							<div class="image-holder">
								<img
									src="${pageContext.request.contextPath}/resource/images/rs1.jpg"
									alt="rs1" class="img-fluid">
							</div>
							<div class="cart-concern position-absolute">
								<div class="cart-button d-flex">
									<a href="rpsgame/index.jsp" class="btn btn-medium btn-black">가위바위보
										게임</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<footer class="py-3 mt-auto bg-dark" id="footer">
		<p class="text-white text-center">Copyright 2024. Tomsboy Project Five Coding all rights reserved</p>
	</footer>

    <script src="${pageContext.request.contextPath}/resource/js/jquery-1.11.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/plugins.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/script.js"></script>

</body>
</html>