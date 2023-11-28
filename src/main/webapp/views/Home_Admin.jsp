<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Trang Chủ - NienHope</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css"
	type="text/css">
</head>

<body>
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
	
	<!-- Footer Section Begin -->
	<jsp:include page="Footer.jsp"></jsp:include>
	<!-- Footer End -->

</body>

</html>