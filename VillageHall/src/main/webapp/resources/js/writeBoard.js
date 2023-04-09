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
    imageUploadUrl: "/board/writeBoard",
    imagePath: '/images/boardImg',
    callbacks: {
    onImageUpload: function(file) {
        var formData = new FormData();
	    formData.append("file", file[0]);
	    console.log(typeof file);
	    
	    $.ajax({
	        url: "writeBoard",
	        type: "POST",
	        data: formData,
	        contentType: false,
	        processData: false,
	        success: function(response) {
                    var imagePath = response.trim();
                    $('#summernote').summernote('insertImage', imagePath);
        }
    });
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


$(document).on("click", "#writebtn", function () {
        saveContent();
      });


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
  
  /*
$(function() {
  // Submit 버튼 클릭 이벤트 처리
  $("#writebtn").on("click", function(e) {
    e.preventDefault(); // Submit 버튼의 기본 동작인 폼 전송을 막음

    // form 데이터를 FormData 객체로 생성
    var formData = new FormData($("#boardWriteForm")[0]);

    // Ajax로 서버에 데이터 전송
    $.ajax({
      url: "board/writeBoard",
      type: "POST",
      enctype: "multipart/form-data",
      data: formData,
      processData: false,
      contentType: false,
      success: function(data) {
        // 게시글 등록 성공 시 게시글 상세 페이지로 이동
        location.href = "boardDetail?boardNo=" + data.boardNo;
      },
      error: function(xhr, status, error) {
        console.log(xhr.responseText);
        alert("게시글 등록에 실패했습니다.");
      }
    });
  });
     */ 

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
}

