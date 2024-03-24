package sdaWeatherPorject.porject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class weatherService {
    private final String API_KEY = "YOUR_API_KEY_HERE";
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

            String weatherDescription = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

            String message = String.format("Current Weather:\nTemperature: %.2f°C\nFeels like: %.2f°C\nMin Temperature: %.2f°C\nMax Temperature: %.2f°C\nHumidity: %.2f%%\nDescription: %s",
                    temperature - 273.15, feelsLike - 273.15, minTemperature - 273.15, maxTemperature - 273.15, humidity, weatherDescription);
            JOptionPane.showMessageDialog(null, message, "Current Weather", JOptionPane.INFORMATION_MESSAGE);
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
