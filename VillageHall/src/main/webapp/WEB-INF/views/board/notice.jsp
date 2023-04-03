<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마을회관</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/notice.css"/>

    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/2f1bf0eac7.js"crossorigin="anonymous"></script>   
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
          
            <h3 id="Notice-name">공지사항</h3>
            <hr>
              <div id="myContent" class="tabcontent">
  
                <ul class="Notice-Ul">
                  <li>글번호</li>
                  <li class="cell">제목</li>
                  <li class="cell">작성일</li>
                  <li class="cell">조회</li>
                  <li class="cell">좋아요</li>
                </ul>
                
                <ul class="Notice-Ul Notice-Ul1">
                  <li>1231</li>
                  <li>개인정보처리방침 개정 내용 사전안내</li>
                  <li>2020.12.02</li>
                  <li>19</li>
                  <li>19</li>
                </ul>
                <div class="p">
                    <p>
                      <strong>개인정보보호위원회 <개인정보보호 포털> 개인정보 처리방침</strong>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
                
                <ul class="Notice-Ul Notice-Ul1">
                  <li>993</li>
                  <li>위치기반 서비스 개정 내용 사전안내</li>
                  <li>2020.12.02</li>
                  <li>19</li>
                  <li>19</li>
                </ul>
                <div class="p">
                    <p>
                      <strong>마을회관 <이용약관의 효력 및 변경> 위치기반서비스</strong>
                      <hr>
                      본 약관은 회원(마을회관 위치기반서비스 약관에 동의한 자를 말합니다)<br>
                      이 본 홈페이지 마을회관이 제공하는 위치기반서비스(이하 "서비스"라고 합니다) 를<br>
                      이용함에 있어 운영자와 회원의 권리·의무 및 책임사항을 규정함을 목적으로 합니다.
                      <hr>
                    </p>
                </div>
                
                <ul class="Notice-Ul Notice-Ul1">
                  <li>951</li>
                  <li>서비스 점검 시간 사전 안내</li>
                  <li>2020.12.02</li>
                  <li>19</li>
                  <li>19</li>
                </ul>
                <div class="p">
                  
                  <p>
                    <strong>개인정보보호위원회 <개인정보보호 포털> 개인정보 처리방침</strong>
                    <hr>
                    개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                    관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                    이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                    기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                    다음과 같이 개인정보 처리방침을 수립·공개합니다.
                    <hr>
                  </p>
                
              </div>
  
                <ul class="Notice-Ul Notice-Ul1">
                  <li>831</li>
                  <li>인터넷 익스플로러(IE) 지원 종료 안내</li>
                  <li>2020.12.02</li>
                  <li>19</li>
                  <li>19</li>
                </ul>
                <div class="p">
                  
                  <p>
                    <strong>개인정보보호위원회 <개인정보보호 포털> 개인정보 처리방침</strong>
                    <hr>
                    개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                    관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                    이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                    기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                    다음과 같이 개인정보 처리방침을 수립·공개합니다.
                    <hr>
                  </p>
                
              </div>
  
                <ul class="Notice-Ul Notice-Ul1">
                  <li>556</li>
                  <li>저작권 도용 관련 게시글 안내 공지</li>
                  <li>2020.12.02</li>
                  <li>19</li>
                  <li>19</li>
                </ul>
                <div class="p">
                  
                  <p>
                    <strong>개인정보보호위원회 <개인정보보호 포털> 개인정보 처리방침</strong>
                    <hr>
                    개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                    관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                    이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                    기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                    다음과 같이 개인정보 처리방침을 수립·공개합니다.
                    <hr>
                  </p>
                
              </div>
  
                <ul class="Notice-Ul Notice-Ul1">
                  <li>512</li>
                  <li>5년 이상 미사용 계정 휴면처리 안내 공지</li>
                  <li>2020.12.02</li>
                  <li>19</li>
                  <li>19</li>
                </ul>
                <div class="p">
                  
                  <p>
                    <strong>개인정보보호위원회 <개인정보보호 포털> 개인정보 처리방침</strong>
                    <hr>
                    개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                    관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                    이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                    기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                    다음과 같이 개인정보 처리방침을 수립·공개합니다.
                    <hr>
                  </p>
              </div>
                <ul class="Notice-Ul Notice-Ul1" >
                  <li>323</li>
                  <li>서비스 점검 시간 사전 안내(~12/20)</li>
                  <li>2020.12.02</li>
                  <li>19</li>
                  <li>19</li>
                </ul>
                <div class="p">
                  <p>
                    <strong>개인정보보호위원회 <개인정보보호 포털> 개인정보 처리방침</strong>
                    <hr>
                    개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                    관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                    이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                    기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                    다음과 같이 개인정보 처리방침을 수립·공개합니다.
                    <hr>
                  </p>
              </div>
              </div>
            </div>  
          </section>
        </section>
      </main>
  
      <!-- footer include -->
      <jsp:include page="/WEB-INF/views/common/footer.jsp" />
  
      <!-- jQuery 라이브러리 추가 -->
      <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  
      <!-- notice.js 연결 -->
      <script src="${pageContext.request.contextPath}/resources/js/notice.js"></script>

</body>
</html>