<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 왼쪽 네비 -->

<section class="left-body">
  <article>
    <%-- 로그인/로그아웃(if-else) --%>
    <c:choose>
      <%-- 로그인 되있지 않은 경우 --%>
      <c:when test="${empty sessionScope.loginUser}">
        <img src="${contextPath}/resources/images/profile.png" /><br />
        <a href="${contextPath}/user/login" id="body-login"> 로그인</a>
      </c:when>
      <c:otherwise>
        <img src="${contextPath}/resources/images/profile.png" /><br />
        <span id="left-user-name"><strong>${loginUser.userNickname}님</strong></span>
        <span>
          <a href="${contextPath}/mypage/myPage" id="updateMyInfo">내 정보 수정</a>
          |
          <a href="${contextPath}/mypage/myBoard" id="selectMyBoard"> 내 글 목록</a></span>
      </c:otherwise>
    </c:choose>
    <!-- 이미지 + 로그인 -->
  </article>
  <!-- 네비 (메뉴바)-->
  <nav>
    <ul>
      <li>
        <i class="fa-solid fa-house" id="nav-home"></i>
        <a href="${contextPath}">홈</a>
      </li>
      <li>
        <i class="fa-regular fa-bell" id="nav-notice"></i>
        <a href="${contextPath}/board/notice"> 공지사항</a>
      </li>
      <li>
        <i class="fa-solid fa-globe" id="nav-all"></i>
        <a href="${contextPath}/board/allBoard">전체글</a>
      </li>
      <li>
        <i class="fa-solid fa-bookmark" id="nav-popular"></i>
        <a href="${contextPath}/board/popularBoard">인기글</a>
      </li>
      <li>
        <i class="fa-regular fa-circle-question" id="nav-faq"></i>
        <a href="${contextPath}/board/FAQ">FAQ</a>
      </li>
      <li>
        <a href="${contextPath}/user/test">테스트로그인용</a>
      </li>
    </ul>
  </nav>
</section>
