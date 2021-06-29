package com.bulding.app;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ResultWindows {

	private Label labelWindowNumber, labelRequiredWidthMain, labelTakenRoll, labelWindowWastage, labelRequiredHeight,
			labelRequiredWidth, labelTakenStats, labelTakenHeight, labelTakenWidth, labelWindowWastageHeight,
			labelWindowWastageWidth;
	private TextField fieldWindowNumber, fieldRequiredheight, fieldRequiredWidth, fieldTakenRoll,
			fieldTakenFromRollHeight, fieldTakenFromRollWidth, fieldWindowWastage, fieldWindowWastageHeight,
			fieldWindowWastageWidth, fieldTakenStats;

	public ResultWindows(Label labelWindowNumber, Label labelRequiredWidthMain, Label labelTakenRoll,
			Label labelWindowWastage, Label labelRequiredHeight, Label labelRequiredWidth, Label labelTakenStats,
			Label labelTakenHeight, Label labelTakenWidth, Label labelWindowWastageHeight,
			Label labelWindowWastageWidth, TextField fieldWindowNumber, TextField fieldRequiredheight,
			TextField fieldRequiredWidth, TextField fieldTakenRoll, TextField fieldTakenFromRollHeight,
			TextField fieldTakenFromRollWidth, TextField fieldWindowWastage, TextField fieldWindowWastageHeight,
			TextField fieldWindowWastageWidth, TextField fieldTakenStats) {
		super();
		this.labelWindowNumber = labelWindowNumber;
		this.labelRequiredWidthMain = labelRequiredWidthMain;
		this.labelTakenRoll = labelTakenRoll;
		this.labelWindowWastage = labelWindowWastage;
		this.labelRequiredHeight = labelRequiredHeight;
		this.labelRequiredWidth = labelRequiredWidth;
		this.labelTakenStats = labelTakenStats;

		this.labelTakenHeight = labelTakenHeight;
		this.labelTakenWidth = labelTakenWidth;
		this.labelWindowWastageHeight = labelWindowWastageHeight;
		this.labelWindowWastageWidth = labelWindowWastageWidth;

		this.fieldWindowNumber = fieldWindowNumber;
		fieldWindowNumber.setEditable(false);
		this.fieldRequiredheight = fieldRequiredheight;
		fieldRequiredheight.setEditable(false);
		this.fieldRequiredWidth = fieldRequiredWidth;
		fieldRequiredWidth.setEditable(false);
		this.fieldTakenRoll = fieldTakenRoll;
		fieldTakenRoll.setEditable(false);
		this.fieldTakenFromRollHeight = fieldTakenFromRollHeight;
		fieldTakenFromRollHeight.setEditable(false);
		this.fieldTakenFromRollWidth = fieldTakenFromRollWidth;
		fieldTakenFromRollWidth.setEditable(false);
		this.fieldWindowWastage = fieldWindowWastage;
		fieldWindowWastage.setEditable(false);
		this.fieldWindowWastageHeight = fieldWindowWastageHeight;
		fieldWindowWastageHeight.setEditable(false);
		this.fieldWindowWastageWidth = fieldWindowWastageWidth;
		fieldWindowWastageWidth.setEditable(false);
		this.fieldTakenStats = fieldTakenStats;
		fieldTakenStats.setEditable(false);
	}

	public Label getLabelTakenHeight() {
		return labelTakenHeight;
	}

	public void setLabelTakenHeight(Label labelTakenHeight) {
		this.labelTakenHeight = labelTakenHeight;
	}

	public Label getLabelTakenWidth() {
		return labelTakenWidth;
	}

	public void setLabelTakenWidth(Label labelTakenWidth) {
		this.labelTakenWidth = labelTakenWidth;
	}

	public Label getLabelWindowWastageHeight() {
		return labelWindowWastageHeight;
	}

	public void setLabelWindowWastageHeight(Label labelWindowWastageHeight) {
		this.labelWindowWastageHeight = labelWindowWastageHeight;
	}

	public Label getLabelWindowWastageWidth() {
		return labelWindowWastageWidth;
	}

	public void setLabelWindowWastageWidth(Label labelWindowWastageWidth) {
		this.labelWindowWastageWidth = labelWindowWastageWidth;
	}

	public Label getLabelWindowNumber() {
		return labelWindowNumber;
	}

	public void setLabelWindowNumber(Label labelWindowNumber) {
		this.labelWindowNumber = labelWindowNumber;
	}

	public Label getLabelRequiredWidthMain() {
		return labelRequiredWidthMain;
	}

	public void setLabelRequiredWidthMain(Label labelRequiredWidthMain) {
		this.labelRequiredWidthMain = labelRequiredWidthMain;
	}

	public Label getLabelTakenRoll() {
		return labelTakenRoll;
	}

	public void setLabelTakenRoll(Label labelTakenRoll) {
		this.labelTakenRoll = labelTakenRoll;
	}

	public Label getLabelWindowWastage() {
		return labelWindowWastage;
	}

	public void setLabelWindowWastage(Label labelWindowWastage) {
		this.labelWindowWastage = labelWindowWastage;
	}

	public Label getLabelRequiredHeight() {
		return labelRequiredHeight;
	}

	public void setLabelRequiredHeight(Label labelRequiredHeight) {
		this.labelRequiredHeight = labelRequiredHeight;
	}

	public Label getLabelRequiredWidth() {
		return labelRequiredWidth;
	}

	public void setLabelRequiredWidth(Label labelRequiredWidth) {
		this.labelRequiredWidth = labelRequiredWidth;
	}

	public Label getLabelTakenStats() {
		return labelTakenStats;
	}

	public void setLabelTakenStats(Label labelTakenStats) {
		this.labelTakenStats = labelTakenStats;
	}

	public TextField getFieldWindowNumber() {
		return fieldWindowNumber;
	}

	public void setFieldWindowNumber(TextField fieldWindowNumber) {
		this.fieldWindowNumber = fieldWindowNumber;
	}

	public TextField getFieldRequiredheight() {
		return fieldRequiredheight;
	}

	public void setFieldRequiredheight(TextField fieldRequiredheight) {
		this.fieldRequiredheight = fieldRequiredheight;
	}

	public TextField getFieldRequiredWidth() {
		return fieldRequiredWidth;
	}

	public void setFieldRequiredWidth(TextField fieldRequiredWidth) {
		this.fieldRequiredWidth = fieldRequiredWidth;
	}

	public TextField getFieldTakenRoll() {
		return fieldTakenRoll;
	}

	public void setFieldTakenRoll(TextField fieldTakenRoll) {
		this.fieldTakenRoll = fieldTakenRoll;
	}

	public TextField getFieldTakenFromRollHeight() {
		return fieldTakenFromRollHeight;
	}

	public void setFieldTakenFromRollHeight(TextField fieldTakenFromRollHeight) {
		this.fieldTakenFromRollHeight = fieldTakenFromRollHeight;
	}

	public TextField getFieldTakenFromRollWidth() {
		return fieldTakenFromRollWidth;
	}

	public void setFieldTakenFromRollWidth(TextField fieldTakenFromRollWidth) {
		this.fieldTakenFromRollWidth = fieldTakenFromRollWidth;
	}

	public TextField getFieldWindowWastage() {
		return fieldWindowWastage;
	}

	public void setFieldWindowWastage(TextField fieldWindowWastage) {
		this.fieldWindowWastage = fieldWindowWastage;
	}

	public TextField getFieldWindowWastageHeight() {
		return fieldWindowWastageHeight;
	}

	public void setFieldWindowWastageHeight(TextField fieldWindowWastageHeight) {
		this.fieldWindowWastageHeight = fieldWindowWastageHeight;
	}

	public TextField getFieldWindowWastageWidth() {
		return fieldWindowWastageWidth;
	}

	public void setFieldWindowWastageWidth(TextField fieldWindowWastageWidth) {
		this.fieldWindowWastageWidth = fieldWindowWastageWidth;
	}

	public TextField getFieldTakenStats() {
		return fieldTakenStats;
	}

	public void setFieldTakenStats(TextField fieldTakenStats) {
		this.fieldTakenStats = fieldTakenStats;
	}

}
