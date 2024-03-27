<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700">
<link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300">  
<style>

* {
  box-sizing: border-box;
  line-height: 1.25em;
}

.clear {
  clear: both;
}
 
body {
  margin: 0;
  width: 100%;
  height: 100vh;
  font-family: 'Montserrat', sans-serif;
  background: var(--gradient);
  display: flex;
  align-items: center;
  justify-content: center;
  background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url(back1.jpeg);
  height: 100vh;
  background-position: center;
  background-size: cover;
  width:100%;
  /* opacity:0.5; */
}
.SearchBar{
    padding: 25px 35px;
  }
  
  .SearchBar_input {
    position: relative;
    width: 100%;
    border: none;
    border-radius: 25px;
    padding: 15px;
    font-family: 'Montserrat', sans-serif;
    background-image: var(--gradient);
    color: #000000;
    font-weight: 700;
    box-shadow: 0 0 30px -5px rgba(0, 0, 0, 0.25);
    transition: transform 200ms ease;
  }
  
  .searchBar-input:hover {
    transform: scale(0.95);
  }
.container {
  /* border-radius: 25px; */
  box-shadow: 0 0 70px -10px rgba(0, 0, 0, 0.2);
  background-color: #222831;
  color: #ffffff;
  height: 90vh;
  width:90%;
  opacity: 0.4;
}

.weather-side {
  position: relative;
  height: 90%;
  background-color: white;
  border-radius: 25px; 
  width: 300px;
  color: #222831;
  margin:10px;
  box-shadow: 0 0 20px -10px rgba(0, 0, 0, 0.2);
  transition: transform 300ms ease;
  transform: translateZ(0) scale(1.02) perspective(1000px);
  float: left;
 
}

.weather-side:hover {
  transform: scale(1.1) perspective(1500px) rotateY(10deg);
}

.weather-app {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  background-image: var(--gradient);
  border-radius: 25px;
  opacity: 0.4;
}

.date-container {
  position: absolute;
  top: 25px;
  left: 25px;
}

.date-dayname {
  margin: 0;
}

.date-day {
  display: block;
}

.location {
  display: inline-block;
  margin-top: 10px;
}

.location-icon {
  display: inline-block;
  height: 0.8em;
  width: auto;
  margin-right: 5px;
}

.weather-container {
  position: absolute;
  bottom: 25px;
  left: 25px;
}

.weather-icon img {
  filter: drop-shadow(0 0 2px #fff);
  width: 100%;
}

.weather-temp {
  margin: 0;
  font-weight: 700;
  font-size: 4em;
}

.weather-desc {
  margin: 0;
}

.l1{
    font-size:12px;
}
.info-side {
  position: relative;
  float: left;
  height: 100%;
  padding-top: 25px;
}

.today-info {
  padding: 15px;
  margin: 0 25px 25px 25px;
  box-shadow: 0 0 50px -5px rgba(0, 0, 0);
  border-radius: 10px;
}

.today-info>div:not(:last-child) {
  margin: 0 0 10px 0;
}

.today-info div .title {
  float: left;
  font-weight: 700;
}

.today-info div .value {
  float: right;
}

.sunTimes{
    width:900px;
    justify-content: space-around;
    display: flex;
}
 .sunset1{
  border: 1px solid black;
  width:400px;
  height:200px;
  background-color: white;
  border-radius: 10px;
 }
 .sunrise1{
    border: 1px solid black;

  width:400px;
  height:200px;
  background-color: white;
  border-radius: 10px;
 }

 .s_title{
    display: block;
    margin: 10px 0 0 0;
    position: relative;
    top:20px;
    left:40px;
    font-size:25px;
  color: #222831;
 }
 .sunrise{
    color: #000000;
    font-size:13px;
    position: relative;
    top:10px;
    left:60px;

 }
 .sunset{
    color: #000000;
    font-size:13px;
    position: relative;
    top:10px;
    left:60px;

 }

#icon1{
  font-size:70px;
  position: relative;
  top:30px;
  left:300px;
}
#icon2{
 font-size:70px;
  position: relative;
  top:30px;
  left:300px;
}

.pollution{
   width:850px;
   height:200px;
   box-shadow: 0 0 50px -5px rgba(0, 0, 0);
   background-color:white;
   color:black;
  border-radius: 10px; 
  margin:20px;
  padding:15px;
}
.pollution p{

 margin-left:140px;;
}
form  .btn1{
    width:80px;
    height:40px;
    position: relative;
    left: 780px;
    border-radius: 20px;

    border:none;

}

 
#notification {
  background-color: #ffcccc;
  padding: 20px;
  border: 1px solid #ff0000;
  border-radius: 5px;
  position: fixed;
  top: 20px;

</style>
</head>
<body>
<div class="container">
    
       
    
    <div class="weather-side">
        <div class="weather-app"></div>
        <div class="date-container">
            <h2 class="date-dayname">${day}</h2>
            <span class="date-day">${date1}</span>
            <i class="fa-solid fa-location-dot"></i>
            <span class="location">${city}</span>
            
        </div>
        <div class="weather-container">
            <span class="weather-icon"></span>
            <h1 class="weather-temp">${temperature}</h1>
            <h3 class="weather-desc">${decrip}</h3>
            <span class="longitude l1">longitude: ${longitude}</span><br>
            <span class="latitude l1">latitude: ${latitude}</span>
        </div>
    </div>
    <div class="info-side">
        <div class="today-info-container">
            <div class="today-info">
                <div class="humidity">
                    <span class="title"><i class="fa-solid fa-droplet"></i> HUMIDITY</span>
                    <span class="value">${humidity} %</span>
                    <form action="forecast.html">
                        <button class="btn1">Forecast </button>
                    </form>
                    <div class="clear"></div>
                </div>
                <div class="wind">
                    <span class="title"><i class="fa-solid fa-wind"></i> WIND</span>
                    <span class="value">${wind} m/s</span>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        
        <div class="sunTimes">
            <div class="sunrise1">
                <span class="s_title">Sunrise</span>
                <span id="icon1"></span>
                <p class="sunrise">${sunrise}</p>
            </div>
            <div class="sunset1">
                
                <span class="s_title">Sunset</span>
                <span id="icon2"></span>
                <p class="sunset">${sunset}</p>
            </div>
            
        </div>
        <div class="pollution">
           <h3>Air pollution</h3>
            <p>&nbsp;&nbsp; co:${co}   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; no:${no } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  no2:${no2}</p>
            <p>&nbsp;&nbsp; o3:${o3}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; so2:${so2} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; pm2_5:${pm2_5 } </p>
            <p>&nbsp;&nbsp; pm10:${pm10} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; nh3:${nh3} </p>
            <form id="airPollutionForm" action="airPollution.jsp" method="post" style="display: none;">
                <button type="submit">Air pollution</button>
            </form>
        </div>
         
    </div>
    
  
  <div id="notification" class="hidden">
    <h2>Air Quality Alert!</h2>
    <p>Poor air quality detected. Take necessary precautions.</p>
    <p><span id="pollutants"></span></p>
  </div>
   
  
</div>

<script>
    document.getElementById("airPollutionForm").addEventListener("submit", function(event) {
        event.preventDefault();
        var formAction = this.getAttribute("action");
        window.location.href = formAction;
    });
    let c1=document.getElementById('icon1');
    let c2=document.getElementById('icon2');
     
    document.getElementById('weatherInfo');
    c1.innerHTML = '☀️'; 
    c2.innerHTML = '☁️'; 
    
    // notification 
    apikey="306ab9cd41753cb018c5190483263290";
    const latitude =  ${latitude};
    const longitude =${longitude};
     
    
    const city = ${city}; 
    const apiUrl = http://api.openweathermap.org/data/2.5/air_pollution?q=${city}&appid=${apiKey};
   
fetch(apiUrl)
  .then(response => response.json())
  .then(data => {
    const pollutants = data.list[0].components; 
    const poorQuality = isPoorAirQuality(pollutants);
    if (poorQuality) {
      document.getElementById('notification').classList.remove('hidden');
      displayPollutants(pollutants);
    }
  })
  .catch(error => console.error('Error fetching air quality data:', error));
function isPoorAirQuality(pollutants) {
  const thresholds = {
    co: 9, 
    no: 200, 
    no2: 100,
    o3: 150,
    so2: 20, 
    nh3: 50, 
    pm2_5: 25,
    pm10: 50 
  };
  for (const [pollutant, value] of Object.entries(pollutants)) {
    if (value > thresholds[pollutant]) {
      return true;
    }
  }
  return false;
}

// Function to display pollutants with poor air quality
function displayPollutants(pollutants) {
  const poorPollutants = [];
  for (const [pollutant, value] of Object.entries(pollutants)) {
    if (value > thresholds[pollutant]) {
      poorPollutants.push(${pollutant}: ${value});
    }
  }
  document.getElementById('pollutants').innerText = poorPollutants.join(', ');
} 	 
    </script>
    
</body>
</html>

 

       
       
