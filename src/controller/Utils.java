package controller;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import log.Log;

public class Utils {
	
	private static Utils utils;
	
	private Utils() {
		super();
	}
	//SINGLETON
	public static Utils getUtils() {
		if(utils==null) {
			utils = new Utils();
		}
		return utils;
	}
	
	/*CREA UNA NUEVA VISTA O VENTANA SOBRE LA VENTANA ACTUAL
	 * parametros: 
	 * string con la ruta de la vista a mostrar
	 * boolean modal boleano que marca la ventana creada de tipo o modal(
	 * itectua con las demas ventanas o bloque la interaccion con las demas ventanas)
	 */
	public void changeView(String view,boolean modal) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(view));
    		//Parent root = FXMLLoader.load(getClass().getResource(view));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			if(modal) {
				stage.initModality(Modality.APPLICATION_MODAL);
			}
			stage.setScene(scene);
			stage.setResizable(false);
			stage.showAndWait();
    	}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
    }
	
	public void changeView(String view,Object controller,boolean modal) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(view));
    		fxmlLoader.setController(controller);
    		//Parent root = FXMLLoader.load(getClass().getResource(view));
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			if(modal) {
				stage.initModality(Modality.APPLICATION_MODAL);
			}
			stage.setScene(scene);
			stage.setResizable(false);
			stage.showAndWait();
    	}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
    }
	
	/* MODIFICA UNA VENTANA O VISTA ACTUALMENTE REPRESENTADA
	 * parametros:
	 * String view ruta de la vista nueva a cambiar
	 * control object objecto de la vista actual que se quiere cambiar
	 * boolean modal boleano que marca la ventana creada de tipo o modal(
	 * itectua con las demas ventanas o bloque la interaccion con las demas ventanas)
	 */
	public void alterView(String view,Control object,boolean modal) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource(view));
    		Stage stage = (Stage) object.getScene().getWindow();
    		Scene scene = new Scene(root);
    		if(modal) {
				stage.initModality(Modality.APPLICATION_MODAL);
			}
    		stage.setScene(scene);
    		stage.show();
    	}catch(Exception e) {
			Log.getLogger(getClass()).error(e.getMessage());
		}
    }
	
	/* CIERRA UNA VENTANA O VISTA
	 * parametros:
	 * Control object objecto que se encuentre en la vista que se quiere cerrar
	 * para extrar el stage del objecto
	 */
	public void closeView(Control object) {
		Stage stage = (Stage) object.getScene().getWindow();
    	stage.close();	
	}
	
	public void addObject(String view,Object controller,Pane panel){
    	if(controller!=null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(view));
    		fxmlLoader.setController(controller);
        	try {
    			panel.getChildren().add(fxmlLoader.load());
    		} catch (IOException e) {
    			Log.getLogger(getClass()).error(e.getMessage());
    			System.out.print(e.getMessage());
    		}
    	}
    }
}
