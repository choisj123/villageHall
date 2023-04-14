<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 왼쪽 네비 -->

<section class="left-body">
    <!-- 이미지 + 로그인 -->
  <article class="profile-area">
    <%-- 로그인/로그아웃(if-else) --%>
    <c:choose>
      <%-- 로그인 되있지 않은 경우 --%>
      <c:when test="${empty sessionScope.loginUser}">
        <img src="${contextPath}/resources/images/profile.png" id="left-profile-image" /><br />
        <a href="${contextPath}/user/login" id="body-login"> 로그인</a>
      </c:when>
      <%-- 로그인 한 경우 --%>
      <c:otherwise>
      	<%-- 프로필사진 설정 안한 경우 --%>
      	<c:if test="${empty loginUser.profileImg}">
			<a href="${contextPath}/mypage/myPage"><img src="${contextPath}/resources/images/profile.png" id="left-profile-image"></a>
		</c:if>
		<%-- 프로필사진 설정 한 경우 --%>
		<c:if test="${!empty loginUser.profileImg}">
			<a href="${contextPath}/mypage/myPage"><img src="${contextPath}${loginUser.profileImg}" id="left-profile-image"></a>
        </c:if>
        <div id="profile-info-area">
	        <span id="left-user-name"><strong>${loginUser.userNickname}님</strong></span>
	        
	        <c:choose>
	        	<c:when test="${sessionScope.loginUser.kakaoUserKey == null}">
	        		<span>
	          			<a href="${contextPath}/mypage/myPage" id="updateMyInfo">내 정보 수정</a> |
	        			<a href="${contextPath}/mypage/myList?type=1" id="selectMyBoard"> 내 글 목록</a> 
	        		</span>
	        	</c:when>
	        	<c:otherwise>
	        		<span>
	          			<a href="${contextPath}/mypage/changeInfo" id="updateMyInfo">내 정보 수정</a> |
	        			<a href="${contextPath}/mypage/myList?type=1" id="selectMyBoard"> 내 글 목록</a> 
	       			 </span>		
	        	</c:otherwise>
	        </c:choose>
        </div>
          <button type="button" id="writeBtn" onclick="location.href='${contextPath}/board/writeBoard?mode=insert'" >글쓰기</button>
      </c:otherwise>
    </c:choose>
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
        <a href="${contextPath}/board/list?type=1&categoryNo=1"> 공지사항</a>
      </li>
      <li>
        <i class="fa-solid fa-globe" id="nav-all"></i>
        <a href="${contextPath}/board/list?type=3&categoryNo=0">전체글</a>
      </li>
      <li>
      <i class="fa-regular fa-thumbs-up" id="nav-popular"></i>
        <a href="${contextPath}/board/popularBoard?sortBy=like">인기글</a>
      </li>
      <li>
        <i class="fa-regular fa-circle-question" id="nav-faq"></i>
        <a href="${contextPath}/board/list?type=2&categoryNo=2">FAQ</a>
      </li>
      <li>
        <a href="${contextPath}/user/test">테스트로그인용</a>
      </li>
    </ul>
  </nav>
  
  <section class="weather">
            <div class="box">
            	<div class="firstBox">
            		<div class="left">
            			<div class="cicon"></div>
            		</div>
            		<div class = "right">
		                <div class="ctemp"></div>
		                <div class="main"></div>
		                <div class="name"></div>
               		</div>
            	</div>
            	<div class="secondBox">
	            	<div class="wi">
		            	<img src="${contextPath}/resources/images/wind.png" id="wind-logo" />
	            		 <div class="speed"></div>
	            	</div>
	            	<div class = "hu">
		            	<img src="${contextPath}/resources/images/humidity.png" id="humidity-logo" />
		            	<div class="humidity"></div>
	            	</div>
	            	<div class="mi">
		            	<img src="${contextPath}/resources/images/dust.png" id="aqi-logo" />
		            	<div class="aqi"></div>	
	            	</div>
            	
            	</div>
            
            </div>
         </section>
  
  
  
</section>

