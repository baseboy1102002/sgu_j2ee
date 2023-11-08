
<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%@include file="/components/post-edit-form.jsp"%>

<div class="modal fade" id="notifyModal" aria-hidden="true"
	data-bs-backdrop="static" data-is-detail-mode="${param.isDetailMode }"
	aria-labelledby="exampleModalToggleLabel" tabindex="-1">
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
					id="confirm-notify-btn">Quay lại</button>
			</div>
		</div>
	</div>
</div>



<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true"
	data-id-bai-viet="${baiVietView.baiViet.maBaiViet}"
	data-is-detail-mode="${param.isDetailMode }">
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


<div class="d-flex flex-column  bai-viet-content-wrapper"
	data-post-id=${baiVietView.baiViet.maBaiViet }>
	<div class=" d-flex justify-content-between profile-wrapper">
		<div class="d-flex profile-left">
			<div class="profile-img">
				<img
					src=<c:url value='${empty baiVietView.anhDaiDienNguoiDang ? "/assets/images/defaultProfileImage.png" :baiVietView.anhDaiDienNguoiDang   }' />
					alt="" />
			</div>
			<div class="profile-info">
				<h1>${baiVietView.hoVaTenNguoiDang}</h1>
				<span>Đã đăng vào lúc ${baiVietView.baiViet.ngayDang} </span>
			</div>

		</div>

		<div class="profile-right">
			<i class="fa fa-ellipsis-h"></i>
			<div class="profile-more-hover">

				<button type="button" class="btn profile-item edit-post-btn">
					<i class="fa fa-cog" aria-hidden="true"></i><span> Chỉnh sửa
					</span>
				</button>




				<button type="button" class="btn profile-item delete-post-btn"
					data-bs-toggle="modal" data-bs-target="#exampleModal">
					<i class="fa fa-trash" aria-hidden="true"></i> <span> Xóa </span>
				</button>
			</div>
		</div>

	</div>
	<div
		class="d-flex flex-column bai-viet-main-content <c:if test="${!param.isDetailMode }">not-detail-mode</c:if>	">
		<p>${baiVietView.baiViet.noiDung }</p>
		<c:if test="${!param.isDetailMode }">

			<div class="see-more">
				<a
					href="/sgu_j2ee/chitietbaiviet?maBaiViet=${baiVietView.baiViet.maBaiViet }">Xem
					thêm</a>
			</div>
		</c:if>


		<c:if test="${param.isDetailMode }">
			<c:if test="${!empty baiVietView.fileHinhAnhs }">
				<div id="carouselExampleIndicators"
					class="carousel slide img-content" data-bs-ride="carousel">
					<div class="carousel-indicators">
						<c:forEach items="${baiVietView.fileHinhAnhs}" varStatus="loop">
							<button type="button" data-bs-target="#carouselExampleIndicators"
								data-bs-slide-to="${loop.index}"
								${loop.index == 0 ? 'class="active" aria-current="true"' : '' }
								aria-label="${loop.index + 1}"></button>
						</c:forEach>
					</div>
					<div class="carousel-inner w-100 h-100">
						<c:forEach items="${baiVietView.fileHinhAnhs}" var="item"
							varStatus="loop">
							<div
								class='carousel-item  w-100 h-100 ${loop.index == 0 ? "active" : "" }'>
								<img src="/sgu_j2ee/files/${item.tenFile}"
									class="img-thumbnail d-block w-100 h-100" alt="...">
							</div>
						</c:forEach>
					</div>

					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>

			</c:if>
		</c:if>






		<div class="bai-viet-data">
			<div class="react-data">
				<c:forEach var="item" items="${baiVietView.top3TuongTac }">
					<div class="react-data-item">
						<img alt=""
							src="<c:url value='/assets/images/${item.trangThai }.png' />">
					</div>
				</c:forEach>
				<span> ${baiVietView.tongLuotTuongTac} </span>
			</div>
			<div class="comment-data">${baiVietView.binhLuanCount}bìnhluận</div>
		</div>
		<hr>
		<div class="bai-viet-actions">
			<div
				class="react-action ${empty baiVietView.loginUserTuongTacBaiViet ? '' : 'active' }">

				<c:if test="${empty baiVietView.loginUserTuongTacBaiViet }">
					${baiVietView.loginUserTuongTacBaiViet }			
					<i class="fa fa-thumbs-up" aria-hidden="true"></i>
					<span>Thích</span>
				</c:if>

				<c:if test="${!empty baiVietView.loginUserTuongTacBaiViet }">
					<img alt=""
						src="<c:url value='/assets/images/${baiVietView.loginUserTuongTacBaiViet.trangThai }.png' />">
					<span class="${baiVietView.loginUserTuongTacBaiViet.trangThai }">${baiVietView.loginUserTuongTacBaiViet.trangThai }</span>
				</c:if>
				<div class="more-action">
					<div class="react-action-item">
						<img alt="" src="<c:url value='/assets/images/like.png' />">
					</div>
					<div class="react-action-item">
						<img alt="" src="<c:url value='/assets/images/heart.png' />">
					</div>
					<div class="react-action-item">
						<img alt="" src="<c:url value='/assets/images/sad.png' />">
					</div>
					<div class="react-action-item">
						<img alt="" src="<c:url value='/assets/images/haha.png' />">
					</div>
					<div class="react-action-item">
						<img alt="" src="<c:url value='/assets/images/mad.png' />">
					</div>
				</div>
			</div>
			<div class="comment-action">
				<c:if test="${!param.isDetailMode }">
					<a
						href="/sgu_j2ee/chitietbaiviet?maBaiViet=${baiVietView.baiViet.maBaiViet }"></a>
				</c:if>
				<i class="fa fa-comment" aria-hidden="true"></i> <span>Bình
					luận</span>
			</div>
		</div>

	</div>

</div>