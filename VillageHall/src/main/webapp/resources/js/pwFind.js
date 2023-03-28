//이메일아이디 입력시 버튼색 바뀜
const inputId = document.getElementById("email-text");
const pwDiv = document.getElementById("pwDiv");


inputId.addEventListener("keyup", function() {

    pwDiv.style.backgroundColor="#55710f";
    pwDiv.style.color ="white";
})

