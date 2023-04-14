const insertCommentBtn = document.getElementById("insertCommentBtn");
const insertCommentContent = document.getElementById("insertCommentContent");
const updateCommentContent = document.getElementById("updateCommentContent");
const updateButton = document.querySelector('#updateCommentButton');
let commentNo = document.getElementById

insertCommentBtn.addEventListener("click", function(event) {
	if(insertCommentContent.value == "") {
		alert("댓글을 입력해주세요.")
		event.preventDefault();
	}
});
document.querySelectorAll('#updateCommentButton').forEach(function(button) {
  button.addEventListener('click', function() {
	console.log("버튼이 클릭됨");
    // 해당 댓글의 수정폼이 열리도록 함
    var commentDetail = this.closest('.commentDetail');
    var commentContent = commentDetail.querySelector('.comment-content');
    var commentEditForm = commentDetail.querySelector('.commentEditForm');
    commentContent.style.display = 'none';
    commentEditForm.style.display = 'flex';
    $("#updateCommentButton").hide();
    $("#deleteCommentButton").hide();
    $(".comment-createDate").hide();
    
    updateCommentContent.value = commentContent.innerHTML;
    commentNo = commentDetail.getAttribute('data-commentNo');
  });
});

document.querySelectorAll('.cancelCommentButton').forEach(function(button) {
  button.addEventListener('click', function() {
    // 수정폼이 닫히고 내용이 다시 보이도록 함
    var commentDetail = this.closest('.commentDetail');
    var commentContent = commentDetail.querySelector('.comment-content');
    var commentEditForm = commentDetail.querySelector('.commentEditForm');
    commentEditForm.style.display = 'none';
    commentContent.style.display = 'flex';
    $("#updateCommentButton").show();
    $("#deleteCommentButton").show();
    $(".comment-createDate").show();
  });
});

//댓글 수정 
document.querySelectorAll('.saveCommentButton').forEach(function(button){
	button.addEventListener('click', function(){
		    // 수정 내용 서버로 전송
    $.ajax({
      type : "GET",
      url : "comment/updateComment",
      dataType : "json", 
      data: {
        commentNo: commentNo, // 수정할 댓글 번호
        commentContent: updateCommentContent.value // 수정한 댓글 내용
      },  
      success: function(result) { // 요청이 성공한 경우
        if (result == "success") { // 수정이 성공한 경우
          $(".commentDetail#" + commentNo).find(".comment-content").text(updateCommentContent.value); // 수정된 내용으로 화면 업데이트
          $(".commentDetail#" + commentNo).find(".commentEditForm").hide(); // 수정 폼 숨기기
          $(".commentDetail#" + commentNo).find(".updateCommentContent").show(); // 댓글 내용 보여주기
        } else { // 수정이 실패한 경우	
          alert("댓글 수정에 실패했습니다.");
        }
      },
      error: function() { // 요청이 실패한 경우
        alert("댓글 수정에 실패했습니다.");
      }
    });
	})
})
