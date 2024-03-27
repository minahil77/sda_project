 <!DOCTYPE html>
 <html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    *{
      padding:0;
      margin:0;
    }
  .main-container{
    width:100%;
    height:150vh;
    background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url(weather-forecasting.jpg);
    background-position: center;
    background-size: cover;
    /* filter: blur(2px); */
  }

  .weather-item{
    width:150px;
    height:170px;
    background-color:rgba(255,255,255,0.5);
    color:black;
    margin:10px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    border-radius:10px;
    
  }

   #weatherInfo{
    width:90%;
    height:80%;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
    margin:10px;
   }
   #weatherInfo .day{
    
   }
   #weatherInfo .temp{
     font-size:30px;

   }
   #weatherInfo .date{

}
 
  </style>
 </head>
 <body>
  <div class="main-container">
    <input type="text" id="locationInput" placeholder="Enter location">
    <button onclick="getWeather()">Get Weather</button>
     
    <div id="weatherInfo"></div>
  </div>
   <div class="second-container">

   </div>
  <script >
    function getWeather() {
  const locationInput = document.getElementById('locationInput').value;
  const apiKey = "306ab9cd41753cb018c5190483263290"; // Replace 'YOUR_API_KEY' with your OpenWeatherMap API key
  const apiUrl = `https://api.openweathermap.org/data/2.5/forecast?q=${locationInput}&appid=${apiKey}`;

  fetch(apiUrl)
      .then(response => response.json())
      .then(data => {
          displayWeather(data);
      })
      .catch(error => {
          console.log('Error fetching weather data:', error);
      });
}

function displayWeather(data) {
  const weatherInfoDiv = document.getElementById('weatherInfo');
  weatherInfoDiv.innerHTML = '';

  data.list.forEach(item => {
    const dateTime = new Date(item.dt_txt);
    const date = dateTime.toLocaleDateString('en-US', { day: 'numeric', month: 'long', year: 'numeric' });  
    const day = dateTime.toLocaleDateString('en-US', { weekday:'long' });
      const time = dateTime.toLocaleTimeString();
       temperature = item.main.temp;
      const temp = parseInt(temperature - 273.15);
      const description = item.weather[0].description;
      let weatherEmoji = '';

switch(description) {
  case 'clear sky':
        weatherEmoji = '☀️';
        break;
      case 'few clouds':
      case 'scattered clouds':
      case 'broken clouds':
        weatherEmoji = '🌤️';
        break;
      case 'overcast clouds':
        weatherEmoji = '☁️';
        break;
      case 'light rain':
      case 'moderate rain':
      case 'heavy intensity rain':
      case 'very heavy rain':
      case 'extreme rain':
      case 'freezing rain':
      case 'light intensity shower rain':
      case 'shower rain':
      case 'heavy intensity shower rain':
      case 'ragged shower rain':
        weatherEmoji = '🌧️';
        break;
      case 'thunderstorm with light rain':
      case 'thunderstorm with rain':
      case 'thunderstorm with heavy rain':
      case 'light thunderstorm':
      case 'thunderstorm':
      case 'heavy thunderstorm':
      case 'ragged thunderstorm':
      case 'thunderstorm with light drizzle':
      case 'thunderstorm with drizzle':
      case 'thunderstorm with heavy drizzle':
        weatherEmoji = '⛈️';
        break;
      case 'snow':
      case 'light snow':
      case 'Heavy snow':
      case 'sleet':
      case 'light shower sleet':
      case 'shower sleet':
      case 'light rain and snow':
      case 'rain and snow':
      case 'light shower snow':
      case 'shower snow':
      case 'heavy shower snow':
        weatherEmoji = '❄️';
        break;
      case 'mist':
      case 'smoke':
      case 'haze':
      case 'sand, dust whirls':
      case 'fog':
      case 'sand':
      case 'dust':
      case 'volcanic ash':
      case 'squalls':
      case 'tornado':
        weatherEmoji = '🌫️';
        break;
      default:
        weatherEmoji = '❓'; 

    
}
      const weatherItem = document.createElement('div');
      weatherItem.classList.add('weather-item');
      weatherItem.innerHTML = `<p class="day"> ${day}</p><br>
                          <p class="emoji">${weatherEmoji}</p><br>
                                <p class="temp">${temp} </p><br>
                               <p class="date">${date}</p><br>
                               
                                 `;
      weatherInfoDiv.appendChild(weatherItem);
  });
}

  </script>
 </body>
 </html>
