(() => {
	const myBoardList = document.getElementById("myBoardList");
	
	$.ajax({
		url : "mypage/myBoard",
		type : "GET",
		dataType : "JSON",
		
		success : function(boardList){
			console.log(boardList)
			
			myBoardList.innerHTML = "";
			
			for(let item of boardList) {
				
				const tr = document.createElement;
				
				const td1 = document.createElement("td");
				td1.innerText = item.boardNo;
				const td2 = document.createElement("td");
				td1.innerText = item.boardTitle;
				const td3 = document.createElement("td");
				td1.innerText = item.boardCreateDate;
				const td4 = document.createElement("td");
				td1.innerText = item.readCount;
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