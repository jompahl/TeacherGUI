package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.*;

import application.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.*;
import model.Course;
import model.Result;
import model.Student;
import model.WrittenExam;
import javafx.scene.control.Button;

public class Maincontroller implements Initializable{
	
	@FXML
	private Button viewStudents;
	@FXML
	private Button viewCourses;
	@FXML
	private Button viewExams;
	
	 // Reference to the main application.
    private Main main;
    
    
	public void setMain(Main main) {
        this.main = main;
    }
	
	
	@FXML
	public void btnCreateStudents(ActionEvent event) {
		Main.setPane(1);
	}
	
	@FXML
	public void btnCreateCourses(ActionEvent event) {
		Main.setPane(2);
	}
	@FXML
	public void btnCreateWrittenExam(ActionEvent event) {
		//WrittenExamController.init();
		Main.setPane(3);
	}
	/*@FXML
	public void btnDeleteStudent(ActionEvent event) {
		Main.setPane(3);
	}*/
	
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		
	}
	

}
