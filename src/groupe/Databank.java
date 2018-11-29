package groupe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Databank {
	
	
	Connection conn;
	DriverManager dm;
	
	
	public void connetDb()  {	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/restaurant","root","");
		Statement st = conn.createStatement();
	}
	catch (SQLException e) {	
		e.printStackTrace();
	}
	System.out.println("DB is not connceted");
	}
	
	
}
