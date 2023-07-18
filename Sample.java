import java.sql.*;
import java.util.Scanner;
import java.lang.Exception;
class Sample
{
	public static void main(String[] args) {
		try 
		{
		Scanner x = new Scanner(System.in);
		System.out.print("Enter Employee No.");
		int eno = x.nextInt();
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/compilersdb","root","super");
		String sql = "select enm,job,sal from employee where eno = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,eno);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			String name = rs.getString("enm");
			String j = rs.getString("job");
			double s = rs.getDouble("sal");
			System.out.println("No"+eno);
			System.out.println("Name "+name);
			System.out.println("Job ="+j);
			System.out.println("Salary = "+s);
		}
		else 
	    System.out.println("Record not found..");
}
catch(Exception ex)
{
	ex.printStackTrace();
	}
}
}