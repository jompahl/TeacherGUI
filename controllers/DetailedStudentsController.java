package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailedStudentsController implements Initializable {

    @FXML
    private Label lblStudentID;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;

    private Student selectedStudent;

    //StudentsController controller = new StudentsController();

    public void initialize(URL location, ResourceBundle resources) {
        lblStudentID.setText("hej");
        lblFirstName.setText("John");
        lblLastName.setText("dahlberg");
    }
    public void updatefields(ActionEvent event) {
        //lblStudentID.setText("hej");
    }
    public void initData(Student student) {
        selectedStudent = student;

        lblStudentID.setText(selectedStudent.getStudentID());
        lblFirstName.setText(selectedStudent.getFirstName());
        lblLastName.setText(selectedStudent.getLastName());
    }

    @FXML
    public void btnGoBack(ActionEvent event) {
        Main.setPane(1);
    }

}
