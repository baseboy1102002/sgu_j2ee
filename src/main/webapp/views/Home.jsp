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


<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/fontawesome6/css/all.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bai-viet-component.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/globalstyle.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/homepage.css' />">
</head>

<body>

	<%@include file="/components/post-edit-form.jsp"%>
	<div class="modal fade" id="notifyModal" aria-hidden="true"
		data-bs-backdrop="static" data-is-detail-mode="${param.isDetailMode }"
		tabindex="-1">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalToggleLabel">Thông báo</h5>

				</div>
				<div class="modal-body">
					<i class="fa-solid fa-circle-check"></i>
					<p>Xóa thành công</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						data-bs-dismiss="modal" id="confirm-notify-btn">Quay lại</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="loadingModal" aria-hidden="true"
		data-bs-backdrop="static" tabindex="-1">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<!-- Nội dung modal -->
				<div class="modal-body">
					<img src="/sgu_j2ee/assets/images/loading.gif" alt="Loading..." />
				</div>
				<!-- Kết thúc nội dung modal -->
			</div>
		</div>
	</div>

	<div class="modal fade" id="deletePostConfirm" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Bạn có chắc chắn muốn xóa bài viết này</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary me-3"
						data-bs-dismiss="modal">Hủy bỏ</button>
					<button type="button" class="btn btn-primary"
						id="delete-baiviet-btn">Xác nhận</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="reportPostPopUp" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Báo cáo</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body comment-pop-up-body">

					<textarea id="report-post-input" name="reportPostInput" rows="5"
						placeholder="Nhập lý do báo cáo">
							
					</textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary dismiss-btn"
						data-bs-dismiss="modal">Hủy bỏ</button>
					<button type="button" class="btn btn-primary"
						id="submit-post-report-btn">Xác nhận</button>
				</div>
			</div>
		</div>
	</div>



	<!-- Header Section Begin -->
	<jsp:include page="Layout/Header.jsp"></jsp:include>
	<!-- Header End -->

	<!-- Login Section Begin -->
	<section class="home-wrapper" >
		<div class="container list-container ">
			
			<c:forEach var="baiVietView" items="${baiVietViews}">
				<c:set var="baiVietView" value="${baiVietView}" scope="request" />

				<jsp:include page="../components/bai-viet-component.jsp">
					<jsp:param value="false" name="isDetailMode" />
				</jsp:include>
			</c:forEach>
		</div>
	</section>
	<!-- Login Section End -->
</body>

<!-- Footer Section Begin -->
<jsp:include page="Layout/Footer.jsp"></jsp:include>
<!-- Footer End -->

<script type="text/javascript"
	src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>

<script type="text/javascript"
	src="<c:url value='/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/jquery/jquery-3.7.1.min.js' />"></script>

<script type="text/javascript"
	src="<c:url value='/fontawesome6/js/all.min.js' />"></script>


<script type="text/javascript">
	let contextPath = "${pageContext.request.contextPath}"
</script>

<script type="text/javascript"
	src="<c:url value='/resources/js/bai-viet-component.js' />"></script>

</body>

</html>