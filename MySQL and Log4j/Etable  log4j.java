import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class Etable { 
	private static Logger initilaizeLogger(){
	  
		
		try {
			String filePath = "C:\\Users\\Nithish.m\\Documents\\Log\\mylog.log";
	        PatternLayout layout = new PatternLayout("%-5p %d %m%n");
	        
	        RollingFileAppender appender;
			appender = new RollingFileAppender(layout, filePath);
			appender.setName("myFirstLog");
	        appender.setMaxFileSize("1MB");
	        appender.activateOptions();
	        
	       // appender.stdout=org.apache.log4j.ConsoleAppender  
	      //  appender.stdout.Target=System.out  
	       // appender.stdout.layout=org.apache.log4j.PatternLayout  
	      
	        Logger log=Logger.getLogger(Etable.class);
	        log.addAppender(appender);
	        log.error("it is error");
	        System.out.println("this is console");
	        return log;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
        
	public static void main(String[] args)
	{
		
	Logger log=initilaizeLogger();
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Nithish@123");
			Statement stmt=con.createStatement();
			
			String sql="insert into employee( EmpID,EmpName,EmpAge, EmpDept ) values(?,?,?,?)";
		    PreparedStatement pst = con.prepareStatement(sql);
		    pst.setInt(1,40);
		    pst.setString(2, "mmm");
		    pst.setInt(3, 22);
		    pst.setString(4, "HR");
		    pst.executeUpdate();
		    log.info(pst);
		    log.info("Succesfully inserted");
		    log.warn(" warning "+initilaizeLogger());
		    log.error("error"+initilaizeLogger());
		//	ResultSet rs=stmt.executeQuery("select * from employee");
		//	while(rs.next())
		//	{
			//	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
		//	}
		   
		
		}
		catch(Exception exception)
		{
			log.error(exception);
		}
		
		}

}
