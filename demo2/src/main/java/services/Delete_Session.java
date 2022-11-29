package src.main.java.services;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;


public class Delete_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Delete_Session() {
    }
    public static final Logger logger = Logger.getLogger(Delete_Session.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			response.setContentType("application/json");
			logger.info("JOSN FORMAT");
			PrintWriter out = null;
			Connection con = null;
			Statement statement = null;
			String str = null;
			// Statement statement = con.createStatement();
			

			StringBuilder builder = new StringBuilder();
			BufferedReader reader = request.getReader();

			while ((str = reader.readLine()) != null) {
				builder.append(str);
				// builder.append(System.lineSeparator());
			}

			String data = builder.toString();
			JSONObject reqObject = new JSONObject(data);

			int EmpID = reqObject.getInt("emp_id");
			String SessionID = reqObject.getString("session_id");

			out = response.getWriter();

			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String Url = "jdbc:mysql://localhost:3306/emp1";
			String user = "root";
			String password = "Nithish@123";
			//con = DriverManager.getConnection(Url, user, password);
			System.out.println("connected");
			
		
			String s1 = "DELETE from session where session_id=?";
			PreparedStatement ps = null;
			try {
			con = DriverManager.getConnection(Url, user, password);
			statement = con.createStatement();
			ps = con.prepareStatement(s1);
			ps.setString(1, SessionID);
			ps.executeUpdate();
			ps.close();
			//con.close();
			JSONObject obj = new JSONObject();
			obj.put("loggedout and deleted the session id from empid=",EmpID);
			logger.info("THE CURRENT USER IS LOGGEDOUT");
			logger.error("THE INVALID");
			out.println(obj);
			
		} catch (Exception exception) {
			System.out.println(exception);
		}
			finally {
				if(con!=null)
				con.close();
				out.close();
				statement.close();
				
			}
			}
			catch(Exception e)
			{
				System.out.println();
			}

	}
    
}
