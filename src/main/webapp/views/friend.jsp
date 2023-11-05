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

	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/style_friend.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/shared_style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
	
</head>

<body>
	<div class="header"></div>

	<div class="content">
		<div class="content_header">
			<div class="content_header_selection_wrapper">
				<select name="type" id="type" class="content_header_selection_cbb" onchange="loadContent(1)">
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
						<a href="" class="item_info">
							<img src="/sgu_j2ee/files/${user.hinhdaidien}.png" alt="ảnh người dùng" class="item_info_img">
							<div class="item_info_name">${user.hovaten}</div>
						</a>
	
						<div class="item_action">
							<a href="action?type=DSBB?numberaction=1?userid1=1?userid2=${user.manguoidung}" class="action_message"> 
								<i class="fa-regular fa-comment" style="margin-right: 10px;"></i>Nhắn tin
							</a>
							<a href="action?type=DSBB?numberaction=2userid1=1?userid2=${user.manguoidung}" class="action_cancel">
								<i class="fa-solid fa-xmark" style="margin-right: 10px;"></i> Hủy
							</a>
							<a href="action?type=DSBB?numberaction=3userid1=1?userid2=${user.manguoidung}" class="action_block">
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js">
</script>
<script>
	var currentPage = 1;
	
	function loadContent(page) {		
	    var select = document.getElementById('type');
	    var selectedValue = select.options[select.selectedIndex].value;
	
	    var searchInput = document.getElementById('search_input');
	    var searchInputValue = searchInput.value || "";
	    
	    page = currentPage;
	
	    $.ajax({
	        url: "/sgu_j2ee/load",
	        type: "get",
	        data: {
	            type: selectedValue,
	            indexpage: page,
	            search: searchInputValue
	        },
	        success:function (response) {
	            var content_listfriend = document.getElementById("content_listfriend");
	            content_listfriend.innerHTML = response;
	        },
	        error: function (xhr) {
	            alert(xhr);
	        }
	    });
	}
	
	$(document).ready(function () {
	    $("#nextButton").on("click", function () {
	    	var listItems = document.getElementsByClassName("listfriend_item");
	    	if(listItems.length == 8) {
	    		currentPage++; 
		        loadContent(currentPage);
	    	}
	    });
	
	    $("#prevButton").on("click", function () {
	        if (currentPage > 1) {
	            currentPage--; 
	            loadContent(currentPage);
	        }
	    });
	    
	    $("#search_input").on("keydown", function (e) {
	        if (e.key === "Enter") {
	            loadContent(1);
	        }
	    });
	});

</script>
</html>