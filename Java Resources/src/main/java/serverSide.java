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
import java.util.Date;
import java.util.Scanner;

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
    //Accesing API
		String key="306ab9cd41753cb018c5190483263290";
		String url="https://api.openweathermap.org/data/2.5/weather?q=" +userInput+"&appid=" + key;
		URL apiURL=new URL (url);
		HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
           connection.setRequestMethod("GET");
		doGet(request, response);
	}

}
