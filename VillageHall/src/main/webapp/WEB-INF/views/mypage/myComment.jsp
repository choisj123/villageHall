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
    <script src="https://kit.fontawesome.com/2f1bf0eac7.js" crossorigin="anonymous"></script>  
</head>
<body>
    <main>
        <!-- header include -->
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
				</div>
				<!--  내 댓글 목록 리스트 -->
            	<div id="myComment" class="tabContent">
              		<h3>내 댓글</h3>
              		<table class="commentTable">
                		<tbody id="myCommentList">
                			<c:choose>
                				<c:when test="${empty commentList}">
                					<tr>
                						<th>댓글이 존재하지 않습니다.</th>
                					</tr>
                				</c:when>
                		
                				<c:otherwise>
                					<c:forEach var="comment" items="${commentList}">
                						<tr>
                							<td>
                								<a href="#">
                									<span>${comment.commentContent}</span><br>
                									<span>${comment.commentCreateDate}</span><br>
                									<span>${comment.boardTitle}</span><br>
                								</a>
                								<hr>
                							</td>
                						</tr>
                					</c:forEach>
                				</c:otherwise>
                			</c:choose>                  
                		</tbody>
              		</table>
            	</div>            	          
          	</section>
          	<!-- 메인 콘텐츠 종료-------------------------------------- -->
        </section>
	</main>
  
    <!-- footer include -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
  
    <!-- jQuery 라이브러리 추가 -->
    <script
        src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
  
    <!-- main.js 연결 -->
    <!-- <script src="${pageContext.request.contextPath}/resources/js/main.js"></script> -->
    <script src="${contextPath}/resources/js/myPage-myBoard.js"></script>

</body>
</html>