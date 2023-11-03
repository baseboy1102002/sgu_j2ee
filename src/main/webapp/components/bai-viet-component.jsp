<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
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
				<button type="button" class="btn btn-primary">Xác nhận</button>
			</div>
		</div>
	</div>
</div>


<div class="d-flex flex-column  bai-viet-content-wrapper">
	<div class=" d-flex justify-content-between profile-wrapper">
		<div class="d-flex profile-left">
			<div class="profile-img">
				<img alt=""
					src="<c:url value='/assets/images/defaultProfileImage.png' />">
			</div>
			<div class="profile-info">
				<h1>Châu Quốc Thanh</h1>
				<span>Đã đăng vào lúc 7:54 1/11/2023</span>
			</div>

		</div>

		<div class="profile-right" onclick="showDiv('profile-more-hover')">


			<i class="fa fa-ellipsis-h"></i>
			<div class="profile-more-hover">

				<button type="button" class="btn profile-item "
					data-bs-toggle="modal" data-bs-target="#exampleModal">
					<i class="fa fa-cog" aria-hidden="true"></i><span> Chỉnh sửa
					</span>
				</button>




				<button type="button" class="btn profile-item"
					data-bs-toggle="modal" data-bs-target="#exampleModal">
					<i class="fa fa-trash" aria-hidden="true"></i> <span> Xóa </span>
				</button>


			</div>
		</div>

	</div>
	<div
		class="d-flex flex-column bai-viet-main-content <c:if test="${!param.isDetailMode }">not-detail-mode</c:if>	">
		<p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.
			Repudiandae repellat vero eum laboriosam itaque corporis
			exercitationem, eius sit officia. Dolorem magnam nam nesciunt
			exercitationem debitis obcaecati explicabo nihil inventore
			accusantium!Lorem, ipsum dolor sit amet consectetur adipisicing elit.
			Repudiandae repellat vero eum laboriosam itaque corporis
			exercitationem, eius sit officia. Dolorem magnam nam nesciunt
			exercitationem debitis obcaecati explicabo nihil inventore
			accusantium! Lorem, ipsum dolor sit amet consectetur adipisicing
			elit. Repudiandae repellat vero eum laboriosam itaque corporis
			exercitationem, eius sit officia. Dolorem magnam nam nesciunt
			exercitationem debitis obcaecati explicabo nihil inventore
			accusantium!Lorem, ipsum dolor sit amet consectetur adipisicing elit.
			Repudiandae repellat vero eum laboriosam itaque corporis
			exercitationem, eius sit officia. Dolorem magnam nam nesciunt
			exercitationem debitis obcaecati explicabo nihil inventore
			accusantium!</p>
		<c:if test="${!param.isDetailMode }">

			<div class="see-more">
				<a href="#">Xem thêm</a>
			</div>
		</c:if>

		<div id="carouselExampleIndicators" class="carousel slide img-content"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner w-100 h-100">
				<div class="carousel-item active w-100 h-100">
					<img src="<c:url value='/assets/images/bangcuc.jpg' />"
						class="img-thumbnail d-block w-100 h-100" alt="...">
				</div>
				<div class="carousel-item  w-100 h-100">
					<img src="<c:url value='/assets/images/nui.jpg' />"
						class="img-thumbnail d-block w-100 h-100" alt="...">
				</div>
				<div class="carousel-item w-100 h-100">
					<img src="<c:url value='/assets/images/Sahara.jpg' />"
						class="img-thumbnail d-block w-100 h-100" alt="...">
				</div>
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





		<div class="bai-viet-data">
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
			<div class="comment-data">22 Bình luận</div>
		</div>
		<hr>
		<div class="bai-viet-actions">
			<div class="react-action">

				<i class="fa fa-thumbs-up" aria-hidden="true"></i> <span>Thích</span>

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
				<i class="fa fa-comment" aria-hidden="true"></i> <span>Bình
					luận</span>
			</div>
		</div>

	</div>

</div>