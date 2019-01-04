package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Course;


public class CourseController implements Initializable {
	
	@FXML
	private Label lblResponse;
	@FXML
	private TextField textFieldCourseName;
	@FXML
	private TextField textFieldCredits;
	@FXML
	private TextArea textAreaReturn;
	@FXML
	private TableView<Course> courseTableView;
	@FXML
	private TableColumn<Course, String> courseCodeColumn;
	@FXML
	private TableColumn<Course, String> courseNameColumn;
	@FXML
	private TableColumn<Course, Integer> courseCreditsColumn;
	private WrittenExamController writtenExamController = new WrittenExamController();
	private static ObservableList<Course> courseData = FXCollections.observableArrayList();
	private static ObservableList<String> courseNamesAndCodes = FXCollections.observableArrayList();
	private static CourseRegister courseRegister = new CourseRegister();



	// Initialize the course table with three columns.
	public void initialize(URL location, ResourceBundle resources) {

		//ObservableList<Course> courseData = FXCollections.observableArrayList(); //(new Course("C10000", "IS-Project", 30), new Course("C10001", "Systemanalys course", 15));
		Course course1 = new Course("C10000", "IS-Project", 30);
		Course course2 = new Course("C10001", "Systemanalys", 45);
		courseData.add(course1);
		courseData.add(course2);
		courseNamesAndCodes.add(course1.getName() + " - " + course1.getCourseCode());
		courseNamesAndCodes.add(course2.getName() + " - " + course2.getCourseCode());
		courseRegister.addCourse(course1);
		courseRegister.addCourse(course2);

		WrittenExamController written = new WrittenExamController();
		written.addCoursesToCourseBox();

		courseCodeColumn.setCellValueFactory(new PropertyValueFactory("CourseCode"));
		courseNameColumn.setCellValueFactory(new PropertyValueFactory("Name"));
		courseCreditsColumn.setCellValueFactory(new PropertyValueFactory("Credits"));

		courseTableView.setItems(courseData);

		courseTableView.setEditable(true);
		courseNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		courseTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	@FXML
	public void btnGoBack(ActionEvent event) {
		textFieldCourseName.setText("");
		textFieldCredits.setText("");
		lblResponse.setText("");
		textAreaReturn.setText("");
		Main.setPane(0);
	}
	@FXML
	public void btnCreateCourse(ActionEvent event) {
		String courseName = textFieldCourseName.getText();
		String Stringcredits = textFieldCredits.getText();
		
		if (courseName.isEmpty() && Stringcredits.isEmpty()) {
			lblResponse.setText("Please add a course name and credits");
		} else if (courseName.isEmpty() && !Stringcredits.isEmpty()) {
			lblResponse.setText("Please add a course name");
		} else if (Stringcredits.isEmpty() && !courseName.isEmpty()) {
			lblResponse.setText("Please add credits");
		} else if (!Stringcredits.isEmpty() && !courseName.isEmpty()) {
			try{
				int intCredits = Integer.parseInt(textFieldCredits.getText());
				String courseCodeFull = "C" + courseRegister.setCourseNumber();
				Course newCourse = new Course(courseCodeFull, courseName, intCredits);
				courseRegister.addCourse(newCourse);
				courseData.add(newCourse);
				courseNamesAndCodes.add( newCourse.getName()+ " - " + newCourse.getCourseCode());

				writtenExamController.addCoursesToCourseBox();

				textAreaReturn.setText("Added \nCourse code: " + courseCodeFull + "\nName: " + courseName +"\nCredits: " + intCredits);
				textFieldCourseName.setText("");
				textFieldCredits.setText("");
				lblResponse.setText("");
					
			}catch(NumberFormatException ex) {
				lblResponse.setText("Credits must only contain numbers\nand no decimals");
			}
		}
	}
	@FXML
	public void btnRemoveCourse(ActionEvent event) {
		ObservableList<Course> selectedRows, allCourses;
		allCourses = courseTableView.getItems();

		selectedRows = courseTableView.getSelectionModel().getSelectedItems();

		allCourses.removeAll(selectedRows);

		for (Course tmpCourse : selectedRows) {
			courseRegister.removeCourse(tmpCourse.getCourseCode());
		}
	}

	//getters for ObservableList
	public static ObservableList<String> getCourseNamesAndCodes() {
		return courseNamesAndCodes;
	}
	public static ObservableList<Course> getCourseData() {
		return courseData;
	}
}