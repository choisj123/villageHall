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

            <div id="myContent" class="tabContent">
              <h3>내 글 목록</h3>
              <table class="contentTable">
                <thead>
                  <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>조회</th>
                    <th>좋아요</th>
                  </tr>
                </thead>

                <tbody id="myBoardList">
                  
                </tbody>

<!-- 페이징용 tfoot -->
                <tfoot>
                  <tr>
                    <td colspan="5">
                      <div id="pagination"></div>
                    </td>
                  </tr>
                </tfoot>
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