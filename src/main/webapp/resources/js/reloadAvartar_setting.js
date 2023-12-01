
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
        }
    }
