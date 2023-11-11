var currentPage = 1;

function loadContent(page, userid) {
	var select = document.getElementById('type');
	var selectedValue = select.options[select.selectedIndex].value;

	var searchInput = document.getElementById('search_input');
	var searchInputValue = searchInput.value || "";

	currentPage = page;

	$.ajax({
		url: "/sgu_j2ee/friendload",
		type: "get",
		data: {
			type: selectedValue,
			indexpage: page,
			search: searchInputValue,
			userid: userid
		},
		success: function(response) {
			var content_listfriend = document.getElementById("content_listfriend");
			content_listfriend.innerHTML = response;
		},
		error: function(xhr) {
			alert(xhr);
		}
	});
}

function nextClick(id) {
	var listItems = document.getElementsByClassName("listfriend_item");
	if (listItems.length == 8) {
		currentPage++;
		loadContent(currentPage, id);
	}
}

function prevClick(id) {
	if (currentPage > 1) {
		currentPage--;
		loadContent(currentPage, 1);
	}
}

function handleKeyDown(event, id) {
	if (event.key === "Enter") {
		loadContent(1, id);
	}
}

function autoSelectOption() {
	var selectedValue = document.getElementById("selectedType").value;

	var selectElement = document.getElementById("type");

	for (var i = 0; i < selectElement.options.length; i++) {
		if (selectElement.options[i].value === selectedValue) {
			selectElement.options[i].selected = true;
			break;
		}
	}
}

window.onload = autoSelectOption;