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
    href="${contextPath}/resources/css/boardDetail.css"
    />

    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>   
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
          	<div id="boardContainer">
          		게시글조회 확인용
          		
          		
          		
          		<span>제목 : ${board.boardTitle}</span> <br>
          		<span>작성자 : ${board.userNickname}</span><br>
          		<span>내용 : ${board.boardContent}</span>
          		<span>작성일 : ${board.boardCreateDate}</span>
          		<span>조회수 : ${board.readCount}</span>
          		<span>좋아요수 : ${board.likeCount}</span>
          		<span>카테고리 : ${board.categoryName}</span>
          		<img src="${contextPath}/webapp/${board.boardImg}" alt="게시글 이미지">
          		
          		<p>조회수 좋아요수 작성일 </p>
            
          		<c:if test="${loginUser.userNickname == board.userNickname}">
          			<button type="button" id="writeBtn" onclick="location.href='${contextPath}/board/writeBoard?mode=update&boardNo=${board.boardNo}'" >수정</button>
          			<a href="${contextPath}/board/deleteBoard?boardNo=${board.boardNo}" id="deleteBoard">삭제</a>
          		</c:if>
            
          		<c:if test="${loginUser != null}"> 
          			<a href="${contextPath}/board/like?boardNo=${board.boardNo}" id="like">좋아요</a>				
          		</c:if>
          	</div>
          	
          	
          	
          	<div id="commentContainer">
          		<c:choose>
          			<c:when test="${empty commentList}">
          				<div>
          					<hr>
          				</div>
          			</c:when>
          		
          			<c:otherwise>
          				<c:forEach var="comment" items="${commentList}">
          					
          					<div class="commentDetail">
          						
          						<div><img src="${contextPath}${comment.profileImg}"></div>
          						<div>
          							<span>${comment.userNickname}</span><br>
          							<span>${comment.commentContent}</span><br>
          							<span>${comment.commentCreateDate}</span>
          						</div>
          						<c:if test="${loginUser.userNickname == comment.userNickname}">
          							<div>
          								<button type="button">수정</button>&nbsp;&nbsp;
          								<a href="${contextPath}/comment/deleteComment?commentNo=${comment.commentNo}&userNo=${loginUser.userNo}&boardNo=${board.boardNo}">삭제</a>
          							</div>
          						</c:if>
          						
          					</div>
          				</c:forEach>
          			</c:otherwise>
          		</c:choose>
          	</div>
          	
          	<c:if test="${loginUser != null}">          		
          		<div>
          			
          			<br><hr>
          			<form action="${contextPath}/comment/insertComment?boardNo=${board.boardNo}&userNo=${loginUser.userNo}" method="post">
          				<div class="insertComment">
          				<div>
          					<textarea id="commentContent" name="commentContent" ></textarea>
          				</div>
          				<div>
          					<button id="insertCommentBtn">댓글 등록</button>
          				</div>
          				</div>
          			</form>
          		</div>
          			
          	</c:if>
            
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
  
      <!-- main.js 연결 -->
      <!-- <script src="${pageContext.request.contextPath}/resources/js/main.js"></script> -->

</body>
</html>