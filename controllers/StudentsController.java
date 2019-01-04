package controllers;

import application.Main;
import model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
	
	@FXML
	private Label lblResponse;
	@FXML
	private TextField textFieldForeName;
	@FXML
	private TextField textFieldLastName;
	@FXML
	private TextArea textAreaReturn;

	public TableView<Student> getStudentTableView() {
		return studentTableView;
	}

	@FXML
	private TableView<Student> studentTableView;
	@FXML
	private TableColumn<Student, String> studentIDColumn;
	@FXML
	private TableColumn<Student, String> studentFirstNameColumn;
	@FXML
	private TableColumn<Student, String> studentLastNameColumn;

	private StudentRegister studentRegister = new StudentRegister();
	private ObservableList<Student> data = FXCollections.observableArrayList();
    private DetailedStudentsController detailedStudentsController = new DetailedStudentsController();

	public void initialize(URL location, ResourceBundle resources) {

		//detailedStudentsController = new DetailedStudentsController();

		// Initialize the student table with three columns.
		Student s1 = new Student("S10000", "John", "Dahlberg");
		Student s2 = new Student("S10001", "Erik", "Mannberg");

		studentRegister.addStudent(s1);
		studentRegister.addStudent(s2);
		data.add(s1);
		data.add(s2);


		studentIDColumn.setCellValueFactory(new PropertyValueFactory("StudentID"));
		studentFirstNameColumn.setCellValueFactory(new PropertyValueFactory("FirstName"));
		studentLastNameColumn.setCellValueFactory(new PropertyValueFactory("LastName"));

		studentTableView.setItems(data);

		//Makes table editable
		studentTableView.setEditable(true);
		studentFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		studentLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		//Makes the user be able to select multiple rows
		studentTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		//test
		for (Student student : studentRegister.getStudentRegister()) {
			System.out.println(student.getFirstName() + student.getStudentID());
		}
	}
	
	@FXML
	public void btnGoBack(ActionEvent event) {
		textAreaReturn.setText("");
		Main.setPane(0);
		}
	
	//Creates students and makes them visible in the table view
	@FXML
	public void btnCreateStudent(ActionEvent event) {
		String studentForeName = textFieldForeName.getText();
		String studentLastName = textFieldLastName.getText();
		
		if (studentForeName.isEmpty() && studentLastName.isEmpty()) {
			lblResponse.setText("Please add a fore name and a last name");
		} else if (studentForeName.isEmpty() && !studentLastName.isEmpty()) {
			lblResponse.setText("Please add a fore name");
		} else if (studentLastName.isEmpty() && !studentForeName.isEmpty()) {
			lblResponse.setText("Please add a last name");
		} else if (!studentLastName.isEmpty() && !studentForeName.isEmpty()) {
				String studentNbrFull = "S" + studentRegister.getStudentNumber();
				Student newStudent = new Student(studentNbrFull, studentForeName, studentLastName);
				studentRegister.addStudent(newStudent);
				studentTableView.getItems().add(newStudent);
		
				textAreaReturn.setText("Added \nName: " + studentForeName +" "+ studentLastName + "\nStudent ID: " + studentNbrFull);
				textFieldForeName.setText("");
				textFieldLastName.setText("");
				lblResponse.setText("");
		}
	}
	//Removes students both from the table view and the StudentsRegister class
	@FXML
	public void btnRemoveStudent(ActionEvent event) {
		ObservableList<Student> selectedRows, allStudents;
		allStudents = studentTableView.getItems();

		selectedRows = studentTableView.getSelectionModel().getSelectedItems();

		allStudents.removeAll(selectedRows);

		for (Student tmpStudent : selectedRows) {
			studentRegister.removeStudent(tmpStudent.getStudentID());
		}
	}
	@FXML
	public void btnGoToDetailedStudent(ActionEvent event) {
		textAreaReturn.setText("");
		System.out.println(studentTableView.getSelectionModel().getSelectedItem());
		if (studentTableView.getSelectionModel().getSelectedItem() != null) {
            detailedStudentsController.initData(studentTableView.getSelectionModel().getSelectedItem());
            Main.setPane(4);
        }
	}
}


