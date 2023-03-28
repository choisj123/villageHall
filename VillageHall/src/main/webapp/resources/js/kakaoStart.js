Kakao.init('34ad775971ebe3c5fd57f7e310f7c21c'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
  window.Kakao.Auth.login({
      scope: 'profile_nickname,	profile_image,account_email', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
      success: function(response) {
          console.log(response) // 로그인 성공하면 받아오는 데이터
          window.Kakao.API.request({ // 사용자 정보 가져오기 
              url: '/v2/user/me',
              success: (res) => {
                  const kakao_account = res.kakao_account;
                  console.log(kakao_account)
              }
          });
          // window.location.href='/ex/kakao_login.html' //리다이렉트 되는 코드
      },
      fail: function(error) {
          console.log(error);
      }
  });
}