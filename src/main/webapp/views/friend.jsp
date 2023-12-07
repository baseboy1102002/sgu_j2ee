<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.NguoiDung"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<jsp:include page="Layout/Head.jsp"></jsp:include>
	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>Friend Page</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_friend.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shared_style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
	
	
</head>

<body>
	<jsp:include page="Layout/Header.jsp"></jsp:include>

	<div class="content">
		<div class="content_header">
			<div class="content_header_selection_wrapper">
				<input type="hidden" id="selectedType" value="<%= request.getAttribute("type") %>" />
				<select name="type" id="type" class="content_header_selection_cbb" onchange="loadContent(1, ${sessionScope.ID})">
					<option value="dsbb" class="content_header_selection_cbb_item">Danh sách bạn bè</option>
					<option value="dslm" class="content_header_selection_cbb_item">Danh sách lời mời</option>
					<option value="dskbcb" class="content_header_selection_cbb_item">Danh sách kết bạn của bạn</option>
					<option value="dsc" class="content_header_selection_cbb_item">Danh sách chặn</option>
				</select>
			</div>

			<input type="text" class="content_header_search_input" id="search_input" placeholder="Nhập tên để tìm kiếm" onkeydown="handleKeyDown(event, ${sessionScope.ID})">
		</div>
		
		<ul class="content_listfriend" id="content_listfriend">
		
			<c:set var="type" value="${type}" />
				<c:choose>
				    <c:when test="${type eq 'dsbb'}">
				        <c:forEach items="${userlist}" var="user" varStatus="loop">
							<c:if test="${loop.index < 8}">
								<li class="listfriend_item">
									<a href="/sgu_j2ee/profile?userID=${user.maNguoiDung}" class="item_info">
										<img src="/sgu_j2ee/files/${user.hinhDaiDien}" alt="ảnh người dùng" class="item_info_img">
										<div class="item_info_name">${user.hoVaTen}</div>
									</a>
				
									<div class="item_action">
										<a href="mess?userid1=${sessionScope.ID}&userid2=${user.maNguoiDung}" class="action_message"> 
											<i class="fa-regular fa-comment" style="margin-right: 10px;"></i>Nhắn tin
										</a>
										<a href="action?type=dsbb&nameact=huy&userid1=${sessionScope.ID}&userid2=${user.maNguoiDung}" class="action_cancel">
											<i class="fa-solid fa-xmark" style="margin-right: 10px;"></i> Hủy
										</a>
										<a href="action?type=dsbb&nameact=chan&userid1=${sessionScope.ID}&userid2=${user.maNguoiDung}" class="action_block">
											<i class="fa-solid fa-ban" style="margin-right: 10px;"></i> Chặn
										</a>
									</div>
								</li>
							</c:if>
						</c:forEach>
				    </c:when>
				    <c:when test="${type eq 'dslm'}">
				        <c:forEach items="${userlist}" var="user" varStatus="loop">
							<c:if test="${loop.index < 8}">
								<li class="listfriend_item">
									<a href="/sgu_j2ee/profile?userID=${user.maNguoiDung}" class="item_info">
										<img src="/sgu_j2ee/files/${user.hinhDaiDien}" alt="ảnh người dùng" class="item_info_img">
										<div class="item_info_name">${user.hoVaTen}</div>
									</a>
				
									<div class="item_action">
									    <a href="action?type=${type}&nameact=chapnhan&userid1=${iuserid}&userid2=${nd.getMaNguoiDung()}" class="action_message">
									        <i class="fa-regular fa-circle-check" style="margin-right: 10px;"></i> Chấp nhận
									    </a>
									    <a href="action?type=${type}&nameact=huy&userid1=${iuserid}&userid2=${nd.getMaNguoiDung()}" class="action_cancel">
									        <i class="fa-solid fa-xmark" style="margin-right: 10px;"></i> Hủy
									    </a>
									    <a href="action?type=${type}&nameact=huy&userid1=${iuserid}&userid2=${nd.getMaNguoiDung()}" class="action_block">
									        <i class="fa-solid fa-ban" style="margin-right: 10px;"></i> Chặn
									    </a>
									</div>
								</li>
							</c:if>
						</c:forEach>
				    </c:when>
				    <c:when test="${type eq 'dskbcb'}">
				        <c:forEach items="${userlist}" var="user" varStatus="loop">
							<c:if test="${loop.index < 8}">
								<li class="listfriend_item">
									<a href="/sgu_j2ee/profile?userID=${user.maNguoiDung}" class="item_info">
										<img src="/sgu_j2ee/files/${user.hinhDaiDien}" alt="ảnh người dùng" class="item_info_img">
										<div class="item_info_name">${user.hoVaTen}</div>
									</a>
				
									<div class="item_action">
									    <a href="action?type=${type}&nameact=huy&userid1=${iuserid}&userid2=${nd.getMaNguoiDung()}" class="action_cancel">
									        <i class="fa-solid fa-xmark" style="margin-right: 10px;"></i> Hủy
									    </a>
									    <a href="action?type=${type}&nameact=chan&userid1=${iuserid}&userid2=${nd.getMaNguoiDung()}" class="action_block">
									        <i class="fa-solid fa-ban" style="margin-right: 10px;"></i> Chặn
									    </a>
									</div>
								</li>
							</c:if>
						</c:forEach>
				    </c:when>
				    <c:when test="${type eq 'dsc'}">
				        <c:forEach items="${userlist}" var="user" varStatus="loop">
							<c:if test="${loop.index < 8}">
								<li class="listfriend_item">
									<a href="/sgu_j2ee/profile?userID=${user.maNguoiDung}" class="item_info">
										<img src="/sgu_j2ee/files/${user.hinhDaiDien}" alt="ảnh người dùng" class="item_info_img">
										<div class="item_info_name">${user.hoVaTen}</div>
									</a>
				
									<div class="item_action">
									    <a href="action?type=${type}&nameact=bochan&userid1=${iuserid}&userid2=${nd.getMaNguoiDung()}" class="action_cancel">
									        <i class="fa-solid fa-xmark" style="margin-right: 10px;"></i> Bỏ Chặn
									    </a>
									</div>
								</li>
							</c:if>
						</c:forEach>
				    </c:when>
				</c:choose>
			
		</ul>
	
		<ul class="pagination">
			<li class="pagination_item" id="prevButton" onclick="prevClick(${sessionScope.ID})">Trước</li>
			<li class="pagination_item" id="nextButton" onclick="nextClick(${sessionScope.ID}")>Sau</li>
		</ul>
	</div>
	
	<jsp:include page="Layout/Footer.jsp"></jsp:include>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/friend.js"></script>
</html>