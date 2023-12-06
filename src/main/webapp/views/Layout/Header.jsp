<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-4">
				<div class="header__logo">
					<a class="logo" href="/sgu_j2ee/trang-chu"> <img class="logo_img"
						src="${pageContext.request.contextPath}/assets/images/logo.png"
						alt="">
					</a>
				</div>
			</div>
			<div class="col-lg-5 col-8">
			
				<div class="search__bar">
					<span class="fa fa-search search__bar__icon"></span> <input
						type="text" id="SearchInput" class="search__bar__input"
						onkeydown="checkEnterKey(event)" 
						placeholder="Nhập từ khoá...">
				</div>
			</div>
			<div class="col-lg-4 col-12">
				<div class="header__right d-flex justify-content-between">

					<!-- Friends -->
					<div class="direct">
						<a href="/sgu_j2ee/friend?userid=${sessionScope.ID}"
							class="icon_group_circle"> <i class="header__icon fa fa-users"
							aria-hidden="true"></i>
						</a>
					</div>


					<!-- Chat -->
					<div class="direct">
						<a href="/sgu_j2ee/mess?userid1=${sessionScope.ID}&userid2=1"
							class="icon_group_circle"> <i class="header__icon fa fa-comments"
							aria-hidden="true"></i>
						</a>
					</div>

					<!-- Thông Báo -->
					<div class="direct">
						<a href="/sgu_j2ee/thongbao?userID=${sessionScope.ID}"
							class="icon_group_circle"> <i class="header__icon fa fa-bell"
							aria-hidden="true"></i>
						</a>
					</div>

					<div class="direct user__options">
						<div class="dropdown">
							<a href="#" class="dropdown-toggle icon_group_circle"
								id="profileDropdown" data-toggle="dropdown"> <i
								class="header__icon fa fa-user" aria-hidden="true"></i>
							</a>
							<div class="dropdown-menu" aria-labelledby="profileDropdown">
								<!-- Trang cá nhân -->
								<a class="dropdown-item" href="/sgu_j2ee/profile?userID=${sessionScope.ID}">Trang Cá Nhân</a>
								<!-- Cài Đặt -->
								<a class="dropdown-item" href="/sgu_j2ee/views/Setting.jsp">Cài
									Đặt</a>
								<!-- Logout -->
								<a class="dropdown-item" href="/sgu_j2ee/dang-xuat">Đăng
									Xuất</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>
<script>

	//Chuyển sang trang chi tiết bài viết khi ấn vào
	function checkEnterKey(event) {
		
		if (event.key === "Enter" && !event.shiftKey) {
			var url = "/sgu_j2ee/search?keySearch=" + $("#SearchInput").val();
			window.location.href = url;

		}
	}
	</script>

