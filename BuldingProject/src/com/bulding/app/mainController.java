package com.bulding.app;

import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class mainController implements Initializable {

	/*
	 * here is Main Page Controller ... Main Clculate , the Calculation Have 3
	 * Steps..
	 * 
	 * Step 1 : take input from user (how mini Window :From windowNumber TextField.
	 * and Take (width and Height) for etch window alone .. After that take every
	 * windows to gother in the arryList<Window> : Line : 297
	 * 
	 * Step 2 : After take All information from user ... take the Array and Sort
	 * From the small to big (Width), Line : 258
	 * 
	 * Step 3 : Start Calculate the windws (width and height) how much take from
	 * roll .. and how much Waste,  Line : 347
	 * 
	 * Step 4 : Here start comparison between windows .. Waste The biger and Width the Smaller. Line : 449
	 * 
	 */ 

	// database coniction information
	static final String url1 = "jdbc:mysql://localhost:3306/buldingdatebase?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	String username = "root";
	String pass = "root";

	// this arrayList for take informaion evry window alone
	ArrayList<Window> windowArrayList = new ArrayList<Window>();
	// this arrayList for sort old arrayList(WindowArrayList) from the smaller to
	// the biger
	ArrayList<Wastage> windowArrayListAfterSort = new ArrayList<Wastage>();

	@FXML
	ListView widowsList;

	@FXML
	ListView resultList;

	// ObservableList for add it items in the Window List
	ObservableList<AnchorPane> windowsField = FXCollections.observableArrayList();

	// ObservableList for add if items in the result list
	ObservableList<AnchorPane> windowsResultList = FXCollections.observableArrayList();

	@FXML
	public TextField windowsNumber;
	public TextField customerNameField;
	public TextField customerNumberField;

	public TextField usefulWindowWidthField;
	public TextField usefulWindowHeightField;
	public TextField linearMeterField;
	public TextField squareMeterField;
	public TextField totalWastageWidthField;
	public TextField totalWastageHeightField;
	public TextArea wastageStateArea;

	ToDatabase toDatabase = new ToDatabase();
	FromDatabase fromDatabase = new FromDatabase();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void setWidows(Event e) {

		addItemsToMainWindowList();

	}// end setWindows Method

	public void setResultWindows(Event e) {
		// this method for add component in the result list View and call all the
		// methods for the reuslts
		windowsResultList.clear();
		resultList.getItems().clear();
		wastageStateArea.setText("Windows that benefit from wastage :");
		int windowWidthForCost = 0;
		double usefulWindowWidth = 0;
		double usefulWindowHeight = 0;
		int usefulShowWidth = 0;
		int usefulShowHeight = 0;
		int unusefulWidth = 0;
		int unusefulHeight = 0;
		double linearMeter = 0;
		double squareMeter = 0;
		double totalWastageWidth = 0;
		double totalWastageHeight = 0;
		int multiWidthInHeight = 0;
		resultOfTotalWastage(windowArrayList);

		addWastage();
		comparisonWindow();

		ArrayList<WindowResultFromDB> windowResultAndCostList = fromDatabase.getResultWindowInfoAndCost();

		for (int i = 0; i < windowResultAndCostList.size(); i++) {
			ResultWindows resultWindows = new ResultWindows(new Label("Window Number : "), new Label("Required Meters"),
					new Label("Taken From Roll"), new Label("Window Wastage "), new Label("Height : "),
					new Label("Width : "), new Label(windowResultAndCostList.get(i).getWindowState()),
					new Label("Height : "), new Label("Width : "), new Label("Height : "), new Label("Width : "),
					new TextField(), new TextField(), new TextField(), new TextField(), new TextField(),
					new TextField(), new TextField(), new TextField(), new TextField(), new TextField());

			if (windowResultAndCostList.get(i).getWindowRollWidth() == 0) {
				wastageStateArea
						.setText(wastageStateArea.getText() + "[" + windowResultAndCostList.get(i).getId() + "]");

			}
			AnchorPane anchorPane = new AnchorPane();
			anchorPane.setLeftAnchor(resultWindows.getLabelWindowNumber(), 5.0);
			anchorPane.setTopAnchor(resultWindows.getLabelWindowNumber(), 5.0);

			anchorPane.setLeftAnchor(resultWindows.getFieldWindowNumber(), 105.0);
			anchorPane.setTopAnchor(resultWindows.getFieldWindowNumber(), 2.5);
			resultWindows.getFieldWindowNumber().setMaxSize(50.0, 50.0);
			resultWindows.getFieldWindowNumber().setText(String.valueOf(windowResultAndCostList.get(i).getId()));

			anchorPane.setLeftAnchor(resultWindows.getLabelRequiredWidthMain(), 52.5);
			anchorPane.setTopAnchor(resultWindows.getLabelRequiredWidthMain(), 50.0);

			anchorPane.setLeftAnchor(resultWindows.getLabelRequiredHeight(), 40.0);
			anchorPane.setTopAnchor(resultWindows.getLabelRequiredHeight(), 80.0);

			anchorPane.setLeftAnchor(resultWindows.getFieldRequiredheight(), 15.0);
			anchorPane.setTopAnchor(resultWindows.getFieldRequiredheight(), 100.0);
			resultWindows.getFieldRequiredheight().setMaxSize(100.0, 50.0);
			resultWindows.getFieldRequiredheight()
					.setText(String.valueOf(windowResultAndCostList.get(i).getWindowHeight()));

			anchorPane.setLeftAnchor(resultWindows.getLabelRequiredWidth(), 150.0);
			anchorPane.setTopAnchor(resultWindows.getLabelRequiredWidth(), 80.0);

			anchorPane.setLeftAnchor(resultWindows.getFieldRequiredWidth(), 120.0);
			anchorPane.setTopAnchor(resultWindows.getFieldRequiredWidth(), 100.0);
			resultWindows.getFieldRequiredWidth().setMaxSize(100.0, 50.0);
			resultWindows.getFieldRequiredWidth()
					.setText(String.valueOf(windowResultAndCostList.get(i).getWindowWidth()));
			anchorPane.setLeftAnchor(resultWindows.getLabelTakenRoll(), 52.5);
			anchorPane.setTopAnchor(resultWindows.getLabelTakenRoll(), 140.0);

			anchorPane.setLeftAnchor(resultWindows.getLabelTakenHeight(), 40.0);
			anchorPane.setTopAnchor(resultWindows.getLabelTakenHeight(), 170.0);

			anchorPane.setLeftAnchor(resultWindows.getFieldTakenFromRollHeight(), 15.0);
			anchorPane.setTopAnchor(resultWindows.getFieldTakenFromRollHeight(), 190.0);
			resultWindows.getFieldTakenFromRollHeight().setMaxSize(100.0, 50.0);
			resultWindows.getFieldTakenFromRollHeight()
					.setText(String.valueOf(windowResultAndCostList.get(i).getWindowRollHeight()));

			anchorPane.setLeftAnchor(resultWindows.getLabelTakenWidth(), 150.0);
			anchorPane.setTopAnchor(resultWindows.getLabelTakenWidth(), 170.0);

			anchorPane.setLeftAnchor(resultWindows.getFieldTakenFromRollWidth(), 120.0);
			anchorPane.setTopAnchor(resultWindows.getFieldTakenFromRollWidth(), 190.0);
			resultWindows.getFieldTakenFromRollWidth().setMaxSize(100.0, 50.0);
			resultWindows.getFieldTakenFromRollWidth()
					.setText(String.valueOf(windowResultAndCostList.get(i).getWindowRollWidth()));

			anchorPane.setLeftAnchor(resultWindows.getLabelWindowWastage(), 52.5);
			anchorPane.setTopAnchor(resultWindows.getLabelWindowWastage(), 230.0);

			anchorPane.setLeftAnchor(resultWindows.getLabelWindowWastageHeight(), 40.0);
			anchorPane.setTopAnchor(resultWindows.getLabelWindowWastageHeight(), 260.0);

			anchorPane.setLeftAnchor(resultWindows.getFieldWindowWastageHeight(), 15.0);
			anchorPane.setTopAnchor(resultWindows.getFieldWindowWastageHeight(), 290.0);
			resultWindows.getFieldWindowWastageHeight().setMaxSize(100.0, 50.0);
			resultWindows.getFieldWindowWastageHeight()
					.setText(String.valueOf(windowResultAndCostList.get(i).getWindowWastageHeight()));

			anchorPane.setLeftAnchor(resultWindows.getLabelWindowWastageWidth(), 150.0);
			anchorPane.setTopAnchor(resultWindows.getLabelWindowWastageWidth(), 260.0);

			anchorPane.setLeftAnchor(resultWindows.getFieldWindowWastageWidth(), 120.0);
			anchorPane.setTopAnchor(resultWindows.getFieldWindowWastageWidth(), 290.0);
			resultWindows.getFieldWindowWastageWidth().setMaxSize(100.0, 50.0);
			resultWindows.getFieldWindowWastageWidth()
					.setText(String.valueOf(windowResultAndCostList.get(i).getWindowWastageWidth()));

			anchorPane.setLeftAnchor(resultWindows.getLabelTakenStats(), 50.0);
			anchorPane.setTopAnchor(resultWindows.getLabelTakenStats(), 350.0);
			anchorPane.setBottomAnchor(resultWindows.getLabelTakenStats(), 20.0);

			anchorPane.getChildren().addAll(resultWindows.getLabelWindowNumber(), resultWindows.getFieldWindowNumber(),
					resultWindows.getLabelRequiredWidthMain(), resultWindows.getLabelRequiredHeight(),
					resultWindows.getFieldRequiredheight(), resultWindows.getLabelRequiredWidth(),
					resultWindows.getFieldRequiredWidth(), resultWindows.getLabelTakenRoll(),
					resultWindows.getLabelTakenHeight(), resultWindows.getFieldTakenFromRollHeight(),
					resultWindows.getFieldTakenFromRollWidth(), resultWindows.getLabelTakenWidth(),
					resultWindows.getLabelWindowWastage(), resultWindows.getLabelWindowWastageHeight(),
					resultWindows.getFieldWindowWastageHeight(), resultWindows.getLabelWindowWastageWidth(),
					resultWindows.getFieldWindowWastageWidth(), resultWindows.getLabelTakenStats());

			windowsResultList.add(anchorPane);

			usefulWindowWidth = usefulWindowWidth + windowResultAndCostList.get(i).getUsefulWastageWidth();
			usefulWindowHeight = usefulWindowHeight + windowResultAndCostList.get(i).getUsefulWastageHeight();

			usefulShowWidth = usefulShowWidth + windowResultAndCostList.get(i).getUsefulShowroomWastageWidth();
			usefulShowHeight = usefulShowHeight + windowResultAndCostList.get(i).getUsefulShowroomWastageHeight();

			unusefulWidth = unusefulWidth + windowResultAndCostList.get(i).getUnusefulWastageWidth();
			unusefulHeight = unusefulHeight + windowResultAndCostList.get(i).getUnusefulWastageHeight();

			linearMeter = linearMeter + (windowResultAndCostList.get(i).getWindowRollHeight()
					* windowResultAndCostList.get(i).getWindowPeice());

			windowWidthForCost = windowResultAndCostList.get(i).getWindowHeight()
					* windowResultAndCostList.get(i).getWindowWidth();
			multiWidthInHeight = multiWidthInHeight + windowWidthForCost;
			squareMeter = multiWidthInHeight / 10000;

			totalWastageWidth = usefulWindowWidth + usefulShowWidth + unusefulWidth;
			totalWastageHeight = usefulWindowHeight + usefulShowHeight + unusefulHeight;
		} // end For to add Items in Result List

		for (AnchorPane a : windowsResultList) {
			resultList.getItems().add(a);

		} // end for Add item in WindowsList

		usefulWindowWidthField.setText(String.valueOf(usefulWindowWidth / 100));
		usefulWindowHeightField.setText(String.valueOf(usefulWindowHeight / 100));
		linearMeterField.setText(String.valueOf(linearMeter / 100));
		squareMeterField.setText(String.valueOf(squareMeter));
		totalWastageWidthField.setText(String.valueOf(totalWastageWidth / 100));
		totalWastageHeightField.setText(String.valueOf(totalWastageHeight / 100));

	}// end setResultWindows Method

	public void resultOfTotalWastage(ArrayList<Window> windowArrayList) {
		/*
		 * Here Step : 2
		 */
		try {
			windowArrayListAfterSort.clear();

			ArrayList<Wastage> windowFilterList = new ArrayList<Wastage>();
			ArrayList<Integer> wastageHeight = new ArrayList<Integer>();
			ArrayList<Integer> wastageWidth = new ArrayList<Integer>();
			for (int i = 0; i < windowArrayList.size(); i++) {

				Wastage windowFilter = new Wastage(windowArrayList.get(i).getId(),
						Integer.valueOf(windowArrayList.get(i).getHeight().getText()),
						Integer.valueOf(windowArrayList.get(i).getWidth().getText()), wastageHeight, wastageWidth);
				windowFilterList.add(windowFilter);
			}
			windowFilterList.sort(Comparator.comparing(report -> {
				try {
					return (Comparable) report.getClass().getDeclaredField("width").get(report);
				} catch (Exception e) {
					throw new RuntimeException("Ooops", e);
				}
			})); // sort the ArryList Of Wastage

			for (int y = windowFilterList.size() - 1; y >= 0; y--) {
				windowArrayListAfterSort.add(windowFilterList.get(y));
			} // revers the sort from the big to the small

		} catch (Exception e) {
//			fromDatabase.showWarning(e.getMessage(), "ERROR MESSAGE");
			e.getMessage();

		}
	}// end resultOfTotalWastage Method

	public void addItemsToMainWindowList() {

		/*
		 * Here Step 1
		 */
		try {
			int numberOfWindows = Integer.valueOf(windowsNumber.getText());
			widowsList.getItems().clear();
			windowsField.clear();
			windowArrayList.clear();
			for (int i = 0; i < numberOfWindows; i++) {
				Window window = new Window(new Label("Height : "), new Label("Width : "),
						new Label("Window Number : " + String.valueOf(i + 1)), new TextField(), new TextField(),
						(i + 1));

				AnchorPane anchorPane = new AnchorPane();

				anchorPane.setLeftAnchor(window.getLaHeight(), 100.0);
				anchorPane.setTopAnchor(window.getLaHeight(), 50.0);

				anchorPane.setLeftAnchor(window.getHeight(), 150.0);
				anchorPane.setTopAnchor(window.getHeight(), 50.0);

				anchorPane.setLeftAnchor(window.getLaWidth(), 100.0);
				anchorPane.setTopAnchor(window.getLaWidth(), 80.0);

				anchorPane.setLeftAnchor(window.getWidth(), 150.0);
				anchorPane.setTopAnchor(window.getWidth(), 80.0);
				anchorPane.setBottomAnchor(window.getWidth(), 20.0);

				anchorPane.setLeftAnchor(window.getLaId(), 5.0);
				anchorPane.setTopAnchor(window.getLaId(), 5.0);

				anchorPane.getChildren().addAll(window.getLaHeight(), window.getHeight(), window.getLaId(),
						window.getLaWidth(), window.getWidth());

				windowArrayList.add(window);
				windowsField.add(anchorPane);
			} // end For to Add Component in Item in the Windows List

			for (AnchorPane a : windowsField) {
				widowsList.getItems().add(a);

			} // end for Add item in WindowsList

		} catch (RuntimeException error) {
//			fromDatabase.showWarning(error.getMessage(), "ERROR MESSAGE");
			error.getMessage();
		}
	}// end Method

	public void addWastage() {
		/*
		 * This method Step 3 in the Clculation .. for calculation the window how much
		 * take from the roll and the width Roll is (152cm ) and height(30 Meters)
		 * Clculate how much take cm from the roll width and height
		 *
		 */
		try {

			for (int i = 0; i < windowArrayListAfterSort.size(); i++) {
				int totalOfPis = 0;
				int sumOfHfiftyTo = 0; // this variable for take how mini 152 window width is take
				int sumOperation = 0;
				int totalWidth = 0;
				int divTotalWidthSumOfHfiftyTO = 0;
				int totalOfWastage = 0;

				windowArrayListAfterSort.get(i).getWastageWidth().clear();
				windowArrayListAfterSort.get(i).getWastageHeight().clear();
				if (windowArrayListAfterSort.get(i).getWidth() < 152
						&& windowArrayListAfterSort.get(i).getHeight() < 152
						|| windowArrayListAfterSort.get(i).getWidth() < 152
								&& windowArrayListAfterSort.get(i).getHeight() > 152) {

					windowArrayListAfterSort.get(i).getWastageWidth()
							.add((152 - windowArrayListAfterSort.get(i).getWidth()));

					windowArrayListAfterSort.get(i).getWastageHeight().add(windowArrayListAfterSort.get(i).getHeight());

					windowArrayListAfterSort.get(i)
							.setWindowState("-- The window will be installed in one piece and it Have waste :"
									+ (152 - windowArrayListAfterSort.get(i).getWidth()) + " --");

					toDatabase.insertWindowsTable(windowArrayListAfterSort.get(i).getId(),
							windowArrayListAfterSort.get(i).getHeight(), windowArrayListAfterSort.get(i).getWidth(),
							(152 - windowArrayListAfterSort.get(i).getWidth()),
							windowArrayListAfterSort.get(i).getHeight(),
							windowArrayListAfterSort.get(i).getWindowState(), 1);

				} else if (windowArrayListAfterSort.get(i).getWidth() > 152
						&& windowArrayListAfterSort.get(i).getHeight() < 152) {

					windowArrayListAfterSort.get(i).getWastageWidth()
							.add((152 - windowArrayListAfterSort.get(i).getHeight()));
					windowArrayListAfterSort.get(i).getWastageHeight().add(windowArrayListAfterSort.get(i).getWidth());
					windowArrayListAfterSort.get(i).setWindowState("-- The window will be installed in reverse --");

					toDatabase.insertWindowsTable(windowArrayListAfterSort.get(i).getId(),
							windowArrayListAfterSort.get(i).getWidth(), windowArrayListAfterSort.get(i).getHeight(),
							(152 - windowArrayListAfterSort.get(i).getHeight()),
							windowArrayListAfterSort.get(i).getWidth(),
							windowArrayListAfterSort.get(i).getWindowState(), 1);

				} else if (windowArrayListAfterSort.get(i).getWidth() > 152
						&& windowArrayListAfterSort.get(i).getHeight() > 152) {

					for (int j = 0; sumOfHfiftyTo <= windowArrayListAfterSort.get(i).getWidth(); j++) {
						sumOfHfiftyTo = sumOfHfiftyTo + 152;
						sumOperation = j + 1;

					}

					totalWidth = sumOfHfiftyTo - windowArrayListAfterSort.get(i).getWidth();
					divTotalWidthSumOfHfiftyTO = totalWidth / sumOperation;
					totalOfPis = 152 - divTotalWidthSumOfHfiftyTO;

					totalOfWastage = 152 - totalOfPis;

					windowArrayListAfterSort.get(i).getWastageWidth().add(totalOfWastage);
					windowArrayListAfterSort.get(i).getWastageHeight().add(windowArrayListAfterSort.get(i).getHeight());
					windowArrayListAfterSort.get(i).setWindowState(
							"-- The window will be installed on more than one piece and the number of pieces is : "
									+ sumOperation + " --");

					toDatabase.insertWindowsTable(windowArrayListAfterSort.get(i).getId(),
							windowArrayListAfterSort.get(i).getHeight(), windowArrayListAfterSort.get(i).getWidth(),
							totalOfWastage, windowArrayListAfterSort.get(i).getHeight(),
							windowArrayListAfterSort.get(i).getWindowState(), sumOperation);

				} else {

					windowArrayListAfterSort.get(i).getWastageWidth().add(0);
					windowArrayListAfterSort.get(i).getWastageHeight().add(0);
					windowArrayListAfterSort.get(i)
							.setWindowState("-- The window will be installed without any waste --");

					toDatabase.insertWindowsTable(windowArrayListAfterSort.get(i).getId(),
							windowArrayListAfterSort.get(i).getHeight(), windowArrayListAfterSort.get(i).getWidth(),
							totalOfWastage, 0, windowArrayListAfterSort.get(i).getWindowState(), 1);

				}

			} // end the main For

		} catch (Exception e) {
//			fromDatabase.showWarning(e.getMessage(), "ERROR MESSAGE");
			e.getMessage();
		}

	}// end Method

	public void comparisonWindow() {
		/*
		 * this method Step 4 ...
		 * 
		 * 
		 * 
		 */
		try {
			ArrayList<WindowResultFromDB> windowResultListDB = fromDatabase.getWindowInfo();

			int idForOperation = fromDatabase.getOprationId() + 1;

			// i is the small width
			for (int i = windowResultListDB.size() - 1; i >= 0; i--) {

				int wastageSuptractFromWindowWidth = 0;
				int wastageSuptractFromHeight = 0;
				String newState = " ";
				int usefulShowroomWastageWidth = 0;
				int usefulShowroomWastageHeight = 0;
				int windowWastageWidthForNewPeice = 0;
				int windowWastageHeightForNewPeice = 0;
				String stateFatherWindow = " ";
				int windowPeiceTakeWastage = 0;
				int wastagePieceUpdate = 0;
				// y is the big width
				for (int y = 0; y < windowResultListDB.size(); y++) {

					if (windowResultListDB.get(i).getId() != windowResultListDB.get(y).getId()) {

						windowPeiceTakeWastage = windowResultListDB.get(y).getWindowPeiceWastage();
						// if the width <= wastage Width , and hight <= wastage Height and the samll not
						// give any one any thing
						if (windowResultListDB.get(i).getWindowWidth() <= windowResultListDB.get(y)
								.getWindowWastageWidth()
								&& windowResultListDB.get(i).getWindowHeight() <= windowResultListDB.get(y)
										.getWindowWastageHeight()
								&& windowResultListDB.get(i).isDonationState() == false) {

							if (windowResultListDB.get(y).getWindowWastageWidth() > windowResultListDB.get(i)
									.getWindowWidth()) {
								wastageSuptractFromWindowWidth = windowResultListDB.get(y).getWindowWastageWidth()
										- windowResultListDB.get(i).getWindowWidth();
								wastageSuptractFromHeight = windowResultListDB.get(y).getWindowWastageHeight()
										- windowResultListDB.get(i).getWindowHeight();

							}

							newState = "-- The window will be installed from the waste of window No. :"
									+ windowResultListDB.get(y).getId() + " --";

							windowResultListDB.get(i).setWindowWastageWidth(0);
							windowResultListDB.get(i).setWindowWastageHeight(0);
							windowResultListDB.get(i).setWindowState(newState);
							windowResultListDB.get(i).setWindowRollWidth(0);
							windowResultListDB.get(i).setWindowRollHeight(0);
							windowResultListDB.get(i).setWindowPeice(1);
							windowResultListDB.get(i).setUsefulWastageWidth(windowResultListDB.get(i).getWindowWidth());
							windowResultListDB.get(i)
									.setUsefulWastageHeight(windowResultListDB.get(i).getWindowHeight());
							windowResultListDB.get(i).setUnusefulWastageWidth(0);
							windowResultListDB.get(i).setUnusefulWastageHeight(0);
							windowResultListDB.get(i).setUsefulShowroomWastageWidth(0);
							windowResultListDB.get(i).setUsefulShowroomWastageHeight(0);

							stateFatherWindow = "And the Children is : " + windowResultListDB.get(i).getId();
							windowResultListDB.get(y).setWindowState(
									windowResultListDB.get(y).getWindowState() + " " + stateFatherWindow);
							windowResultListDB.get(y).setWindowWastageWidth(wastageSuptractFromWindowWidth);
							windowResultListDB.get(y).setWindowWastageHeight(wastageSuptractFromHeight);
							windowResultListDB.get(y).setDonationState(true);
							break;

						} else if (windowResultListDB.get(i).getWindowWidth() <= windowResultListDB.get(y)
								.getWindowWastageHeight()
								&& windowResultListDB.get(i).getWindowHeight() <= windowResultListDB.get(y)
										.getWindowWastageWidth()
								&& windowResultListDB.get(i).isDonationState() == false) {

							if (windowResultListDB.get(y).getWindowWastageHeight() > windowResultListDB.get(i)
									.getWindowWidth()) {
								wastageSuptractFromWindowWidth = windowResultListDB.get(y).getWindowWastageHeight()
										- windowResultListDB.get(i).getWindowWidth();
								wastageSuptractFromHeight = windowResultListDB.get(y).getWindowWastageWidth()
										- windowResultListDB.get(i).getWindowHeight();

							}

							newState = "-- The window will be installed from the waste of window No. :"
									+ windowResultListDB.get(y).getId() + " and will be installation in reverse --";

							windowResultListDB.get(i).setWindowWastageWidth(0);
							windowResultListDB.get(i).setWindowWastageHeight(0);
							windowResultListDB.get(i).setWindowState(newState);
							windowResultListDB.get(i).setWindowRollWidth(0);
							windowResultListDB.get(i).setWindowRollHeight(0);
							windowResultListDB.get(i).setWindowPeice(1);
							windowResultListDB.get(i).setUsefulWastageWidth(windowResultListDB.get(i).getWindowWidth());
							windowResultListDB.get(i)
									.setUsefulWastageHeight(windowResultListDB.get(i).getWindowHeight());
							windowResultListDB.get(i).setUnusefulWastageWidth(0);
							windowResultListDB.get(i).setUnusefulWastageHeight(0);
							windowResultListDB.get(i).setUsefulShowroomWastageWidth(0);
							windowResultListDB.get(i).setUsefulShowroomWastageHeight(0);
							windowResultListDB.get(i).setDonationState(true);

							stateFatherWindow = "And the Children is : " + windowResultListDB.get(i).getId();
							windowResultListDB.get(y).setWindowState(
									windowResultListDB.get(y).getWindowState() + " " + stateFatherWindow);

							windowResultListDB.get(y).setWindowWastageWidth(wastageSuptractFromWindowWidth);
							windowResultListDB.get(y).setWindowWastageHeight(wastageSuptractFromHeight);
							windowResultListDB.get(y).setDonationState(true);

							break;

						} else {

							if (windowResultListDB.get(i).getWindowWastageWidth() >= 40
									&& windowResultListDB.get(i).getWindowWastageHeight() >= 70
									|| windowResultListDB.get(i).getWindowWastageWidth() >= 70
											&& windowResultListDB.get(i).getWindowWastageHeight() >= 40) {
								wastageSuptractFromWindowWidth = 0;
								wastageSuptractFromHeight = 0;

								usefulShowroomWastageWidth = windowResultListDB.get(i).getWindowWastageWidth();
								usefulShowroomWastageHeight = windowResultListDB.get(i).getWindowWastageHeight();

							} else {
								wastageSuptractFromWindowWidth = windowResultListDB.get(i).getWindowWastageWidth();
								wastageSuptractFromHeight = windowResultListDB.get(i).getWindowWastageHeight();
							}

							windowResultListDB.get(i)
									.setWindowRollWidth((152 * windowResultListDB.get(i).getWindowPeice()));
							windowResultListDB.get(i).setWindowRollHeight(windowResultListDB.get(i).getWindowHeight());
							windowResultListDB.get(i).setUsefulWastageWidth(0);
							windowResultListDB.get(i).setUsefulWastageHeight(0);
							windowResultListDB.get(i).setUnusefulWastageWidth(wastageSuptractFromWindowWidth);
							windowResultListDB.get(i).setUnusefulWastageHeight(wastageSuptractFromHeight);
							windowResultListDB.get(i).setUsefulShowroomWastageWidth(usefulShowroomWastageWidth);
							windowResultListDB.get(i).setUsefulShowroomWastageHeight(usefulShowroomWastageHeight);

						} // end if statment to check index not =

					} else {

						if (windowResultListDB.get(i).getWindowWastageWidth() >= 40
								&& windowResultListDB.get(i).getWindowWastageHeight() >= 70
								|| windowResultListDB.get(i).getWindowWastageWidth() >= 70
										&& windowResultListDB.get(i).getWindowWastageHeight() >= 40) {
							wastageSuptractFromWindowWidth = 0;
							wastageSuptractFromHeight = 0;

							usefulShowroomWastageWidth = windowResultListDB.get(i).getWindowWastageWidth();
							usefulShowroomWastageHeight = windowResultListDB.get(i).getWindowWastageHeight();

						} else {
							wastageSuptractFromWindowWidth = windowResultListDB.get(i).getWindowWastageWidth();
							wastageSuptractFromHeight = windowResultListDB.get(i).getWindowWastageHeight();
						}

						windowResultListDB.get(i)
								.setWindowRollWidth((152 * windowResultListDB.get(i).getWindowPeice()));
						windowResultListDB.get(i).setWindowRollHeight(windowResultListDB.get(i).getWindowHeight());
						windowResultListDB.get(i).setUsefulWastageWidth(0);
						windowResultListDB.get(i).setUsefulWastageHeight(0);
						windowResultListDB.get(i).setUnusefulWastageWidth(wastageSuptractFromWindowWidth);
						windowResultListDB.get(i).setUnusefulWastageHeight(wastageSuptractFromHeight);
						windowResultListDB.get(i).setUsefulShowroomWastageWidth(usefulShowroomWastageWidth);
						windowResultListDB.get(i).setUsefulShowroomWastageHeight(usefulShowroomWastageHeight);

					}

				} // end secound for take first item

				toDatabase.insertWindowResultTable(idForOperation, windowResultListDB.get(i).getId(),
						windowResultListDB.get(i).getWindowWidth(), windowResultListDB.get(i).getWindowHeight(),
						windowResultListDB.get(i).getWindowWastageWidth(),
						windowResultListDB.get(i).getWindowWastageHeight(), windowResultListDB.get(i).getWindowState(),
						windowResultListDB.get(i).getWindowRollWidth(), windowResultListDB.get(i).getWindowRollHeight(),
						windowResultListDB.get(i).getWindowPeice(), windowResultListDB.get(i).getUsefulWastageWidth(),
						windowResultListDB.get(i).getUsefulWastageHeight(),
						windowResultListDB.get(i).getUnusefulWastageWidth(),
						windowResultListDB.get(i).getUnusefulWastageHeight(),
						windowResultListDB.get(i).getUsefulShowroomWastageWidth(),
						windowResultListDB.get(i).getUsefulShowroomWastageHeight(),
						windowResultListDB.get(i).isDonationState(), windowResultListDB.get(i).getWindowPeiceWastage(),
						customerNameField.getText(), customerNumberField.getText());

			} // end for take Last Item

			fromDatabase.deleteFromWindowResultTabel();
		} catch (Exception e) {
			e.getMessage();
		}

	}// end method

	public void callReport() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url1, username, pass);

			String sql = "SELECT * FROM `windowsresult` WHERE id = (SELECT `id` FROM `windowsresult` ORDER BY id DESC LIMIT 1)";
			JasperDesign jsp = JRXmlLoader.load("C:\\Program Files\\buldingApplication\\ResultReport.jrxml");

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
	}// end method

}// end class
