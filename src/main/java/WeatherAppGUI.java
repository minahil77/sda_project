import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherAppGUI extends JFrame {
    private JTextField latitudeField, longitudeField, cityNameField; // Added cityNameField
    private JButton getWeatherButton, getAirPollutionButton, getForecastButton, getWeatherByCityButton; // Added button for forecast and by city
    private JTextArea resultArea;
    private WeatherService weatherService;

    public WeatherAppGUI() {
        setTitle("Weather Application");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        weatherService = new WeatherService();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        latitudeField = new JTextField(10);
        longitudeField = new JTextField(10);
        cityNameField = new JTextField(15); // Added cityNameField
        getWeatherButton = new JButton("Get Weather");
        getAirPollutionButton = new JButton("Get Air Pollution");
        getForecastButton = new JButton("Get Forecast");
        getWeatherByCityButton = new JButton("Get Weather by City"); // Added getWeatherByCityButton
        inputPanel.add(new JLabel("Latitude: "));
        inputPanel.add(latitudeField);
        inputPanel.add(new JLabel("Longitude: "));
        inputPanel.add(longitudeField);
        inputPanel.add(new JLabel("City Name: ")); // Added label for city name
        inputPanel.add(cityNameField); // Added cityNameField
        inputPanel.add(getWeatherButton);
        inputPanel.add(getAirPollutionButton);
        inputPanel.add(getForecastButton);
        inputPanel.add(getWeatherByCityButton); // Added getWeatherByCityButton

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultArea = new JTextArea(15, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(new JLabel("Information:"), BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(resultPanel, BorderLayout.CENTER);

        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double latitude = Double.parseDouble(latitudeField.getText());
                    double longitude = Double.parseDouble(longitudeField.getText());

                    JSONObject currentWeather = weatherService.getCurrentWeatherByCoordinates(latitude, longitude);
                    displayWeatherInfo(currentWeather);

                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(WeatherAppGUI.this,
                            "Invalid input or API error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getAirPollutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double latitude = Double.parseDouble(latitudeField.getText());
                    double longitude = Double.parseDouble(longitudeField.getText());

                    JSONObject airPollution = weatherService.getAirPollutionByCoordinates(latitude, longitude);
                    if (airPollution != null) {
                        displayAirPollutionInfo(airPollution);
                    } else {
                        JOptionPane.showMessageDialog(WeatherAppGUI.this,
                                "No data found for the provided coordinates.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(WeatherAppGUI.this,
                            "Invalid input or API error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getForecastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double latitude = Double.parseDouble(latitudeField.getText());
                    double longitude = Double.parseDouble(longitudeField.getText());

                    JSONObject forecast = weatherService.getForecastByCoordinates(latitude, longitude);
                    if (forecast != null) {
                        displayForecastInfo(forecast);
                    } else {
                        JOptionPane.showMessageDialog(WeatherAppGUI.this,
                                "No data found for the provided coordinates.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(WeatherAppGUI.this,
                            "Invalid input or API error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getWeatherByCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cityName = cityNameField.getText(); // Get city name from text field

                    JSONObject currentWeather = weatherService.getCurrentWeatherByCityName(cityName);
                    displayWeatherInfo(currentWeather);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(WeatherAppGUI.this,
                            "Invalid input or API error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(mainPanel);
    }

    private void displayWeatherInfo(JSONObject weatherData) {
        StringBuilder info = new StringBuilder();
        info.append("Location: ").append(weatherData.getString("name")).append("\n");
        JSONObject main = weatherData.getJSONObject("main");
        info.append("Temperature: ").append(main.getDouble("temp")/10).append("°C\n");
        info.append("Feels like: ").append(main.getDouble("feels_like")/10).append("°C\n");
        info.append("Min Temperature: ").append(main.getDouble("temp_min")/10).append("°C\n");
        info.append("Max Temperature: ").append(main.getDouble("temp_max")/10).append("°C\n");
        info.append("Humidity: ").append(main.getInt("humidity")).append("%\n");
        JSONObject sys = weatherData.getJSONObject("sys");
        info.append("Sunrise: ").append(new java.util.Date(sys.getLong("sunrise") * 1000)).append("\n");
        info.append("Sunset: ").append(new java.util.Date(sys.getLong("sunset") * 1000)).append("\n");

        resultArea.setText(info.toString());
    }

    private void displayAirPollutionInfo(JSONObject airPollutionData) {
        StringBuilder info = new StringBuilder();

        try {
            // Access pollution data assuming it's within a "list" key
            JSONArray pollutionList = airPollutionData.getJSONArray("list");
            JSONObject pollutionData = pollutionList.getJSONObject(0);

            info.append("Air Pollution Information:\n");
            info.append("CO: ").append(pollutionData.getJSONObject("components").getDouble("co")).append(" µg/m³\n");
            info.append("NO: ").append(pollutionData.getJSONObject("components").getDouble("no")).append(" µg/m³\n");
            info.append("NO2: ").append(pollutionData.getJSONObject("components").getDouble("no2")).append(" µg/m³\n");
            info.append("O3: ").append(pollutionData.getJSONObject("components").getDouble("o3")).append(" µg/m³\n");
            info.append("SO2: ").append(pollutionData.getJSONObject("components").getDouble("so2")).append(" µg/m³\n");
            info.append("NH3: ").append(pollutionData.getJSONObject("components").getDouble("nh3")).append(" µg/m³\n");
            info.append("PM2.5: ").append(pollutionData.getJSONObject("components").getDouble("pm2_5")).append(" µg/m³\n");
            info.append("PM10: ").append(pollutionData.getJSONObject("components").getDouble("pm10")).append(" µg/m³\n");
        } catch (JSONException e) {
            // Handle exception if "list" key is missing or data is invalid
            System.err.println("Error parsing pollution data: " + e.getMessage());
            info.append("Error retrieving pollution information.");
        }

        resultArea.setText(info.toString());
    }


    private void displayForecastInfo(JSONObject forecastData) {
        StringBuilder info = new StringBuilder();

        try {
            JSONArray forecastList = forecastData.getJSONArray("list");
            for (int i = 0; i < forecastList.length(); i++) {
                JSONObject forecastEntry = forecastList.getJSONObject(i);
                long dateTime = forecastEntry.getLong("dt");
                JSONObject main = forecastEntry.getJSONObject("main");
                double temperature = main.getDouble("temp");
                JSONArray weatherArray = forecastEntry.getJSONArray("weather");
                JSONObject weatherObject = weatherArray.getJSONObject(0);
                String weatherDescription = weatherObject.getString("description");

                // Convert Unix timestamp to human-readable date and time
                String formattedDateTime = formatUnixTimestamp(dateTime);

                info.append("DateTime: ").append(formattedDateTime)
                        .append(", Temperature: ").append(temperature).append("°C")
                        .append(", Weather: ").append(weatherDescription).append("\n");
            }
        } catch (JSONException e) {
            System.err.println("Error parsing forecast data: " + e.getMessage());
            info.append("Error retrieving forecast information.");
        }

        resultArea.setText(info.toString());
    }

    private String formatUnixTimestamp(long unixTimestamp) {
        // Convert Unix timestamp to milliseconds
        long unixSeconds = unixTimestamp;
        // Unix timestamp is in seconds, convert to milliseconds
        Date date = new java.util.Date(unixSeconds * 1000L);
        // Format the date
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WeatherAppGUI appGUI = new WeatherAppGUI();
            appGUI.setVisible(true);
        });
    }
}
