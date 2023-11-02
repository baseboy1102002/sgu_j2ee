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
	<div class="container d-flex flex-column container ">
		<div>Header</div>

		<div class="d-flex content ">
			<jsp:include page="../components/bai-viet-component.jsp"></jsp:include>

		</div>

	



	</div>

	<script type="text/javascript"
		src="<c:url value='/bootstrap/js/bootstrap.bundle.min.js' />"></script>

	<script type="text/javascript"
		src="<c:url value='/fontawesome6/js/all.min.js' />"></script>



</body>
</html>