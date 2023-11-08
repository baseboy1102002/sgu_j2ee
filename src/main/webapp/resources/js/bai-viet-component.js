/**
 * 
 */

function getParentElement(element, parent) {
	while (element.parentElement) {
		if (element.parentElement.matches(parent)) {
			return element.parentElement;
		}
		element = element.parentElement;
	}
}


var profileRightElement = document.getElementsByClassName("profile-right")[0];

function showDiv(divClassName) {
	var x = document.getElementsByClassName(divClassName)[0];
	if (x.style.visibility == "visible") {
		x.style.visibility = "hidden";
	} else {
		x.style.visibility = "visible";
	}
}


$(document).ready(function() {

	/* tắt mở cái more bên phải */
	$(".profile-right").each(function(i, e) {

		$(e).click(function() {
			var parentElement = getParentElement(e, ".bai-viet-content-wrapper");
			childMoreHoverElement = $(parentElement).find(".profile-more-hover")
			if ($(childMoreHoverElement).css("visibility") == "hidden") {
				$(childMoreHoverElement).css("visibility", "visible")
			} else {
				$(childMoreHoverElement).css("visibility", "hidden")
			}


		})
	});

	/*Set id cho pop-up khi nhấn xóa */
	$(".delete-post-btn").each(function(i, e) {
		$(e).click(function() {
			var parentElement = getParentElement(e, ".bai-viet-content-wrapper");
			$("#exampleModal").data("id", $(parentElement).data("id"))

		})
	})

	$("#confirm-notify-btn").click(function(e){
		var parentElement = getParentElement(e.target, "#notifyModal");
		var isDetailMode = $(parentElement).data("is-detail-mode")
		var notifyType = $(parentElement).data("notify-type")
		
		if(isDetailMode && notifyType === "success"){
			history.back();
		}
		else{
			$("#notifyModal").modal('hide');
		}

	})


	/*Xóa baiviet */
	$("#delete-baiviet-btn").click(function(e) {
		var parentElement = getParentElement(e.target, "#exampleModal");

		$.ajax({
			url: "/sgu_j2ee/baiviet",
			type: "post", //send it through get method
			data: {
				maBaiViet : $(parentElement).data("id-bai-viet"),
				action : "delete"
			},
			success: function(response) {
				$("#notifyModal").data("is-detailmode",$(parentElement).data("is-detail-mode"));
				//Do Something
				if(response === "true"){
					$("#notifyModal").addClass("success-notify");
					$("#exampleModal").modal('hide');
					$("#notifyModal").modal('show');
					$("#notifyModal .modal-body").html("<i class='fa-solid fa-circle-check'></i><p>Xóa thành công</p>")
					$("#notifyModal").data("notify-type","success");
					
				}
				else{
					$("#notifyModal").addClass("fail-notify");
					$("#exampleModal").modal('hide');
					$("#notifyModal").modal('show');
					$("#notifyModal .modal-body").html("<i class='fa-solid fa-circle-xmark'></i><p>Xóa thất bại. Vui lòng thử lại!!!</p>")
					$("#notifyModal").data("notify-type","fail");
				}
			},
			error: function(xhr) {
				//Do Something to handle error
			}
		});
	})
});




