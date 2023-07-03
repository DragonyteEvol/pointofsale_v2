package application;
	
import java.lang.reflect.InvocationTargetException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//Color :  #E55807
		try {
			//Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("/view/IndexView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		launch(args);
	}
}
