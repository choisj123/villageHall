<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인창</title>

   <!-- <link rel="stylesheet" href="${contextPath}/resources/css/login.css">-->
     <link rel="stylesheet" href="${contextPath}/resources/css/main.css">

    <script src="https://kit.fontawesome.com/a2e8ca0ae3.js" crossorigin="anonymous"></script>

</head>
<body>
    <main>
        <!-- hedaer include -->
      <jsp:include page="/WEB-INF/views/common/header.jsp" />
      
     		 <div class="villageHall">
                마을회관
             </div>

            <section class="login-content">
           
            
            	<%-- if - else --%>
            	<c:choose>  
            		<%-- choose 내부에는 jsp 주석만 사용 --%>
            		
            		<%-- 로그인이 되어있지 않은 경우 --%>
       				<c:when test="${ empty sessionScope.loginUser}"> 
            		
		                <form action="login" method="Post" name="login-form" onsubmit="return loginValidate()">
		                   
		                    <!-- 아이디(이메일)/비밀번호/로그인버튼 영역 -->
		                    <fieldset id="id-pw-area">
		        
		                        <section>
		                            <input type="text" id="input-area" name="userEmail" placeholder="아이디(이메일)" value="${cookie.saveId.value}"><br>
                                                                                                 <%-- 현재 페이지 쿠키 중 "saveId"의 내용을 출력--%>                   
		                            <input type="password" id="input-area" name="userPw" placeholder="비밀번호">
		                        </section>
		        
		                        <section>
		                            <!-- button의 type 기본값은 submit -->
		                            <button>로그인</button>
		                        </section>
		                    </fieldset>
		                    
		                 
                            <%-- 쿠키에 saveId가 있는 경우--%>
                            <c:if test="${ !empty cookie.saveId.value}">

                                <%-- chk 변수 생성(page scope)--%>
                                <c:set var="chk" value="checked"/>

                            </c:if>
                                

		                    <label>
                                <!-- checked 속성 : radio/checkbox를 체크하는 속성 -->
		                        <input type="checkbox" name="saveId" ${chk}  id="saveId"> 아이디 저장
		                    </label>



		         <!-- 회원가입 / ID/PW 찾기 영역 -->
		                    <article id="signup-find-area">

                                <!-- WEB-INF 폴더는 외부로 부터 직접적으로 요청할 수 없는 폴더
                                    왜? 중요한 코드(자바, sql, 설정관련)가 위치하는 폴더로서
                                        외부로부터 접근을 차단하기 위해서

                                    -> 대신 Servlet을 이용 내부 접근(forward)은 가능
                                -->
		                       <!--  <a href="/community/WEB-INF/views/member/signUp.jsp">회원가입</a>  -->

		                        <a href="${contextPath}/user/signUp">회원가입</a> 

							

		                        <span>|</span>
		                        <a href="${contextPath}/user/pwFindEmail">비밀번호 찾기</a>
		                    </article>
		                    
		                     		<a href="javascript:void(0)" id="kakao-btn" onclick="kakaoLogin()">
        								 <img src="${contextPath}/resources/images/kakao_login_medium_wide.png">
    								</a>
    
       						 <!-- 카카오 스크립트 -->
						<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
						
						<!--***********************카카오로 시작하기 script *************************  -->




	<script>
	
	Kakao.init('f05c8b2913faad9659a18a205defef9c'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단

	var userEmail;
	var userNickname;
	var kakaoUserKey;
		
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
		            kakaoUserKey = response.id;
		            
		            console.log("userEmail",userEmail);
		            console.log("userNickname", userNickname);
		            console.log("kakaoUserKey", kakaoUserKey);
		            
		           	process(userEmail, userNickname, kakaoUserKey);
			            
		
			          
		          		
		         //접속된 회원의 토큰값 출력됨
		        //alert(JSON.stringify(authObj));
		        
		      },
				fail: function(error) {
					
		    		console.log(error);
		      }
		      
		    });
			
		}
	});
			
	function process(userEmail, userNickname, kakaoUserKey){
			
		$.ajax({
	           url:"kakaoTest",
	           data:{"userEmail": userEmail, "userNickname":userNickname, "kakaoUserKey":kakaoUserKey },
	           type:"post",
	           //dataType:"JSON",
	           success:function(data){
	           //성공적으로 하고나면 이동할 url
	           	
	                
	              console.log("data",data);  
	              console.log("aJax",userEmail);
	              console.log("aJax",userNickname);   
	              console.log("aJax",kakaoUserKey);   
	                   
	              alert("성공");
	              location.href='login';
	              
	            },                            
	                   
	            error: function(error,status) {
	                		
	                console.log(error, status);
	            }
	            
	     	});
			
			
		}
		
			
			
	}
	
	</script>
	
						
		                    
		                </form>
            		
            		</c:when>
            
            	</c:choose>
                
            </section>
            
            <!-- footer include -->
   			 <jsp:include page="/WEB-INF/views/common/footer.jsp" />
  

    </main>
    

	


    <!-- jQuery 라이브러리 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
   
    <!-- login.js 연결 -->
    <script src="${contextPath}/resources/js/login.js"></script>

</body>
</html>