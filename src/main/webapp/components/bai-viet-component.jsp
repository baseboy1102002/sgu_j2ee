
<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:set var="anhDaiDienNguoiDung"
	value="${baiVietView.anhDaiDienNguoiDang }" />


<div class="d-flex flex-column  bai-viet-content-wrapper"
	data-post-id=${baiVietView.baiViet.maBaiViet }
	data-is-detail-mode=${param.isDetailMode } data-user-login="4">
	<div class=" d-flex justify-content-between profile-wrapper">
		<div class="d-flex profile-left">
			<a href="/sgu_j2ee/profile?userID=${baiVietView.maNguoiDang}"
				class="profile-img"> <img
				src="/sgu_j2ee/files/${anhDaiDienNguoiDung}" alt="" />
			</a>
			<div class="profile-info">
				<h1>${baiVietView.hoVaTenNguoiDang}</h1>
				<span>Đã đăng vào lúc ${baiVietView.baiViet.ngayDang} </span>
			</div>

		</div>

		<div class="profile-right" onclick="showMore(this)">
			<i class="fa fa-ellipsis-h"></i>
			<div class="profile-more-hover">

				<c:if test="${sessionScope.ID eq baiVietView.maNguoiDang }">
					<button type="button" class="btn profile-item edit-post-btn"
						onclick="editPost(this)">
						<i class="fa fa-cog" aria-hidden="true"></i><span> Chỉnh
							sửa </span>
					</button>
					<button type="button" class="btn profile-item delete-post-btn"
						data-bs-toggle="modal" data-bs-target="#deletePostConfirm"
						onclick="onPostDeleteClick(this)">
						<i class="fa fa-trash" aria-hidden="true"></i> <span> Xóa </span>
					</button>
				</c:if>

				<button type="button" class="btn profile-item report-post-btn"
					data-bs-toggle="modal" data-bs-target="#reportPostPopUp"
					onclick="handleReport(this)">
					<i class="fa-solid fa-flag"></i> <span> Báo cáo </span>
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
		<c:if test="${param.isDetailMode }">
			<c:if test="${!empty baiVietView.fileDinhKems }">
				<div class="attachments">
					<c:forEach var="attachment" items="${baiVietView.fileDinhKems}">
						<div class="attachment">
							<a href="/sgu_j2ee/files/${attachment.tenFile}"
								download="/sgu_j2ee/files/${attachment.tenFile}"> <span
								class="attachment-icon"><i class="fa-solid fa-paperclip"></i></span>
								<span class="attachment-name">${attachment.tenFile}</span>
							</a>
						</div>
					</c:forEach>
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
				<span> <c:if test="${baiVietView.tongLuotTuongTac > 0}">
       								 ${baiVietView.tongLuotTuongTac}
   												 </c:if>
				</span>
			</div>
			<div class="comment-data">${baiVietView.binhLuanCount} bình luận</div>
		</div>
		<hr>
		<div class="bai-viet-actions">
			<div class="react-action ">
				<div onclick="handleOnClickReact(this)"
					class=" react-action-btn ${empty baiVietView.loginUserTuongTacBaiViet ? '' : 'active' } "
					data-active=${empty baiVietView.loginUserTuongTacBaiViet ? false : true }>
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

				</div>



				<div class="more-action">
					<div class="react-action-item" data-react="like"
						onclick="onReactClick(this)">
						<img alt="" src="<c:url value='/assets/images/like.png' />">
					</div>
					<div class="react-action-item" data-react=heart
						onclick="onReactClick(this)">
						<img alt="" src="<c:url value='/assets/images/heart.png' />">
					</div>
					<div class="react-action-item" data-react="sad"
						onclick="onReactClick(this)">
						<img alt="" src="<c:url value='/assets/images/sad.png' />">
					</div>
					<div class="react-action-item" data-react="haha"
						onclick="onReactClick(this)">
						<img alt="" src="<c:url value='/assets/images/haha.png' />">
					</div>
					<div class="react-action-item" data-react="mad"
						onclick="onReactClick(this)">
						<img alt="" src="<c:url value='/assets/images/mad.png' />">
					</div>
				</div>
			</div>

			<c:if test="${!param.isDetailMode }">
				<a class="comment-action"
					href="/sgu_j2ee/chitietbaiviet?maBaiViet=${baiVietView.baiViet.maBaiViet }">
					<i class="fa fa-comment" aria-hidden="true"></i> <span>Bình
						luận</span>
				</a>
			</c:if>
			<c:if test="${param.isDetailMode }">
				<div class="comment-action">
					<i class="fa fa-comment" aria-hidden="true"></i> <span>Bình
						luận</span>
				</div>
			</c:if>

		</div>

	</div>
</div>