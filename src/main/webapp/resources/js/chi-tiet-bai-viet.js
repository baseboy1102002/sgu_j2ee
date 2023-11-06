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

	$("#comment-delete-file").click(function() {
		$("#imageCommentFile").val('');
		$("#comment-show-img").attr("src", null);
		$("#comment-image-attach").css("display", "none");
		$("#comment-file-name").text("");
	})

	/* tắt mở cái more bên phải của comment */
	$(".comment-record-title-right").each(function(i, e) {

		$(e).click(function() {
			var parentElement = getParentElement(e, ".comment-record-item");
			childMoreHoverElement = $(parentElement).find(".comment-more-hover")
			if ($(childMoreHoverElement).css("visibility") == "hidden") {
				$(childMoreHoverElement).css("visibility", "visible")
			} else {
				$(childMoreHoverElement).css("visibility", "hidden")
			}


		})
	});


	/*Set id cho pop-up khi nhấn xóa */
	$(".delete-comment-btn").each(function(i, e) {
		$(e).click(function() {
			var parentElement = getParentElement(e, ".comment-record-item");
			$("#deleteCommentConfirm").data("id", $(parentElement).data("id"))

		})
	})

	/*Xử lí khi chọn edit comment */
	$(".edit-comment-btn").each(function(i, e) {
		$(e).click(function() {
			var parentElement = getParentElement(e, ".comment-record-item");
			$("#updateCommentPopup").data("id", $(parentElement).data("id"))
			var commentText = $(parentElement).find(".comment-record-content p").text();
			var imageSrc = $(parentElement).find(".comment-record-img").attr("src")
			$("#comment-edit-input").text(commentText)
			$(".comment-pop-up-body .img-wrapper img").attr("src", imageSrc)

		})
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

});