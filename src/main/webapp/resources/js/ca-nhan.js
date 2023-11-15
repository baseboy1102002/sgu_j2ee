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

	console.log(User + " " + type + " " + currentUser);

	$.ajax({
		url: "/sgu_j2ee/profile",
		method: "POST",
		data: {
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