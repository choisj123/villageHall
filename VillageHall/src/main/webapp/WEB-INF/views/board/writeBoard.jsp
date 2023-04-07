<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.*,java.util.*" %>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>마을회관</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/writeBoard.css" />

    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>

    <script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"
    ></script>
    <link
      href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  </head>
  <body>
    <main>
    	<!-- header include -->
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
     

      <!-- 바디 부분 시작 -->
      <section class="body">
        
         <jsp:include page="/WEB-INF/views/common/leftBody.jsp" /> 

        <!-- 메인 콘텐츠 -->
        <section class="right-body">
            <h2>글 작성</h2>
          <form action="${contextPath}/board/writeBoard" method="POST" class="board-write"
            onsubmit="return writeValidate()">
            <hr />
<%
HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();


  double latitude = 0.0;
  double longitude = 0.0;
  
  String latStr = req.getParameter("latitude");
  System.out.println("jsp : " + latitude);
  String lngStr = req.getParameter("longitude");
  System.out.println("jsp : " + longitude);
  
  if (latStr != null && !latStr.isEmpty()) {
    latitude = Double.parseDouble(latStr);
  }
  
  if (lngStr != null && !lngStr.isEmpty()) {
    longitude = Double.parseDouble(lngStr);
  }
%>



<p>latitude: <%= latitude %></p>
<p>longitude: <%= longitude %></p>

    <input type="hidden" name="latitude" value="<%= latitude %>" />
    <input type="hidden" name="longitude" value="<%= longitude %>" />
            
            <select name="category" id="category">
              <option value="">카테고리</option>
              <option value="3" id="issue">이슈 🔍️</option>
              <option value="4" id="delicious">맛집 🍽️</option>
              <option value="5" id="hobby">취미 🏂 </option>
              <option value="6" id="friend">친목 👫</option>
              <option value="7" id="recommend">추천 👍</option>
              <option value="8" id="etc">기타 😎</option>
            </select>
            <input
              type="text"
              name="boardTitle"
              id="boardTitle"
              placeholder="제목을 입력해주세요"
              size="125px"
            />
       
            <textarea id="summernote" name="boardContent"></textarea>
            <!-- 버튼 영역 -->
            <div class="board-btn-area">
                <button type="submit" id="writebtn" onclick="saveContent(this.form)">등록</button>
                    <button type="button" id="goToListBtn">목록으로</button>
                    <c:if test ="">
                    <button type="button" onclick="location.href='${header.referer}'">이전으로</button>          
                    </c:if>                 
            </div>
          </form>
        </section>
      </section>
    </main>
    
	 <!-- footer include -->
      <jsp:include page="/WEB-INF/views/common/footer.jsp" />
  
    
    <script src="${contextPath}/resources/js/mainPage.js"></script>
    <script src="${contextPath}/resources/js/writeBoard.js"></script>
  </body>
</html>
