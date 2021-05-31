module Demo {
	exports com.example.controller;
	exports com.example.db;
	exports com.example;
	exports com.example.model;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens com.example to javafx.fxml, javafx.graphics, javafx.base, javafx.controls;
	opens com.example.controller to javafx.fxml, javafx.graphics;
	
}