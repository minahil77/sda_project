package PROJECT;



import jakarta.servlet.ServletException; 
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
import com.google.gson.JsonObject;

import com.google.gson.Gson;


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
        sdf.setTimeZone(TimeZone.getDefault());
        String sunriseTime = sdf.format(sunriseDate);
        
        //sunset time
        long sunset=jsonObject.getAsJsonObject("sys").get("sunset").getAsLong();
       long timeset=sunset;
        Date sunsetDate = new Date(timeset * 1000);
        SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm a");
        sdf1.setTimeZone(TimeZone.getDefault()); 
        String sunsetTime = sdf1.format(sunsetDate);
        
        String currentWeather = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").toString();
        
       // icon 
//        String icon1 = jsonObject.getAsJsonArray("weather").get(1).getAsJsonObject().get("icon").toString();

      
        
     
 //air pollution
//        String air_url="http://api.openweathermap.org/data/2.5/air_pollution?lat="+latitude+"&lon="+longt+"&appid="+key;
//        URL airApi=new URL (air_url);
//		HttpURLConnection connection2 = (HttpURLConnection) airApi.openConnection();
//           connection2.setRequestMethod("GET");
//        InputStream inputConnection2 = connection2.getInputStream();
//        InputStreamReader read_information2 = new InputStreamReader(inputConnection2);
        
        
//    
//        StringBuilder saveResponse2 = new StringBuilder();
//        Scanner scanner2 = new Scanner(read_information2);
//        
//        while (scanner2.hasNext()) {
//        	 saveResponse2.append(scanner2.nextLine());
//        }
//        System.out.println(saveResponse2);
//        Gson gson2 = new Gson();
//        JsonObject jsonObject2 = gson2.fromJson(saveResponse2.toString(), JsonObject.class);
//        scanner2.close();
//        
           
          
//        double co = jsonObject2.getAsJsonArray("list").get(0).getAsJsonObject().getAsJsonObject("components").getAsJsonObject().get("co").getAsDouble();
//        double no = jsonObject2.getAsJsonArray("list").get(0).getAsJsonObject().getAsJsonObject("components").getAsJsonObject().get("no").getAsDouble();
//        double no2 = jsonObject2.getAsJsonArray("list").get(0).getAsJsonObject().get("components").getAsJsonObject().get("no2").getAsDouble();
//        double o3 = jsonObject2.getAsJsonArray("list").get(0).getAsJsonObject().get("components").getAsJsonObject().get("o3").getAsDouble();
//        double so2 = jsonObject2.getAsJsonArray("list").get(0).getAsJsonObject().get("components").getAsJsonObject().get("so2").getAsDouble();

          
//          long co=jsonObject2.getAsJsonObject("components").get("co").getAsLong();
//          long no=jsonObject2.getAsJsonObject("components").get("no").getAsLong();
//          long no2=jsonObject2.getAsJsonObject("components").get("no2").getAsLong();
//          long o3=jsonObject2.getAsJsonObject("components").get("o3").getAsLong();
//          long so2=jsonObject2.getAsJsonObject("components").get("so2").getAsLong();
          
//          request.setAttribute("co", co);
//          request.setAttribute("no",no);
        
        
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
//          request.setAttribute("icon1", icon1); 
          
          request.setAttribute("weatherData", saveResponse.toString());
//          request.setAttribute("weatherData1", saveResponse2.toString());
          
          request.getRequestDispatcher("internal.jsp").forward(request, response);
           
          
        //5 days 3 hours interval forecast
//        String for_url="api.openweathermap.org/data/2.5/forecast?q="+userInput+"&appid="+key;
//
//        URL forapiURL=new URL (for_url);
        // putting all the data into a list
       
//        
//      HttpURLConnection connection1 = (HttpURLConnection) forapiURL.openConnection();
//        connection1.setRequestMethod("GET");
//     InputStream inputConnection1 = connection1.getInputStream();
//     InputStreamReader read_information1= new InputStreamReader(inputConnection1);
//     
//     
//     StringBuilder saveResponse1= new StringBuilder();
//     Scanner scanner1= new Scanner(read_information);
//     while (scanner1.hasNext()) {
//     	 saveResponse1.append(scanner.nextLine());
//     }
//     scanner.close();
//     Gson gson1 = new Gson();
//     JsonObject jsonObject1 = gson.fromJson( saveResponse1.toString(), JsonObject.class);
//     scanner1.close();
//     
//     JsonArray forecastList = JsonParser.parseString(jsonObject1 ).getAsJsonObject().getAsJsonArray("list");
//
//// Process forecast data and store in a list of objects
//     List<Forecast> forecasts = new ArrayList<>();
//     
//       for (JsonElement element : forecastList) {
//       
//    	   double temperature_in_K1 = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
//           int temperature_in_C1 = (int) (temperature_in_K1- 273.15);
//           request.setAttribute("temperature1", temperature_in_C);
// 
//       request.setAttribute("weatherData", saveResponse1.toString());
//       request.getRequestDispatcher("internal.jsp").forward(request, response);
       
		doGet(request, response);
	}
     
}
