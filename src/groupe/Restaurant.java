package groupe;

import javafx.beans.property.SimpleStringProperty;

public class Restaurant {

	 private SimpleStringProperty name1= new SimpleStringProperty() ; 
	 private SimpleStringProperty stadt1 = new SimpleStringProperty() ; 
	 private SimpleStringProperty plz1 = new SimpleStringProperty(); 
	 private SimpleStringProperty strasse1= new SimpleStringProperty() ; 
	 private SimpleStringProperty hausNr1 = new SimpleStringProperty(); 
	 private SimpleStringProperty telefon1 = new SimpleStringProperty(); 
	 private SimpleStringProperty email1= new SimpleStringProperty() ; 
	 
	 @Override
	public String toString() {
		return "Restaurant [name1=" + name1 + ", stadt1=" + stadt1 + ", plz1=" + plz1 + ", strasse1=" + strasse1
				+ ", hausNr1=" + hausNr1 + ", telefon1=" + telefon1 + ", email1=" + email1 + "]";
	}
	public Restaurant() {}
	 public Restaurant(String name, String stadt, String plz,
			 String strasse, String hausNr, String telefon ,String email) {
			super();
			this.name1 = new SimpleStringProperty(name);
			this.stadt1 = new SimpleStringProperty(stadt);
			this.plz1 = new SimpleStringProperty(plz);
			this.strasse1 = new SimpleStringProperty(strasse);
			this.hausNr1 = new SimpleStringProperty(hausNr);
			this.telefon1 = new SimpleStringProperty(telefon);
			this.email1 = new SimpleStringProperty(email);
			
		}
	public String getName1() {
		return name1.get();
	}
	public void setName1(String name) {
		 name1.set(name);
	}
	public String getStadt1() {
		return stadt1.get();
	}
	public void setStadt1(String stadt) {
		stadt1.set(stadt);
	}
	public String getPlz1() {
		return plz1.get();
	}
	public void setPlz1(String plz) {
		plz1.set(plz);
	}
	public String getStrasse1() {
		return strasse1.get();
	}
	public void setStrasse1(String strasse) {
		strasse1.set(strasse);
	}
	public String getHausNr1() {
		return hausNr1.get();
	}
	public void setHausNr1(String hausNr) {
		hausNr1.set(hausNr);
	}
	public String getTelefon1() {
		return telefon1.get();
	}
	public void setTelefon1(String telefon) {
		telefon1.set(telefon);
	}
	public String getEmail1() {
		return email1.get();
	}
	public void setEmail1(String email) {
		email1.set(email);
	}
	

	
	 
}
