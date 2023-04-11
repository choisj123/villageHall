// servlet에서 json 객체 불러오기
$.ajax({
        url : "board/kakaoMap",
        dataType : "json",    //  응답 데이터의 형식을 "json"으로 지정
                              // -> 자동으로 JS 객체로 변환됨
        success : function( kakaoMapList ){
	      console.log(kakaoMapList);

$.ajax({
        url : "board/kakaoMapBoardRecent",
        dataType : "json", 

        success : function(kakaoBoardRecent){
          console.log(kakaoBoardRecent);

// map 함수 정의 
var mapContainer = document.getElementById('map'),
    mapOption = { 
        center: new kakao.maps.LatLng(37.566826, 126.9786567), 
        level: 3 
    }; 
// kakao library 메서드
var map = new kakao.maps.Map(mapContainer, mapOption); 


// 데이터를 담을 배열추가
var markers = [];

// 데이터를 담을 배열추가
var markersData = [];

var navData = [];


// DB데이터를 배열에 삽입
for (var i = 0; i < kakaoMapList.length; i++) {
  markersData.push({
    marker : null,  
    name : kakaoMapList[i].userNickname,
    title : kakaoMapList[i].boardTitle,
    createAt : kakaoMapList[i].boardCreateDate,
    location: new kakao.maps.LatLng(kakaoMapList[i].latitude, kakaoMapList[i].longtitude),
    content : kakaoMapList[i].boardContent,
    category : kakaoMapList[i].categoryName,
    like : kakaoMapList[i].likeCount,
    photoUrl : kakaoMapList[i].profileImg
  });
}

for(var i = 0; i < kakaoBoardRecent.length; i++){
	navData.push({
		
		name : kakaoBoardRecent[i].userNickname,
		title : kakaoBoardRecent[i].boardTitle,
		createAt : kakaoBoardRecent[i].boardCreateDate,
		category : kakaoBoardRecent[i].categoryName,
		boardNo : kakaoBoardRecent[i].boardNo,
		photoUrl : kakaoBoardRecent[i].profileImg
	});
}

// marker에 위치 , 맵, 카테고리 삽입
for (var i = 0; i < markersData.length; i++) {
  var marker = new kakao.maps.Marker({
    position: markersData[i].location,
    map: map,
    category: markersData[i].category
  });

  markersData[i].marker = marker;

// 위에서 정의한 markers배열에 marker 데이터 삽입
  markers.push(marker);

// 배열에 담은 데이터를 정의하는 인포윈도우 이벤트 리스너
  kakao.maps.event.addListener(marker, 'click', (function(marker ,i) {
      return function() {
          var infowindow = new kakao.maps.InfoWindow({
              content: 
              '<div class="infowindow-container">' +
              	'<div class="infowindow-header">' + 
                	'<div class="inwi-left">' +
                		'<div class="map-profile-area">' +
                			'<img class= "profile" src="' + markersData[i].photoUrl + '">' +
                		'</div>' +
                  '</div>' +
                	'<div class="inwi-right">' +
						        '<div>' + markersData[i].name + '</div>' +
                 		'<div class="time">' + markersData[i].createAt + '</div>' + 
                 		'<div class="category"> #' +  markersData[i].category + '</div>' +
                	'</div>' +
              	'</div>' +
            	  '<div class="infowindow-content">' +
              		'<div class="info-title">' + markersData[i].title + '</div>' +
              		'<div class="info-content">' + markersData[i].content + '</div>' +
               '</div>'+
               '<div class="infowindow-footer">❤️' + markersData[i].like + '</div>'+
             '</div>'
            
          });
          // 인포윈도우 이벤트 리스너
          infowindow.open(map, marker);
          map.addListener('click',  function() {
            infowindow.close();
          });
      }
  })(marker, i));
}

// option을 정의하는 함수
let category = "전체";

function showMarkersByCategory(newCategory) {
  category = newCategory; // 전역 변수인 category 값을 업데이트
  const filteredNavData = navData.filter((item) => {
    return category === "전체" || item.category === category;
  });
  
  
  const placesList = document.getElementById("placesList");
  placesList.innerHTML = ""; // 이전 목록 삭제
  for (let i = 0; i < filteredNavData.length; i++) {
    const li = document.createElement("li");
const content =
      "<a href='http://localhost:8080/VillageHall/board/boardDetail?boardNo=" +
      filteredNavData[i].boardNo +
      "&cp=1&type=3' onclick ='clickBoardFunction(" +
      filteredNavData[i].boardNo +
      "); '>" +
      filteredNavData[i].name +
      "</a>" +
      "<p>" +
      filteredNavData[i].title +
      "</p>" +
      "<p>" +
      filteredNavData[i].createAt +
      "</p>" +
      "<hr>";
    li.innerHTML = content;
    placesList.appendChild(li);
  }
  
  function clickBoardFunction(boardNo) {
  const boardUrl = `http://localhost:8080/VillageHall/board/boardDetail?boardNo=${boardNo}&cp=1&type=3`;
  window.location.href = boardUrl;
}

  
  for (var i = 0; i < markersData.length; i++) {
    if (category === "전체" || markersData[i].category === category) {
      markers[i].setVisible(true);
    } else {
      markers[i].setVisible(false);
    }
  }
}  
 

// option 이벤트 리스너
document.getElementById("categorySelect").addEventListener("change", function () {
  const newCategory = this.value;
  showMarkersByCategory(newCategory);
});





  },
 error : function(request, status, error){
            console.log("2번째 AJAX 에러 발생");
            console.log("상태코드 : " + request.status); // 404, 500
        }
});

},

error : function(request, status, error){
  console.log("1번째 AJAX 에러 발생");
  console.log("상태코드 : " + request.status); // 404, 500
}

});