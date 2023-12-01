<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-4">
				<div class="header__logo">
					<a class="logo" href="/sgu_j2ee/views/Home.jsp"> <img class="logo_img"
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
		</div>
	</div>
</header>
<script>

	//Chuyển sang trang chi tiết bài viết khi ấn vào
	function checkEnterKey(event) {
		
		if (event.key === "Enter" && !event.shiftKey) {
			var url = "/sgu_j2ee/search?keySearch=" + $("#SearchInput").val() + "&type=";
			window.location.href = url;

		}
	}
	</script>

