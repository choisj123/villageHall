     $.getJSON //api 키값
    ('http://api.openweathermap.org/data/2.5/weather?id=1835848&appid=7401ee2987d021037ece4c98b2baf927&units=metric',function(data){

        var $minTemp = Math.floor(data.main.temp_min) + "℃";
        var $cTemp = Math.floor(data.main.temp) + "℃";
        var $main = data.weather[0].main;
        var $humidity = data.main.humidity + '%';
        var $now = new Date($.now());
        var $cDate = $now.getMonth() + 1 + '월' + $now.getDate() + '일';
        //  + $now.getHours()+ '시간' + $now.getMinutes() + '분';
        var $wIcon = data.weather[0].icon;


        var box = document.querySelector(".box");

        var img = (window.getComputedStyle(document.querySelector(".box")).getPropertyValue("background-image"))
     
        const main = document.querySelector(".main");
        
      function getText($main) {
        var imageUrl = ""
            if($main === "Haze" || $main === "Clouds"){
             /* imageUrl = "../resources/images/cloud.jpg"
                box.style.backgroundImage = "url('" +imageUrl+ "')";*/
                main.innerText = "흐림";
            } else if($main === "Clear"){
             /* imageUrl = "../resources/images/sunny.jpg"
              box.style.backgroundImage = "url('" +imageUrl+ "')"; */
                main.innerText ="맑음";
            } else if($main === "Snow"){
              /*imageUrl = "../resources/images/snow.jpg"
              box.style.backgroundImage = "url('" +imageUrl+ "')";*/
                main.innerText = "눈";
            } else if($main === "Rain"){
              /*imageUrl = "../resources/images/rain.jpg"
              box.style.backgroundImage = "url('" +imageUrl+ "')";*/
                main.innerText = "비";
            } else {
                main.innerText = '번개';
            }
        }     


        $('.clowtemp').append($minTemp);
        $('h1').prepend($cDate);
        $('.main').append(getText($main));
        $('.ctemp').append($cTemp);
        $('.humidity').append($humidity);
        $('.cicon').append(' <img src="http://openweathermap.org/img/wn/'+ $wIcon + '.png"/>');
         
        
    });
    $.getJSON 
    ('http://api.openweathermap.org/data/2.5/air_pollution?lat=37.5683&lon=126.9778&appid=7401ee2987d021037ece4c98b2baf927&units=metric&lang=kr',function(data){
        var $aqi = data.list[0].main.aqi;

        const aqi = document.querySelector(".aqi");
        if($aqi == 1){
        aqi.innerText = "매우 좋음";
        } else if($aqi == 2){
        aqi.innerText = "좋음"
        } else if($aqi == 3){
        aqi.innerText = "보통";
        } else if($aqi == 4){
        aqi.innerText = "나쁨";
        } else if($aqi == 5){
        aqi.innerText = "매우 나쁨";
        } 
    });