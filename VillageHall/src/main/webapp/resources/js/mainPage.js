
console.log("main loaded")
const signupBtn = document.getElementById("signup")
signupBtn.addEventListener("mouseover",function(){
    signupBtn.style.backgroundColor="#EEF5ED"
    signupBtn.style.border = "3px solid #55710F"
    signupBtn.style.color = "#55710F"
    signupBtn.style.padding = "3px"
})

signupBtn.addEventListener("mouseout",function(){
    signupBtn.style.backgroundColor="#55710F"
    signupBtn.style.border = "3px solid #55710F"
    signupBtn.style.color = "white"
    signupBtn.style.padding = "3px"
})



//const writeBtn = document.getElementById("writeBtn");


//writeBtn.addEventListener("click", function(){
	//console.log("test!!!")
	//location.href='board/write'
	
	
//})


function writePage() {
	console.log("click");
	location.href='board/writeBoard';
	
}