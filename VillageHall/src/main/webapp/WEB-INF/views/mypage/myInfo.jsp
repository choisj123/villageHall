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
    <link rel="stylesheet" href="${contextPath}/resources/css/main.css" />
    <link
      rel="stylesheet"
      href="${contextPath}/resources/css/myPage-myInfo.css"
    />
    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <main>
      <!-- header -->
      <jsp:include page="/WEB-INF/views/common/header.jsp" />

      <!-- 바디 부분 시작 -->
      <section class="body">
        <jsp:include page="/WEB-INF/views/common/leftBody.jsp" />

        <!-- 메인 콘텐츠 -->
        <section class="right-body">
          <h2>마이페이지</h2>

          <!-- 탭 메뉴 -->
          <jsp:include page="/WEB-INF/views/mypage/myInfoTab.jsp" />

          <!-- 내 정보 -->
          <div id="myInfo" class="tabContent">
                  <!-- 
                    enctype : form 태그가 데이터를 서버로 제출할 때 
                              데이터의 인코딩 형식을 지정하는 속성

                    1) application/x-www-form-urlencoded
                        - 모든 문자를 서버로 제출하기 전에 인코딩 (모든 데이터가 문자)
                          (form태그 기본값)

                    2) multipart/form-data : 제출할 때 인코딩을 하지 않음
                        -> 모든 데이터가 원본 형태를 유지(파일이 파일상태로 서버로 제출)
                        (주의) multipart/form-data 로 설정 시 method는 무조건 POST
                -->
          
				<div class="profile-image-area">
					<c:if test="${empty loginUser.profileImg}">
                            <img src="${contextPath}/resources/images/profile.png" id="lprofile-image">
                    </c:if>

					<c:if test="${!empty loginUser.profileImg}">
                            <img src="${contextPath}${loginUser.profileImg}" id="profile-image">
                    </c:if>

                </div>


                <div class="myPage-row">
                    <label>이메일</label>
                    <span>${loginUser.userEmail}</span>
                </div>

                <div class="myPage-row">
                    <label>가입일</label>
                    <span>${loginUser.enrollDate}</span>
                </div>
         </div>
       </section>
     </section>
   </main>

    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="/js/myPage.js"></script>

    <script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"
    ></script>
  </body>
</html>
