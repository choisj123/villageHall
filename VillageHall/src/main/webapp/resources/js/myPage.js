const inputPw = document.getElementById("inputPw");
const pwBtn = document.getElementById("pwBtn");

pwBtn.addEventListener("click", function(){
	
	// 미작성시
	if(inputPw.value.length == 0){
		alert("비밀번호를 입력해주세요.");
	}
	
	// 비밀번호 일치 검사
	$.ajax({
            url : "mypage/myPage",
            data : {"inputPw" : inputPw.value, "userEmail" : userEmail},
            type : "POST",
            typeof : "JSON",
            success : function(){
				if(inputPw = userPw){
				
					alert("일치");
	                
					
				}else{
					alert("비밀번호가 일치하지 않습니다.");
					
				
				}
			},
			error: function(){}
			
	
	});

})