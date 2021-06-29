package com.bulding.app;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ResourceBundle;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class SearchController implements Initializable {

	
	//String unicode = "?useUnicode=yes&characterEncoding=utf8&useTimezone=false&serverTimezone=UTC&useSSL=false";
	static final String url1 = "jdbc:mysql://localhost:3306/buldingdatebase?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	String username = "root";
	String pass = "root";
	
	@FXML
	ComboBox compoBox;

	@FXML
	TextField numberField;

	@FXML
	Label fromLabel;

	@FXML
	Label toLabel;

	@FXML
	DatePicker dateFrom;

	@FXML
	DatePicker dateTo;

	@FXML
	Button buttonOk;
	
	@FXML 
	Button reportButton;
	@FXML
	private TableView<TableInfo> infoTable;
	@FXML
	private TableColumn columnId;
	@FXML
	private TableColumn columnWindowId;
	@FXML
	private TableColumn columnCustomerName;
	@FXML
	private TableColumn columnCustomerNumber;
	@FXML
	private TableColumn columnDate;
	@FXML
	private TableColumn columnWindowWidth;
	@FXML
	private TableColumn columnWindowHeight;
	@FXML
	private TableColumn columnWindowRollWidth;
	@FXML
	private TableColumn columnWindowRollHeight; 
	@FXML
	private TableColumn columnWindowState ; 
	

	FromDatabase fromDatabase = new FromDatabase();
	
	ToDatabase toDatabase = new ToDatabase();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		numberField.setVisible(false);
		numberField.setText(String.valueOf(0));
		fromLabel.setVisible(false);
		toLabel.setVisible(false);
		dateFrom.setVisible(false);
		dateFrom.setValue(LocalDate.of(2020, 6, 21));
		dateTo.setVisible(false);
		dateTo.setValue(LocalDate.of(2020, 6, 21));
		buttonOk.setVisible(false);
		reportButton.setVisible(false);
		
		compoBox.getItems().addAll("Phone Number", "Report Number", "Date", "View All");

	}//end initialize Method
	
	
	@FXML
	public void visibleFields() {
		
		int index =compoBox.getSelectionModel().getSelectedIndex();
		
			if(index==0) {
				numberField.setVisible(true);
				fromLabel.setVisible(false);
				toLabel.setVisible(false);
				dateFrom.setVisible(false);
				dateTo.setVisible(false);
				buttonOk.setVisible(true);
				
			}else if(index == 1) {
				numberField.setVisible(true);
				fromLabel.setVisible(false);
				toLabel.setVisible(false);
				dateFrom.setVisible(false);
				dateTo.setVisible(false);
				buttonOk.setVisible(true);
			}else if(index==2) {
				numberField.setVisible(false);
				fromLabel.setVisible(true);
				toLabel.setVisible(true);
				dateFrom.setVisible(true);
				dateTo.setVisible(true);
				buttonOk.setVisible(true);
			}else if(index==3){
				numberField.setVisible(false);
				fromLabel.setVisible(false);
				toLabel.setVisible(false);
				dateFrom.setVisible(false);
				dateTo.setVisible(false);
				buttonOk.setVisible(true);
			}
		
		
		
	}//end visble Method
	
	
	public void addRow() {
	
		infoTable.getItems().clear();
		int index =compoBox.getSelectionModel().getSelectedIndex();
		int idOperation = Integer.valueOf(numberField.getText());
		String customerNumber =numberField.getText();
		java.sql.Date fromDate = java.sql.Date.valueOf(dateFrom.getValue());
		java.sql.Date toDate = java.sql.Date.valueOf(dateTo.getValue());
		
		ObservableList<TableInfo> infoeList = fromDatabase.getResultWindowInfoCustm(index, idOperation, customerNumber, fromDate, toDate);

		
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnWindowId.setCellValueFactory(new PropertyValueFactory<>("windowID"));
		columnCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
		columnCustomerNumber.setCellValueFactory(new PropertyValueFactory<>("customerNumber"));
		columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		columnWindowWidth.setCellValueFactory(new PropertyValueFactory<>("windowWidth"));	
		columnWindowHeight.setCellValueFactory(new PropertyValueFactory<>("windowHeight"));
		columnWindowRollWidth.setCellValueFactory(new PropertyValueFactory<>("windowRollWidth"));
		columnWindowRollHeight.setCellValueFactory(new PropertyValueFactory<>("windowRollHeight"));
		columnWindowState.setCellValueFactory(new PropertyValueFactory<>("windowState"));

		
		
		
		for(TableInfo info : infoeList) {
			infoTable.getItems().add(info);
		}
		
		reportButton.setVisible(true);
		toDatabase.insertSearchReportTable(infoeList);
	

		
		
	}//end Method
	
	public void showReport() {
		


		try {

			Connection con = DriverManager.getConnection(url1 , username, pass);
			Class.forName("com.mysql.cj.jdbc.Driver");

			String sql = "SELECT * FROM searchreport";
			JasperDesign jsp = JRXmlLoader.load("C:\\Program Files\\buldingApplication\\SearchReport.jrxml");

			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(sql);
			jsp.setQuery(updateQuery);

			JasperReport jspre = JasperCompileManager.compileReport(jsp);

			JasperPrint jspPr = JasperFillManager.fillReport(jspre, null, con);

			JasperViewer.viewReport(jspPr, false);

		}

		catch (Exception e4) {
			e4.getMessage();
		}

		catch (java.lang.NoSuchMethodError e4) {
			e4.getMessage();
		}
		
		
	}//end method
	
	
	

}//end class
