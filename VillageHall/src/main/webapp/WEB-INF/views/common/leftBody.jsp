<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!-- 왼쪽 네비 -->

<section class="left-body">
    <article>
      <!-- 이미지 + 로그인 -->

      <img src="../src/profile.png" /><br />
      <a href="/html/sign-in-page.html" id="body-login"> 로그인</a>
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
          <a href="#"> 공지사항</a>
        </li>
        <li>
          <i class="fa-solid fa-globe" id="nav-all"></i>
          <a href="${contextPath}/board/allBoard">전체글</a>
        </li>
        <li>
          <i class="fa-solid fa-bookmark" id="nav-popular"></i>
          <a href="#">인기글</a>
        </li>
        <li>
          <i class="fa-regular fa-circle-question" id="nav-faq"></i>
          <a href="${contextPath}/board/FAQPage">FAQ</a>
        </li>
      </ul>
    </nav>
  </section>