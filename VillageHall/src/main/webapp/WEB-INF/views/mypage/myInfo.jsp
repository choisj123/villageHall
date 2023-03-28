<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="${contextPath}/resources/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-myInfo.css" />
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=af34b09f8f2cdee07cf990ab549e6220"
    ></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=af34b09f8f2cdee07cf990ab549e6220&libraries=LIBRARY"
    ></script>
    <script
      src="https://kit.fontawesome.com/2f1bf0eac7.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <main>
      
      <jsp:include page="/WEB-INF/views/common/header.jsp" />

      <!-- 바디 부분 시작 -->
      <section class="body">
      
     	 <jsp:include page="/WEB-INF/views/common/leftBody.jsp" />
		

        <!-- 메인 콘텐츠 -->
        <section class="right-body">
          <h2>마이페이지</h2>
          <hr />
          <div class="myPage-box">
            <div>내 정보 수정</div>
            <form action="#" method="post">
              <div id="myPage-content">
                <table>
                  <tr>
                    <td>
                      <tr colspan="3">
                        <label for="profile-image">프로필 사진 변경</label>
                        <input type="image" id="profile-image" />
                        <br />
                      </tr>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="3">
                      <button type="submit">프로필 사진 변경</button><br />
                    </td>
                  </tr>
                  <tr>
                    <td>닉네임</td>
                    <td>
                      <input type="text" />
                    </td>
                    <td><button type="submit">중복 확인</button><br /></td>
                  </tr>
                  <tr>
                    <td>비밀번호</td>
                    <td><input type="password" /> <br /></td>
                  </tr>
                  <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="password" /> <br /><br /></td>
                  </tr>
                  <tr>
                    <td colspan="3">
                      <button type="submit" id="updateMyInfo">
                        회원정보 수정
                      </button>
                    </td>
                  </tr>
                </table>
              </div>
              <div></div>
            </form>
          </div>
        </section>
      </section>
    </main>

    <!-- 푸터 -->

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="/js/myPage.js"></script>
    
        <script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"
    ></script>
  </body>
</html>