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
    height:100vh;
    background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url(weather-forecasting.jpg);
    background-position: center;
    background-size: cover;
    /* filter: blur(2px); */
  }

  .weather-item{
    width:100px;
    height:100px;
    background-color: black;
    color:white;
  }
   #weatherInfo{
    width:90%;
    height:80%;
    background-color: white;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
   }
  </style>
 </head>
 <body>
  <div class="main-container">
    <input type="text" id="locationInput" placeholder="Enter location">
    <button onclick="getWeather()">Get Weather</button>
     
    <div id="weatherInfo"></div>
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
    const date = dateTime.getDate(); // Get the date (1-31)
    const day = dateTime.toLocaleDateString('en-US', { weekday:'long' });
      const time = dateTime.toLocaleTimeString();
      const temperature = item.main.temp;
      const description = item.weather[0].description;

      const weatherItem = document.createElement('div');
      weatherItem.classList.add('weather-item');
      weatherItem.innerHTML = `<p>Date: ${date}</p><br>
                            
                                <p>Temperature: ${temperature} K</p><br>
                                 `;
      weatherInfoDiv.appendChild(weatherItem);
  });
}

  </script>
 </body>
 </html>
