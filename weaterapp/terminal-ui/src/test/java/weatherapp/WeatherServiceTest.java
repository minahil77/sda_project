package sdaWeatherPorject.porject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {
    @Test
    public void testAddLocationByCoordinates() {
        WeatherService weatherService = new WeatherService();
        double latitude = 40.7128;
        double longitude = -74.0060;
        weatherService.addLocationByCoordinates(latitude, longitude);
    }
    @Test
    public void testAddLocationByCityName() {
        WeatherService weatherService = new WeatherService();
        String city = "New York";
        String country = "US";
        weatherService.addLocationByCityName(city, country);
    }
    @Test
    public void testShowCurrentWeather() {
        WeatherService weatherService = new WeatherService();
        double latitude = 40.7128;
        double longitude = -74.0060;
        weatherService.showCurrentWeather(latitude, longitude);
    }
    @Test
    public void testShowWeatherForecast() {
        WeatherService weatherService = new WeatherService();
        double latitude = 40.7128; 
        double longitude = -74.0060;
        weatherService.showWeatherForecast(latitude, longitude);
    }
    @Test
    public void testShowAirPollutionData() {
        WeatherService weatherService = new WeatherService();
        double latitude = 40.7128; 
        double longitude = -74.0060;
        weatherService.showAirPollutionData(latitude, longitude);
    }
}
