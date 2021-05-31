package com.example.model;

import com.example.db.DBHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataModel {

	private DBHandler dbHandler;

	private ObservableList<Person> personList = FXCollections.observableArrayList();
	
	
	public DataModel() {
		
		this.dbHandler = new DBHandler(this);
		
		// Datenbank Connect 
		dbHandler.connect();
		
		// Daten aus Datenbank laden
		dbHandler.loadDB();
		
	}
	
	// Getter
	public DBHandler getDBHandler() {return dbHandler;}
	public ObservableList<Person> getPersonList() {return personList;}
	
	// Setter
	public void setPersonList(ObservableList<Person> personList) {this.personList = personList;}
	
}
