<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix = "c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>마을회관</title>

    <script src="http://code.jquery.com/jquery-1.7.min.js"></script>

    <link rel="stylesheet" href="resources/css/main.css" />
    <link rel="stylesheet" href="resources/css/mainPage.css" />
    <link rel="stylesheet" href="resources/css/weather.css" />
    
    <!-- 글꼴 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@400;500&display=swap" rel="stylesheet">
    <!-- 정훈씨꺼 지도 api key -->
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=196b8c346b121bd08b2a475bfa001dd0"
    ></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=196b8c346b121bd08b2a475bfa001dd0&libraries=LIBRARY"
    ></script>

    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>
     <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script> 
     
     <link rel="stylesheet" href ="${contextPath}/resources/images/humidity.png"/>
  </head>
  <body>
    <main>
      <!-- header include -->

      <!-- 내부 접근 절대 경로 -->
      <jsp:include page="/WEB-INF/views/common/header.jsp" />

      <!-- 바디 부분 시작 -->
      <section class="body">
        <jsp:include page="/WEB-INF/views/common/leftBody.jsp" />

        <!-- 메인 콘텐츠 -->
        <section class="right-body">
          <!-- 지도 부분 -->
          <section class="main-container">
            <!-- <div style="margin: 0  0 10px 15px; "> -->
            <form onchange="showMarkersByCategory(this.value)"
                id="categorySelect">
            	<input type="radio" name="category"id="all" value="전체" checked style="display: none;"><label for="all">#전체</label>
            	<input type="radio" name="category" id="issue" value="이슈" style="display: none;"><label for="issue">#이슈</label>
            	<input type="radio" name="category" id="eat" value="맛집" style="display: none;"><label for="eat">#맛집</label>
            	<input type="radio" name="category" id="hobby" value="취미" style="display: none;"><label for="hobby">#취미</label>
            	<input type="radio" name="category" id="friend" value="친목" style="display: none;"><label for="friend">#친목</label>
            	<input type="radio" name="category" id="recommend" value="추천" style="display: none;"><label for="recommend">#추천</label>
            	<input type="radio" name="category" id="etc" value="기타" style="display: none;"><label for="etc">#기타</label>
       
            	<br>
              <!-- <label for="category" class="category">카테고리:</label>
              <select
                onchange="showMarkersByCategory(this.value)"
                id="categorySelect"
              >
                <option value="전체">전체글</option>
                <option value="이슈">이슈</option>
                <option value="맛집">맛집</option>
                <option value="취미">취미</option>
                <option value="친목">친목</option>
                <option value="추천">추천</option>
                <option value="기타">기타</option>
              </select>
            </div> -->
			</form>
            <div class="map-wrap">
              <div
                id="map" style="width: auto; height: 500px; margin-left: 15px">
             	  <div class="spin-container">
      				<i class="fas fa-spinner fa-10x fa-spin"></i>
  				  </div>
                <div class="map-nav">
                  <div class="map-header"></div>
                  <ul id="placesList"></ul>
                </div>
              </div>
            </div>
          </section>
          <!-- 공지+인기글 -->
          <section class="notice-fave">
            <!-- 공지사항 -->
            <div class="notice-box">
              <div><p><i class="fa-regular fa-bell"></i> 공지사항
               <a href="${contextPath}/board/list?type=1"><i class="fa-solid fa-angles-right" id="link"></i></a></p>
              </div>
              <div>
                <table class="notice-content">
                  <thead>
                    <tr>
                      <th>제목</th>
                      <th>조회수</th>
                    </tr>
                  </thead>
                  <tbody id="noticeTbody"></tbody>
                </table>
              </div>
            </div>
            <!-- 인기글 -->
            <div class="fave-box">
              <div><p><i class="fa-regular fa-thumbs-up"></i> 인기글   
              <a href="${contextPath}/board/popularBoard?sortBy=like"> <i class="fa-solid fa-angles-right" id="link"></i></a></p></div>
              <div>
                <table class="fave-content">
                  <thead>
                    <tr>
                      <th>제목</th>
                      <th>조회수</th>
                    </tr>
                  </thead>
                  <tbody id="popularTbody"></tbody>
                </table>
              </div>
            </div>
          </section>

          <!-- 날씨 -->
         <%-- <section class="weather">
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
         </section> --%>
          
          
          
       <%--
          <section class="weather">
            <div class="box">
              <!-- 첫번째 사장 -->
              <div class="FirstBox">
                <h1 class="date"></h1>
              </div>
              <!-- 두번째 상자 -->
              <div class="SecondBox">
              <div class = "secondBox-1">
                  <div class="cicon"></div>
                </div>
                <div class = "secondBox-2">
                <div class="ctemp"></div>
                <div class="main"></div>
                <div class="name"></div>
               </div>
               </div>
               <!-- 세번째 상자 -->
                 <div class="thirdBox">
                 <div class="wi">
                 <a href="${contextPath}">
      			<img src="${contextPath}/resources/images/wind.png" id="wind-logo" />
    			</a>
                 <div class="speed"></div>
                 </div>
                 <div class = "hu">
				<a href="${contextPath}">
      			<img src="${contextPath}/resources/images/humidity.png" id="humidity-logo" />
    			</a>
    			<div class="humidity"></div>
				</div>
                <div class="mi">
                <a href="${contextPath}">
      			<img src="${contextPath}/resources/images/dust.png" id="aqi-logo" />
    			</a>
                  <div class="aqi"></div>
                  </div>
                </div>
             
            </div>
          </section>
          --%>
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
   <script defer src="https://use.fontawesome.com/releases/v5.15.2/js/all.js" integrity="sha384-vuFJ2JiSdUpXLKGK+tDteQZBqNlMwAjhZ3TvPaDfN9QmbPb7Q8qUpbSNapQev3YF" crossorigin="anonymous"></script>
    

    <!-- main.js 연결 -->
    <!-- <script src="${pageContext.request.contextPath}/resources/js/main.js"></script> -->

    <script src="${contextPath}/resources/js/mainPage-MapAPI.js"></script>
    <script src="${contextPath}/resources/js/mainPage.js"></script>
  </body>
</html>
