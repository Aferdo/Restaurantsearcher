package groupe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class lieferung {
	@FXML 
	ChoiceBox <String> choose ; 
	@FXML 
	TextField anzahl ; 
	@FXML 
	TextField preis ; 
	@FXML 
	Button bezahlen ; 
	@FXML 
	TextArea adresse_text ; 
	@FXML 
	Label lb ; 
	@FXML 
	ObservableList<String>items ; 
	@FXML
	Button zurueck ; 
	Connection conn;
	DriverManager dm;
	
	
	public void initialize() {	
		
		
		 items = FXCollections.observableArrayList(
	    			"Sushi","Chicken fingers","shawarma","Falafel-Rolle","Pizza Marinara","Slapfish","sushi pizza");
		 choose.setItems(items);
		 System.out.println("window should be  shown");
		   
		 }
	
	 @FXML
	public void init() {
		 try {
			 Stage fram = new Stage();
			Parent fxml = FXMLLoader.load(getClass().getResource("view3.fxml"));
			 Scene viewMap = new Scene(fxml);
			 fram.setScene(viewMap);
			 fram.show();
		} catch (IOException e) {

			System.out.println("loadxml fehler");
		}
		    
	 }
	 
	 @FXML 
	 public void close_3() {
		 
		 
	 } 
	 
	 @FXML 
	 public void calc() {
	 String query =""; 	 
	 try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/restaurant","root","");
				Statement st = conn.createStatement();
		}
			catch (SQLException e) {	
				e.printStackTrace();
		} 
		 String comb_wert = choose.getValue() ;  
		 int  zahl =Integer.parseInt(anzahl.getText());
	    
	    
	//	preis.setText();
	
	
		 
	 }
	 @FXML
	 public void zurueck() {
		 
		 
	 }
	
}
