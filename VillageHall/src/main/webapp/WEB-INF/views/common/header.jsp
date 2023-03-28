<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<header>
  <!-- 클릭시 메인으로 이동하는 로고 -->
  <section>
    <a href="${contextPath}">
      <img src="${contextPath}/resources/images/logo.png" id="home-logo" />

    </a>
  </section>

  <section>
    <article class="search-area">
      <!-- form 내부 input 태그 값을 서버 또는 페이지로 전달 -->
      <form action="#" name="search-form">
        <fieldset>
          <input
            type="search"
            id="query"
            name="query"
            autocomplete="off"
            placeholder="검색어를 입력해주세요"
          />

          <!-- 검색버튼 -->
          <button id="search-btn" class="fa-solid fa-magnifying-glass"></button>
        </fieldset>
      </form>
    </article>
  </section>

  <!-- 로그인 / 회원가입 -->
  <section class="login-signup-area">
    <div>
      <!-- 자물쇠 아이콘 -->

      <a href="${contextPath}/user/login" id="login" class="fa-solid fa-lock"
        >&nbsp;로그인</a
      >
    </div>

    <a href="${contextPath}/user/signUp" id="signup">회원가입</a>

  </section>
</header>
