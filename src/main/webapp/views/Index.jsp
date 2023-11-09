<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="Mạng Xã Hội NienHope">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Đăng Nhập - NienHope</title>
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
	href="${pageContext.request.contextPath}/resources/css/login_logup.css"
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
						<a href="/sgu_j2ee/views/Index.jsp"> <img
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
								<!-- Login -->
								<a class="dropdown-item" href="/sgu_j2ee/views/Index.jsp">Đăng Nhập</a> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Header End -->

	<!-- Login Section Begin -->
	<section class="login spad">
		<div class="container">
			<div class="row login__panel">
				<div class="col-lg-7">
					<div class="banner__login"></div>
				</div>
				<div class="col-lg-5">
					<div class="login__form">
						<h3>Đăng Nhập</h3>
						<form action="/sgu_j2ee/dang-nhap" method="post">
							<div class="input__item">
								<span class="icon_mail"></span> <input type="email"
									name="inputEmail" placeholder="Địa chỉ Email" required
									value="${email}">
							</div>
							<div class="input__item">
								<span class="icon_lock"></span> <input type="password"
									name="inputPassword" placeholder="Mật khẩu" required
									value="${password}">
							</div>
							<div class="row">
								<div class="col-6">
									<div class="checkRemember">
										<input type="checkbox" name="checkRemember" id="checkRemember" />
										<label for="checkRemember" class="terms-label"> <svg
												class="checkbox-svg" viewBox="0 0 200 200" fill="none"
												xmlns="http://www.w3.org/2000/svg">
											<mask id="path-1-inside-1_476_5-37" fill="white">
											  <rect width="200" height="200" />
											</mask>
											<rect width="200" height="200" class="checkbox-box"
													stroke-width="40" mask="url(#path-1-inside-1_476_5-37)" />
											<path class="checkbox-tick"
													d="M52 111.018L76.9867 136L149 64" stroke-width="15" />
										  </svg> <span class="label-text">Lưu mật khẩu</span>
										</label>
									</div>
								</div>
								<div class="col-6 text-right" style="padding-top: 4px;">
									<a href="#">Quên mật khẩu ?</a>
								</div>
							</div>
							<div>
								<button id="loginBtn" type="submit">Đăng Nhập</button>
							</div>
							<div>
								<a href="${pageContext.request.contextPath}/views/SignUp.jsp">
									<button type="button" id="signUpBtn">Chưa có tài
										khoản? Đăng kí ngay!</button>
								</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Login Section End -->
</body>

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