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
  			var imageUrl = image.filePath + image.fileName
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
  navigator.geolocation.getCurrentPosition(
    function(position) {
      latitude = position.coords.latitude;
      longitude = position.coords.longitude;
      console.log("위도경도 받아오기 " + latitude, longitude)
      
      // 데이터 처리 함수 호출
      processData(latitude, longitude);
    },
    function(error) {
      console.log(error);
    }
  );
}    
    


// JSP로 위도와 경도 값을 전달
/*window.location.href = "writeBoard.jsp?latitude=" + latitude + "&longitude=" + longitude;*/



  

      // 게시글 작성 유효성 검사
function writeValidate(){
    const boardTitle = document.getElementsByName("boardTitle")[0];
    const boardContent = document.querySelector("[name='boardContent']");
	
	if(category.value == "" ){
		alert("카테고리를 선택해주세요.")
		return false;
	}

    if(boardTitle.value.trim().length == 0){
        alert("제목을 입력해주세요.");
        boardTitle.value = "";
        boardTitle.focus();
        return false;
    }

    if(boardContent.value.trim().length == 0){
        alert("내용을 입력해주세요.");
        boardContent.value = "";
        boardContent.focus();
        return false;
    }
    
    return true;
   /* 
    function processData(latitude, longitude) {
  	// 데이터 처리 로직
 	 $.ajax({
	      url: "writeBoard",
	      data: { "latitude": latitude, "longitude": longitude},
	      type: "POST",
	      success: function() {
	          console.log("위치 정보가 저장되었습니");
	          console.log(latitude, longitude);
	          
	          return true;
	      },
	           error : function(request, status, error){
	          console.log("위치 정보 저장 실패");
	          console.log("상태코드 : " + request.status); // 404, 500
	      }
      });
}*/
    

}