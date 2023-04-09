<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
          		</div>

            	<div class="tabContent">
              		<h3>내 좋아요</h3>
              		<table class="likeTable">
                		<thead>
                  			<tr>
                    			<th>카테고리</th>
                    			<th>제목</th>
                    			<th>작성일</th>
                    			<th>작성자</th>
                    			<th>조회</th>
                    			<th>좋아요</th>
                  			</tr>
                		</thead>

                		<tbody id="myLikeList">
                			<c:choose>
                				<c:when test="${empty boardList}">
                					<tr>
                						<th colspan="6">좋아요를 누른 게시글이 존재하지 않습니다.</th>
                					</tr>
                				</c:when>
                		
                				<c:otherwise>
                					<c:forEach var="board" items="${boardList}">
                						<tr>
                							<td>${board.categoryName}</td>
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
            	
            	<div class="pagination-area">

                <!-- 페이지네이션 a태그에 사용될 공통 주소를 저장한 변수 선언 -->
                <c:set var="url" value="myLike?cp="/>


                <ul class="pagination">
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="${url}1${sURL}">&lt;&lt;</a></li>

                    <!-- 이전 목록 마지막 번호로 이동 -->
                    <li><a href="${url}${pagination.prevPage}${sURL}">&lt;</a></li>

                    <!-- 범위가 정해진 일반 for문 사용 -->
                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">

                        <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                <li><a class="current">${i}</a></li>
                            </c:when>

                            <c:otherwise>
                                <li><a href="${url}${i}${sURL}">${i}</a></li>        
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                    
                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="${url}${pagination.nextPage}${sURL}">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="${url}${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

                </ul>
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
        crossorigin="anonymous"></script>
  
    <!-- main.js 연결 -->
    <!-- <script src="${pageContext.request.contextPath}/resources/js/main.js"></script> -->
	<script src="${contextPath}/resources/js/myPage-myBoard.js"></script>

</body>
</html>