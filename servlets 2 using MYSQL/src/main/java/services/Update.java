package services;

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

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
	}

	public static final Logger logger = Logger.getLogger(Update.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("application/json");
		PrintWriter out = null;
		Connection con = null;
		Statement statement = null;
		String str = null;
		
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = request.getReader();

		while ((str = reader.readLine()) != null) {
			builder.append(str);
			// builder.append(System.lineSeparator());
		}

		String data = builder.toString();
		JSONObject reqObject = new JSONObject(data);

		int EmpID = reqObject.getInt("emp_id");
		String Username = reqObject.getString("username");
		String pass = reqObject.getString("password");
		int DeptID = reqObject.getInt("dept_id");
		logger.info("requesting in the postman for update");

		out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String Url = "jdbc:mysql://localhost:3306/emp1";
			String user = "root";
			String password = "Nithish@123";
			//con = DriverManager.getConnection(Url, user, password);
			System.out.println("connected");

//			satement = con.createStatement();

			String s2 = "UPDATE employee SET username=?,password=?,dept_id=? where emp_id=?";
			PreparedStatement ps = null;
			try {
				con = DriverManager.getConnection(Url, user, password);
				statement = con.createStatement();
				ps = con.prepareStatement(s2);
				ps.setString(1, Username);
				ps.setString(2, pass);
				ps.setInt(3, DeptID);
				ps.setInt(4, EmpID);
				ps.executeUpdate();
				ps.close();

				 //con.close();
				JSONObject obj = new JSONObject();
				obj.put("updated Sucessfully empid=", EmpID);

				logger.info("Updated sucessfully");

				// empId = resultset.getInt("emp_id");
				// JSONObject obj = new JSONObject();
				// obj.put(emp_id,empId);

				out.println(obj);
			} catch (Exception e) {
				System.out.println(e);
			}

			finally {
				if(con!=null)
				out.close();
				statement.close();
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
