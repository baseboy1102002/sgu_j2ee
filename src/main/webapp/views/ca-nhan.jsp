<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/globalstyle.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/ca-nhan.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.css' />">
<%-- 
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bai-viet-component.css' />"> --%>
<%-- <link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/post-edit-form.css' />"> --%>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/fontawesome6/css/all.min.css' />">

<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>

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


	<div class="profile-page">
		<div
			class="profile-header-container container row justify-content-around p-4">
			<div class="profile-placeholder col-3"></div>
			<div
				class="profile-header-user col-4 d-flex flex-wrap justify-content-center flex-column">
				<div
					class="profile-header-avatar d-flex justify-content-center mb-3">
					<img src="/sgu_j2ee/files/user.jpg" alt="" />
				</div>
				<p class="h4 text-center">${nguoiDung.hoVaTen}</p>
			</div>
			<div
				class="profile-header-actions col-4 d-flex align-items-end justify-content-end">

				<c:set var="cUID" value="${currentUID}" />
				<c:set var="UserID" value="${nguoiDung.maNguoiDung}" />

				<c:choose>
					<c:when test="${cUID eq UserID}">
						<button type="button"
							class="button-addfriend btn btn-primary col-6">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-pencil-square me-2"
								viewBox="0 0 16 16">
  <path
									d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
  <path fill-rule="evenodd"
									d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
</svg>
							Thông tin cá nhân
						</button>
					</c:when>
					<c:when test="${cUID ne UserID}">
						<button type="button"
							class="button-addfriend btn btn-primary col-6">Kết bạn</button>
						<button type="button" class="button-message btn btn-primary col-6">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-chat-dots-fill"
								viewBox="0 0 16 16">
                        <path
									d="M16 8c0 3.866-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.584.296-1.925.864-4.181 1.234-.2.032-.352-.176-.273-.362.354-.836.674-1.95.77-2.966C.744 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7zM5 8a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm4 0a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" />
                    </svg>
							Nhắn tin
						</button>
					</c:when>
				</c:choose>


			</div>
		</div>
		<div class="profile-content-container">
			<div
				class="profile-content-wrapper container flex-row d-flex justify-content-between p-0">
				<div class="profile-content-left container col-3 m-0 p-0">
					<div
						class="profile-introduction d-flex justify-content-center flex-wrap flex-column p-4">
						<span class="fw-bold text-center">Giới thiệu</span> <span>${nguoiDung.email}</span>
						<span>${nguoiDung.soDienThoai}</span> 
						<span><a>Có ${songuoiban} người bạn</a></span>
					</div>
				</div>
				<div
					class="profile-content-right container col d-flex flex-wrap flex-column ms-4">
					<div
						class="profile-create-post d-flex flex-column justify-content-end flex-wrap col p-4">
						<div class="profile-post-posting col">
							<label for="inputPosting"
								class="profile-post-label form-label fs-3 mb-4">Tạo bài
								viết</label>
							 
							<div class="profile-post-button col d-flex justify-content-end">
							<img class="profile-post-image me-2" src="/sgu_j2ee/files/user.jpg" alt="" />
							<input type="text" id="inputPosting" class="profile-posting-input form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
							<button class="btn btn-primary fs-3 pt-2 pb-2 ps-4 pe-4 col-2 ms-2">
								Tạo bài viết</button>
						</div>
						</div>
						
					</div>
					<div class="profile-posts col mt-5">
						<c:forEach var="baiVietView" items="${baiVietViews}">
							<c:set var="baiVietView" value="${baiVietView}" scope="request" />

							<jsp:include page="../components/bai-viet-component.jsp">
								<jsp:param value="false" name="isDetailMode" />
							</jsp:include>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<c:url value='/jquery/jquery-3.7.1.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/bootstrap/js/bootstrap.bundle.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/js/ca-nhan.js' />"></script>

	<script type="text/javascript"
		src="<c:url value='/fontawesome6/js/all.min.js' />"></script>

	<script type="text/javascript">
		let contextPath = "${pageContext.request.contextPath}"
	</script>

	<script type="text/javascript"
		src="<c:url value='/resources/js/bai-viet-component.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/js/post-edit-form.js' />"></script>

</body>
</html>