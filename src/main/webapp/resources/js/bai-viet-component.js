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
		
		$(e).click(function(){
			var parentElement = getParentElement(e,".bai-viet-content-wrapper");
			childMoreHoverElement = $(parentElement).find(".profile-more-hover")
			if($(childMoreHoverElement).css("visibility") =="hidden"){
				$(childMoreHoverElement).css("visibility","visible")
			}else{
				$(childMoreHoverElement).css("visibility","hidden")
			}
		
			
		})
	});
	
	/*Set id cho pop-up khi nhấn xóa */
	$(".delete-post-btn").each(function(i,e){
		$(e).click(function(){
			var parentElement = getParentElement(e,".bai-viet-content-wrapper");
			$("#exampleModal").data("id",$(parentElement).data("id"))
			
		})
	})
	
	
});




