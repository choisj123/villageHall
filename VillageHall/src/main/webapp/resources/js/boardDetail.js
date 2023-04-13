const insertCommentBtn = document.getElementById("insertCommentBtn");
const insertCommentContent = document.getElementById("insertCommentContent");


insertCommentBtn.addEventListener("click", function(event) {
	if(insertCommentContent.value == "") {
		alert("댓글을 입력해주세요.")
		event.preventDefault();
	}
});