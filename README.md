# sda_project

# Weather Application description 

Welcome to the Weather Application project! This application is designed to provide users with weather forecasts for multiple locations, along with additional features such as current weather conditions, sunrise and sunset times, weather forecasts for 5 days, cache management to reduce API calls, notifications for poor weather conditions, and air pollution data.In this project, users can add multiple locations by providing either longitude and latitude coordinates or city and country names. The application retrieves current weather conditions for the selected location, including basic information like "Feels like," "Minimum temperature," and "Maximum temperature." Additionally, users can view sunrise and sunset times, as well as weather forecasts for the next 5 days.To enhance performance and reduce the load on the OpenWeatherMap API, the application implements cache management using a database. Weather data for frequently accessed locations is stored in the database, and subsequent requests for the same location on the same day fetch the data from the cache instead of making additional API calls. Notifications are generated to alert users about poor weather conditions and air quality. The application integrates with a notification service to deliver timely alerts to users.
The Weather Application is developed in Java and utilizes the OpenWeatherMap API for weather data retrieval.  

# Installation and Setup
1.Clone the repository from [GitHub URL].
2.Install the necessary dependencies.
3.Configure the API keys for OpenWeatherMap (or any other weather data provider) and notification service.
4.Set up the database.
5.Run the application
