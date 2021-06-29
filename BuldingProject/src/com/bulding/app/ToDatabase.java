package com.bulding.app;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javafx.collections.ObservableList;

public class ToDatabase {

	// String unicode =
	// "?useUnicode=yes&characterEncoding=utf8&useTimezone=false&serverTimezone=UTC&useSSL=false";
	// String url1 = "jdbc:mysql://localhost:3306//buldingdatebase";

	static final String url1 = "jdbc:mysql://localhost:3306/buldingdatebase?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";

	String username = "root";
	String pass = "root";

	public void insertWindowsTable(int id, int height, int width, int widthWastage, int heightWastage,
			String windowState, int windowPiece) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url1, username, pass);

			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO `windows`(`id`,`windowHeight`, `windowWidth`,`windowWastageHeight`,`windowWastageWidth`,`windowState`,`windowPeice`,`windowPeiceWastage`)VALUES(?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, id);
			pstmt.setInt(2, height);
			pstmt.setInt(3, width);
			pstmt.setInt(4, heightWastage);
			pstmt.setInt(5, widthWastage);
			pstmt.setString(6, windowState);
			pstmt.setInt(7, windowPiece);
			pstmt.setInt(8, windowPiece);

			pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end method

	public void insertWindowResultTable(int id, int windowId, int windowWidth, int windowHeight, int windowWastageWidth,
			int windowWastageHeight, String windowState, int windowRollWidth, int windowRollHeight, int windowPeice,
			int usefulWastageWidth, int usefulWastageHeight, int unusefulWastageWidth, int unusefulWastageHeight,
			int usefulShowroomWastageWidth, int usefulShowroomWastageHeight, boolean donationState,
			int wastagePieceUpdate, String costumerName, String costumerNumber) {

		try {
			long timeLong = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(timeLong);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection con = DriverManager.getConnection(url1, username, pass);

				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO `windowsresult`(`id`,`windowId`, `windowWidth`,`windowHeight`,`windowWastageWidth`,`windowWastageHeight`,`windowState`,`windowRollWidth`,`windowRollHeight`,`windowPeice`,`usefulWastageWidth`,`usefulWastageHeight`,`unusefulWastageWidth`,`unusefulWastageHeight`,`usefulShowroomWastageWidth`,`usefulShowroomWastageHeight`,`windowPeiceWastage`,`donationState`,`date`,`costumerName`,`costumerNumber`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				pstmt.setInt(1, id);
				pstmt.setInt(2, windowId);
				pstmt.setInt(3, windowWidth);
				pstmt.setInt(4, windowHeight);
				pstmt.setInt(5, windowWastageWidth);
				pstmt.setInt(6, windowWastageHeight);
				pstmt.setString(7, windowState);
				pstmt.setInt(8, windowRollWidth);
				pstmt.setInt(9, windowRollHeight);
				pstmt.setInt(10, windowPeice);
				pstmt.setInt(11, usefulWastageWidth);
				pstmt.setInt(12, usefulWastageHeight);
				pstmt.setInt(13, unusefulWastageWidth);
				pstmt.setInt(14, unusefulWastageHeight);
				pstmt.setInt(15, usefulShowroomWastageWidth);
				pstmt.setInt(16, usefulShowroomWastageHeight);
				pstmt.setInt(17, wastagePieceUpdate);
				pstmt.setBoolean(18, donationState);
				pstmt.setDate(19, date);
				pstmt.setString(20, costumerName);
				pstmt.setString(21, costumerNumber);

				pstmt.executeUpdate();

			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				FromDatabase.showWarning("The mobile number is only 10 digits", "ERROR MESSAGE");

			}
		} catch (Exception e3) {
			FromDatabase.showWarning(e3.getMessage(), "ERROR MESSAGE");

		}

	}

	public void insertSearchReportTable(ObservableList<TableInfo> windowResultList) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url1, username, pass);

			PreparedStatement pstmt2 = con.prepareStatement("DELETE FROM `searchreport`");
			pstmt2.executeUpdate();
			for (TableInfo infoItem : windowResultList) {
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO `searchreport`(`id`,`windowId`, `windowWidth`,`windowHeight`,`windowWastageWidth`,`windowWastageHeight`,`windowState`,`windowRollWidth`,`windowRollHeight`,`windowPeice`,`usefulWastageWidth`,`usefulWastageHeight`,`unusefulWastageWidth`,`unusefulWastageHeight`,`usefulShowroomWastageWidth`,`usefulShowroomWastageHeight`,`windowPeiceWastage`,`donationState`,`date`,`costumerName`,`costumerNumber`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				pstmt.setInt(1, infoItem.getId());
				pstmt.setInt(2, infoItem.getWindowID());
				pstmt.setInt(3, infoItem.getWindowWidth());
				pstmt.setInt(4, infoItem.getWindowHeight());
				pstmt.setInt(5, infoItem.getWindowWastageWidth());
				pstmt.setInt(6, infoItem.getWindowWastageHeight());
				pstmt.setString(7, infoItem.getWindowState());
				pstmt.setInt(8, infoItem.getWindowRollWidth());
				pstmt.setInt(9, infoItem.getWindowRollHeight());
				pstmt.setInt(10, infoItem.getWindowPeice());
				pstmt.setInt(11, infoItem.getUsefulWastageWidth());
				pstmt.setInt(12, infoItem.getUsefulWastageHeight());
				pstmt.setInt(13, infoItem.getUnusefulWastageWidth());
				pstmt.setInt(14, infoItem.getUnusefulWastageHeight());
				pstmt.setInt(15, infoItem.getUsefulShowroomWastageWidth());
				pstmt.setInt(16, infoItem.getUsefulShowroomWastageHeight());
				pstmt.setInt(17, infoItem.getWindowPeiceWastage());
				pstmt.setBoolean(18, infoItem.getDonationState());
				pstmt.setDate(19, java.sql.Date.valueOf(infoItem.getDate()));
				pstmt.setString(20, infoItem.getCustomerName());
				pstmt.setString(21, infoItem.getCustomerNumber());

				pstmt.executeUpdate();
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}// end class
