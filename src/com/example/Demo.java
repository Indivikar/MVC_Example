package com.example;

import com.example.controller.DemoController;
import com.example.model.DataModel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Demo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// DataModel und alles was drin ist laden
		DataModel dataModel = new DataModel();
		
		// Die FXML laden
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/fxml/demo.fxml"));
		// root ist immer der erste Container aus der FXML, also in unserem fall ist es eine AnchorPane
		AnchorPane root = loader.load(); 
		
		// Den Controller laden, der in der FXML-Datei hinterlegt wurde
		DemoController demoController = loader.getController();
		// Alles an den Controller übergeben
		demoController.init(this, dataModel);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Demo");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
