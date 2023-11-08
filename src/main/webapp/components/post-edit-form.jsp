<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <div class="modal fade" id="modal_post" tabindex="-1" data-bs-backdrop="static" aria-hidden="true">
                <div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5"></h1>
                        </div>
                        <div class="modal-body">
                            <div id="post_content">
                                <textarea name="post_text" id="post_text" rows="10" placeholder="Hãy viết gì đó đi ..." class="w-100 p-2"></textarea>
                            </div>
                            <div id="post_file" class="d-flex justify-content-between align-items-center p-3">
                                <div>
                                    <h6 class="mb-0">
                                        <span class="badge rounded-pill">DOCX</span>
                                        Tên file
                                    </h6>
                                </div>
                                <span><i class="fa-regular fa-circle-xmark"></i></span>
                            </div>
                            <div id="post_image" class="mt-1">
                                <div class="row g-1">
                                    <!-- <div class="col-4 img-wrapper">
                                        <img src="./file/rain_girl.jpg">
                                        <div class="img-overlay"></div>
                                        <div class="img-btn fadeIn-top">
                                            <button class="btn btn-sm btn-primary post_image_delete">Hủy</button>
                                        </div>
                                    </div> -->
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div class="d-flex justify-content-lg-start align-content-center w-100">
                                <button id="btn_file" class="btn btn-outline-primary me-3">
                                	<i class="fa-regular fa-file"></i> file
                                </button>
                                <button id="btn_image" class="btn btn-outline-primary">
                                	<i class="fa-regular fa-image"></i> image
                                </button>
                                <input type="file" accept=".pdf, .docx, .xls, .pptx" id="input_file" hidden>
                                <input type="file" accept="image/*" id="input_image" hidden>
                            </div>
                            <button id="modal_post_close_btn" type="button" class="btn btn-secondary">Hủy</button>
                            <button id="modal_post_save_btn" type="button" class="btn btn-primary">Lưu</button>
                        </div>
                    </div>
                </div>
            </div>
