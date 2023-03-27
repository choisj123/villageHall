<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>마을회관</title>

    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/main.css"
    />

    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <main>
      <!-- header include -->

      <!-- 내부 접근 절대 경로 -->
      <jsp:include page="/WEB-INF/views/common/header.jsp" />

      <!--콘텐츠 작성 영역-->
      <section class="content">
        <h1 class="sign-up-text">회원가입</h1>
      </section>

      <section class="content-2">
        <!--회원가입시 필요한 정보 기입 영역-->
        <form action="#" name="sign-up-form">
          <fieldset id="sign-up-area">
            <section class="sign-up-1">
              <!--이메일-->
              이메일<br /><input
                type="text"
                name="userEmail"
                class="input-text"
                id="userEmail"
                placeholder="아이디(이메일)"
                maxlength="30"
                autocomplete="off"
                required
                autofocus
              />
              <button id="email-check-btn">인증</button><br />
              <span class="signUp-message" id="emailMessage"
                >메일을 받을 수 있는 이메일을 입력해주세요.</span
              >

              <!--이메일 인증번호 확인-->
              이메일 인증<br /><input
                type="text"
                name="auth_number"
                class="input-text"
              />
              <button id="email-check-btn">확인</button><br /><br />

              <!--비밀번호-->
              비밀번호<br /><input
                type="password"
                input
                name="password"
                id="pw1"
                class="input-text"
              /><br />
              <span id="result1" class="confirm"></span><br />
              비밀번호 확인<br /><input
                type="password"
                input
                name="password-check"
                id="pw2"
                class="input-text"
              /><br />
              <span id="result2" class="confirm"></span><br />
              <!--닉네임-->
              닉네임<br /><input
                type="text"
                name="Nickname"
                class="input-text"
              />
              <br /><br /><br />

              <!--프로필사진-->
              프로필사진<br />
              <input type="file" name="profile-pic" />
            </section>
          </fieldset>

          <!--회원가입/카카오로 시작하기-->
          <br />
          <section>
            <article class="sign-up-article-1">
              <button type="submit" id="signup-btn">회원가입</button><br />
            </article>

            <article class="sign-up-article-2">
              <a href="javascript:void(0)" onclick="kakaoLogin();">
                <img src="/src/kakao_login_medium_wide.png" />
              </a>
            </article>
          </section>
        </form>
      </section>

      <script src="/js/sign-up-page.js"></script>
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

    <!-- main.js 연결 -->
    <!-- <script src="${pageContext.request.contextPath}/resources/js/main.js"></script> -->
  </body>
</html>
