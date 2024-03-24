package sdaWeatherPorject.porject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextBasedStorage {
    private static final String FILE_NAME = "weather_data.txt";
    public static void saveWeatherData(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving weather data to file: " + e.getMessage());
        }
    }
    public static List<String> loadWeatherData() {
        List<String> weatherData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                weatherData.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading weather data from file: " + e.getMessage());
        }
        return weatherData;
    }
    public static void clearWeatherData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(""); 
        } catch (IOException e) {
            System.err.println("Error clearing weather data from file: " + e.getMessage());
        }
    }
}
