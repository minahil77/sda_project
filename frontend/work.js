document.getElementById('city').addEventListener('input', function () {
var city = this.value;
getWeather(city);
});

async function getWeather() {
try {
  var city = document.getElementById('city').value;
  console.log('Şəhər adı:', city);

  const response = await axios.get('https://api.openweathermap.org/data/2.5/forecast', {
      params: {
          q: city,
          appid: '54a57bc234ad752a4f59e59cd372201d',
          units: 'metric'
      },
  });

  const longitude = response.data.city.coord.lon;
    const latitude = response.data.city.coord.lat;
    document.querySelector('.longitude').textContent = 'Lon: ' + longitude;
    document.querySelector('.latitude').textContent = 'Lat: ' + latitude;

    const sunriseTimestamp = response.data.city.sunrise;
    const sunsetTimestamp = response.data.city.sunset;
    const sunriseTime = new Date(sunriseTimestamp * 1000).toLocaleTimeString();
    const sunsetTime = new Date(sunsetTimestamp * 1000).toLocaleTimeString();
    document.querySelector('.sunrise').textContent = 'Time: ' + sunriseTime;
    document.querySelector('.sunset').textContent = 'Time: ' + sunsetTime;
  const currentTemperature = response.data.list[0].main.temp;

  
 
  
  document.querySelector('.weather-temp').textContent = Math.round(currentTemperature) + 'ºC';

  const forecastData = response.data.list;

  const dailyForecast = {};
  forecastData.forEach((data) => {
      const day = new Date(data.dt * 1000).toLocaleDateString('en-US', { weekday: 'long' });
      if (!dailyForecast[day]) {
          dailyForecast[day] = {
              minTemp: data.main.temp_min,
              maxTemp: data.main.temp_max,
              description: data.weather[0].description,
              humidity: data.main.humidity,
              windSpeed: data.wind.speed,
              icon: data.weather[0].icon,


          };
      } else {
          dailyForecast[day].minTemp = Math.min(dailyForecast[day].minTemp, data.main.temp_min);
          dailyForecast[day].maxTemp = Math.max(dailyForecast[day].maxTemp, data.main.temp_max);
      }
  });
