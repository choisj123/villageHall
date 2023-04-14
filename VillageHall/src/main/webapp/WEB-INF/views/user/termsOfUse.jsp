<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마을회관</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/termsOfUse.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/main.css">

    <script src="https://kit.fontawesome.com/a2e8ca0ae3.js" crossorigin="anonymous"></script>

</head>
<body>

    	<!-- header -->
     	<jsp:include page="/WEB-INF/views/common/header.jsp" />
     	
  <fieldset class="terms-of-use-area">
    	
        <form
        action="termsOfUse"
        method="Post"
        name="TermsOfUse-form"
        onsubmit= "return termsOfUserValidate()"
        >
          
                <div class="villageHall">
                    마을회관
                </div>

                <h4>개인정보 수집·이용 (필수)</h4>
                <table border="1">

                    <tr>   <!-- 1행 -->
                        <th>구분</th>   <!-- 1행 1열 -->
                        <th>목적</th>   <!-- 1행 2열 -->
                        <th>항목</th>   <!-- 1행 3열 -->
                        <th>동의</th>   <!-- 1행 4열 -->
                    </tr>
        
                    <tr> <!-- 2행 -->
                        <td>필수정보</td> <!-- 2행 1열 -->
                        <td>회원제 서비스 이용 / 본인확인</td> <!-- 2행 2열 -->
                        <td>이메일(아이디), 비밀번호, 닉네임</td> <!-- 2행 3열 -->
                    </tr>


                </table>


                <h4>개인정보 수집·이용 (선택)</h4>
                <table border="1">

                    <tr>   <!-- 1행 -->
                        <th>구분</th>   <!-- 1행 1열 -->
                        <th>목적</th>   <!-- 1행 2열 -->
                        <th>항목</th>   <!-- 1행 3열 -->
                        <th>동의</th>   <!-- 1행 4열 -->
                    </tr>
        
                    <tr> <!-- 2행 -->
                        <td>선택정보</td> <!-- 2행 1열 -->
                        <td>회원제 서비스 이용 / 본인확인</td> <!-- 2행 2열 -->
                        <td>이메일(아이디), 비밀번호, 닉네임</td> <!-- 2행 3열 -->
                    </tr>


                </table>


                <h4>광고성 정보 수신 (선택))</h4>
                <table border="1">

                    <tr>   <!-- 1행 -->
                        <th>구분</th>   <!-- 1행 1열 -->
                        <th>목적</th>   <!-- 1행 2열 -->
                        <th>항목</th>   <!-- 1행 3열 -->
                        <th>동의</th>   <!-- 1행 4열 -->
                    </tr>
        
                    <tr> <!-- 2행 -->
                        <td>이메일</td> <!-- 2행 1열 -->
                        <td>회원제 서비스 이용 / 본인확인</td> <!-- 2행 2열 -->
                        <td>이메일(아이디), 비밀번호, 닉네임</td> <!-- 2행 3열 -->
                    </tr>

                    <tr> <!-- 2행 -->
                        <td>전화번호</td> <!-- 2행 1열 -->
                        <td>회원제 서비스 이용 / 본인확인</td> <!-- 2행 2열 -->
                        <td>이메일(아이디), 비밀번호, 닉네임</td> <!-- 2행 3열 -->
                    </tr>


                </table>
                
                <div id="required">
                	<input type="checkbox" id="required1"> 필수1
                </div>
            
            
                <div id="required">
                    <input type="checkbox" id="required2"> 필수2
                </div>
        
                <div id="option1">
                    <input type="checkbox" id="option1"> 선택1
                </div>
        
                <div id="option2">
                    <input type="checkbox" id="option1"> 선택2
                </div>
                
                <a href="${contextPath}">취소</a>
                <button  id="nextBtn" >확인</button>
        </form>

    </fieldset>
    	
     	
   
    <!-- jQuery 라이브러리 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
   
	 <!--FindPw.js 연결 -->
    <script src="${contextPath}/resources/js/termsOfUse.js"></script>

</body>
</html>