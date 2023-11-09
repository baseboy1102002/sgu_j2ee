<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="Mạng Xã Hội NienHope">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Cài Đặt- NienHope</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/favicon.png">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css_lib/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css_lib/font-awesome.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css_lib/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css_lib/elegant-icons.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css_lib/nice-select.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css_lib/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/css_lib/slicknav.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/setting.css"
	type="text/css">
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<header class="header">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-4">
					<div class="header__logo">
						<a href="/sgu_j2ee/views/Home.jsp"> <img
							src="${pageContext.request.contextPath}/assets/images/logo.png"
							alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-5 col-8">
					<div class="form-group has-search">
						<span class="fa fa-search form-control-feedback"></span> <input
							type="text" id="SearchInput" class="form-control"
							placeholder="Nhập từ khoá...">
					</div>
				</div>
				<div class="col-lg-4 col-12">
					<div class="header__right d-flex justify-content-between">
						
						<!-- Friends -->
						<a href="./login.html" class="icon_group_circle">
  							<i class="fa fa-users" aria-hidden="true"></i>
						</a>
						
						<!-- Chat -->
						<a href="./login.html" class="icon_group_circle">
  							<i class="fa fa-comments" aria-hidden="true"></i>
						</a>
						
						<!-- Thông Báo -->
						<a href="./login.html" class="icon_group_circle">
  							<i class="fa fa-bell" aria-hidden="true"></i>
						</a>
						
						<div class="dropdown">
							<a href="#" class="dropdown-toggle icon_group_circle" id="profileDropdown"
								data-toggle="dropdown"> <i class="fa fa-user" aria-hidden="true"></i>
							</a>
							<div class="dropdown-menu" aria-labelledby="profileDropdown">
								<!-- Cài Đặt -->
								<a class="dropdown-item" href="/sgu_j2ee/views/Setting.jsp"">Cài Đặt</a>
								<!-- Logout -->
								<a class="dropdown-item" href="/sgu_j2ee/dang-xuat">Đăng Xuất</a> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Header End -->

	<!-- Setting Section Begin -->
	<section class="setting spad">
		<div class="container">
			<div class="card">
				<h3 class="card-header">
					<i class="fa fa-user" aria-hidden="true" style="margin-right: 10px;"></i>
					Thông Tin Cá Nhân
				</h3>
				<div class="card-body">
					<form action="/sgu_j2ee/cai-dat" method="post">
						<div class="row">
							<div class="col-12" style="margin-bottom: 30px;">
								<div class="image-container">
									<img src="https://i.pinimg.com/1200x/c0/29/5a/c0295a690ba4e121e0ab092279d8ed6b.jpg" alt="Image" class="circle-image">
									<i class="fa fa-cog gear-icon" aria-hidden="true"></i>
								  </div>								  
							</div>
							<div class="col-6">
								<div class="input__item">
									<label for="">Họ và tên</label>
									<input type="text" name="inputName" value="${sessionScope.Name}">
								</div>
								<div class="input__item">
									<label for="">Email</label>
									<input type="email" name="inputEmail" value="${sessionScope.Email}">
								</div>
							</div>
							<div class="col-6">
								<div class="input__item">
									<label for="">Ngày sinh</label>
									<input type="date" name="inputDoB" value="${sessionScope.DoB}">
								</div>
								<div class="input__item">
									<label for="">Số điện thoại</label>
									<input type="tel" name="inputPhone" value="${sessionScope.Phone}">
								</div>
							</div>
							<div class="col-6">
								<button type="submit"><i class="fa fa-floppy-o" aria-hidden="true"></i>Lưu</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- Setting Section End -->
</body>

<!-- Js Plugins -->

<!-- Js Plugins -->
<script
	src="${pageContext.request.contextPath}/resources/js/js_lib/popper.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/js_lib/jquery-3.3.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/js_lib/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/js_lib/jquery.nice-select.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/js_lib/mixitup.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/js_lib/jquery.slicknav.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/js_lib/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>

</html>