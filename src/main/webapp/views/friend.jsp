<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.NguoiDung"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>Friend Page</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_friend.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shared_style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
	
	
</head>

<body>
	<div class="header"></div>

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

			<input type="text" class="content_header_search_input" id="search_input" placeholder="Nhập tên để tìm kiếm">
		</div>
		
		<ul class="content_listfriend" id="content_listfriend">
			<c:forEach items="${userlist}" var="user" varStatus="loop">
				<c:if test="${loop.index < 8}">
					<li class="listfriend_item">
						<a href="action?type=dsbb&nameact=trangcanhan&userid1=${sessionScope.ID}&userid2=${user.maNguoiDung}" class="item_info">
							<img src="/sgu_j2ee/files/${user.hinhDaiDien}.png" alt="ảnh người dùng" class="item_info_img">
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
		</ul>
	
		<ul class="pagination">
			<li class="pagination_item" id="prevButton">Trước</li>
			<li class="pagination_item" id="nextButton">Sau</li>
		</ul>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/friend.js"></script>
</html>