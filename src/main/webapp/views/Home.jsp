<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<jsp:include page="Layout/Head.jsp"></jsp:include>
	
<title>Trang Chủ - NienHope</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login_logup.css"
	type="text/css">
</head>

<body>
	<!-- Header Section Begin -->
	<jsp:include page="Layout/Header.jsp"></jsp:include>
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
						<h1>
							Welcome,
							<c:out value="${sessionScope.Name}" />
						</h1>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Login Section End -->
</body>

	<!-- Footer Section Begin -->
	<jsp:include page="Layout/Footer.jsp"></jsp:include>
	<!-- Footer End -->

</body>

</html>