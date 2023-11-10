/**
 * 
 */


$(document).ready(function() {

	/*Xử lí input comment */
	$("#comment-input").keyup(function(e) {
		if (e.target.value) {
			$("#comment-icon").css("color", "black");
			$("#submit-comment-btn").css("color", "black");
			$("#submit-comment-btn").prop('disabled', false)
		}
		else {
			$("#comment-icon").css("color", "#dedede");
			$("#submit-comment-btn").css("color", "#dedede");
			$("#submit-comment-btn").prop('disabled', true)
		}

	})

	/*Xử lí file image comment */

	$("#imageCommentFile").change(function(e) {
		var tmppath = URL.createObjectURL(e.target.files[0]);
		$("#comment-show-img").attr("src", tmppath);
		$("#comment-image-attach").css("display", "flex");
		$("#comment-file-name").text(e.target.files[0].name);

	})


	/*Xử lí khi xóa image chỗ popup*/
	$("#comment-delete-file").click(function() {
		$("#imageCommentFile").val('');
		$("#comment-show-img").attr("src", null);
		$("#comment-image-attach").css("display", "none");
		$("#comment-file-name").text("");
	})

	/*Xử lí submit comment*/
	$("#submit-comment-btn").click(function(e) {
		var commentInput = $("#comment-input").val();

		if (commentInput) {
			let img_file = $("#imageCommentFile").prop('files')[0];
			let parentElement = getParentElement(e.target, ".comment-wrapper");
			let postId = $(parentElement).data("post-id");


			const formData = new FormData();
			formData.append('noiDung', commentInput);
			formData.append('anhBinhLuan', img_file);
			formData.append('maBaiViet', postId);
			formData.append('action', 'addBinhLuan');

			$.ajax({
				url: contextPath + "/chitietbaiviet",
				method: "post", //send it through get method
				data: formData,
				processData: false,
				contentType: false,
				enctype: 'multipart/form-data',
				beforeSend: function() {

					$("#comment-delete-file").trigger('click')
					$("#loadingModal").modal('show')
				},
				success: function(response) {

					var newRecordHTML = `<div class="comment-record-item" data-id=${response.maBinhLuan}>`;
					if (response.anhDaiDienNguoiDang === '') {
						newRecordHTML += `<img class="comment-record-profile-img"
									src="/sgu_j2ee/assets/images/defaultProfileImage.png" />`
					} else {
						newRecordHTML += `<img class="comment-record-profile-img"
									src="/sgu_j2ee/files/${response.anhDaiDienNguoiDang}" />`
					}
					newRecordHTML += `<div class="comment-record-right">
								<div class="comment-record-content">
									<div class="comment-record-title">
										<div class="comment-record-title-content">
											<h5>${response.hoVaTenNguoiDang}</h5>
											<span> ${response.ngayGioBinhLuan} </span>
										</div>
										<div class="comment-record-title-right" onclick="handleShowMore(this)">
											<i class="fa fa-ellipsis-h"></i>
											<div class="comment-more-hover">

												<button type="button" class="btn edit-comment-btn  "
													data-bs-toggle="modal" data-bs-target="#updateCommentPopup" onclick="handleClickEditComment(this)">
													<i class="fa fa-cog" aria-hidden="true"></i><span>
														Chỉnh sửa </span>
												</button>
												<button type="button" class="btn delete-comment-btn "
													data-bs-toggle="modal"
													data-bs-target="#deleteCommentConfirm"
													onclick="handleSetId(this)"
												>
													<i class="fa fa-trash" aria-hidden="true"></i> <span>
														Xóa </span>
												</button>
											</div>

										</div>
									</div>
									<p>${commentInput}</p>
									<div class="comment-record-react">
										<div class="react-data">
										<span></span>
										</div>
										<button class="comment-record-react-action">
											<div
												class=" comment-record-react-action-btn"
												data - active=${false} onclick="handleOnClickReactComment(this)" >
													<i class="fa fa-thumbs-up" aria-hidden="true"></i>
													<span>Thích</span>

											</div >
				<div class="comment-record-more-action">
												<div class="comment-record-react-item" data-trang-thai="like" onclick="reactHoverComment(this)">
													<img alt="" src="/sgu_j2ee/assets/images/like.png">
												</div>
												<div class="comment-record-react-item" data-trang-thai="heart" onclick="reactHoverComment(this)">
													<img alt="" src="/sgu_j2ee/assets/images/heart.png">
												</div>
												<div class="comment-record-react-item" data-trang-thai="sad" onclick="reactHoverComment(this)">
													<img alt="" src="/sgu_j2ee/assets/images/sad.png">
												</div>
												<div class="comment-record-react-item" data-trang-thai="haha" onclick="reactHoverComment(this)">
													<img alt="" src="/sgu_j2ee/assets/images/haha.png">
												</div>
												<div class="comment-record-react-item" data-trang-thai="mad" onclick="reactHoverComment(this)">
													<img alt="" src="/sgu_j2ee/assets/images/mad.png">
												</div>
											</div>
										</button >
									</div >
								</div >
				`
					if (response.anhBinhLuan !== '') {
						newRecordHTML += `<img class= "comment-record-img"
						src="/sgu_j2ee/files/${response.anhBinhLuan}" />`

					}

					newRecordHTML += `</div>`;
					$("#comment-record-wrapper").prepend(newRecordHTML);
					$("#comment-input").val('');
					$("#loadingModal").modal('hide')
				},
				error: function(xhr) {
					$("#loadingModal").modal('hide')
					//Do Something to handle error

				}
			});

		}

		else {
			notify(false, "Vui lòng nhập ô comment");
		}
	})



	/*Xử lí edit comment*/

	$("#submit-edit-comment-btn").click(function(e) {
		var parentElement = getParentElement(e.target, "#updateCommentPopup");



		var commentInput = $(parentElement).find("#comment-edit-input").val();

		if (commentInput !== '') {

			var imageFile = $("#editImageCommentFile").prop('files')[0];
			var imgSrc = $("#updateCommentPopup .comment-pop-up-body .img-wrapper img").attr("src");
			var commentId = $(parentElement).data("id");
			var formData = new FormData();

			formData.append("maBinhLuan", commentId)
			formData.append("anhBinhLuan", imageFile)
			formData.append("noiDung", commentInput)
			formData.append("imgSrc", imgSrc)
			formData.append("action", "editBinhLuan")

			$.ajax({
				url: contextPath + "/chitietbaiviet",
				method: "post", //send it through get method
				data: formData,
				processData: false,
				contentType: false,
				enctype: 'multipart/form-data',
				beforeSend: function() {
					console.log(imgSrc)
					$(parentElement).find(".dismiss-btn").trigger("click")
				},
				success: function(response) {
					console.log("response", response)
					var editCommentRecord = $(".comment-record-item[data-id=" + commentId + "]");

					$(editCommentRecord).find(".comment-record-content p").text(commentInput)
					$(editCommentRecord).find(".comment-record-title-content span").text(response.ngayGioBinhLuan);
					if (response.anhBinhLuan) {
						$(editCommentRecord).find("img.comment-record-img").attr("src", "/sgu_j2ee/files/" + response.anhBinhLuan);
					}
					else {
						$(editCommentRecord).find("img.comment-record-img").attr("src", "");
					}

				},
				error: function(xhr) {
					//Do Something to handle error

				}
			});
		}
		else {
			$(parentElement).find(".dismiss-btn").trigger("click")
			notify(false, "vui lòng nhập comment")
		}


	})


	/*Xử lí đính kèm file */
	$("#editImageCommentFile").change(function(e) {
		var tmppath = URL.createObjectURL(e.target.files[0]);
		$(".comment-pop-up-body .img-wrapper img").attr("src", tmppath);
	})


	/*Xử lí xóa hình ảnh của edit comment */
	$(".comment-pop-up-body .fadeIn-top button").click(function() {
		$("#editImageCommentFile").val("")
		$(".comment-pop-up-body .img-wrapper img").attr("src", '');

	})

	/*Xử lí xóa comment*/
	$("#delete-comment-btn").click(function(e) {
		var parentElement = getParentElement(e.target, "#deleteCommentConfirm");
		var maBinhLuan = $(parentElement).data("id");
		$.ajax({
			url: "/sgu_j2ee/chitietbaiviet",
			type: "post", //send it through get method
			data: {
				maBinhLuan: maBinhLuan,
				action: "deleteComment"
			},
			success: function(response) {
				//Do Something
				if (response === "true") {


					$("#deleteCommentConfirm").modal('hide');
					notify(true, "Xóa thành công")


					/*khi thành công thì sẽ remove cái bình luận có id đó*/
					$(".comment-record-item[data-id=" + maBinhLuan + "]").remove()
				}
				else {
					$("#deleteCommentConfirm").modal('hide');
					notify(false, "Xóa thất bại")
				}
			},
			error: function(xhr) {
				//Do Something to handle error
			}
		});
	})

});
/* tắt mở cái more bên phải của comment */
function handleShowMore(e) {
	var parentElement = getParentElement(e, ".comment-record-item");
	childMoreHoverElement = $(parentElement).find(".comment-more-hover")
	if ($(childMoreHoverElement).css("visibility") == "hidden") {
		$(".comment-more-hover").css("visibility", "hidden");
		$(childMoreHoverElement).css("visibility", "visible")
	} else {
		$(childMoreHoverElement).css("visibility", "hidden")
	}
}


/*Xử lí khi chọn edit comment */
function handleClickEditComment(e) {
	var parentElement = getParentElement(e, ".comment-record-item");
	$("#updateCommentPopup").data("id", $(parentElement).data("id"))
	var commentText = $(parentElement).find(".comment-record-content p").text();
	var imageSrc = $(parentElement).find(".comment-record-img").attr("src") || "";



	$("#comment-edit-input").text(commentText)
	$("#updateCommentPopup .comment-pop-up-body .img-wrapper img").attr("src", imageSrc)

}


/*Set id cho pop-up khi nhấn xóa */
function handleSetId(e) {
	var parentElement = getParentElement(e, ".comment-record-item");
	$("#deleteCommentConfirm").data("id", $(parentElement).data("id"))
}

/*Xử lí react chỗ hover*/
function reactHoverComment(e) {
	var parentElement = getParentElement(e, ".comment-record-item");
	var trangThaiValue = $(e).data("trang-thai")
	var maBinhLuan = $(parentElement).data("id")

	$.ajax({
		url: "/sgu_j2ee/chitietbaiviet",
		type: "post", //send it through get method
		data: {
			maBinhLuan: maBinhLuan,

			trangThai: trangThaiValue,
			action: 'react'
		},
		success: function(response) {
			var data = JSON.parse(response)
			var top3TuongTac = JSON.parse(data.topTuongTac)


			var reactActionElemen = $(parentElement).find(".comment-record-react-action-btn");
			var innerReactActionElementHtml = `
					<img alt="" src="/sgu_j2ee/assets/images/${trangThaiValue}.png"> <span class="${trangThaiValue}">${trangThaiValue}</span>`;

			$(reactActionElemen).html(innerReactActionElementHtml);
			if (!$(reactActionElemen).hasClass("active")) {
				$(reactActionElemen).addClass("active")
			}
			$(reactActionElemen).data("active", true)
			var innerReactDataHtml = ``;
			$.each(top3TuongTac, function(index, value) {
				innerReactDataHtml += `<div class="react-data-item">
        <img alt="" src="/sgu_j2ee/assets/images/${value}.png">
    </div>`;
			});
			innerReactDataHtml += `<span>${data.tongLuotTT} </span>`

			var reactDataElement = $(parentElement).find(".react-data");
			reactDataElement.html(innerReactDataHtml)
		},
		error: function(xhr) {
			//Do Something to handle error

		}
	});
}


/*Xử lí react chỗ button bên ngoài*/
function handleOnClickReactComment(e) {
	var action = ''
	var parentElement = getParentElement(e, ".comment-record-item");
	var maBinhLuan = $(parentElement).data("id")
	var trangThaiValue = "like";

	if ($(e).data("active")) {

		action = 'deleteTuongBinhLuan'
		$(e).data("active", false)
		if ($(e).hasClass("active")) {
			$(e).removeClass("active")
		}
	}
	else {
		action = 'react';
		$(e).data("active", true)
		if (!$(e).hasClass("active")) {
			$(e).addClass("active")
		}
	}
	$.ajax({
		url: "/sgu_j2ee/chitietbaiviet",
		type: "post", //send it through get method
		data: {
			maBinhLuan: maBinhLuan,
			trangThai: trangThaiValue,
			action: action
		},
		success: function(response) {
			var data = JSON.parse(response)
			var top3TuongTac = JSON.parse(data.topTuongTac)

			var innerReactActionElementHtml = (action === 'deleteTuongBinhLuan')
				? '<i class="fa fa-thumbs-up" aria-hidden="true"></i><span>Thích</span>'
				: `<img alt="" src="/sgu_j2ee/assets/images/${trangThaiValue}.png"><span class="${trangThaiValue}">${trangThaiValue}</span>`;
			$(e).html(innerReactActionElementHtml);


			var reactDataElement = $(parentElement).find(".react-data");
			var innerReactDataHtml = ``;
			$.each(top3TuongTac, function(index, value) {
				innerReactDataHtml += `<div class="react-data-item">
        <img alt="" src="/sgu_j2ee/assets/images/${value}.png">
    </div>`;
			});

			innerReactDataHtml += data.tongLuotTT > 0 ? `<span>${data.tongLuotTT}</span>` : '';

			reactDataElement.html(innerReactDataHtml)
		},
		error: function(xhr) {
			//Do Something to handle error

		}
	});
}
