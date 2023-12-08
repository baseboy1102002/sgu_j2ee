<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-4">
				<div class="header__logo">
					<a class="logo" href="#"> <img class="logo_img"
						src="${pageContext.request.contextPath}/assets/images/logo.png"
						alt="">
					</a>
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

