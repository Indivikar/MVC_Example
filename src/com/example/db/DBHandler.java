package com.example.db;

import com.example.model.DataModel;
import com.example.model.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBHandler {

	private DataModel dataModel;

	
	public DBHandler(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void connect() {
		
	}
	
	public void loadDB() {
		
		// Hier die Daten aus der DB holen und in eine ObservableList eintragen
		
		ObservableList<Person> personList = FXCollections.observableArrayList();
		personList.add(new Person("Inge", "Mustermann", "99"));
		personList.add(new Person("Basti", "Fantastie", "89"));
		
		// und in DataModel speichern
		dataModel.setPersonList(personList);
	}
	
}
