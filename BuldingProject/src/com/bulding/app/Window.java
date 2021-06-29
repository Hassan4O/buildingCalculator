package com.bulding.app;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Window {

	 Label laHeight, laWidth, laId;
	 TextField height, width;
	 int id;

	public Window(Label laHeight, Label laWidth, Label laId, TextField height, TextField width , int id) {
		super();
		this.laHeight = laHeight;
		this.laWidth = laWidth;
		this.height = height;
		this.width = width;
		this.laId = laId;
		this.id = id; 
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Label getLaId() {
		return laId;
	}

	public void setLaId(Label laId) {
		this.laId = laId;
	}

	public Label getLaHeight() {
		return laHeight;
	}

	public void setLaHeight(Label laHeight) {
		this.laHeight = laHeight;
	}

	public Label getLaWidth() {
		return laWidth;
	}

	public void setLaWidth(Label laWidth) {
		this.laWidth = laWidth;
	}

	public TextField getHeight() {
		return height;
	}

	public void setHeight(TextField height) {
		this.height = height;
	}

	public TextField getWidth() {
		return width;
	}

	public void setWidth(TextField width) {
		this.width = width;
	}


}
