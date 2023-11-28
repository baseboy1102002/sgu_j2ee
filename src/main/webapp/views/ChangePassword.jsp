<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Đổi Mật Khẩu - NienHope</title>
<!-- Css Styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/setting.css"
	type="text/css">
</head>

<body>
	<!-- Header Section Begin -->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- Header End -->

	<!-- Setting Section Begin -->
	<section class="setting spad">
		<div class="container">
			<div class="card">
				<h3 class="card-header">
					<i class="fa fa-user" aria-hidden="true"
						style="margin-right: 10px;"></i> Đổi Mật Khẩu
				</h3>
				<div class="card-body">
					<form action="/sgu_j2ee/doi-password" method="post">
						<div class="row">
							<div class="col-12">
								<div class="input__item">
									<label for="">Mật khẩu hiện tại</label> <input required type="password"
										name="inputOldPassword">
								</div>
								<c:if
									test="${not empty requestScope.changePasswordStatus and requestScope.changePasswordStatus eq 'wrong'}">
									<div class="error-message">
										<p>Mật khẩu không đúng!</p>
									</div>
								</c:if>				
							</div>
							
							<div class="col-12">
								<div class="input__item">
									<label for="">Mật khẩu mới</label> <input required type="password"
										name="inputNewPassword_1">
								</div>					
							</div>
							<div class="col-12">
								<div class="input__item">
									<label for="">Xác nhận lại mật khẩu</label> <input required type="password"
										name="inputNewPassword_2">
								</div>
								<c:if
									test="${not empty requestScope.changePasswordStatus and requestScope.changePasswordStatus eq 'not_similar'}">
									<div class="error-message">
										<p>Mật khẩu xác nhận không đúng!</p>
									</div>
								</c:if>	
												
							</div>
							<div class="col-6">
								<button type="submit">
									<i class="fa fa-floppy-o" aria-hidden="true"></i>Lưu
								</button>
								<c:if
									test="${not empty requestScope.changePasswordStatus and requestScope.changePasswordStatus eq 'success'}">
									<div class="error-message">
										<p>Đổi mật khẩu thành công!</p>
									</div>
								</c:if>	
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
<script
	src="${pageContext.request.contextPath}/resources/js/reloadAvartar_setting.js"></script>

</body>

</html>