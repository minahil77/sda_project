CREATE DATABASE IF NOT EXISTS weather_db;
USE weather_db;
CREATE TABLE IF NOT EXISTS weather_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255),
    latitude DOUBLE,
    longitude DOUBLE,
    temperature DOUBLE,
    feels_like DOUBLE,
    min_temperature DOUBLE,
    max_temperature DOUBLE,
    humidity DOUBLE,
    weather_description VARCHAR(255),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS air_pollution_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255),
    latitude DOUBLE,
    longitude DOUBLE,
    co DOUBLE,
    no DOUBLE,
    no2 DOUBLE,
    o3 DOUBLE,
    so2 DOUBLE,
    nh3 DOUBLE,
    pm2_5 DOUBLE,
    pm10 DOUBLE,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
