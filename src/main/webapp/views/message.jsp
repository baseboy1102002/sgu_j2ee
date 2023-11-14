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
    <title>Message Page</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_message.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shared_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<body>
    <div class="header">

    </div>

    <div class="content">
        <div class="sidebar">
            <div class="sidebar_header">
                Friends
            </div>
            <ul class="sidebar_listfriend">
            	<c:forEach items="${userlist}" var="user">
	                <li class="sidebar_listfriend_item" id="${user.maNguoiDung}" onclick="loadNewUser(${sessionScope.ID}, ${user.maNguoiDung})">
	                    <img src="/sgu_j2ee/files/${user.hinhDaiDien}" alt="" class="sidebar_listfriend_item_img">
	                    <div class="sidebar_listfriend_item_name">
	                        ${user.hoVaTen}
	                    </div>
	                </li>
	      		</c:forEach>
            </ul>
        </div>

        <div class="chatbox" id="chatbox">
        	<c:set var="ndfocus" value="${ndfocus}" />
			<c:choose>
			    <c:when test="${ndfocus.maNguoiDung != 1}">
			        <div class="chatbox_header">
		                <a href="/sgu_j2ee/profile?userID=${ndfocus.maNguoiDung}" class="chatbox_header_info_wrapper">
		                    <img src="/sgu_j2ee/files/${ndfocus.hinhDaiDien}" alt="" class="chatbox_header_image">
		                    <div class="chatbox_header_info">
		                        <div class="chatbox_info_name">
		                            ${ndfocus.hoVaTen}
		                        </div>
		                        <div class="chatbox_info_status">
		                            <div class="status_dot"></div>
		                            <div class="status_name">
		                                ${ndfocus.trangThai}
		                            </div>
		                        </div>
		                    </div>
		                </a>
		                <div class="chatbox_call">
		                    <div class="chatbox_norcall">
		                        <i class="fa-solid fa-phone"></i>
		                    </div>
		                    <a href="/sgu_j2ee/callvid?userid1=${sessionScope.ID}&userid2=${ndfocus.maNguoiDung}" class="chatbox_vidcall">
			                    <i class="fa-solid fa-video"></i>
		                    </a>
		                </div>
		            </div>
		            <hr class="separateline">
		            <div class="chatbox_content" id="chatbox_content">
		            	<c:forEach items="${messlist}" var="mess" varStatus="status">
		            		<c:if test="${mess.maNguoiNhan == ndfocus.maNguoiDung}">
							    <div class="chatbox_content_receiver">
							        <img src="/sgu_j2ee/files/${ndfocus.hinhDaiDien}" alt="" class="receiver_image"></img>
							        <div class="receiver_value">
							            <div class="receiver_time">${timelist[status.index]}</div>
							            <div class="receiver_message">${mess.noiDung}</div>
							        </div>
							    </div>
							</c:if>

		            		<c:if test="${mess.maNguoiNhan == sessionScope.ID}">
		            			<div class="chatbox_content_sender">
				                    <div class="sender_value">
				                        <div class="sender_time">${timelist[status.index]}</div>
				                        <div class="sender_message">${mess.noiDung}</div>
				                    </div>
				                    <img src="/sgu_j2ee/files/${sessionScope.IMG}" alt="" class="sender_image"></img>
				                </div>
		            		</c:if>
		            	</c:forEach>
		            </div>
		            <div class="chatbox_inputs">
		                <div class="inputs_file">
		                    <i class="fa-regular fa-image"></i>
		                </div>
		                <textarea type="text" class="inputs_text" id="inputs_text" onkeydown="checkEnterKey(event, ${sessionScope.ID}, ${ndfocus.maNguoiDung})"></textarea>
		                <div class="inputs_buttonsend" onclick="sendMessage(${sessionScope.ID}, ${ndfocus.maNguoiDung})">
		                    <i class="fa-regular fa-paper-plane"></i>
		                </div>
		            </div>
			    </c:when>
			    <c:otherwise>
			    	<div class="chatbox_header">
		            	<div class="status_dot" style="display: none;"></div>
		            	<div class="status_name"></div>
		            </div>
		            <hr class="separateline">
		            <div class="chatbox_content" id="chatbox_content">
		            	<div style="display: none;">asfadas</div>
		            </div>
		            <div class="chatbox_inputs">
		                
		            </div>
			    </c:otherwise>
			</c:choose>
        </div>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/message.js"></script>
</html>