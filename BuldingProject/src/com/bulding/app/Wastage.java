package com.bulding.app;

import java.util.ArrayList;

public class Wastage {
	
	public int id , height,width;
	public ArrayList<Integer> wastageHeight , wastageWidth;
	public String windowState;

	
	public Wastage(int id, int height, int width , ArrayList<Integer> wastageHeight ,  ArrayList<Integer> wastageWidth) {
		super();
		this.id = id;
		this.height = height;
		this.width = width;
		this.wastageHeight = wastageHeight;
		this.wastageWidth = wastageWidth;
	}

	public String getWindowState() {
		return windowState;
	}

	public void setWindowState(String windowState) {
		this.windowState = windowState;
	}
	
	public ArrayList<Integer> getWastageHeight() {
		return wastageHeight;
	}

	public void setWastageHeight(ArrayList<Integer> wastageHeight) {
		this.wastageHeight = wastageHeight;
	}

	public ArrayList<Integer> getWastageWidth() {
		return wastageWidth;
	}

	public void setWastageWidth(ArrayList<Integer> wastageWidth) {
		this.wastageWidth = wastageWidth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	

}
