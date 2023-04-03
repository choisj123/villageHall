$.ajax({
        url : "board/kakaoMap",
        dataType : "json",    //  응답 데이터의 형식을 "json"으로 지정
                              // -> 자동으로 JS 객체로 변환됨
        success : function( kakaoMapList ){
	console.log(kakaoMapList);




var mapContainer = document.getElementById('map'),
    mapOption = { 
        center: new kakao.maps.LatLng(37.566826, 126.9786567), 
        level: 3 
    }; 

var map = new kakao.maps.Map(mapContainer, mapOption); 



var markers = [];

// 데이터를 담을 배열추가
var markersData = [];

// 데이터를 배열에 삽입
for (var i = 0; i < kakaoMapList.length; i++) {
  markersData.push({
    marker : null,  
    name : kakaoMapList[i].userNickname,
    title : kakaoMapList[i].boardTitle,
    createAt : kakaoMapList[i].boardCreateDate,
    location: new kakao.maps.LatLng(kakaoMapList[i].latitude, kakaoMapList[i].longtitude),
    content : kakaoMapList[i].boardContent,
    category : "전체",
    photoUrl : 'https://media.tenor.com/7bS_ec1TjfEAAAAi/%EC%9B%80%EC%A7%81%EC%9D%B4%EB%8A%94%EB%A1%9C%EC%95%84%EC%BD%98-%EB%AA%A8%EC%BD%94%EC%BD%94.gif'
  });
}

// markersData 배열에 데이터가 모두 추가된 후에 반복문 실행
for (var i = 0; i < markersData.length; i++) {
  var marker = new kakao.maps.Marker({
    position: markersData[i].location,
    map: map,
    category: markersData[i].category
  });

  markersData[i].marker = marker;

  markers.push(marker);

  kakao.maps.event.addListener(marker, 'click', (function(marker, i) {
      return function() {
          var infowindow = new kakao.maps.InfoWindow({
              content: 
              '<div class="infowindow-container">' +
              '<div class="infowindow-header">' + 
                '<div class="inwi-left"><img src="'+ markersData[i].photoUrl +'width="58" height="58"></div>' +
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
          infowindow.open(map, marker);
          map.addListener('click',  function() {
            infowindow.close();
          });
      }
  })(marker, i));
}

function showMarkersByCategory(category) {
    for (var i = 0; i < markersData.length; i++) {
      if (category === "전체" || markersData[i].category === category) {
        markers[i].setVisible(true);
      } else {
        markers[i].setVisible(false);
      }
    }
  }
  },

 error : function(request, status, error){
            console.log("AJAX 에러 발생");
            console.log("상태코드 : " + request.status); // 404, 500
        }
});
