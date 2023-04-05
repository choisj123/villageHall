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
    <link rel="stylesheet" href="${contextPath}/resources/css/writeBoard.css" />

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
            <h2>글 작성</h2>
          <form action="write" enctype="multipart/form-data" method="POST" class="board-write"
            onsubmit="return writeValidate()">
            <hr />
            <select name="category" class="category">
              <option>카테고리</option>
              <option value="이슈" id="issue">이슈</option>
              <option value="맛집" id="delicious">맛집</option>
              <option value="취미" id="hobby">취미</option>
              <option value="친목" id="friend">친목</option>
              <option value="추천" id="recommend">추천</option>
              <option value="기타" id="etc">기타</option>
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
                <button type="submit" id="writebtn">등록</button>
                <!-- insert 모드 -->
                <c:if test="${param.mode == 'insert'}">
                    <button type="button" id="goToListBtn">목록으로</button>
                </c:if>
                <!-- update 모드 -->
                <c:if test="${param.mode == 'update'}">
                    <button type="button" onclick="location.href='${header.referer}'">이전으로</button>                           
                </c:if>
            </div>
            
            <!-- 숨겨진 값(hidden) -->
            <!-- 동작 구분 -->
            <input type="hidden" name="mode" value="${param.mode}">

            <!-- 게시판 구분 -->
            <input type="hidden" name="type" value="${param.type}">

            <!-- 게시글 번호 -->
            <input type="hidden" name="no" value="${param.no}">
            
            <!-- 현재 페이지 -->
            <input type="hidden" name="cp" value="${param.cp}">
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
