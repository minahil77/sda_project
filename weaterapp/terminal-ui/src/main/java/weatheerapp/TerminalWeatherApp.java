package sdaWeatherPorject.porject;

import java.util.Scanner;

public class TerminalWeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherService weatherService = new WeatherService();

        System.out.println("Welcome to the Weather App!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Location by Latitude and Longitude");
            System.out.println("2. Add Location by City/Country Name");
            System.out.println("3. Show Current Weather");
            System.out.println("4. Show Weather Forecast for 5 Days");
            System.out.println("5. Show Air Pollution Data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter latitude: ");
                    double latitude = scanner.nextDouble();
                    System.out.print("Enter longitude: ");
                    double longitude = scanner.nextDouble();
                    weatherService.addLocationByCoordinates(latitude, longitude);
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter country code: ");
                    String country = scanner.nextLine();
                    weatherService.addLocationByCityName(city, country);
                    break;
                case 3:
                    System.out.println("Current Weather:");
                    weatherService.showCurrentWeather();
                    break;
                case 4:
                    System.out.println("Weather Forecast for 5 Days:");
                    weatherService.showWeatherForecast();
                    break;
                case 5:
                    System.out.println("Air Pollution Data:");
                    weatherService.showAirPollutionData();
                    break;
                case 6:
                    System.out.println("Exiting Weather App. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
