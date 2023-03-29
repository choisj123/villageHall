/*
(() => {
	console.log("하이")
	$.ajax({
		url : "mypage/myBoard",
		type : "GET",
		dataType : "JSON",
		
		success : function(boardList){
			const myBoardList = document.getElementById("myBoardList");
			console.log(boardList)
			
			myBoardList.innerHTML = "";
			
			for(let i = 0; i <= boardList.length; i++) {
				
				const tr = document.createElement("tr");
				
				const td1 = document.createElement("td");
				td1.innerText = boardList[i].getBoardNo;
				const td2 = document.createElement("td");
				td1.innerText = boardList[i].getBoardTitle;
				const td3 = document.createElement("td");
				td1.innerText = boardList[i].getBoardCreateDate;
				const td4 = document.createElement("td");
				td1.innerText = boardList[i].getReadCount;
				const td5 = document.createElement("td");
				td1.innerText = '좋아요';
				
				tr.append(td1, td2, td3, td4, td5);
				
				myBoardList.append(tr);
			}
		},
		error : function() {
			console.log("에러 발생");
		}
	})	
})();
*/

	
