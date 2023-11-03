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
	<div class="container d-flex flex-column chi-tiet-wrapper">
		<div>Header</div>

		<div class="d-flex content ">
			<jsp:include page="../components/bai-viet-component.jsp">
				<jsp:param value="true" name="isDetailMode"/>
			
			</jsp:include>

		</div>





	</div>

	<script type="text/javascript"
		src="<c:url value='/bootstrap/js/bootstrap.bundle.min.js' />"></script>

	<script type="text/javascript"
		src="<c:url value='/fontawesome6/js/all.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/js/bai-viet-component.js' />"></script>


</body>
</html>