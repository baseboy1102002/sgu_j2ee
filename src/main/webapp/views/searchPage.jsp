<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->

<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/fontawesome6/css/all.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bai-viet-component.css' />">
	


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/globalstyle.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/searchPage.css" />

</head>
<jsp:include page="Layout/Head.jsp"></jsp:include>
<body>

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
	
	<jsp:include page="Layout/Header.jsp"></jsp:include>

	<div class="row" id="search_page" style="margin-top: 100px; background-color: #f1f6ff; ">
		<div class="col-xm-2 col-lg-2 col-xl-2">
			<div id="sp_container_left">
				<div class="sp_container_left_header">
					<h2>Kết quả tìm kiếm</h2>
					<hr>
					
				</div>
				<ul class="nav flex-column">
					<li>
						<div class="cp_button">
							<i class="fa-solid fa-book"></i>
							<a href="${pageContext.request.contextPath}/search?keySearch=${keySearch}">
								<button class=
									<c:if test = "${context == null}">
										active
									</c:if>
								>
									<span>Tất cả</span>
								</button>
							</a>
						</div>
						<hr>
					</li>
					<li>
						<div class="cp_button">
							<i class="fa-solid fa-user"></i>
							<a href="${pageContext.request.contextPath}/search?type=users&keySearch=${keySearch}">
								<button class=
									<c:if test = "${context == 'users'}">
										active
									</c:if>
								>
									<span>Người dùng</span>
								</button>
							</a>
						</div>
						<hr>
					</li>
					<li>
						<div class="cp_button">
							<i class="fa-solid fa-signs-post"></i>
							<a href="${pageContext.request.contextPath}/search?type=posts&keySearch=${keySearch}">
								<button class=
									<c:if test = "${context == 'posts'}">
										active
									</c:if>
								>
									<span>Bài viết</span>
								</button>
							</a>
						</div>
						<hr>
					</li>
				</ul>
			</div>
		</div>
		<div class="col-xm-10 col-lg-10 col-xl-10">
			<div id="sp_container_right">
				<div id="sp_all" class="flex-column" style="height: 100vh">
					<c:if test = "${users == null && posts == null}">
						<div>Khong co ket qua tim kiem</div>
					</c:if>
					<c:if test = "${users != null}">
						<div class="sp_all_user">
							<h2>Mọi người</h2>
						</div>
					</c:if>
					<c:forEach items="${users}" var="user">
				         <div class="sp_user_info row">
							<div class="col-sm-8">
								<a href="/sgu_j2ee/profile?userID=${user.getMaNguoiDung() }" style="color: #000">
								<!-- <i class="fa-solid fa-user"></i> -->
								<img alt="" src="/sgu_j2ee/files/${user.getHinhDaiDien() }" width="40" style="border-radius: 50%; margin-right: 10px;">
								<span>${user.getHoVaTen()}</span>													
								</a>
							</div>
							<div class="col-sm-4">
								
								<button class="add-friend" data-set="${user.getMaNguoiDung()}" onclick="addFriend('${pageContext.request.contextPath}/search/add-friend?friendId=${user.getMaNguoiDung()}', '${user.getMaNguoiDung()}')">Thêm bạn bè</button>								
								
							</div>
						</div>
				    </c:forEach>
					<c:if test = "${posts != null}">
						<div class="sp_all_post">
							<h2>Bài viết</h2>
						</div>
								<c:forEach var="i" items="${posts}">
									<div class="sp_post">
										<c:set var="baiVietView" value="${i}" scope="request" />
										<jsp:include page="../components/bai-viet-component.jsp">
											<jsp:param value="false" name="isDetailMode" />
										</jsp:include>
									</div>
								</c:forEach>
					</c:if>
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		async function addFriend(url, id) {
		 	const response = await fetch(url);
			const buttons = document.querySelectorAll(".add-friend")
			for(let i of buttons){
				if(i.getAttribute("data-set") == id){
					i.innerHTML = "Đã gửi yêu cầu"
					i.style.backgroundColor = "#ccc"
				}
			}
		}
	</script>
	<jsp:include page="Layout/Footer.jsp"></jsp:include>

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
		
</body>
</html>