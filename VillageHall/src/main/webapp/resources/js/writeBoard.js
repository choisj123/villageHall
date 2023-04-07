
$(document).ready(function(){
	
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
    
    callbacks: {
        	onImageUpload: function(files, editor, welEditable) {
        		for(var i = files.length -1; i>=0; i--) {
        			sendFile(files[i], this);
        		}
        	}
        	},

    toolbar: [
      ["style", ["style"]],
      ["font", ["bold", "underline", "clear"]],
      ["color", ["color"]],
      ["para", ["ul", "ol", "paragraph"]],
      ["table", ["table"]],
      ["insert", ["link", "picture"]],
      ["view", ["fullscreen", "codeview", "help"]],
    ],
  });
  
  



$(document).on("click", "#writebtn", function () {
        saveContent();
      });
      
      
    });



    
if (navigator.geolocation) {
	navigator.geolocation.getCurrentPosition(
		function(position) {
			 const latitude = position.coords.latitude;
		     const longitude = position.coords.longitude;
		      // 데이터 처리 함수 호출
		      processData(latitude, longitude);
		      
		      
   		 },		
		 function(error) {
	     console.log(error);
	    }
 	 );
}

function processData(latitude, longitude) {
  // 데이터 처리 로직
  $.ajax({
	      url: "writeBoard",
	      data: { "latitude": latitude, "longitude": longitude},
	      type: "POST",
	      success: function() {
	          console.log("성공?");
	          console.log("ajax: " + latitude, longitude);
	      },
	           error : function(request, status, error){
	          console.log("AJAX 에러 발생");
	          console.log("상태코드 : " + request.status); // 404, 500
	      }
	      });
}
    
      
/*
    var latitude = 0;
    var longitude = 0;
    
if (navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(function(position) {
	       latitude = position.coords.latitude; // 위도
	       longitude = position.coords.longitude; // 경도

			console.log(latitude, longitude)

  });
}
if(latitude != null){
	 console.log("실행")
	  $.ajax({
	      url: "writeBoard",
	      data: { "latitude": latitude, "longitude": longitude},
	      type: "POST",
	      success: function() {
	          console.log("성공?");
	          console.log(latitude, longitude);
	      },
	           error : function(request, status, error){
	          console.log("AJAX 에러 발생");
	          console.log("상태코드 : " + request.status); // 404, 500
	      }
	      });
	
}
	 */

    // 저장 
function saveContent(form) {
	let category = form.category.value;
    let boardTitle = form.boardTitle.value;
    let boardContent = form.boardContent.value;
    latitude = form.latitude.value;
    longitude = form.longitude.value;
    //let boardContent = $("#summernote").summernote("code");
    
    console.log("카테고리 : " + category);
    console.log("제목 : " + boardTitle);
    console.log("내용 : " + boardContent);
    
	
  }

      

      // 게시글 작성 유효성 검사
function writeValidate(){
    const boardTitle = document.getElementsByName("boardTitle")[0];
    const boardContent = document.querySelector("[name='boardContent']");
	
	if(category.value == "" ){
		alert("카테고리를 선택해주세요")
		return false;
	}

    if(boardTitle.value.trim().length == 0){
        alert("제목을 입력해주세요!!!");
        boardTitle.value = "";
        boardTitle.focus();
        return false;
    }

    if(boardContent.value.trim().length == 0){
        alert("내용을 입력해주세요!!!");
        boardContent.value = "";
        boardContent.focus();
        return false;
    }

    return true;
}

