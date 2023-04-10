console.log("js loaded");
 

// 썸머노트 호출
$("#summernote").summernote({
    placeholder: "내용을 입력해주세요",
    tabsize: 2,
    height: 500,
    minHeight: null, // set minimum height of editor
    maxHeight: null, // set maximum height of editor
    focus: true,
    lang: "ko-KR",
    toolbar: [
	  ['fontname', ['fontname']],
	  ['fontsize', ['fontsize']],
      ["style", ["style"]],
      ["font", ["bold", "underline", "clear"]],
      ["color", ["color"]],
      ["para", ["ul", "ol", "paragraph"]],
      ["table", ["table"]],
      ["insert", ["link", "picture"]],
      ["view", ["fullscreen", "codeview", "help"]],
    ],
      fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
	  fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
	   /* 이미지 삽입 후 서버에 저장을 위한 callback */
	  callbacks: {
        			onImageUpload : function(files, editor, welEditable) {
		            for (var i = files.length - 1; i >= 0; i--) {
		            	sendFile(files[i], this);
		            }
							} 
        	}
  });
  
  
  /* 이미지 서버 저장 후 url 반환 받는 함수 */  
	function sendFile(file, el) {
	var form_data = new FormData();
	form_data.append('file', file);

		$.ajax({
   	data: form_data,
   	type: "POST",
   	url: 'boardImg',
   	cache: false,
   	contentType: false,
   	enctype: 'multipart/form-data',
   	dataType : "json",
   	processData: false,
   	success: function(image) {
  		//filePath == url : 서버에 업로드된 url을 반환받아 <img> 태그 src에 저장
  			var imageUrl = image.filePath + "/" + image.fileName
     		$(el).summernote('editor.insertImage', imageUrl);
  			console.log("서버 업로드 성공");
  			console.log(image);
  			console.log(image.filePath);
  			console.log(image.fileName);
   	}
 	});
} 


    var latitude = 0;
    var longitude = 0;
    
if (navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(function(position) {
	       latitude = position.coords.latitude; // 위도
	       longitude = position.coords.longitude; // 경도

			console.log("위도경도 받아오기 " + latitude, longitude)

  });
}

/*
let ajaxDo = function(){
	if(latitude != 0){
	 console.log("실행");
	 
	  $.ajax({
	      url: "writeBoard",
	      data: { latitude: latitude, longitude: longitude},
	      type: "POST",
	      success: function() {
	          console.log("ajax : " + latitude, longitude);
	          //document.getElementById("latitude").innerText = latitude;
	      },
	           error : function(request, status, error){
	          console.log("AJAX 에러 발생");
	          console.log("상태코드 : " + request.status); // 404, 500
	      }
	      });
	}
}
	 
setTimeout(ajaxDo,10000);
*/


  

      // 게시글 작성 유효성 검사
function writeValidate(){
    const boardTitle = document.getElementsByName("boardTitle")[0];
    const boardContent = document.querySelector("[name='boardContent']");
	
	if(category.value == "" ){
		alert("카테고리를 선택해주세요.")
	}

    if(boardTitle.value.trim().length == 0){
        alert("제목을 입력해주세요.");
        boardTitle.value = "";
        boardTitle.focus();
    }

    if(boardContent.value.trim().length == 0){
        alert("내용을 입력해주세요.");
        boardContent.value = "";
        boardContent.focus();
    }

}