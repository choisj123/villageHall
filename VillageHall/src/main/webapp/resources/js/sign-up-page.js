console.log("signUp.js loaded");

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

const userEmail = document.getElementById("userEmail");


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

/***********************이메일 확인 *********************/
// 이메일 중복 검사
const emailMessage = document.getElementById("emailMessage");

userEmail.addEventListener("input",function(){
	const regEx = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	
	if(regEx.test(userEmail.value)){
		emailMessage.innerText = "유효한 이메일 형식입니다.";
		emailMessage.classList.add("confirm");
		emailMessage.classList.remove("error");
		
		$.ajax({
            url : "checkEmail",
            data : {"inputEmail" : userEmail.value},
            type : "GET",
            typeof : "JSON",
            success : function(result){
				if(result == 0){
					console.log("이메일 중복 결과 : " + result);
	                console.log("이메일 중복검사 성공");
	                
		            // 이메일 중복 검사가 정상적으로 되었음을 checkObj에 기록
		            checkObj.memberEmail = true;
		            console.log(checkObj.memberEmail);
					
				}else{
					console.log("이메일 중복 결과 : " + result);
					console.log("중복된 이메일입니다.")
	                emailMessage.innerText = "중복된 이메일입니다."
					emailMessage.classList.add("error");
					emailMessage.classList.remove("confirm");
				} 
				
			},
			error : function(request, status, error){
				console.log("ajax 에러 발생");
				console.log("상태코드 : " + request.status); // 404, 500
	                
	            }
		})
	
	}else{
		emailMessage.innerText = "잘못된 형식입니다.";
		emailMessage.classList.add("error");
		emailMessage.classList.remove("confirm");
		
	}
})


/*************** 인증번호 **************/
// 이메일 중복 아닐 시 인증번호 보내기

// 인증번호 보내기
const emailCheckBtn = document.getElementById("email-check-btn");
const cMessage = document.getElementById("cMessage");

// 타이머에 사용될 변수
let checkInterval; // setInterval을 저장할 변수
let min = 4;
let sec = 59;


sendBtn.addEventListener("click", function(){
	console.log("click");
    if(checkObj.memberEmail){ //유효한 이메일이 작성되어 있을 경우에만 메일 보내기
        $.ajax({
            url : "sendEmail",
            data : {"inputEmail" : userEmail.value},
            type : "GET",
            success : function(result){
                console.log("이메일 발송 성공");
                console.log(result);
                
                // 인증 버튼이 클릭되어 정상적으로 메일이 보내였음을 checkObj에 기록
                checkObj.sendEmail = true;
            },
            error : function(){
                console.log("이메일 발송 실패")
            }
        });
        
        // Mail 발생 ajax 코드는 서버 통신이다보니 동작이 느림
        // -> ajax코드가 비동기이기 때문에 메일이 보내지는 것을 기다리지 않고
        // 바로 다음 코드 수행
        
        // 5분 타이머
        // setInterval(함수, 지연시간)
        cMessage.innerText = "5:00"; //초기값 5분
        min = 4;
        sec = 59;
        cMessage.classList.remove("confirm");
        cMessage.classList.remove("error");
        
        
        checkInterval = setInterval(function(){
			
			if( sec < 10 ) sec = "0" + sec;
			cMessage.innerText = min + ":" + sec;
			if(Number(sec) === 0){
				min--;
				sec = 59;
				
			} else{
				sec--;
			}
			
			if(min === -1){ //만료
				cMessage.classList.add("error");
				cMessage.innerText = "인증번호가 만료되었습니다.";
				
				clearInterval(checkInterval); // checkInterval 반복 지움
			}
			
		}, 1000); // 1초 "지연 후 수행
		 
		alert("인증번호가 발송되었습니다. 이메일을 확인해주세요.")
        
    }
})

const cBtn = document.getElementById("cBtn");
cBtn.addEventListener("click", function(){
	 $.ajax({
            url : "checkNumber",
            data : {"inputNumber" : cNumber.value, "inputEmail" : memberEmail.value},
            type : "GET",
            success : function(result){
					console.log("인증번호 일치");
					alert("인증되었습니다.")
					console.log("인증번호 일치 : " + result);
					cMessage.innerText = "이메일 인증이 완료되었습니다.";
					cMessage.classList.add("confirm");
					cMessage.classList.remove("error");
					
					
					checkObj.memberEmail = true;
				
         		
            },
            error : function(){
				console.log("인증번호 불일치")
				
				alert("인증번호가 틀립니다. 다시 시도해주세요.")

            }
        });
	
})




/********* 닉네임 **************/
const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("focusout", function(){
	const regEx = /^(?=.*[a-zA-Z0-9가-힣])[a-zA-Z0-9가-힣]{2,10}$/;
	
	if(regEx.test(memberNickname.value)){
		nicknameMessage.innerText = "유효한 닉네임 형식입니다.";
		nicknameMessage.classList.add("confirm");
		nicknameMessage.classList.remove("error");
		
			$.ajax({
            url : "checkNickname",
            data : {"inputNickname" : memberNickname.value},
            type : "POST",
            success : function(result){
				if(result == 0){
					console.log("닉네임 중복 결과 : " + result);
	                console.log("닉네임 중복검사 성공");
	                
	                nicknameMessage.innerText = "사용가능한 닉네임입니다.";
					nicknameMessage.classList.add("confirm");
					nicknameMessage.classList.remove("error");
	                
		            // 닉네임 중복 검사가 정상적으로 되었음을 checkObj에 기록
		            checkObj.memberNickname = true;
		            console.log(checkObj.memberNickname);
					
				}else{
					console.log("닉네임 중복 결과 : " + result);
					console.log(typeof(result));
					console.log("중복된 닉네임입니다.")
	                nicknameMessage.innerText = "중복된 닉네임입니다."
					nicknameMessage.classList.add("error");
					nicknameMessage.classList.remove("confirm");
				} 
				
			},
			error : function(request, status, error){
				console.log("ajax 에러 발생");
				console.log("상태코드 : " + request.status); // 404, 500
	                
	            }
		})
		
		
	}else{
		nicknameMessage.innerText = "잘못된 형식입니다.";
		nicknameMessage.classList.add("error");
		nicknameMessage.classList.remove("confirm");
		
		
	}
	
	
	
})




/***********************핸드폰번호 확인 *********************/

const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

memberTel.addEventListener("input", function(){
	const regEx = /(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/;
	
		if(regEx.test(memberTel.value)){
		telMessage.innerText = "유효한 전화번호 형식입니다.";
		telMessage.classList.add("confirm");
		telMessage.classList.remove("error");
		
		
		
	}else{
		telMessage.innerText = "잘못된 형식입니다.";
		telMessage.classList.add("error");
		telMessage.classList.remove("confirm");
		
		
	}
	
	
})








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



const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage = document.getElementById("pwMessage");

memberPw.addEventListener("input", function(){
	const regEx = /^(?=.*[a-zA-Z])(?=.*[!@#-_])(?=.*[0-9]).{6,30}$/;
	
	if(regEx.test(memberPw.value)){
		pwMessage.innerText = "유효한 비밀번호 형식입니다.";
		pwMessage.classList.add("confirm");
		pwMessage.classList.remove("error");
		
		checkObj.memberPw = true;
		
		memberPwConfirm.addEventListener("input",function(){
			if(memberPw.value === memberPwConfirm.value){
				pwMessage.innerText = "사용할 수 있는 비밀번호입니다.";
				pwMessage.classList.add("confirm");
				pwMessage.classList.remove("error");
				
				checkObj.userPwConfirm = true;
				
				
			}else{
				pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
				pwMessage.classList.add("error");
				pwMessage.classList.remove("confirm");
			}
		})
		
	} else{
		pwMessage.innerText = "잘못된 형식입니다.";
		pwMessage.classList.add("error");
		pwMessage.classList.remove("confirm");
		
	}
	
})


/* 프로필 사진 */

