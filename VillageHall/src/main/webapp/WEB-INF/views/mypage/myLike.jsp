<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마을회관</title>

    <link
    rel="stylesheet"
    href="${contextPath}/resources/css/main.css"
    />
    
    <link rel="stylesheet"
    href= "${contextPath}/resources/css/myPage-myBoard.css" />

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
  
          <!-- 메인 콘텐츠------------------------- -->
          <section class="right-body">
          
            <h2>마이페이지</h2>
          <hr>
          <!-- 탭 메뉴 -->
          <div class="tab">
            <a href="${contextPath}/mypage/myBoard"> 내 글</a>
          	<a href="${contextPath}/mypage/myComment"> 내 댓글</a>
          	<a href="${contextPath}/mypage/myLike"> 내 좋아요</a>

            <div class="tabContent">
              <h3>내 좋아요</h3>
              <table class="likeTable">
                <thead>
                  <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>작성자</th>
                    <th>조회</th>
                    <th>좋아요</th>
                  </tr>
                </thead>

                <tbody>
                  <tr>
                    <td>1231</td>
                    <td><a href="#">여기는 데이터불러오는 걸로 수정필요</a></td>
                    <td>2023.03.04</td>
                    <td>역삼불주먹</td>
                    <td>1181</td>
                    <td>18</td>
                  </tr>
                  <tr>
                    <td>993</td>
                    <td><a href="#">테스트2</a></td>
                    <td>2023.02.08</td>
                    <td>고양이만세</td>
                    <td>111</td>
                    <td>19</td>
                  </tr>
                  <tr>
                    <td>951</td>
                    <td><a href="#">가나다라마바사</a></td>
                    <td>2023.01.14</td>
                    <td>민수짱123</td>
                    <td>141</td>
                    <td>58</td>
                  </tr>
                  <tr>
                    <td>831</td>
                    <td><a href="#">새해복 많이받으세요</a></td>
                    <td>2023.01.01</td>
                    <td>개발하조만세</td>
                    <td>11</td>
                    <td>11</td>
                  </tr>
                  <tr>
                    <td>777</td>
                    <td><a href="#">맛집추천좀해주세요</a></td>
                    <td>2022.11.12</td>
                    <td>아이디도일이다</td>
                    <td>181</td>
                    <td>98</td>
                  </tr>
                  <tr>
                    <td>556</td>
                    <td><a href="#">할말이없다</a></td>
                    <td>2022.08.24</td>
                    <td>가나다라마바</td>
                    <td>111</td>
                    <td>8</td>
                  </tr>
                  <tr>
                    <td>512</td>
                    <td>
                      <a href="#">2호선 시위때문에 다들 일찍 출발하세요</a>
                    </td>
                    <td>2022.06.03</td>
                    <td>티없이맑은눈</td>
                    <td>121</td>
                    <td>12</td>
                  </tr>
                  <tr>
                    <td>323</td>
                    <td><a href="#">역삼역 맛집 정보</a></td>
                    <td>2022.05.14</td>
                    <td>캣캣캣캣</td>
                    <td>11</td>
                    <td>1</td>
                  </tr>
                  <tr>
                    <td>123</td>
                    <td><a href="#">가입했습니다 ^^</a></td>
                    <td>2022.03.04</td>
                    <td>작성자만세</td>
                    <td>111</td>
                    <td>8</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          </section>
          <!-- 메인 콘텐츠 종료-------------------------------------- -->
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
      <script src="${contextPath}/resources/js/myPage-myBoard.js"></script>

</body>
</html>