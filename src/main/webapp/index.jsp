<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Post Form Modal</title>
        <link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
        <link rel="stylesheet" href="<c:url value='/fontawesome6/css/all.min.css'/>">
        <link rel="stylesheet" href="<c:url value='/resources/css/post-edit-form.css'/>">
    </head>
    <body>
        <div class="container">
            <!-- Button trigger modal -->
            <button id="btn_add_post" type="button" class="btn btn-primary">
                Thêm bài viết
            </button>
            
            <button id="btn_update_post" type="button" class="btn btn-primary">
                Sửa bài viết
            </button>
            
            <div class="bai-viet-wrapper"></div>

            <!-- Modal -->
            <%@include file="/components/post-edit-form.jsp" %>
        </div>
        <script type="text/javascript">
			let contextPath="${pageContext.request.contextPath}";
		</script>	
        <script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/jquery/jquery-3.7.1.min.js'/>"></script>
        <script src="<c:url value='/resources/js/post-edit-form.js'/>"></script>

    </body>
</html>