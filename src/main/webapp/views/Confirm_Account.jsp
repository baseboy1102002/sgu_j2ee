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
<title>Xác Nhận Tài Khoản - NienHope</title>
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
						<h3>Xác Nhận Tài Khoản</h3>
						<p style="padding-top: 4px;">
							Xin chào <c:out value="${sessionScope.Name}"/>!<br>Để tiếp tục sử dụng vui lòng
							xác nhận tài khoản bằng mã xác nhận đã được gửi qua email đăng kí
							tài khoản này.
						</p>
						<form action="/sgu_j2ee/xac-nhan" method="post">

							<input type="hidden" name="inputEmail"
								value="<%=request.getParameter("inputEmail")%>">

							<div class="input__item">
								<span class="icon_lock"></span> <input type="text"
									name="inputConfirmCode" placeholder="Mã xác nhận">
							</div>

							<div>
								<button id="loginBtn" type="submit">Xác Nhận</button>
							</div>

							<div>
								<a href="${pageContext.request.contextPath}/views/SignUp.jsp">
									<button type="button" id="signUpBtn">Đã mất mã xác
										nhận rồi? Ấn để gửi lại.</button>
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