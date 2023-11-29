<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<jsp:include page="Layout/Head.jsp"></jsp:include>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/header.css"
		type="text/css">
<title>Trang Chủ - NienHope</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css" type="text/css">
</head>
<body>
	<jsp:include page="Layout/Header(Admin).jsp"></jsp:include>

	<section class="admin__table">
		<div class="container mt-5">
			<table class="table table-bordered">
				<thead>
					<tr>
						<% String require = (String) request.getAttribute("require"); %>
						<c:set var="require" value="${require}" />
						<c:choose>
							<c:when test="${require eq 'QLBV'}">
								<th style="background-color: #91bbff">Mã người dùng báo cáo</th>
								<th style="background-color: #91ffbd">Mã bài viết</th>
								<th style="background-color: #fff091">Thời gian báo cáo</th>
								<th style="background-color: #ffaf91">Lí do</th>
								<th style="background-color: #eb91ff">Hành động</th>
						    </c:when>
						    <c:when test="${require eq 'QLND'}">
						        <th style="background-color: #91bbff">Mã người dùng báo cáo</th>
								<th style="background-color: #91ffbd">Mã người dùng bị báo cáo</th>
								<th style="background-color: #fff091">Thời gian báo cáo</th>
								<th style="background-color: #ffaf91">Lí do</th>
								<th style="background-color: #eb91ff">Hành động</th>
						    </c:when>
						    <c:when test="${require eq 'QLBL'}">
						       	<th style="background-color: #91bbff">Mã người dùng báo cáo</th>
								<th style="background-color: #91ffbd">Mã bình luận</th>
								<th style="background-color: #fff091">Thời gian báo cáo</th>
								<th style="background-color: #ffaf91">Lí do</th>
								<th style="background-color: #eb91ff">Hành động</th>
						    </c:when>
						    <c:when test="${require eq 'LSQLBV'}">
						        <th style="background-color: #91bbff">Mã quản lý</th>
								<th style="background-color: #91ffbd">Mã bài viết</th>
								<th style="background-color: #fff091">Thời gian thực hiện</th>
								<th style="background-color: #ffaf91">Chi tiết thực hiện</th>
								<th style="background-color: #eb91ff">Hành động</th>
						    </c:when>
						    <c:when test="${require eq 'LSQLND'}">
						        <th style="background-color: #91bbff">Mã quản lý</th>
								<th style="background-color: #91ffbd">Mã người dùng</th>
								<th style="background-color: #fff091">Thời gian thực hiện</th>
								<th style="background-color: #ffaf91">Chi tiết thực hiện</th>
								<th style="background-color: #eb91ff">Hành động</th>
						    </c:when>
						    <c:when test="${require eq 'LSQLBL'}">
						        <th style="background-color: #91bbff">Mã quản lý</th>
								<th style="background-color: #91ffbd">Mã bình luận</th>
								<th style="background-color: #fff091">Thời gian thực hiện</th>
								<th style="background-color: #ffaf91">Chi tiết thực hiện</th>
								<th style="background-color: #eb91ff">Hành động</th>
						    </c:when>
						</c:choose>
					</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${require eq 'QLBV'}">
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.maNguoiDung}</td>
							<td>${item.maBaiViet}</td>
							<td>${item.ngayGioBaoCao}</td>
							<td>${item.liDo}</td>
							<td>
								<a href="/sgu_j2ee/chitietbaiviet?maBaiViet=${item.maBaiViet}" class="btn btn-primary">View Detail</a>
								<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maBaiViet}" class="btn btn-danger">Ban</a>
							</td>
						</tr>
					</c:forEach>
				    </c:when>
				    
				    <c:when test="${require eq 'QLND'}">
			        <c:forEach items="${list}" var="item">
					<tr>
						<td>${item.maNguoiDungBaoCao}</td>
						<td>${item.maNguoiDungBiBaoCao}</td>
						<td>${item.ngayGioBaoCao}</td>
						<td>${item.liDo}</td>
						<td>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maNguoiDungBiBaoCao}" class="btn btn-primary">View Detail</a>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maNguoiDungBiBaoCao}" class="btn btn-danger">Ban</a>
						</td>
					</tr>
					</c:forEach>
				    </c:when>
				    
				    <c:when test="${require eq 'QLBL'}">
			       	<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.maNguoiDung}</td>
						<td>${item.maBinhLuan}</td>
						<td>${item.ngayGioBaoCao}</td>
						<td>${item.liDo}</td>
						<td>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maBinhLuan}" class="btn btn-primary">View Detail</a>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maBinhLuan}" class="btn btn-danger">Ban</a>
						</td>
					</tr>
					</c:forEach>
				    </c:when>
				    
				    <c:when test="${require eq 'LSQLBV'}">
			        <c:forEach items="${list}" var="item">
					<tr>
						<td>${item.maQuanLy}</td>
						<td>${item.maBaiViet}</td>
						<td>${item.ngayGioCapNhat}</td>
						<td>${item.chiTietCapNhat}</td>
						<td>
							<a href="/sgu_j2ee/chitietbaiviet?maBaiViet=${item.maBaiViet}" class="btn btn-primary">View Detail</a>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maBaiViet}" class="btn btn-danger">Undo</a>
						</td>
					</tr>
					</c:forEach>
				    </c:when>
				    
				    <c:when test="${require eq 'LSQLND'}">
			        <c:forEach items="${list}" var="item">
					<tr>
						<td>${item.maQuanLy}</td>
						<td>${item.maNguoiDung}</td>
						<td>${item.ngayGioCapNhat}</td>
						<td>${item.chiTietCapNhat}</td>
						<td>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maNguoiDung}" class="btn btn-primary">View Detail</a>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maNguoiDung}" class="btn btn-danger">Undo</a>
						</td>
					</tr>
					</c:forEach>
				    </c:when>
				    
				    <c:when test="${require eq 'LSQLBL'}">
			        <c:forEach items="${list}" var="item">
					<tr>
						<td>${item.maQuanLy}</td>
						<td>${item.maBinhLuan}</td>
						<td>${item.ngayGioCapNhat}</td>
						<td>${item.chiTietCapNhat}</td>
						<td>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maBinhLuan}" class="btn btn-primary">View Detail</a>
							<a href="/sgu_j2ee/admin_action?require=${require}&idadmin=${sessionScope.ID}&id=${item.maBinhLuan}" class="btn btn-danger">Undo</a>
						</td>
					</tr>
					</c:forEach>
				    </c:when>
				</c:choose>
				</tbody>
			</table>
		</div>
	</section>
	
	<jsp:include page="Layout/Footer.jsp"></jsp:include>
</body>
</html>