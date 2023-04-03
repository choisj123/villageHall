<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>마을회관</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/write.css" />

    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>

    <script
      src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
      integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
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
          <form>
            <h2>글 작성</h2>
            <hr />
            <label>태그 </label>
            <select id="tag">
              <option name="tag" value="issue" id="issue">이슈</option>
              <option name="tag" value="delicious" id="delicious">맛집</option>
              <option name="tag" value="hobby" id="hobby">취미</option>
              <option name="tag" value="friend" id="friend">친목</option>
              <option name="tag" value="recommend" id="recommend">추천</option>
              <option name="tag" value="etc" id="etc" selected>기타</option>
            </select>
            <input
              type="text"
              name="title"
              id="title"
              placeholder="제목을 입력해주세요"
              size="125px"
            />
            <div id="summernote"></div>

            <button type="button" id="reset">취소</button>
            <button type="button" id="saveBtn">등록</button>
          </form>
        </section>
      </section>
    </main>

	 <!-- footer include -->
      <jsp:include page="/WEB-INF/views/common/footer.jsp" />
  
      <!-- jQuery 라이브러리 추가 -->
      <script
        src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"
      ></script>

    <script src="${contextPath}/resources/js/mainPage.js"></script>
    <script src="${contextPath}/resources/js/write.js"></script>
  </body>
</html>
