<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
      <form action="${contextPath}/board/list" method="get" name="boardSearch" onsubmit="return searchValidate()">      	
        <input type="hidden" name="type" value="3">
        <input type="hidden" name="categoryNo" value="0">
        <input type="hidden" name="key" value="t">
        
        <fieldset>
          <input
            type="text"
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

  <!-- 로그인 / 회원가입 / 로그아웃 -->
  <c:choose>
    <c:when test="${empty sessionScope.loginUser}">
      <section class="login-signup-area">
        <div>
          <!-- 자물쇠 아이콘 -->
          <a href="${contextPath}/user/login" id="login" class="fa-solid fa-lock">&nbsp;로그인</a>
        </div>
        <a href="${contextPath}/user/signUp" id="signup">회원가입</a>
      </section>
    </c:when>
    <c:otherwise>
      <%-- 회원이름 / 로그아웃 --%>
      <section class="logout-area">
        <span id="user-name">${loginUser.userNickname}님</span>&nbsp;&nbsp;
        <div>
          <%-- 자물쇠 아이콘 --%>
          <a href="${contextPath}/user/logout" id="logout" class="fa-solid fa-unlock">&nbsp;로그아웃</a>
        </div>
      </section>
    </c:otherwise>
  </c:choose>
</header>

<script src="${contextPath}/resources/js/header.js"></script>