package com.servlets.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

//@WebServlet("/Users")

public class Users extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String line = null;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = req.getReader();

		while ((line = reader.readLine()) != null) {
			builder.append(line);
			builder.append(System.lineSeparator());
		}
		String data = builder.toString();

		JSONObject JsonObject = new JSONObject(data);
		
		JSONObject JsonObject1 = JsonObject.getJSONObject("request");
		JSONObject JsonObject2 = JsonObject1.getJSONObject("data");
		String status = JsonObject2.getString("petStatus");

		PrintWriter out = res.getWriter();

		URL url = new URL("https://petstore.swagger.io/v2/pet/findByStatus?status=" + status);
		URLConnection con = url.openConnection();
		// BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		InputStreamReader inputstream = new InputStreamReader(con.getInputStream());
		BufferedReader reader1 = new BufferedReader(inputstream);

		StringBuilder builder1 = new StringBuilder();
		String val = null;
		while ((val = reader1.readLine()) != null) {
			builder1.append(val);

		}
		res.setContentType("application/json");// print format in POSTMAN response
		String str = builder1.toString();

		JSONArray arr = new JSONArray(str);
		JSONObject response1 = new JSONObject();
		response1.put("pets", arr);
		
		JSONObject response2 = new JSONObject();
		response2.put("response", response1);

		out.println(response2);
		reader1.close();

	}
}
