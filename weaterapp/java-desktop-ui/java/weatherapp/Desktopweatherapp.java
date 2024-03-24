// package com.weatherapp;

// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class DesktopWeatherApp {
//     private JFrame frame;
//     private JTextField latitudeField;
//     private JTextField longitudeField;

//     public DesktopWeatherApp() {
//         initialize();
//     }

//     private void initialize() {
//         frame = new JFrame("Desktop Weather App");
//         frame.setBounds(100, 100, 450, 300);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.getContentPane().setLayout(null);

//         JLabel lblLatitude = new JLabel("Latitude:");
//         lblLatitude.setBounds(20, 30, 70, 20);
//         frame.getContentPane().add(lblLatitude);

//         latitudeField = new JTextField();
//         latitudeField.setBounds(100, 30, 150, 20);
//         frame.getContentPane().add(latitudeField);
//         latitudeField.setColumns(10);

//         JLabel lblLongitude = new JLabel("Longitude:");
//         lblLongitude.setBounds(20, 60, 70, 20);
//         frame.getContentPane().add(lblLongitude);

//         longitudeField = new JTextField();
//         longitudeField.setBounds(100, 60, 150, 20);
//         frame.getContentPane().add(longitudeField);
//         longitudeField.setColumns(10);

//         JButton btnShowWeather = new JButton("Show Weather");
//         btnShowWeather.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 double latitude = Double.parseDouble(latitudeField.getText());
//                 double longitude = Double.parseDouble(longitudeField.getText());
//                 WeatherService weatherService = new WeatherService();
//                 weatherService.showCurrentWeather(latitude, longitude);
//             }
//         });
//         btnShowWeather.setBounds(100, 90, 150, 30);
//         frame.getContentPane().add(btnShowWeather);
//     }

//     public void setVisible(boolean visible) {
//         frame.setVisible(visible);
//     }
// }
