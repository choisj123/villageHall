console.log("termsOfUse.js loaded");

// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
	
    "required1" : false, 
    "required2" : false, 


}

/****** 취소버튼 */

var cancelBtn = document.getElementById("cancelBtn");

cancelBtn.addEventListener('click', function(){
	
	history.back();
	
	
});


/******필수동의 항목 유효성 */
var checkbox1 = document.querySelector("input[id=required1]");
var checkbox2 = document.querySelector("input[id=required2]");

checkbox1.addEventListener( 'change', function() {
	
    if(this.checked) {
		console.log("체크박스1");
        checkObj.required1 = true;
    } else {
		
		checkObj.required1 = false;
        
    }
});

checkbox2.addEventListener( 'change', function() {
    if(this.checked) {
        console.log("체크박스2");
        checkObj.required2 = true;
    } else {
        checkObj.required2 = false;
    }
});


/*******************유효성 확인  */

function termsOfUserValidate(){

    // checkObj에 있는 모든 속성을 반복 접근하여
    // false가 하나라도 있는 경우에는 form태그 기본 이벤트 제거

    

    for( let key  in checkObj ){ // 객체용 향상된 for문

        // 현재 접근 중인 key의 value가 false인 경우
        if( !checkObj[key] ){ 

            switch(key){
            case "required1":      alert("필수동의 약관에 동의해주시기 바랍니다."); break;
            case "required2":        alert("필수동의 약관에 동의해주시기 바랍니다."); break;    
    
            }

           
            document.getElementById(key).focus();
            
            return false; // form태그 기본 이벤트 제거
        }
        
       
    }

    return true; // form태그 기본 이벤트 수행

}










