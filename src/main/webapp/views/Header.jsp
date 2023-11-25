<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="Mạng Xã Hội NienHope">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/assets/images/favicon.png">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- CSS -->
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
	href="${pageContext.request.contextPath}/resources/css/header.css"
	type="text/css">
</head>
<body>
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
						<div class="direct">
							<a href="/sgu_j2ee/friend?userid=${sessionScope.ID}"
								class="icon_group_circle"> <i class="fa fa-users"
								aria-hidden="true"></i>
							</a>
						</div>


						<!-- Chat -->
						<div class="direct">
							<a href="/sgu_j2ee/mess?userid1=${sessionScope.ID}&userid2=1"
								class="icon_group_circle"> <i class="fa fa-comments"
								aria-hidden="true"></i>
							</a>
						</div>

						<!-- Thông Báo -->
						<div class="direct">
							<a href="./login.html" class="icon_group_circle"> <i
								class="fa fa-bell" aria-hidden="true"></i>
							</a>
						</div>

						<div class="direct user__options">
							<div class="dropdown">
								<a href="#" class="dropdown-toggle icon_group_circle"
									id="profileDropdown" data-toggle="dropdown"> <i
									class="fa fa-user" aria-hidden="true"></i>
								</a>
								<div class="dropdown-menu" aria-labelledby="profileDropdown">
									<!-- Cài Đặt -->
									<a class="dropdown-item" href="/sgu_j2ee/views/Setting.jsp"">Cài
										Đặt</a>
									<!-- Logout -->
									<a class="dropdown-item" href="/sgu_j2ee/dang-xuat">Đăng
										Xuất</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
</body>
</html>