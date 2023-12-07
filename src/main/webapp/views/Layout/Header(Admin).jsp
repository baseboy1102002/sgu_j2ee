<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<header class="header__admin ">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-4">
					<div class="header__logo">
						<a href="/sgu_j2ee/views/Home_Admin.jsp"> <img
							src="${pageContext.request.contextPath}/assets/images/logo_admin.png"
							alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-7 col-8">
					
				</div>
				<div class="col-lg-2 col-12">
					<div class="header__right d-flex justify-content-between">
						<!-- Friends -->
						<div class="direct">
							<a href="/sgu_j2ee/views/Home_Admin.jsp"
								class="icon_group_circle"> <i class="fa fa-home"
								aria-hidden="true"></i>
							</a>
						</div>


						<!-- Chat -->
						<div class="direct">
							<a href="/sgu_j2ee/dang-xuat"
								class="icon_group_circle"> <i class="fa fa-sign-out"
								aria-hidden="true"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>