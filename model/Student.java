package model;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

	// Instance variables
	private StringProperty studentID; //Johnwashere
	private StringProperty firstName;
	private StringProperty lastName;
	private ArrayList<Result> results = new ArrayList<Result>();
	private ArrayList<WrittenExam> exams = new ArrayList<WrittenExam>();
	
	// Constructors
	public Student(String studentID, String firstName, String lastName) {
		this.studentID = new SimpleStringProperty(studentID);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}
	
	// Getters and setters
	public String getStudentID() {
		return studentID.get();
	}
	public void setStudentID(String studentID) {
		this.studentID.set(studentID);
	}
	public StringProperty nameProperty() {
        return firstName;
    }
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(String name) {
		this.firstName.set(name);
	}
	public StringProperty studentIDProperty() {
        return studentID;
    }
	public ArrayList<Result> getResults() {
		return results;
	}
	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}
	public ArrayList<WrittenExam> getExams() {
		return exams;
	}
	public void setExams(ArrayList<WrittenExam> exams) {
		this.exams = exams;
	}
	public String getLastName() {
		return lastName.get();
	}
	public StringProperty lastNameProperty() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	// Methods
	public void addWrittenExam(WrittenExam exam) {
		exams.add(exam);
	}
	public WrittenExam removeWrittenExam(WrittenExam exam) {
		exams.remove(exam);
		return exam;
	}
	public void addResult(Result result) {
		results.add(result);
	}
	public Result removeResult(Result result) {
		results.remove(result);
		return result;
	}
	
}
