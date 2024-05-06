import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherService {
    private static final String API_KEY = "952fbcfbea27df25158cb787aada0bd2";
    private static final String API_BASE_URL = "https://api.openweathermap.org/data/2.5";

    public JSONObject getCurrentWeatherByCoordinates(double latitude, double longitude) throws IOException {
        String urlString = API_BASE_URL + "/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;
        return callWeatherAPI(urlString);
    }

    public JSONObject getForecastByCoordinates(double latitude, double longitude) throws IOException {
        String urlString = API_BASE_URL + "/forecast?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;
        return callWeatherAPI(urlString);
    }

    public JSONObject getAirPollutionByCoordinates(double latitude, double longitude) throws IOException {
        String urlString = "http://api.openweathermap.org/data/2.5/air_pollution?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;

        JSONObject response = callWeatherAPI(urlString); // Assuming callWeatherAPI fetches data

        // Check for API errors (non-200 status code)
        if (response.has("cod") && response.getInt("cod") != 200) {
            System.err.println("Error: API request failed with code: " + response.getInt("cod"));
            return null;
        }

        // Check for presence of pollution data based on OpenWeatherMap API structure
        if (!response.has("list")) {
            System.err.println("Warning: Pollution data not found in response (might be a different API)");
            return null;
        }

        return response;
    }
    public JSONObject getCurrentWeatherByCityName(String cityName) throws IOException {
        // Encode city name to handle spaces and special characters
        String encodedCityName = URLEncoder.encode(cityName, "UTF-8");
        String urlString = API_BASE_URL + "/weather?q=" + encodedCityName + "&appid=" + API_KEY;
        return callWeatherAPI(urlString);
    }


    private JSONObject callWeatherAPI(String urlString) throws IOException {
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

        return new JSONObject(response.toString());
    }
}