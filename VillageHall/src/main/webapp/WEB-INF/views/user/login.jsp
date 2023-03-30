<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>마을회관</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/login-page.css" />

    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/2f1bf0eac7.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <main>
      <!-- header include -->
      <jsp:include page="/WEB-INF/views/common/header.jsp" />

      <!-- 바디 부분 시작 -->
      <section class="body">
        <!-- 메인 콘텐츠 -->
        <section class="right-body">
          <!--콘텐츠 작성 영역-->
          <section class="content">
            <h1 class="sign-in-text">로그인</h1>
          </section>

          <section class="content-2">
            <!--로그인시 필요한 정보 기입 영역-->
            <form action="#" name="sign-in-form">
              <fieldset id="sign-in-area">
                <section class="sign-in-1">
                  <!--아이디-->
                  <fieldset id="id-area">
                    <i class="fa-regular fa-user"></i>
                    <input
                      type="text"
                      name="inputId"
                      class="input-text"
                    /><br />
                  </fieldset>
                  <br />

                  <!--비밀번호-->
                  <fieldset id="pw-area">
                    <i class="fa-solid fa-lock"></i>
                    <input
                      type="password"
                      name="inputPw"
                      class="input-text"
                    /><br /><br />
                  </fieldset>
                  <br />

                  <!-- 로그인 버튼-->
                  <article class="signInBtn-article">
                    <button class="signInBtn">로그인</button>
                  </article>
                </section>
              </fieldset>

              <!--비밀번호 찾기/ 아이디 찾기/ 회원가입 -->
              <br />
              <article class="id-pw-found">
                <a href="../html/pw-find-page.html" class="found"
                  >비밀번호찾기</a
                >
                <a href="sign-up-page.html" class="found">회원가입</a>
              </article>

              <!--카카오로 로그인-->

              <article class="sign-in-article-1">
                <a href="javascript:void(0)" onclick="kakaoLogin();">
                  <img src="/src/kakao_login_medium_wide.png" />
                </a>
              </article>
            </form>
          </section>
        </section>
      </section>
    </main>

    <!-- footer include -->
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
