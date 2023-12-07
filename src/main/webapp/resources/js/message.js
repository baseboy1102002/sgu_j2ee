const listItems = document.querySelectorAll('.sidebar_listfriend_item');
let manguoiguiGlobal;
let manguoinhanGlobal;

listItems.forEach(item => {
	item.addEventListener('click', () => {
		listItems.forEach(item => {
			item.classList.remove('sidebar_listfriend_item_active');
		});
		item.classList.add('sidebar_listfriend_item_active');
	});
});

document.addEventListener("DOMContentLoaded", function() {
	const statusDot = document.querySelector(".status_dot");
	const statusName = document.querySelector(".status_name");

	const trangThai = statusName.textContent.trim();

	if (trangThai === "offline") {
		statusDot.style.backgroundColor = "gray";
	} else if (trangThai === "online") {
		statusDot.style.backgroundColor = "var(--darker-primary-color)";
	} else if (trangThai === "systembanned") {
		statusDot.style.backgroundColor = "red";
	} else {
		statusDot.style.backgroundColor = "#ffcf61";
	}

	var chatboxContent = document.querySelector('.chatbox_content');
	chatboxContent.scrollTop = chatboxContent.scrollHeight;
});

function loadNewUser(id1, id2) {
	$.ajax({
		url: "/sgu_j2ee/messload",
		type: "get",
		data: {
			userid1: id1,
			userid2: id2,
			type: 'loadall'
		},
		success: function(response) {
			var chatbox = document.getElementById("chatbox");
			chatbox.innerHTML = response;
			manguoiguiGlobal = id1;
			manguoinhanGlobal = id2;
			loadNewMessAutomatic();
			setInterval(loadNewMessAutomatic, 1000);
			scrollToBottom();
		},
		error: function(xhr) {
			alert(xhr);
		}
	});
}

function loadNewMess(id1, id2) {
	$.ajax({
		url: "/sgu_j2ee/messload",
		type: "get",
		data: {
			userid1: id1,
			userid2: id2,
			type: 'loadmess'
		},
		success: function(response) {
            var chatbox_content = document.querySelector('.chatbox_content');
            var isScrollBarAtBottom = isScrollbarAtBottom(chatbox_content);

            chatbox_content.innerHTML = response;

            if (isScrollBarAtBottom) {
                scrollToBottom();
            }
        },
		error: function(xhr) {
			alert(xhr);
		}
	});
}

function isScrollbarAtBottom(element, tolerance = 5) {
    return element.scrollHeight - (element.scrollTop + element.clientHeight) <= tolerance;
}


function scrollToBottom() {
    var chatboxContent = document.querySelector('.chatbox_content');
    chatboxContent.scrollTop = chatboxContent.scrollHeight;
}

function checkEnterKey(event, manguoigui, manguoinhan) {
	if (event.key === "Enter" && !event.shiftKey) {
		sendMessage(manguoigui, manguoinhan);
		event.preventDefault();
	}
}

function sendMessage(manguoigui, manguoinhan) {
	var noidung = document.getElementById('inputs_text').value;

	if (noidung.trim() === '') {
		return;
	}

	$.ajax({
		url: "/sgu_j2ee/mess",
		type: "post",
		data: {
			manguoigui: manguoigui,
			manguoinhan: manguoinhan,
			noidung: noidung
		},
		success: function() {
		},
		error: function(xhr) {
			alert(xhr);
		}
	});

	loadNewMess(manguoigui, manguoinhan);
	scrollToBottom();
	$('#inputs_text').val('').focus();
}

function loadNewMessAutomatic() {
	loadNewMess(manguoiguiGlobal, manguoinhanGlobal);
}
