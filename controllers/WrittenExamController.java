package controllers;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import java.time.LocalDate;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WrittenExamController implements Initializable {

    @FXML
    private ComboBox<String> courseBox = new ComboBox<>();
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField locationTextField;
    @FXML
    private Spinner<String> timeSpinnerHour = new Spinner<>();
    @FXML
    private Spinner<String> timeSpinnerMinutes = new Spinner<>();
    @FXML
    private TableView<WrittenExam> writtenExamTableView;
    @FXML
    private TableColumn writtenExamID;
    @FXML
    private TableColumn writtenExamLocation;
    @FXML
    private TableColumn writtenExamCourse;
    @FXML
    private TableColumn writtenExamDate;
    @FXML
    private TableColumn writtenExamTime;
    @FXML
    private Label lblResponse;

    private WrittenExamRegister writtenExamRegister = new WrittenExamRegister();

    private ObservableList<WrittenExam> writtenExamTable = FXCollections.observableArrayList();

    private CourseRegister courseRegister = new CourseRegister();

    //private ObservableList<String> hours = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        //Populates combobox with created courses
        courseBox.setItems(CourseController.getCourseNamesAndCodes());

        //Populates spinner with hours and minutes
        ObservableList<String> hours = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","00");
        ObservableList<String> minutes = FXCollections.observableArrayList("00","05","10","15","20","25","30","35","40","45","50","55","60");
        SpinnerValueFactory<String> hourPicker = new SpinnerValueFactory.ListSpinnerValueFactory<String>(hours);
        SpinnerValueFactory<String> minutesPicker = new SpinnerValueFactory.ListSpinnerValueFactory<String>(minutes);
        hourPicker.setValue("09");
        minutesPicker.setValue("00");
        timeSpinnerHour.setValueFactory(hourPicker);
        timeSpinnerMinutes.setValueFactory(minutesPicker);

        //Creates two written exams and populates the tableview
        WrittenExam writtenExam1 = new WrittenExam("E10000", "RoomA105", LocalDate.now(), "09:00", courseRegister.findCourse("C10000"));
        WrittenExam writtenExam2 = new WrittenExam("E10001", "RoomB167", LocalDate.now(), "13:00", courseRegister.findCourse("C10001"));
        writtenExamTable.add(writtenExam1);
        writtenExamTable.add(writtenExam2);
        writtenExamRegister.add(writtenExam1);
        writtenExamRegister.add(writtenExam2);

        writtenExamID.setCellValueFactory(new PropertyValueFactory("examID"));
        writtenExamLocation.setCellValueFactory(new PropertyValueFactory("location"));
        writtenExamDate.setCellValueFactory(new PropertyValueFactory("date"));
        writtenExamTime.setCellValueFactory(new PropertyValueFactory("time"));
        writtenExamCourse.setCellValueFactory(new PropertyValueFactory("visibleCourse"));

        writtenExamTableView.setItems(writtenExamTable);

    }
    //Creates a new written exam
    public void createWrittenExam(ActionEvent event) {

        if (courseBox.getValue() == null && datePicker.getValue() == null && locationTextField.getText().isEmpty()) {
            lblResponse.setText("Please choose a course\nPlease choose a date\nPlease add a location");
        } else if (courseBox.getValue() == null && datePicker.getValue() == null && !locationTextField.getText().isEmpty()) {
            lblResponse.setText("Please choose a course\nPlease choose a date");
        } else if (courseBox.getValue() == null && datePicker.getValue() != null && !locationTextField.getText().isEmpty()) {
            lblResponse.setText("Please choose a course");
        } else if (courseBox.getValue() != null && datePicker.getValue() == null && !locationTextField.getText().isEmpty()) {
            lblResponse.setText("Please choose a date");
        } else if (courseBox.getValue() == null && datePicker.getValue() != null && locationTextField.getText().isEmpty()) {
            lblResponse.setText("Please choose a course\nPlease add a location");
        } else if (courseBox.getValue() != null && datePicker.getValue() == null && locationTextField.getText().isEmpty()) {
            lblResponse.setText("Please choose a date\nPlease add a location");
        } else if (courseBox.getValue() != null && datePicker.getValue() != null && locationTextField.getText().isEmpty()) {
            lblResponse.setText("Please add a location");
        } else if (courseBox.getValue() != null && datePicker.getValue() != null && !locationTextField.getText().isEmpty()) {
            String writtenExamNumberFull = "E" + writtenExamRegister.getWrittenExamNumberAndAddOne();
            String time = timeSpinnerHour.getValue() + ":" + timeSpinnerMinutes.getValue();
            Course writtenExamCourse = courseRegister.findCourse(courseBox.getValue().substring(courseBox.getValue().length() - 6, courseBox.getValue().length()));
            WrittenExam newWrittenExam = new WrittenExam(writtenExamNumberFull, locationTextField.getText(), datePicker.getValue(), time, writtenExamCourse);
            writtenExamTable.add(newWrittenExam);
            writtenExamRegister.add(newWrittenExam);
        }


    }
    //Updates courseBox with created courses codes and names
    @FXML
    public void addCoursesToCourseBox () {
        courseBox.setItems(CourseController.getCourseNamesAndCodes());
    }

    //Takes the user back to main screen
    @FXML
    public void btnGoBack (ActionEvent event) {
        Main.setPane(0);
    }
}

