<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="${contextPath}/resources/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage.css" />

    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <main>
      <jsp:include page="/WEB-INF/views/common/header.jsp" />

      <section class="body">
        <jsp:include page="/WEB-INF/views/common/leftBody.jsp" />

        <section class="right-body">
          <h3>마이페이지</h3>
          <div class="myPage-box">
            <div>내 정보 수정</div>
            <form action="${contextPath}/mypage/myPage.jsp" method="post">
              <div id="box-body">
                비밀번호 <input type="password" size ="20px" id="inputPw" />
                <button type="submit" id="pwBtn">확인</button>
              </div>
              <div></div>
            </form>
          </div>
          <a href="${contextPath}/mypage/myInfo">이동</a>
        </section>
      </section>
    </main>

    <!-- footer include -->
    <!-- 내부 접근 절대 경로 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <!-- jQuery 라이브러리 추가 -->
    <script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"
    ></script>

    <script src="/js/myPage.js"></script>
  </body>
</html>
