<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" /> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>마을회관</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/signUp.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/main.css" />

    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/2f1bf0eac7.js" crossorigin="anonymous"></script>
  </head>

  <body>
    <main>   
      <!-- hedaer include -->
      <jsp:include page="/WEB-INF/views/common/header.jsp" />

      <!-- 회원가입  -->
  <section class="signUp-content">

         

        <form
          action="signUp"
          method="POST"
          name="signUp-form"
          enctype="multipart/form-data" 
          onsubmit="return signUpValidate()"
        >


        
            <div class="villageHall">
                마을회관
             </div>
        
          <label for="userEmail">
            아이디(이메일)<span class="required">•</span>
          </label>

          <div class="signUp-input-area">
            <input
              type="email"
              id="userEmail"
              name="userEmail"
              placeholder="아이디(이메일)"
              maxlength="30"
              autocomplete="off"
              required
            />

            &nbsp;<button type="button" id="sendBtn">인증번호</button>
          </div>

          <span class="signUp-message" id="emailMessage"
            ></span>

		<!--  
          <label for="emailCheck">
            인증번호<span class="required">•</span>
          </label> 
          -->

          <div class="signUp-input-area">
     
            <input
              type="text"
              id="cNumber"
              placeholder="인증번호 입력"
              maxlength="6"
              autocomplete="off"
            />

            &nbsp;<button type="button" id="cBtn">인증하기</button>
          </div>

         
          <span class="signUp-message" id="cMessage"></span>

          <label for="userPw">  비밀번호 <span class="required">•</span></label>

          <div class="signUp-input-area">
            <input
              type="password"
              id="userPw"
              name="userPw"
              placeholder="영어, 숫자, 특수문자 최소6글자"
              maxlength="30"
            />
          </div>

          <div class="signUp-input-area">
            <input
              type="password"
              id="userPwConfirm"
              placeholder="비밀번호 확인"
              maxlength="30"
            />
          </div>

          <span class="signUp-message" id="pwMessage"
            ></span
          >

          <label for="userNickname">
            닉네임<span class="required">•</span>
          </label>

          <div class="signUp-input-area">
            <input
              type="text"
              id="userNickname"
              name="userNickname"
              placeholder="영어/숫자/한글 최소2글자"
              maxlength="10"
            />
          </div>

          <span class="signUp-message" id="nicknameMessage"
            ></span
          >

          <label for="userTel">
            전화번호<span class="required">•</span>
          </label>

          <div class="signUp-input-area">
            <input
              type="tel"
              id="userTel"
              name="userTel"
              placeholder="(- 없이 숫자만 입력)"
              maxlength="11"
            />
          </div>

          <span class="signUp-message" id="telMessage"
            ></span>
           
          <label for="profile">
            <span class="signUp-message"></span>프로필 사진
          </label>
          <input type="file" name="profileImage" id="input-image" accept="image/*"> 
                     
          <button type="submit" id="signUp-btn">일반 회원가입</button>  
                  
                  
           <a href="javascript:void(0)" id="kakao-btn" onclick="kakaoLogin();">
           		<img src="${contextPath}/resources/images/kakao_login_medium_wide.png">
           </a>
        </form>
      </section>

    </main>
    
    <!-- 카카오 스크립트 -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
	Kakao.init('f05c8b2913faad9659a18a205defef9c'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	
	   //카카오로그인
	   function kakaoLogin() {
        	Kakao.Auth.login({
      	    success: function (response) {
        	    Kakao.API.request({
          	     url: '/v2/user/me',
          	     success: function (response) {
        	                console.log(response)
          		},
          
        		fail: function (error) {
                      		console.log(error)
          		},
       		 })
      		},
      		fail: function (error) {
        		console.log(error)
     		 },
   		 })
  		}

	</script>
	
	
	<a href="${contextPath}/user/kakaoTest">카카오TEST</a>

    <!-- footer include -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <!-- jQuery 라이브러리 추가(CDN) -->
    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>

    <!-- signUp.js 연결 -->
    <script src="${contextPath}/resources/js/signUp.js"></script>
    
    
  </body>
</html>
