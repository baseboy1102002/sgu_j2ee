/**
 * 
 */

function notify(isSuccess, message, handle = () => { }) {
	if (isSuccess) {
		$("#notifyModal").addClass("success-notify");
		$("#notifyModal").modal('show');
		$("#notifyModal .modal-body").html(`<i class='fa-solid fa-circle-check'></i><p>${message}</p>`)
		$("#notifyModal").data("notify-type", "success");
		$("#confirm-notify-btn").off("click").on("click", function() {
			// Gọi hàm handle khi người dùng click nút
			handle();
			$("#notifyModal").modal('hide');
			$('body').removeClass('modal-open');
			$('.modal-backdrop').remove();
		});
	}
	else {
		$("#notifyModal").addClass("fail-notify");
		$("#notifyModal").modal('show');
		$("#notifyModal .modal-body").html(`<i class='fa-solid fa-circle-xmark'></i><p>${message}</p>`)
		$("#notifyModal").data("notify-type", "fail");
		$("#confirm-notify-btn").off("click").on("click", function() {
			// Gọi hàm handle khi người dùng click nút
			handle();
			$("#notifyModal").modal('hide');
			$('body').removeClass('modal-open');
			$('.modal-backdrop').remove();
		});
	}
}

function getParentElement(element, parent) {
	while (element.parentElement) {
		if (element.parentElement.matches(parent)) {
			return element.parentElement;
		}
		element = element.parentElement;
	}
}


/* tắt mở cái more bên phải của bài viết */
function showMore(e) {
	var parentElement = getParentElement(e, ".bai-viet-content-wrapper");
	childMoreHoverElement = $(parentElement).find(".profile-more-hover")
	if ($(childMoreHoverElement).css("visibility") == "hidden") {
		$(childMoreHoverElement).css("visibility", "visible")
	} else {
		$(childMoreHoverElement).css("visibility", "hidden")
	}
}

/*Set lại id của post cho confirm delete và mode detail khi ấn click post btn*/

function onPostDeleteClick(e) {
	var parentElement = getParentElement(e, ".bai-viet-content-wrapper");
	var postId = $(parentElement).data("post-id");
	var isDetailMode = $(parentElement).data("is-detail-mode");
	$("#deletePostConfirm").data("post-id", postId);
	$("#deletePostConfirm").data("is-detail-mode", isDetailMode);

}

/*Xử lí nút react chỗ hover*/
function onReactClick(e) {

	var parentElement = getParentElement(e, ".bai-viet-content-wrapper");
	var baiVietTuongTacId = $(parentElement).data("post-id");

	var userLoginId = $(parentElement).data("user-login");
	var reactValue = $(e).data("react");



	$.ajax({
		url: "/sgu_j2ee/baiviet",
		type: "post", //send it through get method
		data: {
			maBaiViet: baiVietTuongTacId,
			maNguoiDung: userLoginId,
			trangThai: reactValue,
			action: "react"
		},
		success: function(response) {
			var data = JSON.parse(response)
			var top3TuongTac = JSON.parse(data.topTuongTac)
			var reactActionElemen = $(parentElement).find(".react-action-btn");
			var innerReactActionElementHtml = `
					<img alt="" src="/sgu_j2ee/assets/images/${reactValue}.png"> <span class="${reactValue}">${reactValue}</span>`;

			$(reactActionElemen).html(innerReactActionElementHtml);
			if (!$(reactActionElemen).hasClass("active")) {
				$(reactActionElemen).addClass("active")
			}
			$(reactActionElemen).data("active", true)

			var reactDataElement = $(parentElement).find(".react-data");
			var innerReactDataHtml = ``;
			$.each(top3TuongTac, function(index, value) {
				innerReactDataHtml += `<div class="react-data-item">
        <img alt="" src="/sgu_j2ee/assets/images/${value}.png">
    </div>`;
			});
			innerReactDataHtml += `<span>${data.tongLuotTT} </span>`
			reactDataElement.html(innerReactDataHtml)


		},
		error: function(xhr) {
			//Do Something to handle error

		}
	});


};

/*Xử lí khi click vào nút react chỗ không phải hover*/
function handleOnClickReact(e) {
	var parentElement = getParentElement(e, ".bai-viet-content-wrapper");
	var action = ''
	var baiVietTuongTacId = $(parentElement).data("post-id");

	var userLoginId = $(parentElement).data("user-login");
	var reactValue = "like";
	if ($(e).data("active")) {

		action = 'deleteTuongTacBaiViet'
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
		url: "/sgu_j2ee/baiviet",
		type: "post", //send it through get method
		data: {
			maBaiViet: baiVietTuongTacId,
			maNguoiDung: userLoginId,
			trangThai: reactValue,
			action: action
		},
		success: function(response) {
			var data = JSON.parse(response)
			var top3TuongTac = JSON.parse(data.topTuongTac)

			var innerReactActionElementHtml = (action === 'deleteTuongTacBaiViet')
				? '<i class="fa fa-thumbs-up" aria-hidden="true"></i><span>Thích</span>'
				: `<img alt="" src="/sgu_j2ee/assets/images/${reactValue}.png"><span class="${reactValue}">${reactValue}</span>`;
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



/*Xử lí set id cho popup report khi nhấn báo cáo*/
function handleReport(e) {
	var parentElement = getParentElement(e, ".bai-viet-content-wrapper");
	var baiVietId = $(parentElement).data("post-id");
	$("#reportPostPopUp").data("post-id", baiVietId);
	$("#report-post-input").val(null)
	$("#submit-post-report-btn").prop("disabled", true)

}


$(document).ready(function() {

	/*Xử lí khi bấm nút confirm của cái thông báo*/
	/*	$("#confirm-notify-btn").click(function(e) {
			var parentElement = getParentElement(e.target, "#notifyModal");
			var isDetailMode = $(parentElement).data("is-detail-mode")
			var notifyType = $(parentElement).data("notify-type")
			console.log(isDetailMode, " ,  ", notifyType)
			if (isDetailMode && notifyType === "success") {
				history.back();
			}
			else {
				$("#notifyModal").modal('hide');
			}
	
		})*/

	/*xác nhận xóa baiviet */
	$("#delete-baiviet-btn").click(function(e) {
		var parentElement = getParentElement(e.target, "#deletePostConfirm");
		var postID = $(parentElement).data("post-id");
		var isDetailMode = $(parentElement).data("is-detail-mode");
		$.ajax({
			url: "/sgu_j2ee/baiviet",
			type: "post", //send it through get method
			data: {
				maBaiViet: postID,
				action: "delete"
			},
			success: function(response) {
				$("#notifyModal").data("is-detail-mode", isDetailMode);
				//Do Something
				if (response === "true") {

					function handleOnClickSubmit() {
						if (isDetailMode) {
							history.back();
						}

					}
					$("#deletePostConfirm").modal('hide');
					notify(true, "Xóa thành công", handleOnClickSubmit)


					/*khi thành công thì sẽ remove cái bài viết có id đó*/
					$(".bai-viet-content-wrapper[data-post-id=" + postID + "]").remove()
				}
				else {
					$("#deletePostConfirm").modal('hide');
					notify(false, "Xóa thất bại")
				}
			},
			error: function(xhr) {
				//Do Something to handle error
			}
		});
	})

	$("#report-post-input").change(function(e) {
		if (e.target.value) {
			$("#submit-post-report-btn").prop("disabled", false)
		}
		else {
			$("#submit-post-report-btn").prop("disabled", true)
		}
	})


	/*Xác nhận báo cáo*/
	$("#submit-post-report-btn").click(function(e) {
		var reportReason = $("#report-post-input").val();

		if (reportReason) {
			var postId = $("#reportPostPopUp").data("post-id")
			$.ajax({
				url: "/sgu_j2ee/baiviet",
				type: "post", //send it through get method
				data: {
					maBaiViet: postId,
					liDo: reportReason,
					action: "report"
				},
				success: function(response) {
					//Do Something
					$("#reportPostPopUp").modal('hide');
					notify(true, "Hệ thống đã ghi nhận báo cáo")
					$(".bai-viet-content-wrapper[data-post-id=" + postId + "] .profile-right").remove()
				},
				error: function(xhr) {
					//Do Something to handle error
				}
			});
		}
		else {
			notify(false, "Vui lòng nhập lý do báo cáo")
		}
	})


});

