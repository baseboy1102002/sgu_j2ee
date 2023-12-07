<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="Layout/Head.jsp"></jsp:include>
	
<title>Trang Chủ - NienHope</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css" type="text/css">
</head>

<body>
	<jsp:include page="Layout/Header(Admin).jsp"></jsp:include>
	
	<section class="admin__controlpanel">
		<div class="container">
			<div class="row">
				<div class="col-4">
					<a href="/sgu_j2ee/admin?require=QLBV">
						<div class="function post">
							
							<p>Quản lý</p>
							<h2>Bài Viết</h2>
							<i class="fa fa-file-text-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
				<div class="col-4">
					<a href="/sgu_j2ee/admin?require=QLND">
						<div class="function user">
							<p>Quản lý</p>
							<h2>Người Dùng</h2>
							<i class="fa fa-user-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
				<div class="col-4">
					<a href="/sgu_j2ee/admin?require=QLBL">
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
					<a href="/sgu_j2ee/admin?require=LSQLBV">
						<div class="function hpost">
							<p>Lịch sử quản lý</p>
							<h2>Bài Viết</h2>
							<i class="fa fa-file-text-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
				<div class="col-4">
					<a href="/sgu_j2ee/admin?require=LSQLND">
						<div class="function huser">
							<p>Lịch sử quản lý</p>
							<h2>Người Dùng</h2>
							<i class="fa fa-user-o" aria-hidden="true"></i>
						</div>
					</a>
				</div>
				<div class="col-4">
					<a href="/sgu_j2ee/admin?require=LSQLBL">
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
	
	<jsp:include page="Layout/Footer.jsp"></jsp:include>
</body>

</html>