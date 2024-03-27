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
  background-image: url("pexels-brett-sayles-912364.jpg");
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
  height: 80%;
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

.week-list {
  list-style-type: none;
  padding: 0;
  margin: 10px 35px;
  box-shadow: 0 0 50px -5px rgba(0, 0, 0, 0.25);
  border-radius: 10px;
}

.week-list li {
  float: left;
  padding: 10px;
  width:140px;
  height:140px;
  cursor: pointer;
  transition: 200ms ease;
  border-radius: 10px;
  background-color: white;
  margin:20px;
  color: #222831;
  box-shadow: 0 0 40px -5px rgba(0, 0, 0, 0.2);
 
}

/* .week-list>li:hover {
  transform: scale(1.1);
  background: #fff;
  color: #222831;
  box-shadow: 0 0 40px -5px rgba(0, 0, 0, 0.2)
} */

/* .week-list>li.active {
  background: #fff;
  color: #222831;
  border-radius: 10px;
} */

.week-list li .day-name {
  display: block;
  margin: 10px 0 0 0;
  text-align: center;
}

.week-list li .day-icon {
  display: flex;
  margin-top: 20px;
  justify-content: center;
  align-items: center;
  height: 30px;
  width: auto;
  margin: 0 auto;
  font-size: 35px;
}

.week-list li .day-icon img {
  filter: drop-shadow(0 0 2px white);
}

.week-list li .day-temp {
  display: block;
  text-align: center;
  margin-top: 15px;
  font-weight: 700;
  margin-bottom: 25px;
}
.sunTimes{
    width:700px;
    justify-content: space-around;
    display: flex;
}
 .sunset1{
  border: 1px solid black;
  width:300px;
  height:150px;
  background-color: white;
  border-radius: 10px;
 }
 .sunrise1{
    border: 1px solid black;
  width:300px;
  height:150px;
  background-color: white;
  border-radius: 10px;
 }

 .s_title{
    display: block;
    margin: 10px 0 0 0;
    position: relative;
    top:20px;
    left:40px;
  color: #222831;
 }
 .sunrise{
    color: #000000;
    font-size:13px;
    position: relative;
    top:50px;
    left:80px;

 }
 .sunset{
    color: #000000;
    font-size:13px;
    position: relative;
    top:50px;
    left:80px;
 }

</style>
</head>
<body>
<div class="container">
    
       
    
    <div class="weather-side">
        <div class="weather-app"></div>
        <div class="date-container">
            <h2 class="date-dayname"></h2>
            <span class="date-day">${date}</span>
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
                    <div class="clear"></div>
                </div>
                <div class="wind">
                    <span class="title"><i class="fa-solid fa-wind"></i> WIND</span>
                    <span class="value">${wind} m/s</span>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="week-container">
            <ul class="week-list">
                <li>
                    <span class="day-name">Monday</span>
                    <span class="day-temp">23</span>
                    <span class="day-icon"></span>
                </li>
                <li>
                    <span class="day-name"></span>
                    <span class="day-temp"></span>
                    <span class="day-icon"></span>
                </li>
                <li>
                    <span class="day-name"></span>
                    <span class="day-temp"></span>
                    <span class="day-icon"></span>
                </li>
                <li>
                    <span class="day-name"></span>
                    <span class="day-temp"></span>
                    <span class="day-icon"></span>
                </li>
              
            </ul>
        </div>

        <div class="sunTimes">
            <div class="sunrise1">
                <span class="s_title">Sunrise</span>
                <div class="icon"></div>
                <p class="sunrise">${sunrise}</p>
            </div>
            <div class="sunset1">
                
                <span class="s_title">Sunset</span>
                <div class="icon"></div>
                <p class="sunset">${sunset}</p>
            </div>
            
        </div>
  
          <form id="airPollutionForm" action="airPollution.jsp" method="post">
    <button type="submit">Air pollution</button>
</form>
    </div>

</div>
<script>
    document.getElementById("airPollutionForm").addEventListener("submit", function(event) {
        event.preventDefault();
        var formAction = this.getAttribute("action");
        window.location.href = formAction;
    });
    </script>
</body>
</html>

 