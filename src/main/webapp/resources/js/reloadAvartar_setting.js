
    function previewFile() {
        var preview = document.getElementById('previewImage');
        var fileInput = document.getElementById('inputImage');
        var file = fileInput.files[0];
        var reader = new FileReader();

        reader.onloadend = function () {
            preview.src = reader.result;
        };

        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "https://i.pinimg.com/1200x/c0/29/5a/c0295a690ba4e121e0ab092279d8ed6b.jpg";
        }
    }
