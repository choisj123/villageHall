<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마을회관</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/FAQ.css"/>

    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/2f1bf0eac7.js" crossorigin="anonymous"></script>
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
           
          <!--FAQ 질문 검색 부분-->
          <article class="FAQ-search">
            <!--FAQ 질문 검색창-->
            <form action="#" name="FAQ-search-form">
              <h3 class="FAQ-text">FAQ 자주 묻는 질문</h3>

              <fieldset class="FAQ-search-fieldset">
                <input
                  type="search"
                  id="query"
                  name="query"
                  autocomplete="off"
                  placeholder="무엇이 궁금하실까요?"
                />

                <!--FAQ 질문 검색버튼-->
                <button
                  id="FAQ-search-btn"
                  class="fa-solid fa-magnifying-glass"
                ></button>
              </fieldset>
            </form>

            <!--FAQ 카테고리-->
          </article>

          <article class="category-article">
            <a href="#" class="category" data-tab="signUp"> 회원가입 </a>
            <a href="#" class="category" data-tab="logIn"> 로그인 </a>
            <a href="#" class="category" data-tab="content"> 게시글 </a>
            <a href="#" class="category" data-tab="etc"> 기타 </a>
          </article>

          <article class="FAQ-board-article">

            <div class="FAQ-board" id="signUp">
                  <ul class="FAQ-Ul">

                    <li> 구분</li>
                    <li> 제목</li>
                    <li> 작성일</li>
                    <li> 조회</li>
                    <li> 좋아요</li>
    
                  </ul>
                  <hr>
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li> 회원 탈퇴를 취소하고 싶습니다.</li>
                    <li>2020.01.23</li>
                    <li>3578</li>
                    <li>77</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>       
                </div>
  
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li> 회원 탈퇴는 어떻게 하나요?</li>
                    <li>2020.01.23</li>
                    <li>3239</li>
                    <li>89</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
    
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li> 메인 로그인이 안됩니다.</li>
                    <li>2021.10.21</li>
                    <li>2280</li>
                    <li>56</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
    
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li>소셜 로그인(카카오) 연동을 해제하고 싶어요</li>
                    <li>2021.11.23</li>
                    <li>1120</li>
                    <li>80</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
  
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li>아이디와 비밀번호가 기억나지 않아요</li>
                    <li>2021.11.30</li>
                    <li>1002</li>
                    <li>78</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
    
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li>회원정보 수정은 어디서 하나요?</li>
                    <li>2021.09.11</li>
                    <li>998</li>
                    <li>76</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
    
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li>비밀번호 변경은 어디서 하나요?</li>
                    <li>2022.02.22</li>
                    <li>865</li>
                    <li>43</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
    
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li>이메일 인증 시 이미 존재해나는 이메일이라고 <br>
                      뜰 때는 어떻게 해야하나요?</li>
                    <li>2022.06.23</li>
                    <li>724</li>
                    <li>27</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
    
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li>본인 인증이 안되는 경우에는 어떻게 해야하나요?</li>
                    <li>2022.06.23</li>
                    <li>665</li>
                    <li>21</li>
                  </ul>
                  <div class="p">
                    <p>
                      <hr>
                      개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                      관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                      이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                      기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                      다음과 같이 개인정보 처리방침을 수립·공개합니다.
                      <hr>
                    </p>              
                </div>
    
                  <ul class="FAQ-Ul FAQ-Ul1">
                    <li><strong>가입/인증</strong></li>
                    <li>본인 인증을 잘못했는데 초기화 가능한가요?</li>
                    <li>2022.11.23</li>
                    <li>332</li>
                    <li>64</li>
                  </ul>
                  <div class="p">
                    <p>
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

            <div class="FAQ-board" id="logIn">
              <ul class="FAQ-Ul">

                <li> 구분</li>
                <li> 제목</li>
                <li> 작성일</li>
                <li> 조회</li>
                <li> 좋아요</li>

              </ul>
              <hr>
              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li> 회원 탈퇴를 취소하고 싶습니다.</li>
                <li>2020.01.23</li>
                <li>3578</li>
                <li>77</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>    
                </div>          

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li> 회원 탈퇴는 어떻게 하나요?</li>
                <li>2020.01.23</li>
                <li>3239</li>
                <li>89</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
            </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li> 메인 로그인이 안됩니다.</li>
                <li>2021.10.21</li>
                <li>2280</li>
                <li>56</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
            </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>소셜 로그인(카카오) 연동을 해제하고 싶어요</li>
                <li>2021.11.23</li>
                <li>1120</li>
                <li>80</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
            </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>아이디와 비밀번호가 기억나지 않아요</li>
                <li>2021.11.30</li>
                <li>1002</li>
                <li>78</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
            </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>회원정보 수정은 어디서 하나요?</li>
                <li>2021.09.11</li>
                <li>998</li>
                <li>76</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
            </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>비밀번호 변경은 어디서 하나요?</li>
                <li>2022.02.22</li>
                <li>865</li>
                <li>43</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
            </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>이메일 인증 시 이미 존재해나는 이메일이라고 <br>
                  뜰 때는 어떻게 해야하나요?</li>
                <li>2022.06.23</li>
                <li>724</li>
                <li>27</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
            </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>본인 인증이 안되는 경우에는 어떻게 해야하나요?</li>
                <li>2022.06.23</li>
                <li>665</li>
                <li>21</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
            </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>본인 인증을 잘못했는데 초기화 가능한가요?</li>
                <li>2022.11.23</li>
                <li>332</li>
                <li>64</li>
              </ul>
              <div class="p">
                <p>
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
            
              <div class="FAQ-board" id="content">
                <ul class="FAQ-Ul">

                  <li> 구분</li>
                  <li> 제목</li>
                  <li> 작성일</li>
                  <li> 조회</li>
                  <li> 좋아요</li>

                </ul>
                <hr>
                <ul class="FAQ-Ul FAQ-Ul1">
                  <li><strong>탈퇴/기타</strong></li>
                  <li> 회원 탈퇴를 취소하고 싶습니다.</li>
                  <li>2020.01.23</li>
                  <li>3578</li>
                  <li>77</li>
                  </ul>
                <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>탈퇴/기타</strong></li>
                <li> 회원 탈퇴는 어떻게 하나요?</li>
                <li>2020.01.23</li>
                <li>3239</li>
                <li>89</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li> 메인 로그인이 안됩니다.</li>
                <li>2021.10.21</li>
                <li>2280</li>
                <li>56</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>소셜 로그인(카카오) 연동을 해제하고 싶어요</li>
                <li>2021.11.23</li>
                <li>1120</li>
                <li>80</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>아이디와 비밀번호가 기억나지 않아요</li>
                <li>2021.11.30</li>
                <li>1002</li>
                <li>78</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>회원정보 수정은 어디서 하나요?</li>
                <li>2021.09.11</li>
                <li>998</li>
                <li>76</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>로그인/정보</strong></li>
                <li>비밀번호 변경은 어디서 하나요?</li>
                <li>2022.02.22</li>
                <li>865</li>
                <li>43</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>가입/인증</strong></li>
                <li>이메일 인증 시 이미 존재해나는 이메일이라고 <br>
                  뜰 때는 어떻게 해야하나요?</li>
                <li>2022.06.23</li>
                <li>724</li>
                <li>27</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>가입/인증</strong></li>
                <li>본인 인증이 안되는 경우에는 어떻게 해야하나요?</li>
                <li>2022.06.23</li>
                <li>665</li>
                <li>21</li>
              </ul>
              <div class="p">
                <p>
                  <hr>
                  개인정보보호위원회는 정보주체의 자유와 권리 보호를 위해 ｢개인정보 보호법｣ 및 <br>
                  관계 법령이 정한 바를 준수하여, 적법하게 개인정보를 처리하고 안전하게 관리하고 있습니다.
                  이에 ｢개인정보 보호법｣ 제30조에 따라 정보주체에게 개인정보 처리에 관한 절차 및 <br>
                  기준을 안내하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 <br>
                  다음과 같이 개인정보 처리방침을 수립·공개합니다.
                  <hr>
                </p>              
              </div>

              <ul class="FAQ-Ul FAQ-Ul1">
                <li><strong>가입/인증</strong></li>
                <li>본인 인증을 잘못했는데 초기화 가능한가요?</li>
                <li>2022.11.23</li>
                <li>332</li>
                <li>64</li>
              </ul>
              <div class="p">
                <p>
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
            </article>
          </article>
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
  
      <!-- FAQ-page.js 연결 -->
      <script src="${contextPath}/resources/js/FAQ.js"></script>

</body>
</html>