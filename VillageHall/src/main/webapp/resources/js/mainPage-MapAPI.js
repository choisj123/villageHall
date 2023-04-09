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
    like : kakaoMapList[i].boardNo,
    photoUrl : 'https://media.tenor.com/7bS_ec1TjfEAAAAi/%EC%9B%80%EC%A7%81%EC%9D%B4%EB%8A%94%EB%A1%9C%EC%95%84%EC%BD%98-%EB%AA%A8%EC%BD%94%EC%BD%94.gif'
  });
}

for(var i = 0; i < kakaoBoardRecent.length; i++){
	navData.push({
		name : kakaoBoardRecent[i].userNickname,
		title : kakaoBoardRecent[i].boardTitle,
		createAt : kakaoBoardRecent[i].boardCreateDate,
		category : kakaoBoardRecent[i].categoryName,
		like : kakaoBoardRecent[i].boardNo,
		photoUrl : 'https://media.tenor.com/7bS_ec1TjfEAAAAi/%EC%9B%80%EC%A7%81%EC%9D%B4%EB%8A%94%EB%A1%9C%EC%95%84%EC%BD%98-%EB%AA%A8%EC%BD%94%EC%BD%94.gif'
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
                '<div class="inwi-left"><img src='+ markersData[i].photoUrl +'"width="58" height="58"></div>' +
                '<div class="inwi-right">' +
                 ' <div>' + markersData[i].name + '</div>' +
                 ' <div class="time">' + markersData[i].createAt + '</div>' + 
                 ' <div> #' +  markersData[i].category + '</div>' +
                '</div>' +
              '</div>' +
             ' <div class="infowindow-content">' +
              '<div class="info-title">' + markersData[i].title + '</div>' +
              '<div class="info-content">' + markersData[i].content + '</div>' +
              '</div>'+
              '<div class="infowindow-footer">좋아요 : ' + markersData[i].like + '</div>'+
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
      "<p>" +
      filteredNavData[i].name +
      "</p>" +
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
  
  for (var i = 0; i < markersData.length; i++) {
    if (category === "전체" || markersData[i].category === category) {
      markers[i].setVisible(true);
    } else {
      markers[i].setVisible(false);
    }
  }
  
  
    // 스크롤을 맨 위로 올리는 코드
    const mapNav = document.getElementById("map-nav");
    mapNav.scrollTop = 0;
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