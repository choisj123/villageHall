<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>


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
    
    <link
    rel="stylesheet"
    href="${contextPath}/resources/css/popularBoard.css"
    />
    

    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>   
    
    <script src="${contextPath}/resources/js/popularBoard.js"></script>
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
          <h2>인기게시판</h2>          
          	<form id="sortBy">
            	<select id="sortBySelect" name="sortBy" onchange="this.form.submit()">
             		<option value="like">좋아요순</option>
              		<option value="read">조회수순</option>              		
            	</select>
            </form>
          
          
          <div id="popularBoard">
          	<table class="popularBoardTable">
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
          		
          		<tbody id="popularBoardList">
          			<c:choose>
          				<c:when test="${empty boardList}">
	                		<tr>
	                			<th colspan="6">게시글이 존재하지 않습니다.</th>
	                		</tr>
	                	</c:when>
	                	
	                	<c:otherwise>
	                		<c:forEach var="board" items="${boardList}">
	                			<tr>
	                				<td>${board.boardNo}</td>
	                				<td><a href="${contextPath}/board/boardDetail?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
	                				<td>${board.boardCreateDate}</td>
	                				<td>${board.userNickname}</td>
	                				<td>${board.readCount}</td>
	                				<td>${board.likeCount}</td>
	                			</tr>
	                		</c:forEach>
	                	</c:otherwise>
          			</c:choose>
          		</tbody>
          	</table>
          </div>
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

		
</body>
</html>