package groupe;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		try {
					
			Parent fxml = FXMLLoader.load(getClass().getResource("view.fxml"));
			Scene scene = new Scene(fxml);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		   
			} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void cloose() {
		try {
		primaryStage.close();
		}
		catch(Exception e ) {
			
			System.out.println("could not be closed");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
