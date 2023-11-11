<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
						<a href="/sgu_j2ee/friend?userid=${sessionScope.ID}" class="icon_group_circle">
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
</body>
</html>