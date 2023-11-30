// $(document).ready(function () {
//     var popperContent = $('#hidden-popper-content').html();
// });


// var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
// var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
//   return new bootstrap.Popover(popoverTriggerEl)
// })

function handleOnClickAddFriend(e) {

	/*	var parentElement = getParentElement(e, ".profile-header-actions");
		
		var currentUser = $(parentElement).data("this-user");
		var type = $(parentElement).data("button-type");*/

	var User = $(e).data("this-user");
	var currentUser = $(e).data("current-user");
	var type = $(e).data("button-type");

	$.ajax({
		url: "/sgu_j2ee/profile",
		method: "POST",
		data: {
			action: "ketban",
			CUID: currentUser,
			UID: User
		},
		success: function(response) {
			setTimeout(function() {
				location.reload();
			});
		},
		error: function(error){
			console.error("Error adding friend:", error);
		}
	});

}

// Attach the function to the click event of the "Xác nhận" button
document.getElementById('submit-user-report-btn').addEventListener('click', logReportUserInput);
function logReportUserInput() {
    // Get the value from the textarea
    var reportUserInputValue = document.getElementById('report-user-input').value;
   	var User = document.getElementById('submit-user-report-btn').getAttribute('data-this-user');
    var currentUser = document.getElementById('submit-user-report-btn').getAttribute('data-current-user');
    $.ajax({
		url: "/sgu_j2ee/profile",
		method: "POST",
		data: {
			action: "baocao",
			CUID: currentUser,
			UID: User,
			NoiDung: reportUserInputValue
		},
		success: function(response) {
			
		},
		error: function(error){
			console.error("Error adding baocaonguoidung:", error);
		}
	});
    
   
	$("#reportUserPopUp").modal('hide');
    // Log the value to the console
    notify(true, "Hệ thống đã ghi nhận báo cáo")

}

