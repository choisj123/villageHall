$(document).ready(function(){
    $("#summernote").summernote({
        placeholder: "내용을 입력해주세요",
        tabsize: 2,
        height: 500,
        minHeight: null, // set minimum height of editor
        maxHeight: null, // set maximum height of editor
        focus: true,
        lang: "ko-KR",

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
    
      function saveContent() {
        let boardTitle = $("#boardTitle").val;
        let boardContent = $("#summernote").summernote("code");
        
        console.log("제목 : " + boardTitle);
        console.log("내용 : " + boardContent);
      }
          
