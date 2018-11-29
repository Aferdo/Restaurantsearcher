package groupe;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Zeit {

	 @FXML 
	 Label offenzeit ;
	 @FXML 
	 TextArea text ; 
	 @FXML 
	 ComboBox<String> combobx;  
	 Connection conn;
   	DriverManager dm;
	 ObservableList<String>items ; 
	 Statement st;
	
	 @FXML
	public void fenster() {
		 
		 System.out.println("window should be  shown");
		 Stage fram = new Stage();
		
		try {
			Parent fxml2 = FXMLLoader.load(getClass().getResource("view2.fxml"));
			 Scene viewMap = new Scene(fxml2);
			 fram.setScene(viewMap);
			 fram.show();
		} catch (IOException e) {

			System.out.println("loadxml fehler");
		}
		      
	 }
	 
	 @FXML
	public void initialize() {	
		 
	    items = FXCollections.observableArrayList(
    			"ChinaTown","SmallnewYork","Holy Moly","Falafel Zone","Pizza italy","Banana Area","Sushi Mushi");
		combobx.setItems(items);
         
		}
	
	 @FXML
	public void pickTheDate() {	 
		 String comb_wert = combobx.getValue() ; 
		
	try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/restaurant","root","");
			Statement st = conn.createStatement();
			
		String sql = "SELECT `Montag`,`Dienstag`,`Mittwoch`,`Donnerstag`,`Freitag`,`Samstag`,`Sonntag` FROM oeffnungszeit inner JOIN restaurant on oeffnungszeit.id=restaurant.id where name = '"+comb_wert+"'" ; 
		
			
		System.out.println(comb_wert);
			
     	ResultSet rs= st.executeQuery(sql);
			
		while(rs.next()) {
		String montag = rs.getString("Montag")	;
		String dienstag = rs.getString("Dienstag")	;
		String mitwoch= rs.getString("Mittwoch")	;
		String  donnerstag = rs.getString("Donnerstag")	;
		String freitag = rs.getString("Freitag")	;
		String samstag = rs.getString("Samstag")	;
		String sonntag = rs.getString("Sonntag")	;
				
	   text.setText(" Mo, "+montag+"\n"+" Di, "+dienstag+"\r\n"+" Mi, "+mitwoch+"\r\n"+" Do, "+donnerstag+"\r\n"+" Fr, "+freitag+
	   "\r\n"+" Sa, "+samstag+"\r\n"+" So, "+sonntag);
		    
			
		}
			
		} 
		catch (SQLException e) {
			
		System.out.println("error found");
		}
		
		

		
	}
	   
		    

 }
	

