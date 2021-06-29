package com.bulding.app;

import java.io.File;

import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;

public class FromDatabase {

//	String unicode = "?useUnicode=yes&characterEncoding=utf8&useTimezone=false&serverTimezone=UTC&useSSL=false";
	static final String url1 = "jdbc:mysql://localhost:3306/buldingdatebase?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	String username = "root";
	String pass = "root";

	public ArrayList<WindowResultFromDB> getWindowInfo() {

		ArrayList<WindowResultFromDB> windowResultList = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection(url1 , username, pass);

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `windows`");
			ResultSet rs2 = pstmt.executeQuery();
			while (rs2.next()) {

				int windowId = rs2.getInt("id");
				int windowHeight = rs2.getInt("windowHeight");
				int windowWidth = rs2.getInt("windowWidth");
				int windowWastageHeight = rs2.getInt("windowWastageHeight");
				int windowWastageWidth = rs2.getInt("windowWastageWidth");
				String windowState = rs2.getString("windowState");
				int widnowPeice = rs2.getInt("windowPeice");
				int windowPeiceWastage = rs2.getInt("windowPeiceWastage");
				boolean donationState = false;

				WindowResultFromDB windowResultFromDB = new WindowResultFromDB(1, windowId, windowPeiceWastage,
						windowWidth, windowHeight, (windowWastageWidth * windowPeiceWastage),
						(windowWastageHeight * windowPeiceWastage), widnowPeice, (152 * widnowPeice), windowHeight, 0,
						0, 0, 0, 0, 0, windowState, donationState);
				windowResultList.add(windowResultFromDB);

			}

			return windowResultList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void deleteFromWindowResultTabel() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection(url1 , username, pass);

			PreparedStatement pstmt2 = con.prepareStatement("DELETE FROM `windows`");
			pstmt2.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getOprationId() {

		int oprationId = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection(url1 , username, pass);

			PreparedStatement pstmt = con.prepareStatement("SELECT `id` FROM `windowsresult` ORDER BY id DESC LIMIT 1");
			ResultSet rs2 = pstmt.executeQuery();
			if (rs2.next()) {

				oprationId = rs2.getInt("id");
				return oprationId;
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}// end method

	public ArrayList<WindowResultFromDB> getResultWindowInfoAndCost() {

		ArrayList<WindowResultFromDB> windowResultList = new ArrayList<>();

		int idOpretion = getOprationId();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection(url1 , username, pass);

			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM `windowsresult` WHERE id = '" + idOpretion + "'");
			ResultSet rs2 = pstmt.executeQuery();
			while (rs2.next()) {

				int id = rs2.getInt("id");
				int windowId = rs2.getInt("windowId");
				int windowWidth = rs2.getInt("windowWidth");
				int windowHeight = rs2.getInt("windowHeight");
				int windowWastageWidth = rs2.getInt("windowWastageWidth");
				int windowWastageHeight = rs2.getInt("windowWastageHeight");
				int windowRollWidth = rs2.getInt("windowRollWidth");
				int windowRollHeight = rs2.getInt("windowRollHeight");
				String windowState = rs2.getString("windowState");
				int windowPeice = rs2.getInt("windowPeice");
				int usefulWastageWidth = rs2.getInt("usefulWastageWidth");
				int usefulWastageHeight = rs2.getInt("usefulWastageHeight");
				int unusefulWastageWidth = rs2.getInt("unusefulWastageWidth");
				int unusefulWastageHeight = rs2.getInt("unusefulWastageHeight");
				int usefulShowroomWastageWidth = rs2.getInt("usefulShowroomWastageWidth");
				int usefulShowroomWastageHeight = rs2.getInt("usefulShowroomWastageHeight");

				WindowResultFromDB windowResultFromDB = new WindowResultFromDB(id, windowId, windowWidth, windowHeight,
						windowWastageWidth, windowWastageHeight, windowPeice, windowRollWidth, windowRollHeight,
						usefulWastageWidth, usefulWastageHeight, unusefulWastageWidth, unusefulWastageHeight,
						usefulShowroomWastageWidth, usefulShowroomWastageHeight, windowState);

				windowResultList.add(windowResultFromDB);

			}

			return windowResultList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}// end method

	public ObservableList<TableInfo> getResultWindowInfoCustm(int index, int idOpretion, String custmerNumber,
			java.sql.Date fromDate, java.sql.Date toDate) {

		ObservableList<TableInfo> windowResultList = FXCollections.observableArrayList();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection(url1 , username, pass);
			windowResultList.clear();
			if (index == 0) {
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT * FROM `windowsresult` WHERE costumerNumber = '" + custmerNumber + "'");
				ResultSet rs2 = pstmt.executeQuery();
				while (rs2.next()) {

					int id = rs2.getInt("id");
					int windowId = rs2.getInt("windowId");
					int windowWidth = rs2.getInt("windowWidth");
					int windowHeight = rs2.getInt("windowHeight");
					int windowWastageWidth = rs2.getInt("windowWastageWidth");
					int windowWastageHeight = rs2.getInt("windowWastageHeight");
					int windowRollWidth = rs2.getInt("windowRollWidth");
					int windowRollHeight = rs2.getInt("windowRollHeight");
					String windowState = rs2.getString("windowState");
					int windowPeice = rs2.getInt("windowPeice");
					int usefulWastageWidth = rs2.getInt("usefulWastageWidth");
					int usefulWastageHeight = rs2.getInt("usefulWastageHeight");
					int unusefulWastageWidth = rs2.getInt("unusefulWastageWidth");
					int unusefulWastageHeight = rs2.getInt("unusefulWastageHeight");
					int usefulShowroomWastageWidth = rs2.getInt("usefulShowroomWastageWidth");
					int usefulShowroomWastageHeight = rs2.getInt("usefulShowroomWastageHeight");
					int windowPeiceWastage = rs2.getInt("windowPeiceWastage");
					String CustomerName = rs2.getString("costumerName");
					String customerNumber = rs2.getString("costumerNumber");
					String date = String.valueOf(rs2.getDate("date"));
					boolean donationState = rs2.getBoolean("donationState");

					TableInfo tableInfo = new TableInfo(id, windowId, windowWidth, windowHeight, windowRollWidth,
							windowRollHeight, windowWastageWidth, windowWastageHeight, windowPeice, usefulWastageWidth,
							usefulWastageHeight, unusefulWastageWidth, unusefulWastageHeight,
							usefulShowroomWastageWidth, usefulShowroomWastageHeight, windowPeiceWastage,
							date, CustomerName, customerNumber, windowState, donationState);

					windowResultList.add(tableInfo);

				}

			} else if (index == 1) {

				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM `windowsresult` WHERE id = '" + idOpretion + "'");
				ResultSet rs2 = pstmt.executeQuery();
				while (rs2.next()) {

					int id = rs2.getInt("id");
					int windowId = rs2.getInt("windowId");
					int windowWidth = rs2.getInt("windowWidth");
					int windowHeight = rs2.getInt("windowHeight");
					int windowWastageWidth = rs2.getInt("windowWastageWidth");
					int windowWastageHeight = rs2.getInt("windowWastageHeight");
					int windowRollWidth = rs2.getInt("windowRollWidth");
					int windowRollHeight = rs2.getInt("windowRollHeight");
					String windowState = rs2.getString("windowState");
					int windowPeice = rs2.getInt("windowPeice");
					int usefulWastageWidth = rs2.getInt("usefulWastageWidth");
					int usefulWastageHeight = rs2.getInt("usefulWastageHeight");
					int unusefulWastageWidth = rs2.getInt("unusefulWastageWidth");
					int unusefulWastageHeight = rs2.getInt("unusefulWastageHeight");
					int usefulShowroomWastageWidth = rs2.getInt("usefulShowroomWastageWidth");
					int usefulShowroomWastageHeight = rs2.getInt("usefulShowroomWastageHeight");
					int windowPeiceWastage = rs2.getInt("windowPeiceWastage");
					String CustomerName = rs2.getString("costumerName");
					String customerNumber = rs2.getString("costumerNumber");
					String date = String.valueOf(rs2.getDate("date"));
					boolean donationState = rs2.getBoolean("donationState");

					TableInfo tableInfo = new TableInfo(id, windowId, windowWidth, windowHeight, windowRollWidth,
							windowRollHeight, windowWastageWidth, windowWastageHeight, windowPeice, usefulWastageWidth,
							usefulWastageHeight, unusefulWastageWidth, unusefulWastageHeight,
							usefulShowroomWastageWidth, usefulShowroomWastageHeight, windowPeiceWastage,
							date, CustomerName, customerNumber, windowState, donationState);
					windowResultList.add(tableInfo);

				}

			} else if (index == 2) {
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT * FROM `windowsresult` WHERE date BETWEEN '" + fromDate + "' AND '" + toDate + "'");
				ResultSet rs2 = pstmt.executeQuery();
				while (rs2.next()) {

					int id = rs2.getInt("id");
					int windowId = rs2.getInt("windowId");
					int windowWidth = rs2.getInt("windowWidth");
					int windowHeight = rs2.getInt("windowHeight");
					int windowWastageWidth = rs2.getInt("windowWastageWidth");
					int windowWastageHeight = rs2.getInt("windowWastageHeight");
					int windowRollWidth = rs2.getInt("windowRollWidth");
					int windowRollHeight = rs2.getInt("windowRollHeight");
					String windowState = rs2.getString("windowState");
					int windowPeice = rs2.getInt("windowPeice");
					int usefulWastageWidth = rs2.getInt("usefulWastageWidth");
					int usefulWastageHeight = rs2.getInt("usefulWastageHeight");
					int unusefulWastageWidth = rs2.getInt("unusefulWastageWidth");
					int unusefulWastageHeight = rs2.getInt("unusefulWastageHeight");
					int usefulShowroomWastageWidth = rs2.getInt("usefulShowroomWastageWidth");
					int usefulShowroomWastageHeight = rs2.getInt("usefulShowroomWastageHeight");
					int windowPeiceWastage = rs2.getInt("windowPeiceWastage");
					String CustomerName = rs2.getString("costumerName");
					String customerNumber = rs2.getString("costumerNumber");
					String date = String.valueOf(rs2.getDate("date"));
					boolean donationState = rs2.getBoolean("donationState");

					TableInfo tableInfo = new TableInfo(id, windowId, windowWidth, windowHeight, windowRollWidth,
							windowRollHeight, windowWastageWidth, windowWastageHeight, windowPeice, usefulWastageWidth,
							usefulWastageHeight, unusefulWastageWidth, unusefulWastageHeight,
							usefulShowroomWastageWidth, usefulShowroomWastageHeight, windowPeiceWastage,
							date, CustomerName, customerNumber, windowState, donationState);
					windowResultList.add(tableInfo);

				}

			} else if (index == 3) {
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `windowsresult`");
				ResultSet rs2 = pstmt.executeQuery();
				while (rs2.next()) {

					int id = rs2.getInt("id");
					int windowId = rs2.getInt("windowId");
					int windowWidth = rs2.getInt("windowWidth");
					int windowHeight = rs2.getInt("windowHeight");
					int windowWastageWidth = rs2.getInt("windowWastageWidth");
					int windowWastageHeight = rs2.getInt("windowWastageHeight");
					int windowRollWidth = rs2.getInt("windowRollWidth");
					int windowRollHeight = rs2.getInt("windowRollHeight");
					String windowState = rs2.getString("windowState");
					int windowPeice = rs2.getInt("windowPeice");
					int usefulWastageWidth = rs2.getInt("usefulWastageWidth");
					int usefulWastageHeight = rs2.getInt("usefulWastageHeight");
					int unusefulWastageWidth = rs2.getInt("unusefulWastageWidth");
					int unusefulWastageHeight = rs2.getInt("unusefulWastageHeight");
					int usefulShowroomWastageWidth = rs2.getInt("usefulShowroomWastageWidth");
					int usefulShowroomWastageHeight = rs2.getInt("usefulShowroomWastageHeight");
					int windowPeiceWastage = rs2.getInt("windowPeiceWastage");
					String CustomerName = rs2.getString("costumerName");
					String customerNumber = rs2.getString("costumerNumber");
					String date = String.valueOf(rs2.getDate("date"));
					boolean donationState = rs2.getBoolean("donationState");

					TableInfo tableInfo = new TableInfo(id, windowId, windowWidth, windowHeight, windowRollWidth,
							windowRollHeight, windowWastageWidth, windowWastageHeight, windowPeice, usefulWastageWidth,
							usefulWastageHeight, unusefulWastageWidth, unusefulWastageHeight,
							usefulShowroomWastageWidth, usefulShowroomWastageHeight, windowPeiceWastage,
							date, CustomerName, customerNumber, windowState, donationState);
					windowResultList.add(tableInfo);


				}
			}

			return windowResultList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}// end method
	
	
	
	public static void showWarning(String title, String message) {

		try {
			
		
	    Alert alert = new Alert(Alert.AlertType.WARNING);
	    alert.initStyle(StageStyle.UTILITY);
	    alert.setTitle("Warning");
	    alert.setHeaderText(title);

	    
	 // An image file on the hard drive.
	    File file = new File("C:\\Program Files\\buldingApplication\\Error.PNG");
	     
	    // --> file:/C:/MyImages/myphoto.jpg
	    String localUrl;
	    localUrl = file.toURI().toURL().toString();
	    ImageView icon = new ImageView(localUrl);
	 
	    icon.setFitHeight(48);
        icon.setFitWidth(48);

	   alert.setGraphic(icon);
	    alert.setContentText(message);

	    alert.showAndWait();
	    
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}//end method

}// end class
