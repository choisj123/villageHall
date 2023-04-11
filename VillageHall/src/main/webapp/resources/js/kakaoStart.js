Kakao.init('f05c8b2913faad9659a18a205defef9c'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
	
var userEmail;
var userNickname;
	
//카카오로그인
function kakaoLogin() {
	   
	Kakao.Auth.login({
	    success: function (response) {
		    Kakao.API.request({
	  	     url: '/v2/user/me',
	  	     success: function (response) {
	            //console.log(response)
	           
	           
	            userEmail = JSON.stringify(response.kakao_account.email);
	            userNickname = JSON.stringify(response.properties.nickname);
	            
	            console.log("userEmail",userEmail);
	            console.log("userNickname", userNickname);
	            
	           	process(userEmail, userNickname);
		            
	
		          
	          		
	         //접속된 회원의 토큰값 출력됨
	        //alert(JSON.stringify(authObj));
	        
	      },
			fail: function(error) {
				
	    		console.log(error);
	      }
	      
	    });
		
	}
});
		
function process(userEmail, userNickname){
		
	$.ajax({
           url:"kakaoTest",
           data:{"userEmail": userEmail, "userNickname":userNickname },
           type:"post",
           //dataType:"JSON",
           success:function(data){
           //성공적으로 하고나면 이동할 url
                
              console.log("data",data);  
              console.log("aJax",userEmail);
              console.log("aJax",userNickname);        
              alert("성공");
            },                            
                   
            error: function(error,status) {
                		
                console.log(error, status);
            }
            
     	});
		
		
	}
	
		
		
}







	
	     