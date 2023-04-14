
var weatherIcon = {
    '01' : 'fas fa-sun',
    '02' : 'fas fa-cloud-sun',
    '03' : 'fas fa-cloud',
    '04' : 'fas fa-cloud-meatball',
    '09' : 'fas fa-cloud-sun-rain',
    '10' : 'fas fa-cloud-showers-heavy',
    '11' : 'fas fa-poo-storm',
    '13' : 'far fa-snowflake',
    '50' : 'fas fa-smog'
};

    var apiURI = 'http://api.openweathermap.org/data/2.5/weather?id=1835848&appid=7401ee2987d021037ece4c98b2baf927&units=metric';
     $.ajax({
    url: apiURI,
    dataType: "json",
    type: "GET",
    async: "false",
    success: function(resp) {

        var $minTemp = Math.floor(data.main.temp_min) + "℃";
        var $main = data.weather[0].main;
        var $now = new Date($.now());
        var $speed = Math.floor(data.wind.speed) + 'm/s';
        var $cDate = $now.getMonth() + 1 + '월' + " " + $now.getDate() + '일';
        //  + $now.getHours()+ '시간' + $now.getMinutes() + '분';
        var $name = data.name;

		var $Icon = (resp.weather[0].icon).substr(0,2);
        var $cTemp = Math.floor(resp.main.temp- 273.15) + 'º';
        var $humidity = '습도&nbsp;&nbsp;&nbsp;&nbsp;' + resp.main.humidity+ ' %';
       
       // var box = document.querySelector(".box");

        
        const main = document.querySelector(".main");
        
        function getText($main) {
            if($main === "Haze" || $main === "Clouds"){
                //box.style.backgroundImage = "url(../villageHall/resources/images/cloud.jpg)";
                main.innerText = "흐림";
            } else if($main === "Clear"){
                //box.style.backgroundImage = "url(../villageHall/resources/images/sunny.jpg)";
                main.innerText ="맑음";
            } else if($main === "Snow"){
               //box.style.backgroundImage = "url(../villageHall/resources/images/snow.jpg)";
                main.innerText = "눈";
            } else if($main === "Rain"){
               // box.style.backgroundImage = "url(../villageHall/resources/images/rain.jpg)";
                main.innerText = "비";
            } else {
                main.innerText = '흐림';
                // box.style.backgroundImage = "url(../villageHall/resources/images/cloud.jpg)";
            }
        }


        $('.clowtemp').append($minTemp);
        $('h1').prepend($cDate);
        $('.main').append(getText($main));
        $('.ctemp').append($cTemp);
        $('.humidity').append($humidity);
        $('.speed').append($speed);
        $('.name').append($name);
        $('.weather_icon').append('<i class="' + weatherIcon[$Icon] +' fa-5x" style="height : 150px; width : 150px;"></i>');
         
    }    
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

