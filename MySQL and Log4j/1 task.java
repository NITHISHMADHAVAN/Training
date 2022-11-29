import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class Etable {
	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Nithish@123");
			Statement stmt=con.createStatement();
			String sql="insert into employee( EmpID,EmpName,EmpAge, EmpDept,salary ) values(?,?,?,?,?)";
		    PreparedStatement pst = con.prepareStatement(sql);
		    pst.setInt(1,105);
		    pst.setString(2, "nith");
		    pst.setInt(3, 22);
		    pst.setString(4, "services");
		    pst.setDouble(5,14634);
		    pst.executeUpdate();
		    System.out.println(pst);
		    System.out.println("Succesfully inserted");
		//	ResultSet rs=stmt.executeQuery("select * from employee");
		//	while(rs.next())
		//	{
			//	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
		//	}
		
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}
		
		}
}