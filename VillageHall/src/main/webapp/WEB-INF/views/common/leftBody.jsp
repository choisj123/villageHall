<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 왼쪽 네비 -->

<section class="left-body">
    <article>
      <!-- 이미지 + 로그인 -->


      <img src="${pageContext.request.contextPath}/resources/images/profile.png" /><br />
      <a href="${pageContext.request.contextPath}/user/login" id="body-login"> 로그인</a>

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
        	<a href="${contextPath}/board/myBoard">내글목록(로그인기능추가하면 나중에삭제)</a>
        </li>
        <li>
        	<a href="${contextPath}/user/myInfo">내정보수정(로그인기능추가하면나중에삭제)</a>
        </li>
      </ul>
    </nav>
  </section>