package com.bulding.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainCenterController implements Initializable{
  //						<fx:include fx:id="searchPane" source="SearchPane.fxml"/>

	
	@FXML
	Tab tapMainPane;
	
	@FXML 
	Tab tapSearchPane;
	
	SearchController searchController;
	mainController mainController;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 FXMLLoader loader = new FXMLLoader();
	     try {
	    	 AnchorPane mainPane = loader.load(getClass().getResource("mainPane.fxml"));
	    	 tapMainPane.setContent(mainPane);
	    	 mainController = (mainController)loader.getController();
	    	 
	    	 BorderPane searchReport = loader.load(getClass().getResource("SearchPane.fxml"));
	    	 tapSearchPane.setContent(searchReport);
	    	 searchController = (SearchController)loader.getController();
	     }
	     catch(IOException e) {
	    	 
	    	 e.getMessage();
	    	 
	     }
		
	}

	
}
