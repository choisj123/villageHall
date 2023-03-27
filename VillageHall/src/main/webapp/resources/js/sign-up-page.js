/************* 카카오 api 추가************************** */

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



//회원가입시 유효성검사

/***********************이메일 확인 *********************/
/*
    1. 중복된 이메일인 경우
    인증번호 발송 안함

    2. 신규 이메일인 경우 
    인증번호 발송

*/


/***********************이메일 인증 *********************/
/*
    1. 인증 번호 일치X
    인증번호 재확인  --->빨간색 글자 

    2. 인증 번호 일치O
    인증번호가 확인되었습니다. ---> 초록색 글자 

*/



/**************비밀번호 8~16자 영문 대 소문자, 숫자, 특수문자를 사용************/
/*
    1. 일치X 
       " 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요." 를 빨간색 글자

       
    2. 일치O
       "사용 가능합니다." 초록색 글자 
*/

document.getElementById("pw1").addEventListener("keyup",function(){

    const regEx1 = /^[A-Za-z0-9!@#$%^&*]{8,}$/;

    const result1 = document.getElementById("result1");

    if(regEx1.test(this.value)){
        result1.innerText = "안전한 비밀번호 입니다."

        result1.classList.add("confirm");
        result1.classList.remove("error"); 
        pw1.style.borderColor="rgb(240, 244, 240)";

    } else{
        result1.innerText = "8~16자 영문 대 소문자, 숫자, 특수문자를 입력하세요"

        result1.classList.add("error");
        result1.classList.remove("confirm"); 
        pw1.style.borderColor="red";
 
    }

    if(pw1.value==pw2.value){

        result2.innerText = "비밀번호가 일치합니다."

        result2.classList.add("confirm");
        result2.classList.remove("error"); 
        pw2.style.borderColor="rgb(240, 244, 240)";    

    } else{
        result2.innerText = "비밀번호가 일치하지 않습니다."
        result2.classList.add("error");
        result2.classList.remove("confirm"); 
        pw2.style.borderColor="red";
 
    }
})

/*************************비밀번호 일치 / 불일치 **********************/
/*
    1. 일치X
        비밀번호가 일치하지 않습니다.  ---> 빨간색 글씨 

    2. 일치O 
        확인 완료  ----> 초록색 글씨 

*/

document.getElementById("pw2").addEventListener("keyup",function(){

    const result2 = document.getElementById("result2"); 
    const  pw1 = document.getElementById('pw1');
    const  pw2 = document.getElementById('pw2');

    if(pw1.value==pw2.value){

        result2.innerText = "비밀번호가 일치합니다."

        result2.classList.add("confirm");
        result2.classList.remove("error"); 
        pw2.style.borderColor="rgb(240, 244, 240)";    

    } else{
        result2.innerText = "비밀번호가 일치하지 않습니다."
        result2.classList.add("error");
        result2.classList.remove("confirm"); 
        pw2.style.borderColor="red";
 
    }

})



/* 닉네임 */


/* 프로필 사진 */

