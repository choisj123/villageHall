<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!-- map에 저장된 값을 각각 변수에 저장 -->
<c:set var="boardName" value="${map.boardName}" />
<c:set var="pagination" value="${map.pagination}" />
<c:set var="boardList" value="${map.boardList}" />


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
    href="${contextPath}/resources/css/boardList.css"
    />
    

    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.js" 
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" 
    crossorigin="anonymous"></script>   
</head>
<body>
    <main>
        <!-- header include -->
  
        <!-- 내부 접근 절대 경로 -->
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
  
        <!-- 바디 부분 시작 -->
        <section class="body">
          
          <jsp:include page="/WEB-INF/views/common/leftBody.jsp" />
          
          <%-- 검색을 진행한 경우 key, query를 쿼리스트링 형태로 저장한 변수 생성 --%>
        <c:if test="${!empty param.key}">
            <c:set var="sURL" value="&key=${param.key}&query=${param.query}" />
        </c:if>
          
          <!-- 메인 콘텐츠 -->
          <section class="right-body">
          
			<h2>${boardName}</h2>
			
			<c:if test="${!empty param.key}">
                <h3 style="margin-left:30px;"> "${param.query}" 검색 결과  </h3>
            </c:if>
			
          	<c:choose>
				<c:when test="${param.type == 1 || param.type == 3}">
					<div id="boardList">
          				<table class="boardListTable">
          					<thead>
          						<tr>
          							<th>카테고리</th>
	                    			<th>제목</th>	                    
	                    			<th>작성자</th>
	                    			<th>작성일</th>
	                    			<th>조회수</th>
	                    			<c:if test="${param.type == 3}">
	                    				<th>좋아요</th>
	                    			</c:if>	                    			
	               				</tr>
          					</thead>
          		
          					<tbody id="noticeBoardList">
          						<c:choose>
          							<c:when test="${empty boardList}">
	                					<tr>
	                						<c:choose>
	                							<c:when test="${param.type == 3}">
	                								<th colspan="6">게시글이 존재하지 않습니다.</th>
	                							</c:when>
	                							<c:otherwise>
	                								<th colspan="5">게시글이 존재하지 않습니다.</th>
	                							</c:otherwise>
	                						</c:choose>
	                						
	                					</tr>
	                				</c:when>
	                	
	                				<c:otherwise>
	                					<c:forEach var="board" items="${boardList}">
	                						<tr>
	                							<td>${board.categoryName}</td>	                				
	                							<td><a href="${contextPath}/board/boardDetail?boardNo=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">${board.boardTitle}</a></td>
	                							<td>${board.userNickname}</td>
	                							<td>${board.boardCreateDate}</td>	                				
	                							<td>${board.readCount}</td>
	                							<c:if test="${param.type == 3}">
	                								<td>${board.likeCount}</td>
	                							</c:if>	                							
	                						</tr>
	                					</c:forEach>
	                				</c:otherwise>
          						</c:choose>
          					</tbody>
          				</table>
          			</div>
				</c:when>
				
				
				<c:otherwise>
					<c:forEach var="board" items="${boardList}">
						<div class="FAQTitle">${board.boardTitle}</div>
                    	<p class="contents">${board.boardContent}</p>
                    			
					</c:forEach>
					
					<script>
        				$(function() {
            				$("div").on("click", function() {

                				if($(this).next("p").css("display") == 'none') {

                    				$(this).siblings("p.contents").slideUp();
                    				// 다음 요소는 내려라
                    				$(this).next().slideDown();

                				} else {
                    				$(this).next().slideUp();
                				}
                
            				});
        				});
    				</script>			
				</c:otherwise>
          	</c:choose>
          
            
            
         <div class="pagination-area">

                <!-- 페이지네이션 a태그에 사용될 공통 주소를 저장한 변수 선언 -->
                <c:set var="url" value="list?type=${param.type}&cp="/>


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
            
            
            <!-- /board/list?type=1&cp=3 -->

            <!-- /board/list?type=1&cp=10 &key=t&query=안녕 -->

 
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