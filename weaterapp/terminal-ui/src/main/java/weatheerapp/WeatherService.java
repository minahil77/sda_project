package sdaWeatherPorject.porject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherService {
    private final String API_KEY = "YOUR_API_KEY_HERE";
    public void addLocationByCoordinates(double latitude, double longitude) {
        System.out.println("Location added successfully: Latitude " + latitude + ", Longitude " + longitude);
    }
    public void addLocationByCityName(String city, String country) {
        System.out.println("Location added successfully: " + city + ", " + country);
    }
    public void showCurrentWeather(double latitude, double longitude) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;
        try {
            String jsonResponse = makeHttpRequest(apiUrl);
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject main = jsonObject.getJSONObject("main");
            double temperature = main.getDouble("temp");
            double feelsLike = main.getDouble("feels_like");
            double minTemperature = main.getDouble("temp_min");
            double maxTemperature = main.getDouble("temp_max");
            double humidity = main.getDouble("humidity");
            System.out.println("Current Weather:");
            System.out.println("Temperature: " + temperature);
            System.out.println("Feels like: " + feelsLike);
            System.out.println("Min Temperature: " + minTemperature);
            System.out.println("Max Temperature: " + maxTemperature);
            System.out.println("Humidity: " + humidity);
        } catch (IOException e) {
            System.err.println("Error making HTTP request: " + e.getMessage());
        }
    }
    public void showWeatherForecast(double latitude, double longitude) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;
        try {
            String jsonResponse = makeHttpRequest(apiUrl);
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray forecastList = jsonObject.getJSONArray("list");
            System.out.println("Weather Forecast for 5 Days:");
            for (int i = 0; i < forecastList.length(); i++) {
                JSONObject forecast = forecastList.getJSONObject(i);
                JSONObject main = forecast.getJSONObject("main");
                double temperature = main.getDouble("temp");
                System.out.println("Day " + (i + 1) + " Temperature: " + temperature);
            }
        } catch (IOException e) {
            System.err.println("Error making HTTP request: " + e.getMessage());
        }
    }
    public void showAirPollutionData(double latitude, double longitude) {
        String apiUrl = "http://api.openweathermap.org/data/2.5/air_pollution?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;
        try {
            String jsonResponse = makeHttpRequest(apiUrl);
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject components = jsonObject.getJSONObject("list").getJSONObject(0).getJSONObject("components");
            double co = components.getDouble("co");
            double no = components.getDouble("no");
            double no2 = components.getDouble("no2");
            double o3 = components.getDouble("o3");
            double so2 = components.getDouble("so2");
            double nh3 = components.getDouble("nh3");
            double pm2_5 = components.getDouble("pm2_5");
            double pm10 = components.getDouble("pm10");
            System.out.println("Air Pollution Data:");
            System.out.println("Carbon monoxide (CO): " + co);
            System.out.println("Nitrogen monoxide (NO): " + no);
            System.out.println("Nitrogen dioxide (NO2): " + no2);
            System.out.println("Ozone (O3): " + o3);
            System.out.println("Sulphur dioxide (SO2): " + so2);
            System.out.println("Ammonia (NH3): " + nh3);
            System.out.println("Particulates PM2.5: " + pm2_5);
            System.out.println("Particulates PM10: " + pm10);
        } catch (IOException e) {
            System.err.println("Error making HTTP request: " + e.getMessage());
        }
    }
    private String makeHttpRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        conn.disconnect();
        return response.toString();
    }
}
