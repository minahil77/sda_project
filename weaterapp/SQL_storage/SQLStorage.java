package weaterapp.SQL_storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLStorage {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/weather_db";
    private static final String JDBC_USER = "ALIAHSAN";
    private static final String JDBC_PASSWORD = "12345678";

    public static void saveWeatherData(String location, double latitude, double longitude,
            double temperature, double feelsLike, double minTemperature,
            double maxTemperature, double humidity, String weatherDescription) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO weather_data (location, latitude, longitude, temperature, feels_like, min_temperature, max_temperature, humidity, weather_description) "
                    +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, location);
            statement.setDouble(2, latitude);
            statement.setDouble(3, longitude);
            statement.setDouble(4, temperature);
            statement.setDouble(5, feelsLike);
            statement.setDouble(6, minTemperature);
            statement.setDouble(7, maxTemperature);
            statement.setDouble(8, humidity);
            statement.setString(9, weatherDescription);
            statement.executeUpdate();
            System.out.println("Weather data saved successfully.");
        } catch (SQLException e) {
            System.err.println("Error saving weather data to database: " + e.getMessage());
        }
    }
}
