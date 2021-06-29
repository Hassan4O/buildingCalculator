package com.bulding.app;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableInfo {

	/*
	 * 
	 * 
	 * 
	 * ,``,`` \ ,``,``,``,``,
	 * ``,``,`donationState`,`date`,`costumerName`,`costumerNumber`
	 */
	private SimpleIntegerProperty id, windowID, windowWidth, windowHeight, windowRollWidth, windowRollHeight,
			windowWastageWidth, windowWastageHeight, windowPeice, usefulWastageWidth, usefulWastageHeight,
			unusefulWastageWidth, unusefulWastageHeight, usefulShowroomWastageWidth, usefulShowroomWastageHeight,
			windowPeiceWastage;
	private SimpleStringProperty date, customerName, customerNumber, windowState;
	private SimpleBooleanProperty donationState;

	

	public TableInfo(int id, int windowID, int windowWidth,
			int windowHeight, int windowRollWidth,
			int windowRollHeight, int windowWastageWidth,
			int windowWastageHeight, int windowPeice,
			int usefulWastageWidth, int usefulWastageHeight,
			int unusefulWastageWidth, int unusefulWastageHeight,
			int usefulShowroomWastageWidth, int usefulShowroomWastageHeight,
			int windowPeiceWastage, String date, String customerName,
			String customerNumber, String windowState,
			boolean donationState) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.windowID = new SimpleIntegerProperty(windowID);
		this.windowWidth = new SimpleIntegerProperty(windowWidth);
		this.windowHeight = new SimpleIntegerProperty(windowHeight);
		this.windowRollWidth = new SimpleIntegerProperty(windowRollWidth);
		this.windowRollHeight = new SimpleIntegerProperty(windowRollHeight);
		this.windowWastageWidth = new SimpleIntegerProperty(windowWastageWidth);
		this.windowWastageHeight = new SimpleIntegerProperty(windowWastageHeight);
		this.windowPeice = new SimpleIntegerProperty(windowPeice);
		this.usefulWastageWidth = new SimpleIntegerProperty(usefulWastageWidth);
		this.usefulWastageHeight = new SimpleIntegerProperty(usefulWastageHeight);
		this.unusefulWastageWidth = new SimpleIntegerProperty(unusefulWastageWidth);
		this.unusefulWastageHeight = new SimpleIntegerProperty(unusefulWastageHeight);
		this.usefulShowroomWastageWidth = new SimpleIntegerProperty(usefulShowroomWastageWidth);
		this.usefulShowroomWastageHeight = new SimpleIntegerProperty(usefulShowroomWastageHeight);
		this.windowPeiceWastage =new SimpleIntegerProperty(windowPeiceWastage);
		this.date = new SimpleStringProperty(date);
		this.customerName = new SimpleStringProperty(customerName);
		this.customerNumber = new SimpleStringProperty(customerNumber);
		this.windowState = new SimpleStringProperty(windowState);
		this.donationState = new SimpleBooleanProperty(donationState);
	}

	public int getWindowWastageWidth() {
		return windowWastageWidth.get();
	}

	public void setWindowWastageWidth(SimpleIntegerProperty windowWastageWidth) {
		this.windowWastageWidth = windowWastageWidth;
	}

	public int getWindowWastageHeight() {
		return windowWastageHeight.get();
	}

	public void setWindowWastageHeight(SimpleIntegerProperty windowWastageHeight) {
		this.windowWastageHeight = windowWastageHeight;
	}

	public int getWindowPeice() {
		return windowPeice.get();
	}

	public void setWindowPeice(SimpleIntegerProperty windowPeice) {
		this.windowPeice = windowPeice;
	}

	public int getUsefulWastageWidth() {
		return usefulWastageWidth.get();
	}

	public void setUsefulWastageWidth(SimpleIntegerProperty usefulWastageWidth) {
		this.usefulWastageWidth = usefulWastageWidth;
	}

	public int getUsefulWastageHeight() {
		return usefulWastageHeight.get();
	}

	public void setUsefulWastageHeight(SimpleIntegerProperty usefulWastageHeight) {
		this.usefulWastageHeight = usefulWastageHeight;
	}

	public int getUnusefulWastageWidth() {
		return unusefulWastageWidth.get();
	}

	public void setUnusefulWastageWidth(SimpleIntegerProperty unusefulWastageWidth) {
		this.unusefulWastageWidth = unusefulWastageWidth;
	}

	public int getUnusefulWastageHeight() {
		return unusefulWastageHeight.get();
	}

	public void setUnusefulWastageHeight(SimpleIntegerProperty unusefulWastageHeight) {
		this.unusefulWastageHeight = unusefulWastageHeight;
	}

	public int getUsefulShowroomWastageWidth() {
		return usefulShowroomWastageWidth.get();
	}

	public void setUsefulShowroomWastageWidth(SimpleIntegerProperty usefulShowroomWastageWidth) {
		this.usefulShowroomWastageWidth = usefulShowroomWastageWidth;
	}

	public int getUsefulShowroomWastageHeight() {
		return usefulShowroomWastageHeight.get();
	}

	public void setUsefulShowroomWastageHeight(SimpleIntegerProperty usefulShowroomWastageHeight) {
		this.usefulShowroomWastageHeight = usefulShowroomWastageHeight;
	}

	public int getWindowPeiceWastage() {
		return windowPeiceWastage.get();
	}

	public void setWindowPeiceWastage(SimpleIntegerProperty windowPeiceWastage) {
		this.windowPeiceWastage = windowPeiceWastage;
	}

	public boolean getDonationState() {
		return donationState.get();
	}

	public void setDonationState(SimpleBooleanProperty donationState) {
		this.donationState = donationState;
	}

	public int getId() {
		return id.get();
	}

	public void setId(SimpleIntegerProperty id) {
		this.id = id;
	}

	public int getWindowID() {
		return windowID.get();
	}

	public void setWindowID(SimpleIntegerProperty windowID) {
		this.windowID = windowID;
	}

	public int getWindowWidth() {
		return windowWidth.get();
	}

	public void setWindowWidth(SimpleIntegerProperty windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight.get();
	}

	public void setWindowHeight(SimpleIntegerProperty windowHeight) {
		this.windowHeight = windowHeight;
	}

	public int getWindowRollWidth() {
		return windowRollWidth.get();
	}

	public void setWindowRollWidth(SimpleIntegerProperty windowRollWidth) {
		this.windowRollWidth = windowRollWidth;
	}

	public int getWindowRollHeight() {
		return windowRollHeight.get();
	}

	public void setWindowRollHeight(SimpleIntegerProperty windowRollHeight) {
		this.windowRollHeight = windowRollHeight;
	}

	public String getDate() {
		return date.get();
	}

	public void setDate(SimpleStringProperty date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName.get();
	}

	public void setCustomerName(SimpleStringProperty customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber.get();
	}

	public void setCustomerNumber(SimpleStringProperty customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getWindowState() {
		return windowState.get();
	}

	public void setWindowState(SimpleStringProperty windowState) {
		this.windowState = windowState;
	}

}
