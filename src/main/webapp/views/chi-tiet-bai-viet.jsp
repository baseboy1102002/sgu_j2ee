<%@ page pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css' />">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/globalstyle.css' />">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/chi-tiet-bai-viet.css' />">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bai-viet-component.css' />">
<%-- <link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/post-edit-form.css' />"> --%>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/fontawesome6/css/all.min.css' />">


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
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Hủy bỏ</button>
					<button type="button" class="btn btn-primary"
						id="delete-baiviet-btn">Xác nhận</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="deleteCommentConfirm" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Bạn có chắc chắn muốn xóa bình luận
					này</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Hủy bỏ</button>
					<button type="button" class="btn btn-primary"
						id="delete-comment-btn">Xác nhận</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="updateCommentPopup" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Chỉnh sửa bình
						luận</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body comment-pop-up-body">

					<textarea id="comment-edit-input" name="commentInput" rows="5"
						placeholder="Nhập bình luận.....">
							
					</textarea>
					<div>

						<div class="img-wrapper">
							<img src="<c:url value='/assets/images/Sahara.jpg' />" alt>
							<div class="img-overlay"></div>
							<div class="img-btn fadeIn-top">
								<button class="btn btn-sm btn-primary">Hủy</button>
							</div>
						</div>
					</div>

					<label for="editImageCommentFile" id="edit-comment-file-input">
						<div id="edit-comment-file-input-container">
							<i class="fa-solid fa-image"> </i> <span> Đính kèm ảnh </span>
						</div> <input type="file" id="editImageCommentFile"
						style="display: none" name=""
						editImageCommentFile""
							accept="image/gif,image/jpeg,image/jpg,image/png"
						multiple="" data-original-title="upload photos">
					</label>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary dismiss-btn"
						data-bs-dismiss="modal">Hủy bỏ</button>
					<button type="button" class="btn btn-primary"
						id="submit-edit-comment-btn">Xác nhận</button>
				</div>
			</div>
		</div>
	</div>



	<div class="container d-flex flex-column chi-tiet-wrapper">
		<div>Header</div>

		<div class="d-flex flex-column content ">


	

			<c:set var="baiVietView" value="${baiVietView}" scope="request" />
			<jsp:include page="../components/bai-viet-component.jsp">
				<jsp:param value="true" name="isDetailMode" />
			</jsp:include>


			<div class="comment-wrapper"
				data-post-id="${baiVietView.baiViet.maBaiViet }">
				<div class="comment-form-wrapper">
					<div class="comment-form">
						<i class="fa-solid fa-comment" id="comment-icon"></i> <input
							placeholder="Nhập bình luận..." id="comment-input"
							name="comment-input" /> <label id="image-comment-label"
							for="imageCommentFile"> <i class="fa-solid fa-image"></i>
							<input type="file" id="imageCommentFile" style="display: none"
							name="imageCommentFile"
							accept="image/gif,image/jpeg,image/jpg,image/png" multiple=""
							data-original-title="upload photos">
						</label>
						<button id="submit-comment-btn" disabled>
							<i class="fa-solid fa-paper-plane"></i>
						</button>
					</div>
					<div class="comment-image-attach" id="comment-image-attach">
						<img id="comment-show-img" src="" /> <span id="comment-file-name"></span>
						<button id="comment-delete-file">
							<i class="fa-solid fa-circle-xmark"></i>
						</button>
					</div>
				</div>
				<div class="comment-record-wrapper" id="comment-record-wrapper">
					<c:forEach var="item" items="${binhLuanBaiViewList}">

						<div class="comment-record-item"
							data-id=${item.binhLuanBaiViet.maBinhLuan }>
							<img class="comment-record-profile-img"
									src="/sgu_j2ee/files/${item.anhDaiDienNguoiDang}" />


							<div class="comment-record-right">
								<div class="comment-record-content">
									<div class="comment-record-title">
										<div class="comment-record-title-content">
											<h5>${item.hoVaTenNguoiDang }</h5>
											<span> ${item.binhLuanBaiViet.ngayGioBinhLuan } </span>
										</div>
										<div class="comment-record-title-right"
											onclick="handleShowMore(this)">
											<i class="fa fa-ellipsis-h"></i>
											<div class="comment-more-hover">

												<button type="button" class="btn edit-comment-btn  "
													data-bs-toggle="modal" data-bs-target="#updateCommentPopup"
													onclick="handleClickEditComment(this)">
													<i class="fa fa-cog" aria-hidden="true"></i><span>
														Chỉnh sửa </span>
												</button>
												<button type="button" class="btn delete-comment-btn "
													data-bs-toggle="modal"
													data-bs-target="#deleteCommentConfirm"
													onclick="handleSetId(this)">
													<i class="fa fa-trash" aria-hidden="true"></i> <span>
														Xóa </span>
												</button>
											</div>

										</div>
									</div>
									<p>${item.binhLuanBaiViet.noiDung }</p>
									<div class="comment-record-react">
										<div class="react-data">
											<c:forEach var="tuongTacBinhLuan"
												items="${item.top3TuongTac }">
												<div class="react-data-item">
													<img alt=""
														src="<c:url value='/assets/images/${tuongTacBinhLuan.trangThai }.png' />">
												</div>

											</c:forEach>

											<span> <c:if test="${item.tongLuotTuongTac > 0}">
       								 ${item.tongLuotTuongTac}
   												 </c:if>
											</span>

										</div>
										<button class="comment-record-react-action">
											<div
												class=" comment-record-react-action-btn ${empty item.loginUserTuongTacBinhLuan ? '' : 'active' } "
												data-active=${empty item.loginUserTuongTacBinhLuan ? false : true }
												onclick="handleOnClickReactComment(this)">
												<c:if test="${empty item.loginUserTuongTacBinhLuan }">

													<i class="fa fa-thumbs-up" aria-hidden="true"></i>
													<span>Thích</span>
												</c:if>

												<c:if test="${!empty item.loginUserTuongTacBinhLuan }">


													<img alt=""
														src="<c:url value='/assets/images/${item.loginUserTuongTacBinhLuan.trangThai }.png' />">
													<span class="${item.loginUserTuongTacBinhLuan.trangThai }">${item.loginUserTuongTacBinhLuan.trangThai }</span>

												</c:if>

											</div>

											<div class="comment-record-more-action">
												<div class="comment-record-react-item"
													data-trang-thai="like" onclick="reactHoverComment(this)">
													<img alt="" src="<c:url value='/assets/images/like.png' />">
												</div>
												<div class="comment-record-react-item"
													data-trang-thai="heart" onclick="reactHoverComment(this)">
													<img alt=""
														src="<c:url value='/assets/images/heart.png' />">
												</div>
												<div class="comment-record-react-item" data-trang-thai="sad"
													onclick="reactHoverComment(this)">
													<img alt="" src="<c:url value='/assets/images/sad.png' />">
												</div>
												<div class="comment-record-react-item"
													data-trang-thai="haha" onclick="reactHoverComment(this)">
													<img alt="" src="<c:url value='/assets/images/haha.png' />">
												</div>
												<div class="comment-record-react-item" data-trang-thai="mad"
													onclick="reactHoverComment(this)">
													<img alt="" src="<c:url value='/assets/images/mad.png' />">
												</div>
											</div>
										</button>
									</div>
								</div>
								<c:choose>
									<c:when test="${not empty item.binhLuanBaiViet.anhBinhLuan}">
										<img class="comment-record-img"
											src="/sgu_j2ee/files/${item.binhLuanBaiViet.anhBinhLuan}" />
									</c:when>
									<c:otherwise>
										<img class="comment-record-img" src="" />
									</c:otherwise>
								</c:choose>

							</div>
						</div>

					</c:forEach>

				</div>
			</div>

		</div>





	</div>

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
	<script type="text/javascript"
		src="<c:url value='/resources/js/post-edit-form.js' />"></script>

	<script type="text/javascript"
		src="<c:url value='/resources/js/chi-tiet-bai-viet.js' />"></script>

</body>
</html>