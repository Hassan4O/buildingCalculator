package com.bulding.app;

public class WindowResultFromDB {


	
	public int oprationId ,id ,windowPeiceWastage, windowWidth , windowHeight , windowWastageWidth, windowWastageHeight ,windowPeice,windowRollWidth ,
	windowRollHeight,usefulWastageWidth,usefulWastageHeight,unusefulWastageWidth,unusefulWastageHeight,usefulShowroomWastageWidth,usefulShowroomWastageHeight;
	public String windowState;
	public boolean donationState;
	
	

	
	



	public WindowResultFromDB(int id, int windowWidth, int windowHeight, int windowWastageWidth,
			int windowWastageHeight, int windowPeice, int windowRollWidth, int windowRollHeight, int usefulWastageWidth,
			int usefulWastageHeight, int unusefulWastageWidth, int unusefulWastageHeight,
			int usefulShowroomWastageWidth, int usefulShowroomWastageHeight, String windowState) {
		super();
		this.id = id;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.windowWastageWidth = windowWastageWidth;
		this.windowWastageHeight = windowWastageHeight;
		this.windowPeice = windowPeice;
		this.windowRollWidth = windowRollWidth;
		this.windowRollHeight = windowRollHeight;
		this.usefulWastageWidth = usefulWastageWidth;
		this.usefulWastageHeight = usefulWastageHeight;
		this.unusefulWastageWidth = unusefulWastageWidth;
		this.unusefulWastageHeight = unusefulWastageHeight;
		this.usefulShowroomWastageWidth = usefulShowroomWastageWidth;
		this.usefulShowroomWastageHeight = usefulShowroomWastageHeight;
		this.windowState = windowState;
	}



	public WindowResultFromDB(int oprationId, int id, int windowWidth, int windowHeight, int windowWastageWidth,
			int windowWastageHeight, int windowPeice, int windowRollWidth, int windowRollHeight, int usefulWastageWidth,
			int usefulWastageHeight, int unusefulWastageWidth, int unusefulWastageHeight,
			int usefulShowroomWastageWidth, int usefulShowroomWastageHeight, String windowState) {
		super();
		this.oprationId = oprationId;
		this.id = id;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.windowWastageWidth = windowWastageWidth;
		this.windowWastageHeight = windowWastageHeight;
		this.windowPeice = windowPeice;
		this.windowRollWidth = windowRollWidth;
		this.windowRollHeight = windowRollHeight;
		this.usefulWastageWidth = usefulWastageWidth;
		this.usefulWastageHeight = usefulWastageHeight;
		this.unusefulWastageWidth = unusefulWastageWidth;
		this.unusefulWastageHeight = unusefulWastageHeight;
		this.usefulShowroomWastageWidth = usefulShowroomWastageWidth;
		this.usefulShowroomWastageHeight = usefulShowroomWastageHeight;
		this.windowState = windowState;
	}



	
	public WindowResultFromDB(int oprationId, int id, int windowPeiceWastage, int windowWidth, int windowHeight,
			int windowWastageWidth, int windowWastageHeight, int windowPeice, int windowRollWidth, int windowRollHeight,
			int usefulWastageWidth, int usefulWastageHeight, int unusefulWastageWidth, int unusefulWastageHeight,
			int usefulShowroomWastageWidth, int usefulShowroomWastageHeight, String windowState,boolean donationState) {
		super();
		this.oprationId = oprationId;
		this.id = id;
		this.windowPeiceWastage = windowPeiceWastage;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.windowWastageWidth = windowWastageWidth;
		this.windowWastageHeight = windowWastageHeight;
		this.windowPeice = windowPeice;
		this.windowRollWidth = windowRollWidth;
		this.windowRollHeight = windowRollHeight;
		this.usefulWastageWidth = usefulWastageWidth;
		this.usefulWastageHeight = usefulWastageHeight;
		this.unusefulWastageWidth = unusefulWastageWidth;
		this.unusefulWastageHeight = unusefulWastageHeight;
		this.usefulShowroomWastageWidth = usefulShowroomWastageWidth;
		this.usefulShowroomWastageHeight = usefulShowroomWastageHeight;
		this.windowState = windowState;
		this.donationState = donationState;
	}



	public boolean isDonationState() {
		return donationState;
	}



	public void setDonationState(boolean donationState) {
		this.donationState = donationState;
	}

	
	public int getWindowPeiceWastage() {
		return windowPeiceWastage;
	}



	public void setWindowPeiceWastage(int windowPeiceWastage) {
		this.windowPeiceWastage = windowPeiceWastage;
	}



	public int getOprationId() {
		return oprationId;
	}



	public void setOprationId(int oprationId) {
		this.oprationId = oprationId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWindowWidth() {
		return windowWidth;
	}
	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}
	public int getWindowHeight() {
		return windowHeight;
	}
	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}
	public int getWindowWastageWidth() {
		return windowWastageWidth;
	}
	public void setWindowWastageWidth(int windowWastageWidth) {
		this.windowWastageWidth = windowWastageWidth;
	}
	public int getWindowWastageHeight() {
		return windowWastageHeight;
	}
	public void setWindowWastageHeight(int windowWastageHeight) {
		this.windowWastageHeight = windowWastageHeight;
	}
	public int getWindowPeice() {
		return windowPeice;
	}
	public void setWindowPeice(int windowPeice) {
		this.windowPeice = windowPeice;
	}
	public String getWindowState() {
		return windowState;
	}
	public void setWindowState(String windowState) {
		this.windowState = windowState;
	}
	public int getWindowRollWidth() {
		return windowRollWidth;
	}


	public void setWindowRollWidth(int windowRollWidth) {
		this.windowRollWidth = windowRollWidth;
	}


	public int getWindowRollHeight() {
		return windowRollHeight;
	}


	public void setWindowRollHeight(int windowRollHeight) {
		this.windowRollHeight = windowRollHeight;
	}


	public int getUsefulWastageWidth() {
		return usefulWastageWidth;
	}


	public void setUsefulWastageWidth(int usefulWastageWidth) {
		this.usefulWastageWidth = usefulWastageWidth;
	}


	public int getUsefulWastageHeight() {
		return usefulWastageHeight;
	}


	public void setUsefulWastageHeight(int usefulWastageHeight) {
		this.usefulWastageHeight = usefulWastageHeight;
	}


	public int getUnusefulWastageWidth() {
		return unusefulWastageWidth;
	}


	public void setUnusefulWastageWidth(int unusefulWastageWidth) {
		this.unusefulWastageWidth = unusefulWastageWidth;
	}


	public int getUnusefulWastageHeight() {
		return unusefulWastageHeight;
	}


	public void setUnusefulWastageHeight(int unusefulWastageHeight) {
		this.unusefulWastageHeight = unusefulWastageHeight;
	}


	public int getUsefulShowroomWastageWidth() {
		return usefulShowroomWastageWidth;
	}


	public void setUsefulShowroomWastageWidth(int usefulShowroomWastageWidth) {
		this.usefulShowroomWastageWidth = usefulShowroomWastageWidth;
	}


	public int getUsefulShowroomWastageHeight() {
		return usefulShowroomWastageHeight;
	}


	public void setUsefulShowroomWastageHeight(int usefulShowroomWastageHeight) {
		this.usefulShowroomWastageHeight = usefulShowroomWastageHeight;
	}
	
}
