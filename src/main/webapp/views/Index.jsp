<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="Layout/Head.jsp"></jsp:include>
	
	<title>Đăng Nhập - NienHope</title>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/login_logup.css"
		type="text/css">
</head>

<body>
	<!-- Header Section Begin -->
	<jsp:include page="Layout/Header(SignedOut).jsp"></jsp:include>
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
							<c:if
								test="${not empty requestScope.loginStatus and requestScope.loginStatus eq 'failed'}">
								<div class="error-message">
									<p>Đăng nhâp thất bại. Vui lòng kiểm tra lại tài khoản và mật khẩu!</p>
								</div>
							</c:if>
							<c:if
								test="${not empty requestScope.loginStatus and requestScope.loginStatus eq 'ban'}">
								<div class="error-message">
									<p>Tài khoản bị cấm!</p>
								</div>
							</c:if>
							<c:if
								test="${not empty requestScope.loginStatus and requestScope.loginStatus eq 'sendPassword'}">
								<div class="error-message">
									<p>Mật khẩu của bạn đã được gửi tới email. Vui lòng đăng nhập.</p>
								</div>
							</c:if>
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
									<a href="${pageContext.request.contextPath}/views/Forget_Password.jsp">Quên mật khẩu ?</a>
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

	<!-- Footer Section Begin -->
	<jsp:include page="Layout/Footer.jsp"></jsp:include>
	<!-- Footer End -->
</body>
</html>