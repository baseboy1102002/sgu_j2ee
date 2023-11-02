<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

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
		<div class="profile-right">


			<i class="fa fa-ellipsis-h"></i>
			<div class="profile-more-hover">
				<div>
					<i class="fa fa-cog" aria-hidden="true"></i> <span>Chỉnh sửa</span>
				</div>
				<div>
					<i class="fa fa-trash" aria-hidden="true"></i> <span>Xóa</span>
				</div>


			</div>
		</div>
	</div>
</div>

