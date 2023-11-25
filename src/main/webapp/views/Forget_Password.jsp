<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Khôi Phục Mật Khẩu - NienHope</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login_logup.css"
	type="text/css">
</head>

<body>
	
	<!-- Header Section Begin -->
	<jsp:include page="Header(SignedOut).jsp"></jsp:include>
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
						<h3>Khôi Phục Mật Khẩu</h3>
						<p style="padding-top: 4px;">
							Xin chào bạn!<br>Để lấy lại mật khẩu vui lòng
							nhập email tài khoản của bạn. Chúng tôi sẽ gửi mật khẩu của bạn vào email đó.
						</p>
						<form action="/sgu_j2ee/quen-password" method="post">

							<div class="input__item">
								<span class="icon_mail"></span> <input type="email"
									name="inputEmail" placeholder="Địa Chỉ Email">
							</div>

							<div>
								<button id="loginBtn" type="submit">Xác Nhận</button>
							</div>

							<div>
								<a href="https://i.pinimg.com/736x/86/b2/cd/86b2cd76b0279353babf717fac80c180.jpg">
									<button type="button" id="signUpBtn">Đã quên địa chỉ Email rồi? Ấn vào đây.</button>
								</a>
							</div>
						</form>
					</div>
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