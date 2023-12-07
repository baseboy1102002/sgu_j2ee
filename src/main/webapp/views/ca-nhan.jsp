<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Layout/Head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/ca-nhan.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/post-edit-form.css' />">
<title>Insert title here</title>
</head>

<c:set var="cUID" value="${currentUID}" />
<c:set var="UserID" value="${nguoiDung.maNguoiDung}" />

<body>

	 <c:if test="${sessionScope.LoaiTaiKhoan eq 'admin' }">
			<jsp:include page="Layout/Header(Admin).jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.LoaiTaiKhoan eq 'user' }">
			<jsp:include page="Layout/Header.jsp"></jsp:include>
	</c:if> 

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

	<div class="modal fade" id="reportUserPopUp" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Báo cáo người
						dùng</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body comment-pop-up-body">

					<textarea id="report-user-input" name="reportUserInput" rows="5"
						placeholder="Nhập lý do báo cáo">
							
					</textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary dismiss-btn"
						data-bs-dismiss="modal">Hủy bỏ</button>
					<button type="button" class="btn btn-primary"
						id="submit-user-report-btn" data-this-user=${UserID
						}
						data-current-user=${sessionScope.ID} >Xác nhận</button>
				</div>
			</div>
		</div>
	</div>

	<div class="profile-page">
		<div
			class="profile-header-container container row justify-content-around p-4">

			<div
				class="profile-placeholder col-3 d-flex align-items-end justify-content-start">
				<c:if test="${cUID ne UserID}">
					<c:if test="${isReported eq true}">
						<button type="button" disabled
							class="button-message btn btn-primary col-6">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-exclamation-diamond-fill"
								viewBox="0 0 16 16">
  <path
									d="M9.05.435c-.58-.58-1.52-.58-2.1 0L.436 6.95c-.58.58-.58 1.519 0 2.098l6.516 6.516c.58.58 1.519.58 2.098 0l6.516-6.516c.58-.58.58-1.519 0-2.098L9.05.435zM8 4c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995A.905.905 0 0 1 8 4m.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2" />
</svg>
							Báo cáo
						</button>
					</c:if>
					<c:if test="${isReported eq false}">
						<button type="button" class="button-message btn btn-primary col-6"
							id="btn-baocaoND" data-bs-toggle="modal"
							data-bs-target="#reportUserPopUp">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-exclamation-diamond-fill"
								viewBox="0 0 16 16">
  <path
									d="M9.05.435c-.58-.58-1.52-.58-2.1 0L.436 6.95c-.58.58-.58 1.519 0 2.098l6.516 6.516c.58.58 1.519.58 2.098 0l6.516-6.516c.58-.58.58-1.519 0-2.098L9.05.435zM8 4c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995A.905.905 0 0 1 8 4m.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2" />
</svg>
							Báo cáo
						</button>
					</c:if>
				</c:if>

			</div>
			<div
				class="profile-header-user col-4 d-flex flex-wrap justify-content-center flex-column">
				<div
					class="profile-header-avatar d-flex justify-content-center mb-3">
					<img src="/sgu_j2ee/files/${nguoiDung.hinhDaiDien}" alt="" />
				</div>
				<p class="h4 text-center">${nguoiDung.hoVaTen}</p>
			</div>
			<div
				class="profile-header-actions col-4 d-flex align-items-end justify-content-end">

				<c:choose>
					<c:when test="${cUID eq UserID}">
						<button type="button"
							class="profile-action-button btn btn-primary col-6">
							<a href="/sgu_j2ee/views/Setting.jsp">
							
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-pencil-square me-2"
								viewBox="0 0 16 16">
  <path
									d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
  <path fill-rule="evenodd"
									d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
</svg>
							Thông tin cá nhân
							</a>
						</button>
					</c:when>
					<c:when test="${cUID ne UserID}">
						<c:if test="${showButton eq 'disabled'}">
							<button type="button" ${showButton}
								class="profile-action-button btn btn-primary col-6">${btnDescriptionString}</button>
							<button class="button-message btn btn-primary col-6"
								onclick="MoveToPageMessage('${sessionScope.ID}', '${UserID}')">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-chat-dots-fill"
									viewBox="0 0 16 16">
        <path
										d="M16 8c0 3.866-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.584.296-1.925.864-4.181 1.234-.2.032-.352-.176-.273-.362.354-.836.674-1.95.77-2.966C.744 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7zM5 8a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm4 0a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" />
    </svg>
								Nhắn tin
							</button>
						</c:if>

						<c:if test="${showButton ne 'disabled'}">
							<button type="button"
								class="profile-action-button btn btn-primary col-6"
								onclick="handleOnClickAddFriend(this)"
								data-button-type="thong-tin" data-this-user=${UserID
								}
								data-current-user=${sessionScope.ID} >${btnDescriptionString}</button>
							<button class="button-message btn btn-primary col-6"
								onclick="MoveToPageMessage('${sessionScope.ID}', '${UserID}')">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-chat-dots-fill"
									viewBox="0 0 16 16">
        <path
										d="M16 8c0 3.866-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.584.296-1.925.864-4.181 1.234-.2.032-.352-.176-.273-.362.354-.836.674-1.95.77-2.966C.744 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7zM5 8a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm4 0a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" />
    </svg>
								Nhắn tin
							</button>
						</c:if>


					</c:when>
				</c:choose>


			</div>
		</div>
		<div class="profile-content-container">
			<div
				class="profile-content-wrapper container flex-row d-flex justify-content-between p-0 m-0">
				<div class="profile-content-left container col-3 m-0 p-0">
					<div
						class="profile-introduction d-flex justify-content-center flex-wrap flex-column p-4">
						<span class="fw-bold text-center">Giới thiệu</span> <span>${nguoiDung.email}</span>
						<span>${nguoiDung.soDienThoai}</span> <span><a>Có
								${songuoiban} người bạn</a></span>
					</div>
				</div>
				<div
					class="profile-content-right container col d-flex flex-wrap flex-column ms-4 p-0">
					<c:if test="${postingDisplayString eq 'yes'}">
						<div
							class="profile-create-post d-flex flex-column justify-content-end flex-wrap col p-4 mb-4">
							<div class="profile-post-posting col p-0">
								<label for="inputPosting"
									class="profile-post-label form-label fs-3 mb-4">Tạo bài
									viết</label>

								<div class="profile-post-button col d-flex justify-content-end">
									<img class="profile-post-image me-2"
										src="/sgu_j2ee/files/${nguoiDung.hinhDaiDien}" alt="" /> <input type="text"
										id="inputPosting" class="profile-posting-input form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm">
									<button
										class="btn btn-primary fs-3 pt-2 pb-2 ps-4 pe-4 col-2 ms-2"
										id="btn_add_post">Tạo bài viết</button>
								</div>
							</div>

						</div>
					</c:if>
					<div class="profile-posts col p-0">
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

	<jsp:include page="Layout/Footer.jsp"></jsp:include>
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
	<script>
    function MoveToPageMessage(userID1, userID2) {
        window.location.href = "mess?userid1=" + userID1 + "&userid2=" + userID2;
    }
</script>

</body>
</html>