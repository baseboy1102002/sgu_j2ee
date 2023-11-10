<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/globalstyle.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/ca-nhan.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.css' />">

<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div class="profile-page">
		<div
			class="profile-header-container container row justify-content-around p-4">
			<div class="profile-placeholder col-3"></div>
			<div
				class="profile-header-user col-4 d-flex flex-wrap justify-content-center flex-column">
				<div
					class="profile-header-avatar d-flex justify-content-center mb-3">
					<img src="./108410800_p0.png" alt="" />
				</div>
				<p class="h4 text-center">Tên Người Dùng</p>
			</div>
			<div class="profile-header-actions col-4 d-flex align-items-end">
				<button type="button" class="button-addfriend btn btn-primary col-6">
					Kết bạn</button>
				<button type="button" class="button-message btn btn-primary col-6">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-chat-dots-fill"
						viewBox="0 0 16 16">
                        <path
							d="M16 8c0 3.866-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.584.296-1.925.864-4.181 1.234-.2.032-.352-.176-.273-.362.354-.836.674-1.95.77-2.966C.744 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7zM5 8a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm4 0a1 1 0 1 0-2 0 1 1 0 0 0 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" />
                    </svg>
					Nhắn tin
				</button>
			</div>
		</div>
		<div class="profile-content-container">
			<div
				class="profile-content-wrapper container flex-row d-flex justify-content-between p-0">
				<div class="profile-content-left container col-3 m-0 p-0">
					<div
						class="profile-introduction d-flex justify-content-center flex-wrap flex-column p-4">
						<span class="fw-bold text-center">Giới thiệu</span> <span>placeholdermail@email.com</span>
						<span>0999999999</span> <span>Có 32 người bạn</span>
					</div>
				</div>
				<div
					class="profile-content-right container col ms-4 p-4 d-flex flex-wrap flex-column">
					<div
						class="profile-create-post d-flex flex-column justify-content-end flex-wrap col m-4">
						<div class="profile-post-posting mb-3 col">
							<label for="labelPosting"
								class="profile-post-label form-label fs-3 mb-4">Tạo bài viết</label>
							<textarea class="form-control" id="labelPosting" rows="3"></textarea>
						</div>
						<div class="profile-post-button col d-flex justify-content-end">
							<button class="btn btn-primary fs-3 pt-2 pb-2 ps-4 pe-4">
								Đăng bài</button>
						</div>
					</div>
					<div class="profile-posts col mt-5">
						<!-- <div class="profile-post-container">
                            <div class="profile-post-header"></div>
                            <div class="profile-post-content">
                                <div class="post-content-image contanier row">
                                    <img class="img-fluid col-6" src="./image/1161810.jpg" alt="" />
                                    <img class="img-fluid col-6" src="./image/1161810.jpg" alt="" />
                                </div>
                                <div class="post-content-image contanier row">
                                    <img class="img-fluid col-6" src="./image/1161810.jpg" alt="" />
                                    <img class="img-fluid col-6" src="./image/1161810.jpg" alt="" />
                                </div>


                                <div class="post-content-description mt-5">
                                    <span>Lorem, ipsum dolor sit amet consectetur adipisicing elit.
                                        Deserunt odit, asperiores sunt, at, enim quis quae atque
                                        eligendi rerum perferendis vero? Hic, enim cumque
                                        cupiditate nihil earum explicabo sint non?Lorem, ipsum
                                        dolor sit amet consectetur adipisicing elit. Deserunt
                                        odit, asperiores sunt, at, enim quis quae atque eligendi
                                        rerum perferendis vero? Hic, enim cumque cupiditate nihil
                                        earum explicabo sint non?</span>
                                </div>
                            </div>
                            <div class="profile-post-actions d-flex">
                                <div class="profile-post-interaction mt-5">
                                    <button type="button" class="btn btn-secondary" data-bs-container="body"
                                        data-bs-toggle="popover" data-bs-placement="top" data-bs-html="true">
                                        Popover on top
                                    </button>
                                </div>
                                <div class="profile-post-commenting"></div>
                            </div>
                            <div class="profile-post-comments"></div>
                        </div> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/jquery/jquery-3.7.1.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.bundle.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/ca-nhan.js' />"></script>
</body>
</html>