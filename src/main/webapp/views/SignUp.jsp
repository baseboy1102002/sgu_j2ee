<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Đăng Kí - NienHope</title>
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
						<h3>Đăng Kí Tài Khoản</h3>
						<form action="/sgu_j2ee/dang-ky" method="post" id="dang-ky">
							<div class="input__item">
								<span class="icon_profile"></span> <input type="text"
									name="inputName" required placeholder="Họ và Tên">
							</div>
							<div class="input__item">
								<span class="icon_mail"></span> <input type="email"
									name="inputEmail" required placeholder="Địa chỉ Email">
							</div>
							<c:if
								test="${not empty requestScope.signupStatus and requestScope.signupStatus eq 'exists'}">
								<div class="error-message">
									<p>Email đã được sử dụng ở tài khoản khác!</p>
								</div>
							</c:if>
							<div class="input__item">
								<span class="icon_lock"></span> <input type="password"
									name="inputPassword" required placeholder="Mật khẩu">
							</div>
							<div class="input__item">
								<span class="icon_lock"></span> <input type="password"
									name="inputCheckPassword" required
									placeholder="Xác nhận lại mật khẩu">
							</div>
							<c:if
								test="${not empty requestScope.signupStatus and requestScope.signupStatus eq 'wrong'}">
								<div class="error-message">
									<p>Mật khẩu xác nhận không đúng!</p>
								</div>
							</c:if>
							<div class="row">
								<div class="col-12">
									<div class="checkRemember">
										<input type="checkbox" name=agreePolicy id="checkRemember" /> 
										<label for="checkRemember" class="terms-label"> <svg class="checkbox-svg" viewBox="0 0 200 200" fill="none" xmlns="http://www.w3.org/2000/svg">
										<mask id="path-1-inside-1_476_5-37" fill="white">
											<rect width="200" height="200" />
										</mask>
											<rect width="200" height="200" class="checkbox-box" stroke-width="40" mask="url(#path-1-inside-1_476_5-37)" />
											<path class="checkbox-tick" d="M52 111.018L76.9867 136L149 64" stroke-width="15" />
										 	</svg> <span class="label-text">Chấp nhận điều khoản sử dụng</span>
											<a href="${pageContext.request.contextPath}/views/Policy.jsp" style="font-weight: bold">‎ (Đọc thêm)</a>
										</label>
										<div class="error-message" id="errorMessage" style="display: none">
											<p>Vui lòng chấp nhận điều khoản sử dụng!</p>
										</div>
									</div>
								</div>
							</div>
							<div>
								<button type="submit" id="loginBtn">Đăng Ký</button>
							</div>
							<div>
								<a href="${pageContext.request.contextPath}/views/Index.jsp">
									<button type="button" id="signUpBtn">Đã có tài khoản?
										Đăng nhập ngay!</button>
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
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var form = document.getElementById('dang-ky'); // replace 'yourFormId' with the actual ID of your form

        form.addEventListener('submit', function(event) {
            var checkbox = document.getElementById('checkRemember'); // replace 'checkRemember' with the actual ID of your checkbox

            if (!checkbox.checked) {
                errorMessage.style.display = 'block';
                event.preventDefault(); // Prevent form submission
            }
        });
    });
</script>

	<!-- Header Section Begin -->
	<jsp:include page="Footer.jsp"></jsp:include>
	<!-- Header End -->

</body>

</html>