package controllers;


import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Student;

public class RemoveStudents { //implements Initializable{

	@FXML
    private TableView<Student> studentTableView;
	@FXML
    private TableColumn<Student, String> studentIDColumn;
	@FXML
    private TableColumn<Student, String> studentNameColumn;
	@FXML
	private Label lblResponse;
	
	private Main main;
	
	// @FXML
	 /*public void initialize(URL location, ResourceBundle resources) {
	        // Initialize the person table with the two columns.
		 
		 ObservableList<Student> data = FXCollections.observableArrayList(new Student("S10001", "John"), new Student("S10002", "Erik"));
		  	studentIDColumn.setCellValueFactory(new PropertyValueFactory("studentID"));
		  	studentNameColumn.setCellValueFactory(new PropertyValueFactory("name"));
		  	
		  	studentTableView.setItems(data);

		  	studentTableView.setEditable(true);
		  	studentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	    }

	    public void changeFirstName(TableColumn.CellEditEvent editCell) {

	 		if(editCell.getNewValue().toString().isEmpty()) {
	 			lblResponse.setText("First name must have characters");
	 			//Student studentSelected2 = studentTableView.getSelectionModel().getSelectedItem();
				System.out.println("hej");
			} else {

				Student studentSelected = studentTableView.getSelectionModel().getSelectedItem();
				studentSelected.setName(editCell.getNewValue().toString());
			}
		}*/


	}
	/* public void setMainApp(Main main) {
	        this.main = main;

	        // Add observable list data to the table
	        studentTableView.setItems(main.getPersonData());
	    }*/

