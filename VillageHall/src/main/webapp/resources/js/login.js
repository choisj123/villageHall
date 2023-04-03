console.log("login.js loaded");



// 로그인 시 이메일(아이디)/비밀번호 입력 확인

// -> 미작성 시 alert() 이용해서 메세지를 출력하고
//    로그인 form 태그의 제출을 막는 기본 이벤트 제거 진행

function loginValidate(){ // 로그인 유효성 검사
    // validate : 유효하다    
    // invalidate : 무효하다    

    // 이메일 입력 input 요소 
    const inputEmail = document.getElementsByName("inputEmail")[0];

    // 비밀번호 입력 input 요소
    const inputPw = document.getElementsByName("inputPw")[0];


    // 이메일이 입력되지 않은 경우 false를 반환
    if( inputEmail.value.trim().length == 0 ){
        // 문자열.trim() : 문자열 양쪽 공백을 제거
        // 문자열.length : 문자열 길이(몇 글자?)

        alert("이메일을 입력해주세요.");
        inputEmail.value = ""; // 이메일 input에 입력된 내용을 모두 삭제
        inputEmail.focus(); // 이메일 input에 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }

    // 비밀번호를 입력하지 않은 경우 false 반환
    if(inputPw.value.trim() == ""){
        alert("비밀번호를 입력해주세요.");
        inputPw.value = "";
        inputPw.focus();
        return false;
    }


    return true; // form 태그 기본 이벤트 정상 수행
}



    