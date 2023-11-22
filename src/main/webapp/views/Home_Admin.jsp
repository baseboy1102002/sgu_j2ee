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
<title>Trang Chủ - NienHope</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/assets/images/favicon.png">

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
	href="${pageContext.request.contextPath}/resources/css/admin.css"
	type="text/css">
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<jsp:include page="Header(Admin).jsp"></jsp:include>
	<!-- Header End -->

	<!-- Login Section Begin -->
	<section class="admin__controlpanel">
		<div class="container">
			<div class="row">
				<div class="col-4">
					<a href="#">
						<div class="function post">
							<p>Quản lý</p>
							<h2>Bài Viết</h2>
							<i class="fa fa-file-text-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
				<div class="col-4">
					<a href="#">
						<div class="function user">
							<p>Quản lý</p>
							<h2>Người Dùng</h2>
							<i class="fa fa-user-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
				<div class="col-4">
					<a href="#">
						<div class="function comment">
							<p>Quản lý</p>
							<h2>Bình Luận</h2>
							<i class="fa fa-commenting-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<a href="#">
						<div class="function hpost">
							<p>Lịch sử quản lý</p>
							<h2>Bài Viết</h2>
							<i class="fa fa-file-text-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
				<div class="col-4">
					<a href="#">
						<div class="function huser">
							<p>Lịch sử quản lý</p>
							<h2>Người Dùng</h2>
							<i class="fa fa-user-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
				<div class="col-4">
					<a href="#">
						<div class="function hcomment">
							<p>Lịch sử quản lý</p>
							<h2>Bình Luận</h2>
							<i class="fa fa-commenting-o" aria-hidden="true"></i>
						</div>
					</a>
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