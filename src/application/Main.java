package application;
	
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;

import dao.AnnulmentDaoImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import object.Annulment;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			URL url = getClass().getResource("/view/LoginView.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		/*Field[] fields = Annulment.class.getFields();
		for(Field field:fields) {
			if(field.getType().getName().equals(String.class.getName())) {
				System.out.println("$"+field.getName()+":"+String.class.getTypeName());
			}
		}*/
		//launch(args);
		AnnulmentDaoImpl a = new AnnulmentDaoImpl();
		List<Annulment> b= a.getAll();
		for (Annulment c : b) {
			System.out.print(c.getReason());
		}
	}
}
