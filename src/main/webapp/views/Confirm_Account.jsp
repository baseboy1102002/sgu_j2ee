<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Xác Nhận Tài Khoản - NienHope</title>
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
	
	<!-- Footer Section Begin -->
	<jsp:include page="Footer.jsp"></jsp:include>
	<!-- Footer End -->


</body>

</html>