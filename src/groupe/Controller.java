package groupe;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;



public class Controller    {
	
	
	
	
	
  @FXML 
     ImageView  icon ; 
	@FXML
	Label labeltext ; 
	@FXML
	TextArea contain ; 
	@FXML
	Button search ; 
	@FXML
	WebView browser ; 
	@FXML
	TextField feld ; 
	@FXML 
    Label  menu_label ; 
	@FXML 
	ObservableList<String>items ; 
    @FXML
    private ComboBox<String> combobx;
    
    @FXML
    TableView <Restaurant> table;
    @FXML 
    TableColumn <Restaurant,SimpleStringProperty> name ; 
    @FXML 
    TableColumn <Restaurant,SimpleStringProperty> stadt ;
    @FXML 
    TableColumn <Restaurant,SimpleStringProperty> plz ;
    @FXML 
    TableColumn <Restaurant,SimpleStringProperty> strasse ;
    @FXML 
    TableColumn <Restaurant,SimpleStringProperty> hausnr ;
    @FXML 
    TableColumn <Restaurant,SimpleStringProperty> telefon ;
    @FXML
    TableColumn <Restaurant,SimpleStringProperty> email  ;
    
    @FXML 
    Pane pane_map ; 
    @FXML 
    Button liefern; 
    @FXML 
    Button showMAp ;    
   
    
    ObservableList <Restaurant> terms;
    
    Restaurant klasse = new Restaurant();  
    
      
	 
//  Restaurant alles = new Restaurant("SmallnewYork","Duisburg","57434","34","020323211","info@service.com","57434"); 
        
	 public void initialize() {	
		
		 terms = FXCollections.observableArrayList();
		 
		 items = FXCollections.observableArrayList(
	    			"ChinaTown","SmallnewYork","Holy Moly","Falafel Zone","Pizza italy","Banana Area","Sushi Mushi");
			combobx.setItems(items);
			name.setCellValueFactory(new PropertyValueFactory<Restaurant,SimpleStringProperty>("name1"));
		    stadt.setCellValueFactory(new PropertyValueFactory<Restaurant,SimpleStringProperty>("stadt1"));
		    plz.setCellValueFactory(new PropertyValueFactory<Restaurant,SimpleStringProperty>("plz1"));
	        strasse.setCellValueFactory(new PropertyValueFactory<Restaurant,SimpleStringProperty>("strasse1"));
		    hausnr.setCellValueFactory(new PropertyValueFactory<Restaurant,SimpleStringProperty>("hausNr1"));
		    telefon.setCellValueFactory(new PropertyValueFactory<Restaurant,SimpleStringProperty>("telefon1"));
		    email.setCellValueFactory(new PropertyValueFactory<Restaurant,SimpleStringProperty>("email1"));
		   
		 }
	 
	 
	 @FXML
		public void moveToTextFeld() {
	 
	    String x =combobx.getValue().toLowerCase();  
	    switch (x)  
	    {	
	    case "chinatown"   :  feld.setText(combobx.getValue()); break;
	    case "smallnewyork":  feld.setText(combobx.getValue()); break;
	    case "holy moly"   :  feld.setText(combobx.getValue()); break;
	    case "falafel zone":  feld.setText(combobx.getValue()); break;
	    case "pizza italy" :  feld.setText(combobx.getValue()); break;
	    case "banana area" :  feld.setText(combobx.getValue()); break;
	    case "sushi mushi" :  feld.setText(combobx.getValue()); break;	
  	   }
		
	    	
  } 
	 
   	 
     	 
  @FXML
  public void search () {
	 
	  Connection conn;
	  Statement st;
	  
	  String mySql ="SELECT `name`,`ort`,`plz`,`strasse`,`hausnummer`,`telefonnummer`,`email` FROM `restaurant` WHERE name ='"+feld.getText().toLowerCase()+"'" ;
	 try {    
		 
		 conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/restaurant","root","");
	     st = conn.createStatement();     
	     ResultSet rs= st.executeQuery(mySql);
		 System.out.println(mySql);
		 
		    while (rs.next()){
		    	
				String name_ = rs.getString("name");
				String ort_ = rs.getString("ort");
				String plz_ = rs.getString("plz");
				String strasse_ = rs.getString("strasse");
				String haunummer_ = rs.getString("hausnummer");
				String telefon_ = rs.getString("telefonnummer");
				String email_ = rs.getString("email");
//				terms.add(name_);
//				terms.add(ort_);
//				terms.add(plz_);
//				terms.add(strasse_);
//				terms.add(haunummer_);
//				terms.add(telefon_);
//			    terms.add(email_);
				
				Restaurant irgendwas = new Restaurant();
				
				irgendwas.setName1(name_);
				irgendwas.setStadt1(ort_);
				irgendwas.setPlz1(plz_);
				irgendwas.setStrasse1(strasse_);
				irgendwas.setHausNr1(haunummer_);
				irgendwas.setTelefon1(telefon_);
				irgendwas.setEmail1(email_);
				System.out.println(name_);
				System.out.println(ort_);
				System.out.println(plz_);
				System.out.println(strasse_);
				System.out.println(haunummer_);
				System.out.println(telefon_);
				System.out.println(email_);
    			
				System.out.println(irgendwas);
				
				terms.add(irgendwas);
				
    		 //   getInitialTableData();

    		table.setItems(terms);
		      //table.setItems().add(klasse);
    		
    		System.out.println(table.getItems().get(0));
    		
			 }
			     
        }           
		catch (SQLException sq) {
				sq.getStackTrace();
				
	       }    		 
     	 
  }
//  public void getInitialTableData() {
//	  
//   List <Restaurant>list = new <Restaurant>ArrayList();
//   list.add(klasse);
//	 System.out.println(klasse.getName1()+" "+klasse.getStrasse1()+" "+klasse.getTelefon1());
//	  
//  terms = FXCollections.observableList(list);
//
//	
//  }
   /**
    *  oeffnungszeit fenster zeigen
    *  
    */
      public void showTime() {
			
			new Zeit().fenster();
			
     }
      
     public void showTime_2() {
    	 
    	 new lieferung().init();

// 		Main sd = new Main();
// 		 sd.primaryStage.close();
     }
      
      
		 
}
