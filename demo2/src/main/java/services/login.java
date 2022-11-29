package services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

//import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


public class login extends HttpServlet {
	 boolean isValidCredentials;
	public login() {    
    }

	private static final long serialVersionUID = 1L;
      
    public static final Logger logger = Logger.getLogger(login.class);
    	
    	@Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    		
    			logger.debug("logging debug messages");

    			res.setContentType("application/json");
    			PrintWriter out = null;
    			Connection con = null;
    			Statement statement = null;
    			String str = null;
    			// Statement statement = con.createStatement();
    			PreparedStatement ps = null;

    			ResultSet resultset = null, res2 = null, res3 = null;

    			StringBuilder builder = new StringBuilder();
    			BufferedReader reader = req.getReader();

    			while ((str = reader.readLine()) != null) {
    				builder.append(str);
    				builder.append(System.lineSeparator());
    			}

    			String data = builder.toString();
    			JSONObject reqObject = new JSONObject(data);
    			logger.info("REQUESTING ");

    			String Username = reqObject.getString("username");
    			String pass = reqObject.getString("password");
    			System.out.println(Username + " " + pass);
    			logger.debug("USER NAME AND PASSWORD IS FETCHING ");
    			out = res.getWriter();
    			try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			String Url = "jdbc:mysql://localhost:3306/emp1";
    			String user = "root";
    			String password = "Nithish@123";
    			con = DriverManager.getConnection(Url, user, password);
    			System.out.println("connected");
    			logger.info("Login::JDBC connection is established");
//    			Logger log=Logger.getLogger();
//    			BasicConfigurator.configure();

    			statement = con.createStatement();
    			String s1 = "Select * from employee where username= ? and password= ? ";

    			ps = con.prepareStatement(s1);
    			ps.setString(1, Username);
    			ps.setString(2, pass);
    			// System.out.println("result value ");
    			resultset = ps.executeQuery();

    			int ID = 0;
    			int departmentId = 0;
    			boolean isValidCredentials = false;
    			while (resultset.next()) {

    				// String str1 = resultset.getString(0);
    				isValidCredentials = true;
    				ID = resultset.getInt("emp_id");
    				departmentId = resultset.getInt("dept_id");

    			}
    			JSONObject responseobj = new JSONObject();

    			if (isValidCredentials) {
    				UUID uuid = UUID.randomUUID();
    				String uuidAsString = uuid.toString();
    				long currentTime = System.currentTimeMillis();

    				// Insert session data
    				String sql = "INSERT INTO session(session_id,emp_id,login_time,logout_time) VALUES(?,?,?,?)";
    				ps = con.prepareStatement(sql);
    				ps.setString(1, uuidAsString);
    				ps.setLong(2, ID);
    				ps.setLong(3, currentTime);
    				ps.setLong(4, 0);
    				ps.executeUpdate();

    				String s2 = "SELECT dept_name from department WHERE dept_id=?";
    				ps = con.prepareStatement(s2);
    				ps.setInt(1, departmentId);
    				res2 = ps.executeQuery();
    				// System.out.println("result value 1");
    				String departmentName = "";
    				while (res2.next()) {
    					departmentName = res2.getString("dept_name");
    				}

    				if (departmentName.equalsIgnoreCase("admin")) {
    					String s3 = "Select e.emp_id, e.name, e.username, e.dept_id, b.dept_name from employee as e INNER Join department as b on e.dept_id=b.dept_id;";
    					ps = con.prepareStatement(s3);
    					res3 = ps.executeQuery();
    					logger.info("The user is in admin dept" );
;
    					JSONArray arr = new JSONArray();

    					while (res3.next()) {

    						int EmpId = res3.getInt("emp_id");
    						String EName = res3.getString("name");
    						String DeptName = res3.getString("dept_name");
    						String username = res3.getString("username");
    						int DeptId = res3.getInt("dept_id");

    						JSONObject obj = new JSONObject();

    						obj.put("emp_id", EmpId);
    						obj.put("name", EName);
    						obj.put("username", username);
    						obj.put("dept_id", DeptId);
    						obj.put("dept_name", DeptName);
    						arr.put(obj);
    					}
    					System.out.println(arr);
    					responseobj.put("data", arr);
    					responseobj.put("sessionId", uuidAsString);
    					out.print(responseobj);

    				} else {
    					System.out.println(Username);
    					String s4 = "select * from employee where username=?";
    					ps = con.prepareStatement(s4);
    					ps.setString(1, Username);
    					res3 = ps.executeQuery();
    					logger.info("The user is not a admin dept");

    					JSONArray arr = new JSONArray();

    					while (res3.next()) {
    						int EmpId = res3.getInt("emp_id");
    						String EName = res3.getString("name");
    						String username = res3.getString("username");
    						int DeptId = res3.getInt("dept_id");

    						JSONObject obj = new JSONObject();
    						obj.put("emp_id", EmpId);
    						obj.put("name", EName);
    						obj.put("username", username);
    						obj.put("dept_id", DeptId);
    						arr.put(obj);

    					}

    					responseobj.put("data", arr);
    					responseobj.put("sessionId", uuidAsString);
    					out.print(responseobj);
    				}

    			} else {
    				logger.info("Invalid User");
    				System.out.println("Invlaid  user");
    				out.println("INVLAID USER");
    			}
    		}

    		catch (Exception exception) {
    			System.out.println(exception);
    			exception.printStackTrace();
    		}
    			finally
    			{
    				try {
						con.close();
						statement.close();
						out.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
    			}
    		
    	}
    }
	

