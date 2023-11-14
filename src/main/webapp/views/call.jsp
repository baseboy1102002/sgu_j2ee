<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Call Video</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<style>
#video-container {
	position: relative;
	margin: auto;
	width: 640px;
}

video {
	background: #dee;
}

#localVideo {
	position: absolute;
	top: 0;
	right: 0;
	width: 120px;
	z-index: 10;
	background: #333;
}

#remoteVideo {
	width: 100%;
}

#action-buttons {
	margin: auto;
	text-align: center;
}

.hidden-first {
	display: none;
}
</style>
</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-12">
            <div class="jumbotron">
                <div class="container">
                    <div id="incoming-call-notice" style="display: none;">
                        <div class="spinner-grow text-primary" role="status"  >
                            <span class="sr-only">Incoming call...</span>
                        </div>
                        <h3>Incoming call...</h3>
                    </div>
                </div>
            </div>
                <div id="video-container">
                    <video id="localVideo" autoplay muted></video>
                    <video id="remoteVideo" autoplay style="height: 360px;"></video>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col" id="action-buttons">
                <button id="callButton" class="btn btn-success">Call</button>
                <button id="answerCallButton" class="btn btn-info hidden-first">Answer Call</button>
                <button id="rejectCallButton" class="btn btn-warning hidden-first">Reject Call</button>
                <button id="endCallButton" class="btn btn-danger hidden-first">End Call</button>
            </div>
        </div>
    </div>

    <script src="js/lib/jquery.js"></script>
    <script src="js/lib/socket.io-2.2.0.js"></script>
    <script src="js/StringeeSDK-1.5.10.js"></script>
    
    <script>
        var token = 'eyJjdHkiOiJzdHJpbmdlZS1hcGk7dj0xIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiJTSy4wLnJVUlBiSWVYMWJ4U3hPNmlKbEc0WGF3OTB1TkRuSy0xNjk5ODgwNzcxIiwiaXNzIjoiU0suMC5yVVJQYkllWDFieFN4TzZpSmxHNFhhdzkwdU5EbksiLCJleHAiOjE3MDI0NzI3NzEsInVzZXJJZCI6InVzZXIxIn0.LHPOUXzJvQIkOnYfcSKQ-fubtHjZDEe66sTFarBbCrI';
        var callerId = 'user1';
        var calleeId = 'user2';
    </script>


    <script src="js/code.js"></script>
</body>
</html>