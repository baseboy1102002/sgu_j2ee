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

<link rel="stylesheet" type="text/css"
	href="<c:url value='/fontawesome6/css/all.min.css' />">


</head>
<body>
	<div class="modal fade" id="deleteCommentConfirm" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
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
					<button type="button" class="btn btn-primary">Xác nhận</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="updateCommentPopup" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
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
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Hủy bỏ</button>
					<button type="button" class="btn btn-primary">Xác nhận</button>
				</div>
			</div>
		</div>
	</div>



	<div class="container d-flex flex-column chi-tiet-wrapper">
		<div>Header</div>

		<div class="d-flex flex-column content ">
			<jsp:include page="../components/bai-viet-component.jsp">
				<jsp:param value="true" name="isDetailMode" />

			</jsp:include>

			<div class="comment-wrapper">
				<div class="comment-form-wrapper">
					<form action="#" class="comment-form">
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
					</form>
					<div class="comment-image-attach" id="comment-image-attach">
						<img id="comment-show-img" src="" /> <span id="comment-file-name"></span>
						<button id="comment-delete-file">
							<i class="fa-solid fa-circle-xmark"></i>
						</button>
					</div>
				</div>
				<div class="comment-record-wrapper">
					<div class="comment-record-item" data-id=1>
						<img class="comment-record-profile-img"
							src="<c:url value='/assets/images/defaultProfileImage.png' />" />
						<div class="comment-record-right">
							<div class="comment-record-content">
								<div class="comment-record-title">
									<div class="comment-record-title-content">
										<h5>Châu Quốc Thanh</h5>
										<span> 6/11/2023 </span>
									</div>
									<div class="comment-record-title-right">
										<i class="fa fa-ellipsis-h"></i>
										<div class="comment-more-hover">

											<button type="button" class="btn edit-comment-btn  "
												data-bs-toggle="modal" data-bs-target="#updateCommentPopup">
												<i class="fa fa-cog" aria-hidden="true"></i><span>
													Chỉnh sửa </span>
											</button>
											<button type="button" class="btn delete-comment-btn "
												data-bs-toggle="modal"
												data-bs-target="#deleteCommentConfirm">
												<i class="fa fa-trash" aria-hidden="true"></i> <span>
													Xóa </span>
											</button>
										</div>

									</div>
								</div>
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Architecto eaque ipsum incidunt, alias placeat sequi obcaecati
									debitis sint ut, rem accusamus, voluptas perspiciatis illo?
									Culpa exercitationem dolore iure aut. Minus.</p>
								<div class="comment-record-react">
									<div class="react-data">
										<div class="react-data-item">
											<img alt="" src="<c:url value='/assets/images/like.png' />">
										</div>
										<div class="react-data-item">
											<img alt="" src="<c:url value='/assets/images/heart.png' />">
										</div>
										<div class="react-data-item">
											<img alt="" src="<c:url value='/assets/images/sad.png' />">
										</div>
										<div class="react-data-item">
											<img alt="" src="<c:url value='/assets/images/haha.png' />">
										</div>
										<div class="react-data-item">
											<img alt="" src="<c:url value='/assets/images/mad.png' />">
										</div>
										<span> 230 </span>
									</div>
									<button class="comment-record-react-action">
										<i class="fa-solid fa-thumbs-up"></i> <span>Thích</span>
										<div class="comment-record-more-action">
											<div class="comment-record-react-item">
												<img alt="" src="<c:url value='/assets/images/like.png' />">
											</div>
											<div class="comment-record-react-item">
												<img alt="" src="<c:url value='/assets/images/heart.png' />">
											</div>
											<div class="comment-record-react-item">
												<img alt="" src="<c:url value='/assets/images/sad.png' />">
											</div>
											<div class="comment-record-react-item">
												<img alt="" src="<c:url value='/assets/images/haha.png' />">
											</div>
											<div class="comment-record-react-item">
												<img alt="" src="<c:url value='/assets/images/mad.png' />">
											</div>
										</div>
									</button>
								</div>
							</div>
							<img class="comment-record-img"
								src="<c:url value='/assets/images/bangcuc.jpg' />" />
						</div>
					</div>

				</div>
			</div>

		</div>





	</div>


	<script type="text/javascript"
		src="<c:url value='/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/jquery/jquery-3.7.1.min.js' />"></script>

	<script type="text/javascript"
		src="<c:url value='/fontawesome6/js/all.min.js' />"></script>


	<script type="text/javascript"
		src="<c:url value='/resources/js/bai-viet-component.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/js/chi-tiet-bai-viet.js' />"></script>

</body>
</html>