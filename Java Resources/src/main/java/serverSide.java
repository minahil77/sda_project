package sda_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class serverSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public serverSide() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userInput=request.getParameter("inputArea");
		System.out.println(userInput);
		 
		String key="306ab9cd41753cb018c5190483263290";
		String url="https://api.openweathermap.org/data/2.5/weather?q=" +userInput+"&appid=" + key;
		URL apiURL=new URL (url);
		HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
           connection.setRequestMethod("GET");
        InputStream inputConnection = connection.getInputStream();
        InputStreamReader read_information = new InputStreamReader(inputConnection);
        
        
        Scanner scanner = new Scanner(read_information);
        StringBuilder saveResponse = new StringBuilder();
        
        while (scanner.hasNext()) {
        	 saveResponse.append(scanner.nextLine());
        }
        
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson( saveResponse.toString(), JsonObject.class);
        scanner.close();
        
      //Getting date,day and time
        long fetchdate = jsonObject.get("dt").getAsLong() * 1000;
         Date date = new Date(fetchdate);
        SimpleDateFormat temp_date = new SimpleDateFormat("dd-MM-yyyy");
        String date1 = temp_date.format(date);
        SimpleDateFormat temp_day= new SimpleDateFormat("EEEE");
        String day = temp_day.format(date);
        //Temperature
        double temperature_in_K = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
        int temperature_in_C = (int) (temperature_in_K- 273.15);
       
        int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
        
        double wind = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
       
        double longt=jsonObject.getAsJsonObject("coord").get("lon").getAsDouble();
        double latitude=jsonObject.getAsJsonObject("coord").get("lat").getAsDouble();
        // sunrise time
        long sunrise=jsonObject.getAsJsonObject("sys").get("sunrise").getAsLong();
       long timesun=sunrise;
        Date sunriseDate = new Date(timesun * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        sdf.setTimeZone(TimeZone.getDefault()); // Adjust timezone if needed
        String sunriseTime = sdf.format(sunriseDate);
        
        //sunset time
        long sunset=jsonObject.getAsJsonObject("sys").get("sunset").getAsLong();
       long timeset=sunset;
        Date sunsetDate = new Date(timeset * 1000);
        SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm a");
        sdf1.setTimeZone(TimeZone.getDefault()); // Adjust timezone if needed
        String sunsetTime = sdf1.format(sunsetDate);
        
        String currentWeather = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").toString();
        
       // icon 
//        String icon1 = jsonObject.getAsJsonArray("weather").get(1).getAsJsonObject().get("icon").toString();

      
        
        request.setAttribute("city", userInput);
        request.setAttribute("temperature", temperature_in_C);
        request.setAttribute("desp",currentWeather ); 
        request.setAttribute("humidity", humidity);    
        request.setAttribute("wind", wind);
        request.setAttribute("longitude", longt);
        request.setAttribute("latitude", latitude);
 // sunrise
        request.setAttribute("sunrise", sunriseTime);
        request.setAttribute("sunset", sunsetTime);
        request.setAttribute("date1", date1); 
        request.setAttribute("day", day); 
//        request.setAttribute("icon1", icon1); 
        
        request.setAttribute("weatherData", saveResponse.toString());
        request.getRequestDispatcher("internal.jsp").forward(request, response);
        
        
        //5 days 3 hours interval forecast
 
	doGet(request, response);
	}
     
}
