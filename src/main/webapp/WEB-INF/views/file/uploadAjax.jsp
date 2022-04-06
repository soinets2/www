<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="shortcut icon" href="#">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<title>Insert title here</title>
</head>
<body>

<div class="uploadDiv">
	<input type="file" name="uploadFiles" multiple>
</div>

<button id="uploadBtn">Upload</button>

<script>
	$("#uploadBtn").on("click", function(e) {
		var formData = new FormData();
		var inputFile = $("input[name='uploadFiles']");
		var files = inputFile[0].files;
		console.log(files);
		
		for(var i in files) {
			formData.append("uploadFiles", files[i]);
		}
		
		$.ajax({
			url: "/file/uploadAjaxAction",
			processData: false,
			contentType: false,
			data: formData,
			type: "POST",
			dataType: "json",
			success: function(result) {
				console.log(result);
			}
		});
	});
</script>
	
</body>
</html>