console.log("signUp.js loaded");

/************* 카카오 api 추가************************** */
/*
Kakao.init('34ad775971ebe3c5fd57f7e310f7c21c'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
  window.Kakao.Auth.login({
      scope: 'profile_nickname,   profile_image,account_email', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
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
*/


// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
    "userEmail" : false, // 1) 정규표현식 이메일 형식(@) 맞는지 체크 
                           // 2) -> 맞으면 ajax 통신(중복검사)
                           // 3) 통과하면 true
    "userPw" : false, // 정규표현식 체크
    "userPwConfirm" : false, // 비밀번호랑 맞는지 체크
    "userNickname" : false, // 1) 정규표현식 닉네임 형식 맞는지 체크
                              // (영어/숫자/한글 2~10글자 사이) 
                              // 2) -> 맞으면 ajax 통신(중복검사)
                              // 3) 통과하면 true
    "userTel" : false, // 정규표현식 체크 + 중복검사(할 수 있으면)
    "sendEmail" : false
}

//*****************인증번호 발송********************************

// 인증번호 보내기
const sendBtn = document.getElementById("sendBtn");
const cMessage = document.getElementById("cMessage");

// 타이머에 사용될 변수
let checkInterval; // setInterval을 저장할 변수
let min = 4;
let sec = 59;

sendBtn.addEventListener("click", function(){

console.log("click");
    if( checkObj.userEmail ){ // 유효한 이메일이 작성되어 있을 경우에만 메일 보내기

        $.ajax({
            url : "sendEmail"  ,
            data : { "inputEmail" : userEmail.value },
            type : "GET",
            success : function(result){
                console.log("이메일 발송 성공");
                console.log(result);

                // 인증 버튼이 클릭되어 정상적으로 메일이 보내졌음을 checkObj에 기록
                checkObj.sendEmail = true;

            },
            error : function(){
                console.log("이메일 발송 실패")
            }
        });


        // Mail 발송 Ajax 코드는 동작이 느림....
        // -> 메일은 메일대로 보내고, 타이머는 버튼이 클릭 되자 마자 바로 실행
        // --> ajax 코드가 비동기이기 때문에 메일이 보내지는 것을 기다리지 않고
        //      바로 다음 코드가 수행된다!!

        // 5분 타이머
        // setInerval(함수, 지연시간) : 지연시간이 지난 후 함수를 수행 (반복)

        cMessage.innerText = "5:00"; // 초기값 5분
        min = 4;
        sec = 59; // 분, 초 초기화

        cMessage.classList.remove("confirm");
        cMessage.classList.remove("error");

        // 변수에 저장해야지 멈출 수 있음
        checkInterval = setInterval(function(){
            if(sec < 10) sec = "0" + sec;
            cMessage.innerText = min + ":" + sec;

            if(Number(sec) === 0){
                min--;
                sec = 59;
            }else{
                sec--;
            }

            if(min === -1){ // 만료
                cMessage.classList.add("error");
                cMessage.innerText = "인증번호가 만료되었습니다.";

                clearInterval(checkInterval); // checkInterval 반복을 지움
            }

        }, 1000); // 1초 지연 후 수행

        
        alert("인증번호가 발송되었습니다. 이메일을 확인해주세요.");
    }
});


// 인증번호 확인 클릭시에 대한 동작
const cNumber = document.getElementById("cNumber");
const cBtn = document.getElementById("cBtn");
// + cMessage, memberEmail 요소도 사용

cBtn.addEventListener("click", function(){

    // 1. 인증번호 받기 버튼이 클릭되어 이메일 발송되었는지 확인
    if(checkObj.sendEmail){

        // 2. 입력된 인증번호가 6자리가 맞는지 확인
        if( cNumber.value.length == 6 ){ // 6자리 맞음

            $.ajax({
                url : "checkNumber",
                data : { "cNumber" : cNumber.value,
                         "inputEmail" : userEmail.value },
                type : "GET",
                success : function(result){
                    console.log(result);  
                    // 1 : 인증번호 일치 O, 시간 만족O
                    // 2 : 인증번호 일치 O, 시간 만족X
                    // 3 : 인증번호 일치 X

                    if(result == 1){

                        clearInterval(checkInterval); // 타이머 멈춤     

                        cMessage.innerText = "인증되었습니다.";
                        cMessage.classList.add("confirm");
                        cMessage.classList.remove("error");

                    } else if(result == 2){
                        alert("만료된 인증 번호 입니다.");

                    } else{ // 3
                        alert("인증 번호가 일치하기 않습니다.");
                    }


                },

                error : function(){
                    console.log("이메일 인증 실패")
                }
            });



        } else { // 6자리 아님
            alert("인증번호를 정확하게 입력해주세요.");
            cNumber.focus();
        }

    }else{ // 인증번호를 안받은 경우
        alert("인증번호 받기 버튼을 먼저 클릭해주세요.");
    }

});

/***********************이메일 유효성 검사******************************** */

// 이메일 유효성 검사
const userEmail = document.getElementById("userEmail");
const emailMessage = document.querySelector("#emailMessage");

userEmail.addEventListener("input", function(){

    // 입력이 되지 않은 경우
    if( userEmail.value.length == 0 ){
        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";
        emailMessage.classList.remove("confirm", "error");

        checkObj.userEmail = false; // 유효 X 기록
        return;
    }

    // 입력된 경우
    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    if( regExp.test(userEmail.value) ){ // 유효한 경우
        
        // ****** 이메일 중복 검사(ajax) 진행 예정 ******

        //  $.ajax( {k:v , k:v} );  // jQuery ajax 기본형태

        // userEmail.value  == 입력된 이메일

        $.ajax({
            url : "emailDupCheck",   
            data : { "userEmail" : userEmail.value },
            type : "GET", // 데이터 전달 방식 type

            success : function(result){
                // 비동기 통신(ajax)가 오류 없이 요청/응답 성공한 경우
                
                // 매개변수 result : servlet에서 출력된 result 값이 담겨있음
                // console.log(result);

                if(result == 1){ // 중복 O
                    emailMessage.innerText = "이미 사용중인 이메일 입니다.";
                    emailMessage.classList.add("error");
                    emailMessage.classList.remove("confirm");
                    checkObj.memberEmail = false; // 유효 X 기록

                } else { // 중복 X
                    emailMessage.innerText = "사용 가능한 이메일 입니다.";
                    emailMessage.classList.add("confirm");
                    emailMessage.classList.remove("error");
                    checkObj.memberEmail = true; // 유효 O 기록
                }
            },
            
            error : function(){
                // 비동기 통신(ajax) 중 오류가 발생한 경우
                console.log("에러 발생");
            }

        });
        


    }else{
        emailMessage.innerText = "이메일 형식이 유효하지 않습니다.";
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");

        checkObj.userEmail = false; // 유효 X 기록
    }

});







