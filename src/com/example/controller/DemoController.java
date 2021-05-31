package com.example.controller;


import com.example.Demo;
import com.example.model.DataModel;
import com.example.model.Person;

import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DemoController {

	private Demo demo;
	private DataModel dataModel;
	
	private ObservableList<Person> personList;
	
	@FXML private AnchorPane mainAnchorPane;
	@FXML private TextField textFieldVorname;
	@FXML private TextField textFieldNachname;
	@FXML private TextField textFieldAlter;
	@FXML private Button button;
	@FXML private Label label;
	
	public void init(Demo demo, DataModel dataModel) {
		this.demo = demo;
		this.dataModel = dataModel;
		this.personList = dataModel.getPersonList(); // hier die Person-Liste aus DataModel holen
		
		// Button ist erst Aktiv, wenn alle Textfelder ausgefüllt sind
		button.disableProperty().bind(
			    Bindings.isEmpty(textFieldVorname.textProperty())
			    .or(Bindings.isEmpty(textFieldNachname.textProperty()))
			    .or(Bindings.isEmpty(textFieldAlter.textProperty()))			    
			);
		
		// Label anzeigen, wenn Button inaktiv
		label.visibleProperty().bind(button.disableProperty());
		
		// neue Person eintragen
		button.setOnAction(e -> {			
			personList.add(new Person(textFieldVorname.getText(), textFieldNachname.getText(), textFieldAlter.getText()));	
			
			// Gibt alle items in der Konsole aus
			System.out.println("\nAlle Items");			
			for (Person person : personList) {
				System.out.println(person);
			}
		});
		
		// Gibt in der Konsole aus, welche Person hinzugefügt wurde
		personList.addListener((ListChangeListener.Change<? extends Person> c) -> {			
            while (c.next()) {
                if (c.wasAdded()) {
                    for (Person newItem : c.getAddedSubList()) {
                    	System.out.println("\nNew Item");
                    	System.out.println(newItem);
                    }
                }               
            }
        });
		
	}
	
	
}
