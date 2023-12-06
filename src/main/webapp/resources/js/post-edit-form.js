function getParentElement(element, parent) {
    while (element.parentElement) {
        if (element.parentElement.matches(parent)) {
            return element.parentElement;
        }
        element = element.parentElement;
    }
}

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
                $('#modal_post .modal-title').text("Thêm bài viết mới")
                $('#modal_post').modal('show')
            }
        })
    })
});

function editPost(e) {
			let parentDiv = getParentElement(e, '.bai-viet-content-wrapper')
			console.log(parentDiv)
			let postId = $(parentDiv).data('post-id')
			$.ajax({
	            method: "get",
	            url: contextPath+"/api/post?" + $.param({MaBaiViet: postId}),
	            success: function (response) {
	                const postId = response.baiViet.maBaiViet
	                $('#modal_post').data('type', 'update')
	                $('#modal_post').data('post-id', postId)
	                $('#modal_post .modal-title').text("Cập nhật bài viết")
	                $('#modal_post #post_text').val(response.baiViet.noiDung)
	                $.each(response.fileHinhAnhs, function (i, v) { 
     					let imgDiv = `<div class="col-4 img-wrapper" data-post-file-id="${v.maFile}" data-file-name="${v.tenFile}" data-file-delete-status="false">
	                        <img src="/sgu_j2ee/files/${v.tenFile}">
	                        <div class="img-overlay"></div>
	                        <div class="img-btn fadeIn-top">
	                            <button class="btn btn-sm btn-primary post_image_delete">Hủy</button>
	                        </div>
	                	</div>`
	                	$('#post_image .row').append(imgDiv)
	                	$(`div[data-post-file-id="${v.maFile}"] .post_image_delete`).click( () => {
							delete_post_file(`${v.maFile}`)
						})
					})
					$.each(response.fileDinhKems, function (i, v) { 
     					let fileDiv = `
	                        <div class="col-6"  data-post-file-id="${v.maFile}" data-file-name="${v.tenFile}" data-file-delete-status="false">
                                <div class="p-2 d-flex justify-content-between align-items-center">
                                    <a class="flex-grow-1 p-2" href="/sgu_j2ee/files/${v.tenFile}">
                                        <span class="badge rounded-pill">${v.loaiFile}</span>
                                        ${v.tenFile}
                                    </a>
                                	<span class="post_file_delete"><i class="fa-regular fa-circle-xmark"></i></span>	                                
                                </div>
                            </div>
     					`
	                	$('#post_file .row').append(fileDiv)
	                	$(`div[data-post-file-id="${v.maFile}"] .post_file_delete`).click( () => {
							delete_post_file(`${v.maFile}`)
						})
					})
	                $('#modal_post').modal('show')
	            }
        	})
	}

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
	        let imgDiv = `<div class="col-4 img-wrapper" data-post-file-id="${response.file_id}" data-file-name="${response.file_name}" data-file-delete-status="false">
	                        <img src="/sgu_j2ee/files/${response.file_name}">
	                        <div class="img-overlay"></div>
	                        <div class="img-btn fadeIn-top">
	                            <button class="btn btn-sm btn-primary post_image_delete">Hủy</button>
	                        </div>
	                	</div>`
	        $('#post_image .row').append(imgDiv)
	        $(`div[data-post-file-id="${response.file_id}"] .post_image_delete`).click( () => {
				delete_post_file(`${response.file_id}`)
			})
	    }
   })
});

$('#input_file').on('change', function () {
	let file = $(this).prop('files')[0]
	let formData = new FormData()
	const postId = $('#modal_post').data('post-id')
	formData.append('file', file)
	formData.append('postId', postId)
   $.ajax({
	    method: "post",
	    url: contextPath+"/api/post_file",
	    data: formData,
	    processData: false,
	    contentType: false,
	    enctype: 'multipart/form-data',
	    success: function (response) {
	        let fileDiv = `
     						<div class="col-6"  data-post-file-id="${response.file_id}" data-file-name="${response.file_name}" data-file-delete-status="false">
                                <div class="p-2 d-flex justify-content-between align-items-center">
                                    <a class="flex-grow-1 p-2" href="/sgu_j2ee/files/${response.file_name}">
                                        <span class="badge rounded-pill">${response.file_extension}</span>
                                        ${response.file_name}
                                    </a>
                                	<span class="post_file_delete"><i class="fa-regular fa-circle-xmark"></i></span>	                                
                                </div>
                            </div>
     					`
        	$('#post_file .row').append(fileDiv)
        	$(`div[data-post-file-id="${response.file_id}"] .post_file_delete`).click( () => {
				delete_post_file(`${response.file_id}`)
			})
	    }
   })
});


function delete_post_file(post_file_id) {
	$(`div[data-post-file-id="${post_file_id}"]`).attr('data-file-delete-status', 'true')
    $(`div[data-post-file-id="${post_file_id}"]`).hide()
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
		clear_post_modal()
	}
})

function clear_post_modal() {
	$('#post_image .row').empty()
	$('#post_file').empty()
	$('#post_text').val('')
}

$('#modal_post_save_btn').click(function (e) {
	const postId = $('#modal_post').data('post-id')
	let data = {noi_dung: $('#post_text').val(), file_id: [], file_names:[]}
	$(`div[data-file-delete-status="true"]`).each(function (index, element) {
		let file_id = $(this).data('post-file-id')
		let file_name = $(this).data('file-name')
		data.file_names.push(file_name)
		data.file_id.push(file_id)
	})
	$.ajax({
	    method: "put",
	    url: contextPath+"/api/post?" + $.param({MaBaiViet: postId}),
	    data: JSON.stringify(data),
	    contentType: "application/json",
	    success: function (response) {
			if ($('#modal_post').data('type') === 'create') {
				appendBaiViet(response)				
		        $('#modal_post').modal('hide')
		        clear_post_modal()
			} else {
				if ($(`div[data-post-id="${postId}"]`).data('is-detail-mode') === true) {
					$('#carouselExampleIndicators .carousel-indicators').empty()
					$('#carouselExampleIndicators .carousel-inner').empty()
					$.each(response.fileHinhAnhs, function (i, v) { 
						let buttonDiv = `
						    <button type="button" data-bs-target="#carouselExampleIndicators"
						            data-bs-slide-to="${i}"
						            ${i === 0 ? 'class="active" aria-current="true"' : ''}
						            aria-label="${i + 1}"></button>
						`
						let imgSlideDiv = `
							<div class='carousel-item  w-100 h-100 ${i == 0 ? "active" : "" }'>
								<img src="/sgu_j2ee/files/${v.tenFile}" class="img-thumbnail d-block w-100 h-100" alt="...">
							</div>
						`
					   $('#carouselExampleIndicators .carousel-indicators').append(buttonDiv)
					   $('#carouselExampleIndicators .carousel-inner').append(imgSlideDiv)
					})
					$('.bai-viet-main-content .attachments').empty()
					$.each(response.fileDinhKems, function (i, v) { 
						let fileDiv = `
							<div class="attachment">
								<a href="/sgu_j2ee/files/${v.tenFile}"
									download="/sgu_j2ee/files/${v.tenFile}"> <span
									class="attachment-icon"><i class="fa-solid fa-paperclip"></i></span>
									<span class="attachment-name">${v.tenFile}</span>
								</a>
							</div>
						`
					   $('.bai-viet-main-content .attachments').append(fileDiv)
					})
				}
				$(`div[data-post-id="${postId}"] .bai-viet-main-content p`).text(response.baiViet.noiDung)
				$('#modal_post').modal('hide')
				clear_post_modal()
			}
	    }
	})
})

function appendBaiViet(baiVietView) {
	let baiVietDiv = `
		<div class="d-flex flex-column  bai-viet-content-wrapper"
		data-post-id=${baiVietView.baiViet.maBaiViet}
		data-is-detail-mode=false data-user-login="4">
		<div class=" d-flex justify-content-between profile-wrapper">
			<div class="d-flex profile-left">
				<div class="profile-img">
					<img src="/sgu_j2ee/files/${baiVietView.anhDaiDienNguoiDang}"alt=""/>
				</div>
				<div class="profile-info">
					<h1>${baiVietView.hoVaTenNguoiDang}</h1>
					<span>Đã đăng vào lúc ${baiVietView.baiViet.ngayDang}</span>
				</div>
			</div>
	
			<div class="profile-right" onclick="showMore(this)">
				<i class="fa fa-ellipsis-h"></i>
				<div class="profile-more-hover">
					<button type="button" class="btn profile-item edit-post-btn" onclick="editPost(this)">
						<i class="fa fa-cog" aria-hidden="true"></i><span> Chỉnh sửa</span>
					</button>
					<button type="button" class="btn profile-item delete-post-btn"
						data-bs-toggle="modal" data-bs-target="#deletePostConfirm"
						onclick="onPostDeleteClick(this)">
						<i class="fa fa-trash" aria-hidden="true"></i> <span> Xóa </span>
					</button>
				</div>
			</div>
	
		</div>
		<div class="d-flex flex-column bai-viet-main-content not-detail-mode">
			<p>${baiVietView.baiViet.noiDung}</p>
	        <div class="see-more">
	            <a href="/sgu_j2ee/chitietbaiviet?maBaiViet=${baiVietView.baiViet.maBaiViet}">Xem thêm</a>
	        </div>
			<div class="bai-viet-data">
				<div class="react-data">
					<span></span>
				</div>
				<div class="comment-data">0 bình luận</div>
			</div>
			<hr>
			<div class="bai-viet-actions">
				<div class="react-action ">
					<div onclick="handleOnClickReact(this)" class=" react-action-btn" data-active=false>
	                    <i class="fa fa-thumbs-up" aria-hidden="true"></i>
	                    <span>Thích</span>
					</div>
					<div class="more-action">
						<div class="react-action-item" data-react="like"
							onclick="onReactClick(this)">
							<img alt="" src="/assets/images/like.png">
						</div>
						<div class="react-action-item" data-react=heart
							onclick="onReactClick(this)">
							<img alt="" src="/assets/images/heart.png">
						</div>
						<div class="react-action-item" data-react="sad"
							onclick="onReactClick(this)">
							<img alt="" src="/assets/images/sad.png">
						</div>
						<div class="react-action-item" data-react="haha"
							onclick="onReactClick(this)">
							<img alt="" src="/assets/images/haha.png">
						</div>
						<div class="react-action-item" data-react="mad"
							onclick="onReactClick(this)">
							<img alt="" src="/assets/images/mad.png">
						</div>
					</div>
				</div>
				<div class="comment-action">
					<a href="/sgu_j2ee/chitietbaiviet?maBaiViet=${baiVietView.baiViet.maBaiViet}"></a>
					<i class="fa fa-comment" aria-hidden="true"></i> <span>Bình luận</span>
				</div>
			</div>
		</div>
		</div>
	`
	$('.profile-posts').prepend(baiVietDiv)
}
