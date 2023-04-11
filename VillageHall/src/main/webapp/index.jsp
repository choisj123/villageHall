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
          <section>
            <div>
              <label for="category" class="category">카테고리:</label>
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
            </div>

            <div class="map-wrap">
              <div
                id="map"
                style="width: auto; height: 500px; margin-left: 15px"
              >
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
              <a href="${contextPath}/board/popularBoard?sortBy=like" name="link" type="hidden"><i class="fa-solid fa-angles-right" id="link" for="link"></i></a>
              </p></div>
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
          <section class="weather">
            <div class="box">
              <!-- 날짜 -->
              <div class="FirstBox">
                <h1 class="date"> 오늘의날씨</h1>
              </div>
              <!-- 날씨 입력 -->
              <div class="SecondBox">
                <div class="Sbox1">
                  <div class="cicon"></div>
                  <div class="main"></div>
                </div>
                <div class="ctemp"><h4>현재온도</h4></div>
                <div class="clowtemp"><h4>최저온도</h4></div>
                <div class="humidity"><h4>습도</h4></div>
                <div class="mi">
                  <h4>미세먼지</h4>
                  <div class="aqi"></div>
                </div>
              </div>
            </div>
          </section>
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

    <!-- main.js 연결 -->
    <!-- <script src="${pageContext.request.contextPath}/resources/js/main.js"></script> -->

    <script src="${contextPath}/resources/js/mainPage-MapAPI.js"></script>
    <script src="${contextPath}/resources/js/mainPage.js"></script>
    <script src="${contextPath}/resources/js/weather.js"></script>
  </body>
</html>
