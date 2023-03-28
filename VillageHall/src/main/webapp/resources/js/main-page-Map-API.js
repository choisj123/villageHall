var mapContainer = document.getElementById('map'),
    mapOption = { 
        center: new kakao.maps.LatLng(37.566826, 126.9786567), 
        level: 3 
    }; 

var map = new kakao.maps.Map(mapContainer, mapOption); 


var markers = [];


// 마커 데이터
var markersData = [
  {
    name: "정훈쓰",
    location: new kakao.maps.LatLng(37.549264, 126.94500),
    title : "글제목1",
    createAt : "2023-03-08 10:00:00",
    content: "살려주세요",
    like : "500",
    category:"친목",
    photoUrl: 'https://media.tenor.com/91NRJO-HG0IAAAAi/%EC%9B%80%EC%A7%81%EC%9D%B4%EB%8A%94%EB%A1%9C%EC%95%84%EC%BD%98-%EB%AA%A8%EC%BD%94%EC%BD%94.gif' 
  },
  {
    name: "수진쓰",
    location: new kakao.maps.LatLng(37.549264, 126.913598),
    title : "글제목2",
    createAt : "2023-03-08 11:00:00",
    content: "시간 너무 안가요",
    like : "180",
    category:"이슈",
    photoUrl: 'https://media.tenor.com/hXlsX_G7ma0AAAAi/%EC%9B%80%EC%A7%81%EC%9D%B4%EB%8A%94%EB%A1%9C%EC%95%84%EC%BD%98-%EB%AA%A8%EC%BD%94%EC%BD%94.gif'
  },
  {
    name: "정윤쓰",
    location: new kakao.maps.LatLng(37.555284, 126.969833),
    title : "글제목3",
    createAt: "2023-03-08 12:40:00",
    content: "자고싶다",
    like : "260",
    category:"취미",
    photoUrl: 'https://media.tenor.com/lSU2BNd-fyYAAAAj/%EC%9B%80%EC%A7%81%EC%9D%B4%EB%8A%94%EB%A1%9C%EC%95%84%EC%BD%98-%EB%AA%A8%EC%BD%94%EC%BD%94.gif'
  },
  {
    name: "동준쓰",
    location: new kakao.maps.LatLng(37.575868, 126.976781),
    title : "글제목4",
    createAt: "2023-03-08 22:10:03",
    content: "집에안가고싶어요",
    like : "540",
    category:"친목",
    photoUrl: 'https://media.tenor.com/HaSLxXI5y1oAAAAi/%EC%9B%80%EC%A7%81%EC%9D%B4%EB%8A%94%EB%A1%9C%EC%95%84%EC%BD%98-%EB%AA%A8%EC%BD%94%EC%BD%94.gif'
  },
  {
    name: "민성쓰",
    location: new kakao.maps.LatLng(37.551457, 126.988244),
    title : "글제목5",
    createAt: "2023-03-08 20:50:00",
    content: "안녕하세요",
    like : "200",
    category: "추천",
    photoUrl: 'https://media.tenor.com/7bS_ec1TjfEAAAAi/%EC%9B%80%EC%A7%81%EC%9D%B4%EB%8A%94%EB%A1%9C%EC%95%84%EC%BD%98-%EB%AA%A8%EC%BD%94%EC%BD%94.gif'
  }
];




for (var i = 0; i < markersData.length; i++) {
  var marker = new kakao.maps.Marker({
    position: markersData[i].location,
    map: map,
    category: markersData[i].category
  });

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

// 카테고리 선택 폼
var categorySelect = document.getElementById('category');

categorySelect.onchange = function() {
  var category = this.value;
  showMarkersByCategory(category);
};