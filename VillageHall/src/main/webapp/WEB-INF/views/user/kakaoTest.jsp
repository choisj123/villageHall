<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카카오테스트창</title>

   <!-- <link rel="stylesheet" href="${contextPath}/resources/css/login.css">-->
     <link rel="stylesheet" href="${contextPath}/resources/css/main.css">

    <script src="https://kit.fontawesome.com/a2e8ca0ae3.js" crossorigin="anonymous"></script>

</head>

    <h1>카카오 테스트</h1>
    
    <form>
    
    
    <a href="javascript:void(0)" id="kakao-btn" onclick="kakaoLogin();">
           		<img src="${contextPath}/resources/images/kakao_login_medium_wide.png">
    </a>
           
           
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
        	                console.log(response.id)
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
	
	</form>
    
    
    

    <!-- jQuery 라이브러리 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
   

</body>
</html>