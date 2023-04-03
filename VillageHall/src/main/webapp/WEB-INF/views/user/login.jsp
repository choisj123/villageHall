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

    <link rel="stylesheet" href="resources/css/login.css">

    <script src="https://kit.fontawesome.com/a2e8ca0ae3.js" crossorigin="anonymous"></script>

</head>
<body>
    <main>

            <section class="content-2">
            
            	<%-- if - else --%>
            	<c:choose>  
            		<%-- choose 내부에는 jsp 주석만 사용 --%>
            		
            		<%-- 로그인이 되어있지 않은 경우 --%>
       				<c:when test="${ empty sessionScope.loginUser}"> 
            		
       			        <!-- 절대경로 : /community/member/login -->
		           	 	<!-- 상대 경로 (index.jsp) 기준-->
		                <form action="login" method="get" name="login-form" onsubmit="return loginValidate()">
		                   
		                    <!-- 아이디(이메일)/비밀번호/로그인버튼 영역 -->
		                    <fieldset id="id-pw-area">
		        
		                        <section>
		                            <input type="text" name="inputEmail" placeholder="아이디(이메일)" value="${cookie.saveId.value}">     
                                                                                                 <%-- 현재 페이지 쿠키 중 "saveId"의 내용을 출력--%>                   
		                            <input type="password" name="inputPw" placeholder="비밀번호">
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
		                        <a href="#">ID/PW 찾기</a>
		                    </article>
		                </form>
            		
            		</c:when>
            	
            	
            	</c:choose>
                
            </section>

    </main>

    <!-- jQuery 라이브러리 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
   
    <!-- main.js 연결 -->
    <script src="${contextPath}/resources/js/login.js"></script>

</body>
</html>