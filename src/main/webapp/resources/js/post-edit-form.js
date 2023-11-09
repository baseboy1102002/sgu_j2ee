$(document).ready(function () {
    $('#btn_file').click(function (e) { 
        $('#input_file').click()
    })
    $('#btn_image').click(function (e) { 
        $('#input_image').click()
    })

    $('#btn_add_post').click(function (e) {
        $.ajax({
            method: "post",
            url: contextPath+"/api/post",
            data: {NoiDung: ""},
            success: function (response) {
                const postId = response
                $('#modal_post').data('type', 'create')
                $('#modal_post').data('post-id', postId)
                $('#modal_post .modal_title').text("Thêm bài viết mới")
                $('#modal_post').modal('show')
            }
        })
    })
});

$('#input_image').on('change', function () {
	let img_file = $(this).prop('files')[0]
	let formData = new FormData()
	const postId = $('#modal_post').data('post-id')
	formData.append('img_file', img_file)
	formData.append('postId', postId)
   $.ajax({
	    method: "post",
	    url: contextPath+"/api/post_file",
	    data: formData,
	    processData: false,
	    contentType: false,
	    enctype: 'multipart/form-data', 
	    success: function (response) {
	        let imgDiv = `<div class="col-4 img-wrapper" data-post-image-id="${response.file_id}">
	                        <img src="/sgu_j2ee/files/${response.file_name}">
	                        <div class="img-overlay"></div>
	                        <div class="img-btn fadeIn-top">
	                            <button class="btn btn-sm btn-primary post_image_delete">Hủy</button>
	                        </div>
	                	</div>`
	        $('#post_image .row').append(imgDiv)
	        $(`div[data-post-image-id="${response.file_id}"] .post_image_delete`).click( () => {
				delete_post_image(`${response.file_id}`)
			})
	    }
   })
});

function delete_post_image(post_image_id) {
	console.log(post_image_id)
	$.ajax({
	    method: "delete",
	    url: contextPath+"/api/post_file?" + $.param({MaFile: post_image_id}),
	    success: function (response) {
			console.log(response)
	        $(`div[data-post-image-id="${post_image_id}"]`).remove()
	    }
   })
}

$('#modal_post_close_btn').click(function (e) {
	if ($('#modal_post').data('type') === 'create') {
		const postId = $('#modal_post').data('post-id')
		$.ajax({
		    method: "delete",
		    url: contextPath+"/api/post?" + $.param({MaBaiViet: postId}),
		    success: function (response) {
				console.log(response)
		        clear_post_modal()
		        $('#modal_post').modal('hide')
		    }
   		})
	} else {
		$('#modal_post').modal('hide')
	}
})

function clear_post_modal() {
	$('#post_image .row').empty()
	$('#post_file').empty()
}

$('#modal_post_save_btn').click(function (e) {
	const postId = $('#modal_post').data('post-id')
	$.ajax({
	    method: "put",
	    url: contextPath+"/api/post?" + $.param({MaBaiViet: postId}),
	    data: $('#post_text').val(),
	    success: function (response) {
			console.log(response)
	        $('#modal_post').modal('hide')
	        setTimeout(() => window.location.reload(), 2000);
	    }
	})
})
