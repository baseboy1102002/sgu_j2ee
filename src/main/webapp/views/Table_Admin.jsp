<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Trang Chủ - NienHope</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css"
	type="text/css">
</head>

<body>
	<!-- Header Section Begin -->
	<jsp:include page="Header(Admin).jsp"></jsp:include>
	<!-- Header End -->

	<!-- Login Section Begin -->
	<section class="admin__table">
		<div class="container mt-5">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color:#91bbff">ID1</th>
						<th style="background-color:#91ffbd">ID2</th>
						<th style="background-color:#fff091">Time</th>
						<th style="background-color:#ffaf91">Reason</th>
						<th style="background-color:#eb91ff">Actions</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>ABC</td>
						<td>2023-11-22 12:00 PM</td>
						<td>Some reason</td>
						<td>
							<button type="button" class="btn btn-primary">Edit</button>
							<button type="button" class="btn btn-danger">Delete</button>
						</td>
					</tr>
					<!-- Add more rows as needed -->
				</tbody>
			</table>
		</div>
	</section>
	<!-- Login Section End -->

	<!-- Footer Section Begin -->
	<jsp:include page="Footer.jsp"></jsp:include>
	<!-- Footer End -->

</body>
</html>