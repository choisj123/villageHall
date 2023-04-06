$(document).ready(function(){
	console.log("js loaded");
	if (navigator.geolocation) {
    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
        
        var latitude = position.coords.latitude, // 위도
            longitude = position.coords.longitude; // 경도
        
        console.log(latitude, longitude);
            
      });
    
} 
	
	
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
    
      function saveContent(form) {
		let category = form.category.value;
        let boardTitle = form.boardTitle.value;
        let boardContent = form.boardContent.value;
        //let boardContent = $("#summernote").summernote("code");
        
        console.log("카테고리 : " + category);
        console.log("제목 : " + boardTitle);
        console.log("내용 : " + boardContent);
        
        if (navigator.geolocation) {
    
		    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
		    navigator.geolocation.getCurrentPosition(function(position) {
	        
		        let latitude = position.coords.latitude // 위도
		        let longitude = position.coords.longitude; // 경도
		        
		        console.log(latitude, longitude);
	        
	            
	      });
    
		} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
		    
		    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
		        message = 'geolocation을 사용할수 없어요..'
		        
		    displayMarker(locPosition, message);
		    
		}
		
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

