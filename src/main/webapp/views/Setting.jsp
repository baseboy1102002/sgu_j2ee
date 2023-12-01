<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<jsp:include page="Layout/Head.jsp"></jsp:include>
	
<title>Cài Đặt- NienHope</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/setting.css"
	type="text/css">
</head>

<body>
	<!-- Header Section Begin -->
	<jsp:include page="Layout/Header.jsp"></jsp:include>
	<!-- Header End -->

	<!-- Setting Section Begin -->
	<section class="setting spad">
		<div class="container">
			<div class="card">
				<h3 class="card-header">
					<i class="fa fa-user" aria-hidden="true"
						style="margin-right: 10px;"></i> Thông Tin Cá Nhân
				</h3>
				<div class="card-body">
					<form action="/sgu_j2ee/cai-dat" method="post" enctype="multipart/form-data">
						<div class="row">
							<div class="col-12 edit__information">
								<div class="image-container"
									onclick="document.getElementById('inputImage').click();">
									<img
										src="/sgu_j2ee/files/${sessionScope.IMG}"
										alt="Image" class="circle-image" id="previewImage" name="previewImage">  
										<i class="fa fa-cog gear-icon" aria-hidden="true"></i> 
									<input
										type="file" id="inputImage" name="inputImage" accept="image/*"
										style="display: none;" onchange="previewFile()">
								</div>


							</div>
							<div class="col-6">
								<div class="input__item">
									<label for="">Họ và tên</label> <input type="text"
										name="inputName" value="${sessionScope.Name}">
								</div>
								<div class="input__item">
									<label for="">Email</label> <input type="email"
										name="inputEmail" value="${sessionScope.Email}">
								</div>
							</div>
							<div class="col-6">
								<div class="input__item">
									<label for="">Ngày sinh</label> <input type="date"
										name="inputDoB" value="${sessionScope.DoB}">
								</div>
								<div class="input__item">
									<label for="">Số điện thoại</label> <input type="tel"
										name="inputPhone" value="${sessionScope.Phone}">
								</div>
							</div>
							<div class="col-6">
								<button type="submit">
									<i class="fa fa-floppy-o" aria-hidden="true"></i>Lưu
								</button>
							</div>
							<div class="col-6 text-right">
									<a href="${pageContext.request.contextPath}/views/ChangePassword.jsp">
										<button type="button">
											<i class="fa fa-key" aria-hidden="true"></i>Đổi Mật Khẩu
										</button>
									</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- Setting Section End -->
</body>

	<!-- Footer Section Begin -->
	<jsp:include page="Layout/Footer.jsp"></jsp:include>
	<!-- Footer End -->

</body>

</html>