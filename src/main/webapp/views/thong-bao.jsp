<%@page import="controller.web.ThongBaoController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@page import="model.ThongBao"%>
<%@page import="model.TimeDifference"%>
<!DOCTYPE html>

<html>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.css' />">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/globalstyle.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/thong-bao.css' />">
<head>
<meta charset="UTF-8">
<title>NienHope | Thông báo</title>
<body>
	<div class="noti-wrapper pt-5 d-flex justify-content-center">
		<div class="noti-container col-10">
			<div class="noti-header d-flex flex-column mb-2">
				<div class="noti-header-wrapper d-flex justify-content-center">
					<div class="noti-header-container row col-10">
						<div
							class="noti-header-text-container col-lg-3 col-md-4 col-5 d-flex justify-content-end">
							<span>Thông báo</span>
						</div>
						<div
							class="noti-header-number-container col-lg-1 col-md-2 col-1 d-flex align-items-start">
							<span>20</span>
						</div>
					</div>
				</div>
			</div>
			<div class="noti-seperator d-flex justify-content-center">
				<div class="noti-seperator-line col-10"></div>
			</div>
			<div class="noti-detail-wrapper">
				<div class="noti-detail-container">
					<!---------------------------------------------------------Bắt đầu info--------------------------------------------------------->
					<!-- Mỗi class noti-info-wrapper là một thông báo -->
					<c:forEach items="${thongbaos}" var="thisItem" varStatus="status1">
						<div
							class="noti-info-wrapper col-lg-10 col container mx-auto p-lg-2 p-md-2 mb-3">
							<div class="noti-info-container col row p-lg-1 ml-md-2 mb-2">
								<!-- Hình ảnh thông báo -->
								<div
									class="noti-info-image col-3 col-lg-1 col-md-1 media d-flex ml-auto justify-content-center p-lg-1 p-md-2 align-items-center">
									<img class="mr-3 col-9"
										src="<c:url value='/views/108410800_p0.png' />" alt="img" />
								</div>
								<!-- Thông tin thông báo -->
								<div
									class="noti-info-detail-wrapper col col-lg-10 col-md-11 d-flex flex-column justify-content-center p-lg-0 m-lg-2">
									<div class="noti-info-header mb-1">
										<!-- Hiển thị tên người dùng và bài đăng -->
										<div class="d-flex">
											<span style="font-weight: 500"
												class="noti-username text-nowrap">${thisItem.usersPost}</span> <span
												class="text-nowrap" style=" margin-right: 5px;">vừa mới tạo một bài đăng: </span> <span
												style="font-weight: 500; max-width: 500px;"
												class="text-nowrap d-inline-block text-truncate">${thisItem.baiviet.noiDung}</span>
										</div>
										<!-- Hiển thị thời gian -->
										<div class="noti-info-time mt-3">
											<span id="time-stamp" style="color: rgb(160, 160, 160)">
												<c:forEach items="${timeDifference}" var="thisTime" varStatus="status2">
													<c:if test="${status1.index eq status2.index}">
														${thisTime.timeDiff}
													</c:if>
												</c:forEach>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!---------------------------------------------------------Kết thúc info--------------------------------------------------------->
					</c:forEach>
				</div>
			</div>
		</div>
	</div>


</body>
<script type="text/javascript"
	src="<c:url value='/bootstrap/js/bootstrap.bundle.js' />"></script>
</html>